<template>
<div id="pharmacyRregistration">
    <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                    <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSystemAdminRegistration">Add system admin</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyAdminRegistration">Add pharmacy admin</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyRegistration">Add pharmacy</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showDermatologyRegistration">Add dermatology</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSupplierRegistration">Add supplier</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showDrugManipulation">Drugs</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showLoalty">Loalty</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showComplaints">Complaints</button>
            </span>
              <span  style="float:right;margin:15px">
                    <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
                </span>
        </div>
    <div class="vue-tempalte">
            <h3>Pharmacy registration</h3>
            <div class="form-group">
                <label style="color:white">Pharmacy name</label>
                <input type="text" class="form-control" v-model="name" placeholder="Enter name">
                <label style="color:white">Country</label>
                <input type="text" class="form-control" v-model="country" placeholder="Enter country">
                <label style="color:white">City</label>
                <input type="text" class="form-control" v-model="city" placeholder="Enter city">
                <label style="color:white">Street</label>
                <input type="text" class="form-control" v-model="street" placeholder="Enter street">
                <label style="color:white">Street number</label>
                <input type="number" class="form-control" v-model="streetNumber" placeholder="Enter street number">
                <label style="color:white">Description</label>
                <input type="text" class="form-control form-control-lg" v-model="description" placeholder="Enter description"/>
            </div>

            <button style="color:white" type="submit" class="button" v-on:click = "registerPharmacy">Register</button>
    </div>
</div>
</template>

<script>
export default {
    name: 'PharmacyRegistration',
    data(){
        return{
            city:'',
            street:'',
            streetNumber:'',
            country:'',
            name:'',
            description:'',
        }

    },
     methods:{
        validLettersName: function (name) {
        var res = /^[a-zA-Z]+(\s[a-zA-Z]+)?$/;
        return res.test(name);
       },
       validLettersDescription: function (description) {
        var res = /^[a-zA-Z]+$/;
        return res.test(description);
       },
       validLettersCountry: function (country) {
        var res = /^[a-zA-Z]+$/;
        return res.test(country);
       },
       validLettersCity: function (city) {
        var res = /^[a-zA-Z]+(\s[a-zA-Z]+)?$/;
        return res.test(city);
       },
       validLettersStreet: function (street) {
        var res = /^[a-zA-Z]+(\s[a-zA-Z]+)?$/;
        return res.test(street);
       },
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
         showLoalty: function(){
           window.location.href = "/loaltyProgram";
        },
          showSupplierRegistration: function(){
           window.location.href = "/supplierRegistration";
        },
         showSystemAdminRegistration: function(){
           window.location.href = "/systemAdminRegistration";
        },
         showPharmacyAdminRegistration: function(){
           window.location.href = "/pharmacyAdminRegistration";
        },
        showDrugManipulation: function(){
           window.location.href = "/addingDrug";
        },
        showComplaints: function(){
           window.location.href = "/complaints";
        },
        logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";
        },
        registerPharmacy : function(){
          const addressInfo ={
              town: this.city,
              street: this.street,
              number: this.streetNumber,
              country: this.country
            }
            const pharmacyInfo ={
              name : this.name,
              addressDTO : addressInfo,
              description: this.description
            }
            
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
             if(!this.validLettersName(this.name)){
                alert("Please enter valid name!")
                return;
            }
             if(!this.validLettersCountry(this.country)){
                alert("Please enter valid conutry!")
                return;
            }
             if(!this.validLettersCity(this.city)){
                alert("Please enter valid city!")
                return;
            }
            if(!this.validLettersStreet(this.street)){
                alert("Please enter valid street!")
                return;
            }
            if(this.streetNumber ==""){
                alert("Please enter streetNumber!")
                return;
            }
            if(this.streetNumber < 0){
                alert("Please enter valid streetNumber!")
                return;
            }
             if(!this.validLettersDescription(this.description)){
                alert("Please enter valid description!")
                return;
            }
            
            this.axios.post('/pharmacy/registerPharmacy',pharmacyInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                        }
                        })
                .then(response => {
                       alert("Pharmacy is successfully registred!");
                        console.log(response.data);
                })
                .catch(res => {
                    alert("Greska " + res.response.data.message);
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
   background:  #174452;
   box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
   border:  1px solid rgb(25, 40, 90); 
   padding: 10px 20px;
   position: absolute;
   top: 95%;
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