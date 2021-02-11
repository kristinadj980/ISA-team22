<template>
<div id="login">
       
     <div class="vue-tempalte">
        <form>
            <h3>Sign In</h3>

            <div class="form-group">
                <label style="color:white">Email address</label>
                <input type="email" class="form-control form-control-lg" />
                <label style="color:white">Password</label>
                <input type="password" class="form-control form-control-lg" />
            </div>

            <button style="color:white" type="submit" class="btn">Sign In</button>

            <p class="forgot-password text-center mt-2 mb-4">
                <router-link to="/forgot-password">Forgot password ?</router-link>
            </p>

        </form>
    </div>
</div>   
</template>

<script>
export default {
    name: 'Login'
}
</script>

<style scoped>
.vue-tempalte{
  width: 100%;
  height: 100%;
  background: #17a2b8 !important;
  margin-top: 7%;
  min-height: 100vh;
  display: flex;
  font-weight: 400;
  justify-content: center;
  flex-direction: column;   
    }

.form-group{
  position: relative;
  z-index: 1;
  background: #174452;
  max-width: 400px;
  margin: 0 auto 100px;
  padding: 65px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  
    }
.btn {
   width: 20%;
   height: 20%;
   background:  #174452;
   box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
   
}

</style>
