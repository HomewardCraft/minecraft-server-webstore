<!-- 详细信息, 包含details下的所有组件 -->
<template>
<div class="simple padding-y font-general">
  <div class="amount-font amount-style">20x</div>
  <discount-price/>
  <div class="order-text order-general">
    <order-crate/>
  </div>
</div>
</template>

<script>
import discountPrice from "@/components/crate/details/DiscountPrice";
import orderCrate from "@/components/crate/details/OrderCrate";

export default {
  name: "CrateDetails",
  components: {
    discountPrice,
    orderCrate
  }
}
</script>

<style scoped>
/* 购买按钮的颜色 */
.order-text {
  color: rgba(250, 192, 33, 1);
}

/* 购买按钮的样式 */
.order-general {
  display: flex;
  padding-top: 0.75rem;
  justify-content: center;
  align-items: center;
}

/* 基础样式 */
.simple {
  border-width: 1px;
  border-right-width: 0;
  border-color: #ffffff1a;
  border-style: solid;
  /*background-color: rgba(24, 26, 27, 1);*/
}

/* 数量的字体样式 */
.amount-font {
  font-size: 1.5rem;
  line-height: 2rem;
}

/* 数量的样式 */
.amount-style {
  padding-bottom: 0.25rem;
}

/* 字体统一样式 */
.font-general {
  font-weight: 700;
  text-align: center;
}

/* 盒子的留空 */
.padding-y {
  padding-top: 1.25rem;
  padding-bottom: 1.25rem;
}
</style>