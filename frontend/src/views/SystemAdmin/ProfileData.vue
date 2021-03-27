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
                    <div class="p-3 py-5 align-items-center">
                <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right" style="color: #ced2d3; height: 18px"> <b>{{admin.name}} {{admin.surname}}</b></h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control"> {{admin.name}}</div>
                            <div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control">{{admin.surname}}</div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" >{{admin.email}}</div>
                            <div class="col-md-12"><label class="labels">PhoneNumber</label><input type="text" class="form-control">{{admin.contact}}</div>
                            <div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control">{{admin.address}}</div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6"><label class="labels">City</label><input type="text" class="form-control">{{admin.address}}</div>
                            <div class="col-md-6"><label class="labels">Country</label><input type="text" class="form-control">{{admin.address}}</div>
                        </div>
                        <div class="mt-5 text-center"><button class="btn btn-info btn-lg space_style" type="button">Save Changes</button></div>
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
        address : {
            streetName: "",
            streetNumber: "",
            city: {
                name: "",
                country : {
                    name: "",
                }
            },
        } 
    }
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