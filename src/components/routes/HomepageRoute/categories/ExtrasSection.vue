<template>
  <router-link to="/extras" class="category category-extras">
    <extra-animation/>
    <div class="label capitalize">extras</div>
  </router-link>
</template>

<script>
import ExtraAnimation from "./showcase/ExtraAnimation.vue";
export default {
  name: "ExtrasSection",
  components: {ExtraAnimation}
}
</script>

<style scoped>
@screen lg {
  .category-extras {
    grid-column: 1;
    grid-row: 2;
  }
}

.categories .category.category-extras {
  background: linear-gradient(50deg,#bd4e23,#dea338);
}
</style>