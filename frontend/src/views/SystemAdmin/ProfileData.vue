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
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>



<script>
export default {
    name: 'ProfileData',
     data() {
    return {
        admin : "",
        name: "",
        surname: "",
        email: "",
        contact: "",
        address : "",
        password:"",
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