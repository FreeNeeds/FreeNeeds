<template>
  <div class="wallet-container">
    <div class="wallet-header">
      <div class="own-coin-title">보유코인</div>
      <hr class="own-coin-header-line" />
      <div class="own-coin-adress">프리뱅크 {{ walletData.account }}</div>
    </div>
    <div class="wallet-show-coin">
      <img
        src="@/assets/images/bitcoinwallet.png"
        style="width:250px;height:250px"
      />
      <div class="wallet-show-balance">{{ getBalance }} Coin</div>
    </div>
    <coin-detail></coin-detail>
  </div>
</template>

<script>
import CoinDetail from "./wallet/CoinDetail.vue";
export default {
  components: {
    CoinDetail
  },
  data() {
    return {
      walletData: {
        account: "0X2a7b8c9d0e8f",
        balance: 12345
      }
    };
  },
  props: {
    // walletData:Object,
  },
  computed: {
    getBalance() {
      return this.walletData.balance
        .toString()
        .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
    }
  },
  mounted() {}
};
</script>

<style>
.wallet-container {
  margin-top: 30px;
}
.wallet-header {
  text-align: center;
}
.own-coin-header-line {
  margin: 3px auto 3px auto;
  width: 360px;
  text-align: center;
}
.own-coin-title {
  font-size: 45px;
  font-weight: bold;
}
.wallet-show-coin {
  text-align: center;
}
.wallet-show-balance {
  color: #3f79d1;
  font-size: 48px;
  font-weight: bold;
}
</style>
