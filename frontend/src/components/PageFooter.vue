<template>
<div class="bg-yellow-400 mt-20">
  <footer-top/>

  <div class="container mx-auto flex flex-col md:flex-row md:items-center p-6"></div>

</div>
</template>

<script>
import footerTop from "@/components/footer/FooterTop";
import footerBottom from "@/components/footer/FooterBottom";

export default {
  name: "PageFooter",
  components: {
    footerTop,
    footerBottom
  }
}
</script>

<style scoped>

</style>