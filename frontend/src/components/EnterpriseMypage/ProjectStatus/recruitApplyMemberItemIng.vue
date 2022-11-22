<template>
  <b-card
    class="freelancer-contents myPageFreelancerCardWrpr"
    img-src=".."
    img-left
    :id = "representiveImg"
    style="overflow : hidden"
    >
      <div class="hoverProjectCard d-none" style="height : 0px !important;">
        <button data-bs-toggle="modal" :data-bs-target=freelancerCardIdEdit class="myPageApplyMemberDetailBtn" >상세보기</button>
      </div>
      <div class="row justify-content-between">
        <b-card-title class="col-6">
          {{ nameErase }}
          <span style="font-size : 14px">| {{ profile.creer_period }}년 경력</span>
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
          <span style="font-size : 12px; color : gray"> / 평가 {{ estimate.length }} 개</span>
        </b-card-text>
      </div>
      <div class="row justify-content-end my-2">
        <b-card-text class="col-7">
          <div class="mb-2">
            {{ profile.title }}
          </div>
          <FreelancerCardSkill
          v-for="skillItem in profileTech"
          :key="skillItem"
          :skillItem="skillItem"
          >
          </FreelancerCardSkill> 
        </b-card-text>
        <div class="col-5">
          <hr>
          <div class="row justify-content-between">
            <div class="col-8">계약한 프로젝트 : </div>
            <div class="col-4">총 {{ projectCareer.length }} 건 </div>
          </div>
          <hr>
        </div>
      </div>
      <recruitApplyMemberItemDetailIng
      :id=freelancerCardIdModal
      :id_=freelancerCardId
      :nameErase="nameErase"
      :projectCareer="projectCareer"
      :resume="resume"
      :profile="profile"
      :estimate="estimate"
      :profileTech="profileTech"
      :profession="profession"
      :ontime="ontime"
      :active="active"
      :communication="communication"
      :reEmployment="reEmployment"
      :ratingToPercent="ratingToPercent"
      :projectId="projectId"
      :state="state"
      :imgSrc="randomImg"
      @moveToIngContract="moveToIngContract"
      ></recruitApplyMemberItemDetailIng>
  </b-card>
</template>

<script>
  import FreelancerCardSkill from '@/components/Freelancer/FreelancerCardSkill.vue';
  import FreelancerDetail from "@/components/Freelancer/FreelancerDetail.vue";
  import recruitApplyMemberItemDetailIng from './recruitApplyMemberItemDetailIng.vue';
  import { createInstance } from "@/api/index.js";

  export default {
    name : 'recruitApplyMemberItemIng',
    data() {
      return {
        nameErase : "",
        ratingToPercent : 0,
        freelancerCardIdEdit : "#id",
        freelancerCardIdModal: "id",
        projectCareer : [],
        resume : {},
        profile : {},
        estimate : [],
        profileTech : [],
        profession : 0,
        ontime : 0,
        active : 0,
        communication : 0,
        reEmployment : 0,
        randomImg : '',
        representiveImg : "representiveImg"
      }
    },
    props : {
      freelancerCardId : Number,
      projectId : Number,
      state : String,
    },
    mounted() {
      this.representiveImg += this.freelancerCardId
      this.freelancerCardIdModal += this.freelancerCardId
      let randomImgs = ["/img/freech3.1c86f4e1.png","/img/freech4.da4bdf39.png","/img/freech5.e069d918.png"]
      this.randomImg = randomImgs[Math.floor(Math.random()*randomImgs.length)]
      setTimeout(() => {
        document.querySelector('#' + this.representiveImg + '> img').src = this.randomImg
      },500)
      createInstance().get('/users/username/' + String(this.freelancerCardId)).then(res => {
        console.log(res)
        let username = res.data
        createInstance().get('/users/project/' + username).then(res => {
          for (let i = 0; i < res.data.length; i++) {
            this.projectCareer.push({
              body : res.data[i]
            })
          }
          console.log(res)
        })
        createInstance().get('/users/resume/' + username).then(res => {
          this.resume = res.data
          console.log(res)
        })
        createInstance().get('/users/profile/' + username).then(res => {
          this.profile = res.data
          for (let i = 0; i < this.profile.name.length; i++){
            if (i == 1) this.nameErase += "*"
            else this.nameErase += this.profile.name[i]
          }
          createInstance().get('/users/profile/tech/' + String(res.data.profileId)).then(res => {
            for (let i = 0; i < res.data.length; i++) {
              this.profileTech.push(res.data[i].techName)
            }
          })
        })
        createInstance().get('/estimates/' + username).then(res => {
          for (let i = 0; i < res.data.length; i++) {
            this.estimate.push(res.data[i])
          }

          for (let i = 0; i < this.estimate.length; i++) {
            this.profession += this.estimate[i].profession
            this.ontime += this.estimate[i].ontime 
            this.active += this.estimate[i].active
            this.communication += this.estimate[i].communication 
            this.reEmployment += this.estimate[i].reEmployment
          }
          
          this.profession = this.profession / (this.estimate.length)
          this.ontime = this.ontime / (this.estimate.length)
          this.active = this.active / (this.estimate.length)
          this.communication = this.communication / (this.estimate.length)
          this.reEmployment = this.reEmployment / (this.estimate.length)
          this.ratingToPercent = (this.profession + this.ontime + this.active + this.communication + this.reEmployment) / 5
          this.ratingToPercent = this.ratingToPercent * 20
          console.log(this.profession)
        })
      })
      this.freelancerCardIdEdit += String(this.freelancerCardId)
    },
    methods: {
      moveToIngContract(value) {
        this.$emit('moveToIngContract',value)
      }
    },
    components : {
    FreelancerCardSkill,
    FreelancerDetail,
    recruitApplyMemberItemDetailIng
}
  };
</script>