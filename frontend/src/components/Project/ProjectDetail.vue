<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="ProjectDetailModalWrapper">
      <div class="modal-content" id="ProjectDetailModalContent">
        <button type="button" id="ProjectDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
            <ProjectDetailNav
             v-for="projectDetailNavItem in projectDetailNavLst"
             :key="projectDetailNavItem"
             :projectDetailNavItem="projectDetailNavItem"
             class="col-2 projectDetailNav"
             @deactive=deactive 
            >
            </ProjectDetailNav>
          </div>
          <hr class="project-card-line mb-4">
          <div id="프로젝트item">
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
              <div class="col-8 projectDetailItem" id="taskItem"> </div>
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
          <div id="기업정보item" class="deactiveProjectDetailItem">
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
            <button @click="openApplyModal" id="ProjectDetailApplyBtn">지원하기</button>
          </div>
        </div>
      </div>
    </div>
    <div id="applyModalCtnr">
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
  import { applyCompany } from '@/api/projectAPI'

  export default {
    name: 'ProjectDetail',
    data() {
      return {
        remainDate : "",
        periodWork : "",
        projectDetailNavLst : ["프로젝트","기업정보"],
        projectDetailLst: ["프로젝트item","기업정보item"]
      }
    },
    props : {
      projectDataReceive : Object,
      companyDataReceive : Object
    },
    mounted() {
      this.remainDate = Math.ceil(
        (this.projectDataReceive.deadline.getTime() - new Date().getTime()) /
          (1000 * 60 * 60 * 24) -
          1
      );
      this.remainDate = "D - " + String(this.remainDate)
      this.periodWork = (this.projectDataReceive.endDate.getTime() - this.projectDataReceive.startDate.getTime()) /
          (1000 * 60 * 60 * 24) - 1
      let taskItem = document.querySelector("#taskItem")
      taskItem.innerHTML = this.projectDataReceive.task
      let ProjectDetailItem = document.querySelector("#프로젝트")
      ProjectDetailItem.classList.add("activeProjectDetailNav")
    },
    methods : {
      deactive(value) {
        for (let i = 0; i < 2; i++) {
          let removeProjectDetailItem = document.querySelector("#" + this.projectDetailNavLst[i])
          let ProjectDetailItem = document.querySelector("#" + this.projectDetailLst[i])
          if (ProjectDetailItem.classList.contains("deactiveProjectDetailItem"))
            ProjectDetailItem.classList.remove("deactiveProjectDetailItem")
          if (removeProjectDetailItem.classList.contains("activeProjectDetailNav"))
            removeProjectDetailItem.classList.remove("activeProjectDetailNav")
          if (this.projectDetailLst[i] != value + "item")
            ProjectDetailItem.classList.add("deactiveProjectDetailItem")
        }
      },
      openApplyModal() {
        let applyModalCtnrTmp = document.querySelector('#applyModalCtnr')
        applyModalCtnrTmp.setAttribute("style","z-index : 2") 
      },
      clickNoApply() {
        let applyModalCtnrTmp = document.querySelector('#applyModalCtnr')
        applyModalCtnrTmp.setAttribute("style","z-index : -1")
      },
      clickApply() {
        //applyCompany(this.projectDataReceive.id)
        let completeApplyTmp = document.querySelector('#completeApply')
        let leftApplyTmp = document.querySelector('#leftApply')
        completeApplyTmp.classList.remove("d-none")
        leftApplyTmp.classList.add("d-none")
      },
      clickCompleteApply() {
        let applyModalCtnrTmp = document.querySelector('#applyModalCtnr')
        let completeApplyTmp = document.querySelector('#completeApply')
        let leftApplyTmp = document.querySelector('#leftApply')
        applyModalCtnrTmp.setAttribute("style","z-index : -1")
        completeApplyTmp.classList.add("d-none")
        leftApplyTmp.classList.remove("d-none")
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
  #projectDetailCtnr {
    width : 85%;
    margin-left : auto;
    margin-right: auto;
    margin-top: 30px;
    margin-bottom: 30px;
  }

  #projectDetailHeadCtnr {
    border-radius: 20px;
    background-color: rgb(241, 241, 241);
  }

  #ProjectDetailModalCloseBtn {
    position: fixed;
    top : 55px;
    right : 400px;
  }

  #remainDateWrapperInProjectDetail {
    border-radius: 40px;
    border: 1px solid lightgray;
    background-color: #3C74C9;
    font-size: 15px;
    color: white;
    font-weight: bold;
    display: inline-block;
    width: 105px;
  }

  #remainDateInProjectTitle {
    margin-left: 15px;
    font-weight: bold;
    font-size: 26px;
  }

  .projectDetailHeadItem {
    font-weight : bold;
    font-size: 18px;
  }

  #ProjectDetailModalContent {
    border-radius: 20px;
    height: 650px; 
    margin: auto !important;
    overflow-y: scroll;
  }

  #ProjectDetailModalContent::-webkit-scrollbar {
    width: 0px !important;
  }

  .projectDetailItem {
    text-align: left;
  }

  .projectDetailNav {
    position: relative;
    top: 0px;
    left: 0px;
    width: 130px !important;
    font-size: 21px;
    text-align: center;
  }

  .projectDetailNav:hover {
    font-size: 22px;
    font-weight: bold;
  }

  .activeProjectDetailNav {
    font-size: 22px;
    font-weight: bold;
  }

  .deactiveProjectDetailItem {
    display: none;
  }

  #projectDetailNavCtnr {
    margin-top : 30px;
    margin-bottom : 30px;
  }

  #ProjectDetailApplyBtn {
    border-radius: 40px;
    border: 1px solid lightgray;
    background-color: #6ecdb1;
    font-size: 15px;
    font-weight: bold;
    width: 120px;
    height: 40px;
  }

  #ProjectDetailApplyBtn:hover {
    background-color: #3C74C9;
    color: white;
  }

  .ProjectApplyBtn {
    border-radius: 40px;
    border: 1px solid lightgray;
    background-color: #3C74C9;
    color: white;
    font-size: 15px;
    font-weight: bold;
    width: 120px;
    height: 40px;
  }

  #applyModal {
    position: fixed;
    top: 130px;
    right: 600px;
    background-color: white;
    border-radius: 20px;
    height: 170px; 
    border: 1px solid lightgray;
    width: 320px;
    margin: auto;
  }

  #applyModalCtnr {
    z-index: -1;
    position : fixed;
    top: 0px;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0,0,0,0.1);
  }

</style>