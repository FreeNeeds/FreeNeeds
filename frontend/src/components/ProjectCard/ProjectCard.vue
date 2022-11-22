<template>
  <div class="project-card-wrapper col-6">
    <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="">
    <div class="row project-card-header-item">
      <div class="col-3 ">
        <div class="project-card-header-round ">
          {{ projectData.workstyle }}
        </div>
      </div>
      <div class="project-card-title col-10">{{ projectData.title }}</div>
    </div>
    <div class="row project-card-header-item">
      <div class="col-2 ">
        <div class="project-card-header-round" v-if="remainDate != 0">
          D{{ remainDate }}
        </div>
        <div class="project-card-header-round" v-else>
          D-Day
        </div>
      </div>
      <div class="project-card-title col-10 ">
        {{ projectData.endDate.getFullYear() }} -
        {{ projectData.endDate.getMonth() + 1 }} -
        {{ projectData.endDate.getDate() }} 마감
      </div>
    </div>
    <hr class="project-card-line" />
    <div class="row project-card-devide-row">
      <div class="col-6 project-card-item-round-wrapper ">
        <div class="d-flex justify-content-between project-card-item-round">
          <div class="mx-3">예상비용</div>
          <div class="mx-3">
            월
            <span style="color:#0064ff"
              >{{ projectData.lowPrice }} ~ {{ projectData.highPrice }}</span
            >
          </div>
        </div>
      </div>
      <div class="col-6 project-card-item-round-wrapper ">
        <div class="project-card-item-round d-flex justify-content-between ">
          <div class="mx-3">예상종료기간</div>
          <div class="mx-3">
            {{ projectData.deadline.getFullYear() }}.{{
              projectData.deadline.getMonth()
            }}.{{ projectData.deadline.getDate() }}
          </div>
        </div>
      </div>
    </div>
    <!--<div class="row project-card-devide-row">
      <div class="col-2  ">
        <div class="project-card-category">{{ projectData.category }}</div>
      </div>
      <div class="col-10">
        <div class="project-card-domain">
          {{ projectData.demain }}
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div class="col-2  ">
        <div class="project-card-skill-title">필요기술</div>
      </div>
      <div class="col-10">
        <div class="project-card-skill">
          {{ projectData.skill }}
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div class="project-card-content-wrapper">
        {{ projectData.content }}
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div>
        <img
          src="@/assets/images/People.png"
          style="width:20px;height: 20px; object-fit: cover; padding: 0;"
        />
        <div style="display:inline; margin-left: 10px;">
          모집 {{ projectData.recruitNumber }}명
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div>
        <img
          src="@/assets/images/Apartment.png"
          style="width:20px;height:20px;object-fit:cover"
        />
        <div style="display:inline;margin-left:10px">
          {{ projectData.workstyle }}
        </div>
      </div>
    </div>
    <div class="row project-card-devide-row">
      <div>
        <img
          src="@/assets/images/Location on.png"
          style="width:20px;height:20px;object-fit:cover"
        />
        <div style="display:inline;margin-left:10px">
          {{ projectData.location }}
        </div>
      </div>
    </div>-->
    <hr>
  </div>
</template>

<script>
export default {
  data() {
    return {
      /**임시 데이터 */
      projectData: {
        category: "개발",
        demain: "웹사이트",
        location: "대한민국 어딘가AAAAAAAAAAAAAAAAAAAAAA",
        skill: "Java Mysql SpringBoot",
        title: "AI기반 Firescout 솔루션 ux/ui 디자인",
        content: "AI기반 Firescout 솔루션 ux/ui 디자인",
        startDate: new Date("2022-09-10"),
        endDate: new Date("2022-09-16"),
        deadline: new Date("2022-11-30"),
        recruitNumber: 3,
        task: "1) Native UI/UX 2) 단말 내 시스템 연동 3) API 서버 연동",
        workstyle: "재택",
        workStartTime: "오전 08:00",
        workEndTime: "오후 16:00",
        lowPrice: "200만원",
        highPrice: "300만원",
        careerPeriod: 3
      }
    };
  },
  computed: {
    remainDate() {
      return Math.ceil(
        (new Date().getTime() - this.projectData.endDate.getTime()) /
          (1000 * 60 * 60 * 24) -
          1
      );
    }
  },
  props: {
    //nprojectData: Object
  }
};
</script>

<style>
.project-card-title {
  padding-top: 8px;
}
.project-card-devide-row {
  margin-top: 15px;
  margin-bottom: 15px;
  padding-left: 10px;
}
.project-card-header-item {
  margin-bottom: 25px;
}

.project-card-header-round {

  padding: 6px 3px 0px 3px;
  margin-top: 5px;
  margin-left: 13px;
  width: 83px;
  height: 35px;
  border-radius: 20px;
  background-color: #0064ff;
  color: white;
  text-align: center;
}
.project-card-line {
  height: 3px;
  background-color: black;
}
.project-card-item-round-wrapper {
  padding-right: 3px;
  padding-left: 3px;
}
.project-card-item-round {
  padding: 10px 3px 10px 3px;
  border: 1px solid #cdcecf;
  border-radius: 20px;
}

.project-card-category {
  width: 100px;
  height: 40px;
  border-radius: 20px;
  text-align: center;
  padding-top: 8px;
  background-color: white;
  color: #3f8bff;
  border: 1px solid #3f8bff;
}
.project-card-domain {
  padding-top: 8px;
  /* position: absolute;
  top: 50%;
  margin-top: -12px; */
}
.project-card-skill-title {
  width: 100px;
  height: 40px;
  border-radius: 20px;
  text-align: center;
  padding-top: 8px;
  background-color: #707070;
  color: white;
}
.project-card-skill {
  padding-top: 8px;
  /* position: absolute;
  top: 50%;
  margin-top: -12px; */
}
.project-card-content-wrapper {
  color: #b1b1b1;
}

.wrapperImgProjectCarousel {
  width : 100%;
  height : 0px;
}

</style>
