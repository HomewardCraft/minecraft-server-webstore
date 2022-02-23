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
/* 普通样式 */
.simple {
  display: flex;
}

/* 钱包位置的样式*/
.wallet-style {
  width: 1.25rem;
  height: 1.25rem;
  margin-right: 0.75rem;
}

/*钱包图片样式*/
.wallet-image {
  display: block;
  vertical-align: middle;
}


</style>