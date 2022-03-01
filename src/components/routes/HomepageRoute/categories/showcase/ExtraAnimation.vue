<template>
  <div class="render">
    <div class="layer-regular"/>
    <div class="layer-hover"/>
  </div>
</template>

<script>
export default {
  name: "ExtraAnimation"
}
</script>

<style scoped>
.categories .category.category-extras .render div {
  background-size: 240px auto;
  background-position: bottom 0 left 10px;
}

.categories .category.category-extras .render .layer-regular {
  background-image: url(./src/assets/images/homepage/extras.png);
}

@screen lg {
  .categories .category.category-extras .render div {
    background-size: 240px auto;
    background-position: bottom 10px left 30px;
  }
}

.categories .category.category-extras .render .layer-hover {
  background-image: url(./src/assets/images/homepage/extras_hover.png);
}

@screen lg {
  .categories .category.category-extras .render div {
    background-size: 240px auto;
    background-position: bottom 10px left 30px;
  }
}
</style>