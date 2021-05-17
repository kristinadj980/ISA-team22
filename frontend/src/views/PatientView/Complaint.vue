<template>
    <div id="complaint">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyPage">Pharmacy home page</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSubsribedPharmacies">Subscribed pharmacies</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "writeComplaint">Write complaint</button>
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" >Log Out</button>
            </span>
        </div>    
        <!-- *******************************************************-->
        <div class="row">
            <div class="form-group col">
                <h5 style="color: #0D184F">Write complaint for : </h5>
            </div >
             <template>
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'dermatology')">
                   <label class="custom-control-label" for="defaultGroupExample1">dermatology</label>
                
              </div> 
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'pharmacist')">
                   <label class="custom-control-label" for="defaultGroupExample2">pharmacist</label>
                
              </div> 
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample3" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'pharmacy')">
                 <label class="custom-control-label" for="defaultGroupExample3">pharmacy</label>
                
              </div> 
              
             </template>
        </div>   
         <!-- DERMAATOLOGY -->
                <div v-if = "showDermatologistComplaint">
                    <div class="row">
                        <div class="col d-flex justify-content-center">
                            <b-dropdown id="ddCommodity" name="ddCommodity" text="Choose dermatologists" class = "btn btn-link btn-lg" style="float:left;margin-left:20px;">
                                <b-dropdown-item v-for="derm in this.dermatologists"  v-on:click ="dermatologistIsSelected($event, derm)" v-bind:key="derm.email"> {{derm.fullName }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col">
                             <label for="name">Write complaint:</label>
                        </div> 
                    </div>
                    <div class="row d-flex justify-content-center">
                        <input type="textarea" style="height:300px; width: 90%;background-color:white;" v-model="complaintText" class="form-control">
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                         <button class="btn btn-primary" @click="sendComplaintToDermatologist">Send complaint</button>
                    </div>
                </div>
                 <!-- PHARMACIST -->
                <div v-if = "showPharmacistComplaint">
                    <div class="row">
                        <div class="col d-flex justify-content-center">
                            <b-dropdown id="ddCommodity" name="ddCommodity" text="Choose pharmacist" class = "btn btn-link btn-lg" style="float:left;margin-left:20px;">
                                <b-dropdown-item v-for="pharm in this.pharmacists"  v-on:click ="pharmacistIsSelected($event, pharm)" v-bind:key="pharm.email"> {{pharm.fullName }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col">
                             <label for="name">Write complaint:</label>
                        </div> 
                    </div>
                    <div class="row d-flex justify-content-center">
                        <input type="textarea" style="height:300px; width: 90%;background-color:white;" v-model="complaintText" class="form-control">
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                         <button class="btn btn-primary" @click="sendComplaintToPharmacist">Send complaint</button>
                    </div>
                </div>
                <!-- PHARMACY -->
                <div v-if = "showPharmacyComplaint">
                    <div class="row">
                        <div class="col d-flex justify-content-center">
                            <b-dropdown id="ddCommodity" name="ddCommodity" text="Choose pharmacy" class = "btn btn-link btn-lg" style="float:left;margin-left:20px;">
                                <b-dropdown-item v-for="pharmacy in this.pharmacies"  v-on:click ="pharmacyIsSelected($event, pharmacy)" v-bind:key="pharmacy.id"> {{pharmacy.name }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col">
                             <label for="name">Write complaint:</label>
                        </div> 
                    </div>
                    <div class="row d-flex justify-content-center">
                        <input type="textarea" style="height:300px; width: 90%;background-color:white;" v-model="complaintText" class="form-control">
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                         <button class="btn btn-primary"  @click="sendComplaintToPharmacy" >Send complaint</button>
                    </div>
                </div>
            
        
    </div>
    
</template>


<script>

export default {
    name: 'Complaint',
     data() {
    return {
        showComplaintForm : false,
       pharmacies : [],
       pharmacy : null,
       pharmacists : [],
       pharmacist : null,
       dermatologists : [],
       dermatologist : null,
       showPharmacyComplaint : false,
       showPharmacistComplaint : false,
       showDermatologistComplaint : false,
       complaintText : "",

       
    }
  },
    methods:{
        
         showSubsribedPharmacies: function(){
          this.getMyPromotions();
        },
        showPharmacyPage: function(){
           window.location.href = '/';
        },
          writeComplaint: function(){
           window.location.href = '/complaint';
        },
        updateFiler : function(event, filter) {
        let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        if(filter==="dermatology") {
            this.showPharmacyComplaint = false;
          this.showPharmacistComplaint = false;
          this.showDermatologistComplaint = true;
           this.axios.get('/dermatologist/dermaInfo',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
            }).then(response => { 
                this.dermatologists=response.data;
            }).catch(res => {
                        alert("Please try again later.");
                        console.log(res);});
        }
        
        else if(filter==="pharmacist")  {
            this.showPharmacyComplaint = false;
          this.showPharmacistComplaint = true;
          this.showDermatologistComplaint = false;
           this.axios.get('/pharmacist/pharmacistInfo',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
            }).then(response => { 
                this.pharmacists=response.data;
            }).catch(res => {
                        alert("Please try again later.");
                        console.log(res);});
        }else{
            this.showPharmacyComplaint = true;
          this.showPharmacistComplaint = false;
          this.showDermatologistComplaint = false;
           this.axios.get('/pharmacy/pharmacies',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
            }).then(response => { 
                this.pharmacies=response.data;
            }).catch(res => {
                        alert("Please try again later.");
                        console.log(res);});
        }
      },
      dermatologistIsSelected : function(event, derm) {
          this.complaintText ="";
          this.dermatologist = derm;
      },
      pharmacistIsSelected: function(event, pharm) {
          this.complaintText ="";
          this.pharmacists = pharm;
      },
      pharmacyIsSelected: function(event, pharmacy) {
          this.complaintText ="";
          this.pharmacy = pharmacy;
      },
       sendComplaintToDermatologist : function() {
     
          const complaintInfo= {
            isAnswered : false,
            description : this.complaintText,
            answer : "",
            dermatologyId: this.dermatologist.userId,
            
          }
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

          this.axios.post('/complaint/addComplaintDermatologist',complaintInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    alert("Complaint is successfully sent!");

                    console.log(response);                
                }).catch(res => {
                    alert(res.response.data.message);

                });
      },
      sendComplaintToPharmacist : function() {
     
          const complaintInfo= {
            isAnswered : false,
            description : this.complaintText,
            answer : "",
            pharmacistId: this.pharmacists.userId,
            
          }
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

          this.axios.post('/complaint/addComplaintPharmacist',complaintInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    alert("Complaint is successfully sent!");

                    console.log(response);                
                }).catch(res => {
                    alert(res.response.data.message);

                });
      },
       sendComplaintToPharmacy : function() {
     
          const complaintInfo= {
            isAnswered : false,
            description : this.complaintText,
            answer : "",
            pharmacyId : this.pharmacy.id,
            
            
          }
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

          this.axios.post('/complaint/addComplaintPharmacy',complaintInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    alert("Complaint is successfully sent!");

                    console.log(response);                
                }).catch(res => {
                    alert(res.response.data.message);

                });
      },
      },
       
    
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