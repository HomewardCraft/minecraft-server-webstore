<template>
  <div class="item-name my-auto">
    <h3>物品名称</h3>
    <input v-model="cache.name" maxlength="24" placeholder="物品的名称"/>
  </div>
</template>

<script>
export default {
  name: "ItemName"
}
</script>

<script setup>
const props = defineProps(['cache']);
const cache = props.cache
</script>

<style>
.editor .item-name {
  grid-column: 1;
  grid-row: 2;
}
</style>