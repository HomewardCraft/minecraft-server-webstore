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
const props = defineProps(['imageAddress'])

const imageAddress = props.imageAddress

const regular = {
  'backgroundImage': 'url(' + imageAddress.regular + ')'
}

const hover = {
  'backgroundImage': 'url(' + imageAddress.hover + ')'
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

.crate-row .image .regular, .crate-row .image .hover {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
}

.crate-row .image .regular, .crate-row .image .hover {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
}
</style>