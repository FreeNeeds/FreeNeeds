<template>
  <div>
    <div class="project-card-wrapper myPageProjectCardWrpr" style="box-shadow : 0px 0px 0px">
      <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 660px;">
      <div class="hoverProjectCard d-none" style="height : 0px !important;">
        <button class="myPageProjectDetailBtn" data-bs-toggle="modal" :data-bs-target=projectCardItemEdit >상세보기</button>
        <button @click="clickApplyMemberBtn" class="myPageApplyMemberBtn">지원자보기</button>
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
    name : "recruitCardItem",
    props : {
      projectData : Object,
      projectCardCarousel : Object
    },
    data() {
      return {
        myPageCompanyProjectStatusModalCtnr : "myPageCompanyProjectStatusModalCtnr",
        /**임시 데이터 */
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
      this.projectCardItemEdit += String(this.projectCardCarousel.id)
      this.myPageCompanyProjectStatusModalCtnr += String(this.projectCardCarousel.id)

    },
    components : {
      ProjectDetail
    },
    methods : {
      clickApplyMemberBtn() {
        this.$router.push({name : "apply", params: {
              projectId : 1
              }});
      }
    }
  }
</script>

<style>
  .myPageProjectCardWrpr:hover {
    background-color: rgba(0, 0, 0, 0.1);
    width : 660px;
    height : 280.4px;
  }

  .myPageProjectCardWrpr:hover > .hoverProjectCard{
    display: block !important;
  }

  .myPageProjectDetailBtn {
    position: relative;
    top : 60px;
    left : 236px;
    z-index: 2;
    border-radius: 40px;
    border: 1px solid lightgray;
    background-color: #6ecdb1;
    font-size: 17px;
    font-weight: bold;
    color: white;
    width: 150px;
    height: 40px;
  }

  .myPageApplyMemberBtn {
    border-radius: 40px;
    position: relative;
    top : 110px;
    left : 86px;
    z-index: 2;
    border: 1px solid lightgray;
    background-color: #3c74c9;
    font-size: 17px;
    color : white;
    font-weight: bold;
    width: 150px;
    height: 40px;
  }
</style>