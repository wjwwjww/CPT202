<template>
<!--  <nav id="navbar">-->
<!--    <ul>-->
<!--      <li><router-link to="/home">Home</router-link></li>-->
<!--      <li><router-link to="/customer">appointment</router-link></li>-->

<!--      <li></li>-->
<!--    </ul>-->
<!--  </nav>-->

  <Navigate/>
  <div id="account">
    <ul>
    <li id="tologin"><router-link to="/login" class="routerdirect">login</router-link></li>
    <li id="toregister"><router-link to="register" class="routerdirect">register</router-link></li>
    </ul>
  </div>
  <p id="welcome1">Welcome to our gym! We are dedicated to helping you achieve your fitness goals and enhance your quality of life at our professional fitness club.</p>
  <div id="news">
    <p class="welcome2">
      News
      <button class="readmore">read more</button>
    </p>

    <div>
      <ul>
      <li>we have open the appointment channel</li>
      <li>you can view our page at our websit</li>
       <li>you can ask for help with the staff with the click of right corner</li>

      </ul>

    </div>
  </div>
  <div id="aboutus">
    <p class="welcome2">
      About us
    </p><br>
    <a>We are a fitness club located in [location], committed to providing high-quality fitness services to our members. We strive to create a positive and healthy community for our members. Our team consists of experienced, passionate, and professional trainers, and we offer state-of-the-art equipment and a variety of fitness classes to cater to your needs.</a>
  </div>
  <div id="intro">
    <p class="welcome2">Our Facilities and Services:</p>
    <ul>
      <li>Spacious and well-lit gym space equipped with the latest fitness equipment to meet all your fitness needs.</li>
      <li>Diverse group classes including yoga, pilates, aerobic exercises, and more, guided by expert trainers suitable for all ages and fitness levels.</li>
      <li>Personal training sessions tailored to your individual goals and fitness level, ensuring you achieve the best results.</li>
      <li>Comfortable lounge and shower facilities for you to relax and rejuvenate after your workout.
      </li>
    </ul>
  </div>
  <div id="mission">
    <p class="welcome2">Our Mission</p>
    <p>Our mission is to inspire and guide every member towards a healthier and happier life. We believe that by adhering to a scientific training regimen and adopting a healthy lifestyle, you can have more vitality, better physical fitness, and better cope with life's challenges.</p>
  </div>
  <div id="joinus">
    <p class="welcome2">Join us</p>
    <p>Whether you're a fitness beginner or an experienced enthusiast, we welcome you to join us! Whether your goal is muscle building, weight loss, shaping, or improving fitness, we are committed to providing you with the most professional and attentive service. Join us, make health a part of your life, and let exercise become a joy of life!
    </p>
    <div id="contact">
      <p class="welcome2">Contact Information:</p>
      <p>Address: [Gym Address]</p>
      <p>Phone: [Contact Phone]</p>
      <p>Email: [Contact Email]</p>
      <p>Website: [Gym Website]</p>
    </div>
  </div>
</template>

<script>

import Navigate from "@/users/navigatebar/navigateBar.vue";

export default {
  components: {Navigate},
  data() {
    return {
      user: {
        uname: "",
        uid: null,
      },
    };
  },
};
</script>

<style>
#navbar {
  position: fixed; /* 固定在顶部 */
  top: 0;
  left: 0;
  width: 100%; /* 撑满整个宽度 */
  background-color: #333; /* 导航栏背景色 */
  padding: 10px 20px; /* 上下左右边距 */
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 阴影效果 */
  z-index: 2; /* 确保在其他元素上方 */
  text-align: left;

}

#navbar ul {
  list-style: none;
  padding: 0;
}

#navbar li {
  display: inline;
  margin-right: 20px; /* 调整间距 */
}

#navbar li:last-child {
  margin-right: 0; /* 最后一个菜单项不留右边距 */
}

#navbar a {
  color: #fff; /* 链接文字颜色 */
  text-decoration: none; /* 去掉下划线 */
  font-weight: bold; /* 文字加粗 */
}

/* 用户账户样式 */
#account {

  position: fixed; /* 固定在顶部 */
  top: 10px;
  right: 20px;
  z-index: 3;


}
#account .routerdirect {
  color: #fff; /* 设置链接颜色为白色 */
}

#account ul {

  list-style: none;
  padding: 0;
  margin: 0;
}

#account li {


  display: inline;
  margin-left: 10px; /* 调整间距 */
}

/* 欢迎语样式 */
#welcome1 {
  font-size: 30px;
  font-weight: bold;
  text-align: center; /* 居中对齐 */
  margin-top: 90px; /* 调整与导航栏的距离 */
}

/* 新闻部分样式 */
#news {
  margin-top: 40px; /* 调整与欢迎语的距离 */
  background-color: #f4f4f4; /* 背景色 */
  padding: 20px; /* 内边距 */
  border-radius: 5px; /* 圆角边框 */
}

#news .welcome2 {
  font-size: 24px;
  font-weight: bold;
}
#news li{
  list-style: none;
  padding: 0;
  text-align: left;
}
.welcome2{
  text-align: left;
  width: 200px;
}

.readmore {
  position: relative;
  top:0;
  background-color: #333;
  color: #fff;
  border: none;
  padding: 8px 16px;
  border-radius: 5px;
  cursor: pointer;
}

/* 关于我们部分样式 */
#aboutus {
  margin-top: 40px; /* 调整与新闻部分的距离 */
  padding: 20px; /* 内边距 */
  background-color: #f9f9f9; /* 背景色 */
  border-radius: 5px; /* 圆角边框 */
}

#aboutus .welcome2 {
  font-size: 24px;
  font-weight: bold;
}

/* 我们的设施和服务部分样式 */
#intro {
  margin-top: 40px; /* 调整与关于我们部分的距离 */
  padding: 20px; /* 内边距 */
  background-color: #f4f4f4; /* 背景色 */
  border-radius: 5px; /* 圆角边框 */
}

#intro .welcome2 {
  font-size: 24px;
  font-weight: bold;
}
#intro li{

  padding: 0;
  text-align: left;
}

/* 我们的使命部分样式 */
#mission {
  margin-top: 40px; /* 调整与设施和服务部分的距离 */
  padding: 20px; /* 内边距 */
  background-color: #f9f9f9; /* 背景色 */
  border-radius: 5px; /* 圆角边框 */
}

#mission .welcome2 {
  font-size: 24px;
  font-weight: bold;
}

/* 加入我们部分样式 */
#joinus {
  margin-top: 40px; /* 调整与使命部分的距离 */
  padding: 20px; /* 内边距 */
  background-color: #f4f4f4; /* 背景色 */
  border-radius: 5px; /* 圆角边框 */
  padding-bottom: 200px;
}

#joinus .welcome2 {
  font-size: 24px;
  font-weight: bold;
}

/* 联系信息样式 */
#contact {
  margin-top: 20px; /* 调整与加入我们部分的距离 */
  padding: 20px; /* 内边距 */
  background-color: #f9f9f9; /* 背景色 */
  border-radius: 5px; /* 圆角边框 */
  text-align: left;
  width: 300px;
}

#contact .welcome2 {
  font-size: 24px;
  font-weight: bold;
}

#contact p {
  margin: 5px 0; /* 调整段落之间的距离 */
}

</style>