import Vue from "vue";
import VueRouter from "vue-router";
import Signup from "@/views/Signup.vue";

import MyPage from "@/views/MyPage.vue";

import Mainpage from "@/views/Mainpage.vue";
import Login from "@/views/Login.vue";
import store from "@/store";

Vue.use(VueRouter);

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
    name: "login",
    path: "/login",
    component: Login
  },
  {
    path: "/register",
    name: "signup",
    component: Signup
  },
  {
    path: "/logout",
    name: "logout",
    beforeEnter(to, from, next) {
      store.commit("logout");
      alert("로그아웃 되었습니다.");
      next("/");
    }
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

router.beforeEach((to, from, next) => {
  let isSigned = store.state.isSigned;
  let isAvailableToGuest =
    ["/", "/login", "/register"].includes(to.path) ||
    to.path.startsWith("/explorer");

  // 로그인도 하지 않았고 게스트에게 허용된 주소가 아니라면 로그인 화면으로 이동한다.
  if (!isSigned && !isAvailableToGuest) {
    alert("로그인을 하신 뒤에 사용이 가능합니다.");
    next("/login");
  } else {
    next();
  }
});

export default router;
