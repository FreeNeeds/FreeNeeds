<template>
  <div>
    <div id="projectDetailCtnr">
      <div id="remainDateInProjectTitle" class="text-start"></div>
      <div class="container my-4 py-2" id="projectDetailHeadCtnr">
        <div class="row mx-2 my-3 justify-content-between align-items-start">
          <div class="row align-items-center">
            <div class="col-2 projectDetailHeadItem projectDetailItem">
              모집인원
            </div>
            <input
              v-model="projectInfo.recruitNumber"
              class="col-2 mb-1 form-control"
              type="text"
            />
            <div class="col-5 projectDetailItem">명</div>
          </div>
          <div class="row align-items-center">
            <div class="col-2 projectDetailHeadItem projectDetailItem">
              경력기간
            </div>
            <input
              v-model="projectInfo.careerPeriod"
              class="col-2 mb-1 form-control"
              type="text"
            />
            <div class="col-5 projectDetailItem">년</div>
          </div>
          <div class="row align-items-center">
            <div class="col-2 projectDetailHeadItem projectDetailItem">
              근무기간
            </div>
            <input
              v-model="projectInfo.startDate"
              class="col-2 mb-1 form-control"
              type="date"
            />
            <div class="col-1 projectDetailItem text-center">~</div>
            <input
              v-model="projectInfo.endDate"
              class="col-2 mb-1 form-control"
              type="date"
            />
          </div>
          <div class="row align-items-center">
            <div class="col-2 projectDetailHeadItem projectDetailItem">
              근무방식
            </div>
            <input
              v-model="projectInfo.workStyle"
              class="col-2 mb-1 form-control"
              type="text"
            />
          </div>
          <div class="row align-items-center">
            <div class="col-2 projectDetailHeadItem projectDetailItem">
              금액
            </div>
            <input
              v-model="projectInfo.lowPrice"
              class="col-2 mb-1 form-control"
              type="text"
            />
            <div class="col-1 projectDetailItem text-center">~</div>
            <input
              v-model="projectInfo.highPrice"
              class="col-2 mb-1 form-control"
              type="text"
            />
            <div class="col-4">/월(근무 확정시, 단가 확정)</div>
          </div>
          <div class="row align-items-center">
            <div class="col-2 projectDetailHeadItem projectDetailItem">
              마감기한
            </div>
            <input
              v-model="projectInfo.deadline"
              class="col-2 mb-1 form-control"
              type="date"
            />
          </div>
        </div>
      </div>
      <hr class="project-card-line mb-4" />
      <div>
        <div class="row mx-2 my-2 ">
          <div class="col-3 projectDetailHeadItem projectDetailItem">분야</div>
          <select
            v-model="projectInfo.category"
            class="form-select text-center project-regist-select-wrapper"
            aria-label="Default select example"
          >
            <option
              value="개발"
              selected
              style="padding-right: 2px"
              class="project-regist-select-item"
              >개발</option
            >
            <option
              value="디자인"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >디자인</option
            >
            <option
              value="기획"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >기획</option
            >
          </select>
        </div>
        <div class="row mx-2 my-2 ">
          <div class="col-3 projectDetailHeadItem projectDetailItem">형태</div>
          <select
            v-model="projectInfo.domain"
            class="form-select text-center project-regist-select-wrapper"
            aria-label="Default select example"
          >
            <option
              value="웹사이트"
              selected
              style="padding-right: 2px"
              class="project-regist-select-item"
              >웹사이트</option
            >
            <option
              value="앱"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >앱(APP)</option
            >
            <option
              value="커머스/쇼핑몰"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >커머스/쇼핑몰</option
            >
            <option
              value="퍼블리싱"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >퍼블리싱</option
            >
            <option
              value="네트워크/보안"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >네트워크/보안</option
            >
            <option
              value="게임"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >게임</option
            >
            <option
              value="일반소프트웨어"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >일반소프트웨어</option
            >
            <option
              value="제품"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >제품</option
            >
            <option
              value="영상"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >영상</option
            >
            <option
              value="9"
              style="padding-right: 2px"
              class="project-regist-select-item"
              >그래픽</option
            >
          </select>
        </div>
        <div class="row mx-2 my-2">
          <div class="col-3 projectDetailHeadItem projectDetailItem">
            담당업무
          </div>
          <input
            v-model="projectInfo.task"
            class="col-2 mb-1 form-control"
            type="text"
          />
        </div>
      </div>
      <div
        id="skillSelectCtnr my-3"
        style="margin-left : 100px; margin-right : 100px"
      >
        <FilterSkillSelect
          v-for="skillItem in FilterSkillLst"
          :key="skillItem"
          :skillItem="skillItem"
          @deleteSkill="deleteSkill"
        ></FilterSkillSelect>
      </div>
      <div class="row mx-2 my-2">
        <div class="col-3 projectDetailHeadItem projectDetailItem">기술</div>
        <div
          id="skillSearchCtnr"
          style="width : 350px; background-color: white; margin-left : 0px"
        >
          <input
            placeholder="기술명을 검색하세요"
            type="text"
            id="skillSearchBar"
            autocomplete="off"
          />
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="20"
            height="20"
            fill="currentColor"
            class="bi bi-search mb-1 mx-2"
            viewBox="0 0 16 16"
          >
            <path
              d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"
            />
          </svg>
        </div>
        <div
          id="skillCandidateCtnr"
          class=" col-8 mx-5 my-3 text-center"
          style="width : 45%"
        >
          <FilterSkillCandidate
            v-for="skillCandidate in FilterSkillCandidate"
            :key="skillCandidate"
            :skillCandidate="skillCandidate"
            @insertSkill="insertSkill"
          ></FilterSkillCandidate>
        </div>
        <hr class="project-card-line mb-4" />
        <div class="row  my-2">
          <div class="col-3 projectDetailHeadItem projectDetailItem">
            프로젝트명
          </div>
          <input
            v-model="projectInfo.title"
            class="col-2 mx-1 mb-1 form-control"
            type="text"
          />
        </div>
        <div class="row my-2">
          <div class="col-3 projectDetailHeadItem projectDetailItem">내용</div>
          <textarea
            v-model="projectInfo.content"
            class="col-7 mx-1 mb-1 form-control"
            style="width : 500px !important; height : 100px"
          ></textarea>
        </div>

        <div class="row  my-2">
          <div class="col-3 projectDetailHeadItem projectDetailItem">
            근무시간
          </div>
          <input
            v-model="projectInfo.workStartTime"
            class="col-2 mb-1 form-control"
            type="time"
          />
          <div class="col-1 projectDetailItem text-center">~</div>
          <input
            v-model="projectInfo.workEndTime"
            class="col-2 mx-1 mb-1 form-control"
            type="time"
          />
        </div>
        <div class="row  my-2">
          <div class="col-3 projectDetailHeadItem projectDetailItem">
            지역시
          </div>
          <input
            v-model="projectInfo.locationSi"
            class="col-2  mb-1 form-control"
            type="text"
            placeholder="대전광역시"
          />

          <input
            v-model="projectInfo.locationGu"
            class="col-2 mx-1 mb-1  form-control"
            type="text"
            placeholder="유성구"
          />
        </div>
        <div class="row  my-2"></div>
        <button
          @click="clickRegisterProject"
          class="signatureBtn m-auto my-4"
          style="width : 150px !important"
        >
          등록하기
        </button>
      </div>
    </div>
    <div id="completeRegisterProject" class="d-none">
      <div class="sureContractModalCtnrWrpr" style="z-index : 1">
        <div class="sureContractModalCtnr">
          <h5 class="text-center" style="margin-top : 70px">
            등록이 완료되었습니다.
          </h5>
          <button
            @click="okRegisterProject"
            class="signatureBtn my-3"
            style="margin-left : 150px"
          >
            확인
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FilterSkillCandidate from "@/components/Project/FilterSkillCandidate.vue";
import { searchSkillFunc, skills } from "../../utils/skillSearch";
import FilterSkillSelect from "@/components/Project/FilterSkillSelect.vue";
import { mapActions } from "vuex";
import { createInstance } from "@/api/index.js";
import store from "@/store/index.js";
export default {
  name: "ProjectRegist",
  data() {
    return {
      projectInfo: {
        category: "",
        domain: "",
        locationSi: "",
        locationGu: "",
        title: "",
        content: "",
        startDate: "",
        endDate: "",
        deadline: "",
        recruitNumber: "",
        task: "",
        workStyle: "",
        workStartTime: "",
        workEndTime: "",
        lowPrice: "",
        highPrice: "",
        careerPeriod: "",
        skill: "wow"
      },
      FilterSkillCandidate: [],
      FilterSkillLst: []
    };
  },
  mounted() {
    let inputBox = document.querySelector("#skillSearchBar");
    let pre = inputBox.value;
    let skillCandidateCtnrTmp = document.querySelector("#skillCandidateCtnr");

    skillCandidateCtnrTmp.setAttribute(
      "style",
      "height: 250px; overflow-y: auto"
    );
    for (let i = 0; i < skills.length; i++)
      this.FilterSkillCandidate.push(skills[i]);
    let interval = setInterval(() => {
      let post = inputBox.value;
      if (pre != post) {
        this.FilterSkillCandidate = [];
        for (let candidate of searchSkillFunc(inputBox.value)) {
          let isDuplicate = false;
          for (let filterSkill of this.FilterSkillLst) {
            if (filterSkill === candidate) {
              isDuplicate = true;
              break;
            }
          }
          if (!isDuplicate) {
            this.FilterSkillCandidate.push(candidate);
          }
        }

        if (this.FilterSkillCandidate.length > 10) {
          skillCandidateCtnrTmp.removeAttribute("style");
          skillCandidateCtnrTmp.setAttribute(
            "style",
            "height: 250px; overflow-y: auto"
          );
        } else {
          skillCandidateCtnrTmp.removeAttribute("style");
          skillCandidateCtnrTmp.setAttribute("style", "overflow-y: auto");
        }
        pre = post;
      }
    }, 100);
  },
  methods: {
    ...mapActions(["registProject"]),

    insertSkill(value) {
      this.FilterSkillLst.push(value);
      const itemToFind = this.FilterSkillCandidate.find(function(item) {
        return item === value;
      });
      const idx = this.FilterSkillCandidate.indexOf(itemToFind);
      if (idx > -1) this.FilterSkillCandidate.splice(idx, 1);
      let skillCandidateCtnrTmp = document.querySelector("#skillCandidateCtnr");
      if (this.FilterSkillCandidate.length < 10) {
        skillCandidateCtnrTmp.removeAttribute("style");
        skillCandidateCtnrTmp.setAttribute("style", "overflow-y: auto");
      }
    },
    deleteSkill(value) {
      const itemToFind = this.FilterSkillLst.find(function(item) {
        return item === value;
      });
      const idx = this.FilterSkillLst.indexOf(itemToFind);
      if (idx > -1) this.FilterSkillLst.splice(idx, 1);
      let inputBox = document.querySelector("#skillSearchBar");
      this.FilterSkillCandidate = [];
      for (let candidate of searchSkillFunc(inputBox.value)) {
        let isDuplicate = false;
        for (let filterSkill of this.FilterSkillLst) {
          if (filterSkill === candidate) {
            isDuplicate = true;
            break;
          }
        }
        if (!isDuplicate) {
          this.FilterSkillCandidate.push(candidate);
        }
      }
      let skillCandidateCtnrTmp = document.querySelector("#skillCandidateCtnr");
      if (this.FilterSkillCandidate.length > 10) {
        skillCandidateCtnrTmp.removeAttribute("style");
        skillCandidateCtnrTmp.setAttribute(
          "style",
          "margin: 20px; height: 250px; overflow-y: auto"
        );
      }
    },

    clickRegisterProject() {
      document.querySelector("body").classList.add("hiddenScroll");
      // console.log(this.projectInfo);

      console.log(this.FilterSkillLst);
      let skillSelected = this.FilterSkillLst.join(",");
      createInstance()
        .post("/project", this.projectInfo, {
          headers: store.getters.authHeader
        })
        .then(res => {
          console.log(res.data);
          createInstance()
            .post(
              "/project/tech/" + String(res.data.projectId),
              {},
              {
                params: {
                  techList: skillSelected
                }
              }
            )
            .then(res => {
              console.log(res);
              document
                .querySelector("#completeRegisterProject")
                .classList.remove("d-none");
            })
            .catch(err => {
              alert("프로젝트 등록에 실패했습니다. 입력값을 확인해주세요");
            });
        })
        .catch(err => {
          alert("프로젝트 등록에 실패했습니다. 입력값을 확인해주세요");
        });
    },

    okRegisterProject() {
      document
        .querySelector("#completeRegisterProject")
        .classList.add("d-none");
      document.querySelector("body").classList.remove("hiddenScroll");
      this.$router.push("/mypage/company/projectstatus/recruit");
    }
  },
  components: {
    FilterSkillCandidate,
    FilterSkillSelect
  }
};
</script>

<style>
.project-regist-select-item:hover {
  cursor: pointer;
}
.project-regist-select-wrapper:hover {
  cursor: pointer;
}
.form-control {
  width: 20% !important;
}

.form-select {
  width: 20% !important;
}

.hiddenScroll {
  overflow: hidden !important;
}

#skillCandidateCtnr {
  border-radius: 20px;
  background-color: #fff;
  position: relative;
  left: 19%;
}
</style>
