<template>
  <router-link to="/crates" class="category category-crates">
    <crate-animation/>
    <div class="label capitalize">crates</div>
  </router-link>
</template>

<script>
import CrateAnimation from "./showcase/CrateAnimation.vue";
export default {
  name: "CratesSection",
  components: {CrateAnimation}
}
</script>

<style scoped>
@screen lg {
  .category-crates {
    /*grid-column: 1;*/
    /*grid-row: 1;*/
  }
}

.categories .category.category-crates {
  background: linear-gradient(50deg, #dc1628, #ea632e);
}

.homepage .categories .category.category-crates:before {
  display: block;
}
</style>