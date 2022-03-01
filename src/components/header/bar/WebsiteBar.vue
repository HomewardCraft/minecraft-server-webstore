<template>
  <div class="top-100 text-right z-20 uppercase font-bold cursor-pointer hidden md:flex items-center">
    <homeward-address/>
  </div>
</template>

<script>
import HomewardAddress from "./website/HomewardAddress.vue";
export default {
  name: "WebsiteBar",
  components: {HomewardAddress}
}
</script>