<!-- 左侧图片 -->
<template>
<div class="crate-row">
  <div class="image-regular crate-image transition"/>
</div>
</template>

<script>
export default {
  name: "CrateImage",
}
</script>

<style scoped>
/* 神奇代码, 我也不知道原理 */
.transition {
  transition: all .35s;
  transition-timing-function: cubic-bezier(.4,0,.2,1);
}
.transition:hover {
  background-image: url("/src/assets/crates/cosmetic_crate_open.png");
  transition-timing-function: cubic-bezier(.4,0,.2,1);
}

/* 宝箱图片列*/
.crate-row{
  max-width: 100%;
  margin-left: 1.5rem;
}

/* 宝箱图片与宝箱图片列的样式*/
.crate-row .crate-image {
  min-height: 298px;
  max-width: 320px;
  width: 115%;
  margin: 0 auto;
  position: relative;
}

/* 闭合的宝箱的图片 */
.image-regular {
  background-image: url("/src/assets/crates/cosmetic_crate.png");
}

/* 闭合的宝箱的样式 */
.image-regular{
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-position-x: center;
  background-position-y: 5px;
  background-size: cover;
}
</style>