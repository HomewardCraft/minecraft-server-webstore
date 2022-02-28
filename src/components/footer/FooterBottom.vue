<template>
<div class="container mx-auto flex flex-col md:flex-row md:items-center p-6">
  <co-animation/>
  <co-info/>
</div>
</template>

<script>
import CoInfo from "./bottom/CoInfo.vue";
import CoAnimation from "./bottom/CoAnimation.vue";
export default {
  name: "FooterBottom",
  components: {CoAnimation, CoInfo},
}
</script>

<style scoped>

</style>