<template>
  <div class="crates pt-16">
    <div class="mb-12 crate-row">
      <div class="main bg-gray-900 border border-light grid lg:grid-cols-4">
        <crate-image :imageAddress="imageAddress"/>
        <crate-inner-showcase/>
      </div>
    </div>
  </div>
</template>

<script>
import CrateImage from "./CrateImage.vue";
import CrateInnerShowcase from "./CrateInnerShowcase.vue";
export default {
  name: "CrateShowcase",
  components: {CrateInnerShowcase, CrateImage}
}
</script>

<script setup>
const props = defineProps(['crates'])

let imageAddress = props.crates[0].itemBasicInfo.imageAddress

// props.crates.forEach((crate) => {
//   imageAddress = crate.itemBasicInfo.imageAddress
// })
</script>