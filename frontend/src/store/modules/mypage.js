import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";

import companymenus from "@/views/menus/mypageCompanyMenu.json";
import freelancermenus from "@/views/menus/mypageFreelancerMenu.json";

export default {
  state: () => ({
    mypageCompanyMenu: companymenus,
    mypageFreelancerMenu: freelancermenus
  }),
  mutations: {},
  getters: {
    mypageCompanyMenu: state => state.mypageCompanyMenu,
    mypageFreelancerMenu: state => state.mypageFreelancerMenu
  },
  actions: {}
};
