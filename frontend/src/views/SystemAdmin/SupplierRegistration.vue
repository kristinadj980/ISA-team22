<template>
<div id="supplierRregistration">
    <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                    <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showHomePage">Home</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyRegistration">Pharmacy registration</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showDermatologyRegistration">Dermatology registration</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSupplierRegistration">Supplier registration</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showDrugManipulation">Drug manipulation</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showComplaints">Complaints</button>
            </span>
              <span  style="float:right;margin:15px">
                    <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
                </span>
        </div>
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

            <button style="color:white" type="submit" class="button">Sign Up</button>

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
    name: 'SupplierRegistration',
     methods:{
        showHomePage: function(){
           window.location.href = "/homePage";
        },
         showProfile: function(){
           window.location.href = "/profileData";
        },
        showDermatologyRegistration: function(){
           window.location.href = "/dermatologyRegistration";
        },
        showPharmacyRegistration: function(){
           window.location.href = "/pharmacyRegistration";
        },
          showSupplierRegistration: function(){
           window.location.href = "/supplierRegistration";
        }
    }
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
.button {
   width: 20%;
   height: 20%;
   background:  #174452;
   box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
   border:  1px solid rgb(25, 40, 90); 
   padding: 10px 20px;
   
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