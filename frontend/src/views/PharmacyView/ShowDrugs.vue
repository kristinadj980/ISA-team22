<template>
    <div id="showDrugs">
        <div style="background: white; height: 60px; margin-top: 20px">
          <h4 class="text-left"
        style="margin-left:2%;
        margin-top:1%;">
        <b>Drug search:</b>
        </h4>
        <div
        style="margin-top: 2%;
        margin-left: 2%;">
            <b-form inline>
                <b-form-input
                v-model="drugName"
                class="mb-2 mr-sm-2 mb-sm-0"
                placeholder="Drug name"
                ></b-form-input>
                <b-button style="margin-left:2%;" v-on:click = "searchDrug" variant="info">Search</b-button>
                <b-button style="margin-left:2%;" >Refresh</b-button>
            </b-form>
        </div>  
        </div>
    </div>
</template>

<script>
export default {
    name: 'ShowDrugs',
     data() {
    return {
       drugs :[],
       drugName : "",
    }
  },
  mounted() {
       this.getDrugs()
    },
  methods:{
        getDrugs : function() {
          let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
          this.drugs = []
          this.axios.get('/drug/getdrugs',{ 
             headers: {
                 'Authorization': 'Bearer ' + token,
             }
         }).then(response => {
             this.isAuthorized = true;
             this.drugs=response.data;
         }).catch(res => {
                this.isAuthorized = false;
                //alert("Please, log in first!");
                //window.location.href = "/login";
                console.log(res);
            });
      },
      searchDrug : function(){
            let token = localStorage.getItem('token').substring(1, localStorage.getItem('token').length-1);
            if(this.drugName == ""){
                alert("Please enter name!")
                return;
            }
            const drugForSearch = {
                name: this.drugName,
            };
            this.axios.post('/drug/searchDrug',drugForSearch, { 
                headers: {
                'Authorization': 'Bearer ' + token,
                }})
                .then(response => {
                    this.drugs = response.data;
                    /*this.fields = [
                    { key: 'name', sortable: true },
                    { key: 'surname', sortable: true },
                    ];*/
                    alert("Uspesno")
                })
                .catch(response => {
                    alert("Please, try later.")
                    alert(response);
                })
        },
     
      },
    
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