<script>
export default {
  name: 'NavigateBar', // Wrap the component name in quotes
}
</script>

<template>
  <nav id="navbar">
    <ul>
      <li>
        <router-link to="/home">Home</router-link>
      </li>
      <li>
        <router-link to="/customer">Appointment</router-link>
      </li>
      <li><router-link to="/trainers">Trainers</router-link></li>
      <!-- Add other navigation items as needed -->
    </ul>
  </nav>
</template>

<style>
#navbar {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  background-color: #333;
  padding: 10px 20px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  z-index: 2;
  text-align: left;
}

#navbar ul {
  list-style: none;
  padding: 0;
}

#navbar li {
  display: inline;
  margin-right: 20px;
}

#navbar li:last-child {
  margin-right: 0;
}

#navbar a {
  color: #fff;
  text-decoration: none;
  font-weight: bold;
}
</style>
