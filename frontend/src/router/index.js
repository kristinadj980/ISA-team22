import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/SystemAdmin/Login.vue'
import DermatologyRegistration from '../views/SystemAdmin/DermatologyRegistration.vue'
import HomePage from '../views/SystemAdmin/HomePage.vue'
import ProfileData from '../views/SystemAdmin/ProfileData.vue'
import PharmacyRegistration from '../views/SystemAdmin/PharmacyRegistration.vue'
import SupplierRegistration from '../views/SystemAdmin/SupplierRegistration.vue'
import DermatologistHomepage from '../views/dermatologistView/DermatologistHomepage.vue'
import DermatologistProfile from '../views/dermatologistView/DermatologistProfile.vue'
import Registration from '../views/SystemAdmin/Registration.vue'

Vue.use(VueRouter)

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
    path: '/systemAdminRegistration',
    name: 'Registration',
    component: Registration
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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
