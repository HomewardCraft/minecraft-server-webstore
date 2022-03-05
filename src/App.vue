<script>

import PageHeader from "./components/PageHeader.vue";
import PageContainer from "./components/PageContainer.vue";
import PageFooter from "./components/PageFooter.vue";
import BottomModal from "./components/BottomModal.vue";

export default {
  components: {BottomModal, PageFooter, PageContainer, PageHeader}
}

</script>

<script setup>
import {useCookies} from "vue3-cookies";
import {getCurrentInstance, onMounted} from "vue";
import {onBeforeMount} from "vue";
import {watch} from "vue";

let BUS = getCurrentInstance().appContext.config.globalProperties.$bus
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

/**  启用，获取html对象实现过于复杂
onMounted(()=>{
  console.log('---onMounted---')
  document.addEventListener('click', (event) =>{
    let className = event.target.parentNode
    console.log(className)
  })
})*/

function closeAll() {
  BUS.emit('updateSideBarState', 'manipulate')
}

</script>

<template>
  <div class="h-full">
    <div class="grid grid-rows-body h-full">
      <page-header @click = "closeAll"/>
      <page-container/>
      <page-footer @click = "closeAll"/>
    </div>
    <BottomModal/>
    <!--<page-loading/>-->
  </div>
</template>