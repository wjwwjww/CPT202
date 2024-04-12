import {createRouter, createWebHistory} from "vue-router"



import LoginPage from "@/users/login/loginPage.vue";
import RegisterPage from "@/users/register/registerPage.vue";
import HomePage from "@/users/home/homePage.vue";
import CustomerPage from "@/users/customer/customerPage.vue";
import termsPage from "@/users/register/termsPage.vue";
import EmailPage from "@/users/register/emailPage.vue";
import passwordPlan from '@/users/register/passwordPage.vue';
import fitnessPage from '@/users/register/fitnessPlan.vue';
import viewPage from '@/users/account/viewAppointmentPage.vue'
import feedbackPage from '@/users/account/feedbackPage.vue'
import trainersPage from '@/users/trainers/trainersPage.vue'

const routes = [
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/login',
        component: LoginPage
    },
    {
    path:'/register',
    component: RegisterPage
},
    {
        path:'/home',
        component: HomePage
    },
    {
        path:'/customer',
        component: CustomerPage
    },
    {
        path:'/terms',
        component: termsPage
    },
    {
        path:'/email',
        component: EmailPage
    },
    {
        path:'/passwordPlan',
        component: passwordPlan

    },
    {
        path:'/fitness',
        component: fitnessPage
    },
    {
        path:'/viewappointment',
        component: viewPage
    },
    {
      path: '/feedback',
        component: feedbackPage
    },
    {
        path: '/trainers',
        component: trainersPage
    }


];

const router=createRouter({
    history: createWebHistory(),
    routes,

})



export default router