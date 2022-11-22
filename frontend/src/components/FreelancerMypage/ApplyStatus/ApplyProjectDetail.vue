<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="ProjectDetailModalWrapper">
      <div class="modal-content modal-content-project-show" id="ProjectDetailModalContent">
        <button @click="closeFreelancerDetail" type="button" id="ProjectDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        <div id="projectDetailCtnr">
          <div id="remainDateInProjectTitle" class="text-start"> {{ projectDataReceive.title}} </div>
          <div class="container my-4 py-2" id="projectDetailHeadCtnr">
            <div class="row mx-2 my-3 justify-content-between align-items-start">
              <div class="col-9">
                <div class="row">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">  모집인원</div>
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.recruitNumber}} 명</div>
                </div>  
                <div class="row">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">  경력기간</div>
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.careerPeriod}} 년</div>
                </div> 
                <div class="row">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">  근무기간</div>
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.startDateSummry }} ~ {{ projectDataReceive.endDateSummry }} ( {{ periodWork }} 일 )</div>
                </div>
                <div class="row">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">  근무방식</div>
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.workStyle}} </div>
                </div> 
                <div class="row">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">  금액</div>
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.lowPrice }} ~ {{ projectDataReceive.highPrice }}/월(근무 확정시, 단가 확정)</div>
                </div>
              </div>
              <div class="col-2 my-3 mx-3" id="remainDateWrapperInProjectDetail"> 
                <div class="my-2" id="remainDateWrapperInProjectDetailDate">
                  {{ remainDate }} 
                </div>
              </div>
            </div>  
          </div>
          <div class="row" id="projectDetailNavCtnr">
            <div @click="clickProjectDetailNavProject" class="col-2 projectDetailNav activeProjectDetailNav" :id=ProjectDetailNavProject>
              프로젝트
            </div>  
            <div @click="clickProjectDetailNavResume" class="col-2 projectDetailNav" :id=ProjectDetailNavResume>
              기업정보
            </div>
          </div>
          <hr class="project-card-line mb-4">
          <div :id=projectDetailNavItemProject>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  분야</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.category }}</div>
            </div>  
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  형태</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.domain }}</div>
            </div> 
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  담당업무 </div>
              <div class="col-8 projectDetailItem" id="taskItem"> {{ projectDataReceive.task }}</div>
            </div>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  기술</div>
              <div class="col-8 projectDetailItem">
                <ProjectDetailSkill
                v-for="skillItem in this.projectDataReceive.skill"
                :key="skillItem"
                :skillItem="skillItem"
                >
                </ProjectDetailSkill>
              </div>
            </div> 
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  프로젝트명</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.title }}</div>
            </div>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  근무시간</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.workStartTime }} ~ {{ projectDataReceive.workEndTime }}</div>
            </div>   
            <div class="row mx-2 my-2">
             <div class="col-3 projectDetailHeadItem projectDetailItem">  지역</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.locationSi }} {{ projectDataReceive.locationGu }}</div>
            </div>
          </div>
          <div :id=resumeDetailNavItemProject class="deactiveProjectDetailItem">
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  이름</div>
              <div class="col-8 projectDetailItem"> {{ companyDataReceive.name }}</div>
            </div>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  대표자</div>
              <div class="col-8 projectDetailItem"> {{ companyDataReceive.ceo }}</div>
            </div>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  주소</div>
              <div class="col-8 projectDetailItem"> {{ companyDataReceive.address }}</div>
            </div>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  전화번호</div>
              <div class="col-8 projectDetailItem"> {{ companyDataReceive.call }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import HeaderNav from '@/components/HeaderNav.vue';
  import FooterNav from '@/components/FooterNav.vue';
  import ProjectDetailNav from '@/components/Project/ProjectDetailNav.vue'
  import ProjectDetailSkill from '@/components/Project/ProjectDetailSkill.vue'
  import { createInstance } from "@/api/index.js";
  import { applyCompany } from '@/api/projectAPI'

  export default {
    name: 'ApplyProjectDetail',
    data() {
      return {
        ProjectDetailNavProject : "ProjectDetailNavProject",
        ProjectDetailNavResume : "ProjectDetailNavResume",
        projectDetailNavItemProject : "projectDetailNavItemProject",
        resumeDetailNavItemProject : "resumeDetailNavItemProject",
        applyModalCtnr : "applyModalCtnr",
        leftApply : "leftApply",
        completeApply : "completeApply",
        remainDate : "",
        periodWork : "",
        projectDetailNavLst : ["프로젝트","기업정보"],
        projectDetailLst: ["프로젝트item","기업정보item"]
      }
    },
    props : {
      projectDataReceive : Object,
      companyDataReceive : Object,
      idEdit : String
    },
    mounted() {
      this.ProjectDetailNavProject += this.idEdit
      this.ProjectDetailNavResume += this.idEdit
      this.projectDetailNavItemProject += this.idEdit
      this.resumeDetailNavItemProject += this.idEdit
      this.applyModalCtnr += this.idEdit
      this.leftApply += this.idEdit
      this.completeApply += this.idEdit
      
      this.projectDataReceive.skill = []
      createInstance().get('/project/tech/' + this.projectDataReceive.projectId).then(res =>{
        for (let i = 0; i < res.data.length; i++) {
          if (!this.projectDataReceive.skill.includes(res.data[i].techName)){
            this.projectDataReceive.skill.push(res.data[i].techName)
          }
        }
      })

      this.remainDate = Math.ceil((new Date(this.projectDataReceive.deadline).getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24) -
          1)
      this.remainDate = "D - " + String(this.remainDate)
      this.periodWork = parseInt((new Date(this.projectDataReceive.endDate).getTime() - new Date(this.projectDataReceive.startDate).getTime()) /
          (1000 * 60 * 60 * 24))
    },
    methods : {
      clickProjectDetailNavProject() {
        let removeProjectDetailItem = document.querySelector('#' + this.ProjectDetailNavProject)
        let removeResumeDetailItem = document.querySelector("#" + this.ProjectDetailNavResume)
        let ResumeDetailItem = document.querySelector('#' + this.resumeDetailNavItemProject)
        let ProjectDetailItem = document.querySelector('#' + this.projectDetailNavItemProject)
        if (!removeProjectDetailItem.classList.contains("activeProjectDetailNav")) {
            removeProjectDetailItem.classList.add("activeProjectDetailNav")
            removeResumeDetailItem.classList.remove("activeProjectDetailNav")
            ResumeDetailItem.classList.add('deactiveProjectDetailItem')
            ProjectDetailItem.classList.remove('deactiveProjectDetailItem')
        }

      },
      clickProjectDetailNavResume() {
        let removeProjectDetailItem = document.querySelector('#' + this.ProjectDetailNavProject)
        let removeResumeDetailItem = document.querySelector("#" + this.ProjectDetailNavResume)
        let ResumeDetailItem = document.querySelector('#' + this.resumeDetailNavItemProject)
        let ProjectDetailItem = document.querySelector('#' + this.projectDetailNavItemProject)

        if (!removeResumeDetailItem.classList.contains("activeProjectDetailNav")) {
            removeResumeDetailItem.classList.add("activeProjectDetailNav")
            removeProjectDetailItem.classList.remove("activeProjectDetailNav")
            ProjectDetailItem.classList.add('deactiveProjectDetailItem')
            ResumeDetailItem.classList.remove('deactiveProjectDetailItem')
        }
      },

      closeFreelancerDetail() {
        document.querySelector('body').style.overflow = 'scroll'
      }
    },
    components : {
      HeaderNav,
      FooterNav,
      ProjectDetailNav,
      ProjectDetailSkill
    }
  }
</script>