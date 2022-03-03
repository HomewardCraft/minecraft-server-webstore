<template>
  <div v-show = "logged_in"
      class="item cursor-pointer bg-custom-300 border border-lighten lg:w-16 h-16 box-content flex items-center justify-center relative group lg:mb-3 transition-all ease-in-out duration-500" data-item="user">
    <div class="tooltip right-0 mr-20 opacity-0 absolute transition-opacity duration-150 ease-in-out group-hover:opacity-100">
      {{username}}</div>
    <img src="https://cravatar.eu/helmavatar/Ba1oretto/40" alt="Ba1oretto's Minecraft Head" class="w-8 h-8 block">
  </div>
  <div v-show = "!logged_in"
      class="item cursor-pointer bg-custom-300 border border-lighten lg:w-16 h-16 box-content flex items-center justify-center relative group lg:mb-3 transition-all ease-in-out duration-500" data-item="user">
    <div class="tooltip right-0 mr-20 opacity-0 absolute transition-opacity duration-150 ease-in-out group-hover:opacity-100">Guest</div>
    <img src="https://cravatar.eu/helmavatar/Guest/40" alt="Guest's Minecraft Head" class="w-8 h-8 block">
  </div>
  <div class="item cursor-pointer bg-red-600 border border-lighten lg:w-16 h-16 box-content flex items-center justify-center relative group lg:mb-3 transition-all ease-in-out duration-500 delay-100 disabled" data-item="cart">
    <div class="icon">
      <svg viewBox="0 0 36 36" fill="currentColor" class="w-6 h-6 mr-2">
        <path d="M8 8H0V12H4V28H8V32H16V28H24V32H32V28H36V12H32V24H8V8Z"/>
      </svg>
    </div>
    <div class="count">0</div>
  </div>
  <div class="item cursor-pointer bg-blue-500 border border-lighten lg:w-16 h-16 box-content flex flex-col items-center justify-center relative group text-white leading-none transition-all ease-in-out duration-500 delay-200" data-item="currency">
    <div class="lg text-2xl mb-1">$</div>
    <div class="sm text-base">USD</div>
  </div>
</template>

<script setup>
import {getCurrentInstance, toRef} from "vue";

let ctx = getCurrentInstance()
let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')
let username = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'ign')
</script>

<script>
export default {
  name: "SidebarPopout"
}
</script>

<style scoped>
.side-bar.active .popout .item {
  opacity: 0;
  transform: translate(25px);
}
</style>