<template>
  <template v-if="logged_in && IS_ITEM_IN_CART && HOW_MANY_IN_CART !== 0">
    <cart-mutable :increaseItem="increaseItemByOne" :decreaseItem="decreaseItemByOne" :removeItem="removeItem" :itemAmount="HOW_MANY_IN_CART"/>
  </template>
  <template v-if="logged_in && !IS_ITEM_IN_CART">
    <cart-empty :addItemToCart="addItemToCart"/>
  </template>
  <template v-if="!logged_in">
    <un-login/>
  </template>
</template>

<script>
import UnLogin from "./cartmanipulation/UnLogin.vue";
import CartEmpty from "./cartmanipulation/CartEmpty.vue";
import CartMutable from "./cartmanipulation/CartMutable.vue";

export default {
  name: "ItemAddCart",
  components: {UnLogin,CartEmpty,CartMutable}
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
  setCurrentToastComponent('RemoveCartMessage')
}

function increaseItemByOne() {
  GLOBAL_DATA.commit('increaseItemByOne', showItem)
  setCurrentToastComponent('IncreaseItemMessage')
}

function decreaseItemByOne() {
  if (HOW_MANY_IN_CART.value <= 1) {
    removeItem()
    setCurrentToastComponent('RemoveCartMessage')
  }
  GLOBAL_DATA.commit('decreaseItemByOne', showItem)
  setCurrentToastComponent('DecreaseItemMessage')
}

function addItemToCart() {
  showItem.quantity = 1
  GLOBAL_DATA.commit('addItemToCart', showItem)
  pubsub.publish('changeSaberCondition')
  setCurrentToastComponent('AddCartMessage')
}

function setCurrentToastComponent(currentComponentName) {
  let currentComponent = {
    itemMeta: showItem,
    componentName: currentComponentName
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