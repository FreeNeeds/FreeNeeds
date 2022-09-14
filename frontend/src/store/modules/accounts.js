import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";

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
    settestdata({ commit }, data) {
      commit("SET_TEST", data);
    }
  }
};
