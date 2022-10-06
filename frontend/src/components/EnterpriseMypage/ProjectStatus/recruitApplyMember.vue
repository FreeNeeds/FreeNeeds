<template>
  <div id="freelancer-list">
    <div style="width : 0px; height : 0px">
      <button @click="clickContractBefore" id="clickBefore" class="activeContract" style=
      "border: 0px; border-radius : 40px; width : 22px; height : 22px;  position : relative; top : 51px; left : 210px;"
      ></button>
      <div style=
      "position : relative; top: -10px; left : 192px; width: 70px"
      >계약 전</div>
      <button @click="clickContractIng" id="clickIng" style=
      "border : 0px; border-radius : 40px; width : 22px; height : 22px; position : relative; top : -1px; left : 460px;"
      ></button>
      <div style=
      "position : relative; top : -62px; left : 444px;  width: 70px"
      >계약 중</div>
      <button @click="clickContractAfter" id="clickAfter" style=
      "border : 0px; border-radius : 40px; width : 22px; height : 22px; position : relative; top : -50px; left : 710px;"
      ></button>
      <div style=
      "position : relative; top : -110px; left : 686px;  width: 70px"
      >계약 완료</div>

    </div>
    <div class="mx-auto" style="height : 1.5px; background-color : black; width : 80%; margin-top : 60px; margin-bottom: 60px;"></div>
    <div id="beforeFreelancerCardLst">
      <recruitApplyMemberItem
      v-for="freelancerCard in beforeFreelancerCardLst"
      :key="freelancerCard.id"
      :projectId="projectIdTmp"
      :freelancerCardId="freelancerCard.body.user.userId"
      :state="stateBefore"
      @moveToIngContract="moveToIngContract"></recruitApplyMemberItem>
    </div>
    <div id="ingFreelancerCardLst" class='deactiveProjectDetailItem'>
      <recruitApplyMemberItemIng
      v-for="freelancerCard in ingFreelancerCardLst"
      :key="freelancerCard.id"
      :projectId="projectIdTmp"
      :state="stateIng"
      :freelancerCardId="freelancerCard.body.user.userId"></recruitApplyMemberItemIng>
    </div>
    <div id="afterFreelancerCardLst" class='deactiveProjectDetailItem'>
      <recruitApplyMemberItemAfter
      v-for="freelancerCard in afterFreelancerCardLst"
      :key="freelancerCard.id"
      :projectId="projectIdTmp"
      :state="stateAfter"
      :stateTmp="stateTmp"
      :freelancerCardId="freelancerCard.body.user.userId"
      @clickEstimateBtn="clickEstimateBtn"
      ></recruitApplyMemberItemAfter>      
    </div>
    <div id="alreadyDoneEstimateWrpr" class="d-none alreadyDoneEstimateWrpr">
      <div class="alreadyDoneEstimate text-center">
        <h4 class="mt-5">이미 평가를 마친 프리랜서입니다.</h4>
        <button @click="alreadyDoneClose" class="estimateCompleteBtn" style="top : 300px">확인</button>
      </div>
    </div>
    <div id="estimateModalWrpr" class="d-none estimateModalWrpr">
      <div class="estimateModal">
        <div style="height : 0px">
        <button
        @click="clickEstimateModalCloseBtn"
        type="button"
        id="estimateModalCloseBtn"
        class="btn-close"
        ></button>
        </div>
        <h5 class="mt-4 text-center">
          <h3 class="fw-bold d-inline-block">{{ nameErase }}</h3>
          님을 평가해주세요
        </h5>
        <div class="d-flex align-items-center">
          <h5 style="width: 110px; margin-top : 20px; margin-left : 30px; margin-bottom : 0px">전문성</h5>
          <h5 style="width: 15px; margin-top : 25px;"></h5>
          <div class="d-inline-block" style="margin-top: 20px">
            <div class="star-ratings d-inline-block mx-2">
              <div  style="height : 0px">
              <label for="radio1" id="select1" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio2" id="select2" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio3" id="select3" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio4" id="select4" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio5" id="select5" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio6" id="select6" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio7" id="select7" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio8" id="select8" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio9" id="select9" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio10" id="select10" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <input id="radio0" type="radio" name="radioGroup1" class="radio">
              <input id="radio1" type="radio" name="radioGroup1" class="radio">
              <input id="radio2" type="radio" name="radioGroup1" class="radio">
              <input id="radio3" type="radio" name="radioGroup1" class="radio">
              <input id="radio4" type="radio" name="radioGroup1" class="radio">
              <input id="radio5" type="radio" name="radioGroup1" class="radio">
              <input id="radio6" type="radio" name="radioGroup1" class="radio">
              <input id="radio7" type="radio" name="radioGroup1" class="radio">
              <input id="radio8" type="radio" name="radioGroup1" class="radio">
              <input id="radio9" type="radio" name="radioGroup1" class="radio">
              <input id="radio10" type="radio" name="radioGroup1" class="radio">
              <div
                class="star-ratings-fill star-ratings-fill-start space-x-2 text-lg"
              >
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="d-flex align-items-center">
          <h5 style="width: 110px; margin-top : 20px; margin-left : 30px; margin-bottom : 0px">일정준수</h5>
          <h5 style="width: 15px; margin-top : 25px;"></h5>
          <div class="d-inline-block" style="margin-top: 20px">
            <div class="star-ratings d-inline-block mx-2">
              <div style="height : 0px">
              <label for="radio11" id="select1" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio12" id="select2" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio13" id="select3" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio14" id="select4" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio15" id="select5" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio16" id="select6" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio17" id="select7" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio18" id="select8" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio19" id="select9" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio20" id="select10" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <input id="radio0" type="radio" name="radioGroup2" class="radio">
              <input id="radio11" type="radio" name="radioGroup2" class="radio">
              <input id="radio12" type="radio" name="radioGroup2" class="radio">
              <input id="radio13" type="radio" name="radioGroup2" class="radio">
              <input id="radio14" type="radio" name="radioGroup2" class="radio">
              <input id="radio15" type="radio" name="radioGroup2" class="radio">
              <input id="radio16" type="radio" name="radioGroup2" class="radio">
              <input id="radio17" type="radio" name="radioGroup2" class="radio">
              <input id="radio18" type="radio" name="radioGroup2" class="radio">
              <input id="radio19" type="radio" name="radioGroup2" class="radio">
              <input id="radio20" type="radio" name="radioGroup2" class="radio">
              <div
                class="star-ratings-fill star-ratings-fill-start space-x-2 text-lg"
              >
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="d-flex align-items-center">
          <h5 style="width: 110px; margin-top : 20px; margin-left : 30px; margin-bottom : 0px">적극성</h5>
          <h5 style="width: 15px; margin-top : 25px;"></h5>
          <div class="d-inline-block" style="margin-top: 20px">
            <div class="star-ratings d-inline-block mx-2">
              <div style="height : 0px">
              <label for="radio21" id="select1" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio22" id="select2" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio23" id="select3" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio24" id="select4" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio25" id="select5" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio26" id="select6" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio27" id="select7" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio28" id="select8" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio29" id="select9" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio30" id="select10" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <input id="radio0" type="radio" name="radioGroup3" class="radio">
              <input id="radio21" type="radio" name="radioGroup3" class="radio">
              <input id="radio22" type="radio" name="radioGroup3" class="radio">
              <input id="radio23" type="radio" name="radioGroup3" class="radio">
              <input id="radio24" type="radio" name="radioGroup3" class="radio">
              <input id="radio25" type="radio" name="radioGroup3" class="radio">
              <input id="radio26" type="radio" name="radioGroup3" class="radio">
              <input id="radio27" type="radio" name="radioGroup3" class="radio">
              <input id="radio28" type="radio" name="radioGroup3" class="radio">
              <input id="radio29" type="radio" name="radioGroup3" class="radio">
              <input id="radio30" type="radio" name="radioGroup3" class="radio">
              <div
                class="star-ratings-fill star-ratings-fill-start space-x-2 text-lg"
              >
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="d-flex align-items-center">
          <h5 style="width: 110px; margin-top : 20px; margin-left : 30px; margin-bottom : 0px">의사소통</h5>
          <h5 style="width: 15px; margin-top : 25px;"></h5>
          <div class="d-inline-block" style="margin-top: 20px">
            <div class="star-ratings d-inline-block mx-2">
              <div style="height : 0px">
              <label for="radio31" id="select1" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio32" id="select2" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio33" id="select3" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio34" id="select4" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio35" id="select5" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio36" id="select6" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio37" id="select7" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio38" id="select8" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio39" id="select9" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio40" id="select10" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <input id="radio0" type="radio" name="radioGroup4" class="radio">
              <input id="radio31" type="radio" name="radioGroup4" class="radio">
              <input id="radio32" type="radio" name="radioGroup4" class="radio">
              <input id="radio33" type="radio" name="radioGroup4" class="radio">
              <input id="radio34" type="radio" name="radioGroup4" class="radio">
              <input id="radio35" type="radio" name="radioGroup4" class="radio">
              <input id="radio36" type="radio" name="radioGroup4" class="radio">
              <input id="radio37" type="radio" name="radioGroup4" class="radio">
              <input id="radio38" type="radio" name="radioGroup4" class="radio">
              <input id="radio39" type="radio" name="radioGroup4" class="radio">
              <input id="radio40" type="radio" name="radioGroup4" class="radio">
              <div
                class="star-ratings-fill star-ratings-fill-start space-x-2 text-lg"
              >
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="d-flex align-items-center">
          <h5 style="width: 110px; margin-top : 20px; margin-left : 30px; margin-bottom : 0px">재고용의사 </h5>
          <h5 style="width: 15px; margin-top : 25px;"></h5>
          <div class="d-inline-block" style="margin-top: 20px">
            <div class="star-ratings d-inline-block mx-2">
              <div style="height : 0px">
              <label for="radio41" id="select1" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio42" id="select2" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio43" id="select3" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio44" id="select4" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio45" id="select5" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio46" id="select6" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio47" id="select7" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio48" id="select8" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio49" id="select9" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <label for="radio50" id="select10" style="position: relative; border : 1px solid black; width : 20px; height : 40px" class="selectItem"></label>
              <input id="radio40" type="radio" name="radioGroup5" class="radio">
              <input id="radio41" type="radio" name="radioGroup5" class="radio">
              <input id="radio42" type="radio" name="radioGroup5" class="radio">
              <input id="radio43" type="radio" name="radioGroup5" class="radio">
              <input id="radio44" type="radio" name="radioGroup5" class="radio">
              <input id="radio45" type="radio" name="radioGroup5" class="radio">
              <input id="radio46" type="radio" name="radioGroup5" class="radio">
              <input id="radio47" type="radio" name="radioGroup5" class="radio">
              <input id="radio48" type="radio" name="radioGroup5" class="radio">
              <input id="radio49" type="radio" name="radioGroup5" class="radio">
              <input id="radio50" type="radio" name="radioGroup5" class="radio">
              <div
                class="star-ratings-fill star-ratings-fill-start space-x-2 text-lg"
              >
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="rgb(255, 205, 14)" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
                <span>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="mt-5 d-flex justify-content-center">
          <button @click="completeEstimate" class="estimateCompleteBtn">평가완료</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import recruitApplyMemberItem from "@/components/EnterpriseMypage/ProjectStatus/recruitApplyMemberItem.vue";
import recruitApplyMemberItemIng from "./recruitApplyMemberItemIng.vue";
import recruitApplyMemberItemAfter from "./recruitApplyMemberItemAfter.vue";
import { createInstance } from "@/api/index.js";

export default {
  props : {
    projectId : {
      type : Number,
      default : 0
    },
    state : {
      type : String,
      default : ""
    }
  },
  data() {
    return {
      myProjectLst : [],
      beforeFreelancerCardLst : [],
      ingFreelancerCardLst : [],
      afterFreelancerCardLst : [],
      isEstimate : [],
      projectIdTmp : 0,
      stateBefore : "before",
      stateIng : "Ing",
      stateAfter : "After",
      nameErase : "",
      username : '',
      freeTmpId : '',
      freelancerCardItem : {
        projectCareerId : "1",
        category : "개발",
        domain : "웹사이트",
        company_name : "한국투자공사",
        title : "한국투자공사 모바일 가상화 시스템 구축",
        content : "한국투자공사 모바일 가상화 시스템 앱 개발 - 기존 그룹웨어 앱 가상화에서 사용가능하도록 수정",
        projectCareerTech : ["Java","Vue.js","Oracle"],
        startDate : "2020-04-10",
        endDate : "2020-10-30"
      },
      projectData: {
        id: '',
        category: "",
        demain: "",
        location: "",
        skill: [],
        title: "",
        content: "",
        startDate: "",
        endDate: "",
        deadline: "",
        recruitNumber: '',
        task: "",
        workstyle: "",
        workStartTime: "",
        workEndTime: "",
        lowPrice: "",
        highPrice: "",
        careerPeriod: '',
      },
      freelancerDataReceive : {
        user_id : "1",
        name : "빌게이츠",
        resume : {
          title : "최고를 꿈꾸는 개발자입니다.",
          introduce : "고객이 요구하는 개발 스킬 및 요건에 맞추어 수많은 프로젝트의 경험을가지고 있습니다. 고객의 소통을 최우선으로 함께 고민하고 최선의마음으로 개발을 진행하고 있습니다. 원하시는 개발 요건을이루어드립니다. 다양한 프로젝트 경험으로 개발 요구 언어를 사용하여고객의 요건에 충족할 수 있습니다. 또한 최근 트렌드에 맞추어 최신 언어로 개발 진행 가능합니다.",
          career_period : "3"
        },
        tech : ["java","javascript","MySQL"],
        estimate : [
          {
            profession : 4,
            ontime : 5,
            active : 3.5,
            communication : 3.5,
            reEmployment : 3
          },
          {
            profession : 3,
            ontime : 4,
            active : 3,
            communication : 2.5,
            reEmployment : 5
          },
          {
            profession : 2,
            ontime : 4,
            active : 4.5,
            communication : 2,
            reEmployment : 5
          },
          {
            profession : 4,
            ontime : 3,
            active : 3.5,
            communication : 1,
            reEmployment : 4
          },
          {
            profession : 4.5,
            ontime : 4,
            active : 4,
            communication : 3,
            reEmployment : 2
          },
        ],
        projectCareer : [],
      }
    }
  },
  mounted() {
    this.projectIdTmp = this.$route.params.projectId
    this.stateTmp = this.$route.params.state
    if (this.stateTmp === 'complete') {
      document.querySelector('#clickAfter').classList.add('activeContract')
      document.querySelector('#clickBefore').classList.remove('activeContract')
      document.querySelector('#afterFreelancerCardLst').classList.remove('deactiveProjectDetailItem')
      document.querySelector('#beforeFreelancerCardLst').classList.add('deactiveProjectDetailItem')
    }
    createInstance().get('/apply/project' , {
      params : {
        projectId : String(this.$route.params.projectId)
      }
    }).then(res => {
        for (let i = 0; i < res.data.applyList.length; i++) {
          console.log(res.data.applyList[i])
          if (res.data.applyList[i].state === '지원완료') {
            this.beforeFreelancerCardLst.push({
              id : "myPageProjectFreelancer" + String(res.data.applyList[i].user.userId),
              body : res.data.applyList[i]
            })
          } else if (res.data.applyList[i].state === '인터뷰완료') {
            this.ingFreelancerCardLst.push({
              id : "myPageProjectFreelancer" + String(res.data.applyList[i].user.userId),
              body : res.data.applyList[i]
            }) 
          } else {
            this.afterFreelancerCardLst.push({
              id : "myPageProjectFreelancer" + String(res.data.applyList[i].user.userId),
              body : res.data.applyList[i]
            })
          }
        }
    })
  },
  components: {
    recruitApplyMemberItem,
    recruitApplyMemberItemIng,
    recruitApplyMemberItemAfter
  },
  methods : {
    clickContractBefore() { 
      let beforeTmp = document.querySelector("#clickBefore")
      let ingTmp = document.querySelector('#clickIng')
      let afterTmp = document.querySelector('#clickAfter')
      let beforeFreelancerCardLstTmp = document.querySelector('#beforeFreelancerCardLst')
      let ingFreelancerCardLstTmp = document.querySelector('#ingFreelancerCardLst')
      let afterFreelancerCardLstTmp = document.querySelector('#afterFreelancerCardLst')
      if (!beforeTmp.classList.contains('activeContract')) {
        if (ingTmp.classList.contains('activeContract')) {
          ingTmp.classList.remove('activeContract')
          ingFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        if (afterTmp.classList.contains('activeContract')) {
          afterTmp.classList.remove('activeContract')
          afterFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        beforeTmp.classList.add('activeContract')
        beforeFreelancerCardLstTmp.classList.remove('deactiveProjectDetailItem')
      }
    },

    clickContractIng() {
      let beforeTmp = document.querySelector("#clickBefore")
      let ingTmp = document.querySelector('#clickIng')
      let afterTmp = document.querySelector('#clickAfter')
      let beforeFreelancerCardLstTmp = document.querySelector('#beforeFreelancerCardLst')
      let ingFreelancerCardLstTmp = document.querySelector('#ingFreelancerCardLst')
      let afterFreelancerCardLstTmp = document.querySelector('#afterFreelancerCardLst')
      if (!ingTmp.classList.contains('activeContract')) {
        if (beforeTmp.classList.contains('activeContract')) {
          beforeTmp.classList.remove('activeContract')
          beforeFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        if (afterTmp.classList.contains('activeContract')) {
          afterTmp.classList.remove('activeContract')
          afterFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        ingTmp.classList.add('activeContract')
        ingFreelancerCardLstTmp.classList.remove('deactiveProjectDetailItem')
      }
    },
    
    clickContractAfter() {
      let beforeTmp = document.querySelector("#clickBefore")
      let ingTmp = document.querySelector('#clickIng')
      let afterTmp = document.querySelector('#clickAfter')
      let beforeFreelancerCardLstTmp = document.querySelector('#beforeFreelancerCardLst')
      let ingFreelancerCardLstTmp = document.querySelector('#ingFreelancerCardLst')
      let afterFreelancerCardLstTmp = document.querySelector('#afterFreelancerCardLst')
      if (!afterTmp.classList.contains('activeContract')) {
        if (beforeTmp.classList.contains('activeContract')) {
          beforeTmp.classList.remove('activeContract')
          beforeFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        if (ingTmp.classList.contains('activeContract')) {
          ingTmp.classList.remove('activeContract')
          ingFreelancerCardLstTmp.classList.add('deactiveProjectDetailItem')
        }
        afterTmp.classList.add('activeContract')
        afterFreelancerCardLstTmp.classList.remove('deactiveProjectDetailItem')
      }
    },

    moveToIngContract(value) {
      const itemToFind = this.beforeFreelancerCardLst.find(function(item) {return item.id === "myPageProjectFreelancer" + String(value)})
      const idxTmp = this.beforeFreelancerCardLst.indexOf(itemToFind)
      if (idxTmp > -1) this.beforeFreelancerCardLst.splice(idxTmp,1)

      this.ingFreelancerCardLst.push(itemToFind)
    },

    clickEstimateBtn(value) {
      console.log(value)
      if (!this.isEstimate.includes(value.freelancerCardId)) {
        this.nameErase = value.nameErase
        this.username = value.username
        this.freeTmpId = value.freelancerCardId
        document.querySelector('body').style.overflow = 'hidden'
        document.querySelector('#estimateModalWrpr').classList.remove('d-none')
      } else {
        document.querySelector('body').style.overflow = 'hidden'
        document.querySelector('.alreadyDoneEstimateWrpr').classList.remove('d-none')
      }
    },

    clickEstimateModalCloseBtn() {
      document.querySelector('body').style.overflow = 'scroll'
      document.querySelector('#estimateModalWrpr').classList.add('d-none')
    },

    completeEstimate() {
      let tmp = document.querySelectorAll('.star-ratings-fill-start')
      console.log(tmp[0].offsetWidth)
      createInstance().post('/estimates/' + this.username, {
        profession : tmp[0].offsetWidth / 40,
        ontime : tmp[1].offsetWidth / 40,
        active : tmp[2].offsetWidth / 40,
        communication : tmp[3].offsetWidth / 40,
        reEmployment : tmp[4].offsetWidth / 40
      }).then(res => {
        console.log(res)
        this.isEstimate.push(this.freeTmpId)    
      })
      document.querySelector('body').style.overflow = 'scroll'
      document.querySelector('#estimateModalWrpr').classList.add('d-none')
    },

    alreadyDoneClose() {
      document.querySelector('#alreadyDoneEstimateWrpr').classList.add('d-none')
    }
  }
};
</script>

<style>
  .activeContract {
    background-color : lightblue;
  }

  .alreadyDoneEstimateWrpr {
    position: fixed;
    top : 0px;
    left : 0px;
    z-index: 2;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0, 0, 0, 0.15);
  }

  .alreadyDoneEstimate {
    position: fixed;
    top: 180px;
    right: 560px;
    background-color: white;
    border-radius: 30px;
    height: 220px; 
    border: 1px solid lightgray;
    width: 400px;
    margin: auto;
  }
</style>
