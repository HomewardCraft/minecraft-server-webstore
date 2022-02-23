<template>
<div>
  <div class="price-regular price-regular-font">$49.99 USD</div>
  <div class="price-discount">$44.99 USD</div>
</div>
</template>

<script>
export default {
  name: "DiscountPrice"
}
</script>

<style scoped>
.price-discount {
  opacity: .5;
}

.price-regular {
  opacity: .25;
  text-decoration: line-through;

}

.price-regular-font {
  font-size: .875rem;
  line-height: 1.25rem;
}
</style>