<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="ProjectDetailModalWrapper">
      <div class="modal-content modal-content-project-show" id="ProjectDetailModalContent">
        <button @click=clickClosePjtDetail type="button" id="ProjectDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.workstyle}} </div>
                </div> 
                <div class="row">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">  금액</div>
                  <div class="col-8 projectDetailItem"> {{ projectDataReceive.lowPrice }}FC ~ {{ projectDataReceive.highPrice }}FC/월
                    <br>(근무 확정시, 단가 확정)</div>
                </div>
              </div>
              <div class="col-2 my-3 mx-3" id="remainDateWrapperInProjectDetail"> 
                <div class="my-2" id="remainDateWrapperInProjectDetailDate">
                  D - {{ remainDate }} 
                </div>
              </div>
            </div>  
          </div>
          <div class="row" id="projectDetailNavCtnr">
            <div @click="clickProjectDetailNavProject" class="col-2 projectDetailNav activeProjectDetailNav" id="ProjectDetailNavProject">
              프로젝트
            </div> 
            <div @click="clickProjectDetailNavResume" class="col-2 projectDetailNav" id="ProjectDetailNavResume">
              기업정보
            </div> 
          </div>
          <hr class="project-card-line mb-4">
          <div id="projectDetailNavItemProject">
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  분야</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.category }}</div>
            </div>  
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  형태</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.demain }}</div>
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
              <div class="col-3 projectDetailHeadItem projectDetailItem">  내용</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.content }}</div>
            </div>
            <div class="row mx-2 my-2">
              <div class="col-3 projectDetailHeadItem projectDetailItem">  근무시간</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.workStartTime }} ~ {{ projectDataReceive.workEndTime }}</div>
            </div>   
            <div class="row mx-2 my-2">
             <div class="col-3 projectDetailHeadItem projectDetailItem">  지역</div>
              <div class="col-8 projectDetailItem"> {{ projectDataReceive.location }}</div>
            </div>
          </div>
          <div id="resumeDetailNavItemProject" class="deactiveProjectDetailItem">
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
          <div class="row mt-4 justify-content-center">
            <button v-if="loginType == 'freelancer'" @click="openApplyModal" id="ProjectDetailApplyBtn">지원하기</button>
          </div>
        </div>
      </div>
    </div>
    <div id="applyModalCtnr" class="d-none applyModalCtnr">
      <div id="applyModal">
        <div id="leftApply">
          <h5 class="mt-4">해당 프로젝트에</h5>
          <h5 class="mb-4">지원하시겠습니까?</h5>
          <button @click="clickApply" id="ApplyOk" class="ProjectApplyBtn mx-2">네</button>
          <button @click="clickNoApply" id="ApplyNotYet" class="ProjectApplyBtn mx-2">아니요</button>
        </div>
        <div id="completeApply" class="d-none">
          <h5 class="mt-5">지원이 완료되었습니다!</h5>
          <button @click="clickCompleteApply" id="ApplyNotYet" class="ProjectApplyBtn my-3">확인</button>
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
  import { mapGetters, mapActions } from "vuex";
  export default {
  name: 'ProjectDetailShow',
  computed: {
    ...mapGetters(["loginType","loginUserInfo"])
  },
    data() {
      return {
        projectDetailNavLst : ["프로젝트","기업정보"],
        projectDetailLst: ["프로젝트item","기업정보item"]
      }
    },
    props : {
      projectDataReceive : Object,
      companyDataReceive : Object,
      remainDate : Number,
      periodWork : Number
    },
    mounted() {
    },
  methods: {
    ...mapActions(["createApply"]),
      openApplyModal() {
        let applyModalCtnrTmp = document.querySelector('#applyModalCtnr')
        applyModalCtnrTmp.classList.remove('d-none')
      },
      clickNoApply() {
        let applyModalCtnrTmp = document.querySelector('#applyModalCtnr')
        applyModalCtnrTmp.classList.add("d-none")
      },
      clickApply() {
        //applyCompany(this.projectDataReceive.id)
        let completeApplyTmp = document.querySelector('#completeApply')
        let leftApplyTmp = document.querySelector('#leftApply')
        completeApplyTmp.classList.remove("d-none")
        leftApplyTmp.classList.add("d-none")
        //계약 테이블에 데이터 저장
        // console.log(this.projectDataReceive);
        // console.log(this.loginUserInfo);
        let applyInfo = {
          projectId : this.projectDataReceive.id,
          state : "지원완료",
          userId : this.loginUserInfo.id 
        }

        // console.log(applyInfo);
        this.createApply(applyInfo);
      },
      clickCompleteApply() {
        let applyModalCtnrTmp = document.querySelector('#applyModalCtnr')
        let completeApplyTmp = document.querySelector('#completeApply')
        let leftApplyTmp = document.querySelector('#leftApply')
        applyModalCtnrTmp.classList.add("d-none")
        completeApplyTmp.classList.add("d-none")
        leftApplyTmp.classList.remove("d-none")
      },
      clickProjectDetailNavProject() {
        let removeProjectDetailItem = document.querySelector('#ProjectDetailNavProject')
        let removeResumeDetailItem = document.querySelector("#ProjectDetailNavResume")
        let ResumeDetailItem = document.querySelector('#resumeDetailNavItemProject')
        let ProjectDetailItem = document.querySelector('#projectDetailNavItemProject')
        if (!removeProjectDetailItem.classList.contains("activeProjectDetailNav")) {
            removeProjectDetailItem.classList.add("activeProjectDetailNav")
            removeResumeDetailItem.classList.remove("activeProjectDetailNav")
            ResumeDetailItem.classList.add('deactiveProjectDetailItem')
            ProjectDetailItem.classList.remove('deactiveProjectDetailItem')
        }

      },
      clickProjectDetailNavResume() {
        let removeProjectDetailItem = document.querySelector('#ProjectDetailNavProject')
        let removeResumeDetailItem = document.querySelector("#ProjectDetailNavResume")
        let ResumeDetailItem = document.querySelector('#resumeDetailNavItemProject')
        let ProjectDetailItem = document.querySelector('#projectDetailNavItemProject')

        if (!removeResumeDetailItem.classList.contains("activeProjectDetailNav")) {
            removeResumeDetailItem.classList.add("activeProjectDetailNav")
            removeProjectDetailItem.classList.remove("activeProjectDetailNav")
            ProjectDetailItem.classList.add('deactiveProjectDetailItem')
            ResumeDetailItem.classList.remove('deactiveProjectDetailItem')
        }
      },

      clickClosePjtDetail() {
        let removeProjectDetailItem = document.querySelector('#ProjectDetailNavProject')
        let removeResumeDetailItem = document.querySelector("#ProjectDetailNavResume")
        let ResumeDetailItem = document.querySelector('#resumeDetailNavItemProject')
        let ProjectDetailItem = document.querySelector('#projectDetailNavItemProject')
        if (!removeProjectDetailItem.classList.contains("activeProjectDetailNav")) {
            removeProjectDetailItem.classList.add("activeProjectDetailNav")
            removeResumeDetailItem.classList.remove("activeProjectDetailNav")
            ResumeDetailItem.classList.add('deactiveProjectDetailItem')
            ProjectDetailItem.classList.remove('deactiveProjectDetailItem')
        }
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

<style>
  .modal-content-project-show {
    width : 50vw !important;
    left : 25.5% !important;
  }
</style>