<template>
  <div class="mb-16">
    <div class="container mx-auto sm:px-10 lg:px-20 flex items-center justify-between">
      <logo-image/>
    </div>
  </div>
</template>

<script>
import LogoImage from "./header/LogoImage.vue";
export default {
  name: "PageHeader",
  components: {LogoImage}
}
</script>