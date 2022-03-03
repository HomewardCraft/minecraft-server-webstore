<template>
  <div class="image group">
    <div class="regular transition-opacity duration-300 ease-in-out group-hover:opacity-0" :style="regular"/>
    <div class="hover opacity-0 transition-opacity duration-300 ease-in-out group-hover:opacity-100" :style="hover"/>
  </div>
</template>

<script>
export default {
  name: "CrateImage"
}
</script>

<script setup>
let props = defineProps(['imageAddress'])

let regular = {
  'backgroundImage': 'url(' + props.imageAddress + ')'
}

let hover = {
  'backgroundImage': 'url(' + props.imageAddress.substring(0, props.imageAddress.length - 10) + '_crate_hover.png' + ')'
}
</script>

<style scoped>
@screen lg {
  .crate-row .image {
    max-width: 100%;
    margin-left: 1.5rem;
  }
}

.crate-row .image {
  min-height: 282px;
  max-width: 320px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

/*.crate-row .image[crate-type="cosmetic"] .regular {*/
/*  background-image: url(https://storage.googleapis.com/assets.originrealms.com/static/store/seasonal/cosmo/crate.png);*/
/*}*/

.crate-row .image .regular, .crate-row .image .hover {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
}

/*.crate-row .image[data-crate="cosmetic"] .hover {*/
/*  background-image: url(https://storage.googleapis.com/assets.originrealms.com/static/store/seasonal/cosmo/crate_open.png);*/
/*}*/

.crate-row .image .regular, .crate-row .image .hover {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
}
</style>