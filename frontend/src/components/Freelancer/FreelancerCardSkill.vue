<template>
  <span class="tech-contents badge bg-secondary">
    {{ skillItem }}
  </span>
</template>

<script>
  export default {
    name: 'FreelancerCardSkill',
    props : {
      skillItem : String
    }
  }
</script>