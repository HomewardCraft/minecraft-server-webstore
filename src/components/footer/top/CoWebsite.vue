<template>
  <div class="uppercase font-bold text-custom-1000 text-sm justify-center cursor-pointer flex relative lg:items-stretch transition-opacity duration-150 ease-in-out hover:opacity-80">
    <div class="bg-custom-900 tracking-widest py-2 px-3" @click="copyIpAddress">kkk.fantang.cc</div>
    <div class="flex items-center px-3 tracking-wide bg-custom-900 opacity-75">236</div>
    <div class="absolute mb-2 left-0.5 bottom-0 translate-y-2.5 text-xs font-bold uppercase transition-opacity ease-in-out duration-200 text-custom-700" :class="opacity">ip copied</div>
  </div>
</template>

<script>
export default {
  name: "CoWebsite"
}
</script>

<script setup>
import {ref} from "vue";

let timer
let opacity = ref('opacity-0')

function copyIpAddress() {
  let clipboard = new Clipboard()

  clipboard.

  clearTimeout(timer)
  opacity.value = 'opacity-1'
  timer = setTimeout(() => {
    opacity.value = 'opacity-0'
  }, 2000)
}
</script>

<style scoped>

</style>