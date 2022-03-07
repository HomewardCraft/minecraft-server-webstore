<template>
  <div class="item cursor-pointer bg-custom-300 border border-lighten lg:w-16 h-16 box-content flex items-center justify-center relative group lg:mb-3 transition-all ease-in-out duration-500" data-item="user">
    <div class="tooltip right-0 mr-20 opacity-0 absolute transition-opacity duration-150 ease-in-out group-hover:opacity-100">hello</div>
    <img src="https://cravatar.eu/helmavatar/Guest/40" alt="Guest's Minecraft Head" class="w-8 h-8 block">
  </div>
</template>

<script setup>
import {getCurrentInstance, ref, toRef} from "vue";
import {reactive} from "vue";

let ctx = getCurrentInstance()
//全局数据响应式
let GLOBAL_DATA = reactive(ctx.appContext.config.globalProperties.$store)

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