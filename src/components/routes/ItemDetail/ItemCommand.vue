<template>
  <div class="command w-full">
    <div class="inline-flex items-center">
      <span>物品指令: </span>
      <div class="text-3xl text-yellow-400 ml-5">{{ props.command }}</div>
    </div>
    <textarea v-model="props.item.command" maxlength="128"/>
  </div>
</template>

<script>
export default {
  name: "ItemCommand"
}
</script>

<script setup>
const props = defineProps(['item', 'command']);
</script>