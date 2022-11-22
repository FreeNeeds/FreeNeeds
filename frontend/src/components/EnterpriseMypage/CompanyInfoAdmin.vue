<template> 
  <div id="projectDetailCtnr">
    <div class="row mx-2 my-2">
      <div class="projectDetailHeadItem projectDetailItem" style="font-size:30px;">  {{ name }} 님의 기업정보</div>
      <hr style="width: 90%; margin-top:40px; margin-bottom: 0; margin-left : 10px" />
    </div>
    <div class="mx-2 my-5">
      <div class="row mx-2 my-2">
        <div class="col-3 projectDetailHeadItem projectDetailItem">  대표자</div>
        <input v-model="companyInfo.ceo" class="col-2 mb-1 form-control" type="text">
      </div>
      <div class="row mx-2 my-2">
        <div class="col-3 projectDetailHeadItem projectDetailItem">  기업전화</div>
        <input v-model="companyInfo.companyCall" class="col-2 mb-1 form-control" type="text">
      </div>
      <div class="row mx-2 my-2">
        <div class="col-3 projectDetailHeadItem projectDetailItem">  주소</div>
        <input v-model="companyInfo.address" class="col-2 mb-1 form-control" type="text">
      </div>
      <div class="row mx-2 my-2">
        <div class="col-3 projectDetailHeadItem projectDetailItem">  사업자등록번호</div>
        <input v-model="companyInfo.registrationNumber" class="col-2 mb-1 form-control" type="text">
      </div>
    </div>
    <button class="signatureBtn my-4" style="width : 150px !important; margin-left : 300px" @click="register">등록하기</button>
  </div>
</template>

<script>
import * as companyInstance from "@/api/company.js";
import { mapGetters, mapActions } from "vuex";

export default {
  computed: {
    ...mapGetters(["accessToken", "isLogin","loginUserInfo"])
  },
  mounted(){
    console.log(this.$store.getters.loginUserInfo);
    this.name=this.$store.getters.loginUserInfo.name;
  },
  data() {
    return {
      name: "ddd",
      companyInfo: {
        ceo: "",
        address: "",
        companyCall: "",
        registrationNumber: "",
        registrationFile: "wow"
      }
    };
  },
  methods: {
    register() {
      companyInstance.setCompanyInfo(this.companyInfo)
    }
  }
};
</script>

<style>

</style>
