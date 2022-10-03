<template>
  <div class="container">
    <div class="index-signup-container">
      <div class="row">
        <div class="index-signup-header">로그인</div>
      </div>
      <div class="row" style="margin-top:50px">
        <div class="d-flex justify-content-between">
          <router-link
            to="/login/company"
            class="index-signup-selectbox company-selectbox"
          >
            <div class="index-signup-text">기업</div>
          </router-link>
          <router-link
            to="/login/freelancer"
            class="index-signup-selectbox freelancer-selectbox"
          >
            <div class="index-signup-text">프리랜서</div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.index-signup-text {
  padding-top: 28%;
  padding-bottom: 28%;
  padding-left: 25%;

  font-size: 30px;
  font-weight: bold;
}
.index-signup-header {
  font-size: 60px;
}
.index-signup-container {
  margin-top: 50px;
}
.index-signup-selectbox {
  width: 45%;
  height: auto;
  text-decoration: none;
}
.index-signup-selectbox:hover {
  text-decoration: none;
}
.freelancer-selectbox {
  background-color: #202632;
  color: white;
  transition: all 0.3s ease 0s;
  border-radius: 20px;
}
.company-selectbox {
  background-color: #0064ff;
  transition: all 0.3s ease 0s;
  color: black;
  border-radius: 20px;
}
.freelancer-selectbox:hover {
  opacity: 0.8;
  transform: translateY(-3px);
  color: white;
}
.company-selectbox:hover {
  opacity: 0.8;
  transform: translateY(-3px);
  color: white;
}
</style>
