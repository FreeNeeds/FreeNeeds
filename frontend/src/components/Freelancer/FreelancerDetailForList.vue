<template>
  <div
    class="modal text-center"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="false"
    style="background-color: rgba(0, 0, 0, 0.15);"
    id="freelancerListDetailModal"
  >
    <div
      class="modal-dialog modal-lg"
      id="freelancerModalWrapper"
      v-if="isDataLoad"
    >
      <div class="modal-content" id="freelancerDetailModalContent">
        <button
          type="button"
          id="freelancerDetailModalCloseBtn"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
          @click="closeFreelancerDetailModal"
        ></button>

        <div id="freelancerDetailCtnr">
          <div class="container my-4 py-4" id="freelancerDetailHeadCtnr">
            <div class="row m-2">
              <h4 class="text-start fw-bold">
                {{ freelancerInfoDetail.resume.title }}
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
                경력 {{ freelancerInfoDetail.resume.career_period }}년
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
                <hr
                  style="background-color : black; height: 1.5px; margin : 3px"
                />
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
              <div
                class="d-inline-block mx-auto my-3"
                style="width : 229px !important"
              >
                <FreelancerCardSkill
                  v-for="skillItem in freelancerInfoDetail.tech"
                  :key="`id${freelancerInfoDetail.userId}${skillItem}`"
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
                {{ freelancerInfoDetail.resume.introduce }}
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
            <FreelancerProjectCard
              v-for="freelancerProjectCard in projectDetailValue"
              :key="freelancerProjectCard.id"
              :freelancerProjectCard="freelancerProjectCard"
            >
            </FreelancerProjectCard>
          </div>
          <div :id="resumeDetailNavItem" class="deactiveProjectDetailItem">
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
              style="margin-bottom : 60px"
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
          <div class="row mt-4 justify-content-center">
            <button
              @click="openProjectModal"
              id="ProjectDetailApplyBtn"
              class="freelancerFloatBtn"
              v-if="loginType == 'company'"
            >
              인터뷰 요청하기
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FreelancerProjectCard from "@/components/Freelancer/FreelancerProject/FreelancerProjectCard.vue";
import FreelancerCardSkill from "./FreelancerCardSkill.vue";
import ProjectCardCarousel from "../Project/ProjectCardCarousel.vue";
import { mapGetters, mapActions } from "vuex";
import * as userInstance from "@/api/user.js";
import * as projectInstance from "@/api/project.js";
export default {
  watch: {
    async freelancerInfoDetail() {
      await userInstance.getUserResume(
        this.freelancerInfoDetail.username,
        res => {
          this.freelancerEducation = res.data;
        },
        err => {
          const data = {
            careerList: [],
            certificateList: [],
            education: {
              highschool: "---",
              highschool_end_date: "",
              highschool_start_date: "",
              major: "",
              university: "---",
              university_end_date: "",
              university_start_date: ""
            }
          };
          this.freelancerEducation = data;
        }
      );
    }
  },
  computed: {
    ...mapGetters(["loginType", "loginUserInfo", "freelancerInfoDetail"]),
    nameErase() {
      let nameErasedata = "";
      for (let i = 0; i < this.freelancerInfoDetail.name.length; i++) {
        if (i == 1) nameErasedata += "*";
        else nameErasedata += this.freelancerInfoDetail.name[i];
      }
      return nameErasedata;
    },
    projectDetailValue() {
      let projectDetailTemp = [];
      for (let i = 0; i < this.freelancerInfoDetail.projectCareer.length; i++) {
        let tempdata = {};
        tempdata.body = this.freelancerInfoDetail.projectCareer[i];
        tempdata.id = "FDR" + i;
        // console.log(this.freelancerInfoDetail.projectCareer[i]);
        projectDetailTemp.push(tempdata);
      }
      return projectDetailTemp;
    },
    freelancerProjectModalId() {
      return "freeProModal" + this.freelancerInfoDetail.userId;
    },
    freelancerProjectModalCtnrId() {
      return "freeProModalCtnr" + this.freelancerInfoDetail.userId;
    },
    carouselWrapperMine() {
      return "carouselWrpp" + this.freelancerInfoDetail.userId;
    },
    carouselMine() {
      return "carousel" + this.freelancerInfoDetail.userId;
    },
    FreelancerDetailNavProject() {
      return "FreelancerDetailNavProject" + this.freelancerInfoDetail.userId;
    },
    FreelancerDetailNavResume() {
      return "FreelancerDetailNav" + this.freelancerInfoDetail.userId;
    },
    projectDetailNavItem() {
      return "프로젝트item" + this.freelancerInfoDetail.userId;
    },
    resumeDetailNavItem() {
      return "이력서item" + this.freelancerInfoDetail.userId;
    },
    normalProjectFreelancerModal() {
      return "normalProjectFreelancerModal" + this.freelancerInfoDetail.userId;
    },
    sureSelectProjectFreelancer() {
      return "sureSelectProjectFreelancer" + this.freelancerInfoDetail.userId;
    },
    profession() {
      let data = 0;
      for (let i = 0; i < this.freelancerInfoDetail.estimate.length; i++) {
        data += this.freelancerInfoDetail.estimate[i].profession;
      }
      return data / this.freelancerInfoDetail.estimate.length;
    },
    ontime() {
      let data = 0;
      for (let i = 0; i < this.freelancerInfoDetail.estimate.length; i++) {
        data += this.freelancerInfoDetail.estimate[i].ontime;
      }
      return data / this.freelancerInfoDetail.estimate.length;
    },
    active() {
      let data = 0;
      for (let i = 0; i < this.freelancerInfoDetail.estimate.length; i++) {
        data += this.freelancerInfoDetail.estimate[i].active;
      }
      return data / this.freelancerInfoDetail.estimate.length;
    },
    communication() {
      let data = 0;
      for (let i = 0; i < this.freelancerInfoDetail.estimate.length; i++) {
        data += this.freelancerInfoDetail.estimate[i].communication;
      }
      return data / this.freelancerInfoDetail.estimate.length;
    },
    reEmployment() {
      let data = 0;
      for (let i = 0; i < this.freelancerInfoDetail.estimate.length; i++) {
        data += this.freelancerInfoDetail.estimate[i].reEmployment;
      }
      return data / this.freelancerInfoDetail.estimate.length;
    },
    ratingToPercent() {
      let professionTemp = 0;
      let ontimeTemp = 0;
      let activeTemp = 0;
      let communicationTemp = 0;
      let reEmploymentTemp = 0;
      let toreturn = 0;
      for (let i = 0; i < this.freelancerInfoDetail.estimate.length; i++) {
        professionTemp += this.freelancerInfoDetail.estimate[i].profession;
        ontimeTemp += this.freelancerInfoDetail.estimate[i].ontime;
        activeTemp += this.freelancerInfoDetail.estimate[i].active;
        communicationTemp += this.freelancerInfoDetail.estimate[i]
          .communication;
        reEmploymentTemp += this.freelancerInfoDetail.estimate[i].reEmployment;
      }
      professionTemp =
        professionTemp / this.freelancerInfoDetail.estimate.length;
      ontimeTemp = ontimeTemp / this.freelancerInfoDetail.estimate.length;
      activeTemp = activeTemp / this.freelancerInfoDetail.estimate.length;
      communicationTemp =
        communicationTemp / this.freelancerInfoDetail.estimate.length;
      reEmploymentTemp =
        reEmploymentTemp / this.freelancerInfoDetail.estimate.length;
      toreturn =
        (professionTemp +
          ontimeTemp +
          activeTemp +
          communicationTemp +
          reEmploymentTemp) /
        5;
      toreturn = toreturn * 20;
      return toreturn;
    }
  },
  name: "FreelancerDetail",
  components: {
    FreelancerProjectCard,
    FreelancerCardSkill,
    ProjectCardCarousel
  },
  data() {
    return {
      isDataLoad: false,
      idx: 0,
      // nameErase: "",
      selectProjectFreelancerName: "",

      // profession: 0,
      // ontime: 0,
      // active: 0,
      // communication: 0,
      // reEmployment: 0,
      // ratingToPercent: 0,
      myProjectLst: [],
      // projectDetailValue: [],
      // projectData: {}

      freelancerDetailNavLst: ["프로젝트", "이력서"],
      freelancerDetailLst: ["프로젝트item", "이력서item"]
    };
  },
  async mounted() {
    await userInstance.getUserResume(
      this.freelancerInfoDetail.username,
      res => {
        this.freelancerEducation = res.data;
      },
      err => {
        const data = {
          careerList: [],
          certificateList: [],
          education: {
            highschool: "---",
            highschool_end_date: "",
            highschool_start_date: "",
            major: "",
            university: "---",
            university_end_date: "",
            university_start_date: ""
          }
        };
        this.freelancerEducation = data;
      }
    );
    if (this.loginType == "company") {
      let ProjectList = [];
      const filter = projectInstance.getProjectList();
    }
    this.isDataLoad = true;
  },

  methods: {
    // ...mapActions(["setIsModalOn"]),
    closeFreelancerDetailModal() {
      // this.setIsModalOn(false);
    },
    openProjectModal() {
      let freelancerProjectModalCtnrTmp = document.querySelector(
        "#" + this.freelancerProjectModalCtnrId
      );
      let freelancerProjectModalTmp = document.querySelector(
        "#" + this.freelancerProjectModalId
      );
      freelancerProjectModalCtnrTmp.setAttribute("style", "z-index : 2");
      freelancerProjectModalTmp.setAttribute("style", "display : block");
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
        removeResumeDetailItem.classList.add("activeProjectDetailNav");
        removeProjectDetailItem.classList.remove("activeProjectDetailNav");
        ProjectDetailItem.classList.add("deactiveProjectDetailItem");
        ResumeDetailItem.classList.remove("deactiveProjectDetailItem");
      }
    },
    prevBtnClick() {
      if (this.idx === 0) this.idx = this.myProjectLst.length - 1;
      else this.idx--;
      document.querySelector("#" + this.carouselMine).style.transform =
        "translate3d(" + -640 * this.idx + "px, 0, 0)";
    },
    nextBtnClick() {
      if (this.idx === this.myProjectLst.length - 1) this.idx = 0;
      else this.idx++;
      document.querySelector("#" + this.carouselMine).style.transform =
        "translate3d(" + -640 * this.idx + "px, 0, 0)";
    },
    clickSelectProjectFreelancer() {
      this.selectProjectFreelancerName = this.myProjectLst[this.idx].body.title;
      let normalProjectFreelancerModalTmp = document.querySelector(
        "#" + this.normalProjectFreelancerModal
      );
      let sureSelectProjectFreelancerTmp = document.querySelector(
        "#" + this.sureSelectProjectFreelancer
      );
      let freelancerProjectModalTmp = document.querySelector(
        "#" + this.freelancerProjectModalId
      );
      freelancerProjectModalTmp.setAttribute(
        "style",
        "width: 600px; height: 250px; right: 475px; display: block"
      );
      normalProjectFreelancerModalTmp.classList.add("d-none");
      sureSelectProjectFreelancerTmp.classList.remove("d-none");
    },
    clickSelectProjectFreelancerCloseModal() {
      let freelancerProjectModalCtnrTmp = document.querySelector(
        "#" + this.freelancerProjectModalCtnrId
      );
      let freelancerProjectModalTmp = document.querySelector(
        "#" + this.freelancerProjectModalId
      );
      freelancerProjectModalCtnrTmp.setAttribute("style", "z-index : -1");
      freelancerProjectModalTmp.setAttribute("style", "display : none");
    },
    clickSureSelectProjectFreelancer() {
      let freelancerProjectModalCtnrTmp = document.querySelector(
        "#" + this.freelancerProjectModalCtnrId
      );
      let freelancerProjectModalTmp = document.querySelector(
        "#" + this.freelancerProjectModalId
      );
      let normalProjectFreelancerModalTmp = document.querySelector(
        "#" + this.normalProjectFreelancerModal
      );
      let sureSelectProjectFreelancerTmp = document.querySelector(
        "#" + this.sureSelectProjectFreelancer
      );
      freelancerProjectModalCtnrTmp.setAttribute("style", "z-index : -1");
      freelancerProjectModalTmp.setAttribute("style", "display : none");

      freelancerProjectModalTmp.setAttribute(
        "style",
        "width: 900px; height: 400px; right: 325px;"
      );
      normalProjectFreelancerModalTmp.classList.remove("d-none");
      sureSelectProjectFreelancerTmp.classList.add("d-none");
    },

    clickNotYetSelectProjectFreelancer() {
      let freelancerProjectModalCtnrTmp = document.querySelector(
        "#" + this.freelancerProjectModalCtnrId
      );
      let freelancerProjectModalTmp = document.querySelector(
        "#" + this.freelancerProjectModalId
      );
      let normalProjectFreelancerModalTmp = document.querySelector(
        "#" + this.normalProjectFreelancerModal
      );
      let sureSelectProjectFreelancerTmp = document.querySelector(
        "#" + this.sureSelectProjectFreelancer
      );
      freelancerProjectModalCtnrTmp.setAttribute("style", "z-index : -1");
      freelancerProjectModalTmp.setAttribute("style", "display : none");

      freelancerProjectModalTmp.setAttribute(
        "style",
        "width: 900px; height: 400px; right: 325px;"
      );
      normalProjectFreelancerModalTmp.classList.remove("d-none");
      sureSelectProjectFreelancerTmp.classList.add("d-none");
    }
  }
};
</script>

<style>
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

#freelancerDetailModalCloseBtn {
  position: fixed;
  top: 55px;
  right: 400px;
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

.freelancerProjectModal {
  position: fixed;
  top: 140px;
  right: 325px;
  background-color: white;
  border-radius: 20px;
  height: 400px;
  border: 1px solid lightgray;
  width: 900px;
  margin: auto;
  display: none;
}

.carousel-wrapper-mine {
  width: 640px !important;
  height: 219px !important;
  overflow: hidden;
}

.carousel-wrapper-mine > .carousel-mine {
  display: flex;
  transform: translate3d(0, 0, 0);
  transition: transform 0.2s;
}

.prev {
  position: fixed;
  top: 265px;
  left: 360px;
  height: 219px;
  background-color: white;
  border: 0px;
}

.next {
  position: fixed;
  top: 265px;
  right: 370px;
  height: 219px;
  background-color: white;
  border: 0px;
}

#selectProjectFreelancerCloseModal {
  position: fixed;
  top: 160px;
  right: 350px;
}
</style>
