<template>
  <div v-if="isDataLoaded">
    <div v-if="projectDataList.length == 0">
      <no-project-view-vue></no-project-view-vue>
    </div>
    <div
      v-else
      class="carousel-wrapper-mine mx-auto mt-4 carouselWrapperMyPageCompanyRecruit"
      id="carouselWrapperMyPageCompanyRecruit"
    >
      <div class="carousel-mine" id="carouselMyPageCompanyRecruit">
        <!-- {{ projectDataList }} -->
        <div v-for="(item, index) of projectDataList" :key="index">
          <!-- {{ item }} -->
          <recruit-card-item-freelancer
            :projectCardItem="item.projectData"
          ></recruit-card-item-freelancer>
        </div>
      </div>
      <apply-project-detail-ing
        v-for="item of projectDataList"
        :key="item.idEdit"
        :id="item.idEdit"
        :projectDataReceive="item.projectData"
        :companyDataReceive="item.companyData"
        :idEdit="`pmc${item.projectData.projectId}`"
        @moveToAfterContract="moveToAfterContract"
      ></apply-project-detail-ing>
      
    </div>
    <button
      v-if="projectDataList.length != 0"
      @click="prevBtnClick"
      style="top: 230px"
      class="prevMyPageCompany"
      type="button"
      data-bs-target="#carouselExampleControlsNoTouching"
      data-bs-slide="prev"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="25"
        height="25"
        fill="black"
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
      v-if="projectDataList.length != 0"
      @click="nextBtnClick"
      style="top: 230px"
      class="nextMyPageCompany"
      type="button"
      data-bs-target="#carouselExampleControlsNoTouching"
      data-bs-slide="next"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="25"
        height="25"
        fill="black"
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
</template>
<script>
import ProjectCard from "../../ProjectCard/ProjectMessageCard.vue";
import ApplyProjectDetailIng from "./ApplyProjectDetailIng.vue";
import { mapGetters } from "vuex";
import * as applyInstance from "@/api/apply.js";
import * as companyInstance from "@/api/company.js";
import recruitCardItemFreelancer from "./recruitCardItemFreelancer.vue";
import NoProjectViewVue from "../../Mypage/NoProjectView.vue";
export default {
  data() {
    return {
      isDataLoaded: false,
      idx: 0,
      projectDataList: [
        // {
        //   projectData: {
        //     id: "1",
        //     category: "개발",
        //     domain: "웹사이트",
        //     locationSi: "성남시",
        //     locationGu: "분당구",
        //     projectId: 0,
        //     skill: ["Java", "Mysql", "SpringBoot"],
        //     title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
        //     content: "AI기반 Firescout 솔루션 ux/ui 디자인",
        //     startDate: new Date("2022-09-10"),
        //     endDate: new Date("2022-09-16"),
        //     startDateSummry: "2022-09-10",
        //     endDateSummry: "2022-09-16",
        //     deadline: new Date("2022-11-30"),
        //     recruitNumber: 3,
        //     task: "1) Native UI/UX 2) 단말 내 시스템 연동 3) API 서버 연동",
        //     workstyle: "재택",
        //     workStartTime: "오전 08:00",
        //     workEndTime: "오후 16:00",
        //     lowPrice: "200만원",
        //     highPrice: "300만원",
        //     careerPeriod: 3
        //   },
        //   /** api 수정 필요 company_id로 company정보를 찾거나 프로젝트 조회에서 company username을 찾거나 */
        //   companyData: {
        //     name: "삼성전자",
        //     ceo: "이재용",
        //     address: "대전시 유성구 덕명동",
        //     call: "042-000-0000"
        //   }
        // }
      ]
    };
  },
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  async mounted() {
    await applyInstance.getApplyStatus(this.loginUserInfo.id, res => {
      for (const projectItem of res.data.applyList) {
        let data = {
          projectData: {},
          companyData: {}
        };
        if (projectItem.state == "인터뷰완료") {
          // console.log(projectItem);
          let projectData = projectItem.project;
          projectData.startDateSummry = projectData.startDate;
          projectData.endDateSummry = projectData.endDate;
          projectData.startDate = new Date(projectData.startDate);
          projectData.endDate = new Date(projectData.endDate);
          projectData.deadline = new Date(projectData.deadline);
          data.state = "인터뷰완료";
          data.projectData = projectItem.project;
          data.idEdit =
            "myPageProjectDetailId" + String(data.projectData.projectId);
          console.log("data");
          console.log(data);
          this.projectDataList.push(data);
          // console.log(this.projectDataList.length);
        }
      }
    });
    console.log(this.projectDataList);
    for (let i = 0; i < this.projectDataList.length; i++) {
      console.log("???");
      await companyInstance.getCompanyInfo(
        this.projectDataList[i].projectData.company.username,
        res => {
          console.log(res);
          const data = {
            id: res.data.companyInfo.company.companyId,
            ceo: res.data.companyInfo.ceo,
            name: res.data.companyInfo.company.name,
            call: res.data.companyInfo.company.phone,
            address: res.data.companyInfo.address
          };
          // console.log("data출력");
          // console.log(data);
          // console.log(data.id);
          this.projectDataList[i].companyData = data;
        }
      );
    }
    console.log(this.projectDataList);
    this.isDataLoaded = true;
  },
  components: {
    ProjectCard,
    ApplyProjectDetailIng,
    recruitCardItemFreelancer,
    NoProjectViewVue
  },
  methods: {
    moveToAfterContract(value) {
      const itemToFind = this.projectDataList.find(function(item) {
        return item.idEdit === "myPageProjectDetailId" + String(value);
      });
      const idxTmp = this.projectDataList.indexOf(itemToFind);
      if (idxTmp > -1) this.projectDataList.splice(idxTmp, 1);
    },

    prevBtnClick() {
      if (this.idx === 0) this.idx = this.projectDataList.length - 1;
      else this.idx--;
      document.querySelector("#carouselMyPageCompanyRecruit").style.transform =
        "translate3d(" + -660 * this.idx + "px, 0, 0)";
    },
    nextBtnClick() {
      if (this.idx === this.projectDataList.length - 1) this.idx = 0;
      else this.idx++;
      document.querySelector("#carouselMyPageCompanyRecruit").style.transform =
        "translate3d(" + -660 * this.idx + "px, 0, 0)";
    }
  }
};
</script>

<style>
.apply-status-no-project-wrapper {
  color: royalblue;
  font-size: 36px;
  text-align: center;
  padding-top: 100px;
}
.undercontract-project-card-btn-wrapper {
  text-align: center;
  padding-top: 400px;
  display: none;
  position: absolute;
  opacity: 1;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: none;
}
.undercontract-project-card-wrapper:hover
  > .undercontract-project-card-btn-wrapper {
  display: block;
}
.undercontract-project-card-see {
  background-color: #3c74c9;
  border: 1px solid #eaf5fb;
  color: white;
}
.undercontract-project-card-accept {
  background-color: #00aba2;
  border: 1px solid #eaf5fb;
  color: white;
}
.undercontract-project-card-refuse {
  background-color: #f3ecec;
  border: 1px solid #eaf5fb;
  color: #696f86;
}
.undercontract-project-card-btn {
  margin: 30px;
  padding: 5px 20px 5px 20px;
  border-radius: 45px;
  opacity: 1;
}
.undercontract-project-card-wrapper {
  position: relative;
}
.undercontract-project-card-wrapper:hover > .undercontract-project-card-hover {
  display: block;
}
.undercontract-project-card-hover {
  text-align: center;
  padding-top: 450px;
  background-color: white;
  display: none;
  position: absolute;
  opacity: 0.7;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>
