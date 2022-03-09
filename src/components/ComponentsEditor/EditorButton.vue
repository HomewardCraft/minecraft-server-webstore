<template>
  <div class="item-commit flex justify-around">
    <button @click="props.changeEditorPanelCondition" class="cancel bg-btn border border-lighten py-2 px-4 shadow-btn font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center focus:outline-none">
      <span>取消</span>
    </button>
    <button class="save bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center focus:outline-none">
      <span>保存</span>
    </button>
  </div>
</template>

<script setup>
const props = defineProps({
  changeEditorPanelCondition: Function
})
</script>

<script>
export default {
  name: "EditorButton"
}
</script>

<style>
.items-center .save, .items-center .cancel {
  flex-grow: 0.2;
}
</style>