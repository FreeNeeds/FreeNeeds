<template>
  <div
    class="modal text-center"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="false"
    style="background-color: rgba(0, 0, 0, 0.15);"
  >
    <div class="modal-dialog modal-lg" id="freelancerModalWrapper">
      <div class="modal-content" id="freelancerDetailModalContent">
        <button
          type="button"
          id="freelancerDetailModalCloseBtn"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
        ></button>
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
                  v-for="skillItem in freelancerDetailReceive.tech"
                  :key="`id${id_}${skillItem}`"
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
            <div class="d-flex mx-4  my-2">
              <div class="freelancerEducationName">
                {{ freelancerEducation.education.highschool }}
              </div>
              <div class="text-start freelancerEducationItem">
                {{ freelancerEducation.education.highschool_start_date }} ~
                {{ freelancerEducation.education.highschool_end_date }}
              </div>
            </div>
            <div class="d-flex mx-4 my-2">
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
              class="d-flex mx-4 my-2"
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
              class="d-flex mx-4 mt-2"
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
    <div class="freelancerProjectModalCtnr" :id="freelancerProjectModalCtnrId">
      <div class="freelancerProjectModal" :id="freelancerProjectModalId">
        <div class="d-block" :id="normalProjectFreelancerModal">
          <button
            @click="clickSelectProjectFreelancerCloseModal"
            type="button"
            id="selectProjectFreelancerCloseModal"
            class="btn-close"
          ></button>
          <h5 class="mt-5">
            <h3 class="fw-bold d-inline-block">{{ nameErase }}</h3>
            님에게 제안할 프로젝트를 골라주세요
          </h5>
          <div
            class="carousel-wrapper-mine mx-auto mt-4"
            data-bs-touch="false"
            :id="carouselWrapperMine"
          >
            <div class="carousel-mine" :id="carouselMine">
              <ProjectCardCarousel
                v-for="projectCardCarousel in myProjectLst"
                :key="projectCardCarousel.id"
                :projectCardCarousel="projectCardCarousel"
                :projectData="projectData"
              ></ProjectCardCarousel>
            </div>
            <button
              @click="prevBtnClick"
              class="prev"
              type="button"
              data-bs-target="#carouselExampleControlsNoTouching"
              data-bs-slide="prev"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="25"
                height="25"
                fill="black"
                class="bi bi-chevron-left"
                viewBox="0 0 16 16"
              >
                <path
                  fill-rule="evenodd"
                  d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"
                />
              </svg>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              @click="nextBtnClick"
              class="next"
              type="button"
              data-bs-target="#carouselExampleControlsNoTouching"
              data-bs-slide="next"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="25"
                height="25"
                fill="black"
                class="bi bi-chevron-right"
                viewBox="0 0 16 16"
              >
                <path
                  fill-rule="evenodd"
                  d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"
                />
              </svg>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
          <button
            @click="clickSelectProjectFreelancer"
            class="ProjectApplyBtn my-3"
          >
            선택
          </button>
        </div>
        <div class="d-none" :id="sureSelectProjectFreelancer">
          <h5 class="mt-5">
            <h3 class="fw-bold d-inline-block">{{ nameErase }}</h3>
            님에게
            <h4 class="fw-bold text-primary mt-2 mb-3">
              "{{ selectProjectFreelancerName }}"
            </h4>
            프로젝트를 제안하시겠습니까?
          </h5>
          <button
            @click="clickSureSelectProjectFreelancer"
            class="ProjectApplyBtn my-3 mx-2"
          >
            네
          </button>
          <button
            @click="clickNotYetSelectProjectFreelancer"
            class="ProjectApplyBtn my-3 mx-2"
          >
            아니요
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FreelancerProjectCard from "@/components/Freelancer/FreelancerProject/FreelancerProjectCard.vue";
import FreelancerCardSkill from "./FreelancerCardSkill.vue";
import ProjectCardCarousel from "../Project/ProjectCardCarousel.vue";
import { mapGetters } from "vuex";
import * as userInstance from "@/api/user.js";
import * as projectInstance from "@/api/project.js";
export default {
  computed: {
    ...mapGetters(["loginType", "loginUserInfo"])
  },
  name: "FreelancerDetail",
  components: {
    HeaderNav,
    FooterNav,
    FreelancerProjectCard,
    FreelancerCardSkill,
    ProjectCardCarousel
  },
  data() {
    return {
      idx: 0,
      nameErase: "",
      selectProjectFreelancerName: "",
      freelancerProjectModalId: "freeProModal",
      freelancerProjectModalCtnrId: "freeProModalCtnr",
      carouselWrapperMine: "carouselWrpp",
      carouselMine: "carousel",
      normalProjectFreelancerModal: "normalProjectFreelancerModal",
      sureSelectProjectFreelancer: "sureSelectProjectFreelancer",
      FreelancerDetailNavProject: "FreelancerDetailNavProject",
      FreelancerDetailNavResume: "FreelancerDetailNav",
      projectDetailNavItem: "프로젝트item",
      resumeDetailNavItem: "이력서item",
      profession: 0,
      ontime: 0,
      active: 0,
      communication: 0,
      reEmployment: 0,
      ratingToPercent: 0,
      myProjectLst: [],
      projectDetailValue: [],
      // projectData: {}
      projectData: {
        id: "1",
        category: "개발",
        demain: "웹사이트",
        location: "대한민국 어딘가...",
        skill: ["Java", "Mysql", "SpringBoot"],
        title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
        content: "AI기반 Firescout 솔루션 ux/ui 디자인",
        startDate: new Date("2022-09-10"),
        endDate: new Date("2022-09-16"),
        startDateSummry: "2022-09-10",
        endDateSummry: "2022-09-16",
        deadline: new Date("2022-11-30"),
        recruitNumber: 3,
        task:
          "1) Native UI/UX <br> 2) 단말 내 시스템 연동 <br> 3) API 서버 연동",
        workstyle: "재택",
        workStartTime: "오전 08:00",
        workEndTime: "오후 16:00",
        lowPrice: "200만원",
        highPrice: "300만원",
        careerPeriod: 3
      },

      freelancerDetailNavLst: ["프로젝트", "이력서"],
      freelancerDetailLst: ["프로젝트item", "이력서item"],
      freelancerEducation: {
        careerList: [
          {
            companyName: "(주)엠로",
            department: "웹개발부",
            end_date: "2020-02-01",
            position: "수석연구원",
            start_date: "2015-03-01"
          }
        ],
        certificateList: [
          {
            certification: "한국산업인력공단",
            date: "2014-11-01",
            name: "정보처리기사"
          }
        ],
        education: {
          highschool: "싸피고등학교",
          highschool_end_date: "2010-02-01",
          highschool_start_date: "2007-03-01",
          major: "컴퓨터공학과",
          university: "싸피대학교",
          university_end_date: "2015-02-01",
          university_start_date: "2010-03-01"
        }
      }
    };
  },
  mounted() {
    // console.log(this.freelancerDetailReceive);
    this.projectDetailValue = [];
    for (
      let i = 0;
      i < this.freelancerDetailReceive.projectCareer.length;
      i++
    ) {
      let tempdata = {};
      tempdata.body = this.freelancerDetailReceive.projectCareer[i];
      tempdata.id = "FDR" + i;
      // console.log(this.freelancerDetailReceive.projectCareer[i]);
      this.projectDetailValue.push(tempdata);
    }

    // this.projectDetailValue.body = this.freelancerDetailReceive.projectCareer;
    let id__ = String(this.id_);
    // console.log(id__);
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

    this.profession =
      this.profession / this.freelancerDetailReceive.estimate.length;
    this.ontime = this.ontime / this.freelancerDetailReceive.estimate.length;
    this.active = this.active / this.freelancerDetailReceive.estimate.length;
    this.communication =
      this.communication / this.freelancerDetailReceive.estimate.length;
    this.reEmployment =
      this.reEmployment / this.freelancerDetailReceive.estimate.length;
    this.ratingToPercent =
      (this.profession +
        this.ontime +
        this.active +
        this.communication +
        this.reEmployment) /
      5;
    this.ratingToPercent = this.ratingToPercent * 20;
    userInstance.getUserResume(
      this.freelancerDetailReceive.username,
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

    for (let i = 0; i < 5; i++) {
      this.myProjectLst.push({
        id: "ids" + String(i),
        body: this.projectData
      });
    }
    if (this.loginType == "company") {
      let ProjectList = [];
      const filter = projectInstance.getProjectList();
    }
  },
  props: {
    freelancerDetailReceive: Object,
    id_: Number
  },
  methods: {
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
