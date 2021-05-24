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
          <div class="vue-tempalte">
       
            <h3>Define loalty program</h3>

            <div class="form-group">
                 
                 <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Points for consulting</label>
                        <input type="number" class="form-control" v-model="consultingPoints" placeholder="Enter points">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Points for examination</label>
                        <input type="number" class="form-control" v-model = "examinationPoints" placeholder="Enter points">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Regular users discount</label>
                        <input type="email" class="form-control" v-model="regularDiscount" placeholder="Enter discount">
                        </div>
                        
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Silver users discount</label>
                        <input type="text" class="form-control" v-model="silverDiscount" placeholder="Enter discount">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Minimun points for silver</label>
                        <input type="number" class="form-control" v-model="minimumSilverPoints" placeholder="Enter points">
                        </div>
                    </div>
                     <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color:white">Gold users discount</label>
                        <input type="text" class="form-control" v-model="goldDiscount" placeholder="Enter discount">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color:white">Minimun points for gold</label>
                        <input type="number" class="form-control" v-model="minimumGoldPoints" placeholder="Enter points">
                        </div>
                    </div>
                   <button v-on:click = "update" class="btn btn-primary">Confirm</button>
            </div>
    </div>
    </div>
    
</template>



<script>
export default {
    name: 'LoaltyProgram',
     data() {
    return {
            consultingPoints: 0,
            examinationPoints: 0,
            minimumSilverPoints: 0,
            minimumGoldPoints: 0,
            regularDiscount: "0%",
            silverDiscount: "0%",
            goldDiscount: "0%",
       
    }
  },

    methods:{
        validDiscount: function (regularDiscount) {
        var res = /^\d{1,2}%$/;
        return res.test(regularDiscount);
       },
       validDiscountSilver: function (silverDiscount) {
        var res = /^\d{1,2}%$/;
        return res.test(silverDiscount);
       },
       validDiscountGold: function (goldDiscount) {
        var res = /^\d{1,2}%$/;
        return res.test(goldDiscount);
       },
         showProfile: function(){
           window.location.href = "/profileData";
        },
         showLoalty: function(){
           window.location.href = "/loaltyProgram";
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
        update : function() {
            const loyaltyProgram ={
               examinationPoints: this.examinationPoints,
               consultingPoints: this.consultingPoints,
               regularDiscount: this.regularDiscount,
               silverDiscount: this.silverDiscount,
               goldDiscount:this.goldDiscount,
               minimumSilverPoints:this.minimumSilverPoints,
               minimumGoldPoints:this.minimumGoldPoints,
          }
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            if(this.examinationPoints <= 0){
                alert("Please enter positive number for points!")
                return;
            }
            if(this.consultingPoints <= 0){
                alert("Please enter positive number for points!")
                return;
            }
            if(!this.validDiscount(this.regularDiscount)){
                alert("Please enter valid discount (example 15%)!")
                return;
            }
            if(!this.validDiscountSilver(this.silverDiscount)){
                alert("Please enter valid discount (example 15%)!")
                return;
            }
            if(!this.validDiscountGold(this.goldDiscount)){
                alert("Please enter valid discount (example 15%)!")
                return;
            }
            if(this.minimumSilverPoints <= 0){
                alert("Please enter positive number for points!")
                return;
            }
            if(this.minimumGoldPoints <= 0){
                alert("Please enter positive number for points!")
                return;
            }
            
           this.axios.post('/loyaltyProgram/defineLoaltyProgram',loyaltyProgram,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                        }})
                .then(response => {
                       alert("Loyalty program is successfully defined!");
                        console.log(response.data);
                })
                .catch(res => {
                    alert(res.response.data.message);
                 });    
      },
      
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