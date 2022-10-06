<template>
  <div class="container" style="text-align:center">
    <div class="login-wrapper">
      <h2 v-if="loginType == 'company'" class="login-header">
        기업 로그인
      </h2>
      <h2 v-else class="login-header">프리랜서 로그인</h2>
      <div class="login-item-wrapper">
        <label for="loginCIdInput" class="login-input-label">아이디</label>

        <div class="login-input-decoration">
          <input
            v-model="loginInfo.username"
            type="text"
            id="loginCIdInput"
            class="login-input-wrapper"
            @keydown.enter="login"
          />
        </div>
      </div>
      <div class="login-item-wrapper">
        <label for="loginCPasswordInput" class="login-input-label"
          >비밀번호</label
        >
        <div class="login-input-decoration">
          <div class="row">
            <div class="col-10">
              <input
                v-model="loginInfo.password"
                type="password"
                id="loginCPasswordInput"
                class="login-input-wrapper  password-input-wrapper"
                @keydown.enter="login"
              />
            </div>
            <div
              class="col-2"
              v-if="passwordvisible"
              @click="changePasswordVisible"
            >
              <img src="@/assets/images/eyeopen.png" class="eye-wrapper" />
            </div>
            <div class="col-2" v-else @click="changePasswordVisible">
              <img src="@/assets/images/eyeclose.png" class="eye-wrapper" />
            </div>
          </div>
        </div>
      </div>

      
      <div class="login-submit-btn-wrapper">
        <button type="button" class="btn btn-primary btn-lg" @click="login">
          <div style="padding-left:50px;padding-right:50px">
            로그인
          </div>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  props: {
    loginType: String
  },
  data() {
    return {
      loginInfo: {
        username: "",
        password: ""
      },
      passwordvisible: false
    };
  },
  computed: {},
  mounted() {},
  created() {},
  methods: {
    ...mapActions(["freelancerLoginA", "companyLoginA"]),
    async login() {
      if (window.ethereum){
      await window.ethereum.request({
        method: "wallet_switchEthereumChain",
        params: [{ chainId: "0Xaa36a7" }],
      });
      await window.ethereum.request({ method: 'eth_requestAccounts' });}
      if (this.loginType == "company") {
        this.companyLogin();
      } else {
        this.freelancerLogin();
      }
    },
    companyLogin() {
      this.companyLoginA(this.loginInfo);
    },
    freelancerLogin() {
      this.freelancerLoginA(this.loginInfo);
    },
    changePasswordVisible() {
      this.passwordvisible = !this.passwordvisible;
      var passwordElement = document.getElementById("loginCPasswordInput");
      if (passwordElement.type == "password") {
        passwordElement.type = "text";
      } else {
        passwordElement.type = "password";
      }
    }
  }
};
</script>

<style>
.form-check {
  text-align: left;
}
.id-duplicate-confirm-btn {
  width: 100%;
  height: 100%;
}
.login-terms-input-form .form-check-input {
  /* zoom: 1.5; */
}
.login-terms-input-form .form-check-label {
  /* zoom: 1.5; */
  text-align: left;
}

.eye-wrapper {
  margin-left: 40%;
  margin-top: 15%;
  height: 50%;
  weight: 50%;
}
.login-wrapper {
  margin-top: 50px;
  width: 500px;
  /* border: 1px solid black; */
  display: inline-block;
  text-align: left;
}
.login-item-wrapper {
  margin-top: 20px;
}
.login-terms-input-form {
  margin-top: 30px;
  text-align: center;
}
.login-submit-btn-wrapper {
  margin-top: 30px;
  text-align: center;
}
.login-input-wrapper {
  padding: 10px;
  font-size: 20px;
  width: 100%;
  border: none;
  outline: none;
}
.login-input-wrapper:focus {
  border: none;
}
.login-input-label {
  display: block;
}
.password-input-wrapper {
  width: 90%;
}
.login-input-decoration {
  border: 1px solid #c7c8d2;
  border-radius: 8px;
  background-color: white;
  padding: 3px;
}
#emailSelectBar {
  width: 100%;
  height: 100%;
}
.login-header {
  margin-bottom: 50px;
}
</style>
