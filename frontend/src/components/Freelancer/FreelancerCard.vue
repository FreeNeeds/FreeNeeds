<template>
  <b-card
    class="freelancer-contents"
    img-src="https://placekitten.com/300/300"
    img-left
    data-bs-toggle="modal" :data-bs-target=freelancerCardIdEdit
    >
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
      <FreelancerDetail
      :id=freelancerCardId
      :freelancerDetailReceive="freelancerCard.body"
      ></FreelancerDetail>
  </b-card>
</template>

<script>
  import FreelancerCardSkill from './FreelancerCardSkill.vue';
  import FreelancerDetail from "@/components/Freelancer/FreelancerDetail.vue";

  export default {
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
    FreelancerDetail
}
  };
</script>

<style>
  .tech-contents {
    margin: 3px;
  }

  .freelancer-contents {
    width: 800px !important;
    height: 200px !important;
    margin: 0 auto;
    margin-top: 30px;
    box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.25);
  }

  .freelancer-contents > img {
    border-radius: 60px;
    margin : 30px;
  }

  .freelancer-contents > .card-body > .card-title {
    margin-top : 10px;
  }

  .freelancer-contents > .card-body > .container {
    height : 135px;
  }

  .freelancer-contents:hover {
    background-color: white !important;
  }

  .star-ratings {
    color: #aaa9a9; 
    position: relative;
    unicode-bidi: bidi-override;
    width: max-content;
    -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
    -webkit-text-stroke-width: 1.3px;
    -webkit-text-stroke-color: #2b2a29;
  }
  
  .star-ratings-fill {
    color: #fff58c;
    padding: 0;
    position: absolute;
    z-index: 1;
    display: flex;
    top: 0;
    left: 0;
    overflow: hidden;
    -webkit-text-fill-color: gold;
  }
  
  .star-ratings-base {
    z-index: 0;
    padding: 0;
  }

</style>
