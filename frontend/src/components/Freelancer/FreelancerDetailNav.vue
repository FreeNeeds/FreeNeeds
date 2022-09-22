<template>
  <div @click="activeProjectDetailNav" :id="FreelancerDetailNavItem">
    {{ FreelancerDetailNavItem }}
  </div> 
</template>

<script>
  export default {
    name: "FreelancerDetailNav",
    props: {
      FreelancerDetailNavItem : String
    },
    mounted() {
      if (this.FreelancerDetailNavItem == "프로젝트") {
        const isActive = document.querySelector('#' + this.FreelancerDetailNavItem)
        isActive.classList.add("activeProjectDetailNav")
      } 
    },
    methods: {
      activeProjectDetailNav() {
        const isActive = document.querySelector('#' + this.FreelancerDetailNavItem)
        if (!isActive.classList.contains("activeProjectDetailNav")){
          this.$emit("deactive",this.FreelancerDetailNavItem)
          isActive.classList.add("activeProjectDetailNav")
        }
      }
    }
  }
</script>