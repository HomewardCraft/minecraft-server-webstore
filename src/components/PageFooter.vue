<template>
  <div class="bg-yellow-400 mt-20">
    <footer-top/>
    <div class="container mx-auto flex flex-col md:flex-row md:items-center p-6"></div>
  </div>
</template>

<script>
import FooterTop from "./footer/FooterTop.vue";
export default {
  name: "PageFooter",
  components: {FooterTop}
}
</script>

<style scoped>

</style>