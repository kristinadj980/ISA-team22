<template>
<div id="pharmacyAdminRegistration">
   <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                    <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                     <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSystemAdminRegistration">Admin register</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyRegistration">Pharmacy register</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showDermatologyRegistration">Dermatology register</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSupplierRegistration">Supplier register</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showDrugManipulation">Drug manipulation</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showComplaints">Complaints</button>
            </span>
              <span  style="float:right;margin:15px">
                    <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
                </span>
        </div>
    <div class="vue-tempalte">
       
            <h3>Sign Up</h3>

            <div class="form-group">
                 
                 <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Name</label>
                        <input type="text" class="form-control" v-model="name" placeholder="Enter name">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Surname</label>
                        <input type="text" class="form-control" v-model = "surname" placeholder="Enter surname">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Email</label>
                        <input type="email" class="form-control" v-model="email" placeholder="Enter email">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Phone number</label>
                        <input type="text" class="form-control" v-model="phone" placeholder="Enter phone number">
                        </div>
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Country</label>
                        <input type="text" class="form-control" v-model="country" placeholder="Enter country">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">City</label>
                        <input type="text" class="form-control" v-model="city" placeholder="Enter city">
                        </div>
                    </div>
                     <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Street</label>
                        <input type="text" class="form-control" v-model="street" placeholder="Enter street">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Street Number</label>
                        <input type="number" class="form-control" v-model="streetNumber" placeholder="Enter street number">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Password</label>
                        <input type="password" class="form-control" v-model="password" placeholder="Enter password">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Confirm password</label>
                        <input type="password" class="form-control" v-model="passwordConf" placeholder="Repeat password">
                        </div>
                    </div>
            </div>
            <button style="color:white" type="submit" class="button" v-on:click = "registerUser">Register</button>
    </div>
</div>
</template>

<script>
export default {
    name: 'PharmacyAdminRegistration',
    data(){
        return{
            email:'',
            password:'',
            passwordConf:'',
            name:'',
            surname:'',
            street:'',
            streetNumber:'',
            city:'',
            country:'',
            phone:'',
        }

    },
    methods:{
       
         showHomePage: function(){
           window.location.href = "/homePage";
        },
        showSystemAdminRegistration: function(){
           window.location.href = "/systemAdminRegistration";
        },
        showDermatologyRegistration: function(){
           window.location.href = "/dermatologyRegistration";
        },
        showPharmacyRegistration: function(){
           window.location.href = "/pharmacyRegistration";
        },
          showSupplierRegistration: function(){
           window.location.href = "/supplierRegistration";
        },
         showProfile: function(){
           window.location.href = "/profileData";
        },
         registerUser: function(){
              const addressInfo ={
               street: this.street,
               number: this.streetNumber,
               town: this.city,
               country: this.country
          }
            const userInfo ={
                email : this.email,
                password : this.password,
                confirmPassword : this.passwordConf,
                name : this.name,
                surname : this.surname,
                phoneNumber : this.phone,
                address : addressInfo
            }
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/pharmacyAdmin/register',userInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                        }})
                .then(response => {
                       alert("Pharmacy administrator is successfully registred!");
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
  max-width: 900px;
  margin: 0 auto 20px;
  padding: 20px;
  text-align: center;
  margin: auto;
  
    }

.button {
   background:  #174452;
   box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
   border:  1px solid rgb(25, 40, 90); 
   padding: 10px 20px;
   position: absolute;
   top: 110%;
   right: 40%;
   width: 20%;
   height: 7%;
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