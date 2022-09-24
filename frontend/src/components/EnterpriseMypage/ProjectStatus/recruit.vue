<template>
  <div>
    <div class="carousel-wrapper-mine mx-auto mt-4" data-bs-touch="false" id="carouselWrapperMyPageCompanyRecruit">
      <div class="carousel-mine" id="carouselMyPageCompanyRecruit">
        <recruitCardItem
        v-for="projectCardCarousel in myProjectLst"
        :key="projectCardCarousel.id"
        :projectCardCarousel="projectCardCarousel"
        :projectData="projectCardCarousel.body"
        ></recruitCardItem>
      </div>
      <recruitProjectDetail
      v-for="projectCardCarousel in myProjectLst"
      :key=projectCardCarousel.id
      :id=projectCardCarousel.id
      :idEdit=projectCardCarousel.id
      :projectDataReceive=projectCardCarousel.body
      :companyDataReceive=companyData
      >
      </recruitProjectDetail>
      <button @click="prevBtnClick" class="prevMyPageCompany" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-left" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
        </svg>
        <span class="visually-hidden">Previous</span>
      </button>
      <button @click="nextBtnClick" class="nextMyPageCompany" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="black" class="bi bi-chevron-right" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
        </svg>
        <span class="visually-hidden">Next</span>
      </button>    
    </div>
  </div>
</template>

<script>
  import recruitCardItem from './recruitCardItem.vue'
  import recruitProjectDetail from './recruitProjectDetail.vue'

  export default {
    name : "recruit",
    data() {
      return {
        idx : 0,
        myProjectLst : [],
        projectData: {
          id: "1",
          category: "개발",
          demain: "앱",
          location: "대한민국 어딘가...",
          skill: ["Java", "Mysql" ,"SpringBoot"],
          title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
          content: "AI기반 Firescout 솔루션 ux/ui 디자인",
          startDate: new Date("2022-12-1"),
          endDate: new Date("2024-1-1"),
          startDateSummry : "2022-12-1",
          endDateSummry : "2024-1-1",
          deadline: new Date("2022-10-30"),
          recruitNumber: 4,
          task: "1) Native UI/UX 2) 단말 내 시스템 연동 3) API 서버 연동",
          workstyle: "재택",
          workStartTime: "오전 08:00",
          workEndTime: "오후 16:00",
          lowPrice: "200만원",
          highPrice: "300만원",
          careerPeriod: 3,
        },
        companyData : {
          name: "삼성전자",
          ceo: "이재용",
          address: "대전시 유성구 덕명동",
          call: "042-000-0000"
        },
      }
    },
    mounted() {
      for(let i = 0; i < 5; i++) {
        this.myProjectLst.push({
          id : "idMyPageCompanyStatus" + String(i),
          body : this.projectData
        })
      }
    },
    methods : {
      prevBtnClick() {
        if (this.idx === 0) this.idx = this.myProjectLst.length - 1
        else 
          this.idx--
        document.querySelector('#carouselMyPageCompanyRecruit').style.transform = 'translate3d(' + -660 * this.idx  + 'px, 0, 0)'
      },
      nextBtnClick() {
        if (this.idx === this.myProjectLst.length - 1) this.idx = 0
        else 
          this.idx++
        document.querySelector('#carouselMyPageCompanyRecruit').style.transform = 'translate3d(' + -660 * this.idx + 'px, 0, 0)'
      },
    },
    components : {
      recruitCardItem,
      recruitProjectDetail
    }
  }
</script>

<style>
  .prevMyPageCompany {
    position: absolute;
    top : 225px;
    left : 530px;
    height : 219px;
    background-color: #f9f9f9;
    border : 0px;
  }

  .nextMyPageCompany {
    position: absolute;
    top : 225px;
    right : 200px;
    height : 219px;
    background-color: #f9f9f9;
    border : 0px;
  }

  #carouselWrapperMyPageCompanyRecruit{
    width: 660px !important;
    height: 320px !important;
  }
</style>