<template>
  <div class="container">
    <div class="index-signup-container">
      <div class="row">
        <div class="index-signup-header">로그인</div>
      </div>
      <div class="row" style="margin-top:50px">
        <div class="d-flex justify-content-between">
          <router-link
            to="/login/Company"
            class="index-signup-selectbox company-selectbox"
          >
            <div class="index-signup-text">기업</div>
          </router-link>
          <router-link
            to="/login/Freelancer"
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
  padding-left: 45%;
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
  background-color: #3c3c3c;
  color: white;
}
.company-selectbox {
  background-color: #f6f6f6;
  color: black;
}
.freelancer-selectbox:hover {
  background-color: #3c3c3c;
  color: white;
}
.company-selectbox:hover {
  background-color: #f6f6f6;
  color: black;
}
</style>
