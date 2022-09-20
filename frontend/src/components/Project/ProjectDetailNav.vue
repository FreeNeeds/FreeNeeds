<template>
  <div @click="activeProjectDetailNav" :id="projectDetailNavItem">
    {{ projectDetailNavItem }}
  </div> 
</template>

<script>
  export default {
    name: "ProjectDetailNav",
    props: {
      projectDetailNavItem : String
    },
    mounted() {
      if (this.projectDetailNavItem == "프로젝트") {
        const isActive = document.querySelector('#' + this.projectDetailNavItem)
        isActive.classList.add("activeProjectDetailNav")
      } 
    },
    methods: {
      activeProjectDetailNav() {
        const isActive = document.querySelector('#' + this.projectDetailNavItem)
        if (!isActive.classList.contains("activeProjectDetailNav")){
          this.$emit("deactive",this.projectDetailNavItem)
          isActive.classList.add("activeProjectDetailNav")
        }
      }
    }
  }
</script>