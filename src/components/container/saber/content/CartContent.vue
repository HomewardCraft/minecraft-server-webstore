<template>
  <div class="top relative flex items-center justify-between m-6">
    <div class="title text-white font-bold text-2xl">
      Your Cart
      <!-- TODO 购物车一览 -->
      <small class="text-gray-500">( {{ DO_ITEM_IN_CART }} )</small>
    </div>
    <div class="currency-checkout">
      <currency-checkout/>
    </div>
  </div>
  <div v-show="logged_in && DO_ITEM_IN_CART==0" class="px-6 py-12 text-gray-500 text-center">
    <p>Looks like your cart is empty! Add some items to get started.</p>
  </div>
  <div v-show="!logged_in" class="px-6 py-12 text-gray-500 text-center leading-2"><p>Looks like you're not signed in
    yet!</p>
    <p class="text-sm">You'll need to sign in to add items to your cart.</p></div>

  <div v-if="DO_ITEM_IN_CART!==0">
    <ul class="items overflow-y-auto">
      <li v-for="item in itemsInCart" :key="item.id"
          class="flex items-start p-6 m-4 bg-gray-800 rounded-lg">
        <div class="text leading-none">
          <div class="flex items-center mb-2">
            <div class="name text-lg">{{ item.name }}</div>
            <span class="font-bold text-sm text-gray-500 ml-2">x {{ item.quantity }}</span></div>
          <span class="price text-gray-500">${{ item.price }} USD</span></div>
        <button
            class="ml-auto text-gray-500 transition-colors duration-150 ease-in-out hover:text-red-500 focus:outline-none p-1">
          <svg @click="removeThisItem(item)"
               class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd"
                  d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                  clip-rule="evenodd"></path>
          </svg>
        </button>
      </li>
    </ul>
    <div class="total flex items-center justify-between p-6">
      <div><p class="text-gray-500 text-xs uppercase tracking-wide">1 item</p>
        <p>${{ total }} USD</p></div>
      <button
          class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 focus:outline-none">
        Checkout
      </button>
    </div>
  </div>

</template>

<script setup>
import {getCurrentInstance, onMounted, ref, toRef} from "vue";
import {reactive} from "vue";
import {watch} from "vue";

let ctx = getCurrentInstance()
let GLOBAL_DATA = reactive(ctx.appContext.config.globalProperties.$store)
let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')

let BUS = getCurrentInstance().appContext.config.globalProperties.$bus
let DO_ITEM_IN_CART = ref(GLOBAL_DATA.state.cart.items.length)
let itemsInCart = reactive(GLOBAL_DATA.state.cart.items)
let total = ref(0)

onMounted(() => {
})

watch(() => GLOBAL_DATA.state.cart, (newValue, oldValue) => {
  console.log("CardContent 数据发生变化")
  DO_ITEM_IN_CART.value = GLOBAL_DATA.state.cart.items.length
  calculateTotal()
}, {deep: true})

function removeThisItem(item) {

  GLOBAL_DATA.commit('removeThisItem', item)
  //如果你同时开启购物车和detail界面这里弥补了
  //方法countItem的刷新问题，启用强制刷新
  BUS.emit('updateState', 'delete') //这个方法时界面效果，必须使用
}

function calculateTotal() {
  var totalCache = 0
  for (var item in itemsInCart) {
    console.log("开始计算总价")
    totalCache = totalCache + itemsInCart[item].price * itemsInCart[item].quantity
  }
  total.value = totalCache
}

</script>

<script>
import CurrencyCheckout from "./CurrencyCheckout.vue";

export default {
  name: "CartContent",
  components: {CurrencyCheckout}
}
</script>

