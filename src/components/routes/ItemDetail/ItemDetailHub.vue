<template>
    <div class="detail grid gap-12">
      <!-- todo 处理-->
      <div class="title font-bold text-white">
        <div class="inline-flex items-center">
          <span>物品名称:</span>
          <div class="text-3xl text-yellow-400 ml-5">{{ name }}</div>
        </div>
        <input v-model="item.name">
      </div>

      <div class="price font-bold">
        <div class="inline-flex items-center">
          <span>价格: </span>
          <div class="text-3xl text-yellow-400 ml-5">${{ price }} USD</div>
        </div>
        <input v-model="tempItem.price">
      </div>

      <div class="discount font-bold">
        <div class="inline-flex items-center w-full flex-row">
          <span>打折:</span>
          <div class="line-through italic text-yellow-400 text-3xl ml-5 flex-grow">${{ discount }} USD</div>
          <div @click="changeDiscountCondition" :class="discountClass.button" class="rounded-lg p-2">
            <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"/>
            </svg>
          </div>
        </div>
        <input :class="discountClass.input" v-model="item.salePercent">
      </div>

      <div class="command w-full">
        <div class="inline-flex items-center">
          <span>物品指令: </span>
          <div class="text-3xl text-yellow-400 ml-5">{{ command }}</div>
        </div>
        <textarea v-model="item.command"/>
      </div>

      <div class="description">
        <span>物品描述: </span>
        <div id="test" v-show="true" v-html="description" class="content-wrap"/>
        <textarea v-model="item.rawDescription"/>
      </div>



      <div class="picture">
        <div class="item-image bg-gray-800 border border-light px-4 py-10 mb-6 flex flex-col justify-center items-center">
          <div class="h-52 w-52 relative bg-gray-800 bg-bottom bg-no-repeat border border-light border-b-0">
            <div class="image group">
              <div class="regular transition-opacity duration-300 ease-in-out group-hover:opacity-0" :style="{backgroundImage:'url(' + rawItem.image.regular + ')'}"/>
              <div class="hover opacity-0 transition-opacity duration-300 ease-in-out group-hover:opacity-100" :style="{backgroundImage:'url(' + rawItem.image.hover + ')'}"/>
            </div>
          </div>
          <div class="w-52 bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light border-t-0 text-gray-300 flex items-center justify-center text-center cursor-pointer py-2 font-bold opacity-100 transition-colors duration-150 ease-in-out">
            <span>修改图片</span>
            <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import ItemDetailInfo from "./ItemDetailInfo.vue";
import ItemPicture from "./ItemPicture.vue";

export default {
  name: "ItemDetailHub",
  components: {ItemPicture, ItemDetailInfo}
}
</script>

<script setup>
import {useRoute} from "vue-router";
import {computed, onUpdated, reactive, watch} from "vue";
import sendRoutePath from "../../../hooks/sendRoutePath.js";
import axios from "axios";
import {debounce} from "lodash";
import {marked} from 'marked'
const route = useRoute()
let routeValue = {
  name: null,
  type: null
}

// 返回的
let item = reactive({
  name: null,
  price: null,
  saleCondition: null,
  salePercent: null,
  command: null,
  image: {
    regular: null,
    hover: null
  },
  description: null,
  rawDescription: null
})
// 临时的 用于操作
let tempItem = reactive({
  price: null
})
// 接收的
const rawItem = reactive({
  name: '',
  price: null,
  saleCondition: null,
  salePercent: null,
  command: null,
  image: {
    regular: null,
    hover: null
  },
  description: null,
  rawDescription: null
})
let cache
let enableCache = false
let discountClass = reactive({
  isDiscount: false,
  button: 'bg-gray-800',
  input: 'pointer-events-none'
})

const name = computed(() => {
  const prefix = rawItem.name.toString().split(' ', 1).toString().concat(' ')
  return prefix + item.name
})
const price = computed(() => {
  item.price = tempItem.price * 100
  return item.price / 100
})
const discount = computed(() => {
  return (item.price / 100) * (item.salePercent / 100)
})
const command = computed(() => {
  return item.command
})
const description = computed(() => {
  return item.description
})

watch(rawItem, (rawItem) => {
  let name = rawItem.name.toString().split(' ').slice(1).toString().replaceAll(',', ' ');
  let cache = JSON.parse(localStorage.getItem('cache'));
  if (cache !== null && cache !== undefined && cache.name === name) {
    item.name = cache.name
    tempItem.price = cache.price / 100
    discountClass.isDiscount = cache.saleCondition
    item.salePercent = cache.salePercent
    item.command = cache.command
    item.rawDescription = cache.rawDescription
  } else {
    item.name = name
    tempItem.price = rawItem.price / 100
    discountClass.isDiscount = item.saleCondition = rawItem.saleCondition
    item.salePercent = rawItem.salePercent
    item.command = rawItem.command
    item.rawDescription = rawItem.rawDescription
    enableCache = true
  }
})
watch(() => discountClass.isDiscount, () => {
  if (discountClass.isDiscount) {
    discountClass.button = 'bg-green-600'
    discountClass.input = 'pointer-events-auto'
    item.salePercent = rawItem.salePercent
  } else {
    discountClass.button = 'bg-gray-800'
    discountClass.input = 'pointer-events-none'
    item.salePercent = 100
  }
})
watch(() => item.rawDescription, () => {
  item.description = marked(item.rawDescription);
})


function changeDiscountCondition() {
  discountClass.isDiscount = item.saleCondition = !discountClass.isDiscount
}
async function getSpecificItem(id) {
  const {
    data: res
    // } = await http.get(`baioretto/webstore/api/production/${id}`)
  } = await axios.get(`local/production/${id}`)
  const result = res.data
  rawItem.name = result.name
  rawItem.price = result.price
  rawItem.saleCondition = result.saleCondition
  rawItem.salePercent = result.salePercent
  rawItem.command = result.command
  rawItem.image.regular = result.imageAddress
  rawItem.image.hover = result.imageHoverAddress
  rawItem.description = result.description
  rawItem.rawDescription = result.rawDescription
  routeValue.name = result.name
  routeValue.type = result.type
}
async function setCache() {
  if (enableCache) {
    cache = {...item}
    saveCache()
  } else {
    enableCache = true
  }
}
const execSetBreadCrumb = function() {
  let off = false
  return function () {
    if (!off) {
      sendRoutePath(routeValue)
      off = true
    }
  }
}
const setBreadCrumb = execSetBreadCrumb()
const saveCache = debounce(() => {
  localStorage.setItem('cache', JSON.stringify(cache))
}, 300)

onUpdated(() => {
  setCache()
  setBreadCrumb()
})

getSpecificItem(route.params.id)
</script>

<style>
.detail > div {
  @apply mb-6
}

.detail .command, .detail .title{
  word-break: keep-all;
}

.detail span {
  @apply text-4xl text-gray-300 font-bold
}

.detail input, #test {
  @apply bg-gray-800 text-2xl mt-5 w-full py-2.5 px-4 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}

.detail textarea {
  @apply bg-gray-800 text-2xl mt-5 w-full border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none pb-10
}

.detail .title {
  @apply row-start-1
}
.detail .price {
  @apply row-start-2
}
.detail .discount {
  @apply row-start-3
}
.detail .command {
  @apply row-start-4
}
.detail .description {
  @apply row-start-5
}
.detail .description textarea {
  padding-bottom: 35rem;
  @apply row-start-5
}
.detail .picture {
  @apply row-start-6
}
</style>