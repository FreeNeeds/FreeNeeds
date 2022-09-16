<template>
  <b-card
    @click="MoveFreelancerDetail"
    class="freelancer-contents"
    img-src="https://placekitten.com/300/300"
    img-left
    title="이름|경력"
    sub-title="담당업무 | 직무분야"
  >
    <b-card-text>
      프리랜서가 하고싶은 말 보여줘
    </b-card-text>
    <span class="tech-contents badge bg-secondary">JAVA</span>
    <span class="tech-contents badge bg-secondary">JavaScript</span>
  </b-card>
</template>

<script>
export default {
  methods: {
    MoveFreelancerDetail() {
      this.$router.push("/freelancer/detail");
    }
  }
};
</script>

<style>
.tech-contents {
  margin: 3px;
}

.freelancer-contents {
  max-width: 800px;
  max-height: 250px;
  margin: 0 auto;
  margin-top: 30px;
}
</style>
