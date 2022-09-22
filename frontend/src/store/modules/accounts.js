import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";
import * as UserInstance from "@/api/user.js";
export default {
  state: () => ({
    testdata: ""
  }),
  mutations: {
    SET_TEST(state, data) {
      state.testdata = data;
    }
  },
  getters: { testdata: state => state.testdata },
  actions: {
    signupFreelancer({}, FreelancerInfo) {
      // console.log(FreelancerInfo);

      UserInstance.signupFreelancer(
        FreelancerInfo,
        () => {
          alert("회원가입이 완료되었습니다.");
          router.push("/");
        },
        err => {
          alert("회원가입에 실패했습니다.");
          console.log(err);
        }
      );
    },
    settestdata({ commit }, data) {
      commit("SET_TEST", data);
    }
  }
};
