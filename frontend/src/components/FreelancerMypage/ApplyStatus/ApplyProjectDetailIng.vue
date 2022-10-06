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
      <div class="modal-content modal-content-project-show" style="z-index : -1">
        <button
          @click="closeFreelancerDetailIng"
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
          class="ProjectDetailApplyBtn"
          style="z-index : 2; position: fixed; width: 200px !important; bottom : 11vh; left: 44vw;"
        >
          계약서보기
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
                style="width : 50vw;"
              />
              <div class="contractCtnr" :id="contractImg">
                <h3>프리랜서 고용계약서</h3>
                <div class="text-start mt-5 container align-items-start">
                  <div contenteditable="false" class="d-flex justify-content-center">
                    <p class="d-inline-block" style="padding-left: 7px; padding-right: 7px; border-left : 3px solid black; border-right: 1px solid black; border-bottom : 1px solid black; border-top: 3px solid black; line-height: 50px; height : 50px; margin : 0px">계약건명</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      @keyup.enter="keyEnter"
                      style="padding-left: 7px; padding-right: 7px; border-top : 3px solid black; border-right : 3px solid black; border-left : 1px solid black; border-bottom: 1px solid black; margin : 0px; width: 250px; height : 50px; line-height: 50px;"
                    ></div>
                  </div>
                  <div contenteditable="false" class="d-flex justify-content-center mb-3">
                    <p class="d-inline-block" style="padding-left: 7px; padding-right: 7px; border-left: 3px solid black; border-right: 1px solid black; border-bottom : 3px solid black; border-top: 1px solid black; height : 50px; line-height: 50px;">계약기간</p>
                    <div
                      :id="contractInputItem"
                      class="contractInput d-inline-block"
                      @keyup.enter="keyEnter"
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
                      style="width : 20vw"
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
                      style="width : 20vw"
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
            this.contractId = res.data.contractId;
            let tmp = res.data.content.split("`");
            for (let i = 0; i < contractInputs.length; i++) {
              contractInputs[i].innerText = tmp[i];
            }

            document.querySelector("#" + this.imgSignCompany).src = tmp[21];
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

      console.log("출력하기");
      console.log(this.$store.state.accounts.loginUserInfo.id)
      console.log(this.projectDataReceive.projectId)


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
    },

    closeFreelancerDetailIng() {
      document.querySelector('body').style.overflow = 'scroll'
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
