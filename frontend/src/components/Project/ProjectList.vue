<template>
  <div id="projectList">
    <ProjectCard
    >
    </ProjectCard>
  </div>
</template>

<script>
  import ProjectCard from '../ProjectCard/ProjectCard.vue';
  
  export default {
    name: 'ProjectList',
    components : {
      ProjectCard
    }
  }
</script>

<style>
  #projectList {
    margin-top: 25px !important;
    border-radius: 30px;
    width : 80%;
    margin: auto;
    height: 1000px; 
    border: 1px solid rgb(209, 207, 207); 
    background-color: white;
  }
</style>