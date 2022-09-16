<template>
  <div id="freelancer-list">
    <!-- 카드컴포넌트 1 -->
    <FreelancerCard></FreelancerCard>
    <!-- 카드컴포넌트 1 끝-->
    <FreelancerCard></FreelancerCard>
    <FreelancerCard></FreelancerCard>
  </div>
</template>

<script>
import FreelancerCard from "@/components/Freelancer/FreelancerCard.vue";

export default {
  components: {
    FreelancerCard
  }
};
</script>

<style>
.freelancer-contents {
  max-width: 800px;
  max-height: 250px;
  margin: 0 auto;
  margin-top: 30px;
}

.freelancer-contents:hover {
  background-color: #b4b4b4;
}
</style>
