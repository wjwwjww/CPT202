<script>
export default {
 name:'termsPage',
  methods:{
    toemail(){
      this.$router.push("/email")
    }
  }

};

</script>

<template>
  <header>
    <h1>Fitness</h1>
    <hr>
  </header>





  <main>
  <h3>Create Account</h3>
  <section class="account-creation">
    <p>1/3 step</p>
    <h2>Terms and Conditions</h2>

    <form id="terms-form">
      <div class="terms-group">
        <input type="checkbox" id="term1" name="term1" required>
        <label for="term1">I've agree to the Fitness Center's Terms of Service.
        </label>
      </div>
      <div class="terms-group">
        <input type="checkbox" id="term2" name="term2">
        <label for="term2">I consent to the collection, use, and disclosure of my personal information in accordance with the Privacy Policy, which I have read and understood.
        </label>
      </div>
      <div class="terms-group">
        <input type="checkbox" id="term3" name="term3">
        <label for="term3">I agree to receive promotional information about products, services, and events offered by Fitness Center via email, SMS, or other forms of communication.
        </label>
      </div>
      <div class="form-group">
        <button @click='toemail' type="submit">Agree and Continue</button>
      </div>
    </form>
  </section>
  </main>
</template>

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

.account-creation p {
  font-family: Western;
}


.account-creation h2 {
  text-align: center;
  margin-top: 30px;
  margin-bottom: 30px;
}


.terms-group {
  margin: 20px 0;
  margin-left : 50px;
}

.terms-group label {
  margin-left: 10px;
}

.terms-group input[type="checkbox"] {
  accent-color: #0056b3;
}

.form-group {
  text-align: center;
  margin-top: 45px;
  margin-bottom: 30px;

}

.form-group button {
  padding: 10px 15px;
  background-color: #0056b3;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 2px 4px 8px rgba(0,0,0,0.2);

}

.form-group button:hover {
  background-color: #004299;
  box-shadow: 4px 8px 12px rgba(0,0,0,0.3);

}


</style>