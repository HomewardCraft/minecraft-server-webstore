<template>
  <div class="item-image">
    <div class="h-52 w-52 relative bg-gray-800 bg-bottom bg-no-repeat border border-light border-b-0">
      <div class="image group">
        <div v-show="cache.category === 'crates'">
          <div class="regular transition-opacity duration-300 ease-in-out group-hover:opacity-0" :style="{backgroundImage:'url(' + cache.imageAddress.crate.regular + ')'}"/>
          <div class="hover opacity-0 transition-opacity duration-300 ease-in-out group-hover:opacity-100" :style="{backgroundImage:'url(' + cache.imageAddress.crate.hover + ')'}"/>
        </div>
        <div v-show="cache.category === 'extras'">
          <div class="regular" :style="{backgroundImage:'url(' + cache.imageAddress.extra + ')'}"/>
        </div>
      </div>
    </div>
    <div :class="cache.clickable" @click="changeImageShowCaseCondition" class="bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light border-t-0 text-gray-300 flex items-center justify-center text-center cursor-pointer py-2 font-bold opacity-100 transition-colors duration-150 ease-in-out">
      <span>{{moduleCondition.buttonMessage}}</span>
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
const props = defineProps(['moduleCondition', 'cache']);

const moduleCondition = props.moduleCondition
const cache = props.cache

function changeImageShowCaseCondition() {
  moduleCondition.editorCondition = !moduleCondition.editorCondition
  if (moduleCondition.imageUpload.enable) {
    moduleCondition.buttonMessage = '上传图片'
    moduleCondition.imageUpload.style = 'opacity-0 pointer-events-none'
    moduleCondition.imageUpload.enable = false
  } else {
    moduleCondition.buttonMessage = '编辑描述'
    moduleCondition.imageUpload.style = 'opacity-100 pointer-events-auto'
    moduleCondition.imageUpload.enable = true
  }
}
</script>

<style>

@screen lg {
  .item-image .image {
    max-width: 100%;
    margin-left: 1.5rem;
  }
}

.item-image .image {
  min-height: 206px;
  max-width: 206px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

.item-image .image .regular, .item-image .image .hover {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
}
</style>