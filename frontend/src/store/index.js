import Vue from "vue";
import Vuex from "vuex";
import accounts from "@/store/modules/accounts.js";
import mypage from "@/store/modules/mypage.js";
import message from "@/store/modules/message.js";
import project from "@/store/modules/project.js";
import user from "@/store/modules/user.js";
import filter from "@/store/modules/filter.js"
import apply from "@/store/modules/apply.js"
import { createVuexPersistedState } from "vue-persistedstate";
Vue.use(Vuex);

export default new Vuex.Store({
  mutations: {
    setIsSigned(state, isSigned) {
      state.status.isSigned = isSigned;
    },
    setUser(state, data) {
      if (data.accessToken) {
        sessionStorage.setItem("user", JSON.stringify(data));
        state.user = data;
      }
    },
    /*
    setWalletAddress(state, address) {
      state.user.walletAddress = address;
    },*/
    logout(state) {
      sessionStorage.removeItem("user");
      state.status.isSigned = false;
      state.user = null;
      //state.user.walletAddress = null;
    }
  },
  actions: {},
  modules: { accounts, mypage, message, user, project, filter, apply },
  plugins: [
    createVuexPersistedState({
      storage: window.sessionStorage
    })
  ]
});
