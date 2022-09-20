import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";

export default {
  state: () => ({
    selectedMessage: [],
    selectedIndex: Number
  }),
  mutations: {
    SET_SELECTED_INDEX(state, data) {
      state.selectedIndex = data;
    },
    ADD_SELECTED_MESSAGE(state, data) {
      state.selectedMessage.push(data);
    },
    REMOVE_SELECTED_MESSAGE(state, data) {
      state.selectedMessage = state.selectedMessage.filter(listdata => {
        return listdata != data;
      });
    }
  },
  getters: {
    selectedMessage: state => state.selectedMessage,
    selectedIndex: state => state.selectedIndex
  },
  actions: {
    setSelectedIndex({ commit }, data) {
      commit("SET_SELECTED_INDEX", data);
    },
    addSelectedMessage({ commit }, data) {
      commit("ADD_SELECTED_MESSAGE", data);
    },
    removeSelectedMessage({ commit }, data) {
      commit("REMOVE_SELECTED_MESSAGE", data);
    }
  }
};
