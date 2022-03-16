<template>
  <div class="price font-extrabold mb-6">
    <div class="discount line-through italic text-gray-700" v-if="rawInfo.saleCondition">${{ rawInfo.originPrice }} USD</div>
    <div class="final text-2xl text-yellow-400" v-if="!rawInfo.saleCondition">${{ rawInfo.price }} USD</div>
    <div class="flex items-center h-14" v-if="rawInfo.saleCondition">
      <div class="text-3xl text-yellow-400 pt-5">${{ rawInfo.price }} USD</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ItemPrice"
}
</script>

<script setup>
const props = defineProps(['rawInfo']);
const rawInfo = props.rawInfo
</script>