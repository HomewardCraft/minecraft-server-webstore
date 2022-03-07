<template>
  <div class="image">
    <div class="layer lv1"/>
    <div class="layer lv2"/>
    <div class="layer lv3"/>
    <div class="layer lv4"/>
    <div class="layer lv5"/>
  </div>
  <div class="text lg:w-1/2 leading-none font-bold text-center lg:text-left">
    <div class="lg text-5xl mb-2">Happy Arcane Year !</div>
    <div class="sm text-xl uppercase text-yellow-300">25% off store sale</div>
  </div>
</template>

<script>
export default {
  name: "ItemPromotion"
}
</script>

<style scoped>
@screen xl {
  .promotion .image {
    width: 520px;
  }
}

@screen lg {
  .promotion .image {
    display: block;
    position: absolute;
    bottom: 0;
    top: 0;
    right: 20px;
    width: 420px;
  }

  .promotion .image .layer.lv1 {
    background: none 100% 100% no-repeat;
    background-size: auto 200px;
    right: 30px;
  }

  .promotion .image .layer.lv2 {
    background: none no-repeat;
    left: -140px;
  }

  .promotion .text {
    max-width: 350px;
  }
}

.promotion .image {
  display: none;
  width: 468px;
}

.promotion .text {
  position: relative;
  z-index: 10;
}
</style>