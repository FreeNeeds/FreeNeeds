<template>
  <div id="freelancer-list" v-if="isDataLoaded">
    <!-- <div>{{ totalUserList }}</div>
    <div>{{ freelancerCardLst }}</div>
    <div>{{ freelancerDataReceive }}</div> -->
    <!-- {{ pageIdx }} -->
    <FreelancerCard
      v-for="(freelancerCard, index) in freelancerCardLst"
      :key="index"
      :freelancerCard="freelancerCard"
      class="freelancer-list-card-wrapper col-6"
      style="padding : 0px"
      @logo="logo"
    ></FreelancerCard>
  </div>
</template>

<script>
import FreelancerCard from "@/components/Freelancer/FreelancerCardNoModal.vue";
import { mapActions, mapGetters } from "vuex";

import * as userInstance from "@/api/user.js";
import * as EstimateInstance from "@/api/estimate.js";

export default {
  props: {
    idx: Number,
    pageIdx: Number,
    btnIdx: Number
  },
  async mounted() {
    // console.log(this.searchOption.page);
    // console.log(this.pageIdx + " : " + this.idx);
    // console.log("설마 이거 다시 실행함?");
    /** 전체 유저 리스트 받아오기 */
    // console.log("????");
    await userInstance.getUserList(this.searchOption, res => {
      this.totalUserList = res.data;
    });
    await this.settingFreelancer();
    this.isDataLoaded = true;
  },
  methods: {
    logo(value) {
      this.$emit('logo',value)
    },
    async settingFreelancer() {
      // thos.totalUserList: [],
      this.freelancerDataReceive = [];
      this.freelancerCardLst = [];
      /** 유저 프로필 정보 받아오기 */
      for (let i = 0; i < this.totalUserList.length; i++) {
        // console.log(this.totalUserList[i]);
        await userInstance.getUserProfile(
          this.totalUserList[i].username,
          res => {
            // console.log(res);
            const data = this.totalUserList[i];
            data.resume = {};
            data.resume = res.data;
            data.resume.career_period = res.data.creer_period;
            // data.resume.title = res.data.title;
            // data.resume.introduce = res.data.introduce;
            // data.resume.career_period = res.data.creer_period;
            // data.resume.profileId = res.data.profileId;
            this.freelancerDataReceive.push(data);
          },
          () => {
            const data = this.totalUserList[i];
            data.resume = {};
            data.resume.title = "";
            data.resume.introduce = "";
            data.resume.career_period = 0;
            data.resume.profileId = "";
            this.freelancerDataReceive.push(data);
          }
        );
      }
      // console.log(this.freelancerDataReceive);

      /** 유저 프로필 기술 받아오기 */

      for (let i = 0; i < this.freelancerDataReceive.length; i++) {
        if (this.freelancerDataReceive[i].resume.profileId != "") {
          userInstance.getUserTech(
            this.freelancerDataReceive[i].resume.profileId,
            res => {
              // console.log(res);
              // console.log(res);
              this.freelancerDataReceive[i].tech = [];
              for (let k = 0; k < res.data.length; k++) {
                this.freelancerDataReceive[i].tech.push(res.data[k].techName);
              }
            }
          );
        }
      }
      // console.log(this.freelancerDataReceive);
      /** 유저 평가 받아오기 */
      for (let i = 0; i < this.freelancerDataReceive.length; i++) {
        await EstimateInstance.getUserEstimate(
          this.freelancerDataReceive[i].username,
          res => {
            // console.log(res);
            if (res.data.length > 0) {
              this.freelancerDataReceive[i].estimate = res.data;
            } else {
              const data = [
                {
                  profession: 0,
                  ontime: 0,
                  active: 0,
                  communication: 0,
                  reEmployment: 0
                }
              ];
              this.freelancerDataReceive[i].estimate = data;
            }
          }
        );
      }
      // console.log(this.freelancerDataReceive);
      /** 유저 프로젝트 이력 가져오기 */
      for (let i = 0; i < this.freelancerDataReceive.length; i++) {
        this.freelancerDataReceive[i].projectCareer = [];

        await userInstance.getUserProject(
          this.freelancerDataReceive[i].username,
          res => {
            // console.log(res);
            for (let j = 0; j < res.data.length; j++) {
              const data = {
                projectCareerId: res.data[j].projectCareerId,
                category: res.data[j].category,
                domain: res.data[j].domain,
                company_name: res.data[j].companyName,
                title: res.data[j].title,
                content: res.data[j].content,
                startDate: res.data[j].start_date,
                endDate: res.data[j].end_date,
                projectCareerTech: []
              };
              this.freelancerDataReceive[i].projectCareer.push(data);
            }
          },
          err => {}
        );
      }

      for (let i = 0; i < this.freelancerDataReceive.length; i++) {
        this.freelancerCardLst.push({
          id: i,
          body: this.freelancerDataReceive[i]
        });
      }
    }
  },
  components: {
    FreelancerCard
  },
  watch: {
    freelancerFilter: async function() {
      console.log("???");
      this.totalUserList = [];
      const filterdata = {
        page: this.searchOption.page,
        size: this.searchOption.size,
        techList: this.freelancerFilter
      };

      console.log(filterdata);
      if (this.pageIdx == 0) {
        this.isDataLoaded = false;
        await userInstance.getFilterUserList(filterdata, res => {
          this.totalUserList = res.data;
          // console.log("???");
          console.log(this.totalUserList);
        });
        await this.settingFreelancer();
        this.isDataLoaded = true;
      }
    }
  },
  computed: {
    ...mapGetters(["freelancerFilter"])
  },
  data() {
    return {
      searchOption: {
        page: this.pageIdx * 10 + this.btnIdx,
        size: 4
      },

      pagePackage: 0,
      pageindex: 0,
      isDataLoaded: false,
      totalUserList: [],
      freelancerDataReceive: [],
      freelancerCardLst: []
      // freelancerCardItem: {
      //   projectCareerId: "1",
      //   category: "개발",
      //   domain: "웹사이트",
      //   company_name: "한국투자공사",
      //   title: "한국투자공사 모바일 가상화 시스템 구축",
      //   content:
      //     "한국투자공사 모바일 가상화 시스템 앱 개발 - 기존 그룹웨어 앱 가상화에서 사용가능하도록 수정",
      //   projectCareerTech: ["Java", "Vue.js", "Oracle"],
      //   startDate: "2020-04-10",
      //   endDate: "2020-10-30"
      // }
      // freelancerDataReceive: {
      //   user_id: "1",
      //   name: "빌게이츠",
      //   resume: {
      //     title: "최고를 꿈꾸는 개발자입니다.",
      //     introduce:
      //       "고객이 요구하는 개발 스킬 및 요건에 맞추어 수많은 프로젝트의 경험을가지고 있습니다. 고객의 소통을 최우선으로 함께 고민하고 최선의마음으로 개발을 진행하고 있습니다. 원하시는 개발 요건을이루어드립니다. 다양한 프로젝트 경험으로 개발 요구 언어를 사용하여고객의 요건에 충족할 수 있습니다. 또한 최근 트렌드에 맞추어 최신 언어로 개발 진행 가능합니다.",
      //     career_period: "3"
      //   },
      //   tech: ["java", "javascript", "MySQL"],
      //   estimate: [
      //     {
      //       profession: 4,
      //       ontime: 5,
      //       active: 3.5,
      //       communication: 4.5,
      //       reEmployment: 3
      //     },
      //     {
      //       profession: 3,
      //       ontime: 4,
      //       active: 3,
      //       communication: 4.5,
      //       reEmployment: 5
      //     },
      //     {
      //       profession: 2,
      //       ontime: 4,
      //       active: 4.5,
      //       communication: 4.5,
      //       reEmployment: 5
      //     },
      //     {
      //       profession: 4,
      //       ontime: 3,
      //       active: 3.5,
      //       communication: 3.5,
      //       reEmployment: 4
      //     },
      //     {
      //       profession: 4.5,
      //       ontime: 4,
      //       active: 4,
      //       communication: 3.5,
      //       reEmployment: 2
      //     }
      //   ],
      //   projectCareer: []
      // }
    };
  }
};
</script>

<style>
.freelancer-contents {
  max-width: 800px;
  max-height: 250px;
  margin: 0 auto;
  margin-top: 30px;
}

.freelancer-contents:hover {
  background-color: #b4b4b4;
}

#freelancer-list {
  padding-bottom: 10px;
}
</style>
