<template>
  <router-link to="/" class="category category-article">
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
  .category-article {
    grid-column: 1;
    grid-row: 4;
  }
}

.categories .category.category-article {
  background: linear-gradient(50deg, #12547d, #0b1f82);
}
</style>