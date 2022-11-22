import axios from "axios";
import instance from "@/api/index.js";
import router from "@/router/index.js";

/** 메뉴 json파일 */
import companymenus from "@/views/menus/mypage/mypageCompanyMenu.json";
import freelancermenus from "@/views/menus/mypage/mypageFreelancerMenu.json";
import applystatusmenus from "@/views/menus/mypage/applystatus/applystatusmenus.json";
import coinstatusmenus from "@/views/menus/mypage/coin/coinstatusmenus.json";
import projectstatusmenus from "@/views/menus/mypage/projectstatus/projectStatusMenus.json";

export default {
  state: () => ({
    isModalOn: false,
    freelancerInfoDetail: {
      userId: 0,
      username: "defaultusername",
      email: "",
      name: "",
      phone: "",
      accountAddress: "",
      publicKey: null,
      privateKey: null,
      password: "",
      resume: {
        profileId: 0,
        userId: 0,
        username: "",
        name: "",
        title: "",
        introduce: "",
        creer_period: 0,
        career_period: 0
      },
      tech: [],
      estimate: [
        {
          profession: 0,
          ontime: 0,
          active: 0,
          communication: 0,
          reEmployment: 0
        }
      ],
      projectCareer: []
    },
    mypageCompanyMenu: companymenus,
    mypageFreelancerMenu: freelancermenus,
    applyStatusMenus: applystatusmenus,
    coinstatusMenus: coinstatusmenus,
    projectStatusMenus: projectstatusmenus
  }),
  mutations: {
    SET_IS_MODAL_ON(state, data) {
      state.isModalOn = data;
    },
    SET_FREELANCER_INFO_DETAIL(state, data) {
      state.freelancerInfoDetail = data;
    }
  },
  getters: {
    isModalOn: state => state.isModalOn,
    freelancerInfoDetail: state => state.freelancerInfoDetail,
    mypageCompanyMenu: state => state.mypageCompanyMenu,
    mypageFreelancerMenu: state => state.mypageFreelancerMenu,
    applyStatusMenus: state => state.applyStatusMenus,
    coinstatusMenus: state => state.coinstatusMenus,
    projectStatusMenus: state => state.projectStatusMenus
  },
  actions: {
    setFreelancerInfoDetail({ commit }, data) {
      commit("SET_FREELANCER_INFO_DETAIL", data);
    },
    setIsModalOn({ commit }, data) {
      commit("SET_IS_MODAL_ON", data);
    }
  }
};
