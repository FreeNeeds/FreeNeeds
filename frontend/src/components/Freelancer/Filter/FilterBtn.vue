<template>
  <div>
    <div class="d-flex justify-content-end">
      <button
        @click="startInterval"
        id="freelancerFilterBtn"
        data-bs-toggle="modal"
        data-bs-target="#ffilterModal"
        style="position : relative; top : 8px; right : 8px"
      >
        <div style="position:absolute;">
          <img
            class="freelancericon btnimg"
            width="55px"
            src="@/assets/images/freech6.png"
            alt=""
          />
        </div>
        <div>
          필터
        </div>
      </button>
    </div>
    <div
      id="ffilterModal"
      class="modal text-center"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
      data-bs-backdrop="false"
      style="background-color: rgba(0, 0, 0, 0.15);"
    >
      <div class="modal-dialog" id="FFilterModalWrapper">
        <div
          class="modal-content"
          id="FFilterModalContent"
          style="overflow-y: scroll;"
        >
          <button
            @click="clickFilterModalCloseBtn"
            type="button"
            id="FilterModalCloseBtn"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
          <button
            @click="applyFilter"
            type="button"
            id="FilterModalApplyBtn"
            class="d-none"
            style="bottom : 11vh !important"
          >
            <div id="FilterModalApplyBtnLetter">필터 적용</div>
          </button>
          <b-container>
            <div id="FilterModalTitle">필터 추가하기</div>
            <h5 class="fw-blod warnFilter mb-3" style="color : royalblue">
                적어도 한 개 이상의 필터를 적용해주세요!
            </h5>
            <b-container id="FilterCategory">
              <div class="FilterKeyword">기술</div>
              <hr>
              <div id="skillSelectCtnr">
                <FilterSkillSelect
                  v-for="(skillItem, index) in FilterSkillLst"
                  :key="`FSL-${index}`"
                  :skillItem="skillItem"
                  @deleteSkill="deleteSkill"
                ></FilterSkillSelect>
              </div>
              <div id="skillSearchCtnr">
                <input type="text" id="skillSearchBar" autocomplete="off" />
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
              <div id="FskillCandidateCtnr" class="mx-5 my-3">
                <FilterSkillCandidate
                  v-for="(skillCandidate, index) in FilterSkillCandidate"
                  :key="`FSC-${index}`"
                  :skillCandidate="skillCandidate"
                  @insertSkill="insertSkill"
                ></FilterSkillCandidate>
              </div>
            </b-container>
          </b-container>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import FilterModal from "@/components/Project/FilterModal.vue";
import FilterBtnGroup from "@/components/Project/FilterBtnGroup.vue";
import FilterSkillCandidate from "@/components/Project/FilterSkillCandidate.vue";
import FilterSkillSelect from "@/components/Project/FilterSkillSelect.vue";
import RegionBtn from "@/components/Project/RegionBtn.vue";
import RegionDetailBtn from "@/components/Project/RegionDetailBtn.vue";
import { searchSkillFunc, skills } from "@/utils/skillSearch.js";
import { regionKey, regionMap } from "@/utils/region.js";
import { mapActions } from "vuex";
export default {
  name: "FilterBtn",
  components: {
    // FilterModal,
    FilterBtnGroup,
    FilterSkillCandidate,
    FilterSkillSelect,
    RegionBtn,
    RegionDetailBtn
  },
  data() {
    return {
      isStop: 0,

      // 추가한 스킬 리스트
      FilterSkillLst: [],
      // 추가 할 수 있는 스킬 리스트
      FilterSkillCandidate: [],

      preActiveMap: {
        skill: []
      }
    };
  },
  mounted() {
    let inputBox = document.querySelector("#skillSearchBar");
    let pre = inputBox.value;
    let FskillCandidateCtnrTmp = document.querySelector("#FskillCandidateCtnr");

    FskillCandidateCtnrTmp.setAttribute(
      "style",
      "height: 250px; overflow-y: auto"
    );
    for (let i = 0; i < skills.length; i++)
      this.FilterSkillCandidate.push(skills[i]);
  },
  methods: {
    ...mapActions(["setFreelancerFilter"]),
    insertSkill(value) {
      this.FilterSkillLst.push(value);
      const itemToFind = this.FilterSkillCandidate.find(function(item) {
        return item === value;
      });
      const idx = this.FilterSkillCandidate.indexOf(itemToFind);
      if (idx > -1) this.FilterSkillCandidate.splice(idx, 1);
      let FskillCandidateCtnrTmp = document.querySelector(
        "#FskillCandidateCtnr"
      );
      if (this.FilterSkillCandidate.length < 10) {
        skillCandidateCtnrTmp.removeAttribute("style");
        skillCandidateCtnrTmp.setAttribute(
          "style",
          "overflow-y: auto; left: 0px"
        );
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
      let FskillCandidateCtnrTmp = document.querySelector(
        "#FskillCandidateCtnr"
      );
      if (this.FilterSkillCandidate.length > 10) {
        FskillCandidateCtnrTmp.removeAttribute("style");
        FskillCandidateCtnrTmp.setAttribute(
          "style",
          "margin: 20px; height: 250px; overflow-y: auto"
        );
      }
    },
    applyFilter() {
      let filterCnt = this.FilterSkillLst.length;
      if (filterCnt > 0) {
        // this.preActiveMap = { skill: [] };
        // for (let i = 0; i < this.FilterSkillLst.length; i++)
        //   this.preActiveMap["skill"].push(this.FilterSkillLst[i]);
        this.setFreelancerFilter(this.FilterSkillLst);
      } else {
        document.querySelector(".warnFilter").classList.remove("d-none");
      }
      $("#ffilterModal").modal("hide");
      this.isStop = 1;
    },
    clickFilterModalCloseBtn() {
      let inputBox = document.querySelector("#skillSearchBar");
      this.FilterSkillLst = [];
      inputBox.innerText = "";
      for (let i = 0; i < this.preActiveMap["skill"].length; i++)
        this.FilterSkillLst.push(this.preActiveMap["skill"][i]);
      this.isStop = 1;
    },

    startInterval() {
      this.isStop = 0;
      let inputBox = document.querySelector("#skillSearchBar");
      let pre = inputBox.value;
      let FskillCandidateCtnrTmp = document.querySelector(
        "#FskillCandidateCtnr"
      );

      let interval = setInterval(() => {
        console.log(this.isStop);
        if (this.isStop === 1) clearInterval(interval);
        let filterCnt = this.FilterSkillLst.length;
        // console.log("???");
        // console.log(filterCnt);
        if (filterCnt > 0) {
          if (
            document
              .querySelector("#FilterModalApplyBtn")
              .classList.contains("d-none")
          ) {
            document
              .querySelector("#FilterModalApplyBtn")
              .classList.remove("d-none");
            document.querySelector(".warnFilter").classList.add("d-none");
          }
        } else {
          if (
            document.querySelector(".warnFilter").classList.contains("d-none")
          ) {
            document.querySelector(".warnFilter").classList.remove("d-none");
            document
              .querySelector("#FilterModalApplyBtn")
              .classList.add("d-none");
          }
        }
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
            FskillCandidateCtnrTmp.removeAttribute("style");
            FskillCandidateCtnrTmp.setAttribute(
              "style",
              "height: 250px; overflow-y: auto"
            );
          } else {
            FskillCandidateCtnrTmp.removeAttribute("style");
            FskillCandidateCtnrTmp.setAttribute("style", "overflow-y: auto");
          }
          pre = post;
        }
      }, 200);
    }
  }
};
</script>

<style>
#freelancerFilterBtn {
  border-radius: 30px;
  width: 100px;
  height: 40px;
  border: 2px solid rgb(209, 207, 207);
  background-color: white;
  margin-left: 64%;
  font-size: 17px;
  font-weight: bold;
  text-align: center;
}

#filterBtn:hover {
  background-color: #6ecdb1;
  border: 0px;
  font-weight: bold;
}
#FilterModal {
  background-color: rgba(0, 0, 0, 0.2) !important;
}


#FilterModalContent {
  border-radius: 15px;
  height: 650px;
  overflow-y: scroll;
}

#FilterModalApplyBtn:hover {
  background-color: #3c74c9;
  color: white;
}

#FilterModalApplyBtnLetter {
  margin-left: 8px;
  margin-right: 8px;
  margin-top: 2px;
  margin-bottom: 2px;
}

#FilterModalContent::-webkit-scrollbar {
  width: 0px !important;
}

#FilterModalTitle {
  font-size: 24px;
  margin-top: 20px;
  margin-bottom: 20px;
}

.FilterKeyword {
  font-size: 24px;
  text-align: left;
  margin-bottom: 10px;
}

.FilterKeywordLetter {
  margin-left: 7px;
  margin-right: 7px;
  margin-top: 3px;
  margin-bottom: 3px;
}


.FilterBtn:hover {
  border: 1px solid black;
}

.activeFilter {
  color: white;
  background-color: rgb(167, 164, 164);
}

.regionSearchCtnrGroup {
  margin-top: 15px;
  margin-bottom: 15px;
}

#regionBtnGroup {
  border-radius: 15px;
  height: 300px;
  width: 45%;
  overflow-y: scroll;
}

#regionBtnGroup::-webkit-scrollbar {
  width: 0px !important;
}

#regionDetailBtnGroup {
  border-radius: 15px;
  overflow-y: scroll;
  width: 45%;
  scroll-behavior: smooth;
}

#regionDetailBtnGroup::-webkit-scrollbar {
  width: 0px !important;
}

#skillSearchCtnr {
  border-radius: 30px;
  height: 40px !important;
  border: 1px solid rgb(209, 207, 207);
  text-align: center;
  font-size: 18px;
  width: 75%;
  margin: auto;
}

#regionSearchCtnrWrapper {
  margin-bottom: 20px;
}

#regionSearchCtnr::after {
  position: relative;
  top: -1px;
  right: -5px;
}

#regionDetailSearchCtnr::after {
  position: relative;
  top: -1px;
  right: -5px;
}

#regionSearchCtnr {
  border-radius: 18px;
  height: 40px !important;
  border: 1px solid rgb(209, 207, 207);
  background-color: white;
  text-align: center;
  font-size: 18px;
  margin: auto;
  padding-left: 20px;
  padding-right: 20px;
  width: 45%;
}

#regionDetailSearchCtnr {
  border-radius: 18px;
  height: 40px !important;
  border: 1px solid rgb(209, 207, 207);
  background-color: white;
  text-align: center;
  font-size: 18px;
  margin: auto;
  padding-left: 20px;
  padding-right: 20px;
  width: 45%;
  display: none;
}

#skillSearchBar {
  border: none;
  width: 250px;
  margin-top: 4px;
  margin-left: 15px;
}

#regionSearchCtnr:hover {
  border: 1px solid black;
}

#skillSearchBar:focus {
  outline: none;
}

#regionDetailSearchCtnr:hover {
  border: 1px solid black;
}

.skillCandidateLetter:hover {
  color: blue;
  font-size: 18px;
  font-weight: 550;
}

.skillSelectBtn {
  margin-left: 8px;
  margin-right: 8px;
  border-radius: 15px;
  border: 1px solid lightgray;
  background-color: white;
  font-size: 18px;
  margin-top: 5px;
  margin-bottom: 5px;
  background-color: lightgray;
}

.skillSelectLetter {
  margin-left: 20px;
  margin-right: 10px;
  display: inline;
}

#skillSelectCtnr {
  margin-bottom: 10px;
}

.skillCandidateLetter {
  margin-left: 7px;
}

.skillDeleteBtn {
  margin-left: 8px;
  margin-bottom: 3px;
}

.regionLi {
  margin-top: 5px;
  margin-bottom: 5px;
}

.regionLi:hover {
  background-color: #e9ecef;
}

.regionItem {
  margin-left: 10%;
  margin-right: 10%;
  font-size: 1rem;
  color: #212529;
  text-align: center;
}

.regionItemDetail {
  margin-left: 10%;
  margin-right: 10%;
  font-size: 1rem;
  color: #212529;
  text-align: center;
}

*::-webkit-scrollbar {
  width: 10px;
}

*::-webkit-scrollbar-thumb {
  background-color: #2f3542;
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

#FFilterModalContent::-webkit-scrollbar {
  width: 0px;
}

#freelancerFilterBtn:hover {
  background-color: #6ecdb1;
  border: 0px;
  font-weight: bold;
}
</style>
