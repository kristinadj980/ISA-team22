import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from "bootstrap-vue";
import 'bootstrap/dist/css/bootstrap.min.css'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)
Vue.use(BootstrapVue)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.prototype.$axios = axios;
Vue.config.productionTip = false

const baseURL = 'http://localhost:8081/api';
if (typeof baseURL !== 'undefined') {
  Vue.axios.defaults.baseURL = baseURL;
}

/*const baseURL2 = 'http://localhost:8080/api';
if (typeof baseURL2 !== 'undefined') {
  Vue.axios.defaults.baseURL = baseURL2;
}*/

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
