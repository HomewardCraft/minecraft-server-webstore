<template>
  <transition name="item">
    <MdEditor v-show="props.editorCondition.isShow" :showCodeRowNumber="true" theme="dark" class="md-editor bg-gray-800 border-lighten h-700" previewTheme="github"
              :toolbarsExclude="['link', 'mermaid', 'github', 'revoke', 'next']" v-model="data.markdownText"
              mermaidJs="node_modules/mermaid/dist/mermaid.min.js" katexJs="node_modules/katex/dist/katex.min.js" :sanitize="sanitize"
              @onSave="execSave" @onHtmlChanged="getHTMLCode"/>
  </transition>
</template>

<script lang="ts">
export default {
  name: "ItemDescription"
}
</script>

<script setup lang="ts">
import MdEditor from 'md-editor-v3';
import sanitizeHtml from "sanitize-html";
import {watch} from "vue";
import pubsub from "pubsub-js";
const props = defineProps(['editorCondition', 'data']);

let data = props.data

const sanitize = (html) => sanitizeHtml(html)

const execSave = (v: string): void => {
  localStorage.setItem('markdownText', v)
}

const getHTMLCode = (v: String): void => {
  data.htmlText = v
}

watch(() => data.markdownText, (count) => {
  setTimeout(() => {
    data.cache = count
  }, 500)
})

function getMarkdownContent() {
  data.markdownText = localStorage.getItem('markdownText')
}
function persistCache() {
  localStorage.setItem('markdownText', data.cache)
}
pubsub.subscribe('saveLocalCache', persistCache)
getMarkdownContent()
</script>

<style>
.editor .md-editor {
  grid-column: 1;
  grid-row: 1;
}
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