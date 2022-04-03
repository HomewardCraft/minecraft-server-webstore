<template>
  <div class="flex justify-around items-center">
    <item-image :cache="cache" :moduleCondition="moduleCondition"/>
    <div class="item-info grid gap-3">
      <item-category :cache="cache" :moduleCondition="moduleCondition"/>
      <item-name :cache="cache"/>
      <item-discount :cache="cache" :moduleCondition="moduleCondition"/>
      <item-price :cache="cache"/>
      <item-command :cache="cache"/>
    </div>
  </div>
  <div class="item-row-2 bg-gray-800 w-min p-8 grid">
    <item-description :moduleCondition="moduleCondition" :cache="cache"/>
    <upload-image :moduleCondition="moduleCondition" :cache="cache"/>
  </div>
</template>

<script setup>
import {onBeforeMount, reactive, watch} from "vue";
import {insert} from "../../hooks/commit.js";
import pubsub from "pubsub-js";
import 'md-editor-v3/lib/style.css';
import {debounce} from "lodash";
import isBlank from "../../hooks/isBlank.js";

const moduleCondition = reactive({
  editorCondition: true,
  categoryShowCase: false,
  discountShowCase: false,
  imageUpload: {
    style: 'opacity-0 pointer-events-none',
    enable: false
  },
  buttonMessage: '上传图片'
})

const cache = reactive({
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
  htmlText: '',
  imageAddress: {
    crates: {
      regular: '',
      hover: ''
    },
    extras: ''
  },
  imageName: null,
  categories: {
    crate: true,
    extra: true
  },
  clickable: 'pointer-events-none',
  enable: false
})

function execCommit() {
  insert(cache)
}
pubsub.subscribe('commit', execCommit)

const setCache = debounce(() => {
  localStorage.setItem('_insert', JSON.stringify(cache))
}, 300)
watch(cache, () => {
  if (cache.enable) setCache()
})
onBeforeMount(() => {
  const localCache = JSON.parse(localStorage.getItem('_insert'))
  if (!isBlank(localCache)) {
    cache.category = localCache.category
    cache.name = localCache.name
    cache.price = localCache.price
    cache.discount = localCache.discount
    cache.multiDiscount = {...localCache.multiDiscount}
    cache.command = localCache.command
    cache.markdownText = localCache.markdownText
    cache.htmlText = localCache.htmlText
    cache.imageAddress = {...localCache.imageAddress}
    cache.imageName = localCache.imageName
    cache.categories = {...localCache.categories}
    cache.clickable = localCache.clickable
  }
  cache.enable = true
})

const cleanCache = () => {
  localStorage.removeItem('_insert')
  cache.category = '类型'
  cache.name = null
  cache.price = null
  cache.discount = null
  cache.multiDiscount.x1 = null
  cache.multiDiscount.x5 = null
  cache.multiDiscount.x10 = null
  cache.multiDiscount.x20 = null
  cache.command = null
  cache.markdownText = ''
  cache.htmlText = ''
  cache.imageAddress.crates.regular = ''
  cache.imageAddress.crates.hover = ''
  cache.imageAddress.extras = ''
  cache.imageName = null
  cache.categories.crate = true
  cache.categories.extra = true
  cache.clickable = 'pointer-events-none'
  cache.enable = false
}
pubsub.subscribe('cleanInsertCache', cleanCache)
</script>

<script>
import ItemImage from "./item/basic/ItemImage.vue";
import ItemCategory from "./item/basic/ItemCategory.vue";
import ItemName from "./item/basic/ItemName.vue";
import ItemDiscount from "./item/basic/ItemDiscount.vue";
import ItemPrice from "./item/basic/ItemPrice.vue";
import ItemCommand from "./item/basic/ItemCommand.vue";
import ItemDescription from "./item/basic/ItemDescription.vue";
import UploadImage from "./item/image/UploadImage.vue";

export default {
  name: "EditorMain",
  components: {
    ItemImage,
    ItemCategory,
    ItemName,
    ItemDiscount,
    ItemPrice,
    ItemCommand,
    ItemDescription,
    UploadImage
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