<template>
  <div v-show="!logged_in">
    <div class="bg-gray-900 border border-lighten py-4 px-5 text-center mt-4 text-gray-500 font-bold">
      <svg class="w-12 h-12 opacity-50 mx-auto mb-2" viewBox="0 0 640 512" fill="currentColor">
        <path
            d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"></path>
      </svg>
      <div class="lg text-lg leading-tight pb-3">Enter username to purchase</div>
      <div class="sm opacity-75">You need to enter your Minecraft username before you can purchase this item!</div>
    </div>
    <button @click="showLoginPannel"
            class="flex loginbn justify-center w-full text-gray-500 items-center bg-btn text-btn-text border border-lighten py-4 uppercase font-extrabold tracking-wide transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90': cooldown }">
      <svg class="w-6 h-6 opacity-75 mr-2" viewBox="0 0 640 512" fill="#96428e">
        <path
            d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"></path>
      </svg>
      <span class="username">Enter Username</span></button>
  </div>
  <!--  没有登录就显示上面的样式-->
  <!--当购物车有东西时就会显示这些-->
  <div v-show="logged_in && IS_ITEM_IN_CART && !HOW_MANY_IN_CART==0">
    <div class="quantity flex mb-4">
      <button
          @click="decreaseItemByOne"
          class="flex p-4 bg-btn border border-lighten uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90 opacity-50">
        <svg class="w-6 h-6" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
          <path
              d="M400 288h-352c-17.69 0-32-14.32-32-32.01s14.31-31.99 32-31.99h352c17.69 0 32 14.3 32 31.99S417.7 288 400 288z"></path>
        </svg>
      </button>
      <div
          class="quantity w-full text-center font-bold text-lg bg-gray-900 flex text-gray-500 items-center justify-center">
        {{ HOW_MANY_IN_CART }}x Bundle
      </div>
      <button
          @click="increaseItemByOne"
          class="flex p-4 bg-btn border border-lighten uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90">
        <svg class="w-6 h-6" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
          <path
              d="M432 256c0 17.69-14.33 32.01-32 32.01H256v144c0 17.69-14.33 31.99-32 31.99s-32-14.3-32-31.99v-144H48c-17.67 0-32-14.32-32-32.01s14.33-31.99 32-31.99H192v-144c0-17.69 14.33-32.01 32-32.01s32 14.32 32 32.01v144h144C417.7 224 432 238.3 432 256z"></path>
        </svg>
      </button>
    </div>
    <div
        class="flex justify-center items-center w-full bg-gray-900 border border-light py-4 uppercase font-extrabold tracking-wide text-gray-500 transition-all transform duration-150 ease-in-out focus:outline-none"
        disabled="false">Added to cart
    </div>
    <button
        @click="removeItem"
        class="remove text-red-400 transition-colours ease-in-out duration-150 hover:text-red-200 p-5 font-bold text-sm text-center block w-full focus:outline-none">
      Remove from cart
    </button>
  </div>
  <!--当购物车没有东西时就会显示这些-->
  <button
      @click="addItemToCart"
      v-show="logged_in && !IS_ITEM_IN_CART"
      class="flex justify-center items-center w-full px-6 bg-btn border border-lighten py-4 shadow-btn uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90"
      data-exception="">
    <svg class="w-8 h-8 mr-2 opacity-75" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
      <path
          d="M3 1a1 1 0 000 2h1.22l.305 1.222a.997.997 0 00.01.042l1.358 5.43-.893.892C3.74 11.846 4.632 14 6.414 14H15a1 1 0 000-2H6.414l1-1H14a1 1 0 00.894-.553l3-6A1 1 0 0017 3H6.28l-.31-1.243A1 1 0 005 1H3zM16 16.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM6.5 18a1.5 1.5 0 100-3 1.5 1.5 0 000 3z"></path>
    </svg>
    <span>添加到购物车!</span>
  </button>
</template>

<script>

export default {
  name: "ItemAddCart"
}
</script>


<script setup>
import {getCurrentInstance, onMounted, reactive, ref, toRef, watch} from "vue";

let ctx = getCurrentInstance()
let data = defineProps(['item']);
let price = (data.item.price / 100) * (data.item.salePercent / 100);

let IS_ITEM_IN_CART = ref(false)
let HOW_MANY_IN_CART = ref(0)
let GLOBAL_DATA = reactive(ctx.appContext.config.globalProperties.$store)
let BUS = getCurrentInstance().appContext.config.globalProperties.$bus

//当前准备放入购物车的物品
let showItem = reactive({
  "id": data.item.id,
  "name": data.item.name,
  "price": price,
  "quantity": 0
})


function showLoginPannel() {

  ctx.appContext.config.globalProperties.$bus.emit('loginpannelmanipulate', 'open')

}


let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')

function removeItem() {
  GLOBAL_DATA.commit('removeItemFromCart', showItem)
  HOW_MANY_IN_CART.value = 0
}

function increaseItemByOne() {
  GLOBAL_DATA.commit('increaseItemByOne', showItem)
}

function decreaseItemByOne() {
  if (HOW_MANY_IN_CART.value <= 1) {
    removeItem()
  }
  GLOBAL_DATA.commit('decreaseItemByOne', showItem)
}

function addItemToCart() {
  showItem.quantity = 1
  GLOBAL_DATA.commit('addItemToCart', showItem)
}


function countItem() {
  //这个很有可能时vue的问题，mount和watch都不会进入这个循环
  console.log(GLOBAL_DATA.state.cart.items)
  GLOBAL_DATA.state.cart.items.forEach(function (value, index) {
    if (value.id == showItem.id) {
      HOW_MANY_IN_CART.value = value.quantity
    }
  })

}

function isInCart() {
  if (HOW_MANY_IN_CART.value !== 0) {
    IS_ITEM_IN_CART.value = true
  } else {
    IS_ITEM_IN_CART.value = false
  }

}

watch(() => GLOBAL_DATA.state.cart.items, (newValue, oldValue) => {
  console.log("ItemAddCart 数据发生变化")
  countItem()
  isInCart()
}, {deep: true})


onMounted(() => {
  countItem()
  //这个方法执行的很蠢，但是你第一次进入detail页需要她
  isInCart()
  //如果你同时开启购物车和detail界面这里弥补了
  //方法countItem的刷新问题，启用强制刷新
  BUS.on('updateState', (manipulate) => {
    HOW_MANY_IN_CART.value = 0
  })
})
</script>

<style scoped>

/*图标背景颜色*/
.loginbn {
  background-color: #fdafe0;
}

/*字体颜色（按钮）*/

.username {
  color: #96428e;
}
</style>