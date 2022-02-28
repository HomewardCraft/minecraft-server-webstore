<template>
<div class="container mx-auto flex flex-col md:flex-row md:items-center p-6">
  <co-info/>
</div>
</template>

<script>
import CoInfo from "./bottom/CoInfo.vue";
export default {
  name: "FooterBottom",
  components: {CoInfo},
}
</script>

<style scoped>

</style>