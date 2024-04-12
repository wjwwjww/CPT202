
<template>
  <header>
    <h1>Fitness</h1>
    <hr>
  </header>

  <main>
    <h3>Create Account</h3>

    <section class="create-password">
      <p>3/3 step</p>
      <h2>Create Password </h2>

      <form  id="create-password-form">

        <div class="enter-password newpassword">
          <label for="password">Create your password</label>
          <input type="password" id="password" name="password" placeholder="Enter Password"  required>
          <p class="password-requirements">Password must : <br>
            * Be at least 8 characters long<br>
            * Include<br>
            - An uppercase letter<br>
            - A lowercase character<br>
            - A number<br>
            - A special character.</p>
        </div>

        <div class="enter-password confirm">
          <label for="confirm-password">Confirm your password</label>
          <input type="password" id ="confirm-password" name="confrim-password" placeholder ="Confirm Password" required>
        </div>

        <div class="continue-button">
          <button  @click="toPlan" type="submit" id="continue">Continue</button>
        </div>

      </form>

    </section>


  </main>
</template>


<script>
export default {
  methods: {
    toPlan(){
      this.$router.push("/fitness")
    }
  },




}
</script>

<style>
body {
  font-family: 'Arial', sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}

header {
  padding: 20px;
}

header h1 {
  margin: 0 0 30px;
}

hr {
  border: 0;
  height: 1px;
  background-color: #333;
  margin-top: 0;
  margin-bottom: 20px;
  width : 100%; /*선의 길이를 부모 요소의 설정*/
  margin-left: 0; /*선을 중앙에 정렬*/
}

main {
  position: relative; /* 상대 위치 설정 */
  width: 80%;
  max-width: 600px;
  margin: 40px auto;
  background-color: white;
  padding: 30px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

h3 {
  position: absolute; /* 절대 위치 설정 */
  top: -50px; /* main 상단에서 40px 위 */
  left: 0; /* main 왼쪽에서 30px 떨어진 곳 */
  color: rgb(112, 112, 112);
  padding: 0 10px; /* 좌우 패딩 추가 */
}

.create-password p {
  font-family: Western;
}

.create-password h2 {
  text-align: center;
  margin-top: 30px;
  margin-bottom: 50px;
}





.enter-password{
  width: 100%;
  display: flex; /* Flex 컨테이너 설정 */
  flex-direction: column; /* 자식 요소를 세로로 배열 */
  align-items: center; /* 왼쪽 정렬로 변경 */

}

.enter-password label{
  margin-bottom: 10px; /* 라벨과 입력 필드 사이의 여백 */
  margin-left: -100px;
}



.enter-password .password-requirements {
  font-size: 0.8em; /* 비밀번호 요구사항 텍스트의 크기를 줄임 */
  color: #666; /* 텍스트 색상을 변경 */
  margin-left : -100px;
  margin-bottom: 40px;
}

.enter-password input{
  width :250px;
  height: 30px;
  padding: 5px; /* 입력 필드 내부에 패딩을 줌 */
  border: 3px solid #ccc; /* 입력 필드의 테두리를 설정 */
  border-radius: 5px;
}


.continue-button {
  text-align: center;
  margin-top: 45px;
  margin-bottom: 30px;
}

.continue-button button {
  padding: 10px 15px;
  background-color: #0056b3;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 2px 4px 8px rgba(0,0,0,0.2);


}

.continue-button button:hover {
  background-color: #004299;
}
#showplan{
  z-index: 100;
  background-color: #2c3e50;
  margin-right: auto;
  margin-left: auto;
}



</style>