<template>
  <div>
    <header-nav-vue></header-nav-vue>
    <!-- <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div> -->
    <router-view style="width:1526.400px" />
    <footer-nav-vue></footer-nav-vue>
  </div>
</template>
<script>
import HeaderNavVue from "./components/HeaderNav.vue";
import FooterNavVue from "./components/FooterNav.vue";
export default {
  components: {
    HeaderNavVue,
    FooterNavVue
  }
};
</script>
<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #292321;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.form-group .content {
  font-size: 1.2rem;
}
</style>
