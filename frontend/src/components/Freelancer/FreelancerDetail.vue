<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="freelancerModalWrapper">
      <div class="modal-content" id="freelancerDetailModalContent">
        <button type="button" id="freelancerDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
            <FreelancerDetailNav
             v-for="FreelancerDetailNavItem in freelancerDetailNavLst"
             :key="FreelancerDetailNavItem"
             :FreelancerDetailNavItem="FreelancerDetailNavItem"
             class="col-2 projectDetailNav"
             @deactive=deactive 
            >
            </FreelancerDetailNav>
          </div>
          <hr class="project-card-line" style="margin-bottom : 40px">
          <div id="프로젝트item">
            <FreelancerProjectCard
            v-for="freelancerProjectCard in freelancerDetailReceive.projectCareer"
            :key="freelancerProjectCard.id"
            :freelancerProjectCard="freelancerProjectCard"
            >
            </FreelancerProjectCard>
          </div>
          <div id="이력서item" class="deactiveProjectDetailItem">
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
          <div class="row mt-4 justify-content-center">
            <button @click="openProjectModal" id="ProjectDetailApplyBtn" class="freelancerFloatBtn">인터뷰 요청하기</button>
          </div> 
        </div>
      </div>
    </div>
    <div id="freelancerProjectModalCtnr">
      <div id="freelancerProjectModal">
        <h5 class="mt-4"><h3 class="fw-bold d-inline-block">{{ nameErase }}</h3> 님에게 제안할 프로젝트를 골라주세요</h5>
        <div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
          <div class="carousel-inner px-3">
            <ProjectCardCarousel
            v-for="projectCardCarousel in myProjectLst"
            :key="projectCardCarousel.id"
            :projectCardCarousel="projectCardCarousel"
            :projectData="projectData"
            class="carousel-item"
            ></ProjectCardCarousel>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-left" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
            </svg>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-right" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
            </svg>
            <span class="visually-hidden">Next</span>
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
import FreelancerResume from "@/components/Freelancer/FreelancerResume.vue";
import InterviewBtn from "@/components/Freelancer/Interview/InterviewBtn.vue";
import FreelancerCardSkill from "./FreelancerCardSkill.vue";
import FreelancerDetailNav from "@/components/Freelancer/FreelancerDetailNav.vue";
import ProjectCardCarousel from "../Project/ProjectCardCarousel.vue";

export default {
  name: "FreelancerDetail",
  components: {
    HeaderNav,
    FooterNav,
    FreelancerProjectCard,
    FreelancerResume,
    InterviewBtn,
    FreelancerCardSkill,
    FreelancerDetailNav,
    ProjectCardCarousel
  },
  data() {
    return{
      nameErase : "",
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
    freelancerDetailReceive : Object
  },  
  methods: {
    openProjectModal() {
      let freelancerProjectModalCtnrTmp = document.querySelector('#freelancerProjectModalCtnr')
      freelancerProjectModalCtnrTmp.setAttribute("style","z-index : 2") 
    },
    deactive(value) {
      for (let i = 0; i < 2; i++) {
        let removeProjectDetailItem = document.querySelector("#" + this.freelancerDetailNavLst[i])
        let ProjectDetailItem = document.querySelector("#" + this.freelancerDetailLst[i])
        if (ProjectDetailItem.classList.contains("deactiveProjectDetailItem"))
          ProjectDetailItem.classList.remove("deactiveProjectDetailItem")
        if (removeProjectDetailItem.classList.contains("activeProjectDetailNav"))
          removeProjectDetailItem.classList.remove("activeProjectDetailNav")
        if (this.freelancerDetailLst[i] != value + "item") {
          ProjectDetailItem.classList.add("deactiveProjectDetailItem")
        }
      }
    },
  },
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
    margin-left : 20px;
    margin-right : 30px;
    margin-top : 45px;
    width : 120px;
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
    width : 85%;
    margin-left : auto;
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
    color : gray;
  }

  .starScore {
    width : 40px;
  }

  .subScoreLetter { 
    font-size : 13px;
  }

  .freelancerEducationItem {
    margin-left : 100px;
    font-size : 15px
  }

  .freelancerEducationName {
    width : 150px;
    text-align : start;
    font-size : 15px
  }

  #freelancerDetailModalCloseBtn {
    position: fixed;
    top : 55px;
    right : 400px;
  }

  .freelancerFloatBtn {
    position: fixed;
    top : 620px;
    right : 673px;
    width : 200px !important;
  }

  #freelancerProjectModalCtnr {
    z-index: -1;
    position : fixed;
    top: 0px;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0,0,0,0.1);
  }

  #freelancerProjectModal {
    position: fixed;
    top: 130px;
    right: 490px;
    background-color: white;
    border-radius: 20px;
    height: 400px; 
    border: 1px solid lightgray;
    width: 600px;
    margin: auto;
  }
</style>
