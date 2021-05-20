<template>
  <div id="addingDrug">
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
         <!-- DRUG REGISTRATION -->
        <div class="vue-tempalte">
            <h3>Drug</h3>
            <div class="form-group">
                <div class="form-row">
                    <div class="form-group col-md-6">
                     <label style="color:white">Name
                     <input type="text" class="form-control" v-model="name" placeholder="Enter name">
                     </label>
                    </div>
                
                        <div class="form-group col-md-6">
                <label style="color:white">Code
                <input type="text" class="form-control" v-model="code" placeholder="Enter drug code">
                </label>
                        </div>
                        <div class="form-row">
                        <div class="form-group col-md-6">
                    <label style="color:white" >Define contra indications:
                              <input type="text" class="form-control" v-model="specification.contraIndications" placeholder="Enter contra indications">
                              </label>
                        </div>
                        <div class="form-group col-md-6">
                              <label style="color:white">Define composition:
                              <input type="text" class="form-control" v-model="specification.composition" placeholder="Enter composition">
                              </label>
                        </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                    <label style="color:white">Define recommended consumption on day:
                              <input type="number" class="form-control" v-model="specification.therapyDuration" placeholder="Enter recommended consumption">
                              </label>
                        </div>
                        <div class="form-group col-md-6">
                              <label style="color:white">Manufacturer:
                              <input type="text" class="form-control" v-model="specification.manufacturer" placeholder="Enter manufacturer">
                              </label>
                        </div>
                 <!-- DRUG TYPE -->
                
                             <label style="color:white">Drug type:
                             <select v-model="type">
                                 <option value="antibiotic">antibiotic</option>
                                 <option value="antihistamine">antihistamine</option>
                                 <option value="taAntidepressantblet">taAntidepressantblet</option>
                             </select>
                    </label>
                    <!-- DRUG FORM -->
                 <label style="color:white">Drug form:
                          <select v-model="form">
                                 <option value="gel">gel</option>
                                 <option value="powder">powder</option>
                                 <option value="tablets">tablets</option>
                             </select>
                           </label> 
                    
                     <!-- DRUG WAY OF SELLING -->
                     <label style="color:white">Way of selling:
                     <select v-model="wayOfSelling">
                                 <option value="onPrescription">onPrescription</option>
                                 <option value="nonPrescription">nonPrescription</option>
                                 
                             </select>
                     </label>
                    
                              <label style="color:white">Alternative drugs(if exists):
                              
                              <select v-model="alternativeDrugs">
                                 <option v-for="item in this.allDrugs" v-on:click ="addAlternativeTolist($event, item)" v-bind:key="item.id" value="item.name">{{item.name }}

                                 </option>
                                 
                                 
                             </select>
                     </label>
                       
                        
                    
            </div>
            
            <button style="color:white" type="submit" class="button" v-on:click = "addDrugs">Add drug</button>
            
        </div>
            </div>
        </div>
        </div>
  </div>
</template>


<script>
export default {
    name: 'AddingDrug',
    
  data() {
    return {
      type:'',
      form:'',
      wayOfSelling:'',
      
      name : "",
      code : "",
      
      specification : {
           contraIndications : "",
           composition : "",
           therapyDuration : "", 
           manufacturer : ""
      },
      allDrugs : null,
      alternativeDrugs : [],
      isAuthorized : false
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
        },
        showSpecificationModal:function(){
            this.$refs['my-modal'].show();
        },
      confirmSpecification : function() {
        this.$refs['my-modal'].hide()
      },
      logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";
        },
      
      addDrugs : function() {
          const medicationInfo = {
               name : this.name,
               code : this.code,
               drugForm : this.form,
               type : this.type,
               wayOfSelling : this.wayOfSelling,
               specification : this.specification,
               medicationsAlternatives : this.alternativeMedications
          }
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

          this.axios.post('/drug/addDrug',medicationInfo,{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }}).then(response => {
                       alert("Drug is added!");
                        console.log(response.data);
                        
                })
                .catch(res => {
                    alert(res.response.data.message);
                 });    

      },
      
     
      addAlternativeTolist : function(event, item) {
           this.alternativeDrugs.push(item);
      },
      
     
      

      
},
}
</script>  

<style scoped>
.vue-tempalte{
  width: 100%;
  height: 100%;
  background:  #f6f9fa!important;
  min-height: 70vh;
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
  margin: 0 auto 0px;
  padding: 40px;
  text-align: center;
  margin:auto
  
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

    .btn-primary{
        background: #403f72;
        position:relative; 
    }
    select{
        background: #ffffff;
        float:right;
        margin-right:60px;
        margin-left: 10px;
    }

    label, input {
    display: block;
}
    label {
    margin-bottom: 20px;
}





</style>