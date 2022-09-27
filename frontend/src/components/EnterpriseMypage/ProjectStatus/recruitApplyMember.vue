<template>
  <div id="freelancer-list">
    <div style="width : 0px; height : 0px">
      <button @click="clickContractBefore" id="clickBefore" class="activeContract" style=
      "border: 0px; border-radius : 40px; width : 22px; height : 22px;  position : relative; top : 51px; left : 210px;"
      ></button>
      <div style=
      "position : relative; top: -10px; left : 192px; width: 70px"
      >계약 전</div>
      <button @click="clickContractIng" id="clickIng" style=
      "border : 0px; border-radius : 40px; width : 22px; height : 22px; position : relative; top : -1px; left : 460px;"
      ></button>
      <div style=
      "position : relative; top : -62px; left : 444px;  width: 70px"
      >계약 중</div>
      <button @click="clickContractAfter" id="clickAfter" style=
      "border : 0px; border-radius : 40px; width : 22px; height : 22px; position : relative; top : -50px; left : 710px;"
      ></button>
      <div style=
      "position : relative; top : -110px; left : 686px;  width: 70px"
      >계약 완료</div>

    </div>
    <div class="mx-auto" style="height : 1.5px; background-color : black; width : 80%; margin-top : 60px; margin-bottom: 60px;"></div>
    <div id="beforeFreelancerCardLst">
      <recruitApplyMemberItem
      v-for="freelancerCard in beforeFreelancerCardLst"
      :key="freelancerCard.id"
      :freelancerCard="freelancerCard"></recruitApplyMemberItem>
    </div>
    <div id="ingFreelancerCardLst" class='deactiveProjectDetailItem'>
      <recruitApplyMemberItem
      v-for="freelancerCard in ingFreelancerCardLst"
      :key="freelancerCard.id"
      :freelancerCard="freelancerCard"></recruitApplyMemberItem>
    </div>
    <div id="afterFreelancerCardLst" class='deactiveProjectDetailItem'>
      <recruitApplyMemberItem
      v-for="freelancerCard in afterFreelancerCardLst"
      :key="freelancerCard.id"
      :freelancerCard="freelancerCard"></recruitApplyMemberItem>
    </div>
  </div>
</template>

<script>
import recruitApplyMemberItem from "@/components/EnterpriseMypage/ProjectStatus/recruitApplyMemberItem.vue";

export default {
  props : { 
    projectId : Number
  },
  data() {
    return {
      myProjectLst : [],
      beforeFreelancerCardLst : [],
      ingFreelancerCardLst : [],
      afterFreelancerCardLst : [],
      freelancerCardItem : {
        projectCareerId : "1",
        category : "개발",
        domain : "웹사이트",
        company_name : "한국투자공사",
        title : "한국투자공사 모바일 가상화 시스템 구축",
        content : "한국투자공사 모바일 가상화 시스템 앱 개발 - 기존 그룹웨어 앱 가상화에서 사용가능하도록 수정",
        projectCareerTech : ["Java","Vue.js","Oracle"],
        startDate : "2020-04-10",
        endDate : "2020-10-30"
      },
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
      freelancerDataReceive : {
        user_id : "1",
        name : "빌게이츠",
        resume : {
          title : "최고를 꿈꾸는 개발자입니다.",
          introduce : "고객이 요구하는 개발 스킬 및 요건에 맞추어 수많은 프로젝트의 경험을가지고 있습니다. 고객의 소통을 최우선으로 함께 고민하고 최선의마음으로 개발을 진행하고 있습니다. 원하시는 개발 요건을이루어드립니다. 다양한 프로젝트 경험으로 개발 요구 언어를 사용하여고객의 요건에 충족할 수 있습니다. 또한 최근 트렌드에 맞추어 최신 언어로 개발 진행 가능합니다.",
          career_period : "3"
        },
        tech : ["java","javascript","MySQL"],
        estimate : [
          {
            profession : 4,
            ontime : 5,
            active : 3.5,
            communication : 3.5,
            reEmployment : 3
          },
          {
            profession : 3,
            ontime : 4,
            active : 3,
            communication : 2.5,
            reEmployment : 5
          },
          {
            profession : 2,
            ontime : 4,
            active : 4.5,
            communication : 2,
            reEmployment : 5
          },
          {
            profession : 4,
            ontime : 3,
            active : 3.5,
            communication : 1,
            reEmployment : 4
          },
          {
            profession : 4.5,
            ontime : 4,
            active : 4,
            communication : 3,
            reEmployment : 2
          },
        ],
        projectCareer : [],
      }
    }
  },
  mounted() {
    for (let i = 0; i < 10; i++){
      this.beforeFreelancerCardLst.push({
        id : i,
        body : this.freelancerDataReceive
      })
    }

    for (let i = 10; i < 12; i++){
      this.ingFreelancerCardLst.push({
        id : i,
        body : this.freelancerDataReceive
      })
    }

    for (let i = 12; i < 16; i++){
      this.afterFreelancerCardLst.push({
        id : i,
        body : this.freelancerDataReceive
      })
    }

    for (let i = 0; i < 7; i++){
      this.freelancerDataReceive.projectCareer.push({
        id : i,
        body : this.freelancerCardItem
      })
    }

    for(let i = 0; i < 5; i++) {
      this.myProjectLst.push({
        id : "ids" + String(i),
        body : this.projectData
      })
    }
  },
  components: {
    recruitApplyMemberItem
  },
  methods : {
    clickContractBefore() { 
      let beforeTmp = document.querySelector("#clickBefore")
      let ingTmp = document.querySelector('#clickIng')
      let afterTmp = document.querySelector('#clickAfter')
      let beforeFreelancerCardLstTmp = document.querySelector('#beforeFreelancerCardLst')
      let ingFreelancerCardLstTmp = document.querySelector('#ingFreelancerCardLst')
      let afterFreelancerCardLstTmp = document.querySelector('#afterFreelancerCardLst')
      if (!beforeTmp.classList.contains('activeContract')) {
        if (ingTmp.classList.contains('activeContract')) {
          ingTmp.classList.remove('activeContract')
          ingFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        if (afterTmp.classList.contains('activeContract')) {
          afterTmp.classList.remove('activeContract')
          afterFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        beforeTmp.classList.add('activeContract')
        beforeFreelancerCardLstTmp.classList.remove('deactiveProjectDetailItem')
      }
    },

    clickContractIng() {
      let beforeTmp = document.querySelector("#clickBefore")
      let ingTmp = document.querySelector('#clickIng')
      let afterTmp = document.querySelector('#clickAfter')
      let beforeFreelancerCardLstTmp = document.querySelector('#beforeFreelancerCardLst')
      let ingFreelancerCardLstTmp = document.querySelector('#ingFreelancerCardLst')
      let afterFreelancerCardLstTmp = document.querySelector('#afterFreelancerCardLst')
      if (!ingTmp.classList.contains('activeContract')) {
        if (beforeTmp.classList.contains('activeContract')) {
          beforeTmp.classList.remove('activeContract')
          beforeFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        if (afterTmp.classList.contains('activeContract')) {
          afterTmp.classList.remove('activeContract')
          afterFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        ingTmp.classList.add('activeContract')
        ingFreelancerCardLstTmp.classList.remove('deactiveProjectDetailItem')
      }
    },
    
    clickContractAfter() {
      let beforeTmp = document.querySelector("#clickBefore")
      let ingTmp = document.querySelector('#clickIng')
      let afterTmp = document.querySelector('#clickAfter')
      let beforeFreelancerCardLstTmp = document.querySelector('#beforeFreelancerCardLst')
      let ingFreelancerCardLstTmp = document.querySelector('#ingFreelancerCardLst')
      let afterFreelancerCardLstTmp = document.querySelector('#afterFreelancerCardLst')
      if (!afterTmp.classList.contains('activeContract')) {
        if (beforeTmp.classList.contains('activeContract')) {
          beforeTmp.classList.remove('activeContract')
          beforeFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        if (ingTmp.classList.contains('activeContract')) {
          ingTmp.classList.remove('activeContract')
          ingFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        afterTmp.classList.add('activeContract')
        afterFreelancerCardLstTmp.classList.remove('deactiveProjectDetailItem')
      }
    }
  }
};
</script>

<style>
  .activeContract {
    background-color : lightblue;
  }
</style>
