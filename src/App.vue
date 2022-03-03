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
import {getCurrentInstance, toRef, toRefs} from "vue";
import {onBeforeMount} from "vue";

const {cookies} = useCookies()
let ctx = getCurrentInstance()

onBeforeMount(()=>{
  console.log('---onBeforeMount---')
  if (cookies.get("user_session")) {
    ctx.appContext.config.globalProperties.$store.state.user = cookies.get("user_session")
  }

})

</script>

<template>
  <div class="h-full">
    <div class="grid grid-rows-body h-full">
      <page-header/>
      <page-container/>
      <page-footer/>
    </div>
    <BottomModal/>
  </div>
</template>