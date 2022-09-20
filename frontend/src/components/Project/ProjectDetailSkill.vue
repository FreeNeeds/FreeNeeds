<template>
  <div class="skillSelectBtn d-inline-block" :id="skillItem"> 
    <div class="skillSelectLetter mx-3">
      {{ skillItem }}
    </div>
  </div> 
</template>

<script>
  export default {
    name : 'ProjectDetailSkill',
    props : {
      skillItem : String
    }
  }
</script>