<template>
    <div id="offers">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showMyOffers">MyOffers</button>
                    <button class = "btn btn-info btn-lg space_style" >Offers</button>
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
         <table class="table mt-5">
      <thead  >
        <tr class="text-center bg-info text-light">
          <th scope="col">Pharmacy</th>
          <th scope="col">Drug</th>
          <th scope="col">Amount</th>
          <th scope="col">Offered price</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody >
        <tr   class="text-center" v-for="offer in myOffers" v-bind:key="offer.offerId" >
          <td> {{offer.pharmacyName}}</td>
          <td v-for="drug in offer.drugs" v-bind:key ="drug.id">{{drug.name}}</td>
          <td v-for="drug in offer.drugs" v-bind:key ="drug.id">{{drug.amount}}</td>
          <td>{{offer.totalPrice}}</td>
          <td>{{offer.status}}</td>
        </tr>
      </tbody>
    </table>
         
    </div>
    
</template>



<script>
export default {
    name: 'Offers',
     data() {
    return {
       myOffers :[''],
      choosenOffer : {},
      choosenOfferDate : null,
      choosenOfferPrice : 0,
      newDelieveryDate : null,
      choosenOfferId : 0,
      choosenOfferChangable : false,
      choosenOfferNotChangable : false,
    }
  },
  mounted() {
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