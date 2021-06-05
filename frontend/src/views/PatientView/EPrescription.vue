<template>
    <div id="EPrescription">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPharmacyPage">Pharmacy home page</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showSubsribedPharmacies">Subscribed pharmacies</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "writeComplaint">Complaint</button>
                     <button class = "btn btn-info btn-lg space_style" v-on:click = "showEPrescription">EPrescription</button>
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" v-on:click = "logOut">Log Out</button>
            </span>
        </div>       
         <div class="container">
         <div class = "col-8">
                <div style = "background-color:#174452; margin: auto; ;padding: 50px;">
                            <h3 style="color: white;margin-bottom:20px">Upload your QR code</h3>
                        <div class="form-group">
                            <div class="row">
                                
                                    <div class="col">
                                        <input type="file" id="file" ref="file"  v-on:change="handleFileUpload()" />
                                    </div> 
                                    <div class="col">
                                        <button  class="btn btn-primary" v-on:click="submitFile()">Check availability in pharmacies</button>
                                    </div>
                            </div>
                        </div>
                </div>
         </div>

           <!-- TABLE -->
       <div style="height:25px"></div>
            <h3>Pharmacies</h3>
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
                    <tr v-for="pharmacy in pharmacies" v-bind:key="pharmacy.id"
                    @click="selectedPharmacy = pharmacy.id">
                    <td v-bind="name">{{pharmacy.pharmacyName}}</td>
                    <td>{{pharmacy.mark}}</td>
                    <td>{{pharmacy.address.street}}</td>
                     <td>{{pharmacy.sumPrice}}</td>
                    <td>
                    <button  style="background-color:#17a2b8" class="btn btn-primary"  v-on:click = "buyDrugs($event,pharmacy)">Buy here</button>
                    </td>
                    </tr>
                </tbody>
            </table>
         </div>
        
    </div>
    
</template>
<script>

export default {
    name: 'EPrescription',
     data() {
    return {

      file: '',
      pharmacies:[],
      qrCodeDrugs:[],
      name:'',
      selectedPharmacyId:0,
       sortBy: 'grade',
       sortDesc: false,
       fieldForSorting: "grade",
       fields: [
          { key: 'pharmacyName', label: 'PharmacyName' },
          { key: 'mark', label: 'Grade' },
          { key: 'address', label: 'Address' },
           { key: 'sumPrice', label: 'SumPrice' },
            {label: 'Buy'},
        ],
        selectMode: 'single',
        
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
        logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";
        },
         showEPrescription: function(){
           window.location.href = '/ePrescription';
        },
        submitFile(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

            let formData = new FormData();

            formData.append('file', this.file);
           

            this.axios.post( '/erecipes/file', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                     'Authorization': 'Bearer ' + token
                }
              }). then(response => {
                    this.pharmacies = response.data.pharmacies;
                    this.qrCodeDrugs = response.data.qrCodeDrugs;
                    this.code = response.data.code;
                    if(this.pharmacies.length===0) {
                        alert("There is no pharmacy that has all drugs.")
                    }    
                }).catch(res => {
                    alert(res.response.data.message);
                });     
      },
         handleFileUpload(){
        this.file = this.$refs.file.files[0];
      },
       sortColumn : function() {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
             const columnForSort = {
                sortingKey : this.fieldForSorting,
                pharmaciesList: this.pharmacies,
            };
           
            this.axios.post('/pharmacy/sortResult',columnForSort, { 
                headers: {
                'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    this.pharmacies = response.data;
                    alert("Success")
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        },
        buyDrugs : function(event, pharmacy) {
          this.selectedPharmacyId = pharmacy.pharmacyId;
          
          const pharmacyInfos1 ={
                pharmacyId : this.selectedPharmacyId,
                qrCodeDrugs : this.qrCodeDrugs,
                 code: this.code,
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/pharmacy/buyDrugsHere',pharmacyInfos1,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    //this.drugInfo = response.data
                    alert("You have successfully bought drugs in this pharmacy");
                    console.log(response); 
                }).catch(res => {
                       alert("Please try later!");
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