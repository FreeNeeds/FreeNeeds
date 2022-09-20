<template>
  <li @click="clickRegionDetail" :id="region" class="regionLi">
    <div class="regionItemDetail"> {{ region }} </div>
  </li> 
</template>

<script>
  export default {
    name: 'RegionDetailBtn',
    props: {
      region : String
    },
    methods: {
      clickRegionDetail() {
        this.$emit('clickRegionDetail',this.region)
      }
    }
  }
</script>