<template>
  <div>
    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <div class="navbar-nav justify-content-between align-items-center">
          <div id="logo" @click="routeMainPage">
            <img src="../assets/images/ssafy-logo.png" alt="" />
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
.container-fluid {
  margin-top: 1% !important;
  margin-left: 10% !important;
  margin-right: 10% !important;
}
.navbar-nav {
  width: 100% !important;
}
.nav-item {
  font-size: 20px;
  text-align: center;
}
.auth-group:hover {
  font-size: 24px;
  font-weight: bolder;
}
.menuBar:hover {
  font-size: 28px !important;
  font-weight: bolder;
}
#findProject {
  width: 150px;
  margin-right: 75px;
  font-size: 24px;
}
#findFreelancer {
  width: 150px;
  font-size: 24px;
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
</style>
