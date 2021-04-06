<template>
    <div id="supplierProfile">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                 <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showOffers">Offers</button>
                    
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:10px;" v-on:click = "logOut">Log Out</button>
            </span>
        </div>

        <div class="row">
            <div class="form-group col">
                <h5 style="color: #0D184F">Filter offers by status</h5>
            </div >
           
        </div>
    </div>
        
    </template>

<script>
export default {

  data() {
    return {
      myOffers :[],
      choosenOffer : {},
      choosenOfferDate : null,
      choosenOfferPrice : 0,
      newDelieveryDate : null,
      choosenOfferId : 0,
      choosenOfferChangable : false,
      choosenOfferNotChangable : false,
      isAuthorized : false
    }
  },

  methods:{
      
     
      
},
 mounted() {
        let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.axios.get('/offer/myOffers',{ 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                }}).then(response => {
                   
                    this.isAuthorized = true;
                    this.myOffers=response.data;
                }).catch(res => {
                  this.isAuthorized = false;
                    alert("Please, log in first!");
                    window.location.href = "/login";
                    console.log(res);
                }); 
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