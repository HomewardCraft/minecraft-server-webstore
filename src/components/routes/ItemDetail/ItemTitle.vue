<template>
  <div class="title font-bold text-white">
    <div class="inline-flex items-center">
      <span>物品名称:</span>
      <div class="text-3xl text-yellow-400 ml-5">{{ props.name }}</div>
    </div>
    <input v-model="props.item.name">
  </div>
</template>

<script>
export default {
  name: "ItemTitle"
}
</script>

<script setup>
const props = defineProps(['item', 'name']);
</script>