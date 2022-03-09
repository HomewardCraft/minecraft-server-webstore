<template>
  <div class="lg:col-span-3 p-8 bg-gray-800">
    <div class="font-bold text-xl mb-4 text-gray-50/80">如何知道我的用户名?</div>
    <editorrender/>
  </div>
</template>

<script>
export default {
  name: "EditorDescribe"
}
</script>

<script setup>


import Editorrender from "./edit/defineComponent.vue";
</script>

<style scoped>

</style>