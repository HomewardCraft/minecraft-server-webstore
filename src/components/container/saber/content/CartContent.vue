<template>
  <div class="top relative flex items-center justify-between m-6">
    <div class="title text-white font-bold text-2xl">
      Your Cart
      <!-- TODO 购物车一览 -->
      <small class="text-gray-500">(0)</small>
    </div>
    <div class="currency-checkout">
      <currency-checkout/>
    </div>
  </div>
  <div class="px-6 py-12 text-gray-500 text-center">
    <p>Looks like your cart is empty! Add some items to get started.</p>
  </div>
</template>

<script>
import CurrencyCheckout from "./CurrencyCheckout.vue";
export default {
  name: "CartContent",
  components: {CurrencyCheckout}
}
</script>