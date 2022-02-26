<!-- 左侧图片 -->
<template>
<div class="crate-row">
  <div class="image-regular crate-image"
       :style="crate"
       @mouseenter="enable"
       @mouseleave="disable"
  />
  <!--<div class="image-regular crate-image"/>-->
</div>
</template>

<script>
export default {
  name: "CrateImage",
  props: ['uri'],
  data() {
    return {
      imageAddress: this.uri,
      crate: {
        'backgroundImage': 'url(' + this.imageAddress + ')'
      }
    }
  },
  computed: {
    hoverAddress() {
      return this.imageAddress.slice(0, this.imageAddress.length-13) + '_open' + this.imageAddress.slice(this.imageAddress.length-13)
    }
  },
  methods: {
    enable() {
      this.crate = {
        'background-image': 'url(' + this.hoverAddress + ')',
        'transition-timing-function': 'cubic-bezier(.4,0,.2,1)'
      }
    },
    disable() {
      this.crate = {
        'transition': 'all .35s',
        'transition-timing-function': 'cubic-bezier(.4,0,.2,1)',
        'backgroundImage': 'url(' + this.imageAddress + ')'
      }
    }
  }
}
</script>

<style scoped>
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