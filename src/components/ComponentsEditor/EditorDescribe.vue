<template>
  <div class="bg-gray-800 w-min p-8">
    <MdEditor :showCodeRowNumber="true" theme="dark" class="bg-gray-800 border-lighten h-700"
              :toolbarsExclude="['link', 'mermaid', 'github', 'revoke', 'next']" v-model="data.text"
              mermaidJs="node_modules/mermaid/dist/mermaid.min.js" katexJs="node_modules/katex/dist/katex.min.js" :sanitize="sanitize"
              :onChange="execCache" @onSave="execSave"/>
  </div>
</template>

<script setup lang="ts">
import {reactive} from 'vue'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import sanitizeHtml from 'sanitize-html';
import pubsub from "pubsub-js";

const sanitize = (html) => sanitizeHtml(html)

let data = reactive({
  text: '',
  cache: ''
})

let cacheTimer

const execSave = (v: string): void => {
  localStorage.setItem('textSave', v)
}
const execCache = (v: string): void => {
  clearTimeout(cacheTimer)
  cacheTimer = setTimeout(() => {
    data.cache = v
  }, 500)
}

function saveLocalCache() {
  localStorage.setItem('textSave', data.cache)
}
pubsub.subscribe('saveLocalCache', saveLocalCache)
</script>

<script lang="ts">
export default {
  name: "EditorDescribe"
}
</script>

<style>
.md-toolbar-wrapper .md-toolbar {
  @apply border-b-lighten
}

.md-content .md-input-wrapper textarea {
  overflow: auto;
  border-right: solid;
  @apply border-r-lighten border-r
}

.md-content .md-input-wrapper textarea.textarea-only {
  border: none;
}
</style>