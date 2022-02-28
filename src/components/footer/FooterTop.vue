<template>
  <div class="top bg-yellow-500">
    <div class="container mx-auto">
      <div class="md:ml-110 py-3 px-6 md:flex md:items-center md:justify-between">
        <co-website/>
      </div>
    </div>
  </div>
</template>

<script>
import CoWebsite from "./top/CoWebsite.vue";
export default {
  name: "FooterTop",
  components: {CoWebsite}
}
</script>

<style scoped>

</style>