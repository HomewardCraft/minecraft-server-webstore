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

<style>
.categories .category.category-crates .render div {
  background-size: 240px auto;
  background-position: bottom 0 left 10px;
}

.categories .category.category-crates .render .layer-regular {
  background-image: url(./src/assets/images/homepage/crates.png);
}

@screen lg {
  .categories .category.category-crates .render div {
    background-size: 240px auto;
    background-position: bottom 10px left 30px;
  }
}

.categories .category.category-crates .render .layer-hover {
  background-image: url(./src/assets/images/homepage/crates_hover.png);
}

@screen lg {
  .categories .category.category-crates .render div {
    background-size: 240px auto;
    background-position: bottom 10px left 30px;
  }
}
</style>