<template>
  <router-link to="/" class="category category-ranks">
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
  .category-ranks {
    grid-column: 1;
    grid-row: 3;
  }
}

.categories .category.category-ranks {
  background: linear-gradient(50deg,#5e127d,#700b82);
}
</style>