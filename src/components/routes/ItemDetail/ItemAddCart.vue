<template>
  <div v-if="logged_in && IS_ITEM_IN_CART && !HOW_MANY_IN_CART==0">
    <transition name="slide">
      <div class="quantity flex mb-4">
        <button @click="decreaseItemByOne" class="flex p-4 bg-btn border border-lighten uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90 opacity-50">
          <svg class="w-6 h-6" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
            <path d="M400 288h-352c-17.69 0-32-14.32-32-32.01s14.31-31.99 32-31.99h352c17.69 0 32 14.3 32 31.99S417.7 288 400 288z"></path>
          </svg>
        </button>
        <div class="quantity w-full text-center font-bold text-lg bg-gray-900 flex text-gray-500 items-center justify-center">
          {{ HOW_MANY_IN_CART }}x Bundle
        </div>
        <button @click="increaseItemByOne" class="flex p-4 bg-btn border border-lighten uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90">
          <svg class="w-6 h-6" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
            <path d="M432 256c0 17.69-14.33 32.01-32 32.01H256v144c0 17.69-14.33 31.99-32 31.99s-32-14.3-32-31.99v-144H48c-17.67 0-32-14.32-32-32.01s14.33-31.99 32-31.99H192v-144c0-17.69 14.33-32.01 32-32.01s32 14.32 32 32.01v144h144C417.7 224 432 238.3 432 256z"></path>
          </svg>
        </button>
      </div>
    </transition>
    <transition name="slide">
      <div class="flex justify-center items-center w-full bg-gray-900 border border-light py-4 uppercase font-extrabold tracking-wide text-gray-500 transition-all transform duration-150 ease-in-out focus:outline-none">
        Added to cart
      </div>
    </transition>
    <transition name="slide">
      <button @click="removeItem" class="remove text-red-400 transition-colours ease-in-out duration-150 hover:text-red-200 p-5 font-bold text-sm text-center block w-full focus:outline-none">
        Remove from cart
      </button>
    </transition>
  </div>
  <transition name="slide">
    <template v-if="logged_in && !IS_ITEM_IN_CART">
      <cart-empty :addItemToCart="addItemToCart"/>
    </template>
  </transition>

  <template v-if="!logged_in">
    <un-login/>
  </template>
</template>

<script>
import UnLogin from "../CratesRoute/cartmanipulation/UnLogin.vue";
import CartEmpty from "../CratesRoute/cartmanipulation/CartEmpty.vue";
export default {
  name: "ItemAddCart",
  components: {UnLogin,CartEmpty}
}
</script>


<script setup>
import {getCurrentInstance, onMounted, reactive, ref, toRef, watch} from "vue";
import pubsub from "pubsub-js";

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
  let currentComponent = {
    itemName: showItem.name,
    componentName: 'AddCartMessage'
  }
  pubsub.publish('setCurrentToastComponent', currentComponent)
}


function countItem() {
  //这个很有可能时vue的问题，mount和watch都不会进入这个循环
  // console.log(GLOBAL_DATA.state.cart.items)
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
  // console.log("ItemAddCart 数据发生变化")
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