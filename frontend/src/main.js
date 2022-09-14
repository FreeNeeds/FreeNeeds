import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
Vue.config.productionTip = false;
Vue.filter("truncate", function(text, length, clamp) {
  if (text) {
    clamp = clamp || "...";
    return text.length > length ? text.slice(0, length) + clamp : text;
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
Vue.use(BootstrapVue);
//Vue.component("HNav", HNav);
//Vue.component("HBreadcrumb", HBreadcumb);
