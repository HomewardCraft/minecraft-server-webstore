<template>
  <div class="item-image">
    <div class="h-52 w-52 relative bg-gray-800 bg-bottom bg-no-repeat border border-light border-b-0">
      <!-- image here -->
    </div>
    <div @click="changeImageShowCaseCondition" class="bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light border-t-0 text-gray-300 flex items-center justify-center text-center cursor-pointer py-2 font-bold opacity-100 transition-colors duration-150 ease-in-out">
      <span>上传图片</span>
      <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
      </svg>
    </div>
  </div>
</template>

<script>
export default {
  name: "ItemImage"
}
</script>

<script setup>
const props = defineProps(['editorCondition', 'imageUploadStyle']);

let changeEditorCondition = props.editorCondition
let imageUploadStyle = props.imageUploadStyle

function changeImageShowCaseCondition() {
  changeEditorCondition.isShow = !changeEditorCondition.isShow
  if (imageUploadStyle.isShow) {
    imageUploadStyle.style = 'opacity-0 pointer-events-none'
    imageUploadStyle.isShow = false
  } else {
    imageUploadStyle.style = 'opacity-100 pointer-events-auto'
    imageUploadStyle.isShow = true
  }
}
</script>