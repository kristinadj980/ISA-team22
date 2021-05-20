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
        <!-- TABLE -->
       <div style="height:25px"></div>
            <h3>Drugs</h3>
            <table class="table table-striped" style="width:100%;">
                <thead class="thead-light">
                    <tr>
                    <th scope="col" 
                    v-for="f in fields" v-bind:key="f.key" 
                    @click="fieldForSorting = f.key"
                    v-on:click="sortColumn">
                        {{f.label}}
                    </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="drug in drugs" v-bind:key="drug.id"
                    @click="selectedDrug = drug.id">
                    <td>{{drug.name}}</td>
                    <td>{{drug.type}}</td>
                    <td>{{drug.numberOfGrades}}</td>
                    <td>
                    <button  style="background-color:#17a2b8" class="btn btn-primary" v-on:click = "showDrugSpecification($event,drug)" >See Specification</button>
                    </td>
                    <td><button  style="background-color:#17a2b8" class="btn btn-primary" v-on:click = "checkAvailability($event,drug)">See Availability</button> </td>
                    </tr>
                </tbody>
            </table>
            <div> 
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
       sortBy: 'grade',
       sortDesc: false,
       fieldForSorting: "grade",
       fields: [
          { key: 'name', label: 'Name' },
          { key: 'type', label: 'Type' },
          { key: 'grade', label: 'Grade' },
          {label: 'Specification'},
          { label: 'Availability'}
        ],
        selectMode: 'single',
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
                    this.drugs = response.data;
                    this.showMedicationInfoDiv = true;
                    alert("Uspesno")
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        },
        checkAvailability : function(event, drug) {
          this.selectedDrugId = drug.id;
          this.selectedDrugCode = drug.code;
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
      showDrugSpecification : function(event, drug) {
          this.selectedDrugId = drug.id;
          const drugInfos1 ={
                id : this.selectedDrugId,
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
      sortColumn : function() {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
             const columnForSort = {
                sortingKey : this.fieldForSorting
            };
            this.axios.post('/drug/sortResult',columnForSort, { 
                headers: {
                'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    this.drugs = response.data;
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        }
     
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

     .th_header {
        display: table-cell;
        -ms-text-combine-horizontal: inherit;
        font-weight: bold;
        text-align: center;
        }

</style>