<template>
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
            <path d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z"/>
          </svg>
        </div>
        <div class="image:regular" :style="{backgroundImage:'url(' + item.image.regular + ')'}"/>
        <div class="w-full">
          <input v-model="tempItem.imageName" placeholder="图片名称(英文)" class="text-center">
          <input :value="props.regular" :type="'imageName'" class="pointer-events-none text-center">
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
            <path d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z"/>
          </svg>
        </div>
        <div class="image:hover" :style="{backgroundImage:'url(' + item.image.hover + ')'}"/>
        <div class="w-full">
          <input v-model="tempItem.imageName" placeholder="图片名称(英文)" class="text-center">
          <input :value="props.hover" :type="'imageName'" class="pointer-events-none text-center">
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
</template>

<script>
export default {
  name: "ItemPicture"
}
</script>

<script setup>
import setCurrentToastComponent from "../../../hooks/setToastComponent.js";
import axios from "axios";
import {ref} from "vue";
import {useCookies} from "vue3-cookies";
import isBlank from "../../../hooks/isBlank.js";

const props = defineProps(['item', 'rawItem', 'hover', 'regular', 'tempItem' ,'uploadedImageName']);
const cookies = useCookies().cookies

const item = props.item
const tempItem = props.tempItem
const rawItem = props.rawItem
const uploadedImageName = props.uploadedImageName

const uploadRegularInput = ref(null)
const uploadHoverInput = ref(null)


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
    name = tempItem.imageName
  }
  if (document.getElementById('uploadHover').contains(event.target)) {
    name = tempItem.imageName + '_hover'
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
</script>