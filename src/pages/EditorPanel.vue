<template>
  <div :class="currentStyle" class="editor modal fixed bg-black-80 inset-0 flex items-center justify-center transition-opacity duration-300 ease-in-out">
    <div class="transition-transform duration-200 ease-in-out transform">
      <div class="title mb-6">
        <editor-title/>
      </div>
      <div id="editorPanel" class="body bg-gray-900 grid gap-6 p-4">
        <editor-main/>
        <editor-describe/>
        <editor-button :changeEditorPanelCondition="changeEditorPanelCondition"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import pubsub from "pubsub-js";
import axios from "axios";

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
  }
}
pubsub.subscribe('openEditorPanel', changeEditorPanelCondition)


async function commit(value) {
  await axios.post('', {
        category: information.category,
        name: information.name
  })
}
pubsub.subscribe('commit', commit)
</script>

<script>
import EditorTitle from "../components/ComponentsEditor/EditorTitle.vue";
import EditorMain from "../components/ComponentsEditor/EditorMain.vue";
import EditorDescribe from "../components/ComponentsEditor/EditorDescribe.vue";
import EditorButton from "../components/ComponentsEditor/EditorButton.vue";

export default {
  name: "EditorPanel",
  components: {EditorTitle,EditorMain,EditorDescribe,EditorButton}
}
</script>