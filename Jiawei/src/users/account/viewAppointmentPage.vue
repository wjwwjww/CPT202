<script>
export default {
  name: 'AppointmentPage',
  methods: {
    makeChanges() {
      this.$router.push('/feedback');
    }
  }
}
</script>

<template>
  <div id="container1">
    <h2>My Appointments</h2>
    <ul class="appointment-list">
      <li class="appointment-item">
        <strong>Appointment ID:</strong> 001<br>
        <strong>Date:</strong> April 20, 2024<br>
        <strong>Trainer:</strong> John Doe<br>
        <button class="btn" @click="makeChanges">Make Changes</button>
      </li>
      <li class="appointment-item">
        <strong>Appointment ID:</strong> 002<br>
        <strong>Date:</strong> April 19, 2024<br>
        <strong>Trainer:</strong> John Doe<br>
        <button class="btn" @click="makeChanges">Make Changes</button>
      </li>
      <li class="appointment-item">
        <strong>Appointment ID:</strong> 003<br>
        <strong>Date:</strong> April 18, 2024<br>
        <strong>Trainer:</strong> John Doe<br>
        <button class="btn" @click="makeChanges">write rewiews</button>
      </li>
      <!-- Additional appointment items here -->
    </ul>
  </div>

</template>

<style scoped>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}
#container1{
  max-width: 800px;
  margin: 50px auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
}
h2 {
  text-align: center;
}
.appointment-list {
  list-style-type: none;
  padding: 0;
}
.appointment-item {
  margin-bottom: 20px;
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 5px;
}
.btn {
  padding: 5px 10px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
.btn:hover {
  background-color: #45a049;
}
</style>