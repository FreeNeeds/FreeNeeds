<template>
  <div class="no-project-notion-wrapper">
    <img :src="imgsrc" style="width:270px;height:270px" />
    <div class="no-project-notion-text" style="margin-top:50px">
      해당하는 프로젝트가 없습니다.
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imgsrc: require("@/assets/images/freechcry.png")
    };
  }
};
</script>

<style>
.no-project-notion-wrapper {
  text-align: center;
  padding-top: 100px;
}
.no-project-notion-text {
  font-size: 36px;
  color: royalblue;
}
</style>
