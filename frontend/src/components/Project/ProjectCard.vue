<template>
  <div
    class="project-card-wrapper"
    data-bs-toggle="modal"
    :data-bs-target="projectCardItemEdit"
  >
    <img
      class="wrapperImgProjectCarousel"
      src="@/assets/images/하얀색.png"
      alt=""
    />
    <div class="row project-card-header-item">
      <div class="col-2 ">
        <div class="project-card-header-round ">
          {{ projectData.workStyle }}
        </div>
      </div>
      <div class="project-card-title col-10">{{ projectData.title }}</div>
    </div>
    <div class="row project-card-header-item">
      <div class="col-2 ">
        <div class="project-card-header-round" v-if="remainDate != 0">
          D - {{ remainDate }}
        </div>
        <div class="project-card-header-round" v-else>
          D-Day
        </div>
      </div>
      <div class="project-card-title col-10 ">
        {{ projectData.deadline.getFullYear() }} -
        {{ projectData.deadline.getMonth() + 1 }} -
        {{ projectData.deadline.getDate() }} 마감
      </div>
    </div>
    <hr class="project-card-line" />
    <div class="row project-card-devide-row">
      <div class="col-6 project-card-item-round-wrapper ">
        <div class="d-flex justify-content-between project-card-item-round">
          <div class="mx-3">예상비용</div>
          <div class="mx-3">
            월
            <span style="color:blue"
              >{{ projectData.lowPrice }} ~ {{ projectData.highPrice }}</span
            >
          </div>
        </div>
      </div>
      <div class="col-6 project-card-item-round-wrapper ">
        <div class="project-card-item-round d-flex justify-content-between ">
          <div class="mx-3">예상종료기간</div>
          <div class="mx-3">
            {{ projectData.deadline.getFullYear() }}.{{
              projectData.deadline.getMonth() + 1
            }}.{{ projectData.deadline.getDate() }}
          </div>
        </div>
      </div>
    </div>
    <ProjectDetail
      :id="projectCardItem"
      :idEdit="projectCardItem"
      :projectDataReceive="projectData"
      :companyDataReceive="companyData"
    >
    </ProjectDetail>
    <!--<div class="row project-card-devide-row">
      <div class="col-2  ">
        <div class="project-card-category">{{ projectData.category }}</div>
      </div>
      <div class="col-10">
        <div class="project-card-domain">
          {{ projectData.demain }}
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div class="col-2  ">
        <div class="project-card-skill-title">필요기술</div>
      </div>
      <div class="col-10">
        <div class="project-card-skill">
          {{ projectData.skill }}
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div class="project-card-content-wrapper">
        {{ projectData.content }}
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div>
        <img
          src="@/assets/images/People.png"
          style="width:20px;height: 20px; object-fit: cover; padding: 0;"
        />
        <div style="display:inline; margin-left: 10px;">
          모집 {{ projectData.recruitNumber }}명
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div>
        <img
          src="@/assets/images/Apartment.png"
          style="width:20px;height:20px;object-fit:cover"
        />
        <div style="display:inline;margin-left:10px">
          {{ projectData.workstyle }}
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div>
        <img
          src="@/assets/images/Location on.png"
          style="width:20px;height:20px;object-fit:cover"
        />
        <div style="display:inline;margin-left:10px">
          {{ projectData.location }}
        </div>
      </div>
    </div>-->
    <hr />
  </div>
</template>

<script>
import ProjectDetail from "@/components/Project/ProjectDetail.vue";

export default {
  data() {
    return {
      /**임시 데이터 */
      /** 프로젝트 아이디로 데이터 찾기 */
      projectData: {
        id: "1",
        category: "개발",
        projectId: 0,
        domain: "웹사이트",
        locationSi: "성남시",
        locationGu: "분당구",
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
        workStyle: "재택",
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
      },
      projectCardItemEdit: "#",
      remainDate: ""
    };
  },
  mounted() {
    this.remainDate = Math.ceil(
      (this.projectData.deadline.getTime() - new Date().getTime()) /
        (1000 * 60 * 60 * 24) -
        1
    );
    this.projectCardItemEdit += String(this.projectCardItem);
  },
  methods: {
    clickProjectCardInProjectFind() {
      this.$router.push({
        name: "projectDetail",
        params: {
          projectData: this.projectData
        }
      });
    }
  },
  props: {
    //nprojectData: Object
    /** 프로젝트 아이디 */
    projectCardItem: String
  },
  components: {
    ProjectDetail
  }
};
</script>

<style></style>
