import Vue from "vue";
import Vuex from "vuex";
import accounts from "@/store/modules/accounts.js";
Vue.use(Vuex);
const user = JSON.parse(sessionStorage.getItem("user"));
const initialState = user
  ? { status: { isSigned: true }, user }
  : { status: { isSigned: false }, user: null };

export default new Vuex.Store({
  state: initialState,
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
  modules: { accounts }
});
