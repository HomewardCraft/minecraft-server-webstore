<template>
  <div :class="currentStyle" class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out">
    <div class="transition-transform duration-200 ease-in-out transform">
      <div class="title flex items-center justify-between mb-6">
        <editor-title/>
      </div>
      <div class="body bg-gray-900 grid lg:grid-cols-checkout gap-6 checkout p-4">
        <editor-main/>
        <editor-various/>
        <editor-describe/>
        <editor-save/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import pubsub from "pubsub-js";

let currentStyle = ref('opacity-0 pointer-events-none')
let isOpen = false

function changeCondition() {
  if (!isOpen) {
    currentStyle.value = 'opacity-100 pointer-events-auto'
    isOpen = true
  } else {
    currentStyle.value = ref('opacity-0 pointer-events-none')
    isOpen = false
  }
}
pubsub.subscribe('openEditorPanel', changeCondition)
</script>

<script>
import EditorTitle from "../components/ComponentsEditor/EditorTitle.vue";
import EditorMain from "../components/ComponentsEditor/EditorMain.vue";
import EditorVarious from "../components/ComponentsEditor/EditorVarious.vue";
import EditorDescribe from "../components/ComponentsEditor/EditorDescribe.vue";
import EditorSave from "../components/ComponentsEditor/EditorSave.vue";

export default {
  name: "EditorPanel",
  components: {EditorTitle,EditorMain,EditorVarious,EditorDescribe,EditorSave}
}
</script>

<style>
.login section {
  @apply text-4xl
}

.login input {
  @apply bg-gray-800 ml-5 h-full border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}

.login button {
  @apply opacity-90 bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-60 text-center w-full focus:outline-none
}

.modal {
  padding: 40px 0 0;
  overflow: auto;
}

.modal .body {
  max-width: 1000px;
  margin-bottom: 40px;
}

@media (min-width: 992px) {
  .lg\:grid-cols-checkout {
    grid-template-columns: 1fr minmax(260px, 380px);
  }
}
</style>