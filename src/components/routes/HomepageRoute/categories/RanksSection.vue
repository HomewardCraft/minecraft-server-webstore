<template>
  <router-link to="/ranks" class="category category-ranks">
    <rank-animation/>
    <div class="label capitalize">ranks</div>
  </router-link>
</template>

<script>
import RankAnimation from "./showcase/RankAnimation.vue";
export default {
  name: "RanksSection",
  components: {RankAnimation}
}
</script>

<style scoped>
@screen lg {
  .categories .category.category-ranks {
    grid-column: 2;
    grid-row: 1;
  }
}

.categories .category.category-ranks {
  background: linear-gradient(50deg,#5e127d,#700b82);
}
</style>