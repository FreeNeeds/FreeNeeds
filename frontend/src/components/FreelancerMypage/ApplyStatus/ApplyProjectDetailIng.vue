<template>
  <div
    class="modal text-center"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="false"
    style="background-color: rgba(0, 0, 0, 0.15);"
  >
    <div
      class="modal-dialog modal-lg"
      id="freelancerModalWrapper"
      style="z-index : -1"
    >
      <div class="modal-content" style="z-index : -1">
        <button
          type="button"
          id="freelancerDetailModalCloseBtn"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
          style="z-index : 2"
        ></button>
        <button
          @click="openContractPaper"
          :id="ProjectDetailApplyBtn"
          class="ProjectDetailApplyBtn freelancerFloatBtn"
          style="z-index : 2"
        >
          ㅋ
        </button>
        <button
          @click="closeContractPaper"
          :id="closeContractPaperBtn"
          class="d-none contractBackBtn"
          style="z-index : 1"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-arrow-left"
            style="margin-bottom: 5.5px;"
            viewBox="0 0 16 16"
          >
            <path
              fill-rule="evenodd"
              d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"
            />
          </svg>
          뒤로가기
        </button>
        <div
          class="myPageFreelancerDetailModalContent"
          :id="myPageFreelancerDetailModalContentWrpr"
        >
          <div class="carousel-mine scroll-carousel-mypage" :id="carouselMine">
            <div
              class="projectDetailCtnr"
              :id="myPageFreelancerDetailModalContent"
            >
              <div id="remainDateInProjectTitle" class="text-start">
                {{ projectDataReceive.title }}
              </div>
              <div class="container my-4 py-2" id="projectDetailHeadCtnr">
                <div
                  class="row mx-2 my-3 justify-content-between align-items-start"
                >
                  <div class="col-9">
                    <div class="row">
                      <div
                        class="col-3 projectDetailHeadItem projectDetailItem"
                      >
                        모집인원
                      </div>
                      <div class="col-8 projectDetailItem">
                        {{ projectDataReceive.recruitNumber }} 명
                      </div>
                    </div>
                    <div class="row">
                      <div
                        class="col-3 projectDetailHeadItem projectDetailItem"
                      >
                        경력기간
                      </div>
                      <div class="col-8 projectDetailItem">
                        {{ projectDataReceive.careerPeriod }} 년
                      </div>
                    </div>
                    <div class="row">
                      <div
                        class="col-3 projectDetailHeadItem projectDetailItem"
                      >
                        근무기간
                      </div>
                      <div class="col-8 projectDetailItem">
                        {{ projectDataReceive.startDateSummry }} ~
                        {{ projectDataReceive.endDateSummry }} (
                        {{ periodWork }} 일 )
                      </div>
                    </div>
                    <div class="row">
                      <div
                        class="col-3 projectDetailHeadItem projectDetailItem"
                      >
                        근무방식
                      </div>
                      <div class="col-8 projectDetailItem">
                        {{ projectDataReceive.workStyle }}
                      </div>
                    </div>
                    <div class="row">
                      <div
                        class="col-3 projectDetailHeadItem projectDetailItem"
                      >
                        금액
                      </div>
                      <div class="col-8 projectDetailItem">
                        {{ projectDataReceive.lowPrice }} ~
                        {{ projectDataReceive.highPrice }}/월(근무 확정시, 단가
                        확정)
                      </div>
                    </div>
                  </div>
                  <div
                    class="col-2 my-3 mx-3"
                    id="remainDateWrapperInProjectDetail"
                  >
                    <div class="my-2" id="remainDateWrapperInProjectDetailDate">
                      {{ remainDate }}
                    </div>
                  </div>
                </div>
              </div>
              <div class="d-flex" id="projectDetailNavCtnr">
                <div
                  @click="clickProjectDetailNavProject"
                  class="col-2 projectDetailNav activeProjectDetailNav"
                  :id="ProjectDetailNavProject"
                >
                  프로젝트
                </div>
                <div
                  @click="clickProjectDetailNavResume"
                  class="col-2 projectDetailNav"
                  :id="ProjectDetailNavResume"
                >
                  기업정보
                </div>
              </div>
              <hr class="project-card-line mb-4" />
              <div :id="projectDetailNavItemProject">
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    분야
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ projectDataReceive.category }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    형태
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ projectDataReceive.domain }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    담당업무
                  </div>
                  <div class="col-8 projectDetailItem" id="taskItem">
                    {{ projectDataReceive.task }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    기술
                  </div>
                  <div class="col-8 projectDetailItem">
                    <ProjectDetailSkill
                      v-for="skillItem in this.projectDataReceive.skill"
                      :key="skillItem"
                      :skillItem="skillItem"
                    >
                    </ProjectDetailSkill>
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    프로젝트명
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ projectDataReceive.title }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    근무시간
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ projectDataReceive.workStartTime }} ~
                    {{ projectDataReceive.workEndTime }}
                  </div>
                </div>
                <div class="row mx-2 mt-2" style="padding-bottom: 80px">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    지역
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ projectDataReceive.locationSi }}
                    {{ projectDataReceive.locationGu }}
                  </div>
                </div>
              </div>
              <div
                :id="resumeDetailNavItemProject"
                class="deactiveProjectDetailItem"
              >
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    이름
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ companyDataReceive.name }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    대표자
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ companyDataReceive.ceo }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    주소
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ companyDataReceive.address }}
                  </div>
                </div>
                <div class="row mx-2 my-2">
                  <div class="col-3 projectDetailHeadItem projectDetailItem">
                    전화번호
                  </div>
                  <div class="col-8 projectDetailItem">
                    {{ companyDataReceive.call }}
                  </div>
                </div>
              </div>
            </div>
            <div :id="contract" class="d-none myPageFreelancerDetailCtnrAfter">
              <img
                class="wrapperImgProjectCarousel"
                src="@/assets/images/하얀색.png"
                alt=""
                style="width : 800px;"
              />
              <div class="contractCtnr" :id="contractImg">
                <h3>표준근로계약서</h3>
                <div class="text-start mt-5 container align-items-start">
                  <div contenteditable="false" class="d-flex">
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                    ></div>
                    <p class="d-inline-block">(이하 "사업주"라 함)과(와)</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                    ></div>
                    <p class="d-inline-block">(이하 "근로자"라 함)은</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      다음과 같이 근로계약을 체결한다.
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">1. 근로개시일 및 종료일 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p class="d-inline-block">년</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">월</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">일부터</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 165px"
                  >
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p class="d-inline-block">년</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">월</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">일까지</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">2. 근무장소 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 350px"
                    ></div>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">3. 업무의 내용 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 350px"
                    ></div>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">4. 소정근로시간 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">시</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">분부터</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">시</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">분까지</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block" style="margin-left : 130px">
                      (휴게시간 :
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">시</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">분~</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">시</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">분)</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">5. 근무일/휴일 : 매주</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">
                      일(또는 매일단위)근무, 주휴일 매주
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">요일</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">6. 임금</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">- 월(일, 시간)급 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 250px"
                    ></div>
                    <p class="d-inline-block">원</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">- 상여금 : 있음</p>
                    <div
                      style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-top : 4px;"
                    >
                      <svg
                        :id="incentiveBtn"
                        xmlns="http://www.w3.org/2000/svg"
                        style="color : red; position : relative; top: -15px; left: -12px"
                        width="37"
                        height="37"
                        fill="currentColor"
                        class="bi bi-check d-none"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"
                        />
                      </svg>
                    </div>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 250px"
                    ></div>
                    <p class="d-inline-block">원 / 없음</p>
                    <div
                      style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-top : 4px;"
                    >
                      <svg
                        :id="notIncentiveBtn"
                        xmlns="http://www.w3.org/2000/svg"
                        style="color : red; position : relative; top: -15px; left: -12px"
                        width="37"
                        height="37"
                        fill="currentColor"
                        class="bi bi-check d-none"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"
                        />
                      </svg>
                    </div>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">
                      - 임금지급일 : 매월(매주 또는 매일)
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 30px"
                    ></div>
                    <p class="d-inline-block">일(휴일의 경우는 전일 지급)</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">
                      - 지급방법 : 근로자에게 코인 지갑에 입금
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">7. 연차유급휴가</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">
                      - 연차유급휴가는 근로기준법에서 정하는 바에 따라 부여함
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      8. 사회보험 적용여부(해당란에 체크)
                    </p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <div
                      style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px;  margin-right : 5px; margin-top : 4px;"
                    >
                      <svg
                        :id="recruitInsureBtn"
                        xmlns="http://www.w3.org/2000/svg"
                        style="color : red; position : relative; top: -15px; left: -12px"
                        width="37"
                        height="37"
                        fill="currentColor"
                        class="bi bi-check d-none"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"
                        />
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">
                      고용보험
                    </p>
                    <div
                      style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-right : 5px; margin-top : 4px;"
                    >
                      <svg
                        :id="accidentInsureBtn"
                        xmlns="http://www.w3.org/2000/svg"
                        style="color : red; position : relative; top: -15px; left: -12px"
                        width="37"
                        height="37"
                        fill="currentColor"
                        class="bi bi-check d-none"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"
                        />
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">
                      산재보험
                    </p>
                    <div
                      style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px;  margin-right : 5px; margin-top : 4px;"
                    >
                      <svg
                        :id="personInsureBtn"
                        xmlns="http://www.w3.org/2000/svg"
                        style="color : red; position : relative; top: -15px; left: -12px"
                        width="37"
                        height="37"
                        fill="currentColor"
                        class="bi bi-check d-none"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"
                        />
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">
                      국민연금
                    </p>
                    <div
                      style="width: 16px; height: 16px; border: 1px solid black; margin-left : 5px; margin-right : 5px; margin-top : 4px;"
                    >
                      <svg
                        :id="healthInsureBtn"
                        xmlns="http://www.w3.org/2000/svg"
                        style="color : red; position : relative; top: -15px; left: -12px"
                        width="37"
                        height="37"
                        fill="currentColor"
                        class="bi bi-check d-none"
                        viewBox="0 0 16 16"
                      >
                        <path
                          d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"
                        />
                      </svg>
                    </div>
                    <p class="d-inline-block" style="margin-right : 20px;">
                      건강보험
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">9. 근로계약서 교부</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">
                      - 사업주는 근로계약을 체결함과 동시에 본 계약서를 사본하여
                      근로자의 교부요구와
                    </p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 42px;"
                  >
                    <p class="d-inline-block">
                      관계없이 근로자에게 교부함(근로기준법 제17조 이행)
                    </p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">
                      10. 근로계약, 취업규칙 등의 성실한 이행의무
                    </p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">
                      - 사업주와 근로자는 각자가 근로계약, 취업규칙, 단체협약을
                      지키고 성실하게 이행
                    </p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 42px;"
                  >
                    <p class="d-inline-block">하여야 함</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">11. 기 타</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 30px;"
                  >
                    <p class="d-inline-block">
                      - 이 계약에 정함이 없는 사항은 근로기준법령에 의함
                    </p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex justify-content-center"
                    style="margin-left : 30px"
                  >
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 80px"
                    ></div>
                    <p class="d-inline-block">년</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">월</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 50px"
                    ></div>
                    <p class="d-inline-block">일</p>
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(사업주) 사업체명 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 200px"
                    ></div>
                    <p class="d-inline-block">(전화 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 200px"
                    ></div>
                    <p class="d-inline-block">)</p>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 65px"
                  >
                    <p class="d-inline-block">주</p>
                    <p style="margin-left : 30px">소 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 470px"
                    ></div>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex align-items-center"
                    style="margin-left : 65px"
                  >
                    <p class="d-inline-block">대</p>
                    <p style="margin-left : 7px">표</p>
                    <p style="margin-left : 7px">자 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 350px"
                    ></div>
                    <div style="width : 0px">
                      <p
                        style="position : relative; top : 6px; left : 50px; width : 100px"
                      >
                        (서명)
                      </p>
                    </div>
                    <img
                      :id="imgSignCompany"
                      src=""
                      alt=""
                      style="width: 132.6px; height: 67.6px; margin-bottom: 10px"
                    />
                  </div>
                  <div contenteditable="false" class="d-flex">
                    <p class="d-inline-block">(근로자)</p>
                    <p class="d-inline-block" style="margin-left : 7px">주</p>
                    <p style="margin-left : 30px">소 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 470px"
                    ></div>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex"
                    style="margin-left : 65px"
                  >
                    <p class="d-inline-block">연</p>
                    <p style="margin-left : 7px">락</p>
                    <p style="margin-left : 7px">처 :</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 470px"
                    ></div>
                  </div>
                  <div
                    contenteditable="false"
                    class="d-flex align-items-center"
                    style="margin-left : 65px"
                  >
                    <p class="d-inline-block">성</p>
                    <p class="d-inline-block" style="margin-left : 30px">
                      명 :
                    </p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      style="width : 350px"
                    ></div>
                    <div style="width : 0px">
                      <p
                        class="d-none"
                        style="position : relative; top : 6px; left : 50px; width : 100px"
                        :id="representiveSignature"
                      >
                        (서명)
                      </p>
                    </div>
                    <button
                      @click="clickRepresentiveSignature"
                      class="signatureBtn"
                      :id="representiveSignatureBtn"
                    >
                      서명하기
                    </button>
                    <img :id="imgSign" src="" alt="" />
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
        <div class="sureContractModalCtnr" style="height: 200px">
          <h5 class="mt-5 mb-4">계약 내용에 동의하시겠습니까?</h5>
          <div class="m-auto">
            <button @click="clickSendContract" class="signatureBtn my-3 mx-2">
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
import ProjectDetailSkill from "../../Project/ProjectDetailSkill.vue";
import ProjectCardCarousel from "@/components/Project/ProjectCardCarousel.vue";
import { createInstance } from "@/api/index.js";
import html2canvas from "html2canvas";
import { freelancerSignEscrow } from "@/utils/EscrowFactory";
import * as userInstance from "@/api/user.js";
import * as companyInstance from "@/api/company.js";
import { mapGetters } from "vuex";
import hashData from "@/utils/hashData.js";
import signInstance from "@/api/sign.js";

export default {
  name: "ApplyProjectDetailIng",
  components: {
    HeaderNav,
    FooterNav,
    FreelancerProjectCard,
    FreelancerCardSkill,
    ProjectCardCarousel,
    ProjectDetailSkill
  },
  data() {
    return {
      periodWork: 0,
      periodWork: 0,
      idx: 0,
      myPageFreelancerDetailModalContent: "myPageFreelancerDetailModalContent",
      selectProjectFreelancerName: "",
      contract: "contract",
      isContractOpen: false,
      ProjectDetailApplyBtn: "ProjectDetailApplyBtn",
      closeContractPaperBtn: "closeContractPaperBtn",
      freelancerProjectModalId: "freeProModal",
      freelancerProjectModalCtnrId: "freeProModalCtnr",
      carouselWrapperMine: "carouselWrpp",
      carouselMine: "carouselMyPage",
      incentiveBtn: "incentiveBtn",
      notIncentiveBtn: "notIncentiveBtn",
      recruitInsureBtn: "recruitInsureBtn",
      accidentInsureBtn: "accidentInsureBtn",
      personInsureBtn: "personInsureBtn",
      healthInsureBtn: "healthInsureBtn",
      sureContractModal: "sureContractModal",
      myPageFreelancerDetailModalContentWrpr:
        "myPageFreelancerDetailModalContentWrpr",
      ProjectDetailNavProject: "FreelancerDetailNavProject",
      ProjectDetailNavResume: "FreelancerDetailNav",
      projectDetailNavItem: "프로젝트item",
      resumeDetailNavItem: "이력서item",
      representiveSignature: "representiveSignature",
      representiveSignatureBtn: "representiveSignatureBtn",
      signatureModal: "signatureModal",
      canvas: "canvas",
      erase: "erase",
      imgSign: "imgSign",
      imgSignCompany: "imgSignCompany",
      notSign: "notSign",
      freelancerDetailNavLst: ["프로젝트", "이력서"],
      freelancerDetailLst: ["프로젝트item", "이력서item"],
      contractImg: "contractImg",
      contractInputItem: "contractInputItem",
      signatureComplete: "signatureComplete",
      alreadyDoneContract: "alreadyDoneContract",
      projectDetailNavItemProject: "projectDetailNavItemProject",
      resumeDetailNavItemProject: "resumeDetailNavItemProject",
      // freelancerAccount: "",
      companyAccount: "",
      contractId: 0,
    };
  },
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  mounted() {
    let id__ = this.idEdit;
    this.ifSign = false;
    this.signatureComplete += id__;
    this.alreadyDoneContract += id__;
    this.freelancerProjectModalId += id__;
    this.freelancerProjectModalCtnrId += id__;
    this.contractInputItem += id__;
    this.contractImg += id__;
    this.carouselWrapperMine += id__;
    this.carouselMine += id__;
    this.FreelancerDetailNavProject += id__;
    this.FreelancerDetailNavResume += id__;
    this.projectDetailNavItem += id__;
    this.resumeDetailNavItem += id__;
    this.normalProjectFreelancerModal += id__;
    this.sureSelectProjectFreelancer += id__;
    this.myPageFreelancerDetailModalContent += id__;
    this.contract += id__;
    this.ProjectDetailApplyBtn += id__;
    this.closeContractPaperBtn += id__;
    this.incentiveBtn += id__;
    this.notIncentiveBtn += id__;
    this.myPageFreelancerDetailModalContentWrpr += id__;
    this.recruitInsureBtn += id__;
    this.accidentInsureBtn += id__;
    this.personInsureBtn += id__;
    this.healthInsureBtn += id__;
    this.representiveSignature += id__;
    this.representiveSignatureBtn += id__;
    this.signatureModal += id__;
    this.imgSign += id__;
    this.imgSignCompany += id__;
    this.erase += id__;
    this.canvas += id__;
    this.notSign += id__;
    this.sureContractModal += id__;
    this.ProjectDetailNavProject += this.idEdit;
    this.ProjectDetailNavResume += this.idEdit;
    this.projectDetailNavItemProject += this.idEdit;
    this.resumeDetailNavItemProject += this.idEdit;
    this.applyModalCtnr += this.idEdit;
    this.leftApply += this.idEdit;
    this.completeApply += this.idEdit;

    this.projectDataReceive.skill = [];
    createInstance()
      .get("/project/tech/" + this.projectDataReceive.projectId)
      .then(res => {
        for (let i = 0; i < res.data.length; i++) {
          if (!this.projectDataReceive.skill.includes(res.data[i].techName)) {
            this.projectDataReceive.skill.push(res.data[i].techName);
          }
        }
      });

    this.remainDate = Math.ceil(
      (new Date(this.projectDataReceive.deadline).getTime() -
        new Date().getTime()) /
        (1000 * 60 * 60 * 24) -
        1
    );
    this.remainDate = "D - " + String(this.remainDate);
    this.periodWork = parseInt(
      (new Date(this.projectDataReceive.endDate).getTime() -
        new Date(this.projectDataReceive.startDate).getTime()) /
        (1000 * 60 * 60 * 24)
    );
    // userInstance.getUserAccountAddress(this.loginUserInfo.id, res => { this.freelancerAccount = res.data });
    companyInstance.getCompanyAccountAddress(
      this.projectDataReceive.company.companyId,
      res => {
        // console.log("res출력");
        // console.log(res);
        this.companyAccount = res.data;
        // console.log(res.data);
      }
    );

    // console.log("회사 계좌정보");
    // console.log(this.companyAccount);
    // console.log(this.projectDataReceive);
    // console.log(this.projectDataReceive.company.companyId);
  },
  props: {
    projectDataReceive: Object,
    companyDataReceive: Object,
    idEdit: String
  },
  methods: {
    clickProjectDetailNavProject() {
      let removeProjectDetailItem = document.querySelector(
        "#" + this.ProjectDetailNavProject
      );
      let removeResumeDetailItem = document.querySelector(
        "#" + this.ProjectDetailNavResume
      );
      let ResumeDetailItem = document.querySelector(
        "#" + this.resumeDetailNavItemProject
      );
      let ProjectDetailItem = document.querySelector(
        "#" + this.projectDetailNavItemProject
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
    clickProjectDetailNavResume() {
      let removeProjectDetailItem = document.querySelector(
        "#" + this.ProjectDetailNavProject
      );
      let removeResumeDetailItem = document.querySelector(
        "#" + this.ProjectDetailNavResume
      );
      let ResumeDetailItem = document.querySelector(
        "#" + this.resumeDetailNavItemProject
      );
      let ProjectDetailItem = document.querySelector(
        "#" + this.projectDetailNavItemProject
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
        "#" + this.contractInputItem
      );
      if (!this.isContractOpen) {
        createInstance()
          .get(
            "/contracts?projectId=" +
              this.projectDataReceive.projectId +
              "&userId=" +
              String(this.$store.state.accounts.loginUserInfo.id)
          )
          .then(res => {
            let tmp = res.data.content.split("`");
            for (let i = 0; i < contractInputs.length; i++) {
              contractInputs[i].innerText = tmp[i];
            }
            if (res.data.imgSRC[0] === "1")
              document
                .querySelector("#" + this.incentiveBtn)
                .classList.remove("d-none");
            if (res.data.imgSRC[1] === "1")
              document
                .querySelector("#" + this.notIncentiveBtn)
                .classList.remove("d-none");
            if (res.data.imgSRC[2] === "1")
              document
                .querySelector("#" + this.recruitInsureBtn)
                .classList.remove("d-none");
            if (res.data.imgSRC[3] === "1")
              document
                .querySelector("#" + this.accidentInsureBtn)
                .classList.remove("d-none");
            if (res.data.imgSRC[4] === "1")
              document
                .querySelector("#" + this.personInsureBtn)
                .classList.remove("d-none");
            if (res.data.imgSRC[5] === "1")
              document
                .querySelector("#" + this.healthInsureBtn)
                .classList.remove("d-none");

            document.querySelector("#" + this.imgSignCompany).src = tmp[33];
          });
        this.isContractOpen = true;
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
      }, 450);
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
      }, 350);
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
      for (let i = 0; i < contractInputs.length; i++) {
        totalContent += contractInputs[i].innerText + "`";
      }
      totalContent += document.querySelector("#" + this.imgSignCompany).src;
      totalContent += "`";

      totalContent += document.querySelector("#" + this.imgSign).src;
      console.log("total 컨텐츠");
      console.log(totalContent);
      console.log("계좌정보 출력");
      console.log(this.companyAccount);

      createInstance()
        .patch(
          "/contracts/" +
            this.$store.state.accounts.loginUserInfo.id +
            "/" +
            this.projectDataReceive.projectId,
          totalContent
        )
        .then(res => {
          console.log(res);
        });

      //컨트랙트에 서명한 데이터까지 올리는 코드
      let accounts = await window.ethereum.request({
        method: "eth_requestAccounts"
      });
      console.log("프리랜서 계좌주소");
      console.log(accounts[0]);
      let result = hashData.getHashData(totalContent);

      console.log("해시값 출력");
      console.log(result);

      //기업 암호화
      let companyEncrypt = await signInstance.getCompanySign(
        this.projectDataReceive.company.companyId,
        result
      );
      console.log("기업 전자서명 출력");
      console.log(companyEncrypt.encryptData);
      console.log(companyEncrypt.publicKey);


      //프리랜서 암호화
      let freelancerEncrypt = await signInstance.getUserSign(
        this.$store.state.accounts.loginUserInfo.id,
        result
      );
      console.log("프리랜서 전자서명 출력");
      console.log(freelancerEncrypt.encryptData);
      console.log(freelancerEncrypt.publicKey);

      await createInstance()
        .get("/contracts", {
          userId: this.$store.state.accounts.loginUserInfo.id,
          projectId: this.projectDataReceive.projectId,
        })
        .then(res => {
          console.log("찍히냐", res.data.contractId);
          this.contractId = res.data.contractId;
        })

      freelancerSignEscrow(accounts[0], this.companyAccount, this.contractId, result, companyEncrypt.encryptData, companyEncrypt.publicKey, freelancerEncrypt.encryptData, freelancerEncrypt.publicKey);

      // 계약 테이블 저장
      createInstance()
        .put("/apply", {
          userId: this.$store.state.accounts.loginUserInfo.id,
          projectId: this.projectDataReceive.projectId,
          state: "계약완료"
        })
        .then(res => {
          console.log(res);
        });
      this.$emit("moveToAfterContract", this.projectDataReceive.projectId);
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
      document
        .querySelector("#" + this.sureContractModal)
        .classList.add("d-none");
    }
  }
};
</script>

<style>
.projectDetailCtnr {
  width: 85% !important;
  margin-left: auto;
  margin-right: auto;
  margin-top: 30px;
  margin-bottom: 30px;
}

.scroll-carousel-mypage {
  overflow-y: scroll;
}

.scroll-carousel-mypage::-webkit-scrollbar {
  width: 0px !important;
}
</style>
