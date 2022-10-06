<template>
  <div v-if="isDataLoad">
    <b-card
      class="freelancer-contents"
      :img-src=logo
      img-left
      @click="openFreelancerListModal"
      style="overflow:hidden; width : 92% !important"
    >
      <div class="row justify-content-between">
        <b-card-title class="col-5">
          {{ nameErase }}
          <span style="font-size : 14px"
            >| {{ freelancerCard.body.resume.career_period }}년 경력</span
          >
        </b-card-title>
        <b-card-text class="col-7 text-end align-items-center">
          <div class="star-ratings d-inline-block mx-2">
            <div
              class="star-ratings-fill space-x-2 text-lg"
              :style="{ width: ratingToPercent + '%' }"
            >
              <span>★</span><span>★</span><span>★</span><span>★</span
              ><span>★</span>
            </div>
            <div class="star-ratings-base space-x-2 text-lg">
              <span>★</span><span>★</span><span>★</span><span>★</span
              ><span>★</span>
            </div>
          </div>
          {{ Math.round((ratingToPercent / 20) * 100) / 100 }}
          <span style="font-size : 12px; color : gray">
            / 평가 {{ estimateNumber }} 개</span
          >
        </b-card-text>
      </div>
      <div class="row justify-content-end my-2">
        <b-card-text>
          <div class="mb-2">{{ freelancerCard.body.resume.title }}</div>
          <FreelancerCardSkill
            v-for="(skillItem, index) in freelancerCard.body.tech"
            :key="index"
            :skillItem="skillItem"
          >
          </FreelancerCardSkill>
        </b-card-text>
      </div>
    </b-card>
  </div>
</template>

<script>
import FreelancerCardSkill from "./FreelancerCardSkill.vue";
import { mapActions } from "vuex";
import * as userInstance from "@/api/user.js";

export default {
  data() {
    return {
      nameErase: "",
      ratingToPercent: 0,
      projectNumber: 0,
      estimateNumber: 0,
      isDataLoad: false,
      logo: ''
    };
  },
  props: {
    freelancerCard: Object
  },
  async mounted() {
    let randomImgs = ["/img/freech3.1c86f4e1.png","/img/freech4.da4bdf39.png","/img/freech5.e069d918.png"]
    this.logo = randomImgs[Math.floor(Math.random()*randomImgs.length)]
    
    console.log(this.freelancerCard);
    for (let j = 0; j < this.freelancerCard.body.projectCareer.length; j++) {
      await userInstance.getUserProjectTech(
        this.freelancerCard.body.projectCareer[j].projectCareerId,
        res => {
          this.freelancerCard.body.projectCareer[j].projectCareerTech = [];
          const techarr = res.data;
          for (let k = 0; k < techarr.length; k++) {
            this.freelancerCard.body.projectCareer[j].projectCareerTech.push(
              res.data[k].techName
            );
          }
        }
        // err => {
        //   this.freelancerCard.body.projectCareer[j].projectCareerTech = [];
        // }
      );
    }
    for (let i = 0; i < this.freelancerCard.body.name.length; i++) {
      if (i == 1) this.nameErase += "*";
      else this.nameErase += this.freelancerCard.body.name[i];
    }
    for (let i = 0; i < this.freelancerCard.body.estimate.length; i++) {
      this.ratingToPercent +=
        this.freelancerCard.body.estimate[i].profession +
        this.freelancerCard.body.estimate[i].ontime +
        this.freelancerCard.body.estimate[i].active +
        this.freelancerCard.body.estimate[i].communication +
        this.freelancerCard.body.estimate[i].reEmployment;
    }
    this.ratingToPercent =
      this.ratingToPercent / (5 * this.freelancerCard.body.estimate.length);
    this.ratingToPercent = this.ratingToPercent * 20;

    this.projectNumber = this.freelancerCard.body.projectCareer.length;
    this.estimateNumber = this.freelancerCard.body.estimate.length;
    if (
      this.ratingToPercent == 0 &&
      this.freelancerCard.body.estimate.length == 1
    ) {
      this.estimateNumber = 0;
    }
    this.isDataLoad = true;
  },
  methods: {
    ...mapActions(["setFreelancerInfoDetail", "setIsModalOn"]),

    openFreelancerListModal() {
      this.$emit('logo',this.logo)
      this.setFreelancerInfoDetail(this.freelancerCard.body);
      // this.setIsModalOn(true);
      console.log("????");
      $("#freelancerListDetailModal").modal("show");
    }
  },
  components: {
    FreelancerCardSkill
  }
};
</script>

<style>
.freelancer-contents:hover {
  cursor: pointer;
}
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
  margin: 30px;
}

.freelancer-contents > .card-body > .card-title {
  margin-top: 10px;
}

.freelancer-contents > .card-body > .container {
  height: 135px;
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
