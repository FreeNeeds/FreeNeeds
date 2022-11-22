<template>
  <div
    @click="clickDetailOpen"
    class="project-card-wrapper"
    style="padding-top : 0px; padding-bottom : 0px"
    data-bs-toggle="modal"
    data-bs-target="#projectDetail"
  >
    <img
      class="wrapperImgProjectCarousel"
      src="@/assets/images/하얀색.png"
      alt=""
      style="width : 1296px"
    />
    <div class="row mb-3 ms-1">
      <div>
        <h4 class="d-inline-block me-1">{{ companyData.name }}</h4>
        <span style="font-size : 14px">
          | {{ projectData.careerPeriod }}년 경력↑ |
          {{ projectData.category }}</span
        >
      </div>
    </div>
    <div class="row project-card-header-item">
      <div class="col-4">
        <div class="project-card-header-round ">
          {{ projectData.workstyle }}
        </div>
      </div>
      <div class="project-card-title col-8">{{ projectData.title }}</div>
    </div>
    <div class="row project-card-header-item">
      <div class="col-4">
        <div class="project-card-header-round" v-if="remainDate > 0">
          D - {{ remainDate }}
        </div>
        <div class="project-card-header-round" v-else-if="remainDate == 0">
          D-Day
        </div>
        <div class="project-card-header-round" v-else>
          마감
        </div>
      </div>
      <div class="project-card-title col-8">
        {{ projectData.deadline.getFullYear() }} -
        {{ projectData.deadline.getMonth() + 1 }} -
        {{ projectData.deadline.getDate() }} 마감
      </div>
    </div>
    <hr class="project-card-line" />
    <div class="row project-card-devide-row">
      <div class="project-card-item-round-wrapper ">
        <div class="d-flex justify-content-between project-card-item-round">
          <div class="mx-3">예상비용</div>
          <div class="mx-3">
            월
            <span style="color:#0064ff"
              >{{ projectData.lowPrice }}FC ~
              {{ projectData.highPrice }}FC</span
            >
          </div>
        </div>
      </div>
    </div>
    <!--<div style="height : 0px; background-color: white;">
    <div class="endWorkTime">
        <div class="mx-3">예상종료기간</div>
        <div class="mx-3">
          {{ projectData.deadline.getFullYear() }}.{{
            projectData.deadline.getMonth() + 1
          }}.{{ projectData.deadline.getDate() }}
        </div>
    </div>
    </div>-->
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
  </div>
</template>

<script>
import ProjectDetail from "@/components/Project/ProjectDetail.vue";
import { createInstance } from "../../api/index.js";

export default {
  name: "ProjectCardStatic",
  data() {
    return {
      /**임시 데이터 */
      projectDetailModalId: "projectDetail",
      projectData: {
        id: this.projectCardItem.projectId,
        category: this.projectCardItem.category,
        demain: this.projectCardItem.domain,
        location:
          this.projectCardItem.locationSi +
          " " +
          this.projectCardItem.locationGu,
        skill: [],
        title: this.projectCardItem.title,
        content: this.projectCardItem.task,
        startDate: new Date(this.projectCardItem.startDate),
        endDate: new Date(this.projectCardItem.endDate),
        startDateSummry: "2022-09-10",
        endDateSummry: "2022-09-16",
        deadline: new Date(this.projectCardItem.deadline),
        recruitNumber: this.projectCardItem.recruitNumber,
        task: this.projectCardItem.task,
        workstyle: this.projectCardItem.workStyle,
        workStartTime: this.projectCardItem.workStartTime,
        workEndTime: this.projectCardItem.workEndTime,
        lowPrice: this.projectCardItem.lowPrice,
        highPrice: this.projectCardItem.highPrice,
        careerPeriod: this.projectCardItem.careerPeriod
      },
      companyData: {
        name: "",
        ceo: "",
        address: "",
        call: ""
      },
      projectCardItemEdit: "#",
      remainDate: "",
      periodWork: 0
    };
  },
  mounted() {
    createInstance()
      .get("/project/tech/" + this.projectCardItem.projectId)
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          if (!this.projectData.skill.includes(res.data[i].techName)) {
            this.projectData.skill.push(res.data[i].techName);
          }
        }
      });
    createInstance()
      .get("/companies/information/" + this.projectCardItem.company.username)
      .then(res => {
        this.companyData.name = res.data.companyInfo.company.name;
        this.companyData.ceo = res.data.companyInfo.ceo;
        this.companyData.address = res.data.companyInfo.address;
        this.companyData.call = res.data.companyInfo.companyCall;
      });
    this.remainDate = Math.ceil(
      (this.projectData.deadline.getTime() - new Date().getTime()) /
        (1000 * 60 * 60 * 24) -
        1
    );
    this.periodWork =
      (this.projectData.endDate.getTime() -
        this.projectData.startDate.getTime()) /
        (1000 * 60 * 60 * 24) -
      1;
  },
  methods: {
    clickProjectCardInProjectFind() {
      this.$router.push({
        name: "projectDetail",
        params: {
          projectData: this.projectData
        }
      });
    },

    clickDetailOpen() {
      this.$emit("clickDetailOpen", {
        projectData: this.projectData,
        companyData: this.companyData,
        remainDate: this.remainDate,
        periodWork: this.periodWork
      });
    }
  },
  props: {
    //nprojectData: Object
    projectCardItem: Object
  },
  components: {
    ProjectDetail
  }
};
</script>

<style>
.project-card-header-round {

  padding: 6px 3px 0px 3px;
  margin-top: 5px;
  margin-left: 13px;
  width: 83px;
  height: 35px;
  border-radius: 20px;
  background-color: #0064ff;
  color: white;
  text-align: center;
}

.project-card-wrapper {
  transition: all 0.3s ease 0s;
}

.project-card-wrapper:hover {
  transform: translateY(-3px) ;
}
</style>
