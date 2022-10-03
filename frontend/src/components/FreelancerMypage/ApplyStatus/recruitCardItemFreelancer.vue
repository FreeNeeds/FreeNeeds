<template>
  <div>
    <div class="project-card-wrapper myPageProjectCardWrpr" style="width: 660px !important; margin : 0px !important; padding : 20px; box-shadow : 0px 0px 0px">
      <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 660px;">
      <div class="hoverProjectCard d-none" style="height : 0px !important;">
        <button class="myPageApplyMemberBtn" data-bs-toggle="modal" :data-bs-target=projectCardItemEdit style="top: 90px; left: 230px">상세보기</button>
      </div>
      <div class="row mb-3 ms-1">
        <div>
          <span style="font-size : 14px"> | {{ projectData.careerPeriod}}년 경력 | {{ projectData.category}} | {{ projectData.demain }}</span>
        </div>
      </div>
      <div class="row project-card-header-item">
        <div class="col-2 ">
          <div class="project-card-header-round ">
            {{ projectData.workstyle }}
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
    </div>
  </div>
</template>

<script>
  import ProjectDetail from '../../Project/ProjectDetail.vue';

  export default {
    name : "recruitCardItemFreelancer",
    props : {
      projectCardItem : Object,
    },
    data() {
      return {
        myPageCompanyProjectStatusModalCtnr : "myPageCompanyProjectStatusModalCtnr",
        /**임시 데이터 */
        projectData: {
          id: this.projectCardItem.projectId,
          category: this.projectCardItem.category,
          demain: this.projectCardItem.domain,
          location : this.projectCardItem.locationSi + " " + this.projectCardItem.locationGu,
          skill: [],
          title: this.projectCardItem.title,
          content: this.projectCardItem.task,
          startDate: this.projectCardItem.startDate,
          endDate: this.projectCardItem.endDate,
          startDateSummry : this.projectCardItem.startDateSummry,
          endDateSummry : this.projectCardItem.endDateSummry,
          deadline: this.projectCardItem.deadline,
          recruitNumber: this.projectCardItem.recruitNumber,
          task: this.projectCardItem.task,
          workstyle: this.projectCardItem.workStyle,
          workStartTime: this.projectCardItem.workStartTime,
          workEndTime: this.projectCardItem.workEndTime,
          lowPrice: this.projectCardItem.lowPrice,
          highPrice: this.projectCardItem.highPrice,
          careerPeriod: this.projectCardItem.careerPeriod,
        },
        projectCardItemEdit: "#",
        remainDate: ""
      };
    },
    mounted() {
      console.log(this.projectCardItem)
      this.remainDate = Math.ceil(
        (this.projectData.deadline.getTime() - new Date().getTime()) /
          (1000 * 60 * 60 * 24) -
          1
      );
      this.projectCardItemEdit += 'myPageProjectDetailId' + String(this.projectCardItem.projectId)

    },
    components : {
      ProjectDetail
    },
    methods : {
      clickApplyMemberBtn() {
        this.$router.push({name : "apply", params: {
              projectId : this.projectCardItem.projectId
              }});
      }
    }
  }
</script>