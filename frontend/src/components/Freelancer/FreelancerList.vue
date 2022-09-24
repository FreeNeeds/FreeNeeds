<template>
  <div id="freelancer-list">
    <FreelancerCard
    v-for="freelancerCard in freelancerCardLst"
    :key="freelancerCard.id"
    :freelancerCard="freelancerCard"></FreelancerCard>
    
  </div>
</template>

<script>
import FreelancerCard from "@/components/Freelancer/FreelancerCard.vue";

export default {
  data() {
    return {
      myProjectLst : [],
      freelancerCardLst : [],
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
            communication : 4.5,
            reEmployment : 3
          },
          {
            profession : 3,
            ontime : 4,
            active : 3,
            communication : 4.5,
            reEmployment : 5
          },
          {
            profession : 2,
            ontime : 4,
            active : 4.5,
            communication : 4.5,
            reEmployment : 5
          },
          {
            profession : 4,
            ontime : 3,
            active : 3.5,
            communication : 3.5,
            reEmployment : 4
          },
          {
            profession : 4.5,
            ontime : 4,
            active : 4,
            communication : 3.5,
            reEmployment : 2
          },
        ],
        projectCareer : [],
      }
    }
  },
  mounted() {
    for (let i = 0; i < 10; i++){
      this.freelancerCardLst.push({
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
    FreelancerCard,
  }
};
</script>

<style>
.freelancer-contents {
  max-width: 800px;
  max-height: 250px;
  margin: 0 auto;
  margin-top: 30px;
}

.freelancer-contents:hover {
  background-color: #b4b4b4;
}
</style>
