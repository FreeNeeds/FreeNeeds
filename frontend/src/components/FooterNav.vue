<template>
  <div>
    <a href="#" class="btn_gotop">
      <i class="bi bi-chevron-up"></i>
    </a>
    <footer class="text-center text-lg-start bg-light text-muted" style="margin-top:5rem;">
      <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
      </section>
      <section class="">
        <div class="container text-center text-md-start mt-5">
          <div class="row mt-3">
            <!-- Grid column -->
            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
              <!-- Content -->
              <h6 class="text-uppercase fw-bold mb-4">
                 <img width="230px" src="../assets/images/freeneedsfooter.png" alt="" />
              </h6>
              <p class="copyright-text">
                Copyright © 2022 - FreeNeeds All Rights Reserved.
              </p>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
              <!-- Links -->
              <h6 class="text-uppercase fw-bold mb-4">Developer</h6>
              <p>
                <a href="#!" class="text-reset text-developer">SUGEUN PARK</a>
              </p>
              <p>
                <a href="#!" class="text-reset text-developer">JAEYEONG PARK</a>
              </p>
              <p>
                <a href="#!" class="text-reset text-developer">MOONJO SUNG</a>
              </p>
              <p>
                <a href="#!" class="text-reset text-developer">YOUNGJIN YOO</a>
              </p>
              <p>
                <a href="#!" class="text-reset text-developer">DAIN LEE</a>
              </p>
              <p>
                <a href="#!" class="text-reset text-developer">DAYEON JO</a>
              </p>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
              <!-- Links -->
              <!-- <h6 class="text-uppercase fw-bold mb-4">Role</h6>
              <p>
                <a href="#!" class="text-reset">Designer</a>
              </p>
              <p>
                <a href="#!" class="text-reset">API</a>
              </p>
              <p>
                <a href="#!" class="text-reset">Speech-To-Text</a>
              </p>
              <p>
                <a href="#!" class="text-reset">WebRTC</a>
              </p>
              <p>
                <a href="#!" class="text-reset">JIRA</a>
              </p>
              <p>
                <a href="#!" class="text-reset">CI/CD</a>
              </p> -->
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
              <!-- Links -->
              <!-- <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
              <p><i class="fas fa-home me-3"></i> 대전광역시 유성구</p> -->
            </div>
            <!-- Grid column -->
          </div>
          <!-- Grid row -->
        </div>
      </section>
      <!-- Section: Links  -->

      <!-- Copyright -->
      <!-- <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05)">
        © 2022 Copyright:
        <a class="text-reset fw-bold" href="https://i7b202.p.ssafy.io/"
          >i7b202.p.ssafy.io</a
        >
      </div> -->
      <!-- Copyright -->
    </footer>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css");
.btn_gotop {
display: block;
position: fixed;
bottom: 35px; /* 탑버튼을 화면의 가장 아래에서 몇 픽셀 떨어뜨릴 것인지 정하세요*/
right: 30px; /* 탑버튼을 화면의 가장 오른쪽에서 몇 픽셀 떨어뜨릴 것인지 정하세요*/
z-index: 999;
border: 1px solid rgba(84, 109, 49, 0.25);
outline: none;
background-color: rgb(248, 248, 248);
color: rgba(200, 136, 136, 0.7);
cursor: pointer;
padding: 15px 20px;
border-radius: 100%;
}
.copyright-text{
  padding: 0px 0px 0px 10px;
  font-size: 13px;
}
.text-developer{
  text-decoration: none;
  font-size: 14px;
}

</style>
