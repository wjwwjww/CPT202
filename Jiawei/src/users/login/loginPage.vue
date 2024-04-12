<template>
  <div id="all">
    <div class="container">
      <form action="#" class="login-form" @submit.prevent="login">
        <p>Please login:</p>
        <input type="text" v-model="username" placeholder="用户名" />
        <input type="password" v-model="password" placeholder="密码" />
        <button type="submit">登录</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      axios.post('/api/login', {
        username: this.username,
        password: this.password
      })
          .then(()=> {
            // 处理登录成功的情况
            console.log('登录成功');
            this.$router.push('/home');
          })
          .catch(error => {
            // 处理登录失败的情况
            console.error('登录失败:', error);
          });
    }
  }
};
</script>

<style>
.container {
  width: 100vw;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: url("https://starry-lixu.oss-cn-hangzhou.aliyuncs.com/202209141908599.jpg") fixed no-repeat;
  background-size: cover;
}

#all {
  margin: 0;
  background-image: url("@/assets/img.png");
  background-size: cover;
  font-family: "PingFang SC", "Microsoft Yahei", sans-serif;
}

.login-form {
  width: 240px;
  height: 220px;
  display: flex;
  flex-direction: column;
  padding: 30px;
  text-align: center;
  position: relative;
  z-index: 100;
  background: inherit;
  border-radius: 18px;
  overflow: hidden; /* 隐藏多余的模糊效果*/
  background-color: rgba(255, 255, 255, 0.8); /* 修改背景色 */
  /* box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); */ /* 添加阴影效果 */
  /* margin: auto; */ /* 水平居中 */
}

.login-form h2 {
  font-size: 18px;
  font-weight: 400;
  color: #3d5245;
}

.login-form input,
.login-form button {
  margin: 6px 0;
  height: 36px;
  border: none;
  background-color: rgba(255, 255, 255, 0.3);
  border-radius: 4px;
  padding: 0 14px;
  color: #3d5245;
}
</style>
