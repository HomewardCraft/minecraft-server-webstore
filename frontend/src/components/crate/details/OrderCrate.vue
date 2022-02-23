<template>
  <div>
    <div class="simple el-icon-wallet wallet-style wallet-image"/>
    <span>Buy Now</span>
  </div>
</template>

<script>
export default {
  name: "OrderCrate"
}
</script>

<style scoped>
.simple {
  display: flex;
}

.wallet-style {
  width: 1.25rem;
  height: 1.25rem;
  margin-right: 0.75rem;
}

.wallet-image {
  display: block;
  vertical-align: middle;
}


</style>