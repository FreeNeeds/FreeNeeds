<template>
  <div
    @click="clickDetailOpen"
    class="project-card-wrapper"
    style="padding-top : 0px; padding-bottom : 0px"
    data-bs-toggle="modal"
    :data-bs-target="projectCardItemEdit"
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
        <span style="font-size : 14px"> | {{ projectData.careerPeriod}}년 경력 | {{ projectData.category}}</span>
      </div>
    </div>
    <div class="row project-card-header-item">
      <div class="col-4">
        <div class="project-card-header-round ">
          {{ projectData.workStyle }}
        </div>
      </div>
      <div class="project-card-title col-8">{{ projectData.title }}</div>
    </div>
    <div class="row project-card-header-item">
      <div class="col-4">
        <div class="project-card-header-round" v-if="remainDate != 0">
          D - {{ remainDate }}
        </div>
        <div class="project-card-header-round" v-else>
          D-Day
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
            <span style="color:blue"
              >{{ projectData.lowPrice }}만원 ~ {{ projectData.highPrice }}만원</span
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import ProjectDetail from '@/components/Project/ProjectDetail.vue';
  import { createInstance } from "../../api/index.js";

  export default {
    data() {
      return {
        /**임시 데이터 */
        projectDetailModalId : "projectDetail",
        projectData: {
          id: this.projectCardItem.projectId,
          category: this.projectCardItem.category,
          demain: this.projectCardItem.domain,
          location : this.projectCardItem.locationSi + " " + this.projectCardItem.locationGu,
          skill: [],
          title: this.projectCardItem.title,
          content: this.projectCardItem.task,
          startDate: new Date(this.projectCardItem.startDate),
          endDate: new Date(this.projectCardItem.endDate),
          startDateSummry : "2022-09-10",
          endDateSummry : "2022-09-16",
          deadline: new Date(this.projectCardItem.deadline),
          recruitNumber: this.projectCardItem.recruitNumber,
          task: this.projectCardItem.task,
          workStyle: this.projectCardItem.workStyle,
          workStartTime: this.projectCardItem.workStartTime,
          workEndTime: this.projectCardItem.workEndTime,
          lowPrice: this.projectCardItem.lowPrice,
          highPrice: this.projectCardItem.highPrice,
          careerPeriod: this.projectCardItem.careerPeriod,
        },
        companyData : {
          name: "",
          ceo: "",
          address: "",
          call: ""
        },
        projectCardItemEdit: "#",
        remainDate: ""
      };
    },
    mounted() {
      createInstance().get('/project/tech/' + this.projectCardItem.projectId).then(res =>{
        for (let i = 0; i < res.data.length; i++) {
          if (!this.projectData.skill.includes(res.data[i].techName)){
            this.projectData.skill.push(res.data[i].techName)
          }
        }
      })
      createInstance().get('/companies/information/' + this.projectCardItem.company.username).then(res =>{
        this.companyData.name = res.data.companyInfo.company.name
        this.companyData.ceo = res.data.companyInfo.ceo
        this.companyData.address = res.data.companyInfo.address
        this.companyData.call = res.data.companyInfo.companyCall
      })
      this.remainDate = Math.ceil(
        (this.projectData.deadline.getTime() - new Date().getTime()) /
          (1000 * 60 * 60 * 24) -
          1
      );
      this.projectCardItemEdit += "projectDetail" + String(this.projectCardItem.projectId)
      this.projectDetailModalId += String(this.projectCardItem.projectId)
    },
    methods : {
      clickProjectCardInProjectFind() {
        this.$router.push({name : "projectDetail", params: {
                projectData : this.projectData,
                }});
      },

      clickDetailOpen() {
        this.$emit("clickDetailOpen",{
          projectData : this.projectData,
          companyData : this.companyData,
          remainDate : this.remainDate
        })
      }
    },
    props: {
      //nprojectData: Object
      projectCardItem : Object
    },
    components : {
      ProjectDetail
    }
};
</script>

<style>
  .endWorkTime {
    position: relative;
    right : -240px;
    top : -250px;
    width : 200px;
  }

  .project-card-header-round {
      padding: 10px;
      width: 100px;
      height: 40px;
      border-radius: 20px;
      background-color: #fc7494 !important;
      font-weight: bold;
      text-align: center;
}
</style>
