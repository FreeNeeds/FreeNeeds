import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";
import * as projectInstance from "@/api/project.js";
import applyInstance from "@/api/apply.js";
export default {
  state: () => ({}),
  mutations: {},
  getters: {},
  actions: {
    getAllProjectList({ commit }, userId) {
      // projectInstance.getAllProjectList();
    },

    registProject({}, projectInfo) {
      projectInstance.registProject(
        projectInfo,
        () => {
          alert("프로젝트 등록이 완료되었습니다 !");
        },
        err => {
          alert("프로젝트 등록에 실패했습니다 ... ");
          console.log(err);
        }
      );
    }
  }
};
