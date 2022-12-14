import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";
import * as UserInstance from "@/api/user.js";
import * as ConpanyInstance from "@/api/company.js";
import * as authInstance from "@/api/auth.js";
export default {
  state: () => ({
    testdata: "",
    accessToken: "",
    loginUserInfo: {
      email: "",
      id: 0,
      name: "",
      phone: "",
      username: ""
    },
    loginType: ""
  }),
  mutations: {
    SET_TEST(state, data) {
      state.testdata = data;
    },
    SET_ACCESSTOKEN(state, data) {
      state.accessToken = data;
    },
    SET_LOGINUSERINFO(state, data) {
      state.loginUserInfo = data;
    },
    SET_LOGINTYPE(state, data) {
      state.loginType = data;
    }
  },
  getters: {
    authHeader: state => ({ Authorization: `Bearer ${state.accessToken}` }),
    testdata: state => state.testdata,
    loginUserInfo: state => state.loginUserInfo,
    accessToken: state => state.accessToken,
    isLogin: state => state.accessToken != "" || !!state.accessToken,
    loginType: state => state.loginType
  },
  actions: {
    goMypage({ state }) {
      if (state.loginType == "company") {
        router.push("/mypage/company");
      } else {
        router.push("/mypage/freelacer");
      }
    },
    logoutA({ commit }) {
      commit("SET_LOGINTYPE", "");
      commit("SET_ACCESSTOKEN", "");
      commit("SET_LOGINUSERINFO", {});
      router.push("/");
    },
    freelancerLoginA({ commit }, loginInfo) {
      authInstance.freelancerLogin(
        loginInfo,
        res => {
          commit("SET_ACCESSTOKEN", res.data.accessToken);
          const loginUserDate = {
            email: res.data.email,
            id: res.data.id,
            name: res.data.name,
            phone: res.data.phone,
            username: res.data.username
          };
          console.log(res);
          console.log(loginUserDate);
          commit("SET_LOGINUSERINFO", loginUserDate);
          commit("SET_LOGINTYPE", "freelancer");
          router.push("/");
        },
        err => {
          alert("????????? ????????? ???????????? ????????????.");
        }
      );
    },
    companyLoginA({ commit }, loginInfo) {
      console.log(loginInfo);
      authInstance.companyLogin(
        loginInfo,
        res => {
          commit("SET_ACCESSTOKEN", res.data.accessToken);
          const loginUserDate = {
            email: res.data.email,
            id: res.data.companyId,
            name: res.data.name,
            phone: res.data.phone,
            username: res.data.username
          };
          console.log(res);
          console.log(loginUserDate);
          commit("SET_LOGINUSERINFO", loginUserDate);
          commit("SET_LOGINTYPE", "company");
          router.push("/");
        },
        err => {
          alert("????????? ????????? ???????????? ????????????.");
        }
      );
    },
    signupFreelancer({}, FreelancerInfo) {
      // console.log(FreelancerInfo);

      UserInstance.signupFreelancer(
        FreelancerInfo,
        () => {
          alert("??????????????? ?????????????????????.");
          router.push("/");
        },
        err => {
          alert("??????????????? ??????????????????.");
          console.log(err);
        }
      );
    },
    signupCompany({}, CompanyInfo) {
      ConpanyInstance.signupCompany(
        CompanyInfo,
        () => {
          alert("??????????????? ?????????????????????.");
          router.push("/");
        },
        () => {
          alert("??????????????? ??????????????????.");
        }
      );
    },
    settestdata({ commit }, data) {
      commit("SET_TEST", data);
    }
  }
};
