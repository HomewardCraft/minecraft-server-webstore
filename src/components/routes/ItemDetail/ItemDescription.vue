<template>
  <div class="description">
    <span>物品描述: </span>
    <div id="description" v-show="true" v-html="props.description" class="content-wrap"/>
    <textarea v-model="props.item.rawDescription"/>
  </div>
</template>

<script>
export default {
  name: "ItemDescription"
}
</script>

<script setup>
const props = defineProps(['item', 'description']);
</script>