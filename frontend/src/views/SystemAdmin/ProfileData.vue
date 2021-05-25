<template>
    <div id="adminProfile">
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
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" v-on:click = "logOut">Log Out</button>
            </span>
        </div>
          <div class="container bg-white   mt-5 mb-5">
   
            <div class="card"  >
                <div class="profile-img">
                    <img class="img-responsive" src="@/images/nature.jpg" style=" height:150px;" width="100%" />
                    <img class="img-circle img-responsive rounded-circle"  src="@/images/dermatologist.png" style="width:120px; height:120px;"  />
                </div>
                <div class=" d-inline-block " style=" height:100%; background-color: #ced2d3;">
                    <h4 style = "position:left; left:60px; top:2px; background-color:#ebf0fa;"><b>System Admin: {{admin.name}}  {{admin.surname}} </b></h4>
                    <div class="p-3 py-5 ">
                    <div class="col-md-8 ">
                    <div class="card mb-3 " style = "position:right; left:90px; top:2px; background-color:#ebf0fa;">
                    <div class="card-body" style="background-color: #ebf0fa;">
                        <h4 class ="text-justify top-buffer"> Name:   {{admin.name}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Surname:   {{admin.surname}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Email:   {{admin.email}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Password:   {{admin.password}}</h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Address:   {{admin.address.street}}, {{admin.address.number}}  </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> City:   {{admin.address.town}}, {{admin.address.country}} </h4>
                        
                </div>
              </div>
            </div>
                        
                   <!-- <div class="mt-5 text-center top-buffer"><button class="btn btn-info btn-lg space_style" style="background-color:#003d66;"  v-on:click = "editProfile">Edit profile</button></div>-->  
                        <!-- Modal --> 
                        <div class="mt-5 text-center top-buffer">
                            <b-button  class="btn btn-info btn-lg space_style" style="background-color:#003d66;" v-b-modal.modal-2>Edit password</b-button>
                            <b-button  class="btn btn-info btn-lg space_style"  style="background-color:#003d66;" v-b-modal.modal-1>Edit profile info</b-button>
                            <b-modal ref="modal-ref" id="modal-1" title="Edit profile info" hide-footer>
                                <div>
                                    <h5 class ="text-justify top-buffer"> Name:
                                        <b-form-input v-model="admin.name" label="First Name" filled placeholder="Enter your name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Last Name:
                                        <b-form-input v-model="admin.surname" label="Last Name" filled placeholder="Enter your name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Email:
                                        <b-form-input v-model="admin.email" label="Email" disabled></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Street:
                                        <b-form-input v-model="admin.address.street" label="Street" filled placeholder="Enter your street name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Street Number:
                                        <b-form-input type="number" v-model="admin.address.number" label="Street Number" filled placeholder="Enter your street number"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> City:
                                        <b-form-input v-model="admin.address.town" label="City" filled placeholder="Enter the city name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Country:
                                        <b-form-input v-model="admin.address.country" label="Country" filled placeholder="Enter the country name"></b-form-input>
                                    </h5>
                                    <b-row style="float: left; margin: 30px;">
                                        <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" >Cancel</b-button>
                                        <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "update">Update</b-button>
                                    </b-row>
                                </div>
                            </b-modal>
                            <b-modal ref="modal-ref2" id="modal-2" title="Edit profile info" hide-footer>
                                <div>
                                    <h5 class ="text-justify top-buffer">
                                        <div class="mb-4">
                                        <label for="password">Current Password</label>
                                        <VuePassword
                                            v-model="admin.currentPassword"
                                            id="password1"
                                            placeholder="Enter your current password"
                                            :badge="false" 
                                            :toggle="true"
                                        />
                                        </div>
                                    </h5>
                                    <h5 class ="text-justify top-buffer">
                                        <div class="mb-4">
                                        <label for="password">New Password:</label>
                                        <VuePassword
                                            v-model="admin.newPassword"
                                            id="password1"
                                            placeholder="Enter your current password"
                                           
                                        />
                                        </div>
                                    </h5>
                                    <h5 class ="text-justify top-buffer">
                                        <div class="mb-4">
                                        <label for="password">Repeat New Password:</label>
                                        <VuePassword
                                            v-model="admin.repeatNewPassword"
                                            id="password1"
                                            placeholder="Enter your current password"
                                        />
                                        </div>
                                    </h5>
                                    <b-row style="float: left; margin: 30px;">
                                        <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" >Cancel</b-button>
                                        <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "updatePassword">Update</b-button>
                                    </b-row>
                                </div>
                            </b-modal>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>



<script>
import VuePassword from 'vue-password'
export default {
    name: 'ProfileData',
    components: {
    VuePassword,
  },
     data() {
    return {
        admin : "",
        name: "",
        surname: "",
        email: "",
        contact: "",
        address : "",
        password:"",
        currentPassword : "",
        newPassword : "",
        repeatNewPassword : ""
    }
  },
  mounted(){
     let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.axios.get('/systemAdmin/profile',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
               this.admin=response.data;
         }).catch(res => {
                       alert("Error");
                        console.log(res);
                 });
    
   },
    methods:{
        toggle () {
        this.show = !this.show
        },
       validLettersName: function (name) {
        var res = /^[a-zA-Z]+$/;
        return res.test(name);
       },
       validLettersSurname: function (surname) {
        var res = /^[a-zA-Z]+$/;
        return res.test(surname);
       },
       validLettersCountry: function (country) {
        var res = /^[a-zA-Z]+$/;
        return res.test(country);
       },
       validLettersCity: function (city) {
        var res = /^[a-zA-Z]+$/;
        return res.test(city);
       },
       validLettersStreet: function (street) {
        var res = /^[a-zA-Z]+$/;
        return res.test(street);
       },
         showProfile: function(){
           window.location.href = "/profileData";
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
        showPharmacyAdminRegistration: function(){
           window.location.href = "/pharmacyAdminRegistration";
        },
        showDrugManipulation: function(){
           window.location.href = "/addingDrug";
        },
        logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";
        },
        showComplaints: function(){
           window.location.href = "/complaints";
        },
        showLoalty: function(){
           window.location.href = "/loaltyProgram";
        },
        update : function(){
            const addressInfo = {
                town: this.admin.address.town,
                street: this.admin.address.street,
                number:this.admin.address.number,
                country: this.admin.address.country
            };
            const adminInfo = {
                name: this.admin.name,
                surname : this.admin.surname,
                email:this.admin.email,
                address: addressInfo
           };
           alert(this.admin.address.number);
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
             if(!this.validLettersName(this.admin.name)){
                alert("Please enter valid name!")
                return;
            }
            if(!this.validLettersSurname(this.admin.surname)){
                alert("Please enter valid surname!")
                return;
            }
            if(!this.validLettersStreet(this.admin.address.street)){
                alert("Please enter valid street!")
                return;
            }
            if(this.admin.address.number == ""){
                alert("Please enter streetNumber!")
                return;
            }
            if(this.admin.address.numberr < 0){
                alert("Please enter valid streetNumber!")
                return;
            }
            if(!this.validLettersCity(this.admin.address.town)){
                alert("Please enter valid city!")
                return;
            }
             if(!this.validLettersCountry(this.admin.address.country)){
                alert("Please enter valid conutry!")
                return;
            }
       
            this.axios.post('/systemAdmin/update',adminInfo, { 
                headers: {
                    'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    alert("Successfully edited profile.")
                    this.$refs['modal-ref'].hide();
                        console.log(response);
                })
                .catch(response => {
                    alert("Error, please try later.")
                    console.log(response);
                })
            
        },
         updatePassword : function () {
            if(this.admin.newPassword != this.admin.repeatNewPassword) {
            alert("New passwords are not equals!")
            return;
            }
            const changePassword ={
                password : this.admin.currentPassword,
                confirmPassword : this.admin.newPassword
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/systemAdmin/updatePassword',changePassword, { 
                headers: {
                    'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    alert("Successfully edited password.")
                    this.$refs['modal-ref2'].hide();
                        console.log(response);
                })
                .catch(response => {
                    alert("Please, try later.")
                    console.log(response);
                })
        }
    }
}
</script>

<style scoped>
    .card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        max-width: 600px;
        margin: auto;
        text-align: center;
        font-family: arial;
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
    .profile_style{
        position: fixed;
        top: 1;
        left: 30%;
        right:30%;
        width: 100%;
    }
    .space_style{
        margin-right:1px
    }
    .profile-img {
        width: 100%;
        position: relative;
    }

    .img-responsive {
        max-width:100%;
        height:auto;
    }

    .img-circle {
        position:absolute;
        z-index:99;
        left:10px;
        bottom:-50%;
    }

</style>