<template>
  <div @click="changeCondition" :class="styles.outer" class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out">
    <div :class="styles.inner" class="transition-transform duration-200 ease-in-out transform">
      <div class="title flex items-center justify-between mb-6">
        <login-title/>
      </div>
      <div class="body bg-gray-900 grid lg:grid-cols-3 items-center">
        <login-avatar/>
        <login-input/>
        <login-help/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive} from "vue";
import pubsub from "pubsub-js";

let isOpen = false
let styles = reactive({
  outer: 'opacity-0 pointer-events-none',
  inner: 'scale-75'
})
function changeCondition(event) {
  let cancelArea = document.getElementsByClassName('body bg-gray-900 grid lg:grid-cols-3 items-center')
  if (!isOpen) {
    styles.outer = 'opacity-100 pointer-events-auto'
    styles.inner = ''
    isOpen = true
  } else {
    if (cancelArea.length !== 0) {
      if (!cancelArea.item(0).contains(event.target)) {
        styles.outer = 'opacity-0 pointer-events-none'
        styles.inner = 'scale-75'
        isOpen = false
      }
    }
  }
}
pubsub.subscribe('changeLoginCondition', changeCondition)
</script>

<script>
import LoginAvatar from "./modal/LoginAvatar.vue";
import LoginTitle from "./modal/LoginTitle.vue";
import LoginInput from "./modal/LoginInput.vue";
import LoginHelp from "./modal/LoginHelp.vue";

export default {
  name: "BottomModal",
  components: {LoginHelp, LoginInput, LoginTitle, LoginAvatar}
}
</script>

<style scoped>
.modal {
  padding: 40px 0 0;
  overflow: auto;
}

.modal .body {
  max-width: 700px;
  margin-bottom: 40px;
}
</style>