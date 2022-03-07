<script>

import PageContainer from "./components/PageContainer.vue";

export default {
  components: {PageContainer}
}

</script>

<script setup>
import {useCookies} from "vue3-cookies";
import {getCurrentInstance, nextTick, onMounted, reactive, ref} from "vue";
import {onBeforeMount} from "vue";
import {watch} from "vue";
import pubsub from "pubsub-js";

let bus = getCurrentInstance().appContext.config.globalProperties.$bus
const {cookies} = useCookies()
let store = getCurrentInstance().appContext.config.globalProperties.$store


onBeforeMount(()=>{
  if (cookies.get("user_session")) {
    store.state.user = cookies.get("user_session")
  }
  if (cookies.get("user_cart")) {
    store.state.cart = cookies.get("user_cart")
  } else {
    cookies.set("user_cart", store.state.cart, "7D")
  }
})

//不要删掉 这个真有用
watch(() => store.state.cart, (newValue, oldValue) => {
    cookies.set("user_cart", store.state.cart, "7D")
}, {deep: true})

// 完善点击其他区域关闭侧边栏
function closeSaber(event) {
  let cancelArea = document.getElementsByClassName('side-bar bg-gray-900 font-bold transition-all duration-500 ease-in-out z-40 outline-none active')
  if (cancelArea.length !== 0) {
    if (!cancelArea.item(0).contains(event.target)) {
      pubsub.publish('changeSaberCondition')
    }
  }
}
</script>

<template>
  <div class="h-full" @click="closeSaber">
    <div class="grid grid-rows-body h-full">
      <page-container/>
    </div>
  </div>
</template>