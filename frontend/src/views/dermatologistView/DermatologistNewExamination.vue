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
                <table  class="table table-striped table-dark table_style ">
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
                        <!--<td><button class="btn btn-primary btn-lg" v-on:click="Add ($event, examinationSchedule)">Reserve examination</button></td>-->
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
                    <h6 class="ml-n mt-6 strong text-left" style="margin-bottom:8%"><b>Search and chooese patient</b></h6>
                    <i class="fa fa-user icon"></i>
                    <input list="my-list-id" v-model="selectedPatient" class="input_style" placeholder="      Enter patient">
                    <datalist id="my-list-id">
                        <option v-for="patient in patients" v-bind:key="patient.id">
                            {{ patient.name }} {{patient.surname}} | {{patient.email}} 
                        </option>
                    </datalist>
                    <!--https://www.youtube.com/watch?v=G34_yNV8FMY------v-model="selectedPatient"-->
                    <b-dropdown text="Select pharmacy" variant="outline-info" class="dropdown_style" id="dropdown-divider">
                            <b-dropdown-item  
                            v-for="pharm in pharmacies" v-bind:key="pharm.id" :value="pharm.id"
                            @click="selectedPharmacyID = pharm.id, selectedPharmacyName = pharm.name">
                                {{ pharm.name}}
                             </b-dropdown-item>
                    </b-dropdown>
                    <p class="ml-n mt-6 strong chosen"> <b>Selected pharmacy: {{ selectedPharmacyName}}</b></p>
                    <h6 class="ml-n mt-6 strong text-left" style="margin-top:4%"><b>Select date of examination</b></h6>
                    <b-form-input type="date" class="object_space" v-model="startDate" filled placeholder="Enter date of examination"></b-form-input>
                    <h6 class="ml-n mt-6 strong text-left"><b>Select start time of examination</b></h6>
                    <b-form-input type="time" class="object_space" v-model="startTime" filled placeholder="Start time of examination"></b-form-input>
                    <h6 class="ml-n mt-6 strong text-left"><b>Select end time of examination</b></h6>
                    <b-form-input type="time" class="object_space" v-model="endTime" filled placeholder="End time of examination"></b-form-input>
                    
                    <b-button class="btn btn-info btn-lg space_style object_space" style="background-color:#17a2b8; width:18cm;" v-on:click = "scheduleExamination">Schedule</b-button>
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
        pharmacies: [''],
        selectedPharmacyID: null,
        selectedPharmacyName: "",
        patients:[''],
        selectedPatient: [''],
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
            this.pharmacies = response.data;
        }).catch(res => {
            alert("Error");
            console.log(res);
        });

        this.axios.get('/patient/allPatients',{ 
            headers: {
                'Authorization': 'Bearer ' + token,
            }
        }).then(response => {
            this.patients = response.data;
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
        showExaminations: function(){
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
                    endTime: this.endTime,
                    pharmacyID: this.selectedPharmacyID,
                    patientEmail: this.selectedPatient
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
                        alert(response);
                    })
        },
        pokusaj: function(e){
           console.log(e.target.value)
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
    .dropdown_style{
        width: 14%;
        position: fixed;
        left: 54.8%;
    }
    .table_style{
        height:45px;
        width:700px;
        position: fixed;
        top: 25%;
        left: 50px;
        z-index: 999;
    }
    .input_style{
        width: 14%;
        border-bottom: 3px solid #17a2b8;
        border: 1px solid #17a2b8;
        position: fixed;
        left: 49.8%;
        top: 36%;
        margin-left: 5%;
        margin-top: 1% !important;
        margin-bottom: 1% !important;
        height: 5%;
        border-radius: 7%;
    }
    
</style>