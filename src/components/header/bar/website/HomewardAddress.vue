<template>
  <div class="flex flex-col relative font-bold text-sm uppercase justify-center items-center lg:items-stretch lg:flex-row transition-opacity duration-200 ease-in-out hover:opacity-80">
    <div class="tooltips ip bg-custom-900 tracking-widest py-2 px-3 border border-lighten" @click="copyIpAddress" data-clipboard-action="copy" :data-clipboard-text="'kkk.fantang.cc'">kkk.fangtang.cc</div>
    <div class="flex items-center px-3 tracking-widest bg-custom-800 text-custom-400 border border-lighten -ml-px">114</div>
    <div class="absolute mt-2 right-0 -bottom-5 pr-0.5 text-xs font-bold uppercase transition-opacity ease-in-out duration-200 text-custom-700" :class="opacity">ip copied!</div>
  </div>
</template>

<script>
export default {
  name: "HomewardAddress"
}
</script>

<script setup>
import {ref} from "vue";
import clickCopyHook from "../../../../hooks/clickCopyHook.js";

let timer
let opacity = ref('opacity-0')

function copyIpAddress() {
  clickCopyHook('.tooltips')

  clearTimeout(timer)
  opacity.value = 'opacity-1'
  timer = setTimeout(() => {
    opacity.value = 'opacity-0'
  }, 2000)
}
</script>

<style scoped>
.ip {
  padding: 6px 14px;
}
</style>