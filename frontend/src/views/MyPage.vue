<template>
  <div class="container">
    <div class="row">
      <div class="col-3">
        <div class="mypage-menu-wrapper">
          <h2>마이페이지</h2>
          <div class="mypage-menu-items-wrapper">
            <router-link
              class="mypage-menu-item-wrapper"
              v-for="(item, index) in menulist"
              :key="index"
              :to="item.path"
            >
              <div>
                <div class="mypage-menu-item-title">
                  {{ item.name }}
                </div>
                <hr />
              </div>
            </router-link>
          </div>
        </div>
      </div>
      <div class="col">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      menulist: []
    };
  },
  props: {
    accountType: String
  },
  computed: {
    ...mapGetters(["mypageCompanyMenu", "mypageFreelancerMenu"])
  },
  mounted() {
    console.log(this.accountType);
    let target;
    if (this.accountType == "company" || this.accountType == "Company") {
      target = this.mypageCompanyMenu;
    } else {
      target = this.mypageFreelancerMenu;
    }
    let keys = Object.keys(target);

    for (let i = 0; i < keys.length; i++) {
      let menuObject = {};
      menuObject.name = target[keys[i]].name;
      menuObject.path = target[keys[i]].path;
      this.menulist.push(menuObject);
    }
    console.log(this.menulist);
  }
};
</script>

<style>
.mypage-menu-item-title {
  padding-left: 10px;
}
.mypage-menu-wrapper {
  background: #ffffff;
  box-shadow: 0px 4px 12px rgba(63, 121, 209, 0.25),
    0px 0px 12px rgba(63, 121, 209, 0.25);
  padding: 30px;
  margin-top : 30px;
}
.mypage-menu-items-wrapper {
  margin-top: 40px;
  margin-bottom: 40px;
}
.mypage-menu-item-wrapper {
  margin-bottom: 20px;
  text-decoration: none;
  color: #b4b4b4;
}
.mypage-menu-item-wrapper:hover {
  text-decoration: none;
  /* color: #b4b4b4; */
}
.mypage-menu-items-wrapper > .router-link-active {
  color: #3f79d1;
  font-weight: bold;
}
</style>
