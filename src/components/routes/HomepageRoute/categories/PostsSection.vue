<template>
  <router-link to="/" class="category category-ranks">
    <post-animation/>
    <div class="label capitalize">文章</div>
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
  background: linear-gradient(50deg, #12547d, #0b1f82);
}
</style>