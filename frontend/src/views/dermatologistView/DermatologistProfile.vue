<template>
    <div id="dermatologistProfile">
        <!-- Navigation bar -->
        <div class="homepage_style "  >
            <span style="float: left; margin: 15px;">
                <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showHomepage">Home</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showPatients">My patients</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showWorkCalendar">Work calendar</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showVacation">Create a vacation</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showExaminations">Examinations</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showNewExamination">Schedule new examination</button>
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
            </span>
        </div>
        <!-- Navigation bar bg-white mt-5 mb-5-->
        <div class="container bg-white   mt-5 mb-5">
   
            <div class="card"  >
                <div class="profile-img">
                    <img class="img-responsive" src="@/images/nature.jpg" style=" height:150px;" width="100%" />
                    <img class="img-circle img-responsive rounded-circle"  src="@/images/dermatologist.png" style="width:120px; height:120px;"  />
                </div>
                <div class=" d-inline-block " style=" height:100%; background-color: #ced2d3;">
                    <h4 style = "position:left; left:60px; top:2px; background-color:#ebf0fa;"><b>dr {{dermatologist.name}}  {{dermatologist.surname}} </b></h4>
                    <div class="p-3 py-5 ">
                    <div class="col-md-8 ">
                    <div class="card mb-3 " style = "position:right; left:90px; top:2px; background-color:#ebf0fa;">
                    <div class="card-body" style="background-color: #ebf0fa;">
                        <h4 class ="text-justify top-buffer"> Name:   {{dermatologist.name}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Surname:   {{dermatologist.surname}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Email:   {{dermatologist.email}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Password:   {{dermatologist.password}}</h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> Address:   {{dermatologist.address.street}}, {{dermatologist.address.number}} </h4>
                        <hr>
                        <h4 class ="text-justify top-buffer"> City:  {{dermatologist.address.town}}, {{dermatologist.address.country}} </h4>
                        
                </div>
              </div>
            </div>
                        
                         <!-- <div class="mt-5 text-center top-buffer"><button class="btn btn-info btn-lg space_style" style="background-color:#003d66;"  v-on:click = "editProfile">Edit profile</button></div>-->  
                        <!-- Modal --> 
                        <div class="mt-5 text-center top-buffer">
                            <b-button  class="btn btn-info btn-lg space_style" style="background-color:#003d66;" v-b-modal.modal-1>Edit password</b-button>
                            <b-button  class="btn btn-info btn-lg space_style"  style="background-color:#003d66;" v-b-modal.modal-1>Edit profile info</b-button>
                            <b-modal ref="modal-ref" id="modal-1" title="Edit profile info" hide-footer>
                                <div>
                                    <h5 class ="text-justify top-buffer"> Name:
                                        <b-form-input v-model="dermatologist.name" label="First Name" filled placeholder="Enter your name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Last Name:
                                        <b-form-input v-model="dermatologist.surname" label="Last Name" filled placeholder="Enter your name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Email:
                                        <b-form-input v-model="dermatologist.email" label="Email" disabled></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Street:
                                        <b-form-input v-model="dermatologist.address.street" label="Street" filled placeholder="Enter your street name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Street Number:
                                        <b-form-input v-model="dermatologist.address.number" label="Street Number" filled placeholder="Enter your street number"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> City:
                                        <b-form-input v-model="dermatologist.address.town" label="City" filled placeholder="Enter the city name"></b-form-input>
                                    </h5>
                                    <h5 class ="text-justify top-buffer"> Country:
                                        <b-form-input v-model="dermatologist.address.country" label="Country" filled placeholder="Enter the country name"></b-form-input>
                                    </h5>
                                    <b-row style="float: left; margin: 30px;">
                                        <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "cancel">Cancel</b-button>
                                        <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "update">Update</b-button>
                                    </b-row>
                                </div>
                            </b-modal>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script>
export default {
name: 'DermatologistProfile',
data() {
    return {
        dermatologist : "",
        name: "",
        surname: "",
        email: "",
        address : "",
    }
  },
  mounted(){
     let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.axios.get('/dermatologist/profile',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
               this.dermatologist=response.data;
         }).catch(res => {
                       alert("NOT OK");
                        console.log(res);
                 });
    
   },
    methods:{
        showHomepage: function(){
           window.location.href = "/dermatologistHomepage";
        },
        showProfile: function(){
           window.location.href = "/dermatologistProfile";
        },
        showPatients: function(){
            window.location.href = "/dermatologistPatients";
        },
        showWorkCalendar: function(){
            window.location.href = "/dermatologistWorkCalendar";
        },
        showAbsenceRequest: function(){
            window.location.href = "/dermatologistAbsenceRequest";
        },
        showExamination: function(){
            window.location.href = "/dermatologistExamination";
        },
        showNewExamination: function(){
            window.location.href = "/dermatologistNewExamination";
        },
        editProfile: function(){
            window.location.href = "/dermatologistNewExamination";
        },
        cancel() {
            this.$refs['modal-ref'].hide();
        },
       update : function(){
         let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
           const ad = {
                   
                    country: this.dermatologist.address.country,
                    town: this.dermatologist.address.town,
                    street: this.dermatologist.address.street,
                    number:this.dermatologist.address.number
                };
            const p = {
                    id: this.dermatologist.id,
                    email:this.dermatologist.email,
                    firstname: this.dermatologist.name,
                    surname : this.dermatologist.surname,
                    address: ad,
                };
       
                this.axios.post('/dermatologist/update',p, { 
                         headers: {
                                'Authorization': 'Bearer ' + token,
                        }})
                    .then(res => {
                        alert("Successfully updated info.")
                        window.location.href = "/dermatologistProfile";
                        console.log(res);
                    })
                    .catch(res => {
                        alert("Try later.")
                        console.log(res);
                    })
            
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
        margin-right:5px
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
    .top-buffer { 
    margin-top:20px; 
    }
</style>