<template>
  <div class="modal text-center" id="FilterModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.5);" >
    <div class="modal-dialog" id="FilterModalWrapper">
      <div class="modal-content" id="FilterModalContent">
        <button type="button" id="FilterModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        <b-container>
          <div id="FilterModalTitle">필터 추가하기</div>
          <hr>
          <b-container id="FilterCategory">
            <div class="FilterKeyword">분야</div>
            <hr>
            <FilterBtnGroup v-for="filterItem in FilterCategoryLst"
              :key="filterItem"
              :filterItem="filterItem"
            >
            </FilterBtnGroup>
            <div class="FilterKeyword">형태</div>
            <hr>
            <FilterBtnGroup v-for="filterItem in FilterFormLst"
              :key="filterItem"
              :filterItem="filterItem"
            >
            </FilterBtnGroup>
            <div class="FilterKeyword">기술</div>
            <hr>
            <div id="skillSelectCtnr">
              <FilterSkillSelect v-for="skillItem in FilterSkillLst"
              :key="skillItem"
              :skillItem="skillItem"
              @deleteSkill="deleteSkill"
              ></FilterSkillSelect>
            </div>
            <div id="skillSearchCtnr">
              <input type="text" id="skillSearchBar" autocomplete="off">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-search mb-1 mx-2" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
              </svg>
            </div>
            <div id="skillCandidateCtnr">
              <FilterSkillCandidate v-for="skillCandidate in FilterSkillCandidate"
              :key="skillCandidate"
              :skillCandidate="skillCandidate"
              @insertSkill="insertSkill"></FilterSkillCandidate>
            </div>
          </b-container>
        </b-container>   
      </div>
    </div>
  </div>
</template>

<script>
  import FilterBtnGroup from '@/components/Project/FilterBtnGroup.vue';
  import FilterSkillCandidate from '@/components/Project/FilterSkillCandidate.vue';
  import FilterSkillSelect from '@/components/Project/FilterSkillSelect.vue';
  import { searchSkillFunc, skills } from '../../../utils/skillSearch';

  export default {
    name : "FilterModal",
    data() {
      return {
        FilterCategoryLst : ['개발','디자인','기획'],
        FilterFormLst : ['웹사이트','앱(APP)','커머스/쇼핑몰','퍼블리싱','네트워크/보안','게임','일반소프트웨어','제품','영상','그래픽'],
        FilterSkillLst : [],
        FilterSkillCandidate : skills,
      }
    },
    mounted() {
      let inputBox = document.querySelector('#skillSearchBar')
      let pre = inputBox.value

      let interval = setInterval(() => {
        let post = inputBox.value
        if (pre != post){
          this.FilterSkillCandidate = []
          for (let candidate of searchSkillFunc(inputBox.value)) {
            let isDuplicate = false
            for (let filterSkill of this.FilterSkillLst){
              if (filterSkill === candidate){
                isDuplicate = true
                break
              }
            }
            if (!isDuplicate){
              this.FilterSkillCandidate.push(candidate)
            }
          }
          pre = post
        }
      }, 100)
    },
    methods : {
      insertSkill(value) {
        this.FilterSkillLst.push(value)
        const itemToFind = this.FilterSkillCandidate.find(function(item) {return item === value})
        const idx = this.FilterSkillCandidate.indexOf(itemToFind)
        if (idx > -1) this.FilterSkillCandidate.splice(idx, 1)
      },

      deleteSkill(value){
        const itemToFind = this.FilterSkillLst.find(function(item) {return item === value})
        const idx = this.FilterSkillLst.indexOf(itemToFind)
        if (idx > -1) this.FilterSkillLst.splice(idx, 1)
        let inputBox = document.querySelector('#skillSearchBar')
        this.FilterSkillCandidate = []
        for (let candidate of searchSkillFunc(inputBox.value)) {
          let isDuplicate = false
          for (let filterSkill of this.FilterSkillLst){
            if (filterSkill === candidate){
              isDuplicate = true
              break
            }
          }
          if (!isDuplicate){
            this.FilterSkillCandidate.push(candidate)
          }
        }
      }
    },
    components : {
      FilterBtnGroup,
      FilterSkillCandidate,
      FilterSkillSelect
    },
  }
</script>

<style>
  #FilterModal {
    background-color: rgba(0,0,0,0.2) !important;
    
  }

  #FilterModalWrapper {
    margin-top: 50px;
  }

  #FilterModalContent {
    border-radius: 15px;
    height: 650px; 
    overflow-y: auto;
  }

  #FilterModalContent::-webkit-scrollbar {
    width: 0px !important;
  }

  #FilterModalCloseBtn {
    position: fixed;
    top : 65px;
    right : 540px;
  }

  #FilterModalTitle {
    font-size: 24px;
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

  .FilterBtn {
    margin-left: 8px;
    margin-right: 8px;
    border-radius: 15px;
    border: 1px solid lightgray;
    background-color: white;
    font-size: 20px;
    margin-top : 10px;
    margin-bottom: 10px;
  }

  .FilterBtn:hover {
    border: 1px solid black;
  }

  .activeFilter {
    color : white;
    background-color: rgb(167, 164, 164);
  }

  #skillSearchCtnr {
    border-radius: 30px; 
    height: 40px !important; 
    border: 1px solid rgb(209, 207, 207); 
    text-align: center; 
    font-size: 18px;
    width : 75%;
    margin : auto
  }

  #skillSearchBar {
    border:none;
    width: 250px;
    margin-top : 4px;
    margin-left : 15px;
  }

  #skillSearchBar:focus {outline:none;}

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
    margin-top : 5px;
    margin-bottom: 5px;
    background-color: lightgray;
  }

  .skillSelectLetter {
    margin-left : 20px;
    margin-right : 10px;
    display: inline
  }

  #skillSelectCtnr {
    margin-bottom: 10px;
  }

  .skillCandidateLetter {
    margin-left : 7px;
  }
  
  #skillCandidateCtnr {
    margin-top: 20px;
    margin-bottom: 20px;
    height: 160px;
    overflow-y: auto
  }

  .skillDeleteBtn {
    margin-left: 8px;
    margin-bottom: 3px; 
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

</style>
