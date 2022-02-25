<template>
<div>
  <div class="price-regular price-regular-font">${{ originalPrice | priceFormat }} USD</div>
  <div class="price-discount">${{ discountPrice | priceFormat }} USD</div>
</div>
</template>

<script>
export default {
  name: "DiscountPrice",
  props:['amount', 'unhandledPrice', 'onSalePercent'],
  computed: {
    originalPrice() {
      return this.unhandledPrice * this.amount
    },
    discountPrice() {
      return (this.unhandledPrice * (this.onSalePercent / 100)) * this.amount
    }
  }
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