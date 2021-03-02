<template>
<div id="registration">
    <div class="vue-tempalte">
        <form>
            <h3>Sign Up</h3>

            <div class="form-group">
                <label style="color:white">Email address {{email}}</label>
                <input type="email" class="form-control form-control-lg" v-model="registerUserData.email" required/>
                <label style="color:white">Password</label>
                <input type="password" class="form-control form-control-lg" required v-model="registerUserData.password"/>
                <label style="color:white">Confirm password</label>
                <input type="password" class="form-control form-control-lg" required v-model="registerUserData.passwordConf"/>
                <label style="color:white">Name {{name}}</label>
                <input type="text" class="form-control form-control-lg" required v-model="registerUserData.name"/>
                <label style="color:white">Surname</label>
                <input type="text" class="form-control form-control-lg" required v-model="registerUserData.surname"/>
                <label style="color:white">Address</label>
                <input type="text" class="form-control form-control-lg" required v-model="registerUserData.address"/>
                <label style="color:white">City</label>
                <input type="text" class="form-control form-control-lg" required v-model="registerUserData.city"/>
                <label style="color:white">Country</label>
                <input type="text" class="form-control form-control-lg" required v-model="registerUserData.country"/>
                <label style="color:white">Phone number</label>
                <input type="text" class="form-control form-control-lg"  required v-model="registerUserData.phone"/>
            </div>
            <button style="color:white" type="submit" class="button" v-on:click = "registerUser">Sign Up</button>

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
    name: 'Registration',
    data(){
        return{
            registerUserData:{
            email:'',
            password:'',
            passwordConf:'',
            name:'',
            surname:'',
            address:'',
            city:'',
            country:'',
            phone:'',
            }
        }

    },
    methods:{
          registerUser: function(){
                this.axios.post('/systemAdmin/register', this.registerUserData)
                .then(response => {
                       alert("Dermatologist is successfully registred!");
                        console.log(response.data);
                })
                .catch(response => {
                    alert(response.response.data.message);
                 });    
        }
    }

}
</script>

<style scoped>
.vue-tempalte{
  width: 100%;
  height: 100%;
  background:  #f6f9fa!important;
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
.button {
   width: 20%;
   height: 10%;
   background:  #174452;
   box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
   border:  1px solid rgb(25, 40, 90); 
   padding: 10px 20px;
   position: relative
}

.homepage_style{
        background: #17a2b8; 
        position: fixed;
        top: 0;
        left: 0;
        z-index: 999;
        width: 100%;
        height: 70px;
    }

    .space_style{
        margin-right:5px
    }
</style>