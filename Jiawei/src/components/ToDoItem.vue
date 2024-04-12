<template>
  <div>
    <input type="checkbox" :id="id" :checked="isDone" />
    <label :for="id">{{label}}</label>
<!--   <h1>{{label}}</h1>-->

  </div>

</template>
<script>
export default {
  props: {
    label: {required: true, type: String},
    done: {default: false, type: Boolean},
    id:{required: true, type:String}
  },
  data() {
    return {
      isDone: this.done,
    }
  }
};
</script>
<style>
/* 基本样式 */
#login {
  width: 300px; /* 调整表单宽度 */
  margin: auto; /* 让表单居中 */
  padding: 20px;
  background-color: #f9f9f9; /* 设置背景色 */
  border: 1px solid #ccc; /* 添加边框 */
  border-radius: 5px; /* 圆角边框 */
}

input {
  width: calc(100% - 20px); /* 输入框宽度 */
  margin-bottom: 10px; /* 设置输入框之间的间距 */
  padding: 8px; /* 输入框内边距 */
  border: 1px solid #ccc; /* 输入框边框 */
  border-radius: 3px; /* 输入框圆角 */
}

button {
  width: calc(100% - 20px); /* 按钮宽度 */
  padding: 10px; /* 按钮内边距 */
  background-color: #007bff; /* 按钮背景色 */
  color: #fff; /* 按钮文字颜色 */
  border: none; /* 移除按钮边框 */
  border-radius: 3px; /* 按钮圆角 */
  cursor: pointer; /* 设置鼠标样式为手型 */
}

button:hover {
  background-color: #0056b3; /* 按钮悬停时的背景色 */
}

button:active {
  background-color: #004080; /* 按钮点击时的背景色 */
}

</style>