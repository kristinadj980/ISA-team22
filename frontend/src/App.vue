<template>
  <div id="app">
    <dermatologist-homepage />
  </div>
</template>

<script>
import DermatologistHomepage from './view/dermatologistView/DermatologistHomepage'
export default {
  name: 'App',
  components: {
    DermatologistHomepage
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
  margin-top: 60px;
}
</style>
