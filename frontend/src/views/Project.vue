<template>
  <div>
    <HeaderNav></HeaderNav>
    <b-container>
      <div id="banner"></div>
      <FilterBtn></FilterBtn>
      <ProjectList></ProjectList>
      <SearchBar></SearchBar>
    </b-container>
    <FooterNav></FooterNav>
  </div>
</template>

<script>
  import SearchBar from '@/components/Project/SearchBar.vue'
  import HeaderNav from '@/components/HeaderNav.vue';
  import FooterNav from '@/components/FooterNav.vue';
  import FilterBtn from '@/components/Project/FilterBtn.vue';
  import ProjectList from '@/components/Project/ProjectList.vue';

  export default {
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