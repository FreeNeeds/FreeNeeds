<template>
  <div class="no-project-notion-wrapper">
    <img :src="imgsrc" style="width:130px;height:130px" />
    <div class="no-project-notion-text" style="margin-top:30px">
      해당되는 프로젝트가 없습니다.
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
  padding-top: 70px;
}
.no-project-notion-text {
  font-size: 25px;
  color: royalblue;
}
</style>
