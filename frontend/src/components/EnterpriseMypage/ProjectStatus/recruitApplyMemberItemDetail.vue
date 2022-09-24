<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="freelancerModalWrapper">
      <div class="modal-content" id="freelancerDetailModalContent">
        <button type="button" id="freelancerDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        <button @click="openContractPaper" id="ProjectDetailApplyBtn" class="freelancerFloatBtn">계약서 작성</button>
        <div id="myPageFreelancerDetailCtnr">
          <div id="freelancerDetailCtnr">
            <div class="container my-4 py-4" id="freelancerDetailHeadCtnr">
              <div class="row m-2"> <h4 class="text-start fw-bold">{{ freelancerDetailReceive.resume.title }}</h4></div>
              <div class="d-flex mx-4">
                <div class="d-inline-block"> {{ nameErase }} |</div>
                <div class="d-inline-block"> 
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
                  </div>|
                </div>
                <div class="d-inline-block mx-2"> 경력 {{ freelancerDetailReceive.resume.career_period }}년</div>
              </div>
              <div class="d-flex mt-4">
                <div class="d-inline-block" id="freelancerDetailResumeImg"><img src="https://placekitten.com/300/300" alt=""></div>
                <div class="d-inline-block" style="width: 270px">
                  <div class="d-flex mt-3 mb-2 justify-content-between">
                    <div class="d-inline-block fw-bold" style="margin-bottom : 2px; font-size: 17px;">활동평가</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2" style="margin-top: 1px">
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
                      <div class="d-inline-block lightGrayLetter mx-1 starScore">
                        <div>{{ Math.round((ratingToPercent) / 20 * 100) / 100 }}</div>
                      </div>
                    </div>
                  </div>
                  <hr style="background-color : black; height: 1.5px; margin : 3px">
                  <div class="d-flex my-1 justify-content-between">
                    <div class="d-inline-block subScoreLetter" style="margin-top : 2px">전문성</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2">
                        <div 
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: profession * 20 + '%' }"
                          >
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                      </div>
                      <div class="d-inline-block lightGrayLetter mx-1 starScore">
                        <div>{{ Math.round(profession * 100) / 100 }}</div>
                      </div>
                    </div>
                  </div>
                  <div class="d-flex my-1 justify-content-between">
                    <div class="d-inline-block subScoreLetter" style="margin-top : 2px">일정준수</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2">
                        <div 
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: ontime * 20 + '%' }"
                          >
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                      </div>
                      <div class="d-inline-block lightGrayLetter mx-1 starScore">
                        <div>{{ Math.round(ontime * 100) / 100 }}</div>
                      </div>
                    </div>
                  </div>
                  <div class="d-flex my-1 justify-content-between">
                    <div class="d-inline-block subScoreLetter" style="margin-top : 2px">적극성</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2">
                        <div 
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: active * 20 + '%' }"
                          >
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                      </div>
                      <div class="d-inline-block lightGrayLetter mx-1 starScore">
                        <div>{{ Math.round(active * 100) / 100 }}</div>
                      </div>
                    </div>
                  </div>
                  <div class="d-flex my-1 justify-content-between">
                    <div class="d-inline-block subScoreLetter" style="margin-top : 2px">의사소통</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2">
                        <div 
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: communication * 20 + '%' }"
                          >
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                      </div>
                      <div class="d-inline-block lightGrayLetter mx-1 starScore">
                        <div>{{ Math.round(communication * 100) / 100 }}</div>
                      </div>
                    </div>
                  </div>
                  <div class="d-flex my-1 justify-content-between">
                    <div class="d-inline-block subScoreLetter" style="margin-top : 2px">재고용의사</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2">
                        <div 
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: reEmployment * 20 + '%' }"
                          >
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                      </div>
                      <div class="d-inline-block lightGrayLetter mx-1 starScore">
                        <div>{{ Math.round(reEmployment * 100) / 100 }}</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="d-inline-block mx-1">
                  <div style="width: 1px; height: 87%; margin-top: 22px; background-color: gray"></div>
                </div>
                <div class="d-inline-block mx-auto my-3">
                  <FreelancerCardSkill
                  v-for="skillItem in freelancerDetailReceive.tech"
                  :key="skillItem"
                  :skillItem="skillItem"
                  >
                  </FreelancerCardSkill>
                </div>
              </div>
              <div class="row">
                <h5 class="fw-bold m-4 text-start">소개</h5>
              </div>
              <div class="row mx-3">
                <div class="text-start">{{ freelancerDetailReceive.resume.introduce }}</div>
              </div>
            </div>
            
            <div class="row" id="projectDetailNavCtnr">
              <div @click="clickFreelancerDetailNavProject" class="col-2 projectDetailNav activeProjectDetailNav" :id=FreelancerDetailNavProject>
                프로젝트
              </div> 
              <div @click="clickFreelancerDetailNavResume" class="col-2 projectDetailNav" :id=FreelancerDetailNavResume>
                이력서
              </div> 
            </div>
            <hr class="project-card-line" style="margin-bottom : 40px">
            <div :id=projectDetailNavItem>
              <FreelancerProjectCard
              v-for="freelancerProjectCard in freelancerDetailReceive.projectCareer"
              :key="freelancerProjectCard.id"
              :freelancerProjectCard="freelancerProjectCard"
              >
              </FreelancerProjectCard>
            </div>
            <div :id=resumeDetailNavItem class="deactiveProjectDetailItem">
              <div class="row mx-2 my-4">
                <div class="projectDetailHeadItem projectDetailItem">  학력</div>
              </div>
              <div class="d-flex mx-3 my-2">
                <div class="freelancerEducationName"> {{ freelancerEducation.education.highschool}} </div>
                <div class="text-start freelancerEducationItem"> {{ freelancerEducation.education.highschool_start_date }} ~ {{ freelancerEducation.education.highschool_end_date }}</div>
              </div>
              <div class="d-flex mx-3 my-2">
                <div class="freelancerEducationName"> {{ freelancerEducation.education.university}} </div>
                <div class="text-start freelancerEducationItem"> {{ freelancerEducation.education.university_start_date }} ~ {{ freelancerEducation.education.university_end_date }}</div>
              </div>
              <div class="row mx-2 my-4">
                <div class="projectDetailHeadItem projectDetailItem">  경력</div>
              </div>
              <div class="d-flex mx-3 my-2" 
              v-for="freelancerCareerItem in freelancerEducation.careerList"
              >
                <div class="freelancerEducationName">
                  {{ freelancerCareerItem.companyName }} 
                </div>
                <div class="freelancerEducationItem"> {{ freelancerCareerItem.start_date }} ~  {{ freelancerCareerItem.end_date }} </div>
              </div>
              <div class="row mx-2 my-4">
                <div class="projectDetailHeadItem projectDetailItem">  자격증</div>
              </div>
              <div class="d-flex mx-3 mt-2" style="margin-bottom : 60px" 
              v-for="freelancerCareerItem in freelancerEducation.certificateList"
              >
                <div class="freelancerEducationName">
                  {{ freelancerCareerItem.name }} 
                </div>
                <div class="freelancerEducationItem"> {{ freelancerCareerItem.date }}</div>
              </div>
            </div> 
          </div>
        </div>
      </div>
      <div style="width: 800px;height: 650px">
        <h3>표준근로계약서</h3>
        <div contenteditable="true" class="d-inline-block contractInput" style="width : 150px"></div>
        <p class="d-inline-block">(이하 "사업주"라 함)과(와) </p>
        <div contenteditable="true" class="d-inline-block contractInput" style="width : 150px"></div>
        <p class="d-inline-block"></p>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FreelancerProjectCard from "@/components/Freelancer/FreelancerProject/FreelancerProjectCard.vue";
import FreelancerCardSkill from "@/components/Freelancer/FreelancerCardSkill.vue";
import ProjectCardCarousel from "@/components/Project/ProjectCardCarousel.vue";

export default {
  name: "recruitApplyMemberItemDetail",
  components: {
    HeaderNav,
    FooterNav,
    FreelancerProjectCard,
    FreelancerCardSkill,
    ProjectCardCarousel
  },
  data() {
    return{
      idx : 0,
      nameErase : "",
      selectProjectFreelancerName : "",
      freelancerProjectModalId : "freeProModal",
      freelancerProjectModalCtnrId : "freeProModalCtnr",
      carouselWrapperMine : "carouselWrpp",
      carouselMine : "carousel",
      normalProjectFreelancerModal : "normalProjectFreelancerModal",
      sureSelectProjectFreelancer : "sureSelectProjectFreelancer",
      FreelancerDetailNavProject : "FreelancerDetailNavProject",
      FreelancerDetailNavResume : "FreelancerDetailNav",
      projectDetailNavItem : "프로젝트item",
      resumeDetailNavItem : "이력서item",
      profession : 0,
      ontime : 0,
      active : 0,
      communication : 0,
      reEmployment : 0,
      ratingToPercent : 0,
      myProjectLst : [],
      projectData: {
        id: "1",
        category: "개발",
        demain: "웹사이트",
        location: "대한민국 어딘가...",
        skill: ["Java", "Mysql" ,"SpringBoot"],
        title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
        content: "AI기반 Firescout 솔루션 ux/ui 디자인",
        startDate: new Date("2022-09-10"),
        endDate: new Date("2022-09-16"),
        startDateSummry : "2022-09-10",
        endDateSummry : "2022-09-16",
        deadline: new Date("2022-11-30"),
        recruitNumber: 3,
        task: "1) Native UI/UX <br> 2) 단말 내 시스템 연동 <br> 3) API 서버 연동",
        workstyle: "재택",
        workStartTime: "오전 08:00",
        workEndTime: "오후 16:00",
        lowPrice: "200만원",
        highPrice: "300만원",
        careerPeriod: 3,
      },
      freelancerDetailNavLst : ["프로젝트","이력서"],
      freelancerDetailLst : ["프로젝트item","이력서item"],
      freelancerEducation : {
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
    }
  },
  mounted() {
    let id__ = String(this.id_)
    this.freelancerProjectModalId += id__
    this.freelancerProjectModalCtnrId += id__
    this.carouselWrapperMine += id__
    this.carouselMine += id__
    this.FreelancerDetailNavProject += id__
    this.FreelancerDetailNavResume += id__
    this.projectDetailNavItem += id__
    this.resumeDetailNavItem += id__
    this.normalProjectFreelancerModal += id__
    this.sureSelectProjectFreelancer += id__
    for (let i = 0; i < this.freelancerDetailReceive.name.length; i++){
      if (i == 1) this.nameErase += "*"
      else this.nameErase += this.freelancerDetailReceive.name[i]
    }
    for (let i = 0; i < this.freelancerDetailReceive.estimate.length; i++) {
      this.profession += this.freelancerDetailReceive.estimate[i].profession
      this.ontime += this.freelancerDetailReceive.estimate[i].ontime 
      this.active += this.freelancerDetailReceive.estimate[i].active
      this.communication += this.freelancerDetailReceive.estimate[i].communication 
      this.reEmployment += this.freelancerDetailReceive.estimate[i].reEmployment
    }
    this.profession = this.profession / 5
    this.ontime = this.ontime / 5
    this.active = this.active / 5
    this.communication = this.communication / 5
    this.reEmployment = this.reEmployment / 5
    this.ratingToPercent = (this.profession + this.ontime + this.active + this.communication + this.reEmployment) / (this.freelancerDetailReceive.estimate.length)
    this.ratingToPercent = this.ratingToPercent * 20

    for(let i = 0; i < 5; i++) {
      this.myProjectLst.push({
        id : "ids" + String(i),
        body : this.projectData
      })
    }
  },
  props : {
    freelancerDetailReceive : Object,
    id_ : Number
  },  
  methods: {
    clickFreelancerDetailNavProject() {
      let removeProjectDetailItem = document.querySelector('#' + this.FreelancerDetailNavProject)
      let removeResumeDetailItem = document.querySelector("#" + this.FreelancerDetailNavResume)
      let ResumeDetailItem = document.querySelector('#' + this.resumeDetailNavItem)
      let ProjectDetailItem = document.querySelector('#' + this.projectDetailNavItem)
      if (!removeProjectDetailItem.classList.contains("activeProjectDetailNav")) {
          removeProjectDetailItem.classList.add("activeProjectDetailNav")
          removeResumeDetailItem.classList.remove("activeProjectDetailNav")
          ResumeDetailItem.classList.add('deactiveProjectDetailItem')
          ProjectDetailItem.classList.remove('deactiveProjectDetailItem')
      }

    },
    clickFreelancerDetailNavResume() {
      let removeProjectDetailItem = document.querySelector('#' + this.FreelancerDetailNavProject)
      let removeResumeDetailItem = document.querySelector("#" + this.FreelancerDetailNavResume)
      let ResumeDetailItem = document.querySelector('#' + this.resumeDetailNavItem)
      let ProjectDetailItem = document.querySelector('#' + this.projectDetailNavItem)

      if (!removeResumeDetailItem.classList.contains("activeProjectDetailNav")) {
          removeResumeDetailItem.classList.add("activeProjectDetailNav")
          removeProjectDetailItem.classList.remove("activeProjectDetailNav")
          ProjectDetailItem.classList.add('deactiveProjectDetailItem')
          ResumeDetailItem.classList.remove('deactiveProjectDetailItem')
      }
    },
    
    openContractPaper() {
      let freelancerProjectModalCtnrTmp = document.querySelector('#' + this.freelancerProjectModalCtnrId)
      let freelancerProjectModalTmp = document.querySelector('#' + this.freelancerProjectModalId)
      freelancerProjectModalCtnrTmp.setAttribute("style","z-index : 2")
      freelancerProjectModalTmp.setAttribute("style","display : block")
    }
  },
};
</script>

<style>
  .carousel-wrapper-myPage {
    width : 640px !important;
    height: 219px !important;
    overflow: hidden;

  }

  .carousel-wrapper-myPage > .carousel-mine {
    display : flex;
    transform: translate3d(0,0,0);
    transition: transform 0.2s;
  }

  .contractInput {
    border-left : 0px;
    border-right: 0px;
    border-top : 0px;
    outline: none;
  }

</style>