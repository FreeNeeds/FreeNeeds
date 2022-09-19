<template>
  <div>
    <div class="container my-3" id="searchBarCtnr">
      <input type="text" id="searchBar">
      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-search mb-1 mx-2" viewBox="0 0 16 16">
        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
      </svg>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchBar',
}
</script>

<style>
  #searchBarCtnr {
    border-radius: 30px; 
    width: 700px !important;
    height: 40px !important; 
    border: 1px solid rgb(209, 207, 207); 
    text-align: center; 
    font-size: 18px; 
    background-color: white;
    position: absolute;
    top : 297px;
    left : 27%;
  }
  #searchBar {
    border:none;
    width: 620px;
    margin-top : 4px;
    margin-left : 15px;
  }
  #searchBar:focus {outline:none;}
</style>
