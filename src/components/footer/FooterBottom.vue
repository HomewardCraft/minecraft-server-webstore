<template>
  <div class="container mx-auto flex flex-col md:flex-row md:items-center p-6">
    <website-info/>
  </div>
</template>

<script>
import websiteInfo from "@/components/footer/bottom/WebsiteInfo";

export default {
  name: "FooterBottom",
  components: {
    websiteInfo
  }
}
</script>

<style scoped>

</style>