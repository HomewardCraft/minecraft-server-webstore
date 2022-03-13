<template>
  <div class="flex justify-around items-center">
    <item-image :editorCondition="editorCondition" :imageUploadStyle="imageUploadStyle" :imageAddress="imageAddress"/>

    <div class="item-info grid gap-3">
      <item-category :information="information" :categoryShowCase="categoryShowCase" :categories="categories" :discountShowCase="discountShowCase"/>

      <item-name :information="information"/>

      <item-discount :categoryShowCase="categoryShowCase" :discountShowCase="discountShowCase" :categories="categories" :information="information"/>

      <item-price :information="information"/>

      <item-command :information="information"/>
    </div>
  </div>

  <div class="item-row-2 bg-gray-800 w-min p-8 grid">
    <item-describe :editorCondition="editorCondition" :data="data"/>

    <upload-image :imageUploadStyle="imageUploadStyle" :imageAddress="imageAddress" :information="information"/>
  </div>
</template>

<script setup lang="ts">
import {reactive} from "vue";
import commit from "../../hooks/commit.js";
import pubsub from "pubsub-js";
import 'md-editor-v3/lib/style.css';
import UploadImage from "./item/image/UploadImage.vue";

let imageAddress = reactive({
  regular: '',
  hover: ''
})

let imageUploadStyle = reactive({
  style: 'opacity-0 pointer-events-none',
  isShow: false
})

let editorCondition = reactive({
  isShow: true
})

let data = reactive({
  text: '',
  cache: ''
})

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

let information = reactive({
  category: '类型',
  name: null,
  price: null,
  discount: null,
  multiDiscount: {
    x1: null,
    x5: null,
    x10: null,
    x20: null,
  },
  command: null,
  markdownText: '',
  imageAddress: null,
  imageName: null,
})
function execCommit() {
  information.markdownText = data.text
  commit(information)
}
pubsub.subscribe('commit', execCommit)
</script>

<script lang="ts">
import ItemImage from "./item/basic/ItemImage.vue";
import ItemCategory from "./item/basic/ItemCategory.vue";
import ItemName from "./item/basic/ItemName.vue";
import ItemDiscount from "./item/basic/ItemDiscount.vue";
import ItemPrice from "./item/basic/ItemPrice.vue";
import ItemCommand from "./item/basic/ItemCommand.vue";
import ItemDescribe from "./item/basic/ItemDescribe.vue";

export default {
  name: "EditorMain",
  components: {
    ItemImage,
    ItemCategory,
    ItemName,
    ItemDiscount,
    ItemPrice,
    ItemCommand,
    ItemDescribe,
  }
}
</script>

<style>
.editor .item-row-2 {
  grid-column: 1;
  grid-row: 2;
}

.item-leave-active {
  animation: imba ease-in-out 0.3s reverse;
}

.item-enter-active {
  animation: imba ease-in-out 0.3s;
}

.editor .item-info {
  justify-content: flex-end;
  flex-grow: 0.8;
  grid-template-columns: 320px 320px;
  grid-template-rows: 50px 90px 90px;
}
.editor .item-info button {
  @apply my-auto items-center justify-center font-bold transition-colors duration-150 ease-in-out rounded bg-gray-800 text-gray-500 py-2.5 hover:bg-yellow-400 hover:text-yellow-900
}
.editor .item-info input {
  width: 100%;
  @apply bg-gray-800 text-white py-2.5 px-4 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}
</style>