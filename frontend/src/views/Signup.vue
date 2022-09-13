<template>
  <div class="container" style="text-align:center">
    <div class="register-wrapper">
      <h2>기업 회원가입</h2>
      <div class="register-item-wrapper">
        <label for="registerCIdInput" class="register-input-label"
          >아이디</label
        >
        <div class="regist-input-decoration">
          <input
            type="text"
            id="registerCIdInput"
            class="regist-input-wrapper"
          />
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCPasswordInput" class="register-input-label"
          >비밀번호</label
        >
        <div class="regist-input-decoration">
          <div class="row">
            <div class="col-10">
              <input
                type="password"
                id="registerCPasswordInput"
                class="regist-input-wrapper  password-input-wrapper"
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
      <div class="register-item-wrapper">
        <label for="registerCPasswordConfirmInput" class="register-input-label"
          >비밀번호 확인</label
        >
        <div class="regist-input-decoration">
          <div class="row">
            <div class="col-10">
              <input
                type="password"
                id="registerCPasswordConfirmInput"
                class="regist-input-wrapper  password-input-wrapper"
              />
            </div>
            <div
              class="col-2"
              v-if="passwordConfirmvisible"
              @click="changePasswordConfirmVisible"
            >
              <img src="@/assets/images/eyeopen.png" class="eye-wrapper" />
            </div>
            <div class="col-2" v-else @click="changePasswordConfirmVisible">
              <img src="@/assets/images/eyeclose.png" class="eye-wrapper" />
            </div>
          </div>

          <!-- <div v-if="passwordConfirmvisible"></div>
          <div v-else>
            <img ref="@/assets/images/eyeclose.png" />
          </div> -->
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCNameInput" class="register-input-label"
          >기업명</label
        >
        <div class="regist-input-decoration">
          <input
            type="text"
            id="registerCNameInput"
            class="regist-input-wrapper"
          />
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCNumberInput" class="register-input-label"
          >전화번호</label
        >
        <div class="regist-input-decoration">
          <input
            type="text"
            id="registerCNumberInput"
            class="regist-input-wrapper"
          />
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCNumberInput" class="register-input-label"
          >이메일</label
        >
        <div class="regist-input-decoration">
          <div class="row">
            <div class="col-6">
              <input
                type="text"
                id="registerCNumberInput"
                class="regist-email-input-wrapper"
              />
            </div>
            <div
              class="col-1"
              style="text-align:center;font-size:20px; padding-top: 10px;"
            >
              @
            </div>
            <div class="col-5">
              <select
                name="emailadress"
                id="emailSelectBar"
                class="form-select"
                aria-label="Default select example"
              >
                <option value="gmail.com" selected>gmail.com</option>
                <option value="naver.com">naver.com</option>
                <option value="daum.net">daum.net</option>
                <option value="hanmail.net">hanmail.net</option>
                <option value="kakao.com">kakao.com</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div></div>
    </div>
  </div>
</template>

<script>
import { signup } from "../api/user.js";

export default {
  data() {
    return {
      user: {
        email: "",
        name: "",
        password: "",
        passwordConfirm: ""
      },
      passwordvisible: false,
      passwordConfirmvisible: false
    };
  },
  methods: {
    changePasswordConfirmVisible() {
      this.passwordConfirmvisible = !this.passwordConfirmvisible;
      var passwordElement = document.getElementById(
        "registerCPasswordConfirmInput"
      );
      if (passwordElement.type == "password") {
        passwordElement.type = "text";
      } else {
        passwordElement.type = "password";
      }
    },
    changePasswordVisible() {
      this.passwordvisible = !this.passwordvisible;
      var passwordElement = document.getElementById("registerCPasswordInput");
      if (passwordElement.type == "password") {
        passwordElement.type = "text";
      } else {
        passwordElement.type = "password";
      }
    },
    register() {
      var vm = this;

      if (this.user.password === this.user.passwordConfirm) {
        signup(
          this.user.email,
          this.user.name,
          this.user.password,
          function() {
            alert("회원가입이 완료되었습니다.");
            vm.$router.push("/");
          },
          function(error) {
            console.error(error);
          }
        );
      } else {
        alert("비밀번호가 일치하지 않습니다.");
      }
    }
  }
};
</script>

<style>
.regist-email-input-wrapper {
  padding: 10px;
  font-size: 20px;
  width: 40%;
  border: none;
  outline: none;
}
.eye-wrapper {
  margin-left: 25%;
  margin-top: 25%;
  height: 50%;
  weight: 50%;
}
.register-wrapper {
  margin-top: 10%;
  width: 50%;
  border: 1px solid black;
  display: inline-block;
  text-align: left;
}
.register-item-wrapper {
  margin-top: 20px;
}
.regist-input-wrapper {
  padding: 10px;
  font-size: 20px;
  width: 100%;
  border: none;
  outline: none;
}
.regist-input-wrapper:focus {
  border: none;
}
.register-input-label {
  display: block;
}
.password-input-wrapper {
  width: 90%;
}
.regist-input-decoration {
  border: 1px solid #c7c8d2;
  border-radius: 8px;
  background-color: white;
  padding: 3px;
}
#emailSelectBar {
  width: 100%;
  height: 100%;
}
</style>
