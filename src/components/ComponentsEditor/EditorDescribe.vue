<template>
  <div class="bg-gray-800 w-min p-8">
    <MdEditor :showCodeRowNumber="true" theme="dark" class="bg-gray-800 border-lighten h-700" previewTheme="github"
              :toolbarsExclude="['link', 'mermaid', 'github', 'revoke', 'next']" v-model="data.text"
              mermaidJs="node_modules/mermaid/dist/mermaid.min.js" katexJs="node_modules/katex/dist/katex.min.js" :sanitize="sanitize"
              @onSave="execSave"/>
  </div>
</template>

<script setup lang="ts">
import {reactive, watch} from 'vue'
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

function getMarkdownContent() {
  data.text = localStorage.getItem('markdownText')
}
getMarkdownContent()

const execSave = (v: string): void => {
  localStorage.setItem('markdownText', v)
}

watch(() => data.text, (count) => {
  setTimeout(() => {
    data.cache = count
  }, 500)
})

function persistCache() {
  localStorage.setItem('markdownText', data.cache)
}
pubsub.subscribe('saveLocalCache', persistCache)
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