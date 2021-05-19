<template>
    <div id="dermatologistExamination">
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
        <div>
            <div style="left:0">
                <h4 class="text-left text_postion">Please choose one of the options to continue:</h4>
                <b-radio-group v-model="selected"  class="text-left text_postion">
                    <b-radio value="1" >Start examination</b-radio>
                    <b-radio value="2" >Patient didn't come to examination!</b-radio>
                </b-radio-group>
            </div>
            <b-tabs  v-model="tabIndex" card>
                <b-tab title="Enter examination data" v-if="selected == 1">I'm the first fading tab</b-tab>
                <b-tab title="Unsustainable examination" v-else-if="selected == 2" >I'm the first ddddddddddddddddddddddddddddddddddfading tab</b-tab>
                <b-tab title="Please choose one of the options!" v-else disabled></b-tab>
            </b-tabs>
        </div>
    </div>
</template>

<script>
export default {
    name: 'DermatologistExamination',
     data() {
      return {
        selectedRowExamination: '',
        examinationID: '',
        selected: 0,
      }
    },
    mounted () {
        this.examinationID = this.$route.params.selectedExamination;
        

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
        searchPatient : function(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            
            const patientForSearch = {
                examinationID: this.selected.examinationID
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

    .text_postion{
        margin-left:2%;
        margin-top:1%;
        margin-bottom:1%;
    }
</style>