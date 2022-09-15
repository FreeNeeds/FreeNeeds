<template>
  <b-card
    class="freelancer-contents"
    img-src="../assets/imga노란색.png"
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
export default {};
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
