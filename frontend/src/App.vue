<template>
  <div id="app">
     
    <profile/>
    <login/>
    <registration/>
  </div>
</template>

<script>
//import DermatologistHomepage from './view/dermatologistView/DermatologistHomepage'
import Login from './views/SystemAdmin/Login.vue'
import Profile from './views/SystemAdmin/Profile.vue'
import Registration from './views/SystemAdmin/Registration.vue'
export default {
  name: 'App',
  components: {
    //DermatologistHomepage,
    Profile,
    Login,
    Registration,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
