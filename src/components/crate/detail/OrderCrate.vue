<template>
  <div class="position group-hover:text-yellow">
    <div class="wallet-style wallet-image el-icon-wallet "/>
    <span class="text-style">Buy Now</span>
  </div>
</template>

<script>
export default {
  name: "OrderCrate"
}
</script>

<style scoped>
.position {
  padding-top: 0.5rem;
}

.group:hover .group-hover\:text-yellow{
  color: rgba(146, 64, 14, 1);
}

.text-style {
  padding-right: 0.2rem;
}

/* 钱包位置的样式*/
.wallet-style {
  width: 1.25rem;
  height: 1.05rem;
  margin-right: 0.5rem;
}

/*钱包图片样式*/
.wallet-image {
  vertical-align: middle;
  fill-rule: evenodd;
}
</style>