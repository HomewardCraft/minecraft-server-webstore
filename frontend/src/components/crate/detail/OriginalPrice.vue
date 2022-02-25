<template>
<div class="price-font price-position">
${{ price | priceFormat }} USD
</div>
</template>

<script>
export default {
  name: "OriginalPrice",
  props: ['unhandledPrice', 'amount'],
  computed: {
    price() {
      return this.unhandledPrice * this.amount
    }
  }
}
</script>

<style scoped>
.price-position{
  padding-top: 0.785rem;
  padding-bottom: 0.225rem;
}

.price-font {
  opacity: .5;
  font-size: 1.25rem;
  line-height: 1.25rem;
}
</style>