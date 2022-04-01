<template>
  <div class="item-price my-auto grid">
    <h3 class="font-bold mb-2">物品价格</h3>
    <input v-model="cache.price" maxlength="7" type="number" placeholder="1元等于100" class="appearance-none"/>
  </div>
</template>

<script>
export default {
  name: "ItemPrice"
}
</script>

<script setup>
const props = defineProps(['cache']);
const cache = props.cache
</script>

<style>
.editor .item-price {
  grid-column: 2;
  grid-row: 2;
}
</style>