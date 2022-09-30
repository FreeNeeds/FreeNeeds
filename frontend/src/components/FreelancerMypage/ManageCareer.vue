<template>
  <div>
    <freelancer-detail-component
      v-if="isLoading"
      :freelancerDetailReceive="freelancerDataReceive"
      :id_="freelancerDataReceive.id"
    ></freelancer-detail-component>
  </div>
</template>

<script>
import FreelancerDetailComponent from "../Freelancer/FreelancerDetailComponent.vue";
import * as userInstance from "@/api/user.js";
import * as estimateInstance from "@/api/estimate.js";
import { mapGetters } from "vuex";
export default {
  components: { FreelancerDetailComponent },
  computed: {
    ...mapGetters(["loginUserInfo"])
  },
  data() {
    return {
      freelancerDataReceive: {},
      isLoading: false
    };
  },
  async mounted() {
    this.freelancerDataReceive.id = 1;
    // console.log("????");
    // console.log(this.loginUserInfo.username);
    var haveresume = false;
    await userInstance.getUserProfile(
      this.loginUserInfo.username,
      res => {
        let data = this.loginUserInfo;
        data.resume = {};
        data.resume.title = res.data.title;
        data.resume.introduce = res.data.introduce;
        data.resume.career_period = res.data.creer_period;
        data.resume.profileId = res.data.profileId;
        this.freelancerDataReceive = data;
      },
      err => {
        // let data = this.loginUserInfo;
        // data.resume = {};
        // data.resume.title = "asd";
        // data.resume.introduce = "res.data.introduce";
        // data.resume.career_period = 0;
        // data.resume.profileId = "";
        // this.freelancerDataReceive = data;
        haveresume = true;
      }
    );
    if (haveresume) {
      let data = {};
      data.title = "이력서를 작성해보세요!";
      data.introduce = "소개글을 작성해보세요!";
      data.career_period = 0;
      // console.log(data);
      await userInstance.setUserProfile(data, () => {
        // console.log("이건되니?");
      });
      await userInstance.getUserProfile(
        this.loginUserInfo.username,
        res => {
          let data = this.loginUserInfo;
          data.resume = {};
          data.resume.title = res.data.title;
          data.resume.introduce = res.data.introduce;
          data.resume.career_period = res.data.career_period;
          data.resume.profileId = res.data.profileId;
          this.freelancerDataReceive = data;
        },
        err => {
          // console.log("?=");
        }
      );
    }

    // console.log("??????");
    // console.log(this.freelancerDataReceive);
    this.freelancerDataReceive.tech = [];
    if (this.freelancerDataReceive.resume.profileId != "") {
      await userInstance.getUserTech(
        this.freelancerDataReceive.resume.profileId,
        res => {
          // console.log("???" + res.data);
          for (let i = 0; i < res.data.length; i++) {
            // console.log(res.data[i]);
            // console.log(res);
            this.freelancerDataReceive.tech.push(res.data[i].techName);
          }
        },
        err => {
          console.log("is error?");
        }
      );
    }

    // console.log(this.freelancerDataReceive);
    await estimateInstance.getUserEstimate(
      this.freelancerDataReceive.username,
      res => {
        if (res.data.length > 0) {
          this.freelancerDataReceive.estimate = res.data;
        } else {
          this.freelancerDataReceive.estimate = [];
        }
      },
      err => {}
    );

    this.freelancerDataReceive.projectCareer = [];
    await userInstance.getUserProject(
      this.freelancerDataReceive.username,
      res => {
        for (let i = 0; i < res.data.length; i++) {
          const data = {
            projectCareerId: res.data[i].projectCareerId,
            category: res.data[i].category,
            domain: res.data[i].domain,
            company_name: res.data[i].companyName,
            title: res.data[i].title,
            content: res.data[i].content,
            startDate: res.data[i].start_date,
            endDate: res.data[i].end_date
          };
          this.freelancerDataReceive.projectCareer.push(data);
        }
      },
      err => {}
    );

    for (let j = 0; j < this.freelancerDataReceive.projectCareer.length; j++) {
      this.freelancerDataReceive.projectCareer[j].projectCareerTech = [];
      await userInstance.getUserProjectTech(
        this.freelancerDataReceive.projectCareer[j].projectCareerId,

        res => {
          for (let k = 0; k < res.data.length; k++) {
            this.freelancerDataReceive.projectCareer[j].projectCareerTech.push(
              res.data[k].techName
            );
          }
        },
        err => {
          this.freelancerDataReceive.projectCareer[j].projectCareerTech = [];
        }
      );
    }
    // console.log(this.freelancerDataReceive);
    this.isLoading = true;
  }
};
</script>

<style></style>
