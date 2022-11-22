<template>
  <div class="interview-project-card-wrapper">
    <div class="row interview-project-card-header-item">
      <div class="col-2 ">
        <div class="interview-project-card-header-round">
          {{ projectData.workstyle }}
        </div>
      </div>
      <div class="interview-project-card-title col-10">
        {{ projectData.title }}
      </div>
    </div>

    <div class="row interview-project-card-header-item">
      <div class="col-2 ">
        <div class="interview-project-card-header-round" v-if="remainDate != 0">
          D{{ remainDate }}
        </div>
        <div class="interview-project-card-header-round" v-else>
          D-Day
        </div>
      </div>
      <div class="interview-project-card-title col-10 ">
        {{ projectData.endDate.getFullYear() }} -
        {{ projectData.endDate.getMonth() + 1 }} -
        {{ projectData.endDate.getDate() }} 마감
      </div>
    </div>

    <hr class="interview-project-card-line" />
    <div class="row interview-project-card-devide-row">
      <div class="col-6 interview-project-card-item-round-wrapper ">
        <div
          class="d-flex justify-content-between interview-project-card-item-round"
        >
          <div>예상비용</div>
          <div>
            월
            <span style="color:blue"
              >{{ projectData.lowPrice }} ~ {{ projectData.highPrice }}</span
            >
          </div>
        </div>
      </div>
      <div class="col-6 interview-project-card-item-round-wrapper ">
        <div
          class="interview-project-card-item-round d-flex justify-content-between "
        >
          <div>예상종료기간</div>
          <div>
            {{ projectData.deadline.getFullYear() }}.{{
              projectData.deadline.getMonth()
            }}.{{ projectData.deadline.getDate() }}
          </div>
        </div>
      </div>
    </div>

    <div class="row interview-project-card-devide-row">
      <div class="col-2  ">
        <div class="interview-project-card-category">
          {{ projectData.category }}
        </div>
      </div>
      <div class="col-10">
        <div class="interview-project-card-domain">
          {{ projectData.demain }}
        </div>
      </div>
    </div>

    <div class="row interview-project-card-devide-row">
      <div class="col-2  ">
        <div class="interview-project-card-skill-title">필요기술</div>
      </div>
      <div class="col-10">
        <div class="interview-project-card-skill">
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
    </div>
    <button
      @click="selectProject"
      type="button"
      class="project-select btn btn-primary rounded-pill"
    >
      선 택
    </button>
    <ProjectSelectModal></ProjectSelectModal>
  </div>
</template>

<script>
import ProjectSelectModal from "@/components/Freelancer/Interview/ProjectSelectModal.vue";
import BootstrapVue from "bootstrap-vue";

export default {
  data() {
    return {
      /**임시 데이터 */
      projectData: {
        category: "개발",
        demain: "웹사이트",
        location: "대한민국 어딘가...",
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
    freelancerdata: Object
  },
  methods: {
    selectProject() {
      var selectProjectModal = new bootstrap.Modal(document.getElementById('ProjectSelectModal'), {
        keyboard: false
      });
      selectProjectModal.show();
    }
  },
  components: {
    ProjectSelectModal
  }
};
</script>

<style>
.interview-project-card-wrapper {
  margin: 0 auto;
  width: 700px;
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.25);
  padding: 5%;
  margin-top: 20px;
  margin-bottom: 20px;
}

.interview-project-card-header-item {
  margin-bottom: 25px;
}

.interview-project-card-title {
  padding: 10px;
}

.interview-project-card-header-round {
  padding: 10px;
  width: 100px;
  height: 40px;
  border-radius: 20px;
  background-color: #254ec9;
  color: white;
  text-align: center;
}

.interview-project-card-devide-row {
  margin-top: 15px;
  margin-bottom: 15px;
  padding-left: 10px;
}

.interview-project-card-line {
  height: 3px;
  background-color: black;
}
.interview-project-card-item-round-wrapper {
  padding-right: 3px;
  padding-left: 3px;
}
.interview-project-card-item-round {
  padding: 10px 3px 10px 3px;
  border: 1px solid #cdcecf;
  border-radius: 20px;
}

.interview-project-card-category {
  width: 100px;
  height: 40px;
  border-radius: 20px;
  text-align: center;
  padding-top: 8px;
  background-color: white;
  color: #3f8bff;
  border: 1px solid #3f8bff;
}
.interview-project-card-domain {
  padding: 10px;
}

.interview-project-card-skill-title {
  width: 100px;
  height: 40px;
  border-radius: 20px;
  text-align: center;
  padding-top: 8px;
  background-color: #707070;
  color: white;
}
.interview-project-card-skill {
  padding: 5px;
}
.interview-project-card-content-wrapper {
  color: #b1b1b1;
}

.project-select {
  margin-top: 20px;
  width: 100px;
}
</style>
