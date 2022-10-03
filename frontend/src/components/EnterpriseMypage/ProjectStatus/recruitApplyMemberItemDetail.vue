<template>
  <div class="modal text-center" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="false" style="background-color: rgba(0, 0, 0, 0.15);" >
    <div class="modal-dialog modal-lg" id="freelancerModalWrapper" style="z-index : -1">
      <div class="modal-content" style="z-index : -1">
        <button type="button" id="freelancerDetailModalCloseBtn" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="z-index : 2"></button>
        <button @click="openContractPaper" :id=ProjectDetailApplyBtn class="ProjectDetailApplyBtn freelancerFloatBtn" style="z-index : 2">계약서 작성</button>
        <button @click="closeContractPaper" :id=closeContractPaperBtn class="d-none contractBackBtn" style="z-index : 1"> 
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" style="margin-bottom: 5.5px;" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
          </svg>
          뒤로가기
        </button>
        <div class="myPageFreelancerDetailModalContent" :id=myPageFreelancerDetailModalContentWrpr>
          <div class="carousel-mine" :id=carouselMine>
            <div class="myPageFreelancerDetailCtnr" :id=myPageFreelancerDetailModalContent>
              <div style="height : 0px">
                <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 800px;">
              </div>
              <div id="freelancerDetailCtnr">
                <div class="container my-4 py-4" id="freelancerDetailHeadCtnr">
                  <div class="row m-2"> <h4 class="text-start fw-bold">{{ profile.title }}</h4></div>
                  <div class="d-flex mx-4">
                    <div class="d-inline-block"> {{ nameErase }} |</div>
                    <div class="d-inline-block"> 
                      <div class="star-ratings d-inline-block mx-2">
                        <div 
                          class="star-ratings-fill space-x-2 text-lg"
                          :style="{ width: ratingToPercent + '%' }"
                          >
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                      </div>|
                    </div>
                    <div class="d-inline-block mx-2"> 경력 {{ profile.creer_period }}년</div>
                  </div>
                  <div class="d-flex mt-4">
                    <div class="d-inline-block" id="freelancerDetailResumeImg"><img src="https://placekitten.com/300/300" alt=""></div>
                    <div class="d-inline-block" style="width: 270px">
                      <div class="d-flex mt-3 mb-2 justify-content-between">
                        <div class="d-inline-block fw-bold" style="margin-bottom : 2px; font-size: 17px;">활동평가</div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2" style="margin-top: 1px">
                            <div 
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: ratingToPercent + '%' }"
                              >
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div class="d-inline-block lightGrayLetter mx-1 starScore">
                            <div>{{ Math.round((ratingToPercent) / 20 * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <hr style="background-color : black; height: 1.5px; margin : 3px">
                      <div class="d-flex my-1 justify-content-between">
                        <div class="d-inline-block subScoreLetter" style="margin-top : 2px">전문성</div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div 
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: profession * 20 + '%' }"
                              >
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div class="d-inline-block lightGrayLetter mx-1 starScore">
                            <div>{{ Math.round(profession * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div class="d-inline-block subScoreLetter" style="margin-top : 2px">일정준수</div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div 
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: ontime * 20 + '%' }"
                              >
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div class="d-inline-block lightGrayLetter mx-1 starScore">
                            <div>{{ Math.round(ontime * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div class="d-inline-block subScoreLetter" style="margin-top : 2px">적극성</div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div 
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: active * 20 + '%' }"
                              >
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div class="d-inline-block lightGrayLetter mx-1 starScore">
                            <div>{{ Math.round(active * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div class="d-inline-block subScoreLetter" style="margin-top : 2px">의사소통</div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div 
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: communication * 20 + '%' }"
                              >
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div class="d-inline-block lightGrayLetter mx-1 starScore">
                            <div>{{ Math.round(communication * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                      <div class="d-flex my-1 justify-content-between">
                        <div class="d-inline-block subScoreLetter" style="margin-top : 2px">재고용의사</div>
                        <div class="d-inline-block">
                          <div class="star-ratings d-inline-block mx-2">
                            <div 
                              class="star-ratings-fill space-x-2 text-lg"
                              :style="{ width: reEmployment * 20 + '%' }"
                              >
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                            <div class="star-ratings-base space-x-2 text-lg">
                              <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                            </div>
                          </div>
                          <div class="d-inline-block lightGrayLetter mx-1 starScore">
                            <div>{{ Math.round(reEmployment * 100) / 100 }}</div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="d-inline-block mx-1">
                      <div style="width: 1px; height: 87%; margin-top: 22px; background-color: gray"></div>
                    </div>
                    <div class="d-inline-block mx-auto my-3" style="width : 229px">
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
                  <div @click="clickFreelancerDetailNavProject" class="col-2 projectDetailNav activeProjectDetailNav" :id=FreelancerDetailNavProject>
                    프로젝트
                  </div>
                  <div @click="clickFreelancerDetailNavResume" class="col-2 projectDetailNav" :id=FreelancerDetailNavResume>
                    이력서
                  </div> 
                </div>
                <hr class="project-card-line" style="margin-bottom : 40px">
                <div :id=projectDetailNavItem>
                  <FreelancerProjectCard
                  v-for="freelancerProjectCard in projectCareer"
                  :key="freelancerProjectCard.body.projectCareerId"
                  :freelancerProjectCard="freelancerProjectCard"
                  >
                  </FreelancerProjectCard>
                </div>
                <div :id=resumeDetailNavItem class="deactiveProjectDetailItem">
                  <div class="row mx-2 my-4">
                    <div class="projectDetailHeadItem projectDetailItem">  학력</div>
                  </div>
                  <div class="d-flex mx-3 my-2">
                    <div class="freelancerEducationName"> {{ resume.education.highschool }} </div>
                    <div class="text-start freelancerEducationItem"> {{ resume.education.highschool_start_date }} ~ {{ resume.education.highschool_end_date }}</div>
                  </div>
                  <div class="d-flex mx-3 my-2">
                    <div class="freelancerEducationName"> {{ resume.education.university }} </div>
                    <div class="text-start freelancerEducationItem"> {{ resume.education.university_start_date }} ~ {{ resume.education.university_end_date }}</div>
                  </div>
                  <div class="row mx-2 my-4">
                    <div class="projectDetailHeadItem projectDetailItem">  경력</div>
                  </div>
                  <div class="d-flex mx-3 my-2" 
                  v-for="freelancerCareerItem in resume.careerList"
                  >
                    <div class="freelancerEducationName">
                      {{ freelancerCareerItem.companyName }} 
                    </div>
                    <div class="freelancerEducationItem"> {{ freelancerCareerItem.start_date }} ~  {{ freelancerCareerItem.end_date }} </div>
                  </div>
                  <div class="row mx-2 my-4">
                    <div class="projectDetailHeadItem projectDetailItem">  자격증</div>
                  </div>
                  <div class="d-flex mx-3 mt-2" style="margin-bottom : 60px" 
                  v-for="freelancerCareerItem in resume.certificateList"
                  >
                    <div class="freelancerEducationName">
                      {{ freelancerCareerItem.name }} 
                    </div>
                    <div class="freelancerEducationItem"> {{ freelancerCareerItem.date }}</div>
                  </div>
                </div> 
              </div>
            </div>
            <div :id="contract" class="d-none myPageFreelancerDetailCtnrAfter">
              <img class="wrapperImgProjectCarousel" src="@/assets/images/하얀색.png" alt="" style="width : 800px;">
              <div class="contractCtnr" :id="contractImg">
                <h3>표준근로계약서</h3>
                <div class="text-start mt-5 container align-items-start">
                  <div contenteditable="false" class="d-flex">
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block"></div>
                    <p class="d-inline-block">(이하 "사업주"라 함)과(와)</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block"></div>
                    <p class="d-inline-block">(이하 "근로자"라 함)은</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">다음과 같이 근로계약을 체결한다.</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">1. 근로개시일 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 80px"></div>
                    <p class="d-inline-block">년</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">월</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">일부터</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">2. 근무장소 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 350px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">3. 업무의 내용 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 350px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">4. 소정근로시간 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">시</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">분부터 </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">시</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">분까지</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block" style="margin-left : 130px">(휴게시간 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">시</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">분~ </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">시</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">분)</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">5. 근무일/휴일 : 매주 </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">일(또는 매일단위)근무, 주휴일 매주 </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">요일</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">6. 임금 </p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 월(일, 시간)급 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 250px"></div>
                    <p class="d-inline-block">원</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 상여금 : 있음 </p>
                    <div @click="incentiveBtnClick" style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-top : 4px;">
                      <svg :id=incentiveBtn xmlns="http://www.w3.org/2000/svg" style="color : red; position : relative; top: -15px; left: -12px" width="37" height="37" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                      </svg>
                    </div>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 250px"></div>
                    <p class="d-inline-block">원 / 없음</p>
                    <div @click="notIncentiveBtnClick" style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-top : 4px;">
                      <svg :id=notIncentiveBtn xmlns="http://www.w3.org/2000/svg" style="color : red; position : relative; top: -15px; left: -12px" width="37" height="37" fill="currentColor" class="bi bi-check d-none" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                      </svg>
                    </div>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 임금지급일 : 매월(매주 또는 매일) </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 30px"></div>
                    <p class="d-inline-block">일(휴일의 경우는 전일 지급)</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 지급방법 : 근로자에게 코인 지갑에 입금</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">7. 연차유급휴가</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 연차유급휴가는 근로기준법에서 정하는 바에 따라 부여함</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">8. 사회보험 적용여부(해당란에 체크)</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <div @click="recruitInsureBtnClick" style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px;  margin-right : 5px; margin-top : 4px;">
                      <svg :id=recruitInsureBtn xmlns="http://www.w3.org/2000/svg" style="color : red; position : relative; top: -15px; left: -12px" width="37" height="37" fill="currentColor" class="bi bi-check d-none" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">고용보험</p>
                    <div @click="accidentInsureBtnClick" style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-right : 5px; margin-top : 4px;">
                      <svg :id=accidentInsureBtn xmlns="http://www.w3.org/2000/svg" style="color : red; position : relative; top: -15px; left: -12px" width="37" height="37" fill="currentColor" class="bi bi-check d-none" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">산재보험</p>
                    <div @click="personInsureBtnClick" style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px;  margin-right : 5px; margin-top : 4px;">
                      <svg :id=personInsureBtn xmlns="http://www.w3.org/2000/svg" style="color : red; position : relative; top: -15px; left: -12px" width="37" height="37" fill="currentColor" class="bi bi-check d-none" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">국민연금</p>
                    <div @click="healthInsureBtnClick" style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-right : 5px; margin-top : 4px;">
                      <svg :id=healthInsureBtn xmlns="http://www.w3.org/2000/svg" style="color : red; position : relative; top: -15px; left: -12px" width="37" height="37" fill="currentColor" class="bi bi-check d-none" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">건강보험</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">9. 근로계약서 교부</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 사업주는 근로계약을 체결함과 동시에 본 계약서를 사본하여 근로자의 교부요구와</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 42px;">
                    <p class="d-inline-block">관계없이 근로자에게 교부함(근로기준법 제17조 이행)</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">10. 근로계약, 취업규칙 등의 성실한 이행의무</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 사업주와 근로자는 각자가 근로계약, 취업규칙, 단체협약을 지키고 성실하게 이행</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 42px;">
                    <p class="d-inline-block">하여야 함</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">11. 기 타</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 30px;">
                    <p class="d-inline-block">- 이 계약에 정함이 없는 사항은 근로기준법령에 의함</p>
                  </div>
                  <div contenteditable="false" class="d-flex justify-content-center" style="margin-left : 30px">
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 80px"></div>
                    <p class="d-inline-block">년</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">월</p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 50px"></div>
                    <p class="d-inline-block">일</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(사업주) 사업체명 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 200px"></div>
                    <p class="d-inline-block">(전화 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 200px"></div>
                    <p class="d-inline-block">)</p>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">주</p>
                    <p style="margin-left : 30px">소 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex align-items-center" style="margin-left : 65px">
                    <p class="d-inline-block">대</p>
                    <p style="margin-left : 7px">표</p>
                    <p style="margin-left : 7px">자 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 350px"></div>
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
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">연</p>
                    <p style="margin-left : 7px">락</p>
                    <p style="margin-left : 7px">처 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 470px"></div>
                  </div>
                  <div contenteditable="false" class="d-flex" style="margin-left : 65px">
                    <p class="d-inline-block">성</p>
                    <p class="d-inline-block" style="margin-left : 30px">명 : </p>
                    <div contenteditable="true" :id="contractInputItem" class="contractInput d-inline-block" style="width : 350px"></div>
                    <p style="position : relative; top : 0px;">(서명)</p>
                  </div>
                  <div class="d-flex justify-content-center">
                    <button @click="clickCompleteWriteContract" class="signatureBtn m-auto" :id=signatureComplete>작성완료</button>
                  </div>
                  <h5 class="text-center d-none" style="color : red" :id=alreadyDoneContract>이미 전달된 계약서 입니다.</h5>
                  <div class="d-none my-2 fw-bold text-center" style="color : red" :id="notSign">
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
          <hr class="m-auto" style="width : 85%">
          <canvas :id=canvas width="510" height="260"></canvas>
          <hr class="m-auto" style="width : 85%">
          <button :id="erase" class="signatureBtn my-3">지우기</button>
          <button @click="clickSave" class="signatureBtn my-3">저장하기</button>
        </div>
      </div>
    </div>
    <div :id="sureContractModal" class="d-none">
      <div class="sureContractModalCtnrWrpr">
        <div class="sureContractModalCtnr">
          <h5 class="mt-5"><h3 class="fw-bold d-inline-block">{{ nameErase }}</h3> 님에게 <br>작성한 계약서를 보내겠습니까?</h5>
          <div class="m-auto">
            <button @click="clickSendContract" class="signatureBtn my-3 mx-2">네</button>
            <button @click="clickNotSendContract" class="signatureBtn my-3 mx-2">아니요</button>
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
import html2canvas from 'html2canvas'

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
    return{
      idx : 0,
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

    console.log(id__)
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
  },  
  methods: {
    clickFreelancerDetailNavProject() {
      let removeProjectDetailItem = document.querySelector('#' + this.FreelancerDetailNavProject)
      let removeResumeDetailItem = document.querySelector("#" + this.FreelancerDetailNavResume)
      let ResumeDetailItem = document.querySelector('#' + this.resumeDetailNavItem)
      let ProjectDetailItem = document.querySelector('#' + this.projectDetailNavItem)
      if (!removeProjectDetailItem.classList.contains("activeProjectDetailNav")) {
          removeProjectDetailItem.classList.add("activeProjectDetailNav")
          removeResumeDetailItem.classList.remove("activeProjectDetailNav")
          ResumeDetailItem.classList.add('deactiveProjectDetailItem')
          ProjectDetailItem.classList.remove('deactiveProjectDetailItem')
      }

    },
    clickFreelancerDetailNavResume() {
      let removeProjectDetailItem = document.querySelector('#' + this.FreelancerDetailNavProject)
      let removeResumeDetailItem = document.querySelector("#" + this.FreelancerDetailNavResume)
      let ResumeDetailItem = document.querySelector('#' + this.resumeDetailNavItem)
      let ProjectDetailItem = document.querySelector('#' + this.projectDetailNavItem)
      
      if (!removeResumeDetailItem.classList.contains("activeProjectDetailNav")) {
          removeResumeDetailItem.classList.add("activeProjectDetailNav")
          removeProjectDetailItem.classList.remove("activeProjectDetailNav")
          ProjectDetailItem.classList.add('deactiveProjectDetailItem')
          ResumeDetailItem.classList.remove('deactiveProjectDetailItem')
      }
    },

    openContractPaper() {
      let carouselTmp = document.querySelector('#' + this.carouselMine)
      let myPageFreelancerDetailModalContentTmp = document.querySelector('#' + this.myPageFreelancerDetailModalContent)
      let contractTmp = document.querySelector('#' + this.contract)
      let ProjectDetailApplyBtnTmp = document.querySelector('#' + this.ProjectDetailApplyBtn)
      let closeContractPaperBtnTmp = document.querySelector('#' + this.closeContractPaperBtn)
      let myPageFreelancerDetailModalContentWrpr = document.querySelector('#' + this.myPageFreelancerDetailModalContentWrpr)

      myPageFreelancerDetailModalContentTmp.classList.remove('myPageFreelancerDetailCtnr')
      myPageFreelancerDetailModalContentTmp.classList.add('myPageFreelancerDetailCtnrAfter')
      contractTmp.classList.remove('d-none')
      carouselTmp.style.transform = 'translate3d(-800px, 0, 0)'
      ProjectDetailApplyBtnTmp.classList.add('d-none')
      closeContractPaperBtnTmp.classList.remove('d-none')
      setTimeout(function() {
        carouselTmp.classList.remove('carousel-mine')
        carouselTmp.classList.add('carousel-mine-fast')
        carouselTmp.style.transform = 'translate3d(0, 0, 0)'
        myPageFreelancerDetailModalContentTmp.classList.add('d-none')
        contractTmp.classList.remove('myPageFreelancerDetailCtnrAfter')
        contractTmp.classList.add('myPageFreelancerDetailCtnr')
      }, 350)
    },

    closeContractPaper() {
      let carouselTmp = document.querySelector('#' + this.carouselMine)
      let myPageFreelancerDetailModalContentTmp = document.querySelector('#' + this.myPageFreelancerDetailModalContent)
      let contractTmp = document.querySelector('#' + this.contract)
      let ProjectDetailApplyBtnTmp = document.querySelector('#' + this.ProjectDetailApplyBtn)
      let closeContractPaperBtnTmp = document.querySelector('#' + this.closeContractPaperBtn)
      contractTmp.scrollTo(0,0)
      contractTmp.classList.add('myPageFreelancerDetailCtnrAfter')
      contractTmp.classList.remove('myPageFreelancerDetailCtnr')
      myPageFreelancerDetailModalContentTmp.classList.remove('d-none')
      carouselTmp.style.transform = 'translate3d(-800px, 0, 0)'
      ProjectDetailApplyBtnTmp.classList.remove('d-none')
      closeContractPaperBtnTmp.classList.add('d-none')
      setTimeout(function() {
        carouselTmp.classList.remove('carousel-mine-fast')
        carouselTmp.classList.add('carousel-mine')
        carouselTmp.style.transform = 'translate3d(0, 0, 0)'
        myPageFreelancerDetailModalContentTmp.classList.add('myPageFreelancerDetailCtnr')
        myPageFreelancerDetailModalContentTmp.classList.remove('myPageFreelancerDetailCtnrAfter')
        contractTmp.classList.add('d-none')
      },100)
    },

    incentiveBtnClick() {
      let incentiveBtnTmp = document.querySelector('#' + this.incentiveBtn)
      let notIncentiveBtnTmp = document.querySelector('#' + this.notIncentiveBtn)
      if (incentiveBtnTmp.classList.contains('d-none')) {
        incentiveBtnTmp.classList.remove('d-none')
        notIncentiveBtnTmp.classList.add('d-none')
      }
    },

    notIncentiveBtnClick() {
      let incentiveBtnTmp = document.querySelector('#' + this.incentiveBtn)
      let notIncentiveBtnTmp = document.querySelector('#' + this.notIncentiveBtn)
      if (notIncentiveBtnTmp.classList.contains('d-none')) {
        incentiveBtnTmp.classList.add('d-none')
        notIncentiveBtnTmp.classList.remove('d-none')
      }
    },

    recruitInsureBtnClick() {
      let recruitInsureBtnTmp = document.querySelector('#' + this.recruitInsureBtn)
      if (recruitInsureBtnTmp.classList.contains('d-none')) {
        recruitInsureBtnTmp.classList.remove('d-none')
      } else {
        recruitInsureBtnTmp.classList.add('d-none')
      }
    },

    accidentInsureBtnClick () {
      let accidentInsureBtnTmp = document.querySelector('#' + this.accidentInsureBtn)
      if (accidentInsureBtnTmp.classList.contains('d-none')) {
        accidentInsureBtnTmp.classList.remove('d-none')
      } else {
        accidentInsureBtnTmp.classList.add('d-none')
      }
    },
    
    personInsureBtnClick() {
      let personInsureBtnTmp = document.querySelector('#' + this.personInsureBtn)
      if (personInsureBtnTmp.classList.contains('d-none')) {
        personInsureBtnTmp.classList.remove('d-none')
      } else {
        personInsureBtnTmp.classList.add('d-none')
      }
    },

    healthInsureBtnClick() {
      let healthInsureBtnTmp = document.querySelector('#' + this.healthInsureBtn)
      if (healthInsureBtnTmp.classList.contains('d-none')) {
        healthInsureBtnTmp.classList.remove('d-none')
      } else {
        healthInsureBtnTmp.classList.add('d-none')
      }
    },

    clickRepresentiveSignature() {
      let signatureModal = document.querySelector('#' + this.signatureModal)
      signatureModal.classList.remove('d-none')

      let isDrawing = false;
      let x = 0;
      let y = 0;

      let canvas = document.querySelector('#' + this.canvas);
      let ctx = canvas.getContext("2d");

      canvas.addEventListener("mousedown", function (e) {
          x = e.offsetX;
          y = e.offsetY;
          isDrawing = true;
      });

      canvas.addEventListener("mousemove", function (e) {
          if (isDrawing) {
              drawSign(ctx, x, y, e.offsetX, e.offsetY);
              x = e.offsetX;
              y = e.offsetY;
          }
      });

      canvas.addEventListener("mouseup", function (e) {
          if (isDrawing) {
              drawSign(ctx, x, y, e.offsetX, e.offsetY);
              x = 0;
              y = 0;
              isDrawing = false;
          }
      });

      canvas.addEventListener("mouseleave", function (e) {
          x = 0;
          y = 0;
          isDrawing = false;
      });

      document.getElementById(this.erase).addEventListener("click", function (e) {
          if (ctx != null) {
              ctx.clearRect(0, 0, canvas.width, canvas.height);
          }
      })

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
      let signatureModal = document.querySelector('#' + this.signatureModal)
      signatureModal.classList.add('d-none')
      let imgTmp = document.querySelector('#' + this.imgSign)
      imgTmp.src = document.querySelector('#' + this.canvas).toDataURL()
      this.ifSign = true  
      if (!document.querySelector('#' + this.notSign).classList.contains('d-none'))
        document.querySelector('#' + this.notSign).classList.add('d-none')
      imgTmp.setAttribute('style','width: 132.6px; height: 67.6px; margin-bottom: 10px')
      document.querySelector('#' + this.representiveSignature).classList.remove('d-none')
      document.querySelector('#' + this.representiveSignatureBtn).classList.add('d-none')
    },

    clickCompleteWriteContract() {
      if (!this.ifSign) {
        document.querySelector('#' + this.notSign).classList.remove('d-none')
      } else {
        document.querySelector('#' + this.sureContractModal).classList.remove('d-none')
      }
    },

    clickSendContract() {
      let contractInputs = document.querySelectorAll('#' + this.contractInputItem)
      let totalContent = ''
      let btnSelect = ''
      for (let i = 0; i < contractInputs.length; i++) {
        totalContent += contractInputs[i].innerText + '`'
      }
      totalContent += document.querySelector('#' + this.imgSign).src
      
      if (document.querySelector('#' + this.incentiveBtn).classList.contains('d-none')) {
        btnSelect += '0'
      } else {
        btnSelect += '1'
      }
      console.log(1)
      if (document.querySelector('#' + this.notIncentiveBtn).classList.contains('d-none')) {
        btnSelect += '0'
      } else {
        btnSelect += '1'
      }
      console.log(2)
      if (document.querySelector('#' + this.recruitInsureBtn).classList.contains('d-none')) {
        btnSelect += '0'
      } else {
        btnSelect += '1'
      }
      console.log(3)
      if (document.querySelector('#' + this.accidentInsureBtn).classList.contains('d-none')) {
        btnSelect += '0'
      } else {
        btnSelect += '1'
      }
      console.log(4)
      if (document.querySelector('#' + this.personInsureBtn).classList.contains('d-none')) {
        btnSelect += '0'
      } else {
        btnSelect += '1'
      }
      console.log(5)
      if (document.querySelector('#' + this.healthInsureBtn).classList.contains('d-none')) {
        btnSelect += '0'
      } else {
        btnSelect += '1'
      }
      console.log(6)
      createInstance().post('/contracts?projectId=' + this.projectId + '&userId=' + String(this.id_),
      {
        imgSRC : btnSelect,
        content : totalContent
      }).then(res => {
        console.log(res)
      })

      createInstance().put('/apply', {
        userId : String(this.id_),
        projectId : this.projectId,
        state : "인터뷰완료"
      }).then(res => {
        console.log(res)
      })
      this.$emit('moveToIngContract',this.id_)
      document.querySelector('#' + this.signatureComplete).classList.add('d-none')
      document.querySelector('#' + this.alreadyDoneContract).classList.remove('d-none')
      document.querySelector('#' + this.sureContractModal).classList.add('d-none')
    },
    
    clickNotSendContract() {
      document.querySelector('#' + this.sureContractModal).classList.add('d-none')
    }
  },
};
</script>

<style>
  .myPageFreelancerDetailModalContent {
    width: 800px;
    height: 650px;
    overflow: hidden;
  }

  .myPageFreelancerDetailModalContentAfter {
    width: 800px;
    height: 650px;
  }

  .myPageFreelancerDetailModalContent > .carousel-mine {
    display: flex;
    height: 650px;
    transform: translate3d(0,0,0);
    transition: transform 0.4s;
  }

  .myPageFreelancerDetailModalContent > .carousel-mine-fast {
    display: flex;
    height: 650px;
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
    width: 800px;
    height: 650px;
    overflow-y: scroll;
  }

  .myPageFreelancerDetailCtnrAfter {
    width: 800px;
    height: 650px;
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
    top : 54px;
    left : 1000px;
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
    top: 110px;
    left: 468px;
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
    top: 150px;
    left: 552px;
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
</style>