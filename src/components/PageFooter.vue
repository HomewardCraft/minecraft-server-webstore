<template>
  <div class="page-footer bg-yellow-400 mt-20">
    <footer-top/>
    <footer-bottom/>
  </div>
</template>

<script>
import FooterTop from "./footer/FooterTop.vue";
import FooterBottom from "./footer/FooterBottom.vue";
export default {
  name: "PageFooter",
  components: {FooterBottom, FooterTop}
}
</script>