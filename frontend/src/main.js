import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import AOS from 'aos';
import "aos/dist/aos.css";
import VueTypedJs from 'vue-typed-js';
import VueRellax from 'vue-rellax';

Vue.use(VueTypedJs);
Vue.use(BootstrapVue);
Vue.use(VueRellax);
Vue.config.productionTip = false;
Vue.filter("truncate", function(text, length, clamp) {
  if (text) {
    clamp = clamp || "...";
    return text.length > length ? text.slice(0, length) + clamp : text;
  }
});

new Vue({
  created() {
    AOS.init();
},
  router,
  store,
  render: h => h(App)
}).$mount("#app");

//Vue.component("HNav", HNav);
//Vue.component("HBreadcrumb", HBreadcumb);
