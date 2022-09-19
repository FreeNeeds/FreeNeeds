<template>
  <b-container>
    <HeaderNav></HeaderNav>
    <div id="banner"></div>
    <FilterBtn></FilterBtn>
    <FreelancerList></FreelancerList>
    <FooterNav></FooterNav>
  </b-container>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FreelancerList from "@/components/Freelancer/FreelancerList.vue";
import FilterBtn from "@/components/Freelancer/Filter/FilterBtn.vue";

export default {
  components: { HeaderNav, FilterBtn, FooterNav, FreelancerList }
};
</script>

<style>
#banner {
  width: 100%;
  height: 130px;
  margin-top: 10px;
  margin-bottom: 10px;
  background-color: #eaf5fb;
}
</style>
