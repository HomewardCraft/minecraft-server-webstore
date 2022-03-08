<template>
  <router-link to="/" class="category category-ranks">
    <post-animation/>
    <div class="label capitalize">Posts</div>
  </router-link>
</template>

<script>
import PostAnimation from "./showcase/PostAnimation.vue";
export default {
  name: "PostsSection",
  components: {PostAnimation}
}
</script>

<style scoped>
@screen lg {
  .categories .category.category-ranks {
    grid-column: 1;
    grid-row: 2;
  }
}

.categories .category.category-ranks {
  background: linear-gradient(50deg,#5e127d,#700b82);
}
</style>