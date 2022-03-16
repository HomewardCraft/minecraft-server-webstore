<template>
  <div v-show="true" v-html="rawHTMLText" class="description content-wrap"/>
  <!--<div v-show="false" v-html="compiledMarkdown"></div>-->

  <div id="editor">
    <textarea :value="input" @input="update"></textarea>
  </div>
</template>

<script>
export default {
  name: "ItemDescription"
}
</script>

<script setup>
import {debounce} from "lodash";
import {computed, onMounted} from "vue";
import isBlank from "../../../hooks/isBlank.js";

const props = defineProps(['description', 'markdown', 'cache']);

const rawHTMLText = props.description

let cache = props.cache
let input = props.markdown.input

const update = debounce((e) => {
  input = cache.markdown = e.target.value
  localStorage.setItem('detailCache', JSON.stringify(cache))
}, 300)
const compiledMarkdown = computed(() => marked(input.value))

</script>