<template>
  <nav class="navigate mb-2 z-40">
    <div class="mobile ml-auto block md:hidden p-8">
      <mobile-v/>
    </div>
    <div class="desktop flex md:items-center md:flex-row flex-col">
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