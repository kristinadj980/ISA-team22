<template>
<div id="giveOffers">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showMyOffers">MyOffers</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showGiveOffers">Offers</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showMyDrugs">MyDrugs</button>
                    
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
                        <label >Drug</label>
                    </div>
                   
                    <div class=" form-group col">          
                        <label > Drug amount</label>
                    </div>
                    <div class=" form-group col">          
                        <label >Delivery date</label>
                    </div>
                    <div class=" form-group col">
                        <label ></label>
                    </div>
                   
               </div>
               <div v-for="order in orders"   v-bind:key="order.orderId">
                    <div class="row">
                            <div class=" form-group col">
                                <label >{{order.pharmacyName}}</label>
                            </div>
                            <div v-for="drug in order.drugs" v-bind:key="drug.id" class=" form-group col">          
                                <label >{{drug.name}}</label>
                            </div>
                           
                             <div  v-for="drug in order.drugs" v-bind:key="drug.id" class=" form-group col">          
                                <label >{{drug.amount}}</label>
                            </div>
                             
                            <div class=" form-group col">        
                                <label >{{format_date(order.date)}}</label>
                            </div>
                           
                            <div class=" form-group col">
                                <button v-bind:disabled="isOfferGiven" style="background-color:#17a2b8"  v-on:click = "showOffer($event,order)" class="btn btn-primary">Make an offer</button>
                            </div>
                    </div>
               </div>
    </div>
    <div> 
          <b-modal ref="quantity-modal" hide-footer scrollable title="Order specification" size="lg" modal-class="b-modal">
               <div modal-class="modal-dialog" role="document">
                    <div class="modal-content" style="background-color:whitesmoke">
                         <div class="modal-body">
                             <div class="row">
                                <div class=" form-group col">
                                     <label>Enter price: </label> 
                                </div>
                                <div class=" form-group col">  
                                    <input type="text" class="form-control" v-model="choosenOfferPrice" placeholder="Offer price...">
                                </div>
                             </div>
                             <div class="row">
                                <div class=" form-group col">
                                     <label>Enter delivery date: </label> 
                                </div>
                                <div class=" form-group col">  
                                    <input type="text" class="form-control" v-model="choosenDeliveryDate" placeholder="Delivery date...">
                                </div>
                             </div>
                            <button v-on:click = "makeAnOffer" class="btn btn-primary">Confirm</button> 
                                                       
                         </div>                
                    </div>
               </div>
          </b-modal>
       </div>
</div>
</template>

<script>
import moment from 'moment'
export default{
    name:'Drugs',
    data() {
    return {
        orders : [],
        choosenOffer : {},
        choosenOfferPrice : 0,
        choosenOfferId : null,
        choosenDeliveryDate : null,
        dueDate: null,
        isOfferGiven : false,
    }
    },
     methods:{
         
         format_date(value){
         if (value) {
           return moment(String(value)).format('YYYY-MM-DD')
          }
      },
     showProfile: function(){
           window.location.href = "/profileDataSupplier";
        },
        showMyOffers: function(){
           window.location.href = "/offers";
        },
        
        showMyDrugs:  function(){
           window.location.href = "/drugs";
        },
        showGiveOffers:  function(){
           window.location.href = "/giveOffers";
        },
        
        showOffer : function(event, order) {
          this.choosenOrder = order;
          this.choosenOfferPrice = order.price;
          this.choosenOfferId = order.id;
          this.choosenDeliveryDate = this.format_date(order.date);
          this.dueDate = this.format_date(order.date);
         
           this.$refs['quantity-modal'].show();
      },
      getActiveOrders : function() {
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
          this.orders = []
          this.axios.get('/purchaseOrder/activeOrders',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
             
             this.orders=response.data;
         }).catch(res => {
                console.log(res);
            });
      },
      makeAnOffer : function() {
            const offerInfo ={
                orderId : this.choosenOfferId,
                price : this.choosenOfferPrice,
                deliveryDate: this.choosenDeliveryDate,
                dueDate : this.dueDate,
                isOfferGiven : this.isOfferGiven,
                
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/offer/addOffer',offerInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    console.log(response);
                    this.isOfferGiven = true
                    this.getActiveOrders();

                   alert("Offer is successfully sent!"); 
                }).catch(res => {
                       alert("Please try later.");
                        console.log(res);
                });
            this.$refs['quantity-modal'].hide();
            

      },
      
      
},
 mounted() {
        this.getActiveOrders();
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
