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
import {getCurrentInstance} from "vue";
import {onBeforeMount} from "vue";
import {watch} from "vue";
import PageLoading from "./components/PageLoading.vue";

const {cookies} = useCookies()
let store = getCurrentInstance().appContext.config.globalProperties.$store
let bus = getCurrentInstance().appContext.config.globalProperties.$bus


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

</script>

<template>
  <div class="h-full">
    <div class="grid grid-rows-body h-full">
      <page-header/>
      <page-container/>
      <page-footer/>
    </div>
    <BottomModal/>
    <!--<page-loading/>-->
  </div>
</template>