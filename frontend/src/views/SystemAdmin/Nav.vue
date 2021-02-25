<template>
<nav class="navbar navbar-default" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="/">
      <strong class="is-size-4">Pharmacy name</strong>
    </a>
  </div>
  <div id="navbar" class="navbar-menu">
    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-dark"  href="/login">
            <strong>LogIn</strong>
          </a>
          <a class="button is-dark"  href="/dermatologyRegistration">
            <strong>Register</strong>
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>
</template>
<script>
export default {
    name: 'Nav'
}
</script>
<style scoped>
 nav {
    margin-top: 5px;
    margin-bottom: 5px;
    
  } 
  .navbar a {
  float: left;
  padding: 10px;
  color: rgb(29, 4, 167);
  text-decoration: none;
  font-size: 17px;
}
.navbar a:hover {
  background-color: rgb(164, 198, 221);
}
  
</style>