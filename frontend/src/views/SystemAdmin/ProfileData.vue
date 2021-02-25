<template>
    <div id="adminProfile">
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
        <div class="container rounded bg-white mt-5 mb-5">
   
    <div >
        <div class="col-md-5 profile_style">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right"> <b>Profile</b></h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control"> {{admin.name}}</div>
                    <div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control">{{admin.surname}}</div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">PhoneNumber</label><input type="text" class="form-control" >{{admin.contact}}</div>
                    <div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control">{{admin.address}}</div>
                    <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control">{{admin.email}}</div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-6"><label class="labels">Country</label><input type="text" class="form-control">{{admin.address}}</div>
                    <div class="col-md-6"><label class="labels">State/Region</label><input type="text" class="form-control">{{admin.address}}</div>
                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save Changes</button></div>
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