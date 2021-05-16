<template>
    <div id="complaints">
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
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" >Log Out</button>
            </span>
        </div>
         <!-- table -->
         <div style = "background-color:oldlace; margin: auto; width: 60%;border: 2px solid #17a2b8;padding: 10px;margin-top:45px;">
               <div class="row">
                    <div class=" form-group col">
                        <label >Complaint from</label>
                    </div>
                    <div class=" form-group col">
                        <label >Complaint to</label>
                    </div>
                    <div class=" form-group col">
                        <label >Description</label>
                    </div>
                    <div class=" form-group col">
                        <label ></label>
                    </div>
                   
               </div>
               <div v-for="complaint in complaints"   v-bind:key="complaint.id">
                    <div class="row">
                            <div class=" form-group col">
                                <label >{{complaint.nameFrom}}</label>
                            </div>
                             <div class=" form-group col">
                                <label >{{complaint.nameTo}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{complaint.description}}</label>
                            </div>
                            <div class=" form-group col">
                                <button  style="background-color:#17a2b8" class="btn btn-primary" v-on:click = "answerOnComplaint($event,complaint)">Answer</button>
                            </div>
                    </div>
               </div>
         </div>

       
    </div>
</template>


<script>

export default {
    name: 'Complaints',
     data() {
    return {
       complaints : [],
       selectedComplaintID:'',
       
    }
  },
   mounted() {
       this.getComplaints()
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
        showDrugManipulation: function(){
           window.location.href = "/addingDrug";
        },
        showComplaints: function(){
           window.location.href = "/complaints";
        },
        getComplaints : function() {
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
          this.complaints = []
          this.axios.get('/complaint/complaints',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
             this.isAuthorized = true;
             this.complaints=response.data;
         }).catch(res => {
                //this.isAuthorized = false;
                //alert("Please, log in first!");
                //window.location.href = "/login";
                console.log(res);
            });
      },
        answerOnComplaint : function(event, complaint) {
          this.selectedComplaintID = complaint.complaintId;
          const complaintInfo ={
                complaintId : complaint.complaintId,
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/promotion/subscribe',complaintInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    alert("You have successfully subscribed!");
                    console.log(response); 
                }).catch(res => {
                       alert("Please try later.");
                        console.log(res);
                });
          
          
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