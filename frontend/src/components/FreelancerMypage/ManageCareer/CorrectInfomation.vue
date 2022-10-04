<template>
  <div>
    <div class="correct-info-header">
      <div class="d-flex justify-content-between">
        <div class="correct-userinfo-header-text">
          {{ userInfo.name }}님의 정보 수정
        </div>
        <div>
          <button class="userinfo-correct-finish-btn" @click="currectUserInfo">
            수정 완료
          </button>
        </div>
      </div>
      <hr />
    </div>
    <div class="correct-userinfo-content-wrapper">
      <div class="correct-userinfo-profile-introduce">
        <div class="mb-3">
          <label for="correctUserprofileIntroduce" class="form-label"
            >프로필 소개</label
          >
          <input
            style="width:100% !important"
            type="email"
            class="form-control"
            id="correctUserprofileIntroduce"
            placeholder="프로필 소개를 입력해 보세요!"
            v-model="userInfo.title"
          />
        </div>
      </div>
      <div class="correct-userinfo-careeryear">
        <label for="correctUserCareeryear" class="form-label">경력(년수)</label>
        <select
          id="correctUserCareeryear"
          class="form-select"
          aria-label="Default select example"
          v-model="userInfo.career_period"
        >
          <option
            v-for="(item, index) in 15"
            :key="index"
            :selected="item == 0 ? true : false"
            :value="item - 1"
            >{{ item - 1 }}년
            <div v-if="item == 15">이상</div></option
          >
        </select>
      </div>
      <div class="correct-userinfo-skill">
        <label for="currentUserInfoWrapperI" class="form-label">기술</label>
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
          <label for="skillSearchCtnr">기술 검색</label>
          <div id="skillSearchCtnr mb-3" style="display:inline">
            <input
              class="form-control"
              type="text"
              id="skillSearchBar"
              style="display:inline"
              autocomplete="off"
              v-model="searchingWord"
            />
          </div>

          <div class="candidate-skills-wrapper" id="candidateSkillsWrapperI">
            <div
              v-for="skillCandidate in FilterSkillCandidate"
              :key="skillCandidate"
              @click="insertSkill(skillCandidate)"
              class="skill-candidate-items"
            >
              {{ skillCandidate }}
            </div>
          </div>
        </div>
      </div>
      <div class="correct-userinfo-introduction">
        <div class="mb-3">
          <label for="correntUserInfoIntroduction" class="form-label"
            >소개</label
          >
          <textarea
            class="form-control"
            id="correntUserInfoIntroduction"
            rows="6"
            v-model="userInfo.introduce"
            style="width:100% !important"
          ></textarea>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { skills, searchSkillFunc } from "../../../utils/skillSearch.js";
import * as userInstance from "@/api/user.js";
export default {
  props: { originalUserInfo: { type: Object, default: {} } },
  data() {
    return {
      userInfo: {
        name: "김싸피",
        career_period: 0,
        introduce: "",
        title: ""
      },
      // 추가한 스킬 리스트
      FilterSkillLst: [],
      // 추가 할 수 있는 스킬 리스트
      FilterSkillCandidate: [],

      searchingWord: "검색어"
    };
  },
  mounted() {
    console.log(this.$route.params.originalUserInfo);
    this.userInfo.name = this.$route.params.originalUserInfo.name;
    console.log(this.$route.params.originalUserInfo.tech);
    this.FilterSkillLst = this.$route.params.originalUserInfo.tech;
    this.userInfo.career_period = this.$route.params.originalUserInfo.resume.career_period;
    this.userInfo.introduce = this.$route.params.originalUserInfo.resume.introduce;
    this.userInfo.title = this.$route.params.originalUserInfo.resume.title;
    for (let i = 0; i < skills.length; i++) {
      this.FilterSkillCandidate.push(skills[i]);
    }
    // console.log(this.FilterSkillCandidate);
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
      let skillCandidateCtnrTmp = document.querySelector(
        "#candidateSkillsWrapperI"
      );

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
    }
  },
  watch: {
    searchingWord(newval, oldval) {
      // console.log(newval + " : " + oldval);
      this.searchWorldChange();
    }
  },
  methods: {
    async currectUserInfo() {
      const data = {
        creer_period: this.userInfo.career_period,
        introduce: this.userInfo.introduce,
        title: this.userInfo.title
      };
      await userInstance.changeUserProfile(data, res => {});
      // console.log(this.filterSkill);
      // console.log(this.$route.params.originalUserInfo.username);
      console.log(this.FilterSkillLst);
      console.log(this.FilterSkillCandidate);
      await userInstance.setUserTech(
        this.FilterSkillLst,
        this.$route.params.originalUserInfo.username,
        res => {
          alert("기술 스택이 변경되었습니다.");
          this.$router.push({ name: "mycareer" });
        }
        // err => {
        // console.log(err);
        // }
      );
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
      let skillCandidateCtnrTmp = document.querySelector(
        "#candidateSkillsWrapperI"
      );
      if (this.FilterSkillCandidate.length < 10) {
        skillCandidateCtnrTmp.removeAttribute("style");
        skillCandidateCtnrTmp.setAttribute("style", "overflow-y: auto");
      }
      console.log(this.FilterSkillLst);
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
      let skillCandidateCtnrTmp = document.querySelector(
        "#candidateSkillsWrapperI"
      );
      if (this.FilterSkillCandidate.length > 10) {
        skillCandidateCtnrTmp.removeAttribute("style");
        skillCandidateCtnrTmp.setAttribute(
          "style",
          "margin: 20px; height: 250px; overflow-y: auto"
        );
      }
    }
  }
};
</script>

<style>
.skill-candidate-items:hover {
  font-weight: bold;
  font-size: larger;
  color: blue;
}
.correct-userinfo-content-wrapper {
  background-color: #eaeaea;
  border-radius: 30px;
  padding: 30px;
}
.userinfo-correct-finish-btn {
  background-color: #5d8aff;
  color: white;
  font-size: 20px;
  border-radius: 5px;
  border: none;
}
.correct-info-header {
}
.correct-userinfo-header-text {
  font-size: 24px;
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
</style>
