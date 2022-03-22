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
        <div id="description" v-show="true" v-html="description" class="content-wrap"/>
        <textarea v-model="item.rawDescription"/>
      </div>

      <div class="picture">
        <div class="item-image modifier bg-gray-800 grid-cols-3 border border-light px-4 py-10 mb-6 grid">
          <div class="col-start-1 flex items-center w-full">
            <div class="image group border border-light">
              <div class="regular transition-opacity duration-300 ease-in-out group-hover:opacity-0" :style="{backgroundImage:'url(' + item.image.regular + ')'}"/>
              <div class="hover opacity-0 transition-opacity duration-300 ease-in-out group-hover:opacity-100" :style="{backgroundImage:'url(' + item.image.hover + ')'}"/>
            </div>
          </div>

          <div class="col-start-2" id="uploadRegular">
            <div @click="removeImage" class="relative float-right">
              <svg viewBox="0 0 36 36" fill="currentColor" class="w-4 h-4 box-content cursor-pointer p-4 rounded-full bg-gray-900 shadow-lg transition-colors duration-150 ease-in-out hover:text-red-400">
                <path d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z" data-v-00ffbf09=""/>
              </svg>
            </div>
            <div class="image:regular" :style="{backgroundImage:'url(' + item.image.regular + ')'}"/>
            <div class="w-full">
              <input v-model="imageName" placeholder="图片名称(英文)" class="text-center">
              <input :value="regular" :type="'imageName'" class="pointer-events-non text-center">
            </div>
            <div @click="uploadFile" class="title">
              <input type="file" ref="uploadRegularInput" name="regular" @change="onFileChanged">
              <span class="text-4xl">regular</span>
              <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
              </svg>
            </div>
          </div>

          <div class="col-start-3" id="uploadHover">
            <div @click="removeImage" class="relative float-right">
              <svg viewBox="0 0 36 36" fill="currentColor" class="w-4 h-4 box-content cursor-pointer p-4 rounded-full bg-gray-900 shadow-lg transition-colors duration-150 ease-in-out hover:text-red-400">
                <path d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z" data-v-00ffbf09=""/>
              </svg>
            </div>
            <div class="image:hover" :style="{backgroundImage:'url(' + item.image.hover + ')'}"/>
            <div class="w-full">
              <input v-model="imageName" placeholder="图片名称(英文)" class="text-center">
              <input :value="hover" :type="'imageName'" class="pointer-events-none text-center">
            </div>
            <div @click="uploadFile" class="title">
              <input type="file" ref="uploadHoverInput" name="hover" @change="onFileChanged">
              <span class="text-4xl">hover</span>
              <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
              </svg>
            </div>
          </div>
        </div>
      </div>

      <div class="button flex justify-between items-center flex-grow">
        <div class="cancel bg-red-600">取消</div>
        <div @click="commit" class="confirm bg-green-700">保存</div>
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
import {computed, onUpdated, reactive, ref, watch} from "vue";
import sendRoutePath from "../../../hooks/sendRoutePath.js";
import axios from "axios";
import {debounce} from "lodash";
import {marked} from 'marked'
import setCurrentToastComponent from "../../../hooks/setToastComponent.js";
import isBlank from "../../../hooks/isBlank.js";
import {useCookies} from "vue3-cookies";

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
  }
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
const uploadRegularInput = ref(null)
const uploadHoverInput = ref(null)
// 名称
let imageName = ref('')
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
  return imageName.value
})
const hover = computed(() => {
  return imageName.value + '_hover'
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
  imageName.value = value.regular.toString().slice(value.regular.toString().lastIndexOf('/') + 1).split('.')[0]
})


function changeDiscountCondition() {
  discountClass.isDiscount = item.saleCondition = !discountClass.isDiscount
}
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

const commit = async () => {
  //   name: null,
  //   price: null,
  //   saleCondition: null,
  //   salePercent: null,
  //   command: null,
  //   image: {
  //     regular: null,
  //     hover: null
  //   },
  //   description: null,
  //   rawDescription: null
  const formData = new FormData;
  formData.append('name', item.name)
  formData.append('price', item.price)
  formData.append('saleCondition', item.saleCondition)
  formData.append('salePercent', item.salePercent)
  formData.append('command', item.command)
  formData.append('imageAddress', item.image.regular)
  formData.append('imageHoverAddress', item.image.hover)
  formData.append('description', item.description)
  formData.append('rawDescription', item.rawDescription)
  // const {data:result} = await axios.post('local/admin/update', formData, {
  // // const {data:result} = await axios.post('baioretto/webstore/api/admin/update', formData, {
  //   headers: {
  //     'Authorization': cookies.get('authorization')
  //   }
  // })
  // console.log(result)
  formData.forEach((v, k) => {
    console.log(k, v)
  })
}


const uploadFile = (event) => {
  let onClick
  if (document.getElementById('uploadRegular').contains(event.target)) {
    onClick = uploadRegularInput.value
  } else if (document.getElementById('uploadHover').contains(event.target)) {
    onClick = uploadHoverInput.value
  } else return false

  onClick.click()
}
const removeImage = async (event) => {
  let name
  if (document.getElementById('uploadRegular').contains(event.target)) {
    if (isBlank(uploadedImageName.regular)) {
      setCurrentToastComponent('fail', '请先上传图片')
      return false
    }
    name = uploadedImageName.regular
  } else if (document.getElementById('uploadHover').contains(event.target)) {
    if (isBlank(uploadedImageName.hover)) {
      setCurrentToastComponent('fail', '请先上传图片')
      return false
    }
    name = uploadedImageName.hover
  } else return false
  const data = new FormData;
  data.append('category', rawItem.type)
  data.append('name', name)
  // const {data:result} = await axios.post('local/admin/file/unmount', data, {
  const {data:result} = await axios.post('baioretto/webstore/api/admin/file/unmount', data, {
    headers: {
      'Authorization': cookies.get('authorization')
    }
  })
  if (result.status === 200) {
    if (document.getElementById('uploadRegular').contains(event.target)) {
      item.image.regular = uploadedImageName.regular = null
    }
    if (document.getElementById('uploadHover').contains(event.target)) {
      item.image.hover = uploadedImageName.hover = null
    }
    setCurrentToastComponent('success', "删除成功")
  } else {
    setCurrentToastComponent('fail', result.message)
    return false
  }
}
const onFileChanged = async (event) => {
  const input = event.target
  let files = input.files
  if (!files.length) {
    return false
  }
  let name = null
  if (document.getElementById('uploadRegular').contains(event.target)) {
    name = imageName.value
  }
  if (document.getElementById('uploadHover').contains(event.target)) {
    name = imageName.value + '_hover'
  }
  const formData = new FormData()
  formData.append('file', files[0])
  formData.append('category', rawItem.type)
  formData.append('name', name)
  // const {data:result} = await axios.post('local/admin/file/upload', formData, {
    // todo 正式发布切换
    const {data:result} = await axios.post('baioretto/webstore/api/admin/file/upload', formData, {
    headers: {
      'Authorization': cookies.get('authorization')
    }
  })
  if (result.status !== 200) {
    setCurrentToastComponent('fail', result.message)
    return false
  }
  const data = result.data.data
  if (document.getElementById('uploadRegular').contains(event.target)) {
    item.image.regular = data.urlPath
    uploadedImageName.regular = data.fileName
  }
  if (document.getElementById('uploadHover').contains(event.target)) {
    item.image.hover = data.urlPath
    uploadedImageName.hover = data.fileName
  }
  setCurrentToastComponent('success', '添加成功')
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