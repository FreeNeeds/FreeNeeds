<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="freelancerModalWrapper" style="z-index : -1">
      <div class="modal-content modal-content-project-show" style="z-index : -1">
        <button @click="closeFreelancerProjectDetailIng" type="button" id="freelancerDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="z-index : 2"></button>
        <button @click="openContractPaper" :id=ProjectDetailApplyBtn class="ProjectDetailApplyBtn freelancerFloatBtnTmp" style="z-index : 2">계약서 보기</button>
        <button @click="openCoinPaper" class="ProjectDetailApplyBtn coinModalBtn" style="z-index : 2" v-if="state === 'After'">코인보기</button>
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
                <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 50vw;">
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
                      <img :src="imgSrc" alt="" />
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
                    style="margin-bottom : 10px"
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
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="padding-left: 7px; padding-right: 7px; border-top : 3px solid black; border-right : 3px solid black; border-left : 1px solid black; border-bottom: 1px solid black; margin : 0px; width: 250px; height : 50px; line-height: 50px;"
                    ></div>
                  </div>
                  <div contenteditable="false" class="d-flex justify-content-center mb-3">
                    <p class="d-inline-block" style="padding-left: 7px; padding-right: 7px; border-left: 3px solid black; border-right: 1px solid black; border-bottom : 3px solid black; border-top: 1px solid black; height : 50px; line-height: 50px;">계약기간</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="padding-left: 7px; padding-right: 7px; border-left : 1px solid black; border-top: 1px solid black; border-bottom: 3px solid black; border-right: 3px solid black; margin : 0px; width: 250px; height : 50px; line-height: 50px;"
                    ></div>
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
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p>년</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p>월</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p>일로부터</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block" style="width : 78px">
                    
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p>년</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p>월</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
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
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
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
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p class="d-inline-block">
                      법원을 관할법원으로 한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex justify-content-center mb-3">
                    <p class="d-inline-block">
                      계약일자 : 
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p class="d-inline-block">
                      년
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">
                      월 
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">
                      일
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(사업주) 사업체명 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 200px"></div>
                    <p class="d-inline-block">(전화 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 200px"></div>
                    <p class="d-inline-block">)</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">주</p>
                    <p style="margin-left : 30px">소 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex align-items-center" style="margin-left : 65px">
                    <p class="d-inline-block">대</p>
                    <p style="margin-left : 7px">표</p>
                    <p style="margin-left : 7px">자 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 20vw"></div>
                    <div style="width : 0px">
                    <p style="position : relative; top : 6px; left : 50px; width : 100px">(서명)</p>
                    </div>
                    <img :id=imgSignCompany src="" alt="" style="width: 132.6px; height: 67.6px; margin-bottom: 10px">
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(근로자) </p>
                    <p class="d-inline-block" style="margin-left : 7px">주</p>
                    <p style="margin-left : 30px">소 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">연</p>
                    <p style="margin-left : 7px">락</p>
                    <p style="margin-left : 7px">처 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex align-items-center" style="margin-left : 65px">
                    <p class="d-inline-block">성</p>
                    <p class="d-inline-block" style="margin-left : 30px">명 : </p>
                    <div :id="contractInputItem" class="contractInput d-inline-block" style="width : 20vw"></div>
                    <div style="width : 0px">
                    <p style="position : relative; top : 6px; left : 50px; width : 100px">(서명)</p>
                    </div>
                    <img :id=imgSign src="" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div :id="coinModal" class="d-none">
      <div class="coinModalCtnrWrpr">
        <div class="coinModalCtnr">
          <button @click="clickCloseCoinModal" type="button" class="btn-close closeCoinModalBtn" style="z-index : 2"></button>
          <div div class="mx-4" style="box-shadow : 0px 1px 10px rgba(0,0,0,0.25); background-color: ;">
            <div class="d-flex" style="font-weight : bold; line-height: 50px; font-size : 24px; height: 50px; background-color: rgb(230, 239, 255);">
              <div style="width : 27px"></div>
              블록체인 데이터 정보
            </div>
          </div>
          <div class="mt-3 mx-4" style="box-shadow : 0px 5px 10px rgba(0,0,0,0.25);">
            <div class="d-flex justify-content-between" style="height: 50px;">
              <div class="col-3" style="text-align : start; padding-left: 17px; margin-right: 10px; font-size: 22px; line-height: 42px;">계약서 원본 해시값</div>
              <div class="test col-8" :id="longLetterOne">{{ hashData }}</div>
              <div class="col-1" style="font-size : 22px">
                ...
                <img src="@/assets/images/copy_512.png" @click="clickOneLong" style="width : 25px; height : 25px; margin-top: 10px; margin-right : 20px">
              </div>
            </div>
            <div class="d-flex justify-content-between" style="height: 50px; background-color: #f6f6f6;">
              <div class="col-3" style="text-align : start; padding-left: 17px; margin-right: 10px; font-size: 22px; line-height: 42px;">기업 Public Key</div>
              <div class="test col-8" :id="longLetterTwo">{{ enterprisePublicKey }}</div>
              <div class="col-1" style="font-size : 22px">
                ...
                <img src="@/assets/images/copy_512.png" @click="clickTwoLong" style="width : 25px; height : 25px; margin-top: 10px; margin-right : 20px">
              </div>
            </div>
            <div class="d-flex" style="height: 50px">
              <div class="col-3" style="text-align : start; padding-left: 17px; margin-right: 10px; font-size: 22px; line-height: 42px;">기업 전자서명</div>
              <div class="test col-8" :id="longLetterThree">{{ enterpriseEncrypt }}</div>
              <div class="col-1" style="font-size : 22px">
                ...
                <img src="@/assets/images/copy_512.png" @click="clickThreeLong" style="width : 25px; height : 25px; margin-top: 10px; margin-right : 20px">
              </div>
            </div>
            <div class="d-flex " style="height: 50px; background-color: #f6f6f6;">
              <div class="col-3" style="text-align : start; padding-left: 17px; margin-right: 10px; font-size: 22px; line-height: 42px;">프리랜서 Public Key</div>
              <div class="test col-8" :id="longLetterFour">{{ freelancerPublicKey }}</div>
              <div class="col-1" style="font-size : 22px">
                ...
                <img src="@/assets/images/copy_512.png" @click="clickFourLong" style="width : 25px; height : 25px; margin-top: 10px; margin-right : 20px">
              </div>
            </div>
            <div class="d-flex " style="height: 50px">
              <div class="col-3" style="text-align : start; padding-left: 17px; margin-right: 10px; font-size: 22px; line-height: 42px;">프리랜서 전자서명</div>
              <div class="test col-8" :id="longLetterFive">{{ freelancerEncrypt }}</div>
              <div class="col-1" style="font-size : 22px">
                ...
                <img src="@/assets/images/copy_512.png" @click="clickFiveLong" style="width : 25px; height : 25px; margin-top: 10px; margin-right : 20px">
              </div>
            </div>
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
import { getEvents } from "@/utils/EscrowFactory.js";
import html2canvas from "html2canvas";

export default {
  name: "recruitApplyMemberItemDetailIng",
  components: {
    HeaderNav,
    FooterNav,
    FreelancerProjectCard,
    FreelancerCardSkill,
    ProjectCardCarousel
  },
  data() {
    return{
      idx : 0,
      myPageFreelancerDetailModalContent : "myPageFreelancerDetailModalContent",
      selectProjectFreelancerName : "",
      contract : "contract",
      coinModal : "coinModal",
      isContractOpen : false,
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
      imgSignCompany : "imgSignCompany",
      notSign : "notSign",
      freelancerDetailNavLst : ["프로젝트","이력서"],
      freelancerDetailLst : ["프로젝트item","이력서item"],
      contractImg : "contractImg",
      contractInputItem : "contractInputItem",
      signatureComplete : "signatureComplete",
      alreadyDoneContract : "alreadyDoneContract",
      contractId : "",
      longLetterOne : "longLetterOne",
      longLetterTwo : "longLetterTwo",
      longLetterThree : "longLetterThree",
      longLetterFour : "longLetterFour",
      longLetterFive : "longLetterFive",
      hashData: "",
      enterpriseEncrypt: "",
      enterprisePublicKey: "",
      freelancerEncrypt: "",
      freelancerPublicKey: "",
      resSave : '',
    }
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
    this.imgSignCompany += id__
    this.erase += id__
    this.canvas += id__
    this.notSign += id__
    this.sureContractModal += id__
    this.coinModal += id__
    this.longLetterOne += id__
    this.longLetterTwo += id__
    this.longLetterThree += id__
    this.longLetterFour += id__
    this.longLetterFive += id__

    if (!this.isContractOpen) {
      createInstance().get('/contracts?projectId=' + this.projectId + '&userId=' + String(this.id_),
      ).then(res => {
        this.contractId = res.data.contractId;
        console.log(res.data)
        this.resSave = res.data
      })
      this.isContractOpen = true
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
    state : String,
    imgSrc : String,
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

      let contractInputs = document.querySelectorAll(
      "#" + this.contractInputItem)
      
      let tmp = this.resSave.content.split('`')
      for(let i = 0; i < contractInputs.length; i++) {
        contractInputs[i].innerText = tmp[i]
      }
      document.querySelector('#' + this.imgSignCompany).src = tmp[21]
      console.log(tmp.length)
      if (tmp.length === 23) {
        document.querySelector('#' + this.imgSign).setAttribute('style',"width: 132.6px; height: 67.6px; margin-bottom: 10px")
        document.querySelector('#' + this.imgSign).src = tmp[22]
      }
        
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
        carouselTmp.classList.remove('carousel-mine-fast')
        carouselTmp.classList.add('carousel-mine')
        carouselTmp.style.transform = 'translate3d(0, 0, 0)'
        myPageFreelancerDetailModalContentTmp.classList.add('myPageFreelancerDetailCtnr')
        myPageFreelancerDetailModalContentTmp.classList.remove('myPageFreelancerDetailCtnrAfter')
        contractTmp.classList.add('d-none')
      },100)
    },

    async openCoinPaper() {
      document.querySelector('#' + this.coinModal).classList.remove('d-none')
      // await window.ethereum.request({ method: 'eth_requestAccounts' });
      console.log(this.contractId);
      let events = await getEvents(this.contractId - 1);
      this.hashData = events[0].returnValues.hashData
      this.enterpriseEncrypt = events[0].returnValues.enterpriseEncrypt
      this.enterprisePublicKey = events[0].returnValues.enterprisePublicKey
      this.freelancerEncrypt = events[0].returnValues.freelancerEncrypt
      this.freelancerPublicKey = events[0].returnValues.freelancerPublicKey
      console.log(events[0].returnValues.hashData)
    },

    clickCloseCoinModal() {
      document.querySelector('#' + this.coinModal).classList.add('d-none')
    },

    openLongLetter() {
      console.log(document.querySelector('.test'))
      document.querySelector('.test').classList.add('test1')
    },

    closeFreelancerProjectDetailIng() {
      document.querySelector('body').style.overflow = 'scroll'
    },

    clickOneLong() {
      let tmp = document.querySelector('#' + this.longLetterOne).innerHTML

      navigator.clipboard.writeText(tmp)
          .then(() => {
          console.log("Text copied to clipboard...")
      })
          .catch(err => {
          console.log('Something went wrong', err);
      })
    },

    clickTwoLong() {
      let tmp = document.querySelector('#' + this.longLetterTwo).innerHTML

      navigator.clipboard.writeText(tmp)
          .then(() => {
          console.log("Text copied to clipboard...")
      })
          .catch(err => {
          console.log('Something went wrong', err);
      })
    },

    clickThreeLong() {
      let tmp = document.querySelector('#' + this.longLetterThree).innerHTML

      navigator.clipboard.writeText(tmp)
          .then(() => {
          console.log("Text copied to clipboard...")
      })
          .catch(err => {
          console.log('Something went wrong', err);
      })
    },

    clickFourLong() {
      let tmp = document.querySelector('#' + this.longLetterFour).innerHTML

      navigator.clipboard.writeText(tmp)
          .then(() => {
          console.log("Text copied to clipboard...")
      })
          .catch(err => {
          console.log('Something went wrong', err);
      })
    },

    clickFiveLong() {
      let tmp = document.querySelector('#' + this.longLetterFive).innerHTML

      navigator.clipboard.writeText(tmp)
          .then(() => {
          console.log("Text copied to clipboard...")
      })
          .catch(err => {
          console.log('Something went wrong', err);
      })
    },

  },
};
</script>

<style>
  .test {
    display: flex; overflow : hidden; font-size: 22px; line-height: 42px;
  }

</style>

<style scoped>
.modal:hover {
  cursor: default;
}
</style>
