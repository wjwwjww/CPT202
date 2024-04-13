<template>
  <div>
    <p>Hi customer</p>
    <img id="avatar" src="src/assets/img.png">
    <template v-if="!editMode">
      <p>Username: {{ userInfo.username }}</p>
      <p>Email: {{ userInfo.email }}</p>
      <p>Phone: {{ userInfo.phone }}</p>
      <p>City: {{ userInfo.city }}</p>
      <button @click="editMode = true">Change</button>
    </template>
    <template v-else>
      <p>Username: <input type="text" v-model="userInfo.username"></p>
      <p>Email: <input type="email" v-model="userInfo.email"></p>
      <p>Phone: <input type="tel" v-model="userInfo.phone"></p>
      <p>City: <input type="text" v-model="userInfo.city"></p>
      <button @click="saveChanges">Save Changes</button>
    </template>
    <div id="planinfo">
      <p>Plan Information</p>
      <p>Plan: {{ planInfo.plan }}</p>
      <p>Start Date: {{ planInfo.startDate }}</p>
      <p>End Date: {{ planInfo.endDate }}</p>
      <p>Auto Plan Renewal: <input type="checkbox" v-model="planInfo.autoRenewal"></p>
      <p>Newsletter Subscription: <input type="checkbox" v-model="planInfo.newsletterSubscription"></p>
    </div>
  </div>
</template>

<script setup>
const userInfo = {
  username: 'John',
  email: 'john@gmail.com',
  phone: '123456',
  city: 'New York'
};

const planInfo = {
  plan: 'Gold',
  startDate: '2024-04-01',
  endDate: '2024-04-30',
  autoRenewal: true,
  newsletterSubscription: true
};

let editMode = true;

function saveChanges() {
  // 这里可以将修改后的信息发送到服务器或进行其他处理

  editMode = false; // 切换回非编辑模式
}
</script>

<style>
/* 用户信息部分 */
#avatar {
  width: 100px; /* 调整头像的大小 */
  height: 100px;
  border-radius: 50%; /* 将头像变为圆形 */
  margin-bottom: 20px; /* 增加头像与文本之间的间距 */
}

button {
  padding: 8px 16px; /* 调整按钮的内边距 */
  background-color: #007bff; /* 设置按钮背景颜色 */
  color: #fff; /* 设置按钮文字颜色 */
  border: none; /* 移除按钮边框 */
  border-radius: 4px; /* 设置按钮圆角 */
  cursor: pointer; /* 设置鼠标悬停样式为手型 */
  transition: background-color 0.3s; /* 添加过渡效果 */
}

button:hover {
  background-color: #0056b3; /* 设置按钮悬停时的背景颜色 */
}

/* 计划信息部分 */
#planinfo {
  margin-top: 20px; /* 增加计划信息与用户信息之间的间距 */
}

/* 通用样式 */
p {
  margin-bottom: 10px; /* 设置段落之间的间距 */
}

input {
  width: 100%; /* 输入框宽度填满父元素 */
  padding: 8px; /* 调整输入框的内边距 */
  margin-bottom: 10px; /* 设置输入框之间的间距 */
  border-radius: 4px; /* 设置输入框圆角 */
  border: 1px solid #ccc; /* 设置输入框边框 */
  box-sizing: border-box; /* 让输入框的宽度包括边框和内边距 */
}

/* 编辑模式样式 */
.edit-mode input {
  background-color: #f5f5f5; /* 设置编辑模式下输入框的背景颜色 */
}

.edit-mode button {
  background-color: #28a745; /* 设置编辑模式下按钮的背景颜色 */
}

.edit-mode button:hover {
  background-color: #218838; /* 设置编辑模式下按钮悬停时的背景颜色 */
}

</style>
