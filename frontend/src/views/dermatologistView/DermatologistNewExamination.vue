<template>
    <div id="dermatologistNewExamination" style="max-width:100%" >
        <div class="homepage_style ">
           <span style="float: left; margin: 15px; max-width: 100%;">
                <img class="image_style space_style" style="width: 50px; height: 50px; margin-right:10px;" src="@/images/natural-medicine.png">
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showHomepage">Home</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showProfile">Profile</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showPatients">My patients</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showWorkCalendar">Work calendar</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showAbsenceRequest">Create a vacation</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showExaminations">Examinations</button>
                <button class = "btn btn-info btn-lg space_style" v-on:click = "showNewExamination">Schedule new examination</button>
            </span>
              <span  style="float:right;margin:15px">
                    <button class = "btn btn-lg btn-light" style="margin-right:20px;" v-on:click = "logOut">Log Out</button>
                </span>
        </div>
        <div style="
        position: fixed;
        top: 10%;
        left: 0;
        max-width: 100%;
        z-index: 999;
        width: 100%;
        height: 70px;"
        class="table-info ">
            <h3 style="position: fixed;
                top: 12%; 
                max-width: 100%;
                left: 570px;
                text-align:center;">Schedule new examination
            </h3>
        </div>
            <div style="height:45px;
                width:850px;
                position: fixed;
                top: 25%;
                max-width: 100%;
                left: 0;
                z-index: 999;">
                <table  class="table table-striped table-dark " style="height:45px;
                width:700px;
                position: fixed;
                top: 25%;
                left: 50px;
                z-index: 999;">
                <thead class="bg-info">
                    <tr>
                        <th scope="col">Pharmacy Name</th>
                        <th scope="col">Date </th>
                        <th scope="col">Start time</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Price</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="examinationSchedule in myExaminationSchedule" :key="examinationSchedule.id">
                        <td></td>
                        <td>{{examinationSchedule.pharmacy}}</td>
                        <td>{{examinationSchedule.startDate}}</td>
                        <td>{{examinationSchedule.startTime}}</td>
                        <td>{{examinationSchedule.duration}}</td>
                        <td>{{examinationSchedule.price}}</td>
                        <td><button class="btn btn-primary btn-lg" v-on:click="Add ($event, examinationSchedule)">Reserve examination</button></td>
                    </tr>
                </tbody>
            </table>
            <div class="vl"></div>
            <b-card header="Schedule examination from scratch"
                header-text-variant="white"
                header-tag="header"
                header-bg-variant="info"
                border-variant="info"
                style="position: fixed;
                    top: 25%; 
                    max-width: 100%;
                    left: 810px;
                    text-align:center;
                    height: 500px;
                    width: 45%;
                    max-width: 100%;">
                    <h6 class="ml-n mt-6 strong text-left"><b>Search and chooese patient</b></h6>
                    <b-form-input class="object_space" v-model="startDate" filled placeholder="Enter patient"></b-form-input>
                    <h6 class="ml-n mt-6 strong text-left"><b>Select pharmacy</b></h6>
                    <b-dropdown text="Error Reports" class="m-md-2">
                        <component 
                            :is="`b-dropdown-${pharmacy.name}`" 
                            v-for="(pharmacy, index) in pharmacys"
                            :key="index" 
                            
                            >
                            {{ pharmacy.value }}
                        </component>
                    </b-dropdown>
                    <h6 class="ml-n mt-6 strong text-left"><b>Select date of examination</b></h6>
                    <b-form-input class="object_space" v-model="startDate" filled placeholder="Enter date of examination"></b-form-input>
                    <h6 class="ml-n mt-6 strong text-left"><b>Select start time of examination</b></h6>
                    <b-form-input class="object_space" v-model="startTime" filled placeholder="Start time of examination"></b-form-input>
                    <h6 class="ml-n mt-6 strong text-left"><b>Select end time of examination</b></h6>
                    <b-form-input class="object_space" v-model="endTime" filled placeholder="End time of examination"></b-form-input>
                    
                    <b-button class="btn btn-info btn-lg space_style object_space" style="background-color:#003d66; width:18cm;" v-on:click = "scheduleExamination">Schedule</b-button>
            </b-card>
        </div>
    </div>
</template>

<script>
export default {
    name: 'DermatologistNewExamination',
    data() {
    return {
        examination : "",
        startDate: null,
        startTime: null,
        endTime: null,
        pharmacys: [],
        pharmacy: ""
        }
    },
    mounted(){
     let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.axios.get('/examination/getFreeScheduled',{ 
            headers: {
                'Authorization': 'Bearer ' + token,
            }
        }).then(response => {
            this.examination = response.data;
        }).catch(res => {
            alert("Error");
            console.log(res);
        });

        this.axios.get('/pharmacy/pharmacystaff/dermatologist',{ 
            headers: {
                'Authorization': 'Bearer ' + token,
            }
        }).then(response => {
            this.pharmacys = response.data;
        }).catch(res => {
            alert("Error");
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
        logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";

        },
        scheduleExamination : function(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
                const newExamination = {
                    startDate: this.startDate,
                    startTime : this.startTime,
                    endTime: this.endTime
                };
                this.axios.post('/examination/dermatologistSchedule',newExamination, { 
                    headers: {
                        'Authorization': 'Bearer ' + token,
                    }})
                    .then(response => {
                        alert("Successfully scheduled new examination.")
                            console.log(response);
                    })
                    .catch(response => {
                        alert("Please, try later.")
                        console.log(response);
                    })
        }
    }
}
</script>

<style scoped>
    .image_style{
        height: 400px;
        width: 60%;
        max-width: 100%;
    }

    .homepage_style{
        background: #17a2b8; 
        position: fixed;
        top: 0;
        left: 0;
        z-index: 999;
        width: 100%;
        height: 70px;
        max-width: 100%;
    }

    .space_style{
        margin-right:5px;
        max-width: 100%;
    }

    .vl {
        border-left: 6px solid #afced3;
        height: 500px;
        position: fixed;
        top: 25%;
        left: 780px;
        z-index: 999;
        max-width: 100%;
    }

    .object_space {
        margin-top: 1% !important;
        margin-bottom: 1% !important;
    }
</style>