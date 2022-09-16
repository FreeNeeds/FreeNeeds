<template>
  <div id="interview-btn-wrap">
    <button
      id="interview-btn"
      type="button"
      class="btn btn-outline-secondary"
      data-bs-toggle="modal"
      data-bs-target="#InterviewModal"
    >
      인터뷰 요청하기
    </button>
    <InterviewModal></InterviewModal>
  </div>
</template>

<script>
import InterviewModal from "@/components/Freelancer/Interview/InterviewModal.vue";

export default {
  components: {
    InterviewModal
  }
};
</script>

<style>
#interview-btn-wrap {
  margin: 0 auto;
  width: 800px;
  text-align: right;
  margin-top: 20px;
}
</style>
