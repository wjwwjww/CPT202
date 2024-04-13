<template>
  <div id="manage">
  <div>
    <p>Links to shop manager functions:</p>
    <ul>
      <li>Appointments management</li>
      <li>Trainer management</li>
      <li>Notification</li>
      <li>Statistical report</li>
    </ul>

    <h1>Appointments Modification:</h1>
    <form id="appointmentForm" @submit.prevent="submitForm">
      Appointment ID: <input type="text" v-model="appointmentId" /><br />
      Customer: <input type="text" v-model="customer" /><br />
      Trainer: <input type="text" v-model="trainer" /><br />
      Status: <input type="text" v-model="status" /><br />
      Rating: <input type="text" v-model="rating" /><br />
      Time: <input type="text" v-model="time" /><br />
      <button type="submit">APPLY</button>
    </form>


    <h1>Appointments Management</h1>
    <table>
      <thead>
      <tr>
        <th>Overall details:</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>Total Number of Appointments in Recent One Month:</td>
        <td>"amount"</td>
      </tr>
      <tr>
        <td>Average Number of Appointments Per Trainer in Recent One Month:</td>
        <td>"amount"</td>
      </tr>
      <tr>
        <td>Average Rating in Recent One Month</td>
        <td>"average star"</td>
      </tr>
      </tbody>
    </table>
    <p>
     Details:
    </p>

    <table>
      <thead>
      <tr>
        <th>Appointment ID</th>
        <th>Customer</th>
        <th>Trainer</th>
        <th>Status</th>
        <th>Rating</th>
        <th>Time</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>A0001</td>
        <td>customer1</td>
        <td>trainer1</td>
        <th>COMPLETE</th>
        <td>5</td>
        <td>Feb 30 2024 12:00~13:00</td>
      </tr>
      </tbody>
    </table>

    <h1>Trainter Ranking Modification:</h1>
    <div>
      <form>
        <!-- Form content -->
      </form>
      <p>Trainer's Recent Appointments:</p>
      <h1>Trainter Ranking Modification:</h1>
      <form>
        Trainer ID: <input type="text" /><br />
        Modification Type: <select name="Modification Type">
        <option value="Promote">Promote</option>
        <option value="Demote">Demote</option>
      </select><br />
        Target Rating: <select name="Target Rating">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select><br />
        <input type="submit" value="APPLY"/>
      </form>
      <p>Trainer's Recent Appointments: </p>
      <table>
        <thead>
        <tr>
          <th>Appointment ID</th>
          <th>Customer</th>
          <th>Trainer</th>
          <th>Status</th>
          <th>Rating</th>
          <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>A0001</td>
          <td>customer1</td>
          <td>trainer1</td>
          <th>COMPLETE</th>
          <td>5</td>
          <td>Feb 30 2024 12:00~13:00</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  </div>
</template>

<script>

</script>

<style>
/* Styles for the main container */
#manage {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
#appointmentForm {
  font-family: Arial, sans-serif; /* 设置字体 */
  max-width: 400px; /* 设置表单的最大宽度 */
  margin: 0 auto; /* 居中显示 */
}

/* 设置输入框的样式 */
#appointmentForm input {
  width: 100%; /* 输入框宽度填满父容器 */
  padding: 10px; /* 内边距 */
  margin-bottom: 15px; /* 底部外边距 */
  border: 1px solid #ccc; /* 边框 */
  border-radius: 5px; /* 边框圆角 */
  box-sizing: border-box; /* 盒模型 */
}

/* 设置按钮的样式 */
#appointmentForm button {
  width: 100%; /* 按钮宽度填满父容器 */
  padding: 10px; /* 内边距 */
  border: none; /* 去掉边框 */
  border-radius: 5px; /* 边框圆角 */
  background-color: #007bff; /* 背景颜色 */
  color: #fff; /* 文字颜色 */
  cursor: pointer; /* 鼠标样式为手型 */
}

/* 鼠标悬停时按钮的样式 */
#appointmentForm button:hover {
  background-color: #0056b3; /* 悬停时的背景颜色 */
}
#manage input{
  width:auto;
}

/* Styles for headings */
h1 {
  font-size: 24px;
  margin-bottom: 10px;
}

/* Styles for form inputs */
input[type="text"],
select {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

/* Styles for buttons */
button,
input[type="submit"] {
  background-color: #007bff;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover,
input[type="submit"]:hover {
  background-color: #0056b3;
}

/* Styles for tables */
table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

table th,
table td {
  padding: 8px;
  border: 1px solid #ddd;
  text-align: left;
}

table th {
  background-color: #f2f2f2;
}

/* Styles for lists */
ul {
  list-style-type: none;
  padding-left: 0;
}

ul li {
  margin-bottom: 5px;
}


/* Additional custom styles can be added as needed */</style>
