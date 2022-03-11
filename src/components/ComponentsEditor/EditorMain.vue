<template>
  <div class="flex justify-around items-center">
    <div class="item-image">
      <div class="h-52 w-52 relative bg-gray-800 bg-bottom bg-no-repeat border border-light border-b-0">
      <!-- image here -->
      </div>
      <div @click="changeImageShowCaseCondition" class="bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light border-t-0 text-gray-300 flex items-center justify-center text-center cursor-pointer py-2 font-bold opacity-100 transition-colors duration-150 ease-in-out">
        <span>上传图片</span>
        <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
        </svg>
      </div>
    </div>

    <div class="item-info grid gap-3">
      <button @click="changeCategoryShowCaseCondition" class="item-category">
        <span>{{information.category}}</span>
      </button>

      <transition name="item">
        <div v-show="categoryShowCase.isOpen" class="item-categories transition-all ease-in-out duration-200 bg-gray-800 shadow-lg rounded grid grid-flow-col z-50">
          <button v-show="categories.crate" @click="changeCategoryShowCase('Crate')" class="category h-full font-bold">
            <span>Crate</span>
          </button>
          <button v-show="categories.extra" @click="changeCategoryShowCase('Extra')" class="category h-full font-bold">
            <span>Extra</span>
          </button>
        </div>
      </transition>

      <div class="item-name my-auto">
        <h3>物品名称</h3>
        <input v-model="information.name" maxlength="24" placeholder="物品的名称"/>
      </div>

      <button @click="changeDiscountShowCaseCondition" class="item-count">
        <span>折扣</span>
      </button>

      <transition name="item">
        <div v-show="discountShowCase.isOpen" class="item-discount pointer-events-none grid grid-cols-2 my-auto transition-all ease-in-out duration-200 z-50">
          <div class="discount-inner pointer-events-auto">
            <h3 class="text-white font-bold">额度 (%)</h3>
            <input v-model="information.discount" maxlength="2" type="number" placeholder="78%" class="appearance-none"/>
          </div>
        </div>
      </transition>

      <div class="item-price my-auto grid">
        <h3 class="font-bold mb-2">物品价格</h3>
        <input v-model="information.price" maxlength="7" type="number" placeholder="1元等于100" class="appearance-none"/>
      </div>

      <div class="item-command my-auto">
        <h3 class="font-bold ">附带指令</h3>
        <input v-model="information.command" maxlength="128" placeholder="例如 /minecraft give @p items"/>
      </div>
    </div>
  </div>
  <div class="item-row-2 bg-gray-800 w-min p-8 grid">
    <transition name="item">
      <MdEditor v-show="test" :showCodeRowNumber="true" theme="dark" class="md-editor bg-gray-800 border-lighten h-700" previewTheme="github"
                :toolbarsExclude="['link', 'mermaid', 'github', 'revoke', 'next']" v-model="data.text"
                mermaidJs="node_modules/mermaid/dist/mermaid.min.js" katexJs="node_modules/katex/dist/katex.min.js" :sanitize="sanitize"
                @onSave="execSave"/>
    </transition>
    <div :class="imageUploadStyle.style" class="image-upload ease-in-out transition-opacity duration-500 bg-gray-800 p-8 h-700 flex border border-lighten">
      <div class="regular top-2.5 bg-gray-900 border border-lighten">
        <div class="image" :style="regular"/>
        <div class="title">
          <span class="text-4xl">regular</span>
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
          </svg>
        </div>
      </div>
      <div class="hover top-2.5 bg-gray-900 border border-lighten border-l-0">
        <div class="image" :style="hover"/>
        <div class="title">
          <span class="text-4xl">hover</span>
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
          </svg>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {reactive, ref} from "vue";
import commit from "../../hooks/commit.js";
import pubsub from "pubsub-js";
import {watch} from 'vue'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import sanitizeHtml from 'sanitize-html';


let imageUploadStyle = reactive({
  style: 'opacity-0 pointer-events-none',
  isShow: false
})
let test = ref(true)
function changeImageShowCaseCondition() {
  test.value = !test.value
  if (imageUploadStyle.isShow) {
    imageUploadStyle.style = 'opacity-0 pointer-events-none'
    imageUploadStyle.isShow = false
  } else {
    imageUploadStyle.style = 'opacity-100 pointer-events-auto'
    imageUploadStyle.isShow = true
  }
}

//--------------------------------------------------------//
const sanitize = (html) => sanitizeHtml(html)
let data = reactive({
  text: '',
  cache: ''
})
let cacheTimer
function getMarkdownContent() {
  data.text = localStorage.getItem('markdownText')
}
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
getMarkdownContent()

//--------------------------------------------------------//
let categoryShowCase = reactive({
  isOpen: false
})
let discountShowCase = reactive({
  isOpen: false
})
let categories = reactive({
  crate: true,
  extra: true
})
function changeCategoryShowCaseCondition() {
  categoryShowCase.isOpen = !categoryShowCase.isOpen
  discountShowCase.isOpen = false
}
function changeCategoryShowCase(type) {
  categoryShowCase.isOpen = false
  information.category = type
  setTimeout(() => {
    if (type === 'Crate') {
      categories.crate = false
      categories.extra = true
    } else {
      categories.extra = false
      categories.crate = true
    }
  }, 300)
}
function changeDiscountShowCaseCondition() {
  discountShowCase.isOpen = !discountShowCase.isOpen
  categoryShowCase.isOpen = false
}


//--------------------------------------------------------//
let information = reactive({
  category: '类型',
  name: null,
  price: null,
  discount: null,
  command: null,
  markdownText: null,
  imageAddress: null
})
function execCommit() {
  commit(information)
}
pubsub.subscribe('commit', execCommit)


//--------------------------------------------------------//
let imageRegular = 'https://ba1oretto.com/webstore/images/crates/cosmetic_crate.png'
let imageHover = 'https://ba1oretto.com/webstore/images/crates/cosmetic_crate_hover.png'
let regular = ref({
  'backgroundImage': 'url(' + imageRegular + ')'
})
let hover = ref({
  'backgroundImage': 'url(' + imageHover + ')'
})
</script>

<script lang="ts">
export default {
  name: "EditorMain"
}
</script>

<style>
.regular .title, .hover .title {
  padding-top: 4.45rem;
  padding-bottom: 4.45rem;
  @apply bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light text-gray-300 flex items-center justify-center text-center cursor-pointer font-bold opacity-100 transition-colors duration-150 ease-in-out
}

.image-upload .regular, .image-upload .hover {
  width: 100%;
  margin: 0 auto;
  position: relative;
  @apply flex flex-col justify-end
}
.image-upload .regular .image,.image-upload .hover .image {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
  height: 28rem;
  @apply bg-bottom bg-no-repeat border-b-lighten border-b
}

#editorPanel.body .item-row-2 {
  grid-column: 1;
  grid-row: 2;
}

#editorPanel.body .image-upload {
  min-width: 850px;
  grid-column: 1;
  grid-row: 1;
}

#editorPanel.body .md-editor {
  grid-column: 1;
  grid-row: 1;
}

.item-discount .discount-inner {
  grid-column: 2;
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

.item-leave-active {
  animation: imba ease-in-out 0.3s reverse;
}

.item-enter-active {
  animation: imba ease-in-out 0.3s;
}

@keyframes imba {
  from {
    transform: translateY(-30px);
    opacity: 0;
  }
  to {
    transform: translateY(0px);
    opacity: 1;
  }
}

.item-info button {
  @apply my-auto items-center justify-center font-bold transition-colors duration-150 ease-in-out rounded bg-gray-800 text-gray-500 py-2.5 hover:bg-yellow-400 hover:text-yellow-900
}

#editorPanel.body .item-discount {
  grid-column: 2;
  grid-row: 2;
}

#editorPanel.body .item-info {
  justify-content: flex-end;
  flex-grow: 0.8;
  grid-template-columns: 320px 320px;
  grid-template-rows: 50px 90px 90px;
}

#editorPanel.body .item-info input {
  width: 100%;
  @apply bg-gray-800 text-white py-2.5 px-4 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}

#editorPanel.body h3 {
  font-size: 1.25rem;
  line-height: 2rem;
  @apply text-gray-500 mb-1 font-bold
}

#editorPanel.body .item-category {
  font-size: 1.25rem;
  grid-column: 1;
  grid-row: 1;
}

#editorPanel.body .item-categories {
  grid-column: 1;
  grid-row: 2;
  font-size: 1.25rem;
  height: 92%;
}

#editorPanel.body .item-name {
  grid-column: 1;
  grid-row: 2;
}

#editorPanel.body .item-count {
  font-size: 1.25rem;
  grid-column: 2;
  grid-row: 1;
}

#editorPanel.body .item-price {
  grid-column: 2;
  grid-row: 2;
}

#editorPanel.body .item-command {
  grid-column-start: 1;
  grid-column-end: 3;
  grid-row: 3;
}
</style>