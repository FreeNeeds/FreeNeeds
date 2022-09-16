<template>
  <div id="freelancer-list">
    <!-- 카드컴포넌트 1 -->
    <FreelancerCard></FreelancerCard>
    <!-- 카드컴포넌트 1 끝-->
    <b-card
      class="freelancer-contents"
      img-src="https://placekitten.com/300/300"
      img-left
      title="bill|23년 경력"
      sub-title="개발, 기획 | 웹 사이트"
    >
      <b-card-text>
        안녕하세요? 반갑습니다. 저는 빌 게이츠입니다. 무슨일이든 하겠습니다.
      </b-card-text>
      <span class="tech-contents badge bg-secondary">JAVA</span>
      <span class="tech-contents badge bg-secondary">JavaScript</span>
    </b-card>
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
#freelancer-list {
}

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
