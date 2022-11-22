<template>
  <div
    class="modal"
    id="addProjectModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="false"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">프로젝트 이력 추가</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="add-project-items add-project-category">
            <label class="add-project-label">분야</label>
            <select
              class="form-select"
              aria-label="Default select example"
              v-model="projectData.category"
            >
              <option
                v-for="(item, index) in FilterCategoryLst"
                :key="index"
                :selected="index == 0 ? true : false"
                >{{ item }}</option
              >
            </select>
          </div>
          <div class="add-project-items add-project-domain">
            <label class="add-project-label">형태</label>
            <select
              class="form-select"
              aria-label="Default select example"
              v-model="projectData.domain"
            >
              <option
                v-for="(item, index) in FilterFormLst"
                :key="index"
                :selected="index == 0 ? true : false"
                >{{ item }}</option
              >
            </select>
          </div>
          <div class="add-project-items add-project-company-name">
            <label
              for="currentUserInfoWrapperI"
              class="form-label add-project-label"
              >기술</label
            >
            <div class="correct-userinfo-wrapper" id="currentUserInfoWrapperI">
              <label for="selectedSkillsWrapperI"> 선택된 기술 </label>
              <div class="selected-skills-wrapper" id="selectedSkillsWrapperI">
                <div
                  class="selected-skills-item"
                  v-for="skillItem in FilterSkillLst"
                  :key="skillItem"
                  @click="deleteSkill(skillItem)"
                >
                  {{ skillItem }}
                </div>
              </div>
              <hr />

              <div class="mb-3" style="display:inline;">
                <label
                  for="addProjectSearch"
                  style="display:inline; margin-right: 20px;"
                  >기술 검색</label
                >
                <input
                  id="addProjectSearch"
                  type="text"
                  class="form-control"
                  placeholder="검색..."
                  v-model="searchingWord"
                  style="display:inline;"
                />
              </div>

              <div
                class="candidate-skills-wrapper"
                id="candidateSkillsWrapperI"
              >
                <div
                  v-for="skillCandidate in FilterSkillCandidate"
                  :key="skillCandidate"
                  class="add-project-skill-item"
                  @click="insertSkill(skillCandidate)"
                >
                  {{ skillCandidate }}
                </div>
              </div>
            </div>
          </div>
          <div class="add-project-items add-project-companyname">
            <label
              class="add-project-label"
              for="addProjectCompanyName"
              style="display:inline-block; padding-right: 30px;"
              >기업명</label
            >
            <input
              type="text"
              class="form-control"
              id="addProjectCompanyName"
              placeholder="기업명..."
              style="display:inline-block"
              v-model="projectData.companyName"
            />
          </div>
          <div class="add-project-items add-project-title">
            <!-- <label class="add-project-label">프로젝트 명</label> -->
            <label
              class="add-project-label"
              for="addProjectProjectName"
              style="display:inline-block; padding-right: 30px;"
              >프로젝트 명</label
            >
            <input
              type="text"
              class="form-control"
              id="addProjectProjectName"
              placeholder="프로젝트 명..."
              style="display:inline-block"
              v-model="projectData.title"
            />
          </div>

          <div class="add-project-items add-project-content mb-3">
            <label
              class="add-project-label"
              for="addProjectWorkContent"
              style="display:inline-block;"
              >담당 업무</label
            >
            <textarea
              class="form-control"
              id="addProjectWorkContent"
              rows="6"
              v-model="projectData.content"
              style="width:100% !important"
            ></textarea>
          </div>
          <div class="add-project-items add-project-">
            <label class="add-project-label">기간</label>
            <input
              type="date"
              id="addProjectStartDate"
              min="1990-01-01"
              class="add-project-standard-datepicker"
              v-model="projectData.start_date"
            />
            ~
            <input
              type="date"
              id="addProjectEndDate"
              min="1990-01-01"
              class="add-project-standard-datepicker"
              v-model="projectData.end_date"
            />
          </div>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            취소
          </button>
          <button type="button" class="btn btn-primary" @click="addUserProject">
            추가
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { skills, searchSkillFunc } from "../../../utils/skillSearch";
import * as userInstance from "@/api/user.js";
import { mapGetters } from "vuex";
import router from "../../../router";
export default {
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  mounted() {
    for (let i = 0; i < skills.length; i++) {
      this.FilterSkillCandidate.push(skills[i]);
    }
    console.log(this.FilterSkillCandidate);
    this.FilterSkillCandidate = [];
    // console.log(document.querySelector("#skillSearchBar").value);
    for (let candidate of searchSkillFunc(this.searchingWord)) {
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
      // let skillCandidateCtnrTmp = document.querySelector(
      //   "#candidateSkillsWrapperI"
      // );

      // if (this.FilterSkillCandidate.length > 10) {
      //   skillCandidateCtnrTmp.removeAttribute("style");
      //   skillCandidateCtnrTmp.setAttribute(
      //     "style",
      //     "height: 250px; overflow-y: auto"
      //   );
      // } else {
      //   skillCandidateCtnrTmp.removeAttribute("style");
      //   skillCandidateCtnrTmp.setAttribute("style", "overflow-y: auto");
      // }
    }
  },
  watch: {
    searchingWord() {
      this.searchWorldChange();
    }
  },
  methods: {
    async addUserProject() {
      let projectId;
      await userInstance.setUserProject(this.projectData, res => {
        console.log(res);
        projectId = res.data;
      });
      console.log(this.FilterSkillLst + " : " + projectId);
      $("addProjectModal").modal("hidden");
      userInstance.setUserProjectTech(projectId, this.FilterSkillLst, res => {
        // router.push({
        //   name: "mypage"
        // });
      });
    },
    searchWorldChange() {
      this.FilterSkillCandidate = [];
      for (let candidate of searchSkillFunc(this.searchingWord)) {
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
    },
    insertSkill(value) {
      this.FilterSkillLst.push(value);
      const itemToFind = this.FilterSkillCandidate.find(function(item) {
        return item === value;
      });
      const idx = this.FilterSkillCandidate.indexOf(itemToFind);
      if (idx > -1) this.FilterSkillCandidate.splice(idx, 1);
      // let skillCandidateCtnrTmp = document.querySelector(
      //   "#candidateSkillsWrapperI"
      // );
      // if (this.FilterSkillCandidate.length < 10) {
      //   skillCandidateCtnrTmp.removeAttribute("style");
      //   skillCandidateCtnrTmp.setAttribute("style", "overflow-y: auto");
      // }
    },

    deleteSkill(value) {
      const itemToFind = this.FilterSkillLst.find(function(item) {
        return item === value;
      });
      const idx = this.FilterSkillLst.indexOf(itemToFind);
      if (idx > -1) this.FilterSkillLst.splice(idx, 1);

      this.FilterSkillCandidate = [];
      for (let candidate of searchSkillFunc(this.searchingWord)) {
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
      // let skillCandidateCtnrTmp = document.querySelector(
      //   "#candidateSkillsWrapperI"
      // );
      // if (this.FilterSkillCandidate.length > 10) {
      //   skillCandidateCtnrTmp.removeAttribute("style");
      //   skillCandidateCtnrTmp.setAttribute(
      //     "style",
      //     "margin: 20px; height: 250px; overflow-y: auto"
      //   );
      // }
    }
  },
  data() {
    return {
      FilterCategoryLst: ["개발", "디자인", "기획"],
      FilterFormLst: [
        "웹사이트",
        "앱(APP)",
        "커머스/쇼핑몰",
        "퍼블리싱",
        "네트워크/보안",
        "게임",
        "일반소프트웨어",
        "제품",
        "영상",
        "그래픽"
      ],
      // 추가한 스킬 리스트
      FilterSkillLst: [],
      // 추가 할 수 있는 스킬 리스트
      FilterSkillCandidate: [],
      searchingWord: "",
      projectData: {
        category: "",
        domain: "",
        companyName: "",
        title: "",
        content: "",
        start_date: "2022-01-01",
        end_date: "2022-12-01"
      }
    };
  }
};
</script>

<style>
.add-project-skill-item:hover {
  font-weight: bold;
  font-size: larger;
  color: blue;
}
.add-project-standard-datepicker {
  margin-left: 10px;
  margin-right: 10px;
  zoom: 1.2;
}
#candidateSkillsWrapperI {
  margin: 20px;
  height: 250px;
  overflow-y: auto;
}
.candidate-skills-wrapper {
  margin-top: 20px;
  border-radius: 10px;
  border: 1px solid black;
  padding: 20px;
  background-color: white;
}
.selected-skills-item {
  border: 1px black solid;
  display: inline-block;
  margin: 10px;
  padding: 7px 20px 7px 20px;
  border-radius: 10px;
  background-color: white;
}
.selected-skills-wrapper {
  margin-top: 20px;
}
.add-project-label {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
}
.add-project-items {
  margin-bottom: 30px;
}
</style>
