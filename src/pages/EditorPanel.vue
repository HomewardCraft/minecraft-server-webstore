<template>
  <div :class="currentStyle" class="editor row-start-1 col-start-1 top-0 flex items-center justify-center transition-opacity duration-300 ease-in-out">
    <div class="transition-transform duration-200 ease-in-out transform ">
      <div class="title mb-6">
        <editor-title/>
      </div>
      <div id="editorPanel" class="editor bg-gray-900 grid grid-cols-1 gap-6 p-4">
        <editor-main/>
        <editor-button :changeEditorPanelCondition="changeEditorPanelCondition" :commit="commit"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import pubsub from "pubsub-js";

let currentStyle = ref('opacity-0 pointer-events-none')
let isOpen = false

function changeEditorPanelCondition() {
  if (!isOpen) {
    isOpen = true
    currentStyle.value = 'opacity-100 pointer-events-auto'
  } else {
    isOpen = false
    currentStyle.value = 'opacity-0 pointer-events-none'
    pubsub.publish('closeEditorPanel')
    pubsub.publish('saveLocalCache')
  }
}
pubsub.subscribe('openEditorPanel', changeEditorPanelCondition)

async function commit() {
  pubsub.publish('commit')
}
</script>

<script>
import EditorTitle from "../components/editor/EditorTitle.vue";
import EditorMain from "../components/editor/EditorMain.vue";
import EditorButton from "../components/editor/EditorButton.vue";

export default {
  name: "EditorPanel",
  components: {EditorTitle,EditorMain,EditorButton}
}
</script>

<style>
.editor {
  background: rgb(2, 4, 9);
}
.editor h3 {
  font-size: 1.25rem;
  line-height: 2rem;
  @apply text-gray-500 mb-1 font-bold
}
</style>