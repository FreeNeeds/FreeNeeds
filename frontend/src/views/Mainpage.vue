<template>
  <b-container>
    <!--상단 네비게이션 바-->
    <!-- {{ loginUserInfo }} -->
    <div class="mainNav">
      <b-container class = "main-intro-container">
        <b-row>
          <b-col class="intro-textcol">
            <h1 class="intro-text">
              <span class="intro-btext">프리랜서,</span>
              구하세요?
            </h1>
             <h2 class="intro-textsub">IT 프리랜서 계약 플랫폼</h2>
            
            <h2 class="intro-textsub">FreeNeeds 가 도와드릴게요!</h2>
            <b-button variant="outline-primary"> 프리랜서 찾기</b-button>
            <b-button variant="outline-primary"> 프로젝트 찾기</b-button>
          </b-col>
          <b-col
            ><lottie-player
              src="https://assets4.lottiefiles.com/packages/lf20_slipwrv0.json"
              background="transparent"
              speed="1"
              style="width: 500px; height: 500px;"
              loop
              autoplay
            ></lottie-player
          ></b-col>
        </b-row> 
      </b-container>
    </div>
    <!--상단 네비게이션 바 끄읕-->

     <div class ="main-container" data-aos="fade-down" data-aos-easing="linear" data-aos-duration="1000">
      <h1 class="list-title"><img src="../assets/images/freeneeds.png" alt="" /></h1>
      <b-row>
      <b-col></b-col>
      <b-col>IT 프리랜서 계약 서비스로 <br>
      블록체인의 무결성을 이용해 계약서의 위변조를 방지하고<br> 계약 내용 변경 문제를 해결합니다.<br>
      또한 스마트컨트랙트를 통한 대금 정산으로<br> 대금 지연 지급 문제를 극복할 수 있습니다.</b-col>
      <b-col></b-col>
      </b-row>
    </div>
     <div class ="main-container" data-aos="fade-down" data-aos-easing="linear" data-aos-duration="1000">
      <h1 class="list-title">FreeNeeds 어떻게 돌아가나요?</h1>
     <b-row>
      <b-col></b-col>
      <b-col><div class="descFree-p"><lottie-player
          src="https://assets2.lottiefiles.com/private_files/lf30_io4tfdmg.json"
          background="transparent"
          speed="1"
          style="width: 250px; height: 300px; "
          loop
          autoplay
        ></lottie-player>블록체인 기반 계약서 작성으로 무결성 보장</div></b-col>
      <b-col><div class="descFree-p"><lottie-player
            src="https://assets9.lottiefiles.com/packages/lf20_uz2bwauj.json"
            background="transparent"
            speed="1"
            style="width: 200px; height:300px; padding-left: 40px;"
            loop
            autoplay
          ></lottie-player>스마트 컨트랙트 정산으로 대금 지급을 원할하게</div></b-col>
      <b-col></b-col>
      </b-row>
    </div>
    <div class ="main-container" >
      <h1 class="list-title">추천 프로젝트</h1>
      <b-row>
        <b-col><div class="descFree-project">
          <h2>{{recmdProject[0].company.name}}</h2>
          <hr>
          <div>{{recmdProject[0].category}}</div>
          <div>{{recmdProject[0].title}}</div>
          <span>{{recmdProject[0].startDate}}  ~ </span> 
          <span>{{recmdProject[0].endDate}}</span>
          </div></b-col>
        <b-col><div class="descFree-project">
          <h2>{{recmdProject[1].company.name}}</h2>
          <hr>
          <div>{{recmdProject[1].category}}</div>
          <div>{{recmdProject[1].title}}</div>
          <span>{{recmdProject[1].startDate}}  ~  </span>
          <span>{{recmdProject[1].endDate}}</span>
          </div></b-col>
         <b-col><div class="descFree-project">
          <h2>{{recmdProject[2].company.name}}</h2>
          <hr>
          <div>{{recmdProject[2].category}}</div>
          <div>{{recmdProject[2].title}}</div>
          <span>{{recmdProject[2].startDate}}  ~  </span>
          <span>{{recmdProject[2].endDate}}</span>
          </div></b-col>
      </b-row>
    </div>

    <div class ="main-container" >
      <h1 class="list-title">추천 프리랜서</h1>
      <b-row>
        <b-col><div class="descFree-user">{{recmdFreelancer[0]}}</div></b-col>
        <b-col><div class="descFree-user">{{recmdFreelancer[1]}}</div></b-col>
        <b-col><div class="descFree-user">{{recmdFreelancer[2]}}</div></b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";
import { createInstance } from "@/api/index.js";
import { mapGetters } from "vuex";
import "@lottiefiles/lottie-player";



// async function getProjectList(success, fail) {
//   instance
//     .get(`/project?page=0&size=3`)
//     .then(success=>{
//       console.log(success.data)
//       this.recmdProject =success.data;
//       console.log(this.recmdProject);
//       })
//     .catch(fail);
// }
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
      recmdFreelancer :[],
      recmdProject :[],
    };
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    }
  },
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  components: {
    HeaderNav,
    FooterNav
  },
  mounted(){
    const instance = createInstance();
    console.log(instance);
    instance.get(`/project?page=0&size=3`)
    .then(success=>{
      this.recmdProject =success.data;
      console.log(this.recmdProject);
      })
    

    instance.get(`/users?page=0&size=3`)
    .then(success=>{
      this.recmdFreelancer =success.data;
      console.log(this.recmdFreelancer);
      })
    
  }
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap");

* {
  font-family: "Noto Sans KR", sans-serif;

}
.main-intro-container{
  margin-bottom: 200px;
}
.list-title {
  text-align: center;
  margin-top: 80px;
  margin-bottom: 100px;
}
.card-list {
  height: 300px;
}
.link {
  text-decoration: none;
  color: #707070;
}
.intro-text {
  margin-top: 100px;
  margin-bottom: 20px;
  font-size: 40px;
  font-weight: bold;
  color: #444;
}
.intro-btext {
  color: #4657ff;
  font-size: 45px;
  font-weight: bolder;
}

.intro-textsub {
  font-size: 30px;
  font-weight: bold;
  color: #444;
}
.description {
  font-size: 19px;
  margin: 32px 0px;
  color: #444444ba;
}
.descFree {
  padding: 70px;
}
.intro-textcol {
  padding: 70px;
  margin-left: 70px;
}
.descFree-p{
  text-align: center;
  padding: auto;
  padding: 50px;
  margin: 50px;
border-radius: 26px;
background: #f9f9f9;
box-shadow:  5px 5px 9px #dedede,
             -5px -5px 9px #ffffff;
width: 350px;
height: 450px;
}
.main-container{
  /* padding: 100px 0px; */
 
  margin-bottom: 700px;
  justify-content: center;
  text-align: center;
  align-items: center;
  align-content: center;
}
.card-component{
  border: none;
}

.descFree-user{

  padding: auto;

border-radius: 26px;
background: #f9f9f9;
box-shadow:  5px 5px 9px #dedede,
             -5px -5px 9px #ffffff;
width: 400px;
height: 300px;
}

.descFree-project{

  padding: auto;
  padding-top: 10px;

border-radius: 26px;
background: #f9f9f9;
box-shadow:  5px 5px 9px #dedede,
             -5px -5px 9px #ffffff;
width: 400px;
height: 300px;
}

.descFree-project :hover{

  transform: scale(1.1);
}
</style>
