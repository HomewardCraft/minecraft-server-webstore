<template>
  <div class="image bg-gray-800 border border-light px-4 py-10 mb-6">
    <img :src="props.imageAddress" draggable="false" :alt="props.name" class="max-w-full mx-auto">
  </div>
</template>

<script>
export default {
  name: "ItemPicture"
}
</script>

<script setup>
const props = defineProps(['imageAddress', 'name']);
</script>