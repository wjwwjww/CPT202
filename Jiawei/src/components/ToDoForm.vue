<script>
export default {
methods:{
  onSubmit() {
    if(this.label === "") {
      return;
    }
    this.$emit('todo-added', this.label);
  }

},
  data(){
  return{
    label:"",
  }
  }
}
</script>

<template>
<form @submit="onSubmit" @submit.prevent="onSubmit">
  <label for="new-todo-input">What's need to be done?</label>
  <input type="text" id="new-todo-input" name="new-todo-input" v-model.lazy.trim="label" autocomplete="off" />
  <button type="submit">Add</button>
</form>
</template>

<style scoped>

</style>