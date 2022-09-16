<template>
  <div
    class="modal text-center"
    id="ProjectSelectModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="true"
    style="background-color: rgba(0, 0, 0, 0.5);"
  >
    <div class="modal-dialog" id="ProjectSelectModalWrapper">
      <div class="modal-content" id="ProjectSelectModalContent">
        <h3>인터뷰 신청이 완료되었습니다.</h3>
        <div id="CloseBtnWrapper">
          <button
            type="button"
            id="ProjectModalModalCloseBtn"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          >
            확인
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
#ProjectSelectModal {
  background-color: rgba(0, 0, 0, 0.2) !important;
}
#ProjectSelectModalWrapper {
  margin-top: 50px;
  text-align: center;
}
#ProjectSelectModalContent {
  width: 600px;
  margin: 0 auto;
  border-radius: 15px;
  height: 2000px;
  position: fixed;
}
#CloseBtnWrapper {
  text-align: right;
  padding: 30px;
}
</style>
