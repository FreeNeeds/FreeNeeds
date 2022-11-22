<template>
  <div> 
    <ProjectList :projectCardLst="projectList"
    @clickDetailOpen="clickDetailOpen"></ProjectList>
  </div> 
</template>

<script>
  import ProjectList from './ProjectList.vue';

  export default {
    name : 'ProjectListWrpr',
    components : {
      ProjectList
    },
    props : {
      projectList : Array
    },
    methods : {
      clickDetailOpen(value) {
        this.$emit("clickDetailOpen",value)
      }
    }
  }
</script>