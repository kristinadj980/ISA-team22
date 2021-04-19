<template>
<div id="drugs">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showMyOffers">MyOffers</button>
                    <button class = "btn btn-info btn-lg space_style">Offers</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showMyDrugs">MyDrugs</button>
                    
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" >Log Out</button>
            </span>
        </div>
    <div style = "background-color:oldlace; margin: auto; width: 60%;border: 2px solid #17a2b8;padding: 10px;margin-top:45px;">
               <div class="row">
                    <div class=" form-group col">
                        <label >Name</label>
                    </div>
                    <div class=" form-group col">
                        <label >Code</label>
                    </div>
                   
                    <div class=" form-group col">          
                        <label >Reserved quantity for offers</label>
                    </div>
                    <div class=" form-group col">          
                        <label >Available quantity</label>
                    </div>
                    <div class=" form-group col">
                        <label ></label>
                    </div>
                   
               </div>
               <div v-for="drug in myDrugs"   v-bind:key="drug.code">
                    <div class="row">
                            <div class=" form-group col">
                                <label >{{drug.name}}</label>
                            </div>
                            <div class=" form-group col">          
                                <label >{{drug.code}}</label>
                            </div>
                           
                             <div class=" form-group col">          
                                <label >{{drug.reservedQuantity}}</label>
                            </div>
                             <div class=" form-group col">          
                                <label >{{drug.quantity}}</label>
                            </div>
                           
                            <div class=" form-group col">
                                <button style="background-color:#17a2b8" v-on:click = "showDrugQuantity($event,drug)" class="btn btn-primary">Add more quantity</button>
                            </div>
                    </div>
               </div>
    </div>
    <div> 
          <b-modal ref="quantity-modal" hide-footer scrollable title="Drug specification" size="lg" modal-class="b-modal">
               <div modal-class="modal-dialog" role="document">
                    <div class="modal-content" style="background-color:whitesmoke">
                         <div class="modal-body">
                             <div class="row">
                                <div class=" form-group col">
                                     <label>Available quantity: </label> 
                                </div>
                                <div class=" form-group col">  
                                    <input type="text" class="form-control" v-model="choosenDrugQuantity" placeholder="Quantity..">
                                </div>
                             </div>
                            <button v-on:click = "changeQuantity" class="btn btn-primary">Confirm</button> 
                                                       
                         </div>                
                    </div>
               </div>
          </b-modal>
       </div>
</div>
</template>

<script>
export default{
    name:'Drugs',
    data() {
    return {
        myDrugs : [],
        choosenDrug : {},
        choosenDrugQuantity : 0,
        choosenDrugId : null,
        
    
    }
    },
     methods:{
     showProfile: function(){
           window.location.href = "/profileDataSupplier";
        },
        showMyOffers: function(){
           window.location.href = "/offers";
        },
        showMyDrugs:  function(){
           window.location.href = "/drugs";
        },
      changeQuantity : function() {
            const quantityDrugInfo ={
                drugId : this.choosenDrugId,
                newQuantity : this.choosenDrugQuantity,
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/supplierDrugs/updateDrug',quantityDrugInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    console.log(response);
                    this.getMyDrugs();

                   alert("Quantity is successfully updated!"); 
                }).catch(res => {
                       alert("Please try later.");
                        console.log(res);
                });
            this.$refs['quantity-modal'].hide();
            

      },
     
      showDrugQuantity : function(event, drug) {
          this.choosenDrug = drug;
          this.choosenDrugQuantity = drug.quantity;
          this.choosenDrugId = drug.id;
           this.$refs['quantity-modal'].show();
      },
      getMyDrugs : function() {
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
          this.myDrugs = []
          this.axios.get('/supplierDrugs',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
             
             this.myDrugs=response.data;
         }).catch(res => {
                console.log(res);
            });
      }
      
      
},
 mounted() {
        this.getMyDrugs();
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
