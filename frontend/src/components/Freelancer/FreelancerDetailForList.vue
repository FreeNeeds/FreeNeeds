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
      <div class="modal-content modal-content-freelancer-detail" id="freelancerDetailModalContent">
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
                <img :src=logo alt="" />
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
              style="margin-left : 0px !important"
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
              style="width : 200px !important; position : fixed; bottom : 11vh;"
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
          <div style="height : 0px">
            <button
              @click="clickSelectProjectFreelancerCloseModal"
              type="button"
              id="selectProjectFreelancerCloseModal"
              class="btn-close"
            ></button>
          </div>
          <h5 class="mt-5">
            <h3 class="fw-bold d-inline-block">{{ nameErase }}</h3>
            님에게 제안할 프로젝트를 골라주세요
          </h5>
          <div
            class="carousel-wrapper-mine mx-auto mt-4"
            style="width : 640px !important"
            data-bs-touch="false"
            :id="carouselWrapperMine"
          >
            <div class="carousel-mine" :id="carouselMine">
              <ProjectCardCarousel
                v-for="projectCardCarousel in myProjectLst"
                :key="projectCardCarousel.id"
                :projectCardCarousel="projectCardCarousel"
                :projectData="projectCardCarousel.body"
              ></ProjectCardCarousel>
            </div>
          </div>
          <div style="height : 0px">
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
            class="ProjectApplyBtn"
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
import FreelancerProjectCard from "@/components/Freelancer/FreelancerProject/FreelancerProjectCard.vue";
import FreelancerCardSkill from "./FreelancerCardSkill.vue";
import ProjectCardCarousel from "../Project/ProjectCardCarousel.vue";
import { mapGetters, mapActions } from "vuex";
import * as userInstance from "@/api/user.js";
import * as projectInstance from "@/api/project.js";
import * as applyInstance from "@/api/apply.js";
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
      // projectData: {
      //   id: "1",
      //   category: "개발",
      //   demain: "웹사이트",
      //   location: "대한민국 어딘가...",
      //   skill: ["Java", "Mysql", "SpringBoot"],
      //   title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
      //   content: "AI기반 Firescout 솔루션 ux/ui 디자인",
      //   startDate: new Date("2022-09-10"),
      //   endDate: new Date("2022-09-16"),
      //   startDateSummry: "2022-09-10",
      //   endDateSummry: "2022-09-16",
      //   deadline: new Date("2022-11-30"),
      //   recruitNumber: 3,
      //   task:
      //     "1) Native UI/UX <br> 2) 단말 내 시스템 연동 <br> 3) API 서버 연동",
      //   workstyle: "재택",
      //   workStartTime: "오전 08:00",
      //   workEndTime: "오후 16:00",
      //   lowPrice: "200만원",
      //   highPrice: "300만원",
      //   careerPeriod: 3
      // },
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
    console.log(document.querySelectorAll('.btn-close'))
    for (let item of document.querySelectorAll('.btn-close')) {
      item.addEventListener('click', () => {
        document.querySelector('body').style.overflow = 'scroll'
      })
    }
    await projectInstance.getCompanyProject(
      this.loginUserInfo.id,
      async res => {
        console.log(res);
        for (let i = 0; i < res.data.length; i++) {
          let projectdata = {
            id: res.data[i].projectId,
            category: res.data[i].category,
            demain: res.data[i].domain,
            locationSi: res.data[i].locationSi,
            locationGu: res.data[i].locationGu,
            skill: [],
            title: res.data[i].title,
            content: res.data[i].content,
            startDate: new Date(res.data[i].startDate),
            endDate: new Date(res.data[i].endDate),
            startDateSummry: res.data[i].startDate,
            endDateSummry: res.data[i].endDate,
            deadline: new Date(res.data[i].deadline),
            recruitNumber: res.data[i].recruitNumber,
            task: res.data[i].task,
            workstyle: res.data[i].workStyle,
            workStartTime: res.data[i].workStartTime,
            workEndTime: res.data[i].workEndTime,
            lowPrice: res.data[i].lowPrice + "FC",
            highPrice: res.data[i].highPrice + "FC",
            careerPeriod: res.data[i].careerPeriod
          };
          await projectInstance.getProjectTech(projectdata.id, res => {
            console.log(res);
            for (let j = 0; j < res.data.length; j++) {
              projectdata.skill.push(res.data[j].techName);
            }
          });
          this.myProjectLst.push({
            id: "ids" + i,
            body: projectdata
          });
        }
      }
    );
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

    // if (this.loginType == "company") {
    //   let ProjectList = [];
    //   const filter = projectInstance.getProjectList();
    // }
    this.isDataLoad = true;
  },
  props : {
    logo : String
  },
  methods: {
    // ...mapActions(["setIsModalOn"]),
    closeFreelancerDetailModal() {
      // this.setIsModalOn(false);
      document.querySelector('body').style.overflow = 'scroll'
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
        "width: 600px; height: 250px; left : 33vw !important; display: block"
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

      
      normalProjectFreelancerModalTmp.classList.remove("d-none");
      sureSelectProjectFreelancerTmp.classList.add("d-none");
      console.log(this.freelancerInfoDetail);
      const applydata = {
        projectId: this.myProjectLst[this.idx].body.id,
        state: "지원완료",
        userId: this.freelancerInfoDetail.userId
      };
      applyInstance.ApplyProject(applydata, res => {
        alert("인터뷰 요청이 완료되었습니다.");
      });
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
.projectDetailNav:hover {
  cursor: pointer;
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

#freelancerDetailModalCloseBtn {
  position: fixed;
  bottom : 87% !important;
  left : 72.5% !important;
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
  bottom: 33vh !important;
  left : 23vw !important;
  background-color: white;
  border-radius: 20px;
  height: 400px;
  border: 1px solid lightgray;
  width: 55vw;
  margin: auto;
  display: none;
}
.carousel-wrapper-mine {
  overflow: hidden;
}
.carousel-wrapper-mine > .carousel-mine {
  display: flex;
  transform: translate3d(0, 0, 0);
  transition: transform 0.2s;
}

.prev {
  position: relative;
  right: 350px;
  top : -245px;
  height : 234px;
  background-color: white;
  border: 0px;
}

.next {
  position: relative;
  left : 350px;
  top : -245px;
  height: 234px;
  background-color: white;
  border: 0px;
}

#selectProjectFreelancerCloseModal {
  position: relative !important;
  top : 10px;
  left  : 25.5vw;
}

.modal-content-freelancer-detail {
  width : 50vw !important;
  left : 25.5% !important;
}
</style>
