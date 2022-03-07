<template>
  <div class="render">
    <div class="layer-regular"/>
    <div class="layer-hover"/>
  </div>
</template>

<script>
export default {
  name: "CrateAnimation"
}
</script>

<style scoped>
.categories .category.category-crates .render div {
  background-size: 220px auto;
  background-position: bottom -20px left 10px;
}

.categories .category.category-crates .render .layer-regular {
  background-image: url(./src/assets/images/homepage/crates.png);
}

@screen lg {
  .categories .category.category-crates .render div {
    background-size: auto;
    background-position: bottom 30px left 50px;
  }
}

.categories .category.category-crates .render .layer-hover {
  background-image: url(./src/assets/images/homepage/crates_hover.png);
}

@screen lg {
  .categories .category.category-crates .render div {
    background-size: auto;
    background-position: bottom 30px left 50px;
  }
}
</style>