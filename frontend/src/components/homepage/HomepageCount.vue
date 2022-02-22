<!-- 主页的奖励进度 -->
<template>
  <div>
    <span>
      Spend $20+ USD for 1x Heart Wings & Heart Crown Cosmetics!
    </span>
    <span class = "cart">
      Your Cart: 30%
    </span>
  </div>
</template>


<script>
export default {
  name: "HomepageCount"
}
</script>


<style scoped>

.cart {
  float: right;
  font-size: 16px;
  }

span {
  margin: 0;
  padding: 30px;
  text-align: left;
  float: left;
  font-size: 18px;
  font-weight: bold;
  color: #FFFFFF;
}

div {
  margin: auto;
  width: 1100px;
  height: 80px;
  display: block;
  text-align: center;
  border: 2px solid #b670c8;
  background-color: #ae60c2;
}
</style>