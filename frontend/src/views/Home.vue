<template>
  <div class="home">
    <dermatologist-homepage></dermatologist-homepage>
  </div>
</template>

<script>
// @ is an alias to /src
import DermatologistHomepage from '../views/dermatologistView/DermatologistHomepage.vue'

export default {
  name: 'Home',
  components: {
    DermatologistHomepage
  }
}
</script>
