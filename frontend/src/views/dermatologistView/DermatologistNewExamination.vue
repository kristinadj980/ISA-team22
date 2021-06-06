<template
 img-src="https://st2.depositphotos.com/3470617/6425/v/950/depositphotos_64252163-stock-illustration-medical-icons-seamless-pattern.jpg">
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
        <b-card 
        style=" background: #e6f9fc; 
        position: fixed;
        top: 9%;
        width: 100%;
        height: 100%;
        max-width: 100%;"
        >
        <h4 class="ml-n mt-6 strong text-left" style="color: #17a2b8;"><b>Choose existing examination</b></h4>
            <div style="width:44%; 
            height:63%;
            border:2px 
            solid #17a2b8; 
            background-color: #ffffff;
            border:2px solid #17a2b8; ">
                <h5 
                class="ml-n mt-6 strong text-left" 
                style="margin-bottom:8%; 
                margin-left: 2% !important; 
                margin-top: 1% !important;">
                    <b> 
                        Search or chooese patient from list:
                    </b>
                </h5>
                <input 
                list="my-list-id" 
                v-model="selectedPatientE1" 
                class="input_style" 
                placeholder="Enter patient"
                style="margin-top: 1% !important;">
                    <datalist id="my-list-id">
                        <option v-for="patient in patients" v-bind:key="patient.id">
                            {{ patient.name }} {{patient.surname}} | {{patient.email}} 
                        </option>
                    </datalist>
                <h5 class="ml-n mt-6 strong text-left" style="margin-left: 2% !important; margin-top: 12% !important;">
                    <b> 
                        Select pharmacy for examination:
                    </b>
                </h5>
                <div
                style="position:fixed;
                margin-left: 16% !important;
                margin-top: 0.5% !important;"
                >
                    <b-button size="sm" pill variant="outline-info" @click="makeToast('warning')" class="mb-2">
                        <b>?</b>
                    </b-button>
                </div>
                <b-dropdown 
                text="Select pharmacy" 
                variant="outline-info" 
                class="dropdown_style" 
                id="dropdown-divider">
                    <b-dropdown-item  
                    v-for="pharm in pharmacies" v-bind:key="pharm.id" :value="pharm.id"
                    @click="selectedPharmacyIDE1 = pharm.id, selectedPharmacyNameE1 = pharm.name, filteredScheduledExaminations(pharm.id)">
                        {{ pharm.name}}
                    </b-dropdown-item>
                </b-dropdown>
                <p class="ml-n mt-6 strong chosen"
                style="width: 14%;
                position: fixed;
                left: 18%;
                top: 38%; 
                margin-left: 2%;">
                     <b>
                         Selected pharmacy: {{ selectedPharmacyNameE1 }}
                    </b>
                <h5 class="ml-n mt-6 strong text-left" style="margin-left: 2% !important;  margin-top: 15% !important;"><b> Select one date from the list:</b></h5>
                <select
                multiple = "true" 
                text="Select date" 
                variant="outline-info" 
                class="dropdown_style" 
                id="dropdown-divider"
                style="margin-top: 8% !important;">
                    <option
                    v-for="examination in examinations" v-bind:key="examination.id" :value="examination.id"
                    @click="selectedExamination = examination">
                        {{ format_date(examination.startDate)}} | {{ examination.startTimeText}} - {{ examination.endTimeText}}
                    </option>
                </select>
                
                <b-button 
                    class="btn btn-info btn-lg space_style object_space" 
                    style="background-color:#17a2b8; width:16.3cm; margin-top: 17% !important;" 
                    v-on:click = "scheduleSelectedExamination">
                    Schedule
                </b-button>
            </div>  
            <div style="position: fixed;
            width:44%;
            height:75%; 
            border:2px solid #17a2b8; 
            background-color: #ffffff; 
            left:52%;
            top: 16%;">
            <div class="vl"></div>
            <h4 class="ml-n mt-6  text_position" style="color: #17a2b8;"><b>Schedule new examination</b></h4>
            <div style="position: fixed;
                    top: 18%; 
                    max-width: 100%;
                    left: 910px;
                    height: 450px;
                    width: 40%;
                    max-width: 100%;">
                    <h5 class="ml-n mt-6 strong text-left" style="margin-bottom:8%; margin-top: 2% !important;"><b> Search or chooese patient from list:</b></h5>
                    <input list="my-list-id" v-model="selectedPatient" style=" width: 14%;
                    border: 3px solid #17a2b8;
                    position: fixed;
                    left: 48.5%;
                    top: 22%;
                    margin-left: 5%;
                    margin-top: 1% !important;
                    margin-bottom: 1% !important;
                    height: 5%;
                    border-radius: 7%;" placeholder="      Enter patient">
                    <datalist id="my-list-id">
                        <option v-for="patient in patients" v-bind:key="patient.id">
                            {{ patient.name }} {{patient.surname}} | {{patient.email}} 
                        </option>
                    </datalist>
                    <h5 class="ml-n mt-6 strong text-left" style="margin-top: 10% !important;"><b> Select pharmacy for examination:</b></h5>
                    <b-dropdown text="Select pharmacy" variant="outline-info" style="width: 14%;
                    position: fixed;
                    left: 53.5%;" id="dropdown-divider">
                            <b-dropdown-item  
                            v-for="pharm in pharmacies" v-bind:key="pharm.id" :value="pharm.id"
                            @click="selectedPharmacyID = pharm.id, selectedPharmacyName = pharm.name">
                                {{ pharm.name}}
                             </b-dropdown-item>
                    </b-dropdown>
                    <p class="ml-n mt-6 strong chosen"
                    style="width: 14%;
                    position: fixed;
                    left: 68%;
                    top: 36%; 
                    margin-left: 2%;">
                        <b>
                            Selected pharmacy: {{ selectedPharmacyName }}
                        </b>
                    <span></span>
                    <h5 class="ml-n mt-6 strong text-left" style="margin-top:10%"><b>Select date of examination</b></h5>
                    <b-form-input type="date" class="object_space" v-model="startDate" filled placeholder="Enter date of examination"></b-form-input>
                    <h5 class="ml-n mt-6 strong text-left" ><b>Select start time of examination</b></h5>
                    <b-form-input type="time" class="object_space" v-model="startTime" filled placeholder="Start time of examination"></b-form-input>
                    <h5 class="ml-n mt-6 strong text-left"><b>Select end time of examination</b></h5>
                    <b-form-input type="time" class="object_space" v-model="endTime" filled placeholder="End time of examination"></b-form-input>
                    
                    <b-button class="btn btn-info btn-lg space_style object_space" style="background-color:#17a2b8; width:18cm;" v-on:click = "scheduleExamination">Schedule</b-button>
            </div>
        </div>
        </b-card>
    </div>
</template>

<script>
import moment from 'moment'
export default {
    name: 'DermatologistNewExamination',
    data() {
    return {
        selectedExamination: "",
        examinations : [''],
        startDate: null,
        startTime: null,
        endTime: null,
        startTimeText: "",
        endTimeText: "",
        pharmacies: [''],
        selectedPharmacyID: '',
        selectedPharmacyIDE1: '',
        selectedPharmacyName: "",
        selectedPharmacyNameE1: "",
        patients:[''],
        selectedPatient: [''],
        selectedPatientE1: [''],
        }
    },
    mounted(){
        let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.freeScheduledExaminations();

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
            window.location.href = "/dermatologistExamination/-1";
        },
        showNewExamination: function(){
            window.location.href = "/dermatologistNewExamination";
        },
        logOut : function(){
            localStorage.removeItem('token');
            window.location.href = "/login";

        }, 
        format_date(value){
         if (value) {
           return moment(String(value)).format('YYYY-MM-DD')
          }
        },
        format_time(value){
         if (value) {
                return moment(String(value)).format('HH:mm')
            }
        },
        scheduleExamination : function(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            if(this.selectedPatient == ""){
                alert("Please choose patient for examination.")
                return;
            }
            if(this.selectedPharmacyID == ""){
                alert("Please choose pharmacy for examination.")
                return;
            }
            if(this.startDate == null){
                alert("Please choose date for examination.")
                return;
            }
            if(this.startTime == null){
                alert("Please choose start time for examination.")
                return;
            }
            if(this.endTime == null){
                alert("Please choose end time for examination.")
                return;
            }
            
            const newExamination = {
                pharmacyID: this.selectedPharmacyID,
                startDate: this.startDate,
                startTime : this.startTime,
                endTime: this.endTime,
                patientInfo: this.selectedPatient
            };
            this.axios.post('/examination/dermatologistSchedule',newExamination, { 
                headers: {
                    'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    alert(response.data)
                        console.log(response);
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        },
        freeScheduledExaminations : function() {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            this.axios.get('/examination/getFreeScheduled',{ 
                headers: {
                    'Authorization': 'Bearer ' + token,
                }
                }).then(response => {
                    this.examinations = response.data;
                }).catch(res => {
                    alert("Error");
                    console.log(res);
                })
        },
        scheduleSelectedExamination : function() {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            if(this.selectedExamination.examinationID == null){
                alert("Please choose one of examinations.")
                return;
            }
            if(this.selectedPatientE1 == ""){
                alert("Please choose patient for examination.")
                return;
            }
            const newExamination = {
                examinationID: this.selectedExamination.examinationID,
                patientInfo: this.selectedPatientE1
            };
            this.axios.post('/examination/updateScheduledExamination',newExamination, { 
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
        makeToast(variant = null) {
            this.$bvToast.toast('If you choose pharmacy, the list of free dates will be only in the selected pharmacy.'+
            ' If you do not choose it will list free terms in all pharmacies that you work.', {
            title: `About pharmacy selection`,
            variant: variant,
            solid: true
            })
        },
        filteredScheduledExaminations: async function(pharmacyId){
            if(this.examinations.length == 0){
                this.freeScheduledExaminations();
            }
            let examinationsFiltered = [];
            for(let i in this.examinations){
                let ex = this.examinations[i];
                if(ex.pharmacyID == pharmacyId){
                    examinationsFiltered.push(ex);
                }
            } 
            this.examinations =examinationsFiltered;
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
        height: 380px;
        position: fixed;
        top: 18%;
        left: 810px;
        z-index: 999;
        max-width: 100%;
    }

    .object_space {
        margin-top: 2% !important;
        margin-bottom: 2% !important;
    }
    .dropdown_style{
        width: 14%;
        position: fixed;
        left: 0.5%;
        top: 37%; 
        margin-left: 2%;
    }
    .table_style{
        height:45px;
        width:720px;
        position: fixed;
        top: 25%;
        left: 48px;
        z-index: 999;
    }
    .input_style{
        width: 14%;
        border: 3px solid #17a2b8;
        position: fixed;
        left: 0%;
        top: 22%;
        margin-left: 2.5%;
        margin-top: 1% !important;
        margin-bottom: 1% !important;
        height: 5%;
        border-radius: 7%;
    }
    .text_position{
        position: fixed;
        left: 49%;
        top: 9.5%;
        margin-left: 3%;
        margin-top: 1% !important;
        margin-bottom: 1% !important;
        height: 5%;
    }
    
</style>