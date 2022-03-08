<template>
  <button v-show = "logged_in" @click = "showLoginPanel" class="bg-gray-750 border border-light text-gray-500 font-bold text-sm flex items-center justify-center py-3 px-5 w-full transition-colors duration-150 ease-in-out hover:bg-yellow-400 hover:text-yellow-800 focus:bg-yellow-300 focus:outline-none focus:text-yellow-800">
    <svg class="w-4 h-4 mr-3 opacity-75" viewBox="0 0 512 512" fill="currentColor">
      <path d="M0 168v-16c0-13.255 10.745-24 24-24h381.97l-30.467-27.728c-9.815-9.289-10.03-24.846-.474-34.402l10.84-10.84c9.373-9.373 24.568-9.373 33.941 0l82.817 82.343c12.497 12.497 12.497 32.758 0 45.255l-82.817 82.343c-9.373 9.373-24.569 9.373-33.941 0l-10.84-10.84c-9.556-9.556-9.341-25.114.474-34.402L405.97 192H24c-13.255 0-24-10.745-24-24zm488 152H106.03l30.467-27.728c9.815-9.289 10.03-24.846.474-34.402l-10.84-10.84c-9.373-9.373-24.568-9.373-33.941 0L9.373 329.373c-12.497 12.497-12.497 32.758 0 45.255l82.817 82.343c9.373 9.373 24.569 9.373 33.941 0l10.84-10.84c9.556-9.556 9.341-25.113-.474-34.402L106.03 384H488c13.255 0 24-10.745 24-24v-16c0-13.255-10.745-24-24-24z"/>
    </svg>
    <span>切换管理账号</span>
  </button>
  <button v-show = "!logged_in" @click = "showLoginPanel" class="bg-gray-750 border border-light text-gray-500 font-bold text-sm flex items-center justify-center py-3 px-5 w-full transition-colors duration-150 ease-in-out hover:bg-yellow-400 hover:text-yellow-800 focus:bg-yellow-300 focus:outline-none focus:text-yellow-800">
    <svg class="w-4 h-4 mr-3 opacity-50" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
      <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-6-3a2 2 0 11-4 0 2 2 0 014 0zm-2 4a5 5 0 00-4.546 2.916A5.986 5.986 0 0010 16a5.986 5.986 0 004.546-2.084A5 5 0 0010 11z" clip-rule="evenodd"></path>
    </svg>
    <span>输入管理账号</span></button>
</template>

<script>
export default {
  name: "ButtonContent"
}
</script>

<script setup>
import {toRef} from "vue";
import {getCurrentInstance} from "vue";
import pubsub from "pubsub-js";

let ctx = getCurrentInstance()
let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')

// function showLoginPanel() {
//   pubsub.publish('changeSaberCondition')
//   pubsub.publish('changeLoginCondition')
// }
</script>