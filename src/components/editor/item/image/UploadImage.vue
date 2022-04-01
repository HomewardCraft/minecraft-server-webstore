<template>
  <div :class="moduleCondition.imageUpload.style" class="image-upload ease-in-out transition-opacity duration-500 bg-gray-800 p-8 h-700 border border-lighten">
    <transition name="imageUpload">
      <div v-show="cache.category === 'crates'" class="flex justify-between">
        <div class="regular border">
          <div class="image" :style="{backgroundImage:'url(' + cache.imageAddress.crate.regular + ')'}"/>
          <div class="name">
            <input v-model="cache.imageName" :type="'imageName'" placeholder="图片名称(英文)">
            <input v-model="cache.imageName" :type="'imageName'" class="pointer-events-none">
          </div>
          <div @click="uploadFile" class="title" id="uploadCrateRegular">
            <input type="file" ref="uploadCrateRegular" name="regular" @change="onFileChanged">
            <span class="text-4xl">regular</span>
            <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="hover border border-l-0">
          <div class="image" :style="{backgroundImage:'url(' + cache.imageAddress.crate.hover + ')'}"/>
          <div class="name">
            <input v-model="cache.imageName" :type="'imageName'" placeholder="图片名称(英文)">
            <input v-model="imageHover" :type="'imageName'" class="pointer-events-none">
          </div>
          <div @click="uploadFile" class="title" id="uploadCrateHover">
            <input type="file" ref="uploadCrateHover" name="hover" @change="onFileChanged">
            <span class="text-4xl">hover</span>
            <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
    </transition>
    <transition name="imageUpload">
      <div v-show="cache.category === 'extras'">
        <div class="regular border">
          <div class="relative top-0 left-0 right-0 bottom-0 bg-center bg-no-repeat" :style="{backgroundImage:'url(' + cache.imageAddress.extra + ')'}"/>
          <div class="name">
            <input v-model="cache.imageName" :type="'imageName'" placeholder="图片名称(英文)">
          </div>
          <div @click="uploadFile" class="title" id="uploadExtra">
            <input type="file" ref="uploadExtra" name="regular" @change="onFileChanged">
            <span class="text-4xl">upload</span>
            <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: "UploadImage"
}
</script>

<script setup>
import {computed, ref} from "vue";
import {useCookies} from "vue3-cookies";
import axios from "axios";
import setCurrentToastComponent from "../../../../hooks/setToastComponent.js";

const props = defineProps(['moduleCondition', 'cache']);

const moduleCondition = props.moduleCondition
const cache = props.cache

const cookies = useCookies().cookies;

const uploadCrateRegular = ref(null)
const uploadCrateHover = ref(null)
const uploadExtra = ref(null)

const imageHover = computed(() => cache.imageName + '_hover')

const onFileChanged = async (event) => {
  const input = event.target
  const files = input.files
  if (!files.length) {
    return false
  }

  let name
  if (document.getElementById('uploadCrateRegular').contains(event.target))
    name = cache.imageName
  else if (document.getElementById('uploadCrateHover').contains(event.target))
    name = cache.imageName + '_hover'
  else if (document.getElementById('uploadExtra').contains(event.target))
    name = cache.imageName
  else return false

  const formData = new FormData()
  formData.append('file', files[0])
  formData.append('category', cache.category)
  formData.append('name', name)
  const {data:result} = await axios.post('local/admin/file/upload', formData, {
  // todo 正式发布切换
  // const {data:result} = await axios.post('baioretto/webstore/api/admin/file/upload', formData, {
    headers: {
      'Authorization': cookies.get('authorization')
    }
  })
  if (result.status !== 200) {
    setCurrentToastComponent('fail', result.message)
    return false
  }

  const data = result.data
  if (document.getElementById('uploadCrateRegular').contains(event.target))
    cache.imageAddress.crate.regular = data.urlPath
  if (document.getElementById('uploadCrateHover').contains(event.target))
    cache.imageAddress.crate.hover = data.urlPath
  if (document.getElementById('uploadExtra').contains(event.target))
    cache.imageAddress.extra = data.urlPath

  setCurrentToastComponent('success', '添加成功')

  event.target.value = null
}

const uploadFile = (event) => {
  let onClick

  if (document.getElementById('uploadCrateRegular').contains(event.target))
    onClick = uploadCrateRegular.value
  else if (document.getElementById('uploadCrateHover').contains(event.target))
    onClick = uploadCrateHover.value
  else if (document.getElementById('uploadExtra').contains(event.target))
    onClick = uploadExtra.value
  else return false

  if (cache.category === '类型') {
    onClick = null
    setCurrentToastComponent('fail', '请先选择类型')
    return false
  }
  if (cache.imageName === null || cache.imageName === '') {
    onClick = null
    setCurrentToastComponent('fail', '填写图片英文名称')
    return false
  }
  onClick.click()
}
</script>

<style>
.editor .image-upload {
  min-width: 850px;
  grid-column: 1;
  grid-row: 1;
}
.image-upload .regular, .image-upload .hover {
  grid-template-rows: 28rem 50px 8.5rem;
  @apply grid bg-gray-900 border-lighten flex-grow
}
.image-upload .name {
  @apply row-start-2 inline-flex justify-between bg-gray-800
}
.image-upload .title, .image-upload .title {
  padding-top: 3rem;
  padding-bottom: 3rem;
  @apply bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light text-gray-300 flex items-center justify-center text-center cursor-pointer font-bold opacity-100 transition-colors duration-150 ease-in-out row-start-3
}
.image-upload input[type=imageName] {
  padding-top: 15px;
  padding-bottom: 15px;
  @apply bg-gray-800 text-gray-400 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none flex-grow text-center
}
.image-upload input[type=file] {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  opacity: 0;
  @apply pointer-events-none
}
.regular .image, .hover .image {
  position: relative;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: center/cover;
  @apply row-start-1
}
</style>