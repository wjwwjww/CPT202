<script>
export default {
  methods: {
    tohome(){
      this.$router.push("/home")
    }
  },
}
</script>

<template>
  <main>
<!--    <div v-if="showPlanor" id="showplan">-->
<!--      <p>Do you choose plan now or later?</p>-->
<!--      <button>now</button>-->
<!--      <button>later</button>-->
<!--    </div>-->
    <h3>Fitness Plan</h3>
    <div class="plans-container">
      <div class="plan" id="silver-plan">
        <h2>Silver</h2>
        <div class="description">
          <p><strong>Silver Tier (Entry-Level):</strong></p>
          <ul>
            <li>Access to standard gym facilities and group classes.</li>
            <li>Limited number of personal training sessions.</li>
            <li>Basic online support and fitness tracking.</li>
            <li>Community support through forums or social media groups.</li>
          </ul>
        </div>
        <div class ="price-options">
          <div class="price-option">
            <input type="checkbox" id="silver-6" name="plan-option">
            <label for="silver-6">6 Months - $500</label>
          </div>
          <div class="price-option">
            <input type="checkbox" id="silver-12" name="plan-option">
            <label for="silver-12">12 Months - $900</label>
          </div>
        </div>

      </div>

      <!-- 반복해서 Gold와 Diamond 등급에도 동일하게 적용 -->
      <div class="plan" id="gold-plan">
        <h2>Gold</h2>
        <div class="description">
          <p><strong>Gold Tier (Mid-Level):</strong></p>
          <ul>
            <li>Additional personal training sessions.</li>
            <li>Nutritional guidance and meal planning.</li>
            <li>Access to specialty classes or premium gym equipment.</li>
            <li>Enhanced online support and app features.</li>
            <li>Participation in fitness challenges and events.</li>
          </ul>
        </div>
        <div class ="price-options">
          <div class="price-option">
            <input type="checkbox" id="gold-6" name="plan-option">
            <label for="gold-6">6 Months - $800</label>
          </div>
          <div class="price-option">
            <input type="checkbox" id="gold-12" name="gold-option">
            <label for="gold-12">12 Months - $1500</label>
          </div>
        </div>

      </div>

      <div class="plan" id="Diamond-plan">
        <h2>Diamond</h2>
        <div class="description">
          <p><strong>Diamond Tier (Mid-Level):</strong></p>
          <ul>
            <li>Additional personal training sessions.</li>
            <li>Nutritional guidance and meal planning.</li>
            <li>Access to specialty classes or premium gym equipment.</li>
            <li>Enhanced online support and app features.</li>
            <li>Participation in fitness challenges and events.</li>
          </ul>
        </div>
        <div class ="price-options">
          <div class="price-option">
            <input type="checkbox" id="diamond-6" name="plan-option">
            <label for="diamond-6">6 Months - $800</label>
          </div>
          <div class="price-option">
            <input type="checkbox" id="diamond-12" name="diamond-option">
            <label for="diamond-12">12 Months - $1500</label>
          </div>
        </div>

      </div>

      <!-- Repeat for Gold and Diamond plans... -->
    </div>
    <button @click="tohome" id="purchase-button" >Purchase</button>
  </main>

</template>

<style>
.plans-container {
  display: flex;
  justify-content: space-between; /* 중앙 정렬에서 균등 간격으로 변경 */
  align-items: stretch; /* 모든 자식 요소를 부모의 높이에 맞게 늘림 */
  margin-top: 20px;


}
main {
  position: relative; /* 상대 위치 설정 */
  width: 95%; /* 브라우저 창 너비의 95%를 사용 */
  max-width: 1100px; /* 최대 너비를 1200픽셀로 설정 */
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

.plan {
  border: 1px solid #ddd;
  display: flex;
  flex-direction: column;
  justify-content: flex-start; /* 내용을 상단부터 시작 */
  padding: 10px;
  margin:0 10px;
  text-align: center;
  background: #fff;
  flex: 1; /* 모든 .plan 요소가 동일한 비율로 늘어나게 함 */
  margin-bottom: 20px; /* 간격 설정 */
}

.price-options {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  flex-grow: 1; /* 가격 옵션을 하단에 위치 */
}

.price-option {
  background: #f3f3f3;
  padding: 5px;
  border-radius: 4px;
  margin-bottom: 10px; /* 가격 옵션 간격 */
  display: flex;
  justify-content: center; /* 체크박스와 라벨을 양쪽 끝으로 정렬 */
}

.price-option input[type="checkbox"] {
  margin-right: 10px; /* 체크박스와 라벨 사이의 오른쪽 마진 설정 */
}

#purchase-button {
  display: block;
  margin: 20px auto;
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
#purchase-button:hover {
  background-color: #0056b3;
}

</style>