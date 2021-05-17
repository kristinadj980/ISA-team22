<template>
    <div id="showDrugs">
        <div style="background: white; height: 60px; margin-top: 20px">
          <h4 class="text-left"
        style="margin-left:2%;
        margin-top:1%;">
        <b>Drug search:</b>
        </h4>
        <div
        style="margin-top: 2%;
        margin-left: 2%;">
            <b-form inline>
                <b-form-input
                v-model="drugName"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Drug name"
                ></b-form-input>
                <b-button style="margin-left:2%;" v-on:click = "searchDrug" variant="info">Search</b-button>
               
            </b-form>
        </div>  
        <!-- table -->
         <div v-if = "showMedicationInfoDiv" style = "background-color:oldlace; margin: auto; width: 60%;border: 2px solid #17a2b8;padding: 10px;margin-top:45px;">
               <div class="row">
                    <div class=" form-group col">
                        <label >Name</label>
                    </div>
                    <div class=" form-group col">
                        <label >Type</label>
                    </div>
                    <div class=" form-group col">
                        <label >Grade</label>
                    </div>
                    <div class=" form-group col">
                        <label ></label>
                    </div>
                     <div class=" form-group col">
                        <label ></label>
                    </div>
                   
               </div>
               <div>
                    <div class="row">
                            <div class=" form-group col">
                                <label >{{drugInfo.name}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{drugInfo.type}}</label>
                            </div>
                             <div  class=" form-group col">          
                                <label >{{drugInfo.numberOfGrades}}</label>
                            </div>
                           
                            <div class=" form-group col">
                                <button  style="background-color:#17a2b8" class="btn btn-primary" v-on:click = "showDrugSpecification($event,drugInfo)" >See Specification</button>
                            </div>
                             <div class=" form-group col">
                                <button  style="background-color:#17a2b8" class="btn btn-primary" v-on:click = "checkAvailability($event,drugInfo)">See Availability</button>
                            </div>
                    </div>
               </div>
         </div>
        </div>
        <div> 
          <b-modal ref="quantity-modal" hide-footer scrollable title="Drug availability" size="lg" modal-class="b-modal">
               <div modal-class="modal-dialog" role="document">
                    <div class="modal-content" style="background-color:whitesmoke">
                         <div v-for="pharmacy in pharmacyDrugAvailability" v-bind:key="pharmacy.id" class="modal-body">
                             
                             <div class="row">
                                <div class=" form-group col">
                                <label > Pharmacy : {{pharmacy.pharmacyName}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >Price : {{pharmacy.price}}</label>
                            </div>
                             </div>
                                                       
                         </div>                
                    </div>
               </div>
          </b-modal>
       </div>

       <div> 
          <b-modal ref="quantity-modal2" hide-footer scrollable title="Drug specification" size="lg" modal-class="b-modal">
               <div modal-class="modal-dialog" role="document">
                    <div class="modal-content" style="background-color:whitesmoke">
                         <div  class="modal-body">
                             <div class="row">
                    <div class=" form-group col">
                        <label >Code</label>
                    </div>
                    <div class=" form-group col">
                        <label >Form</label>
                    </div>
                    <div class=" form-group col">
                        <label >Composition</label>
                    </div>
                    <div class=" form-group col">
                        <label >Producer</label>
                    </div>
                     <div class=" form-group col">
                        <label >Issuance regime</label>
                    </div>
                     <div class=" form-group col">
                        <label >Contraindications</label>
                    </div>
               </div>
                             <div class="row">
                                <div class=" form-group col">
                                <label >{{drugInfo.code}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{drugInfo.drugForm}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{drugInfo.specification.composition}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{drugInfo.specification.manufacturer}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{drugInfo.issuance}}</label>
                            </div>
                            <div  class=" form-group col">          
                                <label >{{drugInfo.specification.contraIndications}}</label>
                            </div>
                             </div>
                                                       
                         </div>                
                    </div>
               </div>
          </b-modal>
       </div>
    </div>
</template>

<script>
export default {
    name: 'ShowDrugs',
     data() {
    return {
       drugs :[],
       drugName : "",
       showMedicationInfoDiv : false, 
       selectedDrugId:0,
       selectedDrugCode:'',
       pharmacyDrugAvailability: [],
       drugInfo : {
            name : "",
            form : "",
            type :"",
            issuanceRegime :"",
            numberOfGrades:0,
            mark : 0,
            specification: {
                    contraIndications :"",
                    structure : "",
                    recommendedConsumption : "",
                    manufacturer : ""
            },
            medicationId : 0,
            code : 0
      },
    }
  },
  mounted() {
       this.getDrugs()
    },
  methods:{
        getDrugs : function() {
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
          this.drugs = []
          this.axios.get('/drug/getdrugs',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
             this.isAuthorized = true;
             this.drugs=response.data;
         }).catch(res => {
                this.isAuthorized = false;
                //alert("Please, log in first!");
                //window.location.href = "/login";
                console.log(res);
            });
      },
      searchDrug : function(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            if(this.drugName == ""){
                alert("Please enter name!")
                return;
            }
            const drugForSearch = {
                name: this.drugName,
            };
            this.axios.post('/drug/searchDrug',drugForSearch, { 
                headers: {
                'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    this.drugInfo = response.data;
                    this.showMedicationInfoDiv = true;
                    /*this.fields = [
                    { key: 'name', sortable: true },
                    { key: 'surname', sortable: true },
                    ];*/
                    alert("Uspesno")
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        },
        checkAvailability : function(event, drugInfo) {
          this.selectedDrugId = drugInfo.id;
          this.selectedDrugCode = drugInfo.code;
          const drugInfos ={
                id : this.selectedDrugId,
                drugCode : this.selectedDrugCode
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/pharmacy/checkDrugAvailability',drugInfos,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    this.pharmacyDrugAvailability = response.data
                    alert("successfully");
                    this.$refs['quantity-modal'].show();
                    console.log(response); 
                }).catch(res => {
                       alert("Please try later.");
                        console.log(res);
                });
      },
      showDrugSpecification : function(event, drugInfo) {
          this.selectedDrugId = drugInfo.id;
          //this.selectedDrugCode = drugInfo.code;
          const drugInfos1 ={
                id : this.selectedDrugId,
               // drugCode : this.selectedDrugCode
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/drug/getDrugSpecification',drugInfos1,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    this.drugInfo = response.data
                    alert("successfully");
                    this.$refs['quantity-modal2'].show();
                    console.log(response); 
                }).catch(res => {
                       alert("Please try later.");
                        console.log(res);
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