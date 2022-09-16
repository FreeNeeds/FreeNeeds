<template>
  <b-container>
    <HeaderNav></HeaderNav>
    <div id="freelancer-detail">
      <h1 id="freelancer-title">최고를 꿈꾸는 개발자입니다.</h1>
      <div id="freelancer-name">개발자 이*규 | ★★★★★ | 경력 3년</div>
      <!-- 컴포넌트 만들기 -->
      <div id="freelancer-grade" class="card text-bg-dark">
        <div class="card-img-overlay">
          <h5 class="card-title">Card title</h5>
          <p class="card-text">
            This is a wider card with supporting text below as a natural lead-in
            to additional content. This content is a little bit longer.
          </p>
          <p class="card-text"><small>Last updated 3 mins ago</small></p>
        </div>
      </div>
      <!-- 컴포넌트 만들기 끝-->
      <div id="freelancer-intro">
        <h2 id="freelancer-intro-title">소개</h2>
        <div id="freelacner-intro-contents">
          고객이 요구하는 개발 스킬 및 요건에 맞추어 수많은 프로젝트의 경험을
          가지고 있습니다. 고객의 소통을 최우선으로 함께 고민하고 최선의
          마음으로 개발을 진행하고 있습니다. 원하시는 개발 요건을
          이루어드립니다. 다양한 프로젝트 경험으로 개발 요구 언어를 사용하여
          고객의 요건에 충족할 수 있습니다. 또한 최근 트렌드에 맞추어 최신
          언어로 개발 진행 가능합니다.
        </div>
      </div>
    </div>
    <!-- 프로젝트, 이력서 -->
    <div id="project-resume">
      <!-- 프로젝트 이력서 nav -->
      <nav id="project-resume-nav">
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button
            class="nav-link active"
            id="nav-home-tab"
            data-bs-toggle="tab"
            data-bs-target="#nav-project"
            type="button"
            role="tab"
            aria-controls="nav-home"
            aria-selected="true"
          >
            프로젝트
          </button>
          <button
            class="nav-link"
            id="nav-profile-tab"
            data-bs-toggle="tab"
            data-bs-target="#nav-resume"
            type="button"
            role="tab"
            aria-controls="nav-profile"
            aria-selected="false"
          >
            이력서
          </button>
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div
          class="project-resume-contents-data tab-pane fade show active"
          id="nav-project"
          role="tabpanel"
          aria-labelledby="nav-home-tab"
          tabindex="0"
        >
          <FreelancerProjectList></FreelancerProjectList>
        </div>
        <div
          class="project-resume-contents-data tab-pane fade"
          id="nav-resume"
          role="tabpanel"
          aria-labelledby="nav-profile-tab"
          tabindex="0"
        >
          이력서 내용
        </div>
      </div>
      <!-- 프로젝트 이력서 nav -->
    </div>
    <div id="interview-btn-wrap">
      <button
        id="interview-btn"
        type="button"
        class="btn btn-outline-secondary"
      >
        인터뷰 요청하기
      </button>
    </div>
    <FooterNav></FooterNav>
  </b-container>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import FreelancerProjectList from "@/components/Freelancer/FreelancerProject/FreelancerProjectList.vue";
export default {
  components: { HeaderNav, FooterNav, FreelancerProjectList }
};
</script>

<style>
#freelancer-detail {
  margin: 0 auto;
  margin-top: 50px;
  border-radius: 30px;
  max-width: 800px;
  height: 500px;
  border: 1px solid rgb(209, 207, 207);
  background-color: rgb(219, 219, 217);
  padding: 30px;
}
#project-resume {
  margin-top: 30px;
}
#project-resume-nav {
  margin: 0 auto;
  width: 800px;
}
.project-resume-contents-data {
  margin: 0 auto;
  width: 800px;
  padding: 20px;
}
#interview-btn-wrap {
  margin: 0 auto;
  width: 800px;
  text-align: right;
  margin-top: 20px;
}
#freelancer-title {
}
#freelancer-name {
  margin-top: 10px;
}
#freelancer-grade {
  height: 150px;
  margin-top: 10px;
  background-color: rgb(245, 244, 176);
}
#freelancer-intro {
  margin-top: 20px;
}
#freelancer-intro-title {
}
#freelancer-intro-contents {
}
</style>
