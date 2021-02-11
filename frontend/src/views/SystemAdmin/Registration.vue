<template>
<div id="registration">
    <div class="vue-tempalte">
        <form>
            <h3>Sign Up</h3>

            <div class="form-group">
                <label style="color:white">Email address</label>
                <input type="email" class="form-control form-control-lg" />
                <label style="color:white">Password</label>
                <input type="password" class="form-control form-control-lg" />
                <label style="color:white">Confirm password</label>
                <input type="password" class="form-control form-control-lg" />
                <label style="color:white">Name</label>
                <input type="text" class="form-control form-control-lg"/>
                <label style="color:white">Surname</label>
                <input type="text" class="form-control form-control-lg"/>
                <label style="color:white">Address</label>
                <input type="text" class="form-control form-control-lg" />
                <label style="color:white">City</label>
                <input type="text" class="form-control form-control-lg" />
                <label style="color:white">Country</label>
                <input type="text" class="form-control form-control-lg" />
                <label style="color:white">Phone number</label>
                <input type="text" class="form-control form-control-lg" />
            </div>

            <button style="color:white" type="submit" class="btn">Sign Up</button>

            <p class="forgot-password text-center">
                Already registered 
                <router-link :to="{name: 'login'}">sign in?</router-link>
            </p>
        </form>
    </div>
</div>
</template>

<script>
export default {
    name: 'Registration'
}
</script>

<style scoped>
.vue-tempalte{
  width: 100%;
  height: 100%;
  background:  #17a2b8!important;
  min-height: 100vh;
  display: flex;
  font-weight: 400;
  justify-content: center;
  flex-direction: column;   
    }

.form-group{
  position: relative;
  z-index: 1;
  background:  #174452;
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