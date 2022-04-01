<template>
  <div class="price font-bold">
    <div class="inline-flex items-center">
      <span>价格: </span>
      <div class="text-3xl text-yellow-400 ml-5">${{ props.price }} USD</div>
    </div>
    <input v-model="props.tempItem.price" type="number" class="appearance-none">
  </div>
</template>

<script>
export default {
  name: "ItemPrice"
}
</script>

<script setup>
const props = defineProps(['tempItem', 'price']);
</script>