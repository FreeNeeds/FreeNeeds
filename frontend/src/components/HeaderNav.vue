<template>
  <div>
    <nav class="big-nav navbar navbar-expand-lg navbar-light ">
  <div class="container-fluid">
        <div class="navbar-nav justify-content-between align-items-center">
          <div id="logo" @click="routeMainPage">
            <img src="../assets/images/freeneeds.png" width="100px" alt="" />
          </div>
          <div>
            <span
              @click="routeProjectPage"
              id="findProject"
              class="nav-item menuBar"
              >프로젝트 찾기</span
            >
            <span
              @click="routeFreelancerPage"
              id="findFreelancer"
              class="nav-item menuBar"
              >프리랜서 찾기</span
            >
          </div>
          <div>
            <span
              v-if="!isLogin"
              id="loginBtn"
              class="nav-item auth-group"
              @click="routerLoginPage"
              >로그인</span
            >
            <span
              v-if="isLogin"
              id="mypageBtn"
              class="nav-item auth-group"
              @click="routerMyPage"
              >마이페이지</span
            >
            <span
              v-if="isLogin"
              id="logoutBtn"
              class="nav-item auth-group"
              @click="logout"
              >로그아웃</span
            >
            <span
              v-if="!isLogin"
              id="signupBtn"
              class="nav-item auth-group"
              @click="routerSignupPage"
              >회원가입</span
            >
          </div>
        </div>
      </div>
</nav>
    
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  computed: {
    ...mapGetters(["accessToken", "isLogin"])
  },
  mounted() {
    // const loginBtn = document.querySelector("#loginBtn");
    // const logoutBtn = document.querySelector("#logoutBtn");
    // const mypageBtn = document.querySelector("#mypageBtn");
    // const signupBtn = document.querySelector("#signupBtn");
    // if (this.$store.getters.isLogin) {
    //   logoutBtn.setAttribute("style", "display: inline");
    //   mypageBtn.setAttribute("style", "display: inline");
    // } else {
    //   signupBtn.setAttribute("style", "display: inline");
    //   loginBtn.setAttribute("style", "display: inline");
    // }
  },
  methods: {
    ...mapActions(["logoutA", "goMypage"]),
    logout() {
      this.logoutA();
    },
    routerSignupPage() {
      this.$router.push("/register");
    },
    routerMyPage() {
      this.goMypage();
    },
    routerLoginPage() {
      this.$router.push("/login");
    },
    routeProjectPage() {
      this.$router.push("/project");
    },
    routeFreelancerPage() {
      this.$router.push("/freelancer");
    },
    routeMainPage() {
      this.$router.push("/");
    }
  }
};
</script>

<style>
.big-nav{
  background-color: #fff;
  height: 70px;
border-bottom: 1px inset rgba(77,139,250,0.28);
}
.container-fluid {
  /* margin-top: 1% !important;
  margin-left: 10% !important;
   */
margin-right: 10% !important;
  /* background: #0099CC;
	background: linear-gradient(to bottom,  #151d24,  #34615c); */
  height: 100px;
   margin-left: 5% !important;

}
.navbar-nav {
  width: 100% !important;
   /* background-color: rgb(51, 199, 232); */
}
.nav-item {
  font-size: 18px;
  text-align: center;
}

.auth-group {
  transition: all 0.3s ease 0s;
  font-size: 16px;
}
.auth-group:hover {
  font-size: 17px;
  font-weight: bolder;
  transform: translateY(-3px) ;
   cursor: pointer;
}
.menuBar {
 transition: all 0.3s ease 0s;
}
.menuBar:hover {
  font-size: 23px !important;
  font-weight: bolder;
  cursor: pointer;
  transform: translateY(-3px) ;
}
#findProject {
  width: 150px;
  margin-right: 75px;
  font-size: 22px;
}
#findFreelancer {
  width: 150px;
  font-size: 22px;
}
#loginBtn {
  width: 100px;
  margin-right: 50px;
  /* display: none; */
}
#mypageBtn {
  width: 100px;
  margin-right: 50px;
  /* display: none; */
}
#signupBtn {
  width: 100px;
  margin-right: 50px;
  /* display: none; */
}
#logoutBtn {
  width: 100px;
  /* display: none; */
}

#logo{
  cursor: pointer;
}
</style>
