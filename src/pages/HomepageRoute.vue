<template>
  <section class="section-categories mb-6">
    <categories-section/>
  </section>
</template>

<script>
import CategoriesSection from "../components/routes/HomepageRoute/CategoriesSection.vue";

export default {
  name: "HomepageRoute",
  components: {CategoriesSection}
}
</script>

<script setup>
import sendRoutePath from "../hooks/sendRoutePath.js";

sendRoutePath()
</script>