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

  export default {
    data() {
      return {
        projectCardLst : ["id1","id2","id3","id4","id5"]
      }
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