<template>
  <div class="top bg-yellow-500">
    <div class="container mx-auto">
      <div class="md:ml-48 max-w-4xl py-3 px-6 md:flex md:items-center md:justify-between">
        <co-website/>
        <co-sns/>
      </div>
    </div>
  </div>
</template>

<script>
import CoWebsite from "./top/CoWebsite.vue";
import CoSns from "./top/CoSns.vue";
export default {
  name: "FooterTop",
  components: {CoSns, CoWebsite}
}
</script>