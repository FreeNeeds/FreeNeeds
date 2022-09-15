<template>
  <b-container>
    <header-nav></header-nav>
    <button id="filterBtn">
      필터
    </button>
    <FreelancerList></FreelancerList>
    <FooterNav></FooterNav>
  </b-container>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FreelancerList from "@/components/Freelancer/FreelancerList.vue";

export default {
  components: { HeaderNav, FooterNav, FreelancerList }
};
</script>

<style></style>
