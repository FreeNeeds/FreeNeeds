<template>
  <div v-if="isDataLoad">
    <div id="freelancerDetailCtnr">
      <div class="container my-4 py-4" id="freelancerDetailHeadCtnr">
        <div class="row m-2">
          <h4 class="text-start fw-bold">
            {{ freelancerDetailReceive.resume.title }}
          </h4>
        </div>
        <div class="d-flex mx-4">
          <div class="d-inline-block">{{ nameErase }} |</div>
          <div class="d-inline-block">
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
            |
          </div>
          <div class="d-inline-block mx-2">
            경력 {{ freelancerDetailReceive.resume.career_period }}년
          </div>
          <div class="d-inline-block mx-2">
            <button class="info-change-btn" @click="goInfoCorrectPage">
              수정 하기
            </button>
          </div>
        </div>
        <div class="d-flex mt-4">
          <div class="d-inline-block" id="freelancerDetailResumeImg">
            <img src="https://placekitten.com/300/300" alt="" />
          </div>
          <div class="d-inline-block" style="width: 270px">
            <div class="d-flex mt-3 mb-2 justify-content-between">
              <div
                class="d-inline-block fw-bold"
                style="margin-bottom : 2px; font-size: 17px;"
              >
                활동평가
              </div>
              <div class="d-inline-block">
                <div
                  class="star-ratings d-inline-block mx-2"
                  style="margin-top: 1px"
                >
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
                <div class="d-inline-block lightGrayLetter mx-1 starScore">
                  <div>
                    {{ Math.round((ratingToPercent / 20) * 100) / 100 }}
                  </div>
                </div>
              </div>
            </div>
            <hr style="background-color : black; height: 1.5px; margin : 3px" />
            <div class="d-flex my-1 justify-content-between">
              <div
                class="d-inline-block subScoreLetter"
                style="margin-top : 2px"
              >
                전문성
              </div>
              <div class="d-inline-block">
                <div class="star-ratings d-inline-block mx-2">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: profession * 20 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                </div>
                <div class="d-inline-block lightGrayLetter mx-1 starScore">
                  <div>{{ Math.round(profession * 100) / 100 }}</div>
                </div>
              </div>
            </div>
            <div class="d-flex my-1 justify-content-between">
              <div
                class="d-inline-block subScoreLetter"
                style="margin-top : 2px"
              >
                일정준수
              </div>
              <div class="d-inline-block">
                <div class="star-ratings d-inline-block mx-2">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: ontime * 20 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                </div>
                <div class="d-inline-block lightGrayLetter mx-1 starScore">
                  <div>{{ Math.round(ontime * 100) / 100 }}</div>
                </div>
              </div>
            </div>
            <div class="d-flex my-1 justify-content-between">
              <div
                class="d-inline-block subScoreLetter"
                style="margin-top : 2px"
              >
                적극성
              </div>
              <div class="d-inline-block">
                <div class="star-ratings d-inline-block mx-2">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: active * 20 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                </div>
                <div class="d-inline-block lightGrayLetter mx-1 starScore">
                  <div>{{ Math.round(active * 100) / 100 }}</div>
                </div>
              </div>
            </div>
            <div class="d-flex my-1 justify-content-between">
              <div
                class="d-inline-block subScoreLetter"
                style="margin-top : 2px"
              >
                의사소통
              </div>
              <div class="d-inline-block">
                <div class="star-ratings d-inline-block mx-2">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: communication * 20 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                </div>
                <div class="d-inline-block lightGrayLetter mx-1 starScore">
                  <div>{{ Math.round(communication * 100) / 100 }}</div>
                </div>
              </div>
            </div>
            <div class="d-flex my-1 justify-content-between">
              <div
                class="d-inline-block subScoreLetter"
                style="margin-top : 2px"
              >
                재고용의사
              </div>
              <div class="d-inline-block">
                <div class="star-ratings d-inline-block mx-2">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: reEmployment * 20 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                </div>
                <div class="d-inline-block lightGrayLetter mx-1 starScore">
                  <div>{{ Math.round(reEmployment * 100) / 100 }}</div>
                </div>
              </div>
            </div>
          </div>
          <div class="d-inline-block mx-1">
            <div
              style="width: 1px; height: 87%; margin-top: 22px; background-color: gray"
            ></div>
          </div>
          <div class="d-inline-block mx-auto my-3" style="width : 229px">
            <FreelancerCardSkill
              v-for="(skillItem, index) in freelancerDetailReceive.tech"
              :key="`FDR-T-${index}`"
              :skillItem="skillItem"
            >
            </FreelancerCardSkill>
          </div>
        </div>
        <div class="row">
          <h5 class="fw-bold m-4 text-start">소개</h5>
        </div>
        <div class="row mx-3">
          <div class="text-start">
            {{ freelancerDetailReceive.resume.introduce }}
          </div>
        </div>
      </div>

      <div class="row" id="projectDetailNavCtnr">
        <div
          @click="clickFreelancerDetailNavProject"
          class="col-2 projectDetailNav activeProjectDetailNav"
          :id="FreelancerDetailNavProject"
        >
          프로젝트
        </div>
        <div
          @click="clickFreelancerDetailNavResume"
          class="col-2 projectDetailNav"
          :id="FreelancerDetailNavResume"
        >
          이력서
        </div>
      </div>
      <hr class="project-card-line" style="margin-bottom : 40px" />
      <div :id="projectDetailNavItem">
        <div class="d-flex justify-content-end">
          <button
            class="project-add-btn"
            data-bs-toggle="modal"
            data-bs-target="#addProjectModal"
          >
            프로젝트 추가
          </button>
        </div>
        <FreelancerProjectCard
          v-for="freelancerProjectCard in freelancerDetailReceive.projectCareer"
          :key="freelancerProjectCard.id"
          style="margin-left : 0px !important"
          :freelancerProjectCard="{
            body: freelancerProjectCard
          }"
        >
        </FreelancerProjectCard>
      </div>
      <div :id="resumeDetailNavItem" class="deactiveProjectDetailItem">
        <div class="d-flex justify-content-end">
          <button
            class="resume-add-btn"
            data-bs-toggle="modal"
            data-bs-target="#addCareerModal"
          >
            이력서 수정
          </button>
        </div>
        <div class="row mx-2 my-4">
          <div class="projectDetailHeadItem projectDetailItem">학력</div>
        </div>
        <div class="d-flex mx-3 my-2">
          <div class="freelancerEducationName">
            {{ freelancerEducation.education.highschool }}
          </div>
          <div class="text-start freelancerEducationItem">
            {{ freelancerEducation.education.highschool_start_date }} ~
            {{ freelancerEducation.education.highschool_end_date }}
          </div>
        </div>
        <div class="d-flex mx-3 my-2">
          <div class="freelancerEducationName">
            {{ freelancerEducation.education.university }}
          </div>
          <div class="text-start freelancerEducationItem">
            {{ freelancerEducation.education.university_start_date }} ~
            {{ freelancerEducation.education.university_end_date }}
          </div>
        </div>
        <div class="row mx-2 my-4">
          <div class="projectDetailHeadItem projectDetailItem">경력</div>
        </div>
        <div
          class="d-flex mx-3 my-2"
          v-for="freelancerCareerItem in freelancerEducation.careerList"
        >
          <div class="freelancerEducationName">
            {{ freelancerCareerItem.companyName }}
          </div>
          <div class="freelancerEducationItem">
            {{ freelancerCareerItem.start_date }} ~
            {{ freelancerCareerItem.end_date }}
          </div>
        </div>
        <div class="row mx-2 my-4">
          <div class="projectDetailHeadItem projectDetailItem">자격증</div>
        </div>
        <div
          class="d-flex mx-3 mt-2"
          v-for="freelancerCareerItem in freelancerEducation.certificateList"
        >
          <div class="freelancerEducationName">
            {{ freelancerCareerItem.name }}
          </div>
          <div class="freelancerEducationItem">
            {{ freelancerCareerItem.date }}
          </div>
        </div>
      </div>
    </div>

    <add-career-modal-vue
      :freelancerDetailReceive="freelancerDetailReceive"
      v-if="isDataLoad"
    >
    </add-career-modal-vue>
    <add-project-modal-vue v-if="isDataLoad"></add-project-modal-vue>
  </div>
</template>

<script>
import FreelancerProjectCard from "@/components/Freelancer/FreelancerProject/FreelancerProjectCard.vue";
import FreelancerCardSkill from "./FreelancerCardSkill.vue";

import ProjectCardCarousel from "../Project/ProjectCardCarousel.vue";
import AddCareerModalVue from "../FreelancerMypage/ManageCareer/AddCareerModal.vue";
import AddProjectModalVue from "../FreelancerMypage/ManageCareer/AddProjectModal.vue";
import * as userInstance from "@/api/user.js";

export default {
  name: "FreelancerDetail",
  components: {
    AddCareerModalVue,
    AddProjectModalVue,

    FreelancerProjectCard,
    FreelancerCardSkill,

    ProjectCardCarousel
  },

  data() {
    return {
      idx: 0,
      isDataLoad: false,
      nameErase: "",
      profession: 0,
      ontime: 0,
      active: 0,
      communication: 0,
      reEmployment: 0,
      ratingToPercent: 0,
      projectDetailNavItem: "프로젝트item",
      resumeDetailNavItem: "이력서item",
      selectProjectFreelancerName: "",
      freelancerProjectModalId: "freeProModal",
      freelancerProjectModalCtnrId: "freeProModalCtnr",
      carouselWrapperMine: "carouselWrpp",
      carouselMine: "carousel",
      normalProjectFreelancerModal: "normalProjectFreelancerModal",
      sureSelectProjectFreelancer: "sureSelectProjectFreelancer",
      FreelancerDetailNavProject: "FreelancerDetailNavProject",
      FreelancerDetailNavResume: "FreelancerDetailNav",
      freelancerDetailNavLst: ["프로젝트", "이력서"],
      freelancerDetailLst: ["프로젝트item", "이력서item"],
      freelancerEducation: {}
      // freelancerEducation: {
      //   careerList: [
      //     {
      //       companyName: "(주)엠로",
      //       department: "웹개발부",
      //       end_date: "2020-02-01",
      //       position: "수석연구원",
      //       start_date: "2015-03-01"
      //     }
      //   ],
      //   certificateList: [
      //     {
      //       certification: "한국산업인력공단",
      //       date: "2014-11-01",
      //       name: "정보처리기사"
      //     }
      //   ],
      //   education: {
      //     highschool: "싸피고등학교",
      //     highschool_end_date: "2010-02-01",
      //     highschool_start_date: "2007-03-01",
      //     major: "컴퓨터공학과",
      //     university: "싸피대학교",
      //     university_end_date: "2015-02-01",
      //     university_start_date: "2010-03-01"
      //   }
      // }
    };
  },
  async mounted() {
    let id__ = String(this.id_);
    this.freelancerProjectModalId += id__;
    this.freelancerProjectModalCtnrId += id__;
    this.carouselWrapperMine += id__;
    this.carouselMine += id__;
    this.FreelancerDetailNavProject += id__;
    this.FreelancerDetailNavResume += id__;
    this.projectDetailNavItem += id__;
    this.resumeDetailNavItem += id__;
    this.normalProjectFreelancerModal += id__;
    this.sureSelectProjectFreelancer += id__;
    for (let i = 0; i < this.freelancerDetailReceive.name.length; i++) {
      if (i == 1) this.nameErase += "*";
      else this.nameErase += this.freelancerDetailReceive.name[i];
    }
    // console.log(this.nameErase);
    for (let i = 0; i < this.freelancerDetailReceive.estimate.length; i++) {
      this.profession += this.freelancerDetailReceive.estimate[i].profession;
      this.ontime += this.freelancerDetailReceive.estimate[i].ontime;
      this.active += this.freelancerDetailReceive.estimate[i].active;
      this.communication += this.freelancerDetailReceive.estimate[
        i
      ].communication;
      this.reEmployment += this.freelancerDetailReceive.estimate[
        i
      ].reEmployment;
    }
    this.profession = this.profession / this.freelancerDetailReceive.estimate.length;
    this.ontime = this.ontime / this.freelancerDetailReceive.estimate.length;
    this.active = this.active / this.freelancerDetailReceive.estimate.length;
    this.communication = this.communication / this.freelancerDetailReceive.estimate.length;
    this.reEmployment = this.reEmployment / this.freelancerDetailReceive.estimate.length;
    this.ratingToPercent =
      (this.profession +
        this.ontime +
        this.active +
        this.communication +
        this.reEmployment) /
      5
    this.ratingToPercent = this.ratingToPercent * 20;
    await userInstance.getUserResume(
      this.freelancerDetailReceive.username,
      res => {
        res.data.isData = true;
        this.freelancerEducation = res.data;
      },
      err => {
        // console.log("이거 실행 안됨?");
        const data = {
          isData: false,
          careerList: [],
          certificateList: [],
          education: {
            highschool: "---",
            highschool_end_date: "2020-01-01",
            highschool_start_date: "2000-01-01",
            major: "",
            university: "---",
            university_end_date: "2020-01-01",
            university_start_date: "2000-01-01"
          }
        };
        this.freelancerEducation = data;
      }
    );
    this.freelancerDetailReceive.education = this.freelancerEducation;
    this.isDataLoad = true;
  },
  props: {
    freelancerDetailReceive: Object,
    id_: Number
  },
  methods: {
    goInfoCorrectPage() {
      this.$router.push({
        name: "correctmycareer",
        params: { originalUserInfo: this.freelancerDetailReceive }
      });
    },
    clickFreelancerDetailNavProject() {
      let removeProjectDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavProject
      );
      let removeResumeDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavResume
      );
      let ResumeDetailItem = document.querySelector(
        "#" + this.resumeDetailNavItem
      );
      let ProjectDetailItem = document.querySelector(
        "#" + this.projectDetailNavItem
      );
      if (
        !removeProjectDetailItem.classList.contains("activeProjectDetailNav")
      ) {
        console.log("이거는 됨?2");
        removeProjectDetailItem.classList.add("activeProjectDetailNav");
        removeResumeDetailItem.classList.remove("activeProjectDetailNav");
        ResumeDetailItem.classList.add("deactiveProjectDetailItem");
        ProjectDetailItem.classList.remove("deactiveProjectDetailItem");
      }
    },
    clickFreelancerDetailNavResume() {
      let removeProjectDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavProject
      );
      let removeResumeDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavResume
      );
      let ResumeDetailItem = document.querySelector(
        "#" + this.resumeDetailNavItem
      );
      let ProjectDetailItem = document.querySelector(
        "#" + this.projectDetailNavItem
      );

      if (
        !removeResumeDetailItem.classList.contains("activeProjectDetailNav")
      ) {
        console.log("이거는 됨?1");
        removeResumeDetailItem.classList.add("activeProjectDetailNav");
        removeProjectDetailItem.classList.remove("activeProjectDetailNav");
        ProjectDetailItem.classList.add("deactiveProjectDetailItem");
        ResumeDetailItem.classList.remove("deactiveProjectDetailItem");
      }
    }
  }
};
</script>

<style>
.deactiveProjectDetailItem {
  display: none;
}
.info-change-btn {
  background-color: #5d8aff;
  color: white;
  font-weight: 24px;
  border: none;
  padding: 3px 10px 3px 10px;
  border-radius: 5px;
}
.resume-add-btn {
  background-color: #5d8aff;
  color: white;
  font-weight: 24px;
  border: none;
  padding: 3px 10px 3px 10px;
  border-radius: 5px;
}
.project-add-btn {
  background-color: #5d8aff;
  color: white;
  font-weight: 24px;
  border: none;
  padding: 3px 10px 3px 10px;
  border-radius: 5px;
}
#freelancer-detail {
  margin: 0 auto;
  margin-top: 50px;
  border-radius: 30px;
  max-width: 800px;
  height: 500px;
  border: 1px solid rgb(209, 207, 207);
  background-color: rgb(219, 219, 217);
  padding: 30px;
}
#project-resume {
  margin-top: 30px;
}
#project-resume-nav {
  margin: 0 auto;
  width: 800px;
}

#freelancerDetailResumeImg > img {
  border-radius: 60px;
  margin-left: 20px;
  margin-right: 30px;
  margin-top: 45px;
  width: 120px;
}

.project-resume-contents-data {
  margin: 0 auto;
  width: 800px;
  padding: 20px;
}

#freelancer-name {
  margin-top: 10px;
}
#freelancer-grade {
  height: 150px;
  margin-top: 10px;
  background-color: rgb(245, 244, 176);
}
#freelancer-intro {
  margin-top: 20px;
}

#freelancerDetailHeadCtnr {
  border-radius: 20px;
  background-color: rgb(241, 241, 241);
}

#freelancerDetailCtnr {
  width: 85%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 30px;
  margin-bottom: 30px;
}

#freelancerDetailModalContent {
  border-radius: 20px;
  height: 650px;
  margin: auto !important;
  overflow-y: scroll;
}

#freelancerDetailModalContent::-webkit-scrollbar {
  width: 0px !important;
}

.lightGrayLetter {
  color: gray;
}

.starScore {
  width: 40px;
}

.subScoreLetter {
  font-size: 13px;
}

.freelancerEducationItem {
  margin-left: 100px;
  font-size: 15px;
}

.freelancerEducationName {
  width: 150px;
  text-align: start;
  font-size: 15px;
}

.freelancerFloatBtn {
  position: fixed;
  top: 620px;
  right: 673px;
  width: 200px !important;
}

.freelancerProjectModalCtnr {
  z-index: -1;
  position: fixed;
  top: 0px;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.1);
}


.carousel-wrapper-mine {
  overflow: hidden;
}
.carousel-wrapper-mine > .carousel-mine {
  display: flex;
  transform: translate3d(0, 0, 0);
  transition: transform 0.2s;
}


</style>
