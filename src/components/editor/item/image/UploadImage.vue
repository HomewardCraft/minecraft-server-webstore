<template>
  <div :class="props.imageUploadStyle.style" class="image-upload ease-in-out transition-opacity duration-500 bg-gray-800 p-8 h-700 flex border border-lighten">


    <div class="regular top-2.5 bg-gray-900 border border-lighten">

      <div class="image" :style="{backgroundImage:'url(' + imageAddress.regular + ')'}"/>

      <div class="name inline-flex items-center bg-gray-800">
        <input v-model="information.imageName" :type="'imageName'" placeholder="图片名称(英文)">
        <div class="showcase bg-gray-800 text-gray-400 ml-10 max-w-min">
          {{information.imageName}}
        </div>
      </div>

      <div @click="uploadFile" class="title" id="uploadRegular">
        <input type="file" ref="uploadRegularInput" name="regular" @change="onFileChanged" class="pointer-events-none">
        <span class="text-4xl">regular</span>
        <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
        </svg>
      </div>

    </div>


    <div class="hover top-2.5 bg-gray-900 border border-lighten border-l-0">
      <div class="image" :style="{backgroundImage:'url(' + imageAddress.hover + ')'}"/>
      <div class="name inline-flex items-center bg-gray-800">
        <input v-model="information.imageName" :type="'imageName'" placeholder="图片名称(英文)">
        <div class="showcase bg-gray-800 text-gray-400 ml-10 max-w-min">
          {{information.imageName}}_hover
        </div>
      </div>
      <div @click="uploadFile" class="title" id="uploadHover">
        <input type="file" ref="uploadHoverInput" name="hover" @change="onFileChanged" class="pointer-events-none">
        <span class="text-4xl">hover</span>
        <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
        </svg>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  name: "UploadImage"
}
</script>

<script setup lang="ts">
import {defineProps, ref} from "vue";
import {useCookies} from "vue3-cookies";
import axios from "axios";
import setCurrentToastComponent from "../../../../hooks/setToastComponent.js";

const props = defineProps(['imageUploadStyle', 'imageAddress', 'information']);

let information = props.information
let imageAddress = props.imageAddress
const cookies = useCookies().cookies;
const uploadRegularInput = ref<HTMLElement | null>(null)
const uploadHoverInput = ref<HTMLElement | null>(null)

const onFileChanged = async (event: Event) => {
  const input = event.target as HTMLInputElement
  let files = input.files
  if (!files.length) {
    return false
  }
  let name = null
  if (document.getElementById('uploadRegular').contains(event.target as Node)) {
    name = information.imageName
  }
  if (document.getElementById('uploadHover').contains(event.target as Node)) {
    name = information.imageName + '_hover'
  }
  const formData = new FormData()
  formData.append('file', files[0])
  formData.append('category', information.category)
  formData.append('name', name)
  const {data:result} = await axios.post('local/admin/file/upload', formData, {
  // const {data:result} = await axios.post('baioretto/webstore/api/admin/file/upload', formData, {
    headers: {
      'Authorization': cookies.get('authorization')
    }
  })
  if (result.status !== 200) {
    setCurrentToastComponent('fail', result.message)
    return false
  }
  const data = result.data.data
  if (document.getElementById('uploadRegular').contains(event.target as Node)) {
    imageAddress.regular = data.urlPath
  }
  if (document.getElementById('uploadHover').contains(event.target as Node)) {
    imageAddress.hover = data.urlPath
  }
  setCurrentToastComponent('success', '添加成功')
}

const uploadFile = (event) => {
  let onClick = null
  if (document.getElementById('uploadRegular').contains(event.target as Node)) {
    onClick = uploadRegularInput.value as HTMLInputElement
  } else if (document.getElementById('uploadHover').contains(event.target as Node)) {
    onClick = uploadHoverInput.value as HTMLInputElement
  } else return false
  if (information.category === '类型') {
    onClick = null
    setCurrentToastComponent('fail', '请先选择类型')
    return false
  }
  if (information.imageName === null || information.imageName === '') {
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
.image-upload .name {
  width: 400px;
  height: 49px;
}
.image-upload .title{
  position: relative;
  display: inline-block;
  overflow: hidden;
}
.image-upload input[type=imageName] {
  padding-top: 13px;
  padding-bottom: 13px;
  @apply bg-gray-800 text-white px-4 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}
.image-upload input[type=file] {
  position: absolute;
  right: 0;
  top: 0;
  opacity: 0;
}
.regular .title, .hover .title {
  padding-top: 3rem;
  padding-bottom: 3rem;
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
</style>