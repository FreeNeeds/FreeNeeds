import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";

import * as userInstance from "@/api/user.js";
import * as estimateInstance from "@/api/estimate.js";

export default {
  state: () => ({}),
  mutations: {},
  getters: {},
  actions: {
    getUserprofile({ commit }, username, success, fail) {
      userInstance.getUserProfile(username, success, fail);
    },
    getUserTech({ commit }, profileId, success, fail) {
      userInstance.getUserTech(profileId, success, fail);
    },
    getUserEstimate({ commit }, username, success, fail) {
      estimateInstance.getUserEstimate(username, success, fail);
    },
    getUserProjectHistory({ commit }, username, success, fail) {
      userInstance.getUserProjectTech(username, success, fail);
    }
  }
};
