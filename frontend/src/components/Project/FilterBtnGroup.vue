<template>
  <button @click="activeFilter" class="FilterBtn" :id="filterName">
    <div class="FilterKeywordLetter"> {{ filterItem }} </div>
  </button> 
</template>

<script>
  export default {
    name: "FilterBtnGroup",
    props: {
      filterItem : String
    },
    data() {
      return {
        filterName : ""
      }
    },
    created() {
      this.filterName = this.filterItem.split('/')[0]
      this.filterName = this.filterName.split('(')[0]
    },
    methods: {
      activeFilter() {
        const isActive = document.querySelector('#' + this.filterName)
        if (isActive.classList.contains("activeFilter")){
          isActive.classList.remove("activeFilter")
          if (this.filterItem != "개발" && this.filterItem != "디자인" && this.filterItem != "기획"){
            this.$emit("removeFilterForm",this.filterItem)
          } else {
            this.$emit("removeFilterCategory",this.filterItem)
          }
        } else {
          isActive.classList.add("activeFilter")
          if (this.filterItem != "개발" && this.filterItem != "디자인" && this.filterItem != "기획"){
            this.$emit("addFilterForm",this.filterItem)
          } else {
            this.$emit("addFilterCategory",this.filterItem)
          }
        }
      }
    }
  }
</script>