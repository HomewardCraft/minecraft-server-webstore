<template>
  <div class="category-heading pt-4 text-center">
    <div class="text-5xl text-white font-bold">Crates</div>
  </div>
  <crate-showcase/>
</template>

<script>
import CrateShowcase from "../components/routes/CratesRoute/CrateShowcase.vue";
export default {
  name: "CratesRoute",
  components: {CrateShowcase}
}
</script>

<!--<script setup>-->
<!--import sendRoutePath from "../hooks/sendRoutePath.js";-->

<!--sendRoutePath()-->
<!--</script>-->