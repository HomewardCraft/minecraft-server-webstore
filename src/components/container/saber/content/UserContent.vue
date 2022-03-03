<template>
  <div
      v-if="logged_in"
      class="flex items-center font-bold text-lg bg-custom-1200 pt-5 px-6">
    <!-- 图片使用vue的:src来处理模板字符串-->
    <img :src="`https://visage.surgeplay.com/bust/64/${id}`"
         alt="Ba1oretto's Minecraft Skin"/>
    <div class="ml-5">
      <div class="label text-xs uppercase tracking-widest leading-none text-gray-500">Shopping As</div>
      <div class="username">{{ userName }}</div>
    </div>
  </div>
  <div
      v-show="!logged_in"
      class="flex items-center font-bold text-lg bg-gray-800 pt-5 px-6"><img
      src="https://visage.surgeplay.com/bust/64/c06f89064c8a49119c29ea1dbd1aab82" alt="Guest Minecraft Skin">
    <div class="ml-5">
      <div class="label text-xs uppercase tracking-widest leading-none text-gray-500">Guest</div>
      <div class="username">Login to Purchase</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserContent"
}
</script>
<script setup>

import {onBeforeMount, ref, toRef, toRefs, watch} from "vue";
import {getCurrentInstance} from "vue";


let ctx = getCurrentInstance()
let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')
let userName = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'ign')
let id = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'uuid')

watch(logged_in, (newValue, oldValue) => {
  console.log('logged_in的值变化了', newValue, oldValue)
}, {deep: true})

onBeforeMount(() => {
  console.log(logged_in)
})
</script>
