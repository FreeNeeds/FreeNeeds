
import * as applyInstance from "@/api/apply.js";

export default {
  state: () => ({}),
  mutations: {},
  getters: {},
  actions: {
    createApply({}, applyInfo) {
      // console.log("출력잘되냐?");
      // console.log(applyInfo);
      applyInstance.ApplyProject(applyInfo,
        (success) => {
          console.log(success);
        },
        (err) => { 
          console.log(err);
        });
    },
  }
};
