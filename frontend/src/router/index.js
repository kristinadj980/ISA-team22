import Vue from 'vue'
import VueRouter from 'vue-router'
import BootstrapVue from "bootstrap-vue";
import { ValidationObserver, ValidationProvider, extend } from 'vee-validate';
import * as rules from 'vee-validate/dist/rules';
import Home from '../views/Home.vue'
import Login from '../views/SystemAdmin/Login.vue'
import DermatologyRegistration from '../views/SystemAdmin/DermatologyRegistration.vue'
import HomePage from '../views/SystemAdmin/HomePage.vue'
import ProfileData from '../views/SystemAdmin/ProfileData.vue'
import PharmacyRegistration from '../views/SystemAdmin/PharmacyRegistration.vue'
import SupplierRegistration from '../views/SystemAdmin/SupplierRegistration.vue'
import DermatologistHomepage from '../views/dermatologistView/DermatologistHomepage.vue'
import DermatologistProfile from '../views/dermatologistView/DermatologistProfile.vue'
import SystemAdminRegistration from '../views/SystemAdmin/SystemAdminRegistration.vue'
import Registration from '../views/SystemAdmin/Registration.vue'
import DermatologistAbsenceRequest from '../views/dermatologistView/DermatologistAbsenceRequest.vue'
import DermatologistExamination from '../views/dermatologistView/DermatologistExamination.vue'
import DermatologistNewExamination from '../views/dermatologistView/DermatologistNewExamination.vue'
import DermatologistPatients from '../views/dermatologistView/DermatologistPatients.vue'
import DermatologistWorkCalendar from '../views/dermatologistView/DermatologistWorkCalendar.vue'

Vue.use(BootstrapVue)
Vue.use(VueRouter)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


Object.keys(rules).forEach(rule => {
  extend(rule, rules[rule]);
});

Vue.component('ValidationObserver', ValidationObserver);
Vue.component('ValidationProvider', ValidationProvider);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {

    path: '/homePage',
    name: 'HomePage',
    component: HomePage
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/registration',
    name: 'Registration',
    component: Registration
  },
  {
    path: '/systemAdminRegistration',
    name: 'SystemAdminRegistration',
    component: SystemAdminRegistration
  },
  {
    path: '/dermatologyRegistration',
    name: 'DermatologyRegistration',
    component: DermatologyRegistration
  },
  {
    path: '/pharmacyRegistration',
    name: 'PharmacyRegistration',
    component: PharmacyRegistration
  },
  {
    path: '/supplierRegistration',
    name: 'SupplierRegistration',
    component: SupplierRegistration
  },
  {
    path: '/profileData',
    name: 'ProfileData',
    component: ProfileData
  },
  {
    path: '/dermatologistHomepage',
    name: 'DermatologistHomepage',
    component: DermatologistHomepage
  },
  {
    path: '/dermatologistProfile',
    name: 'DermatologistProfile',
    component: DermatologistProfile
  },
  {
    path: '/dermatologistAbsenceRequest',
    name: 'DermatologistAbsenceRequest',
    component: DermatologistAbsenceRequest
  },
  {
    path: '/dermatologistExamination',
    name: 'DermatologistExamination',
    component: DermatologistExamination
  },
  {
    path: '/dermatologistNewExamination',
    name: 'DermatologistNewExamination',
    component: DermatologistNewExamination
  },
  {
    path: '/dermatologistPatients',
    name: 'DermatologistPatients',
    component: DermatologistPatients
  },
  {
    path: '/dermatologistWorkCalendar',
    name: 'DermatologistWorkCalendar',
    component: DermatologistWorkCalendar
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router


