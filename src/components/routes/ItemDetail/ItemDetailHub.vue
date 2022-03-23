<template>
    <div class="detail grid gap-12">
      <item-title :item="item" :name="name"/>

      <item-price :tempItem="tempItem" :price="price"/>

      <item-discount :item="item" :discountClass="discountClass" :discount="discount"/>

      <item-command :item="item" :command="command"/>

      <item-description :item="item" :description="description"/>

      <item-picture :item="item" :rawItem="rawItem" :hover="hover" :regular="regular" :tempItem="tempItem" :uploadedImageName="uploadedImageName"/>

      <item-button :execCommit="execCommit"/>
    </div>
</template>

<script>
import ItemPicture from "./ItemPicture.vue";
import ItemTitle from "./ItemTitle.vue";
import ItemPrice from "./ItemPrice.vue";
import ItemDiscount from "./ItemDiscount.vue";
import ItemCommand from "./ItemCommand.vue";
import ItemDescription from "./ItemDescription.vue";
import ItemButton from "./ItemButton.vue";

export default {
  name: "ItemDetailHub",
  components: {ItemPicture, ItemTitle, ItemPrice, ItemDiscount, ItemCommand, ItemDescription, ItemButton}
}
</script>

<script setup>
import {useRoute} from "vue-router";
import {computed, onUpdated, reactive, ref, watch} from "vue";
import sendRoutePath from "../../../hooks/sendRoutePath.js";
import axios from "axios";
import {debounce} from "lodash";
import {marked} from 'marked'
import {useCookies} from "vue3-cookies";
import {update} from "../../../hooks/commit.js";

const cookies = useCookies().cookies
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
  price: null,
  image: {
    regular: null,
    hover: null
  },
  imageName: null
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
  rawDescription: null,
  type: null
})
let cache
let enableCache = false
let discountClass = reactive({
  isDiscount: false,
  button: 'bg-gray-800',
  input: 'pointer-events-none'
})
let uploadedImageName = {
  regular: null,
  hover: null
}


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
const regular = computed(() => {
  return tempItem.imageName
})
const hover = computed(() => {
  return tempItem.imageName + '_hover'
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
    tempItem.image.regular = item.image.regular = uploadedImageName.regular = cache.image.regular
    tempItem.image.hover = item.image.hover = uploadedImageName.hover = cache.image.hover
  } else {
    item.name = rawItem.name.toString().split(' ').slice(1).toString().replaceAll(',', ' ');
    tempItem.price = rawItem.price / 100
    discountClass.isDiscount = item.saleCondition = rawItem.saleCondition
    item.salePercent = rawItem.salePercent
    item.command = rawItem.command
    item.rawDescription = rawItem.rawDescription
    item.command = rawItem.command
    item.rawDescription = rawItem.rawDescription
    tempItem.image.regular = item.image.regular = uploadedImageName.regular = rawItem.image.regular
    tempItem.image.hover = item.image.hover = uploadedImageName.hover = rawItem.image.hover
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
watch(tempItem.image, (value) => {
  item.image = {...value}
  tempItem.imageName = value.regular.toString().slice(value.regular.toString().lastIndexOf('/') + 1).split('.')[0]
})


async function getSpecificItem(id) {
  const {
    data: res
    } = await axios.get(`baioretto/webstore/api/production/${id}`)
  // } = await axios.get(`local/production/${id}`)
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
  rawItem.type = result.type
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

const execCommit = async () => {
  const data = {
    id: route.params.id,
    type: rawItem.type,
    name: item.name,
    price: item.price,
    saleCondition: item.saleCondition,
    salePercent: item.salePercent,
    command: item.command,
    imageAddress: item.image.regular,
    imageHoverAddress: item.image.hover,
    description: item.description,
    rawDescription: item.rawDescription
  }
  update(data)
}

onUpdated(() => {
  setCache()
  setBreadCrumb()
})

getSpecificItem(route.params.id)
</script>

<style>
.detail .button > div {
  @apply mx-2 w-full p-4 text-center text-gray-300 font-bold text-2xl border border-light rounded-lg transition-colors hover:bg-yellow-400 hover:text-yellow-900
}

.modifier .image\:regular, .modifier .image\:hover {
  min-height: 206px;
  max-width: 206px;
  width: 100%;
  margin: 0 auto;
  position: relative;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
}

.modifier input[type=file] {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  opacity: 0;
  @apply pointer-events-none
}
.modifier .title {
  padding-top: 1rem;
  padding-bottom: 1rem;
  @apply bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light text-gray-300 flex items-center justify-center text-center cursor-pointer font-bold opacity-100 transition-colors duration-150 ease-in-out row-start-3
}

.detail > div {
  @apply mb-6
}

.detail .command, .detail .title{
  word-break: keep-all;
}

.detail span {
  @apply text-4xl text-gray-300 font-bold
}

.detail input, #description {
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