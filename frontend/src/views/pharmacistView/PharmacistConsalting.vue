<template>
    <div id="pharmacistConsalting">
        <div class="homepage_style ">
           <span style="float: left; margin: 15px;">
                <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showHomepage">Home</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showPatients">My patients</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showWorkCalendar">Work calendar</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showAbsenceRequest">Create a vacation</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showConsalting">Consaltings</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showNewConsalting">Schedule new consalting</button>
            </span>
            <span  style="float:right;margin:15px">
                <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
            </span>
            <h1>{{counselingID}}</h1>
        </div>
    </div>
</template>

<script>
export default {
    name: 'PharmacistConsalting',
    data() {
      return {
        counselingID: '',

      }
    },
    mounted(){
        this.counselingID = this.$route.params.selectedCounseling;
    },
    methods:{
       showHomepage: function(){
           window.location.href = "/pharmacistHomepage";
        },
        showProfile: function(){
           window.location.href = "/pharmacistProfile";
        },
        showPatients: function(){
            window.location.href = "/pharmacistPatients";
        },
        showWorkCalendar: function(){
            window.location.href = "/pharmacistWorkCalendar";
        },
        showAbsenceRequest: function(){
            window.location.href = "/pharmacistAbsenceRequest";
        },
        showConsalting: function(){
            window.location.href = "/pharmacistConsalting/-1";
        },
        showNewConsalting: function(){
            window.location.href = "/pharmacistNewConsalting";
        },
        logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";
        }
    }
}
</script>

<style scoped>
    .image_style{
        height: 400px;
        width: 60%;
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
</style>