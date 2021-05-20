<template>
  <div class="home">
    <section class="hero is-dark">
    <div class="hero-body">
      <div class="container">
        <h1 class="title">
          Welcome to the Pharmacy          
        </h1>
        <h2 class="subtitle">
          Make sure you check out our upcoming events below
        </h2>
        
      </div>
    </div>
  </section>
    
  </div>
</template>

<script>
// @ is an alias to /src
//import DermatologistHomepage from '../views/dermatologistView/DermatologistHomepage.vue'


export default {
  name: 'Home',
  components: {
    //DermatologistHomepage
  }
}
</script>
<style  scoped>
.hero {    
    text-align: center;
    background-image: url("../images/pharmacy.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    height: 400px;
  }
  .hero-body .title {
    text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.6);
    padding: 420px 0 20px 0;
    font-size: 60px;
  }
  .subtitle {
    font-size: 30px;
  }
    .welcome {
      width: 400px;
      padding: 10px;
      margin-left: auto;
      margin-right: auto;
    }
  
  .is-xl {
    font-size: 1.7rem;
  }
</style>
