<template>
  <div class="item-command my-auto">
    <h3 class="font-bold ">附带指令</h3>
    <input v-model="cache.command" maxlength="128" placeholder="例如 /minecraft give @p items"/>
  </div>
</template>

<script>
export default {
  name: "ItemCommand"
}
</script>

<script setup>
const props = defineProps(['cache']);
const cache = props.cache
</script>

<style>
.editor .item-command {
  grid-column-start: 1;
  grid-column-end: 3;
  grid-row: 3;
}
</style>