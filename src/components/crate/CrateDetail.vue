<!-- 详细信息, 包含details下的所有组件 -->
<template>
  <div :class="animation" class="simple padding-y font-general detail-background"
       @mouseenter="enable()" @mouseleave="disable()">
    <div class="amount-font amount-style">{{ amount }}x</div>
    <originalPrice
        v-if="!detail.discount.onSaleCondition"
        :amount="amount"
        :unhandledPrice="detail.price"
    />
    <discount-price
        v-if="detail.discount.onSaleCondition"
        :amount="amount"
        :unhandledPrice="detail.price"
        :onSalePercent="detail.discount.onSalePercent"
    />
    <div class="order-text order-general">
      <order-crate/>
    </div>
  </div>
</template>

<script>
import discountPrice from "@/components/crate/detail/DiscountPrice";
import orderCrate from "@/components/crate/detail/OrderCrate";
import originalPrice from "@/components/crate/detail/OriginalPrice";

export default {
  name: "CrateDetails",
  components: {
    discountPrice,
    orderCrate,
    originalPrice
  },
  props: ['detail', 'amount'],
  methods: {
    enable() {
      this.animation = 'shadow-drop-start group'
    },
    disable() {
      this.animation = ''
    }
  },
  data() {
    return {
      animation: '',
    }
  }
}
</script>

<style scoped>
.shadow-drop-start {
  animation: shadow-drop 0.2s cubic-bezier(0.455, 0.030, 0.515, 0.955) both;

}

.group:hover {
  color: rgba(146, 64, 14, 1);
  background-color: rgba(250, 192, 33, 1);
}

@keyframes shadow-drop {
  0% {
    -webkit-transform: translateZ(0) translateY(0);
    transform: translateZ(0) translateY(0);
    -webkit-box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
    box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
  }
  100% {
    -webkit-transform: translateZ(50px) translateY(-12px);
    transform: translateZ(50px) translateY(-12px);
    -webkit-box-shadow: 0 12px 20px -12px rgba(0, 0, 0, 0.35);
    box-shadow: 0 12px 20px -12px rgba(0, 0, 0, 0.35);
  }
}

/* 详情的背景 */
.detail-background {
  background-color: rgba(24, 26, 27, 1);
}

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
  text-align: center;
}

/* 基础样式 */
.simple {
  border-width: 1px;
  border-color: #ffffff1a;
  border-style: solid;
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