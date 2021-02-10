<template>
    <div id="dermaHomepage">
        <div class="homepage_style ">
            <span style="float: left; margin: 15px;">
                    <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showHomePage">Home</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showMyProfile">Profile</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showPatients">My patients</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "workCalendar">Work calendar</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "vacation">Create a vacation</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "showExaminations">Examination</button>
                    <button class = "btn btn-info btn-lg space_style" v-on:click = "scheduleExamination">Schedule new examination</button>
            </span>
              <span  style="float:right;margin:15px">
                    <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
                </span>
        </div>
        <div style="border-bottom-color: #313052;">
            <img class="image_style" src="@/images/dermaa.jpg">
        </div>
    </div>

</template>

<script>
export default {
    name: 'DermatologistHomepage'
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