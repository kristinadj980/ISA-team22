<template>
    <div id="dermatologistPatients">
        <div class="homepage_style ">
           <span style="float: left; margin: 15px;">
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
        <h4 class="text-left"
        style="margin-left:2%;
        margin-top:1%;">
        <b>Patient search:</b>
        </h4>
        <div
        style="margin-top: 2%;
        margin-left: 2%;">
            <b-form inline>
                <b-form-input
                v-model="nameForSerch"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Patient name"
                ></b-form-input>
                <b-form-input 
                v-model="surnameForSearch"
                placeholder="Patient last name">
                </b-form-input>
                <b-button style="margin-left:2%;" v-on:click = "searchPatient" variant="info">Search</b-button>
                <b-button style="margin-left:2%;" v-on:click = "init" variant="info">Refresh</b-button>
            </b-form>
        </div>  
        <div style="height:25px"></div>
            <h3>Patients</h3>
                <b-table :items="patients" :fields="fields"
                :sort-by.sync="sortBy"
                :sort-desc.sync="sortDesc"
                responsive="sm" class="table table-striped table-bordered table-info">
                </b-table>
            
            <div> 
            </div>
    </div>
</template>

<script>
import moment from 'moment'
export default {
    name: 'DermatologistPatients',
    data() {
      return {
        sortBy: 'age',
        sortDesc: false,
        fields: [
          { key: 'name', sortable: true },
          { key: 'surname', sortable: true },
          { key: 'email', sortable: true },
          { key: 'startDate', sortable: true },
          { key: 'startTime', sortable: true },
        ],
        patients: [],
        name: "",
        surname: "",
        email: "",
        nameForSerch: "",
        surnameForSearch: ""
      }
    },
    mounted(){
        let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        this.axios.get('/dermatologist/myPatients',{ 
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
        format_date(value){
         if (value) {
           return moment(String(value)).format('YYYY-MM-DD')
          }
        },
        searchPatient : function(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            if(this.nameForSerch == null || this.surnameForSearch == null){
                alert("Please enter name and last name!")
                return;
            }
            const patientForSearch = {
                name: this.nameForSerch,
                surname: this.surnameForSearch
            };
            this.axios.post('/dermatologist/searchMyPatient',patientForSearch, { 
                headers: {
                'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    this.patients = response.data;
                    this.fields = [
                    { key: 'name', sortable: true },
                    { key: 'surname', sortable: true },
                    ];
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        },
        init() {
         window.location.reload();   
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