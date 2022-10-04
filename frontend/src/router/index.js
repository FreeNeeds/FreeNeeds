import Vue from "vue";
import VueRouter from "vue-router";
import Signup from "@/views/Signup.vue";
import Mainpage from "@/views/Mainpage.vue";
import IndexLogin from "@/views/indexLogin.vue";
import store from "@/store";

import Project from "@/views/Project";
import Freelancer from "@/views/Freelancer.vue";
import IndexSignup from "@/views/IndexSignup";
import Login from "@/views/Login.vue";

/** 마이페이지 */
import Mypage from "@/views/MyPage";

/** 프리랜서 마이페이지 */
import ApplyStatus from "@/components/FreelancerMypage/ApplyStatus";
import ManageCareer from "@/components/FreelancerMypage/ManageCareer";
import FreelancerMessage from "@/components/FreelancerMypage/FreelancerMessage";
import FreelancerWallet from "@/components/FreelancerMypage/FreelancerWallet";
import ManageCareerMain from "@/components/FreelancerMypage/ManageCareerMain";
/** 기업 마이페이지 */
import CompanyInfoAdmin from "@/components/EnterpriseMypage/CompanyInfoAdmin";
import CompanyMessage from "@/components/EnterpriseMypage/CompanyMessage";
import CompanyWallet from "@/components/EnterpriseMypage/CompanyWallet";
import ProjectRegist from "@/components/EnterpriseMypage/ProjectRegist";
import ProjectStatus from "@/components/EnterpriseMypage/ProjectStatus";

Vue.use(VueRouter);

/** 프리랜서 프로젝트 현황 컴포넌트 */
import ApplyProject from "@/components/FreelancerMypage/ApplyStatus/ApplyProject";
import RequestedProject from "@/components/FreelancerMypage/ApplyStatus/RequestedProject";
import SignedProject from "@/components/FreelancerMypage/ApplyStatus/SignedProject";
import UnderContract from "@/components/FreelancerMypage/ApplyStatus/UnderContract";

/** 프리랜서 커리어관리 컴포넌트 */
import CorrectInfomation from "@/components/FreelancerMypage/ManageCareer/CorrectInfomation.vue";

/** 기업 프로젝트 현황*/
import recruit from "@/components/EnterpriseMypage/ProjectStatus/recruit";
import ongoing from "@/components/EnterpriseMypage/ProjectStatus/ongoing";
import complete from "@/components/EnterpriseMypage/ProjectStatus/complete";
import recruitApplyMember from "@/components/EnterpriseMypage/ProjectStatus/recruitApplyMember";

/**
 * 아래의 router를 변경하여 구현할 수 있습니다.
 */
const routes = [
  {
    path: "/",
    name: "main",
    component: Mainpage
  },
  {
    name: "indexLogin",
    path: "/login",
    component: IndexLogin
  },
  {
    path: "/register/:signupType",
    name: "signup",
    component: Signup,
    props: true
  },
  {
    path: "/login/:loginType",
    name: "login",
    component: Login,
    props: true
  },
  {
    path: "/logout",
    name: "logout",
    beforeEnter(to, from, next) {
      store.commit("logout");
      alert("로그아웃 되었습니다.");
      next("/");
    }
  },
  {
    path: "/project",
    name: "project",
    component: Project
  },
  {
    path: "/freelancer",
    name: "freelancer",
    component: Freelancer
  },
  {
    path: "/register",
    name: "indexsignup",
    component: IndexSignup
  },
  {
    path: "/mypage/:accountType",
    name: "mypage",
    component: Mypage,
    props: true,
    redirect: to => {
      const { hash, params, query } = to;
      if (params.accountType == "company" || params.accountType == "Company") {
        return "/mypage/company/projectstatus";
      } else {
        return "/mypage/freelancer/applystatus";
      }
    },
    children: [
      {
        path: "applystatus",
        name: "applystatus",
        component: ApplyStatus,
        redirect: "/mypage/freelancer/applystatus/requestedproject",
        children: [
          {
            path: "requestedproject",
            name: "requestedproject",
            component: RequestedProject
          },
          {
            path: "applyproject",
            name: "applyproject",
            component: ApplyProject
          },
          {
            path: "undercontract",
            name: "undercontract",
            component: UnderContract
          },
          {
            path: "signedproject",
            name: "signedproject",
            component: SignedProject
          }
        ]
      },
      {
        path: "managecareer",
        name: "managecareer",
        component: ManageCareerMain,
        redirect: "/mypage/freelancer/managecareer/myCareer",
        children: [
          {
            path: "mycareer",
            name: "mycareer",
            component: ManageCareer
          },
          {
            path: "correctmycareer",
            name: "correctmycareer",
            component: CorrectInfomation,
            props: true
          }
        ]
      },
      {
        path: "freelancermessage",
        name: "freelancermessage",
        component: FreelancerMessage
      },
      {
        path: "freelancerwallet",
        name: "freelancerwallet",
        component: FreelancerWallet
      },
      {
        path: "projectstatus",
        name: "projectstatus",
        component: ProjectStatus,
        redirect: "/mypage/company/projectstatus/recruit",
        children: [
          {
            path: "recruit",
            name: "recruit",
            component: recruit
          },
          {
            path: "ongoing",
            name: "ongoing",
            component: ongoing
          },
          {
            path: "complete",
            name: "complete",
            component: complete
          }
        ]
      },
      {
        path: "projectstatus/recruit/apply",
        name: "apply",
        component: recruitApplyMember
      },
      {
        path: "projectregist",
        name: "projectregist",
        component: ProjectRegist
      },
      {
        path: "companyinfoadmin",
        name: "companyinfoadmin",
        component: CompanyInfoAdmin
      },
      {
        path: "companywallet",
        name: "companywallet",
        component: CompanyWallet
      },
      {
        path: "companymessage",
        name: "companymessage",
        component: CompanyMessage
      }
    ]
  }
];

const router = new VueRouter({
  mode: "history",
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
  base: process.env.BASE_URL,
  routes
});

/*
router.beforeEach((to, from, next) => {
  let isSigned = store.state.isSigned;
  let isAvailableToGuest =
    ["/", "/login", "/register"].includes(to.path) ||
    to.path.startsWith("/explorer");

  // 로그인도 하지 않았고 게스트에게 허용된 주소가 아니라면 로그인 화면으로 이동한다.
  if (to.meta.IsLogin && !isSigned && !isAvailableToGuest) {
    alert("로그인을 하신 뒤에 사용이 가능합니다.");
    next("/login");
  } else {
    next();
  }
});
*/
export default router;
