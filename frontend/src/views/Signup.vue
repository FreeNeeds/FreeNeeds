<template>
  <div class="container" style="text-align:center">
    <div class="register-wrapper">
      <h2 v-if="signupType == 'Company'" class="regist-header">
        기업 회원가입
      </h2>
      <h2 v-else class="regist-header">프리랜서 회원가입</h2>
      <div class="register-item-wrapper">
        <label for="registerCIdInput" class="register-input-label"
          >아이디</label
        >
        <div class="row">
          <div class="col-9">
            <div class="regist-input-decoration">
              <input
                @change="idChange"
                v-model="user.id"
                type="text"
                id="registerCIdInput"
                class="regist-input-wrapper"
              />
            </div>
          </div>
          <div class="col-3">
            <button
            
              type="button"
              class="btn btn-outline-primary id-duplicate-confirm-btn"
              @click="checkIdDuplicate"
            >
              중복검사
            </button>
            
            
          </div>
          <div
            v-if="isDuplicatedIdTried&&isDuplicatedId"
             
              class="mt-3 my-3 btn btn-warning id-duplicate-confirm-btn"
      
              style="width:500px; margin-left:10px"
            >
              중복된 아이디입니다.
            </div>
          <div
            v-if="isDuplicatedIdTried&&!isDuplicatedId"
              class="mt-3 my-3 btn btn-light id-duplicate-confirm-btn"
              style="width:500px; margin-left:10px"
            >
              사용가능한 아이디입니다
            </div>
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
                v-model="user.password"
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
                v-model="user.passwordConfirm"
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
        <div v-show="isPasswordSame">입력한 비밀번호가 다릅니다.</div>
      </div>
      <div class="register-item-wrapper">
        <label
          v-if="signupType == 'Company'"
          for="registerCNameInput"
          class="register-input-label"
          >기업명</label
        >
        <label v-else for="registerCNameInput" class="register-input-label"
          >이름</label
        >
        <div class="regist-input-decoration">
          <input
            v-model="user.name"
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
            v-model="user.number"
            type="text"
            id="registerCNumberInput"
            class="regist-input-wrapper"
          />
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCEmailInput" class="register-input-label"
          >이메일</label
        >
        <div class="regist-input-decoration">
          <div class="row">
            <div class="col-6">
              <input
                v-model="user.email"
                type="text"
                id="registerCEmailInput"
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
                style="width:100% !important"
                v-model="user.emailDomain"
                name="emailadress"
                id="emailSelectBar"
                class="form-select"
                aria-label="Default select example"
              >
                <option value="@gmail.com" selected>gmail.com</option>
                <option value="@naver.com">naver.com</option>
                <option value="@daum.net">daum.net</option>
                <option value="@hanmail.net">hanmail.net</option>
                <option value="@kakao.com">kakao.com</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="register-item-wrapper">
        <label for="registerCNumberInput" class="register-input-label"
          >지갑연결</label
        >
        <button class="btn btn-info connect-wallet-btn" @click="getMetamask">지갑 가져오기</button>
        <div class="connected-wallet alert alert-primary">프리니즈에 연결된 지갑주소 : {{ user.accountAddress }}</div>
      </div>
      <div class="regist-terms-input-form">
        <div class="form-check">
          <input
            v-model="termsCheck"
            class="form-check-input"
            type="checkbox"
            value=""
            id="flexCheckDefault"
          />
          <label class="form-check-label" for="flexCheckDefault">
            서비스 <router-link to="/">이용약관</router-link>에 동의합니다.
          </label>
        </div>
      </div>
      <div class="regist-submit-btn-wrapper">
        <button type="button" class="btn btn-primary btn-lg" @click="Signup">
          <div style="padding-left:50px;padding-right:50px">
            회원가입
          </div>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import * as yup from "yup";
import { mapActions, mapGetters } from "vuex";
import { createInstance } from "@/api/index.js";

export default {
  props: {
    signupType: String
  },
  data() {
    return {
      fortest: "",
      termsCheck: false,
      isDuplicatedEmail: false,
      isDuplicatedId: false,
      isDuplicatedIdTried: false,
      isAuthorized: false,
      user: {
        id: "",
        name: "",
        number: "",
        password: "",
        email: "",
        emailDomain: "",
        passwordConfirm: "",
        accountAddress: ""
      },
      validationPattern: {
        pwdCheckPattern: /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+-])(?=.*[0-9]).{9,16}$/,
        idCheckPattern: /^[a-zA-Z0-9].{1,16}$/,
        eamilCheckPattern: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/
      },
      schema: yup.object().shape({
        name: yup.string().required("이름을 입력해주세요."),
        number: yup.number().required("전화번호를 입력해주세요."),
        emailadress: yup.string().required("이메일을 입력해주세요."),
        id: yup.string().required("아이디를 입력해주세요."),
        password: yup.string().required("비밀번호를 입력해주세요.")
      }),

      passwordvisible: false,
      passwordConfirmvisible: false
    };
  },
  computed: {
    ...mapGetters(["testdata"]),
    isPasswordSame() {
      return this.user.password != this.user.passwordConfirm;
    }
  },
  mounted() {
    console.log(this.signupType);
  },
  created() {
    console.log(this.signupType);
  },
  methods: {
    ...mapActions(["settestdata", "signupFreelancer", "signupCompany"]),
    idChange() {
      this.isDuplicatedId = false;
    },
    async getMetamask() {
      if (window.ethereum) {
        await window.ethereum.request({
        method: "wallet_switchEthereumChain",
        params: [{ chainId: "0Xaa36a7" }],
        });
        // first we check if metamask is installed
        var accounts = await window.ethereum.request({
          method: "eth_requestAccounts"
        });
        this.user.accountAddress = accounts[0];
      }
    },
    gettestdata() {
      this.settestdata(this.fortest);
    },
    checkIdDuplicate() {
      
      createInstance().get("/users/username/"+this.user.id+"/exists")
      .then(res=>{
        console.log(res)
        this.isDuplicatedId = res.data;
        console.log(this.isDuplicatedId)
        this.isDuplicatedIdTried = true;
        });
      

    },
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
    Signup() {
      console.log("유저정뵈:" + this.user);
      this.user.emailadress = `${this.email}@${this.emailDomain}`;
      this.schema.isValid(this.user).then((valid, msg) => {
        if (!valid) {
          alert("모든 정보를 입력해 주세요");
          return;
        }
      });
      if (!this.validationPattern.idCheckPattern.test(this.user.id)) {
        alert("아이디는 영문자 또는 숫자만 가능합니다.");
        return;
      } else if (
        !this.validationPattern.pwdCheckPattern.test(this.user.password)
      ) {
        alert(
          "비밀번호는 영문자+숫자+특수문자 조합으로 9~16자리를 사용해야합니다."
        );
        return;
      } else if (
        !this.validationPattern.eamilCheckPattern.test(this.user.emailadress)
      ) {
        alert("이메일 형태가 아닙니다. 다시 확인해주세요.");
        return;
      } else if (!this.user.accountAddress) {
        alert("지갑을 등록해주세요");
        return;
      } else if (!this.termsCheck) {
        alert("이용약관에 동의해주세요.");
        return;
      }
      // user: {
      //   id: "",
      //   name: "",
      //   number: "",
      //   password: "",
      //   email: "",
      //   emailDomain: "",
      //   passwordConfirm: ""
      // },
      if (this.signupType == "Company") {
        this.signupCompany(this.user);
      } else {
        // console.log(FreelancerInfo);
        this.signupFreelancer(this.user);
      }
    }
  }
};
</script>

<style>
.id-duplicate-confirm-btn {
  width: 100%;
  height: 100%;
}
.regist-terms-input-form .form-check-input {
  zoom: 1.5;
  font-size: 10px;
}
.regist-terms-input-form .form-check-label {
  zoom: 1.5;
  font-size: 10px;
}
.regist-email-input-wrapper {
  padding: 10px;
  font-size: 20px;
  width: 100%;
  border: none;
  outline: none;
}
.eye-wrapper {
  margin-left: 40%;
  margin-top: 15%;
  height: 50%;
  weight: 50%;
}
.register-wrapper {
  margin-top: 50px;
  width: 500px;
  /* border: 1px solid black; */
  display: inline-block;
  text-align: left;
}
.register-item-wrapper {
  margin-top: 20px;
}
.regist-terms-input-form {
  margin-top: 30px;
  text-align: center;
}
.regist-submit-btn-wrapper {
  margin-top: 30px;
  text-align: center;
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
.regist-header {
  margin-bottom: 50px;
}
.connected-wallet{

}
.connect-wallet-btn{
  margin: 5px 0px 5px 0px;
}
</style>
