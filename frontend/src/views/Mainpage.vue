<template>
  <b-container v-if="idDataLoad">
    <!--상단 네비게이션 바-->
    <!-- {{ loginUserInfo }} -->
    <div class="mainNav">
      <b-container class="main-intro-container">
        <b-row>
          <b-col class="intro-textcol">
            <vue-typed-js
              :strings="['프리랜서', ' 프로젝트']"
              :typeSpeed="100"
              :loop="true"
              class=""
              :startDelay="1000"
            >
              <h1><span class="typing intro-btext"></span> 구하세요?</h1>
            </vue-typed-js>

            <h3 class="intro-textsub">
              IT 프리랜서 계약 플랫폼 <br />FreeNeeds 가 도와드릴게요!
            </h3>

            <button class="navbtn1">프리랜서 찾기</button>
            <button class="navbtn2">프로젝트 찾기</button>
          </b-col>
          <b-col
            ><lottie-player
              src="https://assets4.lottiefiles.com/packages/lf20_slipwrv0.json"
              background="transparent"
              speed="1"
              style="width: 500px; height: 500px;"
              loop
              autoplay
            ></lottie-player
          ></b-col>
        </b-row>
      </b-container>
    </div>
    <!--상단 네비게이션 바 끄읕-->

    <div
      class="main-container"
      data-aos="fade-down"
      data-aos-easing="linear"
      data-aos-duration="1000"
    >
      <h1 class="list-title">
        <img src="../assets/images/freeneeds.png" alt="" />
      </h1>
      <b-row>
        <b-col></b-col>
        <b-col
          >IT 프리랜서 계약 서비스로 <br />
          블록체인의 무결성을 이용해 계약서의 위변조를 방지하고<br />
          계약 내용 변경 문제를 해결합니다.<br />
          또한 스마트컨트랙트를 통한 대금 정산으로<br />
          대금 지연 지급 문제를 극복할 수 있습니다.</b-col
        >
        <b-col></b-col>
      </b-row>
    </div>
    <div
      v-rellax="{
        speed: 15
      }"
      class="circle1"
    ></div>
    <div
      v-rellax="{
        speed: 5
      }"
      class="circle2"
    ></div>
    <div
      v-rellax="{
        speed: 17
      }"
      class="circle5"
    ></div>
    <div
      v-rellax="{
        speed: 10
      }"
      class="circle4"
    ></div>
    <div
      v-rellax="{
        speed: 4
      }"
      class="circle3"
    >
      <img width="300px" src="../assets/images/freech3.png" alt="" />
    </div>
    <div
      class="main-container"
      data-aos="fade-down"
      data-aos-easing="linear"
      data-aos-duration="1000"
    >
      <img width="90px" src="../assets/images/freech6.png" alt="" />
      <h1 class="list-title">FreeNeeds 어떻게 진행되나요?</h1>
      <b-row>
        <b-col
          ><div class="descFree-flow">
            <lottie-player
              src="https://assets3.lottiefiles.com/private_files/lf30_kskakh1u.json"
              mode="bounce"
              background="transparent"
              speed="0.1"
              style="width: 80px; height: 250px;"
              loop
              autoplay
            ></lottie-player>
            내게 필요한 <br />프로젝트/ 프리랜서를 <br />
            필터를 통해 찾아 <br />지원하세요
          </div></b-col
        >
        <b-col
          ><div class="descFree-flow">
            <lottie-player
              src="https://assets3.lottiefiles.com/private_files/lf30_eiaughgn.json"
              background="transparent"
              speed="0.3"
              style="width: 80px; height: 250px;"
              loop
              autoplay
            ></lottie-player>
            미팅 후 협의된 조건으로 <br />계약서를 작성하세요
          </div></b-col
        >
        <b-col
          ><div class="descFree-flow">
            <lottie-player
              src="https://assets5.lottiefiles.com/private_files/lf30_urbt0vfx.json"
              background="transparent"
              speed="0.3"
              style="width: 100px; height: 250px;"
              loop
              autoplay
            ></lottie-player>
            계약서는 이후 안전하게 <br />블록체인에 올라갑니다.
          </div></b-col
        >
        <b-col
          ><div class="descFree-flow">
            <lottie-player
              src="https://assets5.lottiefiles.com/private_files/lf30_rvoz2xj8.json"
              background="transparent"
              speed="0.3"
              style="width: 120px; height: 250px;"
              loop
              autoplay
            ></lottie-player>
            프로젝트 종료 후 <br />상호 확인 절차 이후 <br />
            사용자의 지갑으로 정산이 진행됩니다.
          </div></b-col
        >
      </b-row>
    </div>
    <div
      class="main-container"
      data-aos="fade-down"
      data-aos-easing="linear"
      data-aos-duration="1000"
    >
      <small class="small-title">FreeNeeds Povides!</small>
      <h2 class="list-title">
        여러분의 선택이 최고의 선택이 될 수 있도록 기존과 다른 계약을 제안합니다
      </h2>
      <b-row>
        <b-col></b-col>
        <b-col
          ><div class="descFree-p">
            <lottie-player
              src="https://assets1.lottiefiles.com/packages/lf20_c76upj2q.json"
              background="transparent"
              speed="1"
              style="width: 350px; height: 320px;"
              loop
              autoplay
            ></lottie-player
            >블록체인 기반 계약서 작성으로<br />
            계약서 무결성 보장
          </div></b-col
        >
        <b-col
          ><div class="descFree-p">
            <lottie-player
              src="https://assets5.lottiefiles.com/packages/lf20_MqQ9rx.json"
              background="transparent"
              speed="1"
              style="width: 300px; height:240px; padding-top:50px; padding-left: 50px; margin:50px 0px 80px 0px;"
              loop
              autoplay
            ></lottie-player>
            스마트 컨트랙트 정산으로 <br />대금 지급을 원할하게
          </div></b-col
        >
        <b-col></b-col>
      </b-row>
    </div>
    <div class="main-container">
      <small class="small-title">FreeNeeds Pick!</small>
      <h1 class="list-title">
        추천 프로젝트<img
          class="freeicon"
          width="80px"
          src="../assets/images/freech3.png"
          alt=""
        />
      </h1>
      <a @click="routeProjectPage()" class="moreList" href="#"
        >더 많은 프로젝트 보러가기 〉</a
      >
      <b-row>
        <b-col
          ><div class="descFree-project">
            <h3>{{ recmdProject[0].company.name }}</h3>
            <hr />

            <div class="project-title">{{ recmdProject[0].title }}</div>
            <span>{{ recmdProject[0].startDate }} ~ </span>
            <span>{{ recmdProject[0].endDate }}</span>
            <div class="deadline">
              마감일자 : {{ recmdProject[0].deadline }}
            </div>
            <b-row>
              <b-col></b-col>
              <b-col></b-col>
              <b-col></b-col>
              <b-col
                ><div class="workstyle">
                  {{ recmdProject[0].workStyle }}
                </div></b-col
              >
              <b-col>
                <div class="category">{{ recmdProject[0].category }}</div>
              </b-col>
            </b-row>
          </div></b-col
        >
        <b-col
          ><div class="descFree-project">
            <h3>{{ recmdProject[1].company.name }}</h3>
            <hr />

            <div class="project-title">{{ recmdProject[1].title }}</div>
            <span>{{ recmdProject[1].startDate }} ~ </span>
            <span>{{ recmdProject[1].endDate }}</span>
            <div class="deadline">
              마감일자 : {{ recmdProject[1].deadline }}
            </div>
            <b-row>
              <b-col></b-col>
              <b-col></b-col>
              <b-col></b-col>
              <b-col
                ><div class="workstyle">
                  {{ recmdProject[1].workStyle }}
                </div></b-col
              >
              <b-col>
                <div class="category">{{ recmdProject[1].category }}</div>
              </b-col>
            </b-row>
          </div></b-col
        >
        <b-col
          ><div class="descFree-project">
            <h3>{{ recmdProject[2].company.name }}</h3>
            <hr />

            <div class="project-title">{{ recmdProject[2].title }}</div>
            <span>{{ recmdProject[2].startDate }} ~ </span>
            <span>{{ recmdProject[2].endDate }}</span>
            <div class="deadline">
              마감일자 : {{ recmdProject[2].deadline }}
            </div>
            <b-row>
              <b-col></b-col>
              <b-col></b-col>
              <b-col></b-col>
              <b-col
                ><div class="workstyle">
                  {{ recmdProject[2].workStyle }}
                </div></b-col
              >
              <b-col>
                <div class="category">{{ recmdProject[2].category }}</div>
              </b-col>
            </b-row>
          </div></b-col
        >
      </b-row>
    </div>

    <div class="main-container">
      <small class="small-title">FreeNeeds Pick!</small>
      <h1 class="list-title">
        추천 프리랜서<img
          class="freeicon"
          width="80px"
          src="../assets/images/freech4.png"
          alt=""
        />
      </h1>
      <a @click="routeFreelancerPage()" class="moreList" href="#"
        >더 많은 프리랜서 보러가기 〉</a
      >

      <b-row>
        <b-col
          ><div class="descFree-user">
            <b-row>
              <b-col></b-col>
              <b-col
                ><img
                  class="freelancericon"
                  width="100px"
                  src="../assets/images/freech4.png"
                  alt=""
              /></b-col>
              <b-col></b-col>
            </b-row>
            <b-row>
              <b-col></b-col>
              <b-col class="freename col-8">{{ nameErase[0] }} 님</b-col>
              <b-col></b-col>
            </b-row></div
        ></b-col>
        <b-col
          ><div class="descFree-user">
            <b-row>
              <b-col></b-col>
              <b-col
                ><img
                  class="freelancericon"
                  width="100px"
                  src="../assets/images/freech5.png"
                  alt=""
              /></b-col>
              <b-col></b-col>
            </b-row>
            <b-row>
              <b-col></b-col>
              <b-col class="freename col-8">{{ nameErase[1] }} 님</b-col>
              <b-col></b-col>
            </b-row></div
        ></b-col>
        <b-col
          ><div class="descFree-user">
            <b-row>
              <b-col></b-col>
              <b-col
                ><img
                  class="freelancericon"
                  width="100px"
                  src="../assets/images/freech3.png"
                  alt=""
              /></b-col>
              <b-col></b-col>
            </b-row>
            <b-row>
              <b-col></b-col>
              <b-col class="freename col-8">{{ nameErase[2] }} 님</b-col>
              <b-col></b-col>
            </b-row></div
        ></b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import { createInstance } from "@/api/index.js";
import { mapGetters } from "vuex";
import "@lottiefiles/lottie-player";

// async function getProjectList(success, fail) {
//   instance
//     .get(`/project?page=0&size=3`)
//     .then(success=>{
//       console.log(success.data)
//       this.recmdProject =success.data;
//       console.log(this.recmdProject);
//       })
//     .catch(fail);
// }
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
      recmdFreelancer: [],
      recmdProject: [],
      nameErase: [],
      idDataLoad: false
    };
  },
  methods: {
    routeProjectPage() {
      this.$router.push("/project");
    },
    routeFreelancerPage() {
      this.$router.push("/freelancer");
    },
    routeMainPage() {
      this.$router.push("/");
    }
  },
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  components: {
    HeaderNav,
    FooterNav
  },
  async mounted() {
    const instance = createInstance();
    this.nameErase = ["", "", ""];

    await instance.get(`/project?page=0&size=3`).then(success => {
      this.recmdProject = success.data;
      console.log(this.recmdProject);
    });

    await instance.get(`/users?page=0&size=3`).then(success => {
      this.recmdFreelancer = success.data;

      for (let j = 0; j < 3; j++) {
        for (let i = 0; i < this.recmdFreelancer[j].name.length; i++) {
          if (i == 1) this.nameErase[j] += "*";
          else this.nameErase[j] += this.recmdFreelancer[j].name[i];
        }
        console.log(this.recmdFreelancer[j].username);
      }
    });

    this.idDataLoad = true;
  }
};
</script>
<style scope>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap");

* {
  font-family: "Noto Sans KR", sans-serif;
}

.mainNav {
  position: relative;
  top: 10vh;
}
.main-intro-container {
  margin-bottom: 200px;
}
.list-title {
  text-align: center;
  margin-bottom: 70px;
}
.small-title {
  color: #4657ff;
  padding: 0;
  margin: 0;
}

.navbtn1 {
  min-width: 130px;
  height: 40px;
  color: #fff;
  padding: 5px 10px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
  outline: none;
  border-radius: 5px;
  border: none;
  background-size: 120% auto;
  background-image: linear-gradient(315deg, #4ecdc4 0%, #c797eb 75%);
}
.navbtn1:hover {
  background-position: right center;
}
.navbtn1:active {
  top: 2px;
}
.navbtn2 {
  margin: 20px;
  min-width: 130px;
  height: 40px;
  color: #fff;
  padding: 5px 10px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
  outline: none;
  border-radius: 5px;
  border: none;
  background-size: 120% auto;
  background-image: linear-gradient(315deg, #000428 0%, #004e92 75%);
}
.navbtn2:hover {
  background-position: right center;
}
.navbtn2:active {
  top: 2px;
}

.card-list {
  height: 300px;
}
.link {
  text-decoration: none;
  color: #707070;
}
.intro-text {
  margin-top: 100px;
  margin-bottom: 20px;
  font-size: 40px;
  /* font-weight: bold; */
  color: #444;
}
.intro-btext {
  color: #4657ff;
  font-size: 45px;
  font-weight: bolder;
}

.intro-textsub {
  margin-top: 20px;
  font-size: 20px;
  /* font-weight: bold; */
  color: #444;
}
.description {
  font-size: 19px;
  margin: 32px 0px;
  color: #444444ba;
}
.descFree {
  padding: 70px;
}
.intro-textcol {
  padding: 150px;
  margin: 50px 0px 0px 70px;
}
.descFree-p {
  text-align: center;
  padding: auto;
  padding: 0px;
  margin: 50px;
  border-radius: 26px;
  background: #f9f9f9;
  box-shadow: 5px 5px 9px #dedede, -5px -5px 9px #ffffff;
  width: 350px;
  height: 400px;
}

.descFree-flow {
  display: flex;
  padding: auto;
  padding: 20px;
  margin: 0px;
  margin-bottom: 5px;
  border-radius: 26px;
  background: #f9f9f9;
  box-shadow: 5px 5px 9px #dedede, -5px -5px 9px #ffffff;
  width: 300px;
  height: 200px;
}
.main-container {
  /* padding: 100px 0px; */

  margin-bottom: 700px;
  justify-content: center;
  text-align: center;
  align-items: center;
  align-content: center;
}
.card-component {
  border: none;
}

.descFree-user {
  padding: 20px;

  border-radius: 26px;
  background: #f9f9f9;
  box-shadow: 5px 5px 9px #dedede, -5px -5px 9px #ffffff;
  width: 400px;
  height: 220px;
  transition: all 0.3s ease 0s;
}
.descFree-user:hover {
  transform: translateY(-3px);
}

.descFree-project {
  padding: auto;
  padding-top: 10px;

  border-radius: 26px;
  background: #f9f9f9;
  box-shadow: 5px 5px 9px #dedede, -5px -5px 9px #ffffff;
  width: 400px;
  height: 300px;
  transition: all 0.3s ease 0s;
}

.descFree-project :hover {
  transform: translateY(-3px);
}

.freeicon {
  padding-left: 15px;
  padding-bottom: 15px;
}

.category {
  color: white;
  background-color: #4657ff;
  width: 60px;
  border-radius: 20px;
  margin: 0px 20px 20px 0px;
  padding: 3px;
}

.workstyle {
  color: white;
  background-color: #4dd36a;
  width: 60px;
  border-radius: 20px;
  padding: 3px;
}
.project-title {
  color: #4657ff;
  font-size: 25px;
  margin: 0px 0px 30px;
}
.deadline {
  margin: 20px 0px 40px;
}

.freelancericon {
  margin: 15px;
}

.freename {
  font-size: 30px;
}
.moreList {
  text-decoration: none;
  position: relative;
  top: -30px;
  left: 40%;
  padding-bottom: 1000px;
}
.circle1 {
  width: 200px;
  height: 200px;
  border-radius: 100%;
  background-color: rgba(237, 189, 189, 0.197);
}
.circle2 {
  width: 355px;
  height: 355px;
  border-radius: 100%;
  background-color: rgba(174, 187, 238, 0.197);
  position: absolute;
  left: 75%;
}
.circle3 {
  position: absolute;
  left: 25%;
  top: 200%;
  opacity: 0.5;
}

.circle4 {
  width: 70px;
  height: 70px;
  border-radius: 100%;
  background-color: rgba(254, 255, 179, 0.762);
  position: absolute;
  left: 65%;
}

.circle5 {
  width: 70px;
  height: 70px;
  border-radius: 100%;
  background-color: rgba(110, 253, 141, 0.301);
  position: absolute;
  left: 20%;
  top: 500%;
}
</style>
