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
            <b-tabs card>
                <b-tab title="Begin with examination" v-if="selected == 1" @click="getPatientValidDrugs">
                    <b-row class="mt-2">
                        <b-col sm="3">
                        <h3 for="textarea-large" class="text-left" style="font-size:18px">Enter information about examination:</h3>
                        
                        </b-col>
                        <b-col sm="12">
                        <b-form-textarea
                            id="textarea-large"
                            size="lg"
                            v-model="examinationInfo"
                            placeholder="type here.."
                        ></b-form-textarea>
                        </b-col>
                    </b-row>
                    <table class="table table-striped" style="width:100%; border-bottom:solid;">
                            <thead class="thead-light">
                                <tr>
                                <th scope="col" 
                                v-for="f in fields" v-bind:key="f.key" >
                                    {{f.label}}
                                </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="drug in drugs" v-bind:key="drug.id">
                                <td>{{drug.name}}</td>
                                <td>{{drug.type}}</td>
                                <td>{{drug.drugForm}}</td>
                                <b-button 
                                variant="info" 
                                style="margin-top:1%;" 
                                v-on:click="getDrugSpecification(drug.id)" 
                                @click="selectedDrug = drug"
                                v-b-modal.modal-1>drug specification</b-button>
                                </tr>
                            </tbody>
                        </table>
                        <b-modal ref="modal-ref" id="modal-1" title="Drug specification" hide-footer>
                          <div class="drug_info">
                            <h4>Drug : <u>{{selectedDrug.name}}</u></h4>
                            <h4>Possible contra indication : <u>{{drugSpecification.contraIndications}}</u></h4>
                            <h4>Composition : <u>{{drugSpecification.composition}}</u></h4>
                            <h4>Manufacturer : <u>{{drugSpecification.manufacturer}}</u></h4>
                        </div>
                        <h4 style="margin-top:20px;">Specify the length of therapy (in days): </h4>
                        <b-form-input 
                        type="number" 
                        class="object_space" 
                        v-model="terapyDuration" 
                        filled 
                        placeholder="terapy duration"
                        style="margin-top:10px; font-size:16px;">
                        </b-form-input>
                        <b-row style="float: left; margin: 30px;">
                            <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "checkDrugAvailability">Check drug availability</b-button>
                            <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "cancel">Cancel</b-button>
                            <b-button class="btn btn-info btn-lg space_style" style="background-color:#003d66; width:5cm;" v-on:click = "updatePassword">Update</b-button>
                        </b-row>
                        </b-modal>
                </b-tab>
                <b-tab title="Unsustainable examination" v-else-if="selected == 2" >
                    <h3  class="text-left"
                    style="margin-left:1%;
                    margin-top:1%;">Please, confirm once more:</h3>
                    <b-form-checkbox
                    id="checkbox-1"
                    v-model="confirmation"
                    name="checkbox-1"
                    value="1"
                    size="lg"
                    unchecked-value="not_accepted"
                    class="text-left"
                    style="margin-left:28%;
                    margin-top:-2.5%;"
                    >
                    I confirm.
                    </b-form-checkbox>
                    <button 
                    class="button"
                    style="
                    margin-top:0%;
                    width: 20%;"
                    v-on:click = "patientDidntShow"> finish examination</button>
                    
                </b-tab>
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
        examination: [],
        confirmation: 0,
        examinationInfo: "",
        fields: [
          { key: 'drugName', label: 'Drug name' },
          { key: 'type', label: 'Drug type' },
          { key: 'form', label: 'Drug form' },
          {label: 'Open specification'}
        ],
        drugs: [],
        drugSpecification: [],
        terapyDuration: '',
        selectedDrug: [],

      }
    },
    mounted () {
        this.examinationID = this.$route.params.selectedExamination;
        let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
        
        this.axios.get('/examination/getExaminationById',this.$route.params.selectedExamination,{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
               this.examination = response.data;
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
        patientDidntShow : function() {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            
            const examinationInfo = {
                examinationID: this.examinationID
            };
            this.axios.post('/examination/absenceRegister',examinationInfo, { 
                headers: {
                'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    alert(response);
                    this.$bvToast.toast('The patients absence was registered.', {
                    variant: 'warning',
                    title: 'INFO',
                    solid: true
                    })
                   
                })
                .catch(response => {
                    alert("Please, try agen.")
                    alert(response);
                })
        },getPatientValidDrugs: function() {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

            const patientForSearch = {
                id: this.$route.params.selectedExamination
            };
            this.axios.post('/drug/getdrugsForPatient',patientForSearch ,{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
            }).then(response => {
                this.drugs = response.data;
            }).catch(res => {
                        alert("Error");
                            console.log(res);
                    });
        },getDrugSpecification: function(drugID) {
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);

            const drugSpec = {
                id: drugID,
            };
            this.axios.post('/drug/getOnlyDrugSpecification',drugSpec ,{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
            }).then(response => {
                this.drugSpecification = response.data;
            }).catch(res => {
                        alert("Error");
                            console.log(res);
                    });
        }, checkDrugAvailability: function() {

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

    .text_postion{
        margin-left:2%;
        margin-top:1%;
        margin-bottom:1%;
    }
.button {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #17a2b8;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #74b6c0}

.button:active {
  background-color: #17a2b8;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

.drug_info {
    background: #b1ced3; 
    border-left-style: solid;
    border-color: #17a2b8;
    border-width: 8px;
}

.drug_info {
    background: #b1ced3; 
    border-left-style: solid;
    border-color: #17a2b8;
    border-width: 8px;
    padding-top:10px;
    padding-bottom:10px;
    padding-left:1px;
}

</style>