<template> 
  <div id="projectDetailCtnr">
    <div class="row mx-2 my-2">
      <div class="col-3 projectDetailHeadItem projectDetailItem">  이름</div>
      <input class="col-2 mb-1 form-control" type="text">
    </div>
    <div class="row mx-2 my-2">
      <div class="col-3 projectDetailHeadItem projectDetailItem">  대표자</div>
      <input class="col-2 mb-1 form-control" type="text">
    </div>
    <div class="row mx-2 my-2">
      <div class="col-3 projectDetailHeadItem projectDetailItem">  주소</div>
      <input class="col-2 mb-1 form-control" type="text">
    </div>
    <div class="row mx-2 my-2">
      <div class="col-3 projectDetailHeadItem projectDetailItem">  전화번호</div>
      <input class="col-2 mb-1 form-control" type="text">
    </div>
    <button class="signatureBtn my-4" style="width : 150px !important; margin-left : 300px">등록하기</button>
  </div>
</template>

<script>
export default {
  name : 'CompanyInfoAdmin'
};
</script>

<style>

</style>
