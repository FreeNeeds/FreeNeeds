<template>
  <div v-if="isDataLoaded">
    <div v-for="(item, index) of projectDataList" :key="index">
      <div class="apply-project-card-wrapper">
        <project-card
          :projectData="item.projectData"
          :companyData="item.companyData"
        ></project-card>
        <div class="apply-project-card-hover"></div>
        <div class="apply-project-card-btn-wrapper">
          <button
            class="apply-project-card-btn apply-project-card-see"
            data-bs-toggle="modal"
            :data-bs-target="`#pmc${item.projectData.projectId}`"
          >
            상세보기
          </button>
        </div>
      </div>
      <project-detail
        :id="`pmc${item.projectData.projectId}`"
        :projectDataReceive="item.projectData"
        :companyDataReceive="item.companyData"
        :idEdit="`pmc${item.projectData.projectId}`"
      ></project-detail>
    </div>
  </div>
</template>

<script>
import ProjectCard from "../../ProjectCard/ProjectMessageCard.vue";
import * as companyInstance from "@/api/company.js";
import { mapGetters } from "vuex";
import * as applyInstance from "@/api/apply.js";
import ProjectDetail from "../../Project/ProjectDetail.vue";
export default {
  data() {
    return {
      isDataLoaded: false,
      projectCardItemEdit: "#",
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
        if (projectItem.state == "계약완료") {
          // console.log(projectItem);
          let projectData = projectItem.project;
          projectData.startDateSummry = projectData.startDate;
          projectData.endDateSummry = projectData.endDate;
          projectData.startDate = new Date(projectData.startDate);
          projectData.endDate = new Date(projectData.endDate);
          projectData.deadline = new Date(projectData.deadline);
          data.state = "계약완료";
          data.projectData = projectItem.project;
          // console.log("data");
          // console.log(data);
          this.projectDataList.push(data);
          // console.log(this.projectDataList.length);
        }
      }
    });
    // console.log(this.projectDataList);
    for (let i = 0; i < this.projectDataList.length; i++) {
      // console.log("???");
      await companyInstance.getCompanyInfo(
        this.projectDataList[i].projectData.company.username,
        res => {
          // console.log(res);
          const data = {
            ceo: res.data.companyInfo.ceo,
            name: res.data.companyInfo.company.name,
            call: res.data.companyInfo.company.phone,
            address: res.data.companyInfo.address
          };
          this.projectDataList[i].companyData = data;
        }
      );
    }
    // console.log(this.projectDataList);
    this.isDataLoaded = true;
  },
  components: {
    ProjectCard,
    ProjectDetail
  }
};
</script>

<style>
.apply-project-card-btn-wrapper {
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
.apply-project-card-wrapper:hover > .apply-project-card-btn-wrapper {
  display: block;
}
.apply-project-card-see {
  background-color: #3c74c9;
  border: 1px solid #eaf5fb;
  color: white;
}
.apply-project-card-accept {
  background-color: #00aba2;
  border: 1px solid #eaf5fb;
  color: white;
}
.apply-project-card-refuse {
  background-color: #f3ecec;
  border: 1px solid #eaf5fb;
  color: #696f86;
}
.apply-project-card-btn {
  margin: 30px;
  padding: 5px 20px 5px 20px;
  border-radius: 45px;
  opacity: 1;
}
.apply-project-card-wrapper {
  position: relative;
}
.apply-project-card-wrapper:hover > .apply-project-card-hover {
  display: block;
}
.apply-project-card-hover {
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
