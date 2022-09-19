<template>
  <div class="modal text-center" id="FilterModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.5);" >
    <div class="modal-dialog" id="FilterModalWrapper">
      <div class="modal-content" id="FilterModalContent">
        <button @click="clickFilterModalCloseBtn" type="button" id="FilterModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        <button @click="applyFilter" type="button" id="FilterModalApplyBtn" data-bs-dismiss="modal" aria-label="Close">
          <div id="FilterModalApplyBtnLetter">필터 적용</div>
        </button>
        <b-container>
          <div id="FilterModalTitle">필터 추가하기</div>
          <b-container id="FilterCategory">
            <div class="FilterKeyword">분야</div>
            <hr>
            <FilterBtnGroup v-for="filterItem in FilterCategoryLst"
              :key="filterItem"
              :filterItem="filterItem"
              @addFilterCategory="addFilterCategory"
              @removeFilterCategory="removeFilterCategory"
            >
            </FilterBtnGroup>
            <div class="FilterKeyword">형태</div>
            <hr>
            <FilterBtnGroup v-for="filterItem in FilterFormLst"
              :key="filterItem"
              :filterItem="filterItem"
              @addFilterForm="addFilterForm"
              @removeFilterForm="removeFilterForm"
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
            <div id="skillCandidateCtnr" class="mx-5 my-3">
              <FilterSkillCandidate v-for="skillCandidate in FilterSkillCandidate"
              :key="skillCandidate"
              :skillCandidate="skillCandidate"
              @insertSkill="insertSkill"></FilterSkillCandidate>
            </div>
            <div class="FilterKeyword">지역</div>
            <hr>
            <div id="regionSearchCtnrWrapper">
              <div class="dropup-center dropup regionSearchCtnrGroup">
                <button class="dropdown-toggle" id="regionSearchCtnr" data-bs-toggle="dropdown" aria-expanded="false">전체</button>
                <ul class="dropdown-menu" id="regionBtnGroup">
                  <RegionBtn v-for="region in RegionLst"
                  :key="region"
                  :region="region"
                  @clickRegion="clickRegion"
                  >
                  </RegionBtn>
                </ul>
              </div>
              <div class="dropup-center dropup regionSearchCtnrGroup">
                <button class="dropdown-toggle" id="regionDetailSearchCtnr" data-bs-toggle="dropdown" aria-expanded="false">전체</button>
                <ul class="dropdown-menu" id="regionDetailBtnGroup">
                  <RegionDetailBtn v-for="region in RegionDetailLst"
                  :key="region"
                  :region="region"
                  @clickRegionDetail="clickRegionDetail"
                  >
                  </RegionDetailBtn>
                </ul>
              </div>
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
  import RegionBtn from '@/components/Project/RegionBtn.vue';
  import RegionDetailBtn from '@/components/Project/RegionDetailBtn.vue';
  import { searchSkillFunc, skills } from '../../utils/skillSearch';
  import { regionKey, regionMap } from '../../utils/region';
  import { findProjectListByFilter } from '@/api/projectAPI';

  export default {
    name : "FilterModal",
    data() {
      return {
        FilterCategoryLst : ['개발','디자인','기획'],
        FilterFormLst : ['웹사이트','앱(APP)','커머스/쇼핑몰','퍼블리싱','네트워크/보안','게임','일반소프트웨어','제품','영상','그래픽'],
        FilterSkillLst : [],
        FilterSkillCandidate : [],
        RegionLst: regionKey,
        RegionDetailLst : [],
        activeFilterCategoryLst : [],
        activeFilterFormLst : [],
        preActiveMap : {'category' : [], 'form' : [], 'skill' : [], 'region' : ['전체','전체']}
      }
    },
    mounted() {
      let inputBox = document.querySelector('#skillSearchBar')
      let pre = inputBox.value
      let skillCandidateCtnrTmp = document.querySelector('#skillCandidateCtnr')

      skillCandidateCtnrTmp.setAttribute('style','height: 250px; overflow-y: auto')
      for (let i = 0; i < skills.length; i++) this.FilterSkillCandidate.push(skills[i])
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

          if (this.FilterSkillCandidate.length > 10) {
            skillCandidateCtnrTmp.removeAttribute('style')
            skillCandidateCtnrTmp.setAttribute('style','height: 250px; overflow-y: auto')
          } else {
            skillCandidateCtnrTmp.removeAttribute('style')
            skillCandidateCtnrTmp.setAttribute('style','overflow-y: auto')
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
        let skillCandidateCtnrTmp = document.querySelector('#skillCandidateCtnr')
        if (this.FilterSkillCandidate.length < 10) {
          skillCandidateCtnrTmp.removeAttribute('style')
          skillCandidateCtnrTmp.setAttribute('style','overflow-y: auto')
        }
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
        let skillCandidateCtnrTmp = document.querySelector('#skillCandidateCtnr')
        if (this.FilterSkillCandidate.length > 10) {
          skillCandidateCtnrTmp.removeAttribute('style')
          skillCandidateCtnrTmp.setAttribute('style','margin: 20px; height: 250px; overflow-y: auto')
        }
      },
      clickRegion(value) {
        let regionBtn = document.querySelector('#regionSearchCtnr')
        let regionDetail = document.querySelector('#regionDetailSearchCtnr')
        let filterModalContent = document.querySelector('#FilterModalContent')
        regionBtn.innerText = value
        if (value != "전체"){  
          regionDetail.setAttribute('style','display: block')
          filterModalContent.scrollTop = filterModalContent.scrollHeight
          this.RegionDetailLst = []
          for (let city of regionMap[value]) this.RegionDetailLst.push(city)
          if (this.RegionDetailLst.length > 8) {
            let regionDetailBtnGroupTmp = document.querySelector('#regionDetailBtnGroup')
            regionDetailBtnGroupTmp.setAttribute('style','height: 300px')
          }
        } else {
          regionDetail.setAttribute('style','display: none')
        }
      },
      clickRegionDetail(value) {
        let regionDetail = document.querySelector('#regionDetailSearchCtnr')
        regionDetail.innerText = value
      },
      addFilterCategory(value) {
        let isDuplicate = false
        for (let activeFilter of this.activeFilterCategoryLst){
          if (activeFilter == value) isDuplicate = true
        }
        if (!isDuplicate) this.activeFilterCategoryLst.push(value)
      },
      addFilterForm(value) {
        let isDuplicate = false
        for (let activeFilter of this.activeFilterFormLst){
          if (activeFilter == value) isDuplicate = true
        }
        if (!isDuplicate) this.activeFilterFormLst.push(value)
      },
      removeFilterCategory(value) {
        const itemToFind = this.activeFilterCategoryLst.find(function(item) {return item === value})
        const idx = this.activeFilterCategoryLst.indexOf(itemToFind)
        if (idx > -1) this.activeFilterCategoryLst.splice(idx, 1)
      },
      removeFilterForm(value) {
        const itemToFind = this.activeFilterFormLst.find(function(item) {return item === value})
        const idx = this.activeFilterFormLst.indexOf(itemToFind)
        if (idx > -1) this.activeFilterFormLst.splice(idx, 1)
      },
      applyFilter() {
        let regionBig = document.querySelector('#regionSearchCtnr').innerText
        let regionDetail = document.querySelector('#regionDetailSearchCtnr').innerText
        findProjectListByFilter(
          this.activeFilterCategoryLst.join(),
          this.activeFilterFormLst.join(),
          this.FilterSkillLst.join(),
          [regionBig,regionDetail].join()
        )
        
        this.preActiveMap = {'category' : [], 'form' : [], 'skill' : [], 'region' : []}
        for (let i = 0; i < this.activeFilterCategoryLst.length; i++) this.preActiveMap['category'].push(this.activeFilterCategoryLst[i])
        for (let i = 0; i < this.activeFilterFormLst.length; i++) this.preActiveMap['form'].push(this.activeFilterFormLst[i])
        for (let i = 0; i < this.FilterSkillLst.length; i++) this.preActiveMap['skill'].push(this.FilterSkillLst[i])
        for (let i = 0; i < [regionBig,regionDetail].length; i++) this.preActiveMap['region'].push([regionBig,regionDetail][i])
      },
      clickFilterModalCloseBtn() {
        let regionBig = document.querySelector('#regionSearchCtnr')
        let regionDetail = document.querySelector('#regionDetailSearchCtnr')
        let inputBox = document.querySelector('#skillSearchBar')
        
        for (let activeFilter of this.activeFilterCategoryLst){
          let filterBtnTmp = document.querySelector('#' + activeFilter)
          filterBtnTmp.classList.remove('activeFilter') 
        }
        for (let activeFilter of this.activeFilterFormLst){
          activeFilter = activeFilter.split('/')[0]
          activeFilter = activeFilter.split('(')[0]
          let filterBtnTmp = document.querySelector('#' + activeFilter)
          filterBtnTmp.classList.remove('activeFilter') 
        }
        this.activeFilterCategoryLst = []
        this.activeFilterFormLst = []
        this.FilterSkillLst = []
        inputBox.innerText = ''
        regionBig.innerText = this.preActiveMap['region'][0]
        regionDetail.innerText = this.preActiveMap['region'][1]
        
        for (let i = 0; i < this.preActiveMap['category'].length; i++) 
          this.activeFilterCategoryLst.push(this.preActiveMap['category'][i])
        for (let i = 0; i < this.preActiveMap['form'].length; i++) 
          this.activeFilterFormLst.push(this.preActiveMap['form'][i])
        for (let i = 0; i < this.preActiveMap['skill'].length; i++) 
          this.FilterSkillLst.push(this.preActiveMap['skill'][i])
        for (let activeFilter of this.activeFilterCategoryLst){
          let filterBtnTmp = document.querySelector('#' + activeFilter)
          filterBtnTmp.classList.add('activeFilter')
        }
        for (let activeFilter of this.activeFilterFormLst){
          activeFilter = activeFilter.split('/')[0]
          activeFilter = activeFilter.split('(')[0]
          let filterBtnTmp = document.querySelector('#' + activeFilter)
          filterBtnTmp.classList.add('activeFilter') 
        }
      }
    },
    components : {
      FilterBtnGroup,
      FilterSkillCandidate,
      FilterSkillSelect,
      RegionBtn,
      RegionDetailBtn
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
    overflow-y: scroll;
  }

  #FilterModalApplyBtn {
    position: fixed;
    top : 645px;
    right : 540px;
    z-index : 2;
    border-radius: 40px;
    border: 1px solid lightgray;
    background-color: #6ecdb1;
    font-size: 15px;
    font-weight: bold;
    width: 105px;
    height: 40px;
  }
  #FilterModalApplyBtn:hover {
    background-color: #3C74C9;
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

  #FilterModalCloseBtn {
    position: fixed;
    top : 65px;
    right : 540px;
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

  .regionSearchCtnrGroup {
    margin-top: 15px;
    margin-bottom: 15px;
  }
  
  #regionBtnGroup {
    border-radius: 15px;
    height: 300px;
    width: 45%;
    overflow-y: scroll;
    scroll-behavior: smooth;
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
    width : 75%;
    margin : auto
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
    width: 45%
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
    border:none;
    width: 250px;
    margin-top : 4px;
    margin-left : 15px;
  }

  #regionSearchCtnr:hover {
    border: 1px solid black;
  }

  #skillSearchBar:focus {outline:none;}

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

  .skillDeleteBtn {
    margin-left: 8px;
    margin-bottom: 3px; 
  }
  
  .regionLi {
    margin-top : 5px;
    margin-bottom : 5px;
  }

  .regionLi:hover {
    background-color: #e9ecef;
  }

  .regionItem {
    margin-left : 10%;
    margin-right : 10%;
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

</style>
