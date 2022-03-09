<script>

import PageContainer from "./components/PageContainer.vue";

export default {
  components: {PageContainer}
}

</script>

<script setup>
import pubsub from "pubsub-js";
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