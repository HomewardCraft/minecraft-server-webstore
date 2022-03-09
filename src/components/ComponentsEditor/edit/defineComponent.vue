<template>
  <div class="codeShare bg-gray-800">
    <div>
      <!-- 只读模式 :previewOnly="true" -->
      <!-- :sanitize="sanitize" 使用会导致代码不高亮 -->
      <MdEditor class = "bg-gray-800"
          toolbarsExclude="['link', 'mermaid', 'katex', 'github']"
          v-model="text"
          @onSave="codeSave"
      >
      </MdEditor>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, reactive, toRefs, onMounted} from 'vue'

import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
// 使用 sanitizeHtml 处理不安全的 html
import sanitizeHtml from 'sanitize-html';

interface shareData {
  text: string,
  load: number,
  isDis: boolean
}

export default defineComponent({
  name: "editorrender",
  components: {MdEditor},
  setup() {
    const data = <shareData>reactive({
      text: '',
      load: 0,
      isDis: false
    })

    const codeSave = (v: string): void => {
      localStorage.setItem('codeSave', v)
    }

    const sanitize = (html: string): string => {
      console.log(sanitizeHtml(html))
      return sanitizeHtml(html)
    }

    const href = window.location.href;
    const url = href.substring(0, href.length - 10);


    onMounted(() => {
      if (localStorage.getItem('codeSave')) {
        data.text = localStorage.getItem('codeSave') || ''
      }
    })

    return {
      ...toRefs(data),
      codeSave,
      sanitize,
    }
  },
});
</script>

<style scoped>


/deep/ .md {
  height: 600px !important;
}

</style>
