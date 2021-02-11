<template>
  <div class="home">
    <profile/>
  </div>
</template>

<script>
// @ is an alias to /src



export default {
  name: 'Home',
  methods:{
        showRegistration: function(){
           window.location.href = "/registration";
        },
        showProfile: function(){
           window.location.href = "/dermatologistProfile";
        }
    }
}
</script>
