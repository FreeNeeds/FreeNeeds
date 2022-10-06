<template>
  <b-card
    class="freelancer-contents myPageFreelancerCardWrpr"
    img-src=".."
    img-left
    :id="representiveImgAfter"
    style="overflow : hidden"
    >
      <div class="hoverProjectCard d-none" style="height : 0px !important;">
        <button id="completeDetailBtn" data-bs-toggle="modal" :data-bs-target=freelancerCardIdEdit class="myPageApplyMemberDetailBtn">상세보기</button>
        <button @click=clickEstimateBtn :id="completeEstimateBtn" class="completeEstimateAfterBtn myPageProjectDetailBtn d-none" style="top : 65px; left : -30px">평가하기</button>
        <button @click=clickCalBtn :id="completeCalBtn" class="completeEstimateAfterBtn myPageProjectDetailBtn newClrBtn d-none" style="top : 115px; left : -180px">정산하기</button>
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
        <hr />
        <div class="row justify-content-between">
          <div class="col-8">계약한 프로젝트 :</div>
          <div class="col-4">총 {{ projectCareer.length }} 건</div>
        </div>
        <hr />
      </div>
      <div id="calWrpr" class="d-none calWrpr">
        <div class="cal text-center">
          <h4 class="mt-5">정산하시겠습니까?</h4>
          <button @click="calClose(), withdraw()" class="estimateCompleteBtn mt-3">네</button>
        </div>
      </div>
    </div>
    <recruitApplyMemberItemDetailIng
      :id="freelancerCardIdModal"
      :id_="freelancerCardId"
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
import FreelancerCardSkill from "@/components/Freelancer/FreelancerCardSkill.vue";
import FreelancerDetail from "@/components/Freelancer/FreelancerDetail.vue";
import recruitApplyMemberItemDetailIng from "@/components/EnterpriseMypage/ProjectStatus/recruitApplyMemberItemDetailIng.vue";
import { createInstance } from "@/api/index.js";
import { enterprisePayFreelancer } from "@/utils/EscrowFactory.js";
import * as userInstance from "@/api/user.js";

export default {
  name: "recruitApplyMemberItemAfter",
  data() {
    return {
      freelancerAccount: "",
      escrowAddress: "0xC404bD07bcd3131433a2489CE8Ac5Cb2c41B967b",
      nameErase: "",
      ratingToPercent: 0,
      freelancerCardIdEdit: "#id",
      freelancerCardIdModal: "id",
      projectCareer: [],
      resume: {},
      profile: {},
      estimate: [],
      profileTech: [],
      profession: 0,
      ontime: 0,
      active: 0,
      communication: 0,
      reEmployment: 0,
      username: "",
      randomImg : '',
      representiveImgAfter : "representiveImgAfter",
      estimateModalWrpr: "estimateModalWrpr",
      completeDetailBtn: "completeDetailBtn",
      completeEstimateBtn: "completeEstimateBtn",
      completeCalBtn: "completeCalBtn"
    };
  },
  props: {
    freelancerCardId: Number,
    projectId: Number,
    state: String,
    stateTmp: String
  },
  mounted() {
    this.freelancerCardIdModal += this.freelancerCardId;
    this.completeCalBtn += this.freelancerCardId;
    this.representiveImgAfter += this.freelancerCardId
    let randomImgs = ["/img/freech3.1c86f4e1.png","/img/freech4.da4bdf39.png","/img/freech5.e069d918.png"]
    this.randomImg = randomImgs[Math.floor(Math.random()*randomImgs.length)]
    setTimeout(() => {
      document.querySelector('#' + this.representiveImgAfter + '> img').src = this.randomImg
    },10)
    createInstance()
      .get("/users/username/" + String(this.freelancerCardId))
      .then(res => {
        let username = res.data;
        this.username = res.data;
        createInstance()
          .get("/users/project/" + username)
          .then(res => {
            for (let i = 0; i < res.data.length; i++) {
              this.projectCareer.push({
                body: res.data[i]
              });
            }
          });
        createInstance()
          .get("/users/resume/" + username)
          .then(res => {
            this.resume = res.data;
          });
        createInstance()
          .get("/users/profile/" + username)
          .then(res => {
            this.profile = res.data;
            for (let i = 0; i < this.profile.name.length; i++) {
              if (i == 1) this.nameErase += "*";
              else this.nameErase += this.profile.name[i];
            }
            createInstance()
              .get("/users/profile/tech/" + String(res.data.profileId))
              .then(res => {
                for (let i = 0; i < res.data.length; i++) {
                  this.profileTech.push(res.data[i].techName);
                }
              });
          });
        createInstance()
          .get("/estimates/" + username)
          .then(res => {
            for (let i = 0; i < res.data.length; i++) {
              this.estimate.push(res.data[i]);
            }

            for (let i = 0; i < this.estimate.length; i++) {
              this.profession += this.estimate[i].profession;
              this.ontime += this.estimate[i].ontime;
              this.active += this.estimate[i].active;
              this.communication += this.estimate[i].communication;
              this.reEmployment += this.estimate[i].reEmployment;
            }

            this.profession = this.profession / this.estimate.length;
            this.ontime = this.ontime / this.estimate.length;
            this.active = this.active / this.estimate.length;
            this.communication = this.communication / this.estimate.length;
            this.reEmployment = this.reEmployment / this.estimate.length;
            this.ratingToPercent =
              (this.profession +
                this.ontime +
                this.active +
                this.communication +
                this.reEmployment) /
              5;
            this.ratingToPercent = this.ratingToPercent * 20;
            console.log(this.profession);
          });
      });
    this.completeDetailBtn += String(this.freelancerCardId);
    this.completeEstimateBtn += String(this.freelancerCardId);
    this.estimateModalWrpr += String(this.freelancerCardId);
    if (this.stateTmp === "complete") {
      for (let item of document.querySelectorAll("#completeDetailBtn")) {
        item.setAttribute("style", "top : 15px;");
      }
      for (let item of document.querySelectorAll(".completeEstimateAfterBtn")) {
        item.classList.remove("d-none");
      }
    }
    this.freelancerCardIdEdit += String(this.freelancerCardId);
    userInstance.getUserAccountAddress(this.freelancerCardId, res => {
      this.freelancerAccount = res.data;
    });
    // createInstance().get('/contracts?projectId=' + this.projectId + '&userId=' + String(this.freelancerCardId),
    //   ).then(res => {this.escrowAddress = res.data.escrowAddress})
  },

  methods: {
    withdraw: async function() {
      const accounts = await window.ethereum.request({
        method: "eth_requestAccounts"
      });
      enterprisePayFreelancer(accounts[0], this.freelancerAccount);
    },

    moveToIngContract(value) {
      this.$emit("moveToIngContract", value);
    },

    clickEstimateBtn() {
      this.$emit("clickEstimateBtn", {
        nameErase: this.nameErase,
        freelancerCardId: this.freelancerCardId,
        username: this.username
      });
    },

    clickCalBtn() {
      document.querySelector("body").style.overflow = "hidden";
      document.querySelector("#calWrpr").classList.remove("d-none");
    },

    calClose() {
      document.querySelector("body").style.overflow = "scroll";
      document.querySelector("#calWrpr").classList.add("d-none");
    }
  },
  components: {
    FreelancerCardSkill,
    FreelancerDetail,
    recruitApplyMemberItemDetailIng
  }
};
</script>

<style>
  .myPageFreelancerCardWrpr:hover {
    background-color: rgba(0, 0, 0, 0.1) !important;
  }

  .myPageFreelancerCardWrpr:hover > .card-body > .hoverProjectCard{
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

  .estimateModalWrpr {
    position: fixed;
    top : 0px;
    left : 0px;
    z-index: 2;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0, 0, 0, 0.15);
  }

  .estimateModal {
    position: fixed;
    bottom : 30%;
    left: 40%;
    background-color: white;
    border-radius: 20px;
    height: 500px; 
    border: 1px solid lightgray;
    width: 400px;
    margin: auto;
  }

  #estimateModalCloseBtn {
    position : relative;
    top : 15px;
    left : 360px;
  }

  .selectItem {
    z-index: 2;
    border : 0px !important;
  }

  .star-ratings-fill-start {
    width : 0%;
  }

  .newClrBtn {
    background-color: rgb(252, 121, 91);
  }
  
  #select1:hover ~ .star-ratings-fill {
    width: 10% !important;
  }

  #select2:hover ~ .star-ratings-fill {
    width: 20% !important;
  }
  
  #select3:hover ~ .star-ratings-fill {
    width: 30% !important;
  }

  #select4:hover ~ .star-ratings-fill {
    width: 40% !important;
  }

  #select5:hover ~ .star-ratings-fill {
    width: 50% !important;
  }

  #select6:hover ~ .star-ratings-fill {
    width: 60% !important;
  }

  #select7:hover ~ .star-ratings-fill {
    width: 70% !important;
  }

  #select8:hover ~ .star-ratings-fill {
    width: 80% !important;
  }

  #select9:hover ~ .star-ratings-fill {
    width: 90% !important;
  }

  #select10:hover ~ .star-ratings-fill {
    width: 100% !important;
  }

  .radio {
    opacity:0;width:0;height:0;position:absolute;
  }

  #radio1:checked ~ .star-ratings-fill {
    width: 10%;
  }

  #radio2:checked ~ .star-ratings-fill {
    width: 20%;
  }

  #radio3:checked ~ .star-ratings-fill {
    width: 30%;
  }

  #radio4:checked ~ .star-ratings-fill {
    width: 40%;
  }

  #radio5:checked ~ .star-ratings-fill {
    width: 50%;
  }

  #radio6:checked ~ .star-ratings-fill {
    width: 60%;
  }

  #radio7:checked ~ .star-ratings-fill {
    width: 70%;
  }

  #radio8:checked ~ .star-ratings-fill {
    width: 80%;
  }

  #radio9:checked ~ .star-ratings-fill {
    width: 90%;
  }

  #radio10:checked ~ .star-ratings-fill {
    width: 100%;
  }

  #radio11:checked ~ .star-ratings-fill {
    width: 10%;
  }

  #radio12:checked ~ .star-ratings-fill {
    width: 20%;
  }

  #radio13:checked ~ .star-ratings-fill {
    width: 30%;
  }

  #radio14:checked ~ .star-ratings-fill {
    width: 40%;
  }

  #radio15:checked ~ .star-ratings-fill {
    width: 50%;
  }

  #radio16:checked ~ .star-ratings-fill {
    width: 60%;
  }

  #radio17:checked ~ .star-ratings-fill {
    width: 70%;
  }

  #radio18:checked ~ .star-ratings-fill {
    width: 80%;
  }

  #radio19:checked ~ .star-ratings-fill {
    width: 90%;
  }

  #radio20:checked ~ .star-ratings-fill {
    width: 100%;
  }

  #radio21:checked ~ .star-ratings-fill {
    width: 10%;
  }

  #radio22:checked ~ .star-ratings-fill {
    width: 20%;
  }

  #radio23:checked ~ .star-ratings-fill {
    width: 30%;
  }

  #radio24:checked ~ .star-ratings-fill {
    width: 40%;
  }

  #radio25:checked ~ .star-ratings-fill {
    width: 50%;
  }

  #radio26:checked ~ .star-ratings-fill {
    width: 60%;
  }

  #radio27:checked ~ .star-ratings-fill {
    width: 70%;
  }

  #radio28:checked ~ .star-ratings-fill {
    width: 80%;
  }

  #radio29:checked ~ .star-ratings-fill {
    width: 90%;
  }

  #radio30:checked ~ .star-ratings-fill {
    width: 100%;
  }

  #radio31:checked ~ .star-ratings-fill {
    width: 10%;
  }

  #radio32:checked ~ .star-ratings-fill {
    width: 20%;
  }

  #radio33:checked ~ .star-ratings-fill {
    width: 30%;
  }

  #radio34:checked ~ .star-ratings-fill {
    width: 40%;
  }

  #radio35:checked ~ .star-ratings-fill {
    width: 50%;
  }

  #radio36:checked ~ .star-ratings-fill {
    width: 60%;
  }

  #radio37:checked ~ .star-ratings-fill {
    width: 70%;
  }

  #radio38:checked ~ .star-ratings-fill {
    width: 80%;
  }

  #radio39:checked ~ .star-ratings-fill {
    width: 90%;
  }

  #radio40:checked ~ .star-ratings-fill {
    width: 100%;
  }

  #radio41:checked ~ .star-ratings-fill {
    width: 10%;
  }

  #radio42:checked ~ .star-ratings-fill {
    width: 20%;
  }

  #radio43:checked ~ .star-ratings-fill {
    width: 30%;
  }

  #radio44:checked ~ .star-ratings-fill {
    width: 40%;
  }

  #radio45:checked ~ .star-ratings-fill {
    width: 50%;
  }

  #radio46:checked ~ .star-ratings-fill {
    width: 60%;
  }

  #radio47:checked ~ .star-ratings-fill {
    width: 70%;
  }

  #radio48:checked ~ .star-ratings-fill {
    width: 80%;
  }

  #radio49:checked ~ .star-ratings-fill {
    width: 90%;
  }

  #radio50:checked ~ .star-ratings-fill {
    width: 100%;
  }

  .estimateCompleteBtn {
    width : 130px;
    height : 40px;
    border-radius: 20px;
    border : 0px;
    background-color: #3c74c9;
    text-align: center;
    color : white;
    font-weight: bold;
    font-size : 18px;
  }

  .calWrpr {
    position: fixed;
    top : 0px;
    left : 0px;
    z-index: 2;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0, 0, 0, 0.15);
  }

  .cal {
    position: fixed;
    bottom : 50%;
    left : 43%;
    background-color: white;
    border-radius: 30px;
    height: 27vh;
    border: 1px solid lightgray;
    width: 30vw;
    margin: auto;
  }
</style>