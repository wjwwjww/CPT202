<template>
  <div>
<!--   <login></login>-->
<!--    <router-link to="/register">No account, register</router-link>-->

  <router-view></router-view>
  </div>
</template>

<script>
// import login from './users/loginPage.vue'
// import register from './users/registerPage.vue'



// Vue.use(VueRouter);

// import LoginPage from "@/users/loginPage.vue";

export default {
 name:'App',
  components: {
    // LoginPage
    // login,
  },

}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>