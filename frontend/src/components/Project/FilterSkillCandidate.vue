<template>
    <div @click="selectSkill" class="skillCandidateLetter" :id="skillCandidate"> 
      {{ skillCandidate }}
    </div> 
</template>

<script>
  export default {
    name : "FilterSkillCandidate",
    props : {
      skillCandidate : String
    },
    methods : {
      selectSkill() {
        this.$emit("insertSkill",this.skillCandidate)
      }
    }
  }
</script>
<style>
.skillCandidateLetter:hover{
  cursor: pointer;
}
</style>