<template>
  <h3 class="package-title font-bold text-5xl text-white mb-4">{{ props.name }}</h3>
</template>

<script>
export default {
  name: "ItemTitle"
}
</script>

<script setup>
const props = defineProps(['name']);
</script>