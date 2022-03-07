<template>
  <nav class="navigate mb-2 z-40">
    <div class="mobile ml-auto block md:hidden p-8" :class="active" @click="changeActivity">
      <mobile-v/>
    </div>
    <div class="desktop flex md:items-center md:flex-row flex-col" :class="active">
      <desktop-v/>
    </div>
  </nav>
</template>

<script>
import DesktopV from "./client/DesktopV.vue";
import MobileV from "./client/MobileV.vue";
export default {
  name: "NavigatorBar",
  components: {MobileV, DesktopV}
}
</script>

<script setup>
import {ref} from "vue";

let isActive = false
let active = ref('')

function changeActivity() {
  if (isActive === false) {
    active.value = 'active'
    isActive = true
  } else {
    active.value = ''
    isActive = false
  }
}
</script>

<style scoped>
.navigate .mobile.active {
  cursor: pointer;
}
.navigate .desktop.active {
  pointer-events: all;
  opacity: 1;
  top: 136px;
  visibility: visible;
}
</style>