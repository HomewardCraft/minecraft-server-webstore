<template>
  <div class="render">
    <div class="layer-regular"/>
    <div class="layer-hover"/>
  </div>
</template>

<script>
export default {
  name: "RankAnimation"
}
</script>

<style scoped>
.categories .category.category-ranks .render div {
  background-size: 180px auto;
  background-position: bottom -30px left 10px;
}

.categories .category.category-ranks .render .layer-regular {
  background-image: url(./src/assets/images/homepage/ranks.png);
}

@screen lg {
  .categories .category.category-ranks .render div {
    background-size: 180px auto;
    background-position: bottom -30px left 20px;
  }
}

.categories .category.category-ranks .render .layer-hover {
  background-image: url(./src/assets/images/homepage/ranks_hover.png);
}

@screen lg {
  .categories .category.category-ranks .render div {
    background-size: 180px auto;
    background-position: bottom -30px left 20px;
  }
}
</style>