<template>
  <div :class="'message' + index" class="message-wrapper">
    <div class="message-title">
      <div class="row">
        <div class="col-1">
          <div class="d-flex justify-content-between">
            <input
              class="message-delete-checkbox"
              type="checkbox"
              :value="selectedMessage"
              @change="updatecheckmessage"
              style="zoom:1.5"
            />
            <div v-if="message.open">
              <img src="@/assets/images/envelope-open.png" />
            </div>
            <div v-else>
              <img src="@/assets/images/envelope.png" />
            </div>
          </div>
        </div>
        <div class="col-11">
          <div
            class="col-11 message-open-btn"
            @click="changeSelectedMessage(index)"
          >
            {{ message.title }}
          </div>
        </div>
      </div>
    </div>
    <div class="message-content">
      <div class="message-content-container">
        {{ message.content }}
        <div class="message-content-project-wrapper">
          <project-card
            :projectData="projectData"
            :companyData="companyData"
          ></project-card>
          <div class="message-project-hover"></div>
          <div class="message-project-btn-wrapper">
            <button class="message-project-btn interesting-project-btn">
              자세히 보러갈까요?
            </button>
            <button class="message-project-btn not-interesting-project-btn">
              관심 없어요.
            </button>
          </div>
        </div>
      </div>
    </div>
    <hr class="message-hr-decoration" />
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { mapGetters } from "vuex";
import ProjectCard from "@/components/ProjectCard/ProjectMessageCard.vue";
export default {
  components: {
    ProjectCard
  },
  data() {
    return {
      companyData: {
        name: "삼성전자",
        ceo: "이재용",
        address: "대전시 유성구 덕명동",
        call: "042-000-0000"
      },
      projectData: {
        id: "1",
        category: "개발",
        domain: "웹사이트",
        location: "대한민국 어딘가...",
        skill: ["Java", "Mysql", "SpringBoot"],
        title: "AI기반 Firescout 솔루션 ux/ui 디자인 ",
        content: "AI기반 Firescout 솔루션 ux/ui 디자인",
        startDate: new Date("2022-09-10"),
        endDate: new Date("2022-09-16"),
        locationSi: "성남시",
        locationGu: "분당구",
        startDateSummry: "2022-09-10",
        endDateSummry: "2022-09-16",
        deadline: new Date("2022-11-30"),
        recruitNumber: 3,
        task:
          "1) Native UI/UX <br> 2) 단말 내 시스템 연동 <br> 3) API 서버 연동",
        workStyle: "재택",
        workStartTime: "오전 08:00",
        workEndTime: "오후 16:00",
        lowPrice: "200만원",
        highPrice: "300만원",
        careerPeriod: 3
      },

      freelancerDetailNavLst: ["프로젝트", "이력서"],
      freelancerDetailLst: ["프로젝트item", "이력서item"],
      freelancerEducation: {
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
    };
  },
  props: {
    message: Object,
    index: Number
  },
  computed: {
    ...mapGetters(["selectedMessage", "selectedIndex"])
  },
  methods: {
    ...mapActions([
      "addSelectedMessage",
      "removeSelectedMessage",
      "setSelectedIndex"
    ]),
    viewlist() {
      console.log(this.selectedMessage);
    },
    updatecheckmessage(e) {
      if (e.target.checked) {
        this.addSelectedMessage(this.message.message_id);
      } else {
        this.removeSelectedMessage(this.message.message_id);
      }
      console.log(this.selectedMessage);
    },
    changeSelectedMessage(index) {
      console.log(index);
      console.log(this.selectedIndex + " : " + index);
      if (this.selectedIndex == index) {
        $(".message-wrapper")
          .children(".message-content")
          .slideUp();
        this.setSelectedIndex(-1);
      } else {
        $(".message-wrapper")
          .children(".message-content")
          .slideUp();
        $(`.message${index}`)
          .children(".message-content")
          .slideDown();
        this.setSelectedIndex(index);
      }
      this.message.open = true;
    }
  },
  mounted() {
    // $(document).on("click", ".message-wrapper", () => {
    //   console.log("???");
    //   $(".message-wrapper")
    //     .next(".message-content")
    //     .slideUp();
    //   $(this)
    //     .next(".message-content")
    //     .slideDown();
    //   console.log($(this).next(".message-content"));
    // });
  }
};
</script>

<style>
.message-open-btn:hover {
  cursor: pointer;
}
.message-delete-checkbox:hover {
  cursor: pointer;
}
.message-hr-decoration {
  margin-top: 15px;
  margin-bottom: 15px;
}
.message-project-btn-wrapper {
  text-align: center;
  padding-top: 400px;
  display: none;
  position: absolute;
  opacity: 1;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: none;
}
.message-content-project-wrapper:hover > .message-project-btn-wrapper {
  display: block;
}
.interesting-project-btn {
  background-color: #3f79d1;
  border: 1px solid #eaf5fb;
  color: white;
}
.not-interesting-project-btn {
  background-color: #e6ebf4;
  border: 1px solid #eaf5fb;
  color: #606275;
}
.message-project-btn {
  margin: 30px;
  padding: 5px 20px 5px 20px;
  border-radius: 45px;
  opacity: 1;
}
.message-content-project-wrapper {
  position: relative;
}
.message-content-project-wrapper:hover > .message-project-hover {
  display: block;
}
.message-project-hover {
  text-align: center;
  padding-top: 450px;
  background-color: white;
  display: none;
  position: absolute;
  opacity: 0.7;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
/* .message-content-project-wrapper:hover:after {
  width: 100%;
  height: 100%;
  content: "";
  background: white;
  position: absolute;
  top: 0;
  left: 0;
  z-index: 100;
} */
.message-content-container {
  padding: 30px 50px 30px 50px;
}
.message-image-wrapper {
  padding-left: 10px;
  padding-right: 10px;
}
.message-content {
  display: none;
}
.message-title {
}
.message-wrapper {
  width: 100%;
}
</style>
