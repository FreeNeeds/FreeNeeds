<template>
  <div
    class="modal text-center"
    id="InterviewModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="false"
    style="background-color: rgba(0, 0, 0, 0.5);"
  >
    <div class="modal-dialog modal-lg" id="InterviewModalWrapper">
      <div class="modal-content" id="InterviewModalContent">
        <div id="CloseBtnWrapper">
          <button
            type="button"
            id="InterviewModalCloseBtn"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div id="comment-wrapper">
          <h4 id="project-select-wrapper">
            인터뷰를 신청할 프로젝트를 선택해주세요
          </h4>
        </div>
        <ProjectList></ProjectList>
      </div>
    </div>
  </div>
</template>

<script>
import ProjectList from "@/components/Freelancer/Interview/ProjectList.vue";
export default {
  components: {
    ProjectList
  }
};
</script>

<style>
#InterviewModal {
  background-color: rgba(0, 0, 0, 0.2) !important;
}

#InterviewModalWrapper {
  margin-top: 50px;
  text-align: center;
}

#InterviewModalContent {
  width: 800px;
  margin: 0 auto;
  border-radius: 15px;
  height: 650px;
  overflow-y: auto;
}

#InterviewModalContent::-webkit-scrollbar {
  width: 0px !important;
}
#CloseBtnWrapper {
  text-align: right;
  padding: 30px;
}

*::-webkit-scrollbar {
  width: 10px;
}

*::-webkit-scrollbar-thumb {
  background-color: #2f3542;
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}
</style>
