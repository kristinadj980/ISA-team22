<template>
    <div id="offers">
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
        <!-- *******************************************************-->
        <div class="row">
            <div class="form-group col">
                <h5 style="color: #0D184F">Filter offers by status: </h5>
            </div >
             <template>
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'created')">
                   <label class="custom-control-label" for="defaultGroupExample1">created</label>
                
              </div> 
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'accepted')">
                   <label class="custom-control-label" for="defaultGroupExample2">accepted</label>
                
              </div> 
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample3" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'refused')">
                 <label class="custom-control-label" for="defaultGroupExample3">refused</label>
                
              </div> 
              <div class="custom-control custom-radio form-group col ">

                  <input type="radio" class="custom-control-input" id="defaultGroupExample4" name="groupOfDefaultRadios" v-on:click="updateFiler($event,'all')" checked>
                 <label class="custom-control-label" for="defaultGroupExample4" >all</label>
                
              </div> 
             </template>
        </div>
        <!-- TABLE -->
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
                        <label >Offered price</label>
                    </div>
                    <div class=" form-group col">          
                        <label >Status</label>
                    </div>
                    <div class=" form-group col">
                        <label ></label>
                    </div>
                   
               </div>
               <div v-for="offer in myOffers"   v-bind:key="offer.id">
                    <div class="row">
                            <div class=" form-group col">
                                <label >{{offer.pharmacyName}}</label>
                            </div>
                            <div v-for="drug in offer.drugs" v-bind:key="drug.id" class=" form-group col">          
                                <label >{{drug.name}}</label>
                            </div>
                           
                             <div  v-for="drug in offer.drugs" v-bind:key="drug.id" class=" form-group col">          
                                <label >{{drug.amount}}</label>
                            </div>
                             
                            <div class=" form-group col">        
                                <label >{{offer.totalPrice}}</label>
                            </div>
                            <div class=" form-group col">        
                                <label >{{offer.status}}</label>
                            </div>
                           
                            <div class=" form-group col">
                                <button style="background-color:#17a2b8" v-on:click = "showOffer($event,offer)" class="btn btn-primary">Change offer</button>
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
                                    <input type="text" class="form-control" v-model="deliveryTime" placeholder="Delivery date...">
                                </div>
                             </div>
                            <button v-on:click = "changeOffer" class="btn btn-primary">Confirm</button> 
                                                       
                         </div>                
                    </div>
               </div>
          </b-modal>
       </div>
</div>
</template>


<script>
import moment from 'moment'
export default {
    name: 'Offers',
     data() {
    return {
       myOffers :[],
      choosenOffer : {},
      choosenOfferDate : null,
      choosenOfferPrice : 0,
      deliveryTime : null,
      choosenOfferId : 0,
      choosenOfferChangable : false,
      choosenOfferNotChangable : false,
      isOfferGiven : false,
    }
  },
  mounted() {
       this.getMyOffers()
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
        showOffer : function(event, offer) {
          this.choosenOffer = offer;
          this.choosenOfferPrice = offer.totalPrice;
          this.choosenOfferId = offer.purchaseOrderId;
          alert(this.choosenOfferId)
          this.deliveryTime = this.format_date(offer.deliveryTime);
          this.dueDate = this.format_date(offer.date);
          this.offerId = offer.offerId;
          this.isOfferGiven = offer.isOfferGiven;
           this.$refs['quantity-modal'].show();
      },
       getMyOffers : function() {
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.axios.get('/offer/myOffers',{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    this.myOffers=response.data;
                    console.log(response.data)
                }).catch(res => {
                 
                    console.log(res);
                }); 
      },
      changeOffer : function() {
            const offerInfo ={
                orderId : this.choosenOfferId,
                price : this.choosenOfferPrice,
                deliveryDate: this.deliveryTime,
                dueDate : this.dueDate,
                offerId : this.offerId,
                
            } 
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.post('/offer/changeOffer',offerInfo,{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                    console.log(response);
                    this.getMyOffers()

                   alert("Offer is successfully changed!"); 
                }).catch(res => {
                       alert("Please try later.");
                        console.log(res);
                });
            this.$refs['quantity-modal'].hide();
            

      },
         updateFiler : function(event, filter) {
        let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        if(filter==="all") {
            this.axios.get('/offer/myOffers',{ 
                                          headers: {
                                                  'Authorization': 'Bearer ' + token,
                                  }}).then(response => {
                                      this.myOffers=response.data;
                                      alert(this.myOffers.length)
                                      console.log(response.data)
                                  }).catch(res => {
                                        alert("Please try later.");
                                          console.log(res);
                                  }); 
        }
        
        else {
            this.axios.get('/offer/myOffers/'+filter,{ 
                                    headers: {
                                            'Authorization': 'Bearer ' + token,
                            }}).then(response => {
                                this.myOffers=response.data;
                                console.log(response.data)
                                alert(this.myOffers.length)
                            }).catch(res => {
                                  alert("Please try later.");
                                    console.log(res);
                            }); 
        }
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