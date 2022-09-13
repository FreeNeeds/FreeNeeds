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
          <input
            type="password"
            id="registerCPasswordInput"
            class="regist-input-wrapper password-input-wrapper"
          />
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCPasswordConfirmInput" class="register-input-label"
          >비밀번호 확인</label
        >
        <div class="regist-input-decoration">
          <input
            type="password"
            id="registerCPasswordConfirmInput"
            class="regist-input-wrapper  password-input-wrapper"
          />
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
      }
    };
  },
  methods: {
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
  width: 80%;
}
.regist-input-decoration {
  border: 1px solid #c7c8d2;
  border-radius: 8px;
  background-color: white;
  padding: 3px;
}
</style>
