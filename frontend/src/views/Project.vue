<template>
  <b-container>
    <div id="banner"></div>
    <FilterBtn></FilterBtn>
    <!--<SearchBar></SearchBar>-->
    <ProjectList :projectCardLst="projectCardLst"></ProjectList>
  </b-container>
</template>

<script>
  import SearchBar from '@/components/Project/SearchBar.vue'
  import HeaderNav from '@/components/HeaderNav.vue';
  import FooterNav from '@/components/FooterNav.vue';
  import FilterBtn from '@/components/Project/FilterBtn.vue';
  import ProjectList from '@/components/Project/ProjectList.vue';
  import { findProjectList } from '../api/projectAPI.js';
  import { createInstance } from "../api/index.js";

  export default {
    data() {
      return {
        projectCardLst : []
      }
    },
    mounted() {
      createInstance().get('/project').then(res =>{
        console.log(res)
        for (let i = 0; i < res.data.length; i++) {
          console.log(res.data[i])
          this.projectCardLst.push(res.data[i])
        }
      })
      
    },
    components : {
      SearchBar,
      HeaderNav,
      FooterNav,
      FilterBtn,
      ProjectList
    }
  }
</script>

<style>
  #banner {
    width : 100%;
    height : 130px;
    margin-top : 10px;
    margin-bottom : 10px;
    background-color: #EAF5FB;
  }
</style>