<script>


</script>


<template>
  <div id="container2">
    <h2>Write Review</h2>
    <div class="stars">
      <span class="star" onclick="toggleStar(1)">★</span>
      <span class="star" onclick="toggleStar(2)">★</span>
      <span class="star" onclick="toggleStar(3)">★</span>
      <span class="star" onclick="toggleStar(4)">★</span>
      <span class="star" onclick="toggleStar(5)">★</span>
    </div>
    <textarea id="reviewText" rows="6" placeholder="Write your review here..." style="width: 100%;"></textarea>
    <input type="file" id="fileInput">
    <button class="btn" onclick="saveReview()">Upload</button>
    <button class="btn" onclick="cancelReview()">Cancel</button>
  </div>

</template>

<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}
#container2 {
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
.stars {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}
.star {
  font-size: 30px;
  color: #ccc;
  cursor: pointer;
}
.star:hover,
.star.active {
  color: #fdd835; /* Yellow color */
}
.btn {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
.btn:hover {
  background-color: #45a049;
}
</style>