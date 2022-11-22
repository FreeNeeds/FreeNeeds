import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";
import * as UserInstance from "@/api/user.js";
import * as ConpanyInstance from "@/api/company.js";
import * as authInstance from "@/api/auth.js";
export default {
  state: () => ({
    freelancerFilter: [],
    projectFilter: {}
  }),
  mutations: {
    SET_FREELANCERFILTER(state, data) {
      state.freelancerFilter = data;
    },
    SET_PROJECTFILTER(state, data) {
      state.projectFilter = data;
    }
  },
  getters: {
    freelancerFilter: state => state.freelancerFilter,
    projectFilter: state => state.projectFilter
  },
  actions: {
    setFreelancerFilter({ commit }, data) {
      console.log(data);
      commit("SET_FREELANCERFILTER", data);
    },
    setProjectFilter({ commit }, data) {
      commit("SET_PROJECTFILTER", data);
    }
  }
};
