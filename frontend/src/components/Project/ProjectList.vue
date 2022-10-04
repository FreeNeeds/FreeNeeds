<template>
  <div id="projectList" class="container">
    <div class="row ms-3">
      <ProjectCardStatic
        class="projectCardInProjectFind"
        v-for="projectCardItem in projectCardLst"
        :key="projectCardItem.projectId"
        :projectCardItem="projectCardItem"
        @clickDetailOpen="clickDetailOpen"
      >
      </ProjectCardStatic>
    </div>
    <!--<div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
      <div class="carousel-inner px-3">
        <ProjectCard class="carousel-item projectCardInProjectFind" v-for="projectCardItem in projectCardLst"
        :key="projectCardItem"
        :projectCardItem="projectCardItem"
        >
        </ProjectCard>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-left" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
        </svg>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-right" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
        </svg>
        <span class="visually-hidden">Next</span>
      </button>
    </div>-->
  </div>
</template>

<script>
import ProjectCardStatic from "./ProjectCardStatic.vue";

export default {
  name: "ProjectList",
  props: {
    projectCardLst: Array
  },
  mounted() {
    //document.querySelector(".carousel-item").classList.add("active")
  },
  components: {
    ProjectCardStatic
  },
  methods: {
    clickDetailOpen(value) {
      this.$emit("clickDetailOpen", value);
    }
  }
};
</script>

<style>
#projectList {
  width: 1300px !important;
  margin: auto;
}

.projectCardInProjectFind {
  width: 80%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 10px;
  margin-bottom: 10px;
}
.projectCardInProjectFind:hover {
  cursor: pointer;
}
</style>
