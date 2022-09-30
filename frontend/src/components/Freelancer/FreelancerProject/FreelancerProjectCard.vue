<template>
  <div class="project-card-wrapper">
    <div class="d-flex my-2">
      <div class="text-start" style="color: gray">
        {{ freelancerProjectCard.body.category }}
      </div>
    </div>
    <div class="d-flex mx-2 my-3">
      <div class="fw-bold" style="font-size: 18px">
        {{ freelancerProjectCard.body.title }}
      </div>
    </div>
    <div class="d-flex mx-2 my-3">
      <div style="color: gray">
        {{ freelancerProjectCard.body.startDate }} ~
        {{ freelancerProjectCard.body.endDate }}
      </div>
    </div>
    <div class="d-flex mx-2 my-2">
      <div class="text-start">{{ freelancerProjectCard.body.content }}</div>
    </div>
    <div class="d-flex mx-2 my-2">
      <FreelancerCardSkill
        v-for="skillItem in freelancerProjectCard.body.projectCareerTech"
        :key="skillItem"
        :skillItem="skillItem"
      ></FreelancerCardSkill>
    </div>
  </div>
</template>

<script>
import FreelancerCardSkill from "../FreelancerCardSkill.vue";
export default {
  name: "FreelancerProjectCard",
  props: {
    freelancerProjectCard: Object
  },
  components: {
    FreelancerCardSkill
  },
  mounted() {
    console.log(this.freelancerProjectCard);
  }
};
</script>

<style></style>
