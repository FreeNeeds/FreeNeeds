<template>
  <router-view></router-view>
</template>

<script>
import { mapActions } from "vuex";
export default {
  mounted() {},
  method: {
    ...mapActions(["getAllProjectList"])
  }
};
</script>

<style></style>
