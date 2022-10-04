<template>
  <div class="coin-detail-wrapper">
    <div class="coin-detail-header">
      <div class="coin-detail-header-text">
        코인내역
      </div>
      <hr class="coin-detail-header-line" />
    </div>
    <div class="row ">
      <div class="d-flex justify-content-end menu-list-wrapper">
        <div
          v-for="(item, index) in menuList"
          :key="index"
          style="display:inline"
          class="coin-status-router"
          :class="{ 'list-item-active': item.name == selectedManu }"
          @click="selectHistoryMode(item.name)"
        >
          <div class="coin-status-list-item">
            {{ item.name }}
          </div>
        </div>
      </div>
    </div>
    <hr style="margin-top:1px; margin-bottom: 0;" />
    <div class="coin-status-list-item-wrapper">
      <div class="d-flex justify-content-between">
        <div class="coin-status-detail-item">사피 컴퍼니</div>
        <div class="coin-status-detail-item">30000Coin</div>
      </div>
    </div>
    <div class="coin-status-send-img d-flex justify-content-end">
      <img src="@/assets/images/sendcoinimg.png" alt="" />
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      menuList: [],
      selectedManu: "전체"
    };
  },
  computed: {
    ...mapGetters(["coinstatusMenus"])
  },
  methods: {
    selectHistoryMode(itemName) {
      this.selectedManu = itemName;
    }
  },
  mounted() {
    let keys = Object.keys(this.coinstatusMenus);

    for (let i = 0; i < keys.length; i++) {
      let menuObject = {};
      menuObject.name = this.coinstatusMenus[keys[i]].name;
      menuObject.path = this.coinstatusMenus[keys[i]].path;
      this.menuList.push(menuObject);
    }
    console.log(this.menuList);
  }
};
</script>

<style>
.coin-status-list-item:hover {
  cursor: pointer;
}
.coin-detail-wrapper {
  margin-top: 30px;
}
.coin-detail-header {
}
.coin-detail-header-line {
  margin: 3px 0px 15px 0px;
}
.coin-detail-header-text {
  font-size: 24px;
  font-weight: bold;
}
.menu-list-wrapper > .router-link-active {
  font-weight: bold;
}
.coin-status-router {
  text-decoration: none;
  color: black;
}
.coin-status-router:hover {
  text-decoration: none;
  color: black;
}
.router-link-active > .coin-status-list-item::after {
  content: "";
  display: block;
  width: 100%;
  height: 3px;
  position: absolute;
  bottom: -1px;
  left: 1px;
  background: black;
}
.coin-status-list-item {
  font-size: 20px;
  margin-right: 10px;
  position: relative;
}
.coin-status-list-item-wrapper {
  width: 100%;
  border-radius: 45px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  margin-top: 15px;
}
.coin-status-detail-item {
  padding: 10px;
}
.list-item-active {
  font-weight: bold;
}
.list-item-active .coin-status-list-item::after {
  content: "";
  display: block;
  width: 100%;
  height: 2px;
  position: absolute;
  bottom: -1px;
  left: 1px;
  background: black;
}
.coin-status-send-img {
  margin-top: 10px;
}
</style>
