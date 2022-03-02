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
  <div v-show="logged_in" class="px-6 py-12 text-gray-500 text-center">
    <p>Looks like your cart is empty! Add some items to get started.</p>
  </div>
  <div v-show="!logged_in" class="px-6 py-12 text-gray-500 text-center leading-2"><p>Looks like you're not signed in yet!</p>
    <p class="text-sm">You'll need to sign in to add items to your cart.</p></div>
</template>

<script setup>
import {getCurrentInstance, toRef} from "vue";

let ctx = getCurrentInstance()
let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')
</script>

<script>
import CurrencyCheckout from "./CurrencyCheckout.vue";

export default {
  name: "CartContent",
  components: {CurrencyCheckout}
}
</script>

