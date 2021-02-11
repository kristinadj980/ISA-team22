<template>
  <div class="home">
    <profile/>
  </div>
</template>

<script>
// @ is an alias to /src
import Profile from '../views/SystemAdmin/Profile.vue'


export default {
  name: 'Home',
  components: {
    Profile
  }
}
</script>
