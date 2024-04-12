<script setup>

import Navigate from "@/users/navigatebar/navigateBar.vue";
</script>

<template>
  <Navigate/>
  <div id="container3">
    <h2>View All Trainers</h2>
    <ul class="trainer-list">
      <li class="trainer-item" onclick="viewTrainerProfile('Trainer 1')">Trainer 1</li>
      <li class="trainer-item" onclick="viewTrainerProfile('Trainer 2')">Trainer 2</li>
      <li class="trainer-item" onclick="viewTrainerProfile('Trainer 3')">Trainer 3</li>
      <!-- Additional trainers here -->
    </ul>
  </div>

</template>

<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}
#container3 {
  text-align: left;
  max-width: 1200px;
  margin: 200px auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
}
h2 {
  text-align: center;
}
.trainer-list {
  list-style-type: none;
  padding: 0;
}
.trainer-item {
  margin-bottom: 20px;
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 5px;
}
.trainer-item:hover {
  background-color: #f0f0f0;
  cursor: pointer;
}
</style>