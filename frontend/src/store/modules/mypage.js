import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";

/** 메뉴 json파일 */
import companymenus from "@/views/menus/mypage/mypageCompanyMenu.json";
import freelancermenus from "@/views/menus/mypage/mypageFreelancerMenu.json";
import applystatusmenus from "@/views/menus/mypage/applystatus/applystatusmenus.json";
import coinstatusmenus from "@/views/menus/mypage/coin/coinstatusmenus.json";
import projectstatusmenus from "@/views/menus/mypage/projectstatus/projectStatusMenus.json"

export default {
  state: () => ({
    mypageCompanyMenu: companymenus,
    mypageFreelancerMenu: freelancermenus,
    applyStatusMenus: applystatusmenus,
    coinstatusMenus: coinstatusmenus,
    projectStatusMenus: projectstatusmenus
  }),
  mutations: {},
  getters: {
    mypageCompanyMenu: state => state.mypageCompanyMenu,
    mypageFreelancerMenu: state => state.mypageFreelancerMenu,
    applyStatusMenus: state => state.applyStatusMenus,
    coinstatusMenus: state => state.coinstatusMenus,
    projectStatusMenus: state => state.projectStatusMenus
  },
  actions: {}
};
