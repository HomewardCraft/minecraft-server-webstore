<template>
  <div class="button flex justify-between items-center flex-grow">
    <div class="cancel bg-red-600">取消</div>
    <div @click="props.execCommit" class="confirm bg-green-700">保存</div>
  </div>
</template>

<script>
export default {
  name: "ItemButton"
}
</script>

<script setup>
const props = defineProps({
  execCommit: Function
});
</script>