<template>
  <b-container>
    <header-nav></header-nav>
    <FilterBtn></FilterBtn>
    <FreelancerList></FreelancerList>
    <FooterNav></FooterNav>
  </b-container>

</template>

<script>
import HeaderNav from '@/components/HeaderNav.vue';
import FooterNav from '@/components/FooterNav.vue';
import FilterBtn from '@/components/Freelancer/FilterBtn.vue';
import FreelancerList from '@/components/Freelancer/FreelancerList.vue';

export default {
  components: {HeaderNav, FooterNav, FilterBtn, FreelancerList },
}
</script>

<style>

</style>
