<template>
  <div class="flex main-text flex-col lg:flex-row text-xl items-center justify-center">
    <div class="text">Spend $10+ USD for 1x Free Cosmetic Crate Key!</div>
  </div>
  <div class="lg:flex items-center justify-center w-full lg:w-auto">
    <progress-bar/>
  </div>
</template>

<script>
import ProgressBar from "./ProgressBar.vue";
export default {
  name: "SpecialBar",
  components: {ProgressBar}
}
</script>

<style scoped>
.special-bar .main-text .text {
  padding: 16px;
}
</style>