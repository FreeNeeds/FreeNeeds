<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="freelancerModalWrapper" style="z-index : -1">
      <div class="modal-content modal-content-project-show" style="z-index : -1">
        <button @click="closeFreelancerProjectDetail" type="button" id="freelancerDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="z-index : 2"></button>
        <button @click="openContractPaper" :id=ProjectDetailApplyBtn class="ProjectDetailApplyBtn freelancerFloatBtnTmp" style="z-index : 2">계약서 작성</button>
        <button @click="closeContractPaper" :id=closeContractPaperBtn class="d-none contractBackBtn" style="z-index : 1">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" style="margin-bottom: 5.5px;" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
          </svg>
          뒤로가기
        </button>
        <div
          class="myPageFreelancerDetailModalContent"
          :id="myPageFreelancerDetailModalContentWrpr"
        >
          <div class="carousel-mine" :id="carouselMine">
            <div
              class="myPageFreelancerDetailCtnr"
              :id="myPageFreelancerDetailModalContent"
            >
              <div style="height : 0px">
                <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 50vw">
              </div>
              <div id="freelancerDetailCtnr">
                <div class="container my-4 py-4" id="freelancerDetailHeadCtnr">
                  <div class="row m-2">
                    <h4 class="text-start fw-bold">{{ profile.title }}</h4>
                  </div>
                  <div class="d-flex mx-4">
                    <div class="d-inline-block">{{ nameErase }} |</div>
                    <div class="d-inline-block">
                      <div class="star-ratings d-inline-block mx-2">
                        <div
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: ratingToPercent + '%' }"
                        >
                          <span>★</span><span>★</span><span>★</span
                          ><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span
                          ><span>★</span><span>★</span>
                        </div>
                      </div>
                      |
                    </div>
                    <div class="d-inline-block mx-2">
                      경력 {{ profile.creer_period }}년
                    </div>
                  </div>
                  <div class="d-flex mt-4">
                    <div class="d-inline-block" id="freelancerDetailResumeImg">
                      <img :src=imgSrc alt="" />
                    </div>
                    <div class="d-inline-block" style="width: 270px">
                      <div class="d-flex mt-3 mb-2 justify-content-between">
                        <div
                          class="d-inline-block fw-bold"
                          style="margin-bottom : 2px; font-size: 17px;"
                        >
                          활동평가
                        </div>
                        <div class="d-inline-block">
                          <div
                            class="star-ratings d-inline-block mx-2"
                            style="margin-top: 1px"
                          >
                            <div
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: ratingToPercent + '%' }"
                            >
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div
                            class="d-inline-block lightGrayLetter mx-1 starScore"
                          >
                            <div>
                              {{
                                Math.round((ratingToPercent / 20) * 100) / 100
                              }}
                            </div>
                          </div>
                        </div>
                      </div>
                      <hr
                        style="background-color : black; height: 1.5px; margin : 3px"
                      />
                      <div class="d-flex my-1 justify-content-between">
                        <div
                          class="d-inline-block subScoreLetter"
                          style="margin-top : 2px"
                        >
                          전문성
                        </div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: profession * 20 + '%' }"
                            >
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div
                            class="d-inline-block lightGrayLetter mx-1 starScore"
                          >
                            <div>{{ Math.round(profession * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div
                          class="d-inline-block subScoreLetter"
                          style="margin-top : 2px"
                        >
                          일정준수
                        </div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: ontime * 20 + '%' }"
                            >
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div
                            class="d-inline-block lightGrayLetter mx-1 starScore"
                          >
                            <div>{{ Math.round(ontime * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div
                          class="d-inline-block subScoreLetter"
                          style="margin-top : 2px"
                        >
                          적극성
                        </div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: active * 20 + '%' }"
                            >
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div
                            class="d-inline-block lightGrayLetter mx-1 starScore"
                          >
                            <div>{{ Math.round(active * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div
                          class="d-inline-block subScoreLetter"
                          style="margin-top : 2px"
                        >
                          의사소통
                        </div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: communication * 20 + '%' }"
                            >
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div
                            class="d-inline-block lightGrayLetter mx-1 starScore"
                          >
                            <div>
                              {{ Math.round(communication * 100) / 100 }}
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div
                          class="d-inline-block subScoreLetter"
                          style="margin-top : 2px"
                        >
                          재고용의사
                        </div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: reEmployment * 20 + '%' }"
                            >
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span
                              ><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div
                            class="d-inline-block lightGrayLetter mx-1 starScore"
                          >
                            <div>
                              {{ Math.round(reEmployment * 100) / 100 }}
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="d-inline-block mx-1">
                      <div
                        style="width: 1px; height: 87%; margin-top: 22px; background-color: gray"
                      ></div>
                    </div>
                    <div
                      class="d-inline-block mx-auto my-3"
                      style="width : 229px"
                    >
                      <FreelancerCardSkill
                        v-for="skillItem in profileTech"
                        :key="skillItem"
                        :skillItem="skillItem"
                      >
                      </FreelancerCardSkill>
                    </div>
                  </div>
                  <div class="row">
                    <h5 class="fw-bold m-4 text-start">소개</h5>
                  </div>
                  <div class="row mx-3">
                    <div class="text-start">{{ profile.introduce }}</div>
                  </div>
                </div>

                <div class="row" id="projectDetailNavCtnr">
                  <div
                    @click="clickFreelancerDetailNavProject"
                    class="col-2 projectDetailNav activeProjectDetailNav"
                    :id="FreelancerDetailNavProject"
                  >
                    프로젝트
                  </div>
                  <div
                    @click="clickFreelancerDetailNavResume"
                    class="col-2 projectDetailNav"
                    :id="FreelancerDetailNavResume"
                  >
                    이력서
                  </div>
                </div>
                <hr class="project-card-line" style="margin-bottom : 40px" />
                <div :id="projectDetailNavItem">
                  <FreelancerProjectCard
                  v-for="freelancerProjectCard in projectCareer"
                  :key="freelancerProjectCard.body.projectCareerId"
                  :freelancerProjectCard="freelancerProjectCard"
                  style="margin-left : 0px !important"
                  >
                  </FreelancerProjectCard>
                </div>
                <div
                  :id="resumeDetailNavItem"
                  class="deactiveProjectDetailItem"
                >
                  <div class="row mx-2 my-4">
                    <div class="projectDetailHeadItem projectDetailItem">
                      학력
                    </div>
                  </div>
                  <div class="d-flex mx-3 my-2">
                    <div class="freelancerEducationName">
                      {{ resume.education.highschool }}
                    </div>
                    <div class="text-start freelancerEducationItem">
                      {{ resume.education.highschool_start_date }} ~
                      {{ resume.education.highschool_end_date }}
                    </div>
                  </div>
                  <div class="d-flex mx-3 my-2">
                    <div class="freelancerEducationName">
                      {{ resume.education.university }}
                    </div>
                    <div class="text-start freelancerEducationItem">
                      {{ resume.education.university_start_date }} ~
                      {{ resume.education.university_end_date }}
                    </div>
                  </div>
                  <div class="row mx-2 my-4">
                    <div class="projectDetailHeadItem projectDetailItem">
                      경력
                    </div>
                  </div>
                  <div
                    class="d-flex mx-3 my-2"
                    v-for="freelancerCareerItem in resume.careerList"
                  >
                    <div class="freelancerEducationName">
                      {{ freelancerCareerItem.companyName }}
                    </div>
                    <div class="freelancerEducationItem">
                      {{ freelancerCareerItem.start_date }} ~
                      {{ freelancerCareerItem.end_date }}
                    </div>
                  </div>
                  <div class="row mx-2 my-4">
                    <div class="projectDetailHeadItem projectDetailItem">
                      자격증
                    </div>
                  </div>
                  <div
                    class="d-flex mx-3 mt-2"

                    v-for="freelancerCareerItem in resume.certificateList"
                  >
                    <div class="freelancerEducationName">
                      {{ freelancerCareerItem.name }}
                    </div>
                    <div class="freelancerEducationItem">
                      {{ freelancerCareerItem.date }}
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div :id="contract" class="d-none myPageFreelancerDetailCtnrAfter">
              <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 50vw;">
              <div class="contractCtnr" :id="contractImg">
                <h3>프리랜서 고용계약서</h3>
                <div class="text-start mt-5 container align-items-start">
                  <div contenteditable="false" class="d-flex justify-content-center">
                    <p class="d-inline-block" style="padding-left: 7px; padding-right: 7px; border-left : 3px solid black; border-right: 1px solid black; border-bottom : 1px solid black; border-top: 3px solid black; line-height: 50px; height : 50px; margin : 0px">계약건명</p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="padding-left: 7px; padding-right: 7px; border-top : 3px solid black; border-right : 3px solid black; border-left : 1px solid black; border-bottom: 1px solid black; margin : 0px; width: 250px; height : 50px; line-height: 50px;"
                    >FreeNeeds</div>
                  </div>
                  <div contenteditable="false" class="d-flex justify-content-center mb-3">
                    <p class="d-inline-block" style="padding-left: 7px; padding-right: 7px; border-left: 3px solid black; border-right: 1px solid black; border-bottom : 3px solid black; border-top: 1px solid black; height : 50px; line-height: 50px;">계약기간</p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      @keyup.enter="keyEnter"
                      style="padding-left: 7px; padding-right: 7px; border-left : 1px solid black; border-top: 1px solid black; border-bottom: 3px solid black; border-right: 3px solid black; margin : 0px; width: 250px; height : 50px; line-height: 50px;"
                    >2022.11.01 - 2023.10.31</div>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      (이하 "갑"이라 한다.)와 (이하 "을"이라 한다.)은 계약건명에 명시된 업무작업을
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      수행하기 위해 다음과 같이 계약을 체결한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="height : 30px">
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block fw-bold" style="font-size : 18px">
                      제1조 【 목 적 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-2">
                    <p class="d-inline-block">
                      본 계약은 "갑"이 "을"에게 의뢰한 OOO의 업무를 "갑"에게 공급함에 있어 "갑"과 "을"사이에
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      필요한 사항을 정하는 것을 목적으로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제2조 【 계 약 기 간 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-2">
                    <p class="d-inline-block">
                      계약 기간은
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    >2022</div>
                    <p>년</p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    >11</div>
                    <p>월</p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    >01</div>
                    <p>일로부터</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block" style="width : 78px">

                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    >2023</div>
                    <p>년</p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    >10</div>
                    <p>월</p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    >31</div>
                    <p>일까지로 하며,</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block" style="width : 84px">

                    </p>
                    <p class="d-inline-block">
                      갑과 을의 합의 하에 본 계약 기간은 연장 될 수 있다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제3조 【 계 약 금 액 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-2">
                    <p class="d-inline-block">
                      총 계약금액은
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p class="d-inline-block">
                      FC으로 하며,
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      작업완료와 동시에 "갑"은 "을"에게 지급하기로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제4조 【 납 품 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      작업완료와 동시에 최종 결과물은 "을"이 "갑"에게 지급하기로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제5조 【 비 밀 유 지 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      "을"은 본 작업과 관련된 어떠한 일체의 정보를 외부에 누설하거나 유출해서는 안되며
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      이로 인해 발생하는 모든 책임은 "을"이 진다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제6조 【 자 료 제 공 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      "갑"은 "을"이 작업을 수행하는데 필요한 일체의 자료를 제공하기로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제7조 【 근 무 조 건 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      (1) 본 계약 상의 업무를 수행하기 위해 출근 등과 관련된 사항은 자유로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      (2) 본 계약 내용 외에도 다른 필요한 업무가 필요한 경우 "갑"은 "을"이 추가로 작업을 수행하는
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block" style="width: 25px"></p>
                    <p class="d-inline-block">
                      부분에 대한 인건비와 계약 기간은 상호 협의 하에 결정한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제8조 【 해 지 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mb-3">
                    <p class="d-inline-block">
                      "갑"과 "을"은 다음 각 호에 해당될 경우 본 계약을 해지할 수 있다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      (1) 정당한 이유 없이 작업 진행이 이루어지지 않을 때
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      (2) 정당한 이유 없이 계약기간에 작업완료가 불가능하다고 판단될 때
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      (3) "갑"이 계약금액을 지급하지 않았을 경우
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제9조 【 손 해 배 상 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      "을"의 귀책사유로 인하여 본 계약이 불이행이 되었을 경우 "을"은 "갑"이 제시한 손해배상의
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      책임을 진다. (이 때, 손해배상은
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    >1000</div>
                    <p class="d-inline-block">
                      FC로 한다.)
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mt-4" style="font-size : 18px">
                    <p class="d-inline-block fw-bold">
                      제10조 【 소 송 분 할 】
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex mb-3">
                    <p class="d-inline-block">
                      본 계약으로 발생하는 분쟁은
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    >대전지방</div>
                    <p class="d-inline-block">
                      법원을 관할법원으로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex justify-content-center mb-3">
                    <p class="d-inline-block">
                      계약일자 :
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    >2022</div>
                    <p class="d-inline-block">
                      년
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    >10</div>
                    <p class="d-inline-block">
                      월
                    </p>
                    <div
                      contenteditable="true"
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    >07</div>
                    <p class="d-inline-block">
                      일
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(사업주) 사업체명 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 200px">놀모컴퍼니</div>
                    <p class="d-inline-block">(전화 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 200px">042-231-3627</div>
                    <p class="d-inline-block">)</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">주</p>
                    <p style="margin-left : 30px">소 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px">대전 유성구 수통골로 47-3</div>
                  </div>
                  <div contenteditable="false" class="d-flex align-items-center" style="margin-left : 65px">
                    <p class="d-inline-block">대</p>
                    <p style="margin-left : 7px">표</p>
                    <p style="margin-left : 7px">자 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 20vw">박수근</div>
                    <div style="width : 0px">
                    <p class='d-none' style="position : relative; top : 6px; left : 50px; width : 100px" :id=representiveSignature>(서명)</p>
                    </div>
                    <button @click="clickRepresentiveSignature" class="signatureBtn" :id="representiveSignatureBtn">서명하기</button>
                    <img :id=imgSign src="" alt="">
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(근로자) </p>
                    <p class="d-inline-block" style="margin-left : 7px">주</p>
                    <p style="margin-left : 30px">소 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px">대전 유성구 계룡로 84</div>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">연</p>
                    <p style="margin-left : 7px">락</p>
                    <p style="margin-left : 7px">처 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px">010-3923-9592</div>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">성</p>
                    <p class="d-inline-block" style="margin-left : 30px">명 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 20vw">박재영</div>
                    <p style="position : relative; top : 0px;">(서명)</p>
                  </div>
                  <div class="d-flex justify-content-center">
                    <button
                      @click="clickCompleteWriteContract"
                      class="signatureBtn m-auto"
                      :id="signatureComplete"
                    >
                      작성완료
                    </button>
                  </div>
                  <h5
                    class="text-center d-none"
                    style="color : red"
                    :id="alreadyDoneContract"
                  >
                    이미 전달된 계약서 입니다.
                  </h5>
                  <div
                    class="d-none my-2 fw-bold text-center"
                    style="color : red"
                    :id="notSign"
                  >
                    서명을 완료해주세요!
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div :id="signatureModal" class="d-none">
      <div class="signatureModalCtnrWrpr">
        <div class="signatureModalCtnr">
          <h3 class="my-3">아래에 서명을 해주세요</h3>
          <hr class="m-auto" style="width : 85%" />
          <canvas :id="canvas" width="510" height="260"></canvas>
          <hr class="m-auto" style="width : 85%" />
          <button :id="erase" class="signatureBtn my-3">지우기</button>
          <button @click="clickSave" class="signatureBtn my-3">저장하기</button>
        </div>
      </div>
    </div>
    <div :id="sureContractModal" class="d-none">
      <div class="sureContractModalCtnrWrpr">
        <div class="sureContractModalCtnr">
          <h5 class="mt-5">
            <h3 class="fw-bold d-inline-block">{{ nameErase }}</h3>
            님에게 <br />작성한 계약서를 보내겠습니까?
          </h5>
          <div class="m-auto">
            <button
              @click="clickSendContract"
              class="signatureBtn my-3 mx-2"
            >
              네
            </button>
            <button
              @click="clickNotSendContract"
              class="signatureBtn my-3 mx-2"
            >
              아니요
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FreelancerProjectCard from "@/components/Freelancer/FreelancerProject/FreelancerProjectCard.vue";
import FreelancerCardSkill from "@/components/Freelancer/FreelancerCardSkill.vue";
import ProjectCardCarousel from "@/components/Project/ProjectCardCarousel.vue";
import { createInstance } from "@/api/index.js";
import html2canvas from "html2canvas";
import { createEscrow } from "@/utils/EscrowFactory.js";
import * as userInstance from "@/api/user.js";

export default {
  name: "recruitApplyMemberItemDetail",
  components: {
    HeaderNav,
    FooterNav,
    FreelancerProjectCard,
    FreelancerCardSkill,
    ProjectCardCarousel
  },
  data() {
    return {
      amount: 0, // 계약금
      freelancerAccount: "", // 프리랜서 지갑 주소
      idx : 0,
      coinModal : "coinModal",
      myPageFreelancerDetailModalContent : "myPageFreelancerDetailModalContent",
      selectProjectFreelancerName : "",
      contract : "contract",
      ProjectDetailApplyBtn : "ProjectDetailApplyBtn",
      closeContractPaperBtn : "closeContractPaperBtn",
      freelancerProjectModalId : "freeProModal",
      freelancerProjectModalCtnrId : "freeProModalCtnr",
      carouselWrapperMine : "carouselWrpp",
      carouselMine : "carouselMyPage",
      incentiveBtn : "incentiveBtn",
      notIncentiveBtn : "notIncentiveBtn",
      recruitInsureBtn : "recruitInsureBtn",
      accidentInsureBtn : "accidentInsureBtn",
      personInsureBtn : "personInsureBtn",
      healthInsureBtn : "healthInsureBtn",
      sureContractModal : "sureContractModal",
      myPageFreelancerDetailModalContentWrpr : "myPageFreelancerDetailModalContentWrpr",
      FreelancerDetailNavProject : "FreelancerDetailNavProject",
      FreelancerDetailNavResume : "FreelancerDetailNav",
      projectDetailNavItem : "프로젝트item",
      resumeDetailNavItem : "이력서item",
      representiveSignature : "representiveSignature",
      representiveSignatureBtn : "representiveSignatureBtn",
      signatureModal : "signatureModal",
      canvas : "canvas",
      erase : "erase",
      imgSign : "imgSign",
      notSign : "notSign",
      freelancerDetailNavLst : ["프로젝트","이력서"],
      freelancerDetailLst : ["프로젝트item","이력서item"],
      contractImg : "contractImg",
      contractInputItem : "contractInputItem",
      signatureComplete : "signatureComplete",
      alreadyDoneContract : "alreadyDoneContract"
    }
  },
  props : {
    nameErase : String,
    projectCareer : Array,
    profile : Object,
    resume : Object,
    profileTech : Array,
    estimate : Array,
    projectData : Object,
    ratingToPercent : Number,
    profession : Number,
    ontime : Number,
    active : Number,
    communication : Number,
    reEmployment : Number,
    id_ : Number,
    projectId : Number,
    imgSrc : String,
  },  
  mounted() {
    let id__ = String(this.id_)
    this.ifSign = false
    this.signatureComplete += id__
    this.alreadyDoneContract += id__
    this.freelancerProjectModalId += id__
    this.freelancerProjectModalCtnrId += id__
    this.contractInputItem += id__
    this.contractImg += id__
    this.carouselWrapperMine += id__
    this.carouselMine += id__
    this.FreelancerDetailNavProject += id__
    this.FreelancerDetailNavResume += id__
    this.projectDetailNavItem += id__
    this.resumeDetailNavItem += id__
    this.normalProjectFreelancerModal += id__
    this.sureSelectProjectFreelancer += id__
    this.myPageFreelancerDetailModalContent += id__
    this.contract += id__
    this.ProjectDetailApplyBtn += id__
    this.closeContractPaperBtn += id__
    this.incentiveBtn += id__
    this.notIncentiveBtn += id__
    this.myPageFreelancerDetailModalContentWrpr += id__
    this.recruitInsureBtn += id__
    this.accidentInsureBtn += id__
    this.personInsureBtn += id__
    this.healthInsureBtn += id__
    this.representiveSignature += id__
    this.representiveSignatureBtn += id__
    this.signatureModal += id__
    this.imgSign += id__
    this.erase += id__
    this.canvas += id__
    this.notSign += id__
    this.sureContractModal += id__
    this.coinModal += id__
    
    userInstance.getUserAccountAddress(this.id_, res => {this.freelancerAccount = res.data})
  },
  methods: {


    clickFreelancerDetailNavProject() {
      let removeProjectDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavProject
      );
      let removeResumeDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavResume
      );
      let ResumeDetailItem = document.querySelector(
        "#" + this.resumeDetailNavItem
      );
      let ProjectDetailItem = document.querySelector(
        "#" + this.projectDetailNavItem
      );
      if (
        !removeProjectDetailItem.classList.contains("activeProjectDetailNav")
      ) {
        removeProjectDetailItem.classList.add("activeProjectDetailNav");
        removeResumeDetailItem.classList.remove("activeProjectDetailNav");
        ResumeDetailItem.classList.add("deactiveProjectDetailItem");
        ProjectDetailItem.classList.remove("deactiveProjectDetailItem");
      }
    },
    clickFreelancerDetailNavResume() {
      let removeProjectDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavProject
      );
      let removeResumeDetailItem = document.querySelector(
        "#" + this.FreelancerDetailNavResume
      );
      let ResumeDetailItem = document.querySelector(
        "#" + this.resumeDetailNavItem
      );
      let ProjectDetailItem = document.querySelector(
        "#" + this.projectDetailNavItem
      );

      if (
        !removeResumeDetailItem.classList.contains("activeProjectDetailNav")
      ) {
        removeResumeDetailItem.classList.add("activeProjectDetailNav");
        removeProjectDetailItem.classList.remove("activeProjectDetailNav");
        ProjectDetailItem.classList.add("deactiveProjectDetailItem");
        ResumeDetailItem.classList.remove("deactiveProjectDetailItem");
      }
    },

    openContractPaper() {
      let carouselTmp = document.querySelector("#" + this.carouselMine);
      let myPageFreelancerDetailModalContentTmp = document.querySelector(
        "#" + this.myPageFreelancerDetailModalContent
      );
      let contractTmp = document.querySelector("#" + this.contract);
      let ProjectDetailApplyBtnTmp = document.querySelector(
        "#" + this.ProjectDetailApplyBtn
      );
      let closeContractPaperBtnTmp = document.querySelector(
        "#" + this.closeContractPaperBtn
      );
      let myPageFreelancerDetailModalContentWrpr = document.querySelector(
        "#" + this.myPageFreelancerDetailModalContentWrpr
      );

      myPageFreelancerDetailModalContentTmp.classList.remove(
        "myPageFreelancerDetailCtnr"
      );
      myPageFreelancerDetailModalContentTmp.classList.add(
        "myPageFreelancerDetailCtnrAfter"
      );
      contractTmp.classList.remove("d-none");
      carouselTmp.style.transform = "translate3d(-800px, 0, 0)";
      ProjectDetailApplyBtnTmp.classList.add("d-none");
      closeContractPaperBtnTmp.classList.remove("d-none");
      setTimeout(function() {
        carouselTmp.classList.remove("carousel-mine");
        carouselTmp.classList.add("carousel-mine-fast");
        carouselTmp.style.transform = "translate3d(0, 0, 0)";
        myPageFreelancerDetailModalContentTmp.classList.add("d-none");
        contractTmp.classList.remove("myPageFreelancerDetailCtnrAfter");
        contractTmp.classList.add("myPageFreelancerDetailCtnr");
      }, 350);
    },

    closeContractPaper() {
      let carouselTmp = document.querySelector("#" + this.carouselMine);
      let myPageFreelancerDetailModalContentTmp = document.querySelector(
        "#" + this.myPageFreelancerDetailModalContent
      );
      let contractTmp = document.querySelector("#" + this.contract);
      let ProjectDetailApplyBtnTmp = document.querySelector(
        "#" + this.ProjectDetailApplyBtn
      );
      let closeContractPaperBtnTmp = document.querySelector(
        "#" + this.closeContractPaperBtn
      );
      contractTmp.scrollTo(0, 0);
      contractTmp.classList.add("myPageFreelancerDetailCtnrAfter");
      contractTmp.classList.remove("myPageFreelancerDetailCtnr");
      myPageFreelancerDetailModalContentTmp.classList.remove("d-none");
      carouselTmp.style.transform = "translate3d(-800px, 0, 0)";
      ProjectDetailApplyBtnTmp.classList.remove("d-none");
      closeContractPaperBtnTmp.classList.add("d-none");
      setTimeout(function() {
        carouselTmp.classList.remove("carousel-mine-fast");
        carouselTmp.classList.add("carousel-mine");
        carouselTmp.style.transform = "translate3d(0, 0, 0)";
        myPageFreelancerDetailModalContentTmp.classList.add(
          "myPageFreelancerDetailCtnr"
        );
        myPageFreelancerDetailModalContentTmp.classList.remove(
          "myPageFreelancerDetailCtnrAfter"
        );
        contractTmp.classList.add("d-none");
      }, 100);
    },

    incentiveBtnClick() {
      let incentiveBtnTmp = document.querySelector("#" + this.incentiveBtn);
      let notIncentiveBtnTmp = document.querySelector(
        "#" + this.notIncentiveBtn
      );
      if (incentiveBtnTmp.classList.contains("d-none")) {
        incentiveBtnTmp.classList.remove("d-none");
        notIncentiveBtnTmp.classList.add("d-none");
      }
    },

    notIncentiveBtnClick() {
      let incentiveBtnTmp = document.querySelector("#" + this.incentiveBtn);
      let notIncentiveBtnTmp = document.querySelector(
        "#" + this.notIncentiveBtn
      );
      if (notIncentiveBtnTmp.classList.contains("d-none")) {
        incentiveBtnTmp.classList.add("d-none");
        notIncentiveBtnTmp.classList.remove("d-none");
      }
    },

    recruitInsureBtnClick() {
      let recruitInsureBtnTmp = document.querySelector(
        "#" + this.recruitInsureBtn
      );
      if (recruitInsureBtnTmp.classList.contains("d-none")) {
        recruitInsureBtnTmp.classList.remove("d-none");
      } else {
        recruitInsureBtnTmp.classList.add("d-none");
      }
    },

    accidentInsureBtnClick() {
      let accidentInsureBtnTmp = document.querySelector(
        "#" + this.accidentInsureBtn
      );
      if (accidentInsureBtnTmp.classList.contains("d-none")) {
        accidentInsureBtnTmp.classList.remove("d-none");
      } else {
        accidentInsureBtnTmp.classList.add("d-none");
      }
    },

    personInsureBtnClick() {
      let personInsureBtnTmp = document.querySelector(
        "#" + this.personInsureBtn
      );
      if (personInsureBtnTmp.classList.contains("d-none")) {
        personInsureBtnTmp.classList.remove("d-none");
      } else {
        personInsureBtnTmp.classList.add("d-none");
      }
    },

    healthInsureBtnClick() {
      let healthInsureBtnTmp = document.querySelector(
        "#" + this.healthInsureBtn
      );
      if (healthInsureBtnTmp.classList.contains("d-none")) {
        healthInsureBtnTmp.classList.remove("d-none");
      } else {
        healthInsureBtnTmp.classList.add("d-none");
      }
    },

    clickRepresentiveSignature() {
      let signatureModal = document.querySelector("#" + this.signatureModal);
      signatureModal.classList.remove("d-none");

      let isDrawing = false;
      let x = 0;
      let y = 0;

      let canvas = document.querySelector("#" + this.canvas);
      let ctx = canvas.getContext("2d");

      canvas.addEventListener("mousedown", function(e) {
        x = e.offsetX;
        y = e.offsetY;
        isDrawing = true;
      });

      canvas.addEventListener("mousemove", function(e) {
        if (isDrawing) {
          drawSign(ctx, x, y, e.offsetX, e.offsetY);
          x = e.offsetX;
          y = e.offsetY;
        }
      });

      canvas.addEventListener("mouseup", function(e) {
        if (isDrawing) {
          drawSign(ctx, x, y, e.offsetX, e.offsetY);
          x = 0;
          y = 0;
          isDrawing = false;
        }
      });

      canvas.addEventListener("mouseleave", function(e) {
        x = 0;
        y = 0;
        isDrawing = false;
      });

      document
        .getElementById(this.erase)
        .addEventListener("click", function(e) {
          if (ctx != null) {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
          }
        });

      function drawSign(ctx, x1, y1, x2, y2) {
        if (ctx != null) {
          ctx.save();
          ctx.beginPath();
          ctx.strokeStyle = "#000000";
          ctx.lineWidth = 7;
          ctx.moveTo(x1, y1);
          ctx.lineTo(x2, y2);
          ctx.stroke();
          ctx.closePath();
          ctx.restore();
        }
      }
    },

    clickSave() {
      let signatureModal = document.querySelector("#" + this.signatureModal);
      signatureModal.classList.add("d-none");
      let imgTmp = document.querySelector("#" + this.imgSign);
      imgTmp.src = document.querySelector("#" + this.canvas).toDataURL();
      this.ifSign = true;
      if (
        !document.querySelector("#" + this.notSign).classList.contains("d-none")
      )
        document.querySelector("#" + this.notSign).classList.add("d-none");
      imgTmp.setAttribute(
        "style",
        "width: 132.6px; height: 67.6px; margin-bottom: 10px"
      );
      document
        .querySelector("#" + this.representiveSignature)
        .classList.remove("d-none");
      document
        .querySelector("#" + this.representiveSignatureBtn)
        .classList.add("d-none");
    },

    clickCompleteWriteContract() {
      if (!this.ifSign) {
        document.querySelector("#" + this.notSign).classList.remove("d-none");
      } else {
        document
          .querySelector("#" + this.sureContractModal)
          .classList.remove("d-none");
      }
    },

    async clickSendContract() {
      let contractInputs = document.querySelectorAll(
        "#" + this.contractInputItem
      );
      let totalContent = "";
      let btnSelect = "";
      for (let i = 0; i < contractInputs.length; i++) {
        totalContent += contractInputs[i].innerText + "`";

        if (i === 8) this.amount = parseInt(contractInputs[i].innerText)
      }
      totalContent += document.querySelector("#" + this.imgSign).src;
      console.log(totalContent.split('`').length)


      const accounts = await window.ethereum.request({
        method: "eth_requestAccounts"
      });

      var test = await createEscrow(accounts[0], this.freelancerAccount, this.amount);
      console.log(test);


      createInstance()
        .post(
          "/contracts?projectId=" +
            this.projectId +
            "&userId=" +
            String(this.id_),
          {
            imgSRC: btnSelect,
            content: totalContent
          }
        )
        .then(res => {
          console.log(res);
        });

      createInstance()
        .put("/apply", {
          userId: String(this.id_),
          projectId: this.projectId,
          state: "인터뷰완료"
        })
        .then(res => {
          console.log(res);
        });
      this.$emit("moveToIngContract", this.id_);
      document
        .querySelector("#" + this.signatureComplete)
        .classList.add("d-none");
      document
        .querySelector("#" + this.alreadyDoneContract)
        .classList.remove("d-none");
      document
        .querySelector("#" + this.sureContractModal)
        .classList.add("d-none");
    },

    clickNotSendContract() {
      document.querySelector('#' + this.sureContractModal).classList.add('d-none')
    },

    openCoinPaper() {
      document.querySelector('#' + this.coinModal).classList.remove('d-none')
    },

    clickCloseCoinModal() {
      document.querySelector('#' + this.coinModal).classList.add('d-none')
    },

    closeFreelancerProjectDetail() {
      document.querySelector('body').style.overflow = 'scroll'
    },

    keyEnter() {

    }
  }
};
</script>

<style>
  .myPageFreelancerDetailModalContent {
    width: 50vw;
    height: 80vh;
    overflow: hidden;
  }

  .myPageFreelancerDetailModalContentAfter {
    width: 50vw;
    height: 80vh;
  }

  .myPageFreelancerDetailModalContent > .carousel-mine {
    display: flex;
    height: 80vh;
    transform: translate3d(0,0,0);
    transition: transform 0.4s;
  }

  .myPageFreelancerDetailModalContent > .carousel-mine-fast {
    display: flex;
    height: 80vh;
    transform: translate3d(0,0,0);
    transition: transform 0s;
  }

  .contractInput {
    border-bottom : 1px solid black;
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 20px;
    width : 120px;
    outline: none;
  }
  .myPageFreelancerDetailCtnr {
    width: 50vw;
    height: 80vh;
    overflow-y: scroll;
  }

  .myPageFreelancerDetailCtnrAfter {
    width: 50vw;
    height: 80vh;
  }

  .myPageFreelancerDetailCtnr::-webkit-scrollbar {
    width: 0px !important;
  }

  .modal-content {
    border-radius: 20px !important;
    border : 0px !important;
  }

  .ProjectDetailApplyBtn {
    border-radius: 40px;
    border: 1px solid lightgray;
    background-color: #6ecdb1;
    font-size: 15px;
    font-weight: bold;
    width: 120px;
    height: 40px;
  }

  .ProjectDetailApplyBtn:hover {
    background-color: #3C74C9;
    color: white;
  }

  .contractBackBtn {
    position: fixed;
    bottom : 87%;
    left : 66%;
    border : 0px;
    background-color: white;
  }

  .contractCtnr {
    border-radius: 20px;
    background-color: rgb(255, 255, 255);
    width : 85%;
    margin-left : auto;
    margin-right: auto;
    margin-top: 30px;
    margin-bottom: 30px;
  }

  .signatureBtn {
    width : 120px;
    height : 35px;
    border : 0.5px solid black;
    border-radius: 20px;
    margin-left : 25px;
    background-color: rgb(240,240,240);
    font-weight: bold;
  }

  .signatureBtn:hover{
    border : 0px;
    background-color: #6ecdb1;
  }

  .signatureModalCtnr {
    z-index: 2;
    position: fixed;
    bottom : 26vh;
    left: 30.5vw;
    background-color: white;
    border-radius: 20px;
    height: 400px;
    border: 1px solid lightgray;
    width: 600px;
    margin: auto;
  }

  .signatureModalCtnrWrpr {
    z-index: -1;
    position : fixed;
    top: 0px;
    left: 0px;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0,0,0,0.025);
  }

  .sureContractModalCtnr {
    z-index: 2;
    position: fixed;
    bottom : 40vh;
    left: 37vw;
    background-color: white;
    border-radius: 20px;
    height: 230px;
    border: 1px solid lightgray;
    width: 430px;
    margin: auto;
  }

  .sureContractModalCtnrWrpr {
    z-index: -1;
    position : fixed;
    top: 0px;
    left: 0px;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0,0,0,0.025);
  }

  .freelancerFloatBtnTmp{
    position: fixed;
    bottom : 11vh;
    left : 44.5vw;
    width: 200px !important;
  }

  .coinModalBtn {
    position: fixed;
    bottom : 11vh;
    left : 65.5vw;
    background-color: #f98740;
    width: 100px !important;
    border-radius: 100px !important;
  }

  .coinModalBtn:hover {
    background-color: rgb(255, 76, 76);
  }

  .coinModalCtnr {
    position: fixed;
    bottom : 35vh;
    left: 20.5vw;
    height : 410px;
    width : 60vw;
    border-radius: 20px;
    background-color: white;
  }

  .coinModalCtnrWrpr{
    z-index: -1;
    position : fixed;
    top: 0px;
    left: 0px;
    width : 100vw;
    height : 100vh;
    background-color: rgba(0,0,0,0.15);
  }

  .closeCoinModalBtn {
    position : relative;
    top : 10px;
    left : 27.5vw;
  }
</style>
