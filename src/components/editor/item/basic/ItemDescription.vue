<template>
  <transition name="item">
    <MdEditor v-show="moduleCondition.editorCondition" :showCodeRowNumber="true" theme="dark" class="md-editor bg-gray-800 border-lighten h-700" previewTheme="github"
              :toolbarsExclude="['link', 'mermaid', 'github', 'revoke', 'next']" v-model="cache.markdownText"
              mermaidJs="node_modules/mermaid/dist/mermaid.min.js" katexJs="node_modules/katex/dist/katex.min.js" :sanitize="sanitize"
              @onSave="synchronizeMarkdownText" @onHtmlChanged="synchronizeHTMLCode"/>
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
const props = defineProps(['moduleCondition', 'cache']);

const cache = props.cache
const moduleCondition = props.moduleCondition

const sanitize = (html) => sanitizeHtml(html)

const synchronizeMarkdownText = (v: string): void => {
  cache.markdownText = v
}
const synchronizeHTMLCode = (v: String): void => {
  cache.htmlText = v
}
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