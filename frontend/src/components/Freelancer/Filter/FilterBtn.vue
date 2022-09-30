<template>
  <div>
    <button id="filterBtn" data-bs-toggle="modal" data-bs-target="#FilterModal">
    필터
    </button>
    <FilterModal></FilterModal>
  </div> 
</template>

<script>
  import FilterModal from '@/components/Freelancer/Filter/FilterModal.vue';
  
  export default {
    name: 'FilterBtn',
    components : {
      FilterModal
    }
  }
</script>

<style>
  #filterBtn {
    border-radius: 15px; 
    width: 100px;
    height: 30px;
    border: 2px solid rgb(209, 207, 207); 
    text-align: center; 
    font-size: 17px;
    font-weight: bold; 
    background-color: white;
    margin-left: 64%;
    margin-top: 10px;
    margin-bottom: 8px;
  }
</style>