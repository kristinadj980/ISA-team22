<template>
    <div id="patientProfile">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyPage">Pharmacy home page</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSubsribedPharmacies">Subscribed pharmacies</button>
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" >Log Out</button>
            </span>
        </div>       
        
        <div style = "background-color:oldlace; margin: auto; width: 60%;border: 2px solid #17a2b8;padding: 10px;margin-top:45px;">
               <div class="row">
                    <div class=" form-group col">
                        <label >Pharmacy</label>
                    </div>
                    <div class=" form-group col">
                        <label ></label>
                    </div>
                   
               </div>
               <div v-for="pharmacy in pharmacies"   v-bind:key="pharmacy.id">
                    <div class="row">
                            <div class=" form-group col">
                                <label >{{pharmacy.pharmacyName}}</label>
                            </div>
                           
                            <div class=" form-group col">
                                <button  style="background-color:#17a2b8" class="btn btn-primary" v-on:click = "canclePromotion($event,pharmacy)" >Cancel promotion</button>
                            </div>
                    </div>
               </div>
     </div>
    </div>
    
</template>


<script>

export default {
    name: 'Profile',
     data() {
    return {

        patient : "",
        pharmacies:[],
    }
  },
  mounted() {
       this.getMyPromotions()
    },
    methods:{
        
         showSubsribedPharmacies: function(){
          this.getMyPromotions();
        },
        showPharmacyPage: function(){
           window.location.href = '/';
        },
        getMyPromotions: function(){
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
          this.pharmacies = []
          this.axios.get('/promotion/subscriptions',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
             
             this.pharmacies=response.data;
         }).catch(res => {
                console.log(res);
            });
        },
         canclePromotion : function(event, pharmacy) {
            const pharmacyInfo ={
                pharmacyId : pharmacy.pharmacyId,
                pharmacyName: pharmacy.pharmacyName,
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/promotion/canclePromotion',pharmacyInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    console.log(response);
                    this.pharmacies = response.data;
                    this.getMyPromotions()
                   alert("Promotion is successfully cancled!"); 
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