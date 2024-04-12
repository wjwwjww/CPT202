import { createApp } from 'vue'
import App from './App.vue'

import router from '@/router'

// import * as Vue from 'vue' // in Vue 3
import axios from 'axios'
// Vue.prototype.$axios = axios
// Vue.prototype.$axios = axios


import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'





const app = createApp(App);

app.config.globalProperties.$axios = axios;

app.component('VueDatePicker', VueDatePicker);

// app.mount('#app');


app.use(router).mount('#app')
