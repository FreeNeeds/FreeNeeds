import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";
import projectInstance from "@/api/project.js";
import applyInstance from "@/api/apply.js";
export default {
  state: () => ({}),
  mutations: {},
  getters: {},
  actions: {
    getAllProjectList({ commit }, userId) {
      // projectInstance.getAllProjectList();
    }
  }
};
