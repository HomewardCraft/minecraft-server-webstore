<template>
<div class="bg-yellow-400 mt-20">
  <footer-top/>
  <!--<footer-bottom/>-->
  <!--<div class="top bg-yellow-500">-->
  <!--  <div class="container mx-auto">-->
  <!--    &lt;!&ndash; md为media &ndash;&gt;-->
  <!--    <div class="md:ml-110 py-3 px-6 md:flex md:items-center md:justify-between">-->
  <!--      <div class="-->
  <!--      uppercase font-bold text-ip-1000-->
  <!--      text-sm justify-center cursor-pointer flex relative-->
  <!--      lg:items-stretch transition-opacity duration-150 ease-in-out-->
  <!--      hover:opacity-80-->
  <!--      ">-->
  <!--        <div class="bg-yellow-600 tracking-widest py-2 px-3">play.originrealms.com</div>-->
  <!--        <div class="flex items-center px-3 tracking-wide bg-yellow-600 opacity-80">236</div>-->
  <!--      </div>-->
  <!--    </div>-->
  <!--  </div>-->
  <!--</div>-->

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