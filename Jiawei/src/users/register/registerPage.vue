<template>

  <button @click="toterms">register</button>

</template>
<script>
export default {
  methods:{
    toterms(){
      this.$router.push("/terms")
    }
  }
}

</script>