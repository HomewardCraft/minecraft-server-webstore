<template>
</template>

<script>
export default {
  name: "ItemPicture"
}
</script>

<script setup>
const props = defineProps(['imageAddress', 'imageHoverAddress']);
const imageAddress = {
  regular: props.imageAddress,
  hover: props.imageHoverAddress
}
</script>