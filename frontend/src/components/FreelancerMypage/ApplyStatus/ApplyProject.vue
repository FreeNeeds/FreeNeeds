<template>
  <div>
    <!-- {{ projectDataList }} -->
    <div v-for="(item, index) of projectDataList" :key="index">
      <!-- {{ item }} -->
      <project-card
        :projectData="item.projectData"
        :companyData="item.companyData"
      ></project-card>
    </div>
  </div>
</template>

<script>
import ProjectCard from "../../ProjectCard/ProjectMessageCard.vue";
import { mapGetters } from "vuex";
import * as applyInstance from "@/api/apply.js";
export default {
  data() {
    return {
      projectDataList: [
        {
          projectData: {
            id: "1",
            category: "개발",
            domain: "웹사이트",
            locationSi: "성남시",
            locationGu: "분당구",
            projectId: 0,
            skill: ["Java", "Mysql", "SpringBoot"],
            title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
            content: "AI기반 Firescout 솔루션 ux/ui 디자인",
            startDate: new Date("2022-09-10"),
            endDate: new Date("2022-09-16"),
            startDateSummry: "2022-09-10",
            endDateSummry: "2022-09-16",
            deadline: new Date("2022-11-30"),
            recruitNumber: 3,
            task: "1) Native UI/UX 2) 단말 내 시스템 연동 3) API 서버 연동",
            workstyle: "재택",
            workStartTime: "오전 08:00",
            workEndTime: "오후 16:00",
            lowPrice: "200만원",
            highPrice: "300만원",
            careerPeriod: 3
          },
          /** api 수정 필요 company_id로 company정보를 찾거나 프로젝트 조회에서 company username을 찾거나 */
          companyData: {
            name: "삼성전자",
            ceo: "이재용",
            address: "대전시 유성구 덕명동",
            call: "042-000-0000"
          }
        }
      ]
    };
  },
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  mounted() {
    // applyInstance.getApplyStatus(this.loginUserInfo.username, res => {
    //   for (projectItem in res.data.applyList) {
    //     if (projectItem.project.state == "지원완료") {
    //       this.projectDataList.push(projectItem);
    //     }
    //   }
    // });
  },
  components: {
    ProjectCard
  }
};
</script>

<style></style>
