<template>
  <li @click="clickRegion" :id="region" class="regionLi">
    <div class="regionItem"> {{ region }} </div>
  </li> 
</template>

<script>
  export default {
    name: 'RegionBtn',
    props: {
      region : String
    },
    methods: {
      clickRegion() {
        this.$emit('clickRegion',this.region)
      }
    }
  }
</script>