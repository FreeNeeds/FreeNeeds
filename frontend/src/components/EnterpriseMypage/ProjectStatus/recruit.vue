<template>
  <div>
    <div class="d-none noProjectImg">
      <no-project-view-vue></no-project-view-vue>
    </div>
    <div
      class="carousel-wrapper-mine carouselWrapperMyPageCompanyRecruit mx-auto mt-4"
      data-bs-touch="false"
      id="recruitCarouselWrapperMyPageCompanyRecruit"
    >
      <div class="carousel-mine" id="carouselMyPageCompanyRecruit">
        <recruitCardItem
          v-for="projectCardItem in myProjectLst"
          :key="projectCardItem.projectIdEdit"
          :projectCardItem="projectCardItem"
          :state="state"
        ></recruitCardItem>
      </div>
      <recruitProjectDetail
        v-for="projectCardItem in myProjectLst"
        :key="projectCardItem.projectId"
        :id="projectCardItem.projectIdEdit"
        :idEdit="projectCardItem.projectIdEdit"
        :projectDataReceive="projectCardItem"
      >
      </recruitProjectDetail>
    </div>
    <button @click="prevBtnClick" class="prevMyPageCompany" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
      <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-left" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
      </svg>
      <span class="visually-hidden">Previous</span>
    </button>
    <button @click="nextBtnClick" class="nextMyPageCompany" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
      <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-right" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
      </svg>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
</template>

<script>
import recruitCardItem from "./recruitCardItem.vue";
import recruitProjectDetail from "./recruitProjectDetail.vue";
import { createInstance } from "@/api/index.js";
import NoProjectViewVue from "../../Mypage/NoProjectView.vue";
export default {
  name: "recruit",
  data() {
    return {
      idx: 0,
      myProjectLst: [],
      state: "recruit"
    };
  },
  mounted() {
    /*for(let i = 0; i < 5; i++) {
        this.myProjectLst.push({
          id : "idMyPageCompanyStatus" + String(i),
          body : this.projectData
        })
      }*/
    createInstance()
      .get(
        "/project/company/" +
          String(this.$store.state.accounts.loginUserInfo.id)
      )
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          let remainDateTmp = Math.ceil(
            (new Date(res.data[i].deadline).getTime() - new Date().getTime()) /
              (1000 * 60 * 60 * 24) -
              1
          );
          if (remainDateTmp >= 0) {
            res.data[i].projectIdEdit =
              "myPageProjectDetailId" + String(res.data[i].projectId);
            res.data[i].skill = [];
            this.myProjectLst.push(res.data[i]);
          }
        }

        if (this.myProjectLst.length === 0) {
          document.querySelector('.noProjectImg').classList.remove('d-none')
          document
            .querySelector("#carouselWrapperMyPageCompanyRecruit")
            .setAttribute("style", "background-color : lightgray");
        }
      });
  },
  methods: {
    prevBtnClick() {
      //wowowowowo
      if (this.idx === 0) this.idx = this.myProjectLst.length - 1;
      else this.idx--;
      document.querySelector("#carouselMyPageCompanyRecruit").style.transform =
        "translate3d(" + -660 * this.idx + "px, 0, 0)";
    },
    nextBtnClick() {
      if (this.idx === this.myProjectLst.length - 1) this.idx = 0;
      else this.idx++;
      document.querySelector("#carouselMyPageCompanyRecruit").style.transform =
        "translate3d(" + -660 * this.idx + "px, 0, 0)";
    }
  },
  components: {
    recruitCardItem,
    recruitProjectDetail,
    NoProjectViewVue
  }
};
</script>

<style>
  .prevMyPageCompany {
    position: relative;
    top : -314px !important;
    left : 90px;
    height : 314px;
    z-index: 2;
    background-color: #f9f9f9;
    border : 0px;
  }

  .nextMyPageCompany {
    position: relative;
    top : -314px !important;
    left : 800px;
    height : 314px;
    z-index: 2;
    background-color: #f9f9f9;
    border : 0px;
  }

.carouselWrapperMyPageCompanyRecruit {
  width: 660px !important;
  height: 320px !important;
  margin-left: 180px !important;
}
</style>
