<template>
  <b-card
    class="freelancer-contents myPageProjectCardWrpr"
    img-src="https://placekitten.com/300/300"
    img-left
    >
      <div class="hoverProjectCard d-none" style="height : 0px !important;">
        <button data-bs-toggle="modal" :data-bs-target=freelancerCardIdEdit class="myPageApplyMemberDetailBtn" >상세보기</button>
      </div>
      <div class="row justify-content-between">
        <b-card-title class="col-6">
          {{ nameErase }}
          <span style="font-size : 14px">| {{ freelancerCard.body.resume.career_period }}년 경력</span>
        </b-card-title>
        <b-card-text class="col-6 text-end align-items-center">
          <div class="star-ratings d-inline-block mx-2">
            <div 
              class="star-ratings-fill space-x-2 text-lg"
              :style="{ width: ratingToPercent + '%' }"
            >
              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
            </div>
            <div class="star-ratings-base space-x-2 text-lg">
              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
            </div>
          </div>
          {{ Math.round((ratingToPercent) / 20 * 100) / 100}} 
          <span style="font-size : 12px; color : gray"> / 평가 {{ freelancerCard.body.estimate.length }} 개</span>
        </b-card-text>
      </div>
      <div class="row justify-content-end my-2">
        <b-card-text class="col-7">
          <div class="mb-2">
            {{ freelancerCard.body.resume.title }} <br>
            {{ freelancerCard.body.resume.title }}
          </div>
          <FreelancerCardSkill
          v-for="skillItem in freelancerCard.body.tech"
          :key="skillItem"
          :skillItem="skillItem"
          >
          </FreelancerCardSkill> 
        </b-card-text>
        <div class="col-5">
          <hr>
          <div class="row justify-content-between">
            <div class="col-8">계약한 프로젝트 : </div>
            <div class="col-4">총 {{ freelancerCard.body.projectCareer.length }} 건 </div>
          </div>
          <hr>
        </div>
      </div>
      <recruitApplyMemberItemDetail
      :id=freelancerCardId
      :freelancerDetailReceive="freelancerCard.body"
      :id_=this.freelancerCard.id
      ></recruitApplyMemberItemDetail>
  </b-card>
</template>

<script>
  import FreelancerCardSkill from '@/components/Freelancer/FreelancerCardSkill.vue';
  import FreelancerDetail from "@/components/Freelancer/FreelancerDetail.vue";
  import recruitApplyMemberItemDetail from '@/components/EnterpriseMypage/ProjectStatus/recruitApplyMemberItemDetail.vue'

  export default {
    name : 'recruitApplyMemberItem',
    data() {
      return {
        nameErase : "",
        ratingToPercent : 0,
        freelancerCardIdEdit : "#id",
        freelancerCardId : "id"
      }
    },
    props : {
      freelancerCard : Object
    },
    mounted() {
      for (let i = 0; i < this.freelancerCard.body.name.length; i++){
        if (i == 1) this.nameErase += "*"
        else this.nameErase += this.freelancerCard.body.name[i]
      }
      for (let i = 0; i < this.freelancerCard.body.estimate.length; i++) {
        this.ratingToPercent += this.freelancerCard.body.estimate[i].profession
        + this.freelancerCard.body.estimate[i].ontime + this.freelancerCard.body.estimate[i].active
        + this.freelancerCard.body.estimate[i].communication + this.freelancerCard.body.estimate[i].reEmployment
      }
      this.ratingToPercent = this.ratingToPercent / (5 * this.freelancerCard.body.estimate.length)
      this.ratingToPercent = this.ratingToPercent * 20
      this.freelancerCardIdEdit += String(this.freelancerCard.id)
      this.freelancerCardId += String(this.freelancerCard.id)
    },
    methods: {
      
    },
    components : {
    FreelancerCardSkill,
    FreelancerDetail,
    recruitApplyMemberItemDetail
}
  };
</script>

<style>
  .myPageProjectCardWrpr:hover {
    background-color: rgba(0, 0, 0, 0.1) !important;
  }

  .myPageProjectCardWrpr:hover > .card-body > .hoverProjectCard{
    display: block !important;
  }

  .myPageApplyMemberDetailBtn {
    border-radius: 40px;
    position: relative;
    top : 63px;
    left : 120px;
    z-index: 2;
    border: 1px solid lightgray;
    background-color: #3c74c9;
    font-size: 17px;
    color : white;
    font-weight: bold;
    width: 150px;
    height: 40px;
  }
</style>