<template>
  <div class="project-card-wrapper" style="width : 100% !important">
    <div class="d-flex my-2">
      <div class="text-startc">
        {{ freelancerProjectCard.body.category }}
      </div>
    </div>
    <div class="d-flex mx-2 ">
      <div class="fw-bold" style="font-size: 18px">
        {{ freelancerProjectCard.body.title }}
      </div>
    </div>
    <div class="d-flex mx-2 ">
      <div style="color: gray">
        {{ freelancerProjectCard.body.start_date }} ~
        {{ freelancerProjectCard.body.end_date }}
      </div>
    </div>
    <div class="d-flex mx-2 my-4">
      <div class="text-start">{{ freelancerProjectCard.body.content }}</div>
    </div>
    <div class="d-flex mx-1 my-2">
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
    console.log('wow')
    console.log(this.freelancerProjectCard);
  }
};
</script>

<style>
.project-card-wrapper {
  padding: 10px;
}
.text-startc {
  margin: 0px 10px 0px 10px;
  padding: 4px 7px 4px 7px;
  color: white;
  background-color: #4657ff;
  border-radius: 20px;
  font-weight: 0;
}
</style>
