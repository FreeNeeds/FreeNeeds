<template>
  <div :id="projectCardCarousel.id">
    <img
      class="wrapperImgProjectCarousel"
      src="@/assets/images/하얀색.png"
      alt=""
      style="width : 640px;"
    />
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
        <div class="project-card-header-round" v-if="remainDate > 0">
          D - {{ remainDate }}
        </div>
        <div class="project-card-header-round" v-else-if="remainDate === 0">
          D-Day
        </div>
        <div class="project-card-header-round" v-else>
          마감
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
</template>

<script>
export default {
  name: "ProjectCardCarousel",
  props: {
    projectData: Object,
    projectCardCarousel: Object
  },
  data() {
    return {
      remainDate: ""
    };
  },
  mounted() {
    this.remainDate = Math.ceil(
      (this.projectData.deadline.getTime() - new Date().getTime()) /
        (1000 * 60 * 60 * 24) -
        1
    );
  }
};
</script>
