<template>
  <b-container>
    <div id="banner">
      <img src="../assets/images/banner2.jpg" alt="" width="95%" />
    </div>
    <!--<SearchBar></SearchBar>-->
    <FilterBtn @applyFilter="applyFilter"></FilterBtn>
    <div style="overflow : hidden; width: 1300px; height: 650px">
      <div class="d-flex carouselProjectWrpr">
        <ProjectListWrpr
          v-for="projectList in projectCardMap"
          :key="projectList.id"
          :projectList="projectList.body"
          @clickDetailOpen="clickDetailOpen"
        >
        </ProjectListWrpr>
      </div>
    </div>
    <ProjectDetailShow
      class="checkProjectDetail"
      id="projectDetail"
      :projectDataReceive="projectData"
      :companyDataReceive="companyData"
      :remainDate="remainDate"
      :periodWork="periodWork"
    >
    </ProjectDetailShow>
    <div class="d-flex justify-content-between" style="height : 0px">
    <button
      type="button"
      @click="clickPrevBtnProject"
      style="height : 650px !important; position: relative !important;  left: -3vw !important; top : -670px !important; background-color: #f9f9f9;
    border: 0px;"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="45"
        height="45"
        fill="gray"
        class="bi bi-chevron-left"
        viewBox="0 0 16 16"
      >
        <path
          fill-rule="evenodd"
          d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"
        />
      </svg>
      <span class="visually-hidden">Previous</span>
    </button>
    <button
      type="button"
      @click="clickNextBtnProject"
      style="height : 650px !important; position: relative !important;  left:  3vw !important; top : -670px !important; background-color: #f9f9f9;
    border: 0px;">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="45"
        height="45"
        fill="gray"
        class="bi bi-chevron-right"
        viewBox="0 0 16 16"
      >
        <path
          fill-rule="evenodd"
          d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"
        />
      </svg>
      <span class="visually-hidden">Next</span>
    </button>
    </div>
    <div class="text-center">
      <div
        @click="clickPageOne"
        id="page1"
        class="d-inline-block fw-bold mx-2 activePage pageItem"
      >
        1
      </div>
      <div
        @click="clickPagetwo"
        id="page2"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        2
      </div>
      <div
        @click="clickPagethree"
        id="page3"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        3
      </div>
      <div
        @click="clickPagefour"
        id="page4"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        4
      </div>
      <div
        @click="clickPagefive"
        id="page5"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        5
      </div>
      <div
        @click="clickPagesix"
        id="page6"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        6
      </div>
      <div
        @click="clickPageseven"
        id="page7"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        7
      </div>
      <div
        @click="clickPageeight"
        id="page8"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        8
      </div>
      <div
        @click="clickPagenine"
        id="page9"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        9
      </div>
      <div
        @click="clickPageten"
        id="page10"
        class="d-inline-block fw-bold mx-2 pageItem"
      >
        10
      </div>
    </div>
  </b-container>
</template>

<script>
import SearchBar from "@/components/Project/SearchBar.vue";
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FilterBtn from "@/components/Project/FilterBtn.vue";
import ProjectList from "@/components/Project/ProjectList.vue";
import ProjectListWrpr from "../components/Project/ProjectListWrpr.vue";
import { createInstance } from "../api/index.js";
import ProjectDetail from "../components/Project/ProjectDetail.vue";
import ProjectDetailShow from "../components/Project/ProjectDetailShow.vue";

export default {
  data() {
    return {
      projectCardMap: [],
      projectCardTotal: [],
      idx: 0,
      pageIdx: 0,
      btnIdx: 1,
      filterIdx: -1,
      limitIdx: -1,
      isFilter: false,
      remainDate: 0,
      periodWork: 0,
      projectDetailId: "",
      projectData: {
        id: "",
        category: "",
        demain: "",
        location: "",
        skill: [],
        title: "",
        content: "",
        startDate: "",
        endDate: "",
        startDateSummry: "2022-09-10",
        endDateSummry: "2022-09-16",
        deadline: "",
        recruitNumber: "",
        task: "",
        workstyle: "",
        workStartTime: "",
        workEndTime: "",
        lowPrice: "",
        highPrice: "",
        careerPeriod: ""
      },
      companyData: {}
    };
  },
  mounted() {
    console.log(document.querySelectorAll('.btn-close'))
    for (let item of document.querySelectorAll('.btn-close')) {
      item.addEventListener('click', () => {
        document.querySelector('body').style.overflow = 'scroll'
      })
    }
    createInstance()
      .get("/project", {
        params: {
          page: this.pageIdx,
          size: 60
        }
      })
      .then(res => {
        let cnt = 0;
        let tmp = {
          id: cnt,
          body: []
        };
        for (let i = 0; i < res.data.length; i++) {
          if (tmp.body.length == 6) {
            this.projectCardMap.push(tmp);
            cnt++;
            tmp = {
              id: cnt,
              body: []
            };
          }
          tmp.body.push(res.data[i]);
          res.data[i].detailId = "projectDetail" + res.data[i].projectId;
          this.projectCardTotal.push(res.data[i]);
        }
        this.projectCardMap.push(tmp)
        this.pageIdx++;
      });
  },
  methods: {
    applyFilter(value) {
      let skill = value.skill.join(",");
      let domain = value.form.join(",");
      if (value.category.length === 0) value.category = [""];
      if (value.regionBig.trim() === "전체") value.regionBig = "";
      if (value.regionDetail.trim() === "전체") value.regionDetail = "";
      createInstance()
        .get("/project/filter/", {
          params: {
            techList: skill,
            locationSi: value.regionBig,
            locationGu: value.regionDetail,
            category: value.category[0],
            domain: domain
          }
        })
        .then(res => {
          this.projectCardMap = [];
          this.projectCardTotal = [];
          this.idx = 0;
          this.btnIdx = 1;
          let cnt = 0;
          let tmp = {
            id: cnt,
            body: []
          };
          for (let i = 0; i < res.data.length; i++) {
            if (tmp.body.length == 6) {
              this.projectCardMap.push(tmp);
              cnt++;
              tmp = {
                id: cnt,
                body: []
              };
            }
            tmp.body.push(res.data[i]);
            res.data[i].detailId = "projectDetail" + res.data[i].projectId;
            this.projectCardTotal.push(res.data[i]);
          }
          this.projectCardMap.push(tmp);
          this.isFilter = true;
          if (
            parseInt(this.projectCardTotal / 6) !=
            this.projectCardTotal.length / 6
          ) {
            this.filterIdx = parseInt(this.projectCardTotal.length / 6) + 2;
          } else {
            this.filterIdx = parseInt(this.projectCardTotal.length / 6) + 1;
          }
          this.limitIdx = parseInt(this.projectCardTotal.length / 6);
          document.querySelector(".carouselProjectWrpr").style.transform =
            "translate3d(0, 0, 0)";
          for (let t = 1; t < 11; t++) {
            document.querySelector("#page" + String(t)).innerText = t;
            if (
              document
                .querySelector("#page" + String(t))
                .classList.contains("activePage")
            )
              document
                .querySelector("#page" + String(t))
                .classList.remove("activePage");
            if (
              document
                .querySelector("#page" + String(t))
                .classList.contains("d-none")
            ) {
              document
                .querySelector("#page" + String(t))
                .classList.remove("d-none");
            }
          }
          document.querySelector("#page1").classList.add("activePage");
          for (let t = this.filterIdx; t < 11; t++)
            document.querySelector("#page" + String(t)).classList.add("d-none");
        });
    },

    clickPageOne() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page1").classList.add("activePage");
      this.btnIdx = 1;
      this.idx = parseInt(document.querySelector("#page1").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPagetwo() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page2").classList.add("activePage");
      this.btnIdx = 2;
      this.idx = parseInt(document.querySelector("#page2").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPagethree() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page3").classList.add("activePage");
      this.btnIdx = 3;
      this.idx = parseInt(document.querySelector("#page3").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPagefour() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page4").classList.add("activePage");
      this.btnIdx = 4;
      this.idx = parseInt(document.querySelector("#page4").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPagefive() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page5").classList.add("activePage");
      this.btnIdx = 5;
      this.idx = parseInt(document.querySelector("#page5").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPagesix() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page6").classList.add("activePage");
      this.btnIdx = 6;
      this.idx = parseInt(document.querySelector("#page6").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPageseven() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page7").classList.add("activePage");
      this.btnIdx = 7;
      this.idx = parseInt(document.querySelector("#page7").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPageeight() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page8").classList.add("activePage");
      this.btnIdx = 8;
      this.idx = parseInt(document.querySelector("#page8").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPagenine() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page9").classList.add("activePage");
      this.btnIdx = 9;
      this.idx = parseInt(document.querySelector("#page9").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickPageten() {
      let tmp = document.querySelectorAll(".pageItem");
      for (let i = 0; i < tmp.length; i++) {
        if (tmp[i].classList.contains("activePage"))
          tmp[i].classList.remove("activePage");
      }
      document.querySelector("#page10").classList.add("activePage");
      this.btnIdx = 10;
      this.idx = parseInt(document.querySelector("#page10").innerText) - 1;
      document.querySelector(".carouselProjectWrpr").style.transform =
        "translate3d(" + -1300 * this.idx + "px, 0, 0)";
    },

    clickNextBtnProject() {
      console.log(this.limitIdx);
      console.log(this.idx);
      if (this.limitIdx === -1 || this.idx + 2 < this.filterIdx) {
        document
          .querySelector("#page" + this.btnIdx)
          .classList.remove("activePage");
        this.idx++;
        this.btnIdx++;
        if (this.btnIdx === 11) {
          let btnTmp = document.querySelectorAll(".pageItem");
          for (let i = 0; i < btnTmp.length; i++) {
            btnTmp[i].innerText = parseInt(btnTmp[i].innerText) + 10;
            if (
              this.filterIdx != -1 &&
              parseInt(btnTmp[i].innerText) >= this.filterIdx
            ) {
              btnTmp[i].classList.add("d-none");
            }
          }
          this.btnIdx = 1;
        }
        document
          .querySelector("#page" + this.btnIdx)
          .classList.add("activePage");
        if (this.projectCardMap[this.idx] === undefined && !this.isFilter) {
          createInstance()
            .get("/project", {
              params: {
                page: this.pageIdx,
                size: 60
              }
            })
            .then(res => {
              let cnt = 0;
              let tmp = {
                id: cnt,
                body: []
              };
              for (let i = 0; i < res.data.length; i++) {
                if (tmp.body.length == 6) {
                  this.projectCardMap.push(tmp);
                  cnt++;
                  tmp = {
                    id: cnt,
                    body: []
                  };
                }
                tmp.body.push(res.data[i]);
                res.data[i].detailId =
                  "projectDetail" + res.data[i].projectId;
                this.projectCardTotal.push(res.data[i]);
              }
              this.projectCardMap.push(tmp)
              this.pageIdx++;
            });
        }
        document.querySelector(".carouselProjectWrpr").style.transform =
          "translate3d(" + -1300 * this.idx + "px, 0, 0)";
      }
    },

    clickPrevBtnProject() {
      if (this.idx != 0) {
        document
          .querySelector("#page" + this.btnIdx)
          .classList.remove("activePage");
        this.idx--;
        this.btnIdx--;
        if (this.btnIdx === 0) {
          let btnTmp = document.querySelectorAll(".pageItem");
          for (let i = 0; i < btnTmp.length; i++) {
            if (btnTmp[i].classList.contains("d-none"))
              btnTmp[i].classList.remove("d-none");
            btnTmp[i].innerText = parseInt(btnTmp[i].innerText) - 10;
          }
          this.btnIdx = 10;
        }
        document
          .querySelector("#page" + this.btnIdx)
          .classList.add("activePage");
        document.querySelector(".carouselProjectWrpr").style.transform =
          "translate3d(" + -1300 * this.idx + "px, 0, 0)";
      }
    },

    clickDetailOpen(value) {
      this.projectData = value.projectData;
      this.companyData = value.companyData;
      this.remainDate = value.remainDate;
      this.periodWork = value.periodWork;
    }
  },
  components: {
    SearchBar,
    HeaderNav,
    FooterNav,
    FilterBtn,
    ProjectList,
    ProjectListWrpr,
    ProjectDetail,
    ProjectDetailShow
  }
};
</script>

<style>
#banner {
  width: 100%;

  display: flex;
  align-content: center;
  text-align: center;
  margin: 0 auto;
  padding-top: 20px;
  margin-bottom: 10px;
  margin-left: 30px;
}

.activePage {
  font-size: 22px !important;
  color: blue !important;
}

.pageItem {
  font-size: 20px;
  color: gray;
  transition: all 0.3s ease 0s;
}

.pageItem:hover {
  cursor: pointer;
  font-size: 22px !important;
  color: blue !important;
}

.prevProjectvue {
  position: absolute !important;
  top: 270px !important;
  left: 45px !important;
  height: 600px !important;
  width: 70px !important;
  background-color: #f9f9f9 !important;
}

.nextProjectvue {
  position: absolute !important;
  top: 270px !important;
  right: 45px !important;
  height: 600px !important;
  width: 70px !important;
  background-color: #f9f9f9 !important;
}

.carouselProjectWrpr {
  transform: translate3d(0, 0, 0);
  transition: transform 0.4s;
}
</style>
