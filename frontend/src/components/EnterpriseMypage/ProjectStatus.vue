<template> 
  <div>
    <div class="row ">
      <div class="d-flex justify-content-end menu-list-wrapper">
        <router-link
          v-for="(item, index) in menuList"
          :key="index"
          :to="item.path"
          style="display:inline"
          class="apply-status-router"
        >
          <div class="apply-status-list-item">
            {{ item.name }}
          </div>
        </router-link>
      </div>
    </div>
    <hr style="margin-top:1px; margin-bottom: 0;" />
    <router-view></router-view>
  </div>
</template>

<script>
  import { mapGetters } from "vuex";
  export default {
    data() {
      return {
        menuList: []
      };
    },
    computed: {
      ...mapGetters(["projectStatusMenus"])
    },
    mounted() {
      let keys = Object.keys(this.projectStatusMenus);

      for (let i = 0; i < keys.length; i++) {
        let menuObject = {};
        menuObject.name = this.projectStatusMenus[keys[i]].name;
        menuObject.path = this.projectStatusMenus[keys[i]].path;
        this.menuList.push(menuObject);
      }
      console.log(this.menuList);
    }
  };
</script>

<style>
.menu-list-wrapper > .router-link-active {
  font-weight: bold;
}

.apply-status-router {
  text-decoration: none;
  color: black;
}
.apply-status-router:hover {
  text-decoration: none;
  color: black;
}
.router-link-active > .apply-status-list-item::after {
  content: "";
  display: block;
  width: 100%;
  height: 3px;
  position: absolute;
  bottom: -1px;
  left: 1px;
  background: black;
}
.apply-status-list-item {
  font-size: 20px;
  margin-right: 10px;
  position: relative;
}
/* .apply-status-list-item::after {
  content: "";
  display: block;
  width: 100%;
  height: 3px;
  position: absolute;
  bottom: -1px;
  left: 1px;
  background: black;
} */
/* .apply-status-list-item-underline {
}
.apply-status-list-item-underline::after {
  content: "";
  display: block;
  width: 100%;
  height: 2px;
  position: absolute;
  bottom: 1px;
  left: 1px;
  background: black;
} */
</style>