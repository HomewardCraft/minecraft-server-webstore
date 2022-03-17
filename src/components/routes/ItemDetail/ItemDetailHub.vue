<template>
    <div class="detail grid lg:grid-cols-3 gap-12">
      <!-- todo 处理-->
      <div class="title position font-bold text-white">
        <div class="inline-flex items-center">
          <span>物品名称:</span>
          <div class="text-3xl text-yellow-400 ml-5">{{ rawItem.name }}</div>
        </div>
        <input v-model="rawItem.name">
      </div>

      <div class="price position font-bold">
        <div class="inline-flex items-center">
          <span>价格: </span>
          <div class="text-3xl text-yellow-400 ml-5">${{ price }} USD</div>
        </div>
        <input v-model="price">
      </div>

      <div class="discount position font-bold">
        <div class="inline-flex items-center">
          <span>打折:</span>
          <div class="line-through italic text-yellow-400 text-3xl ml-5">${{ originPrice }} USD</div>
        </div>
        <input>
      </div>

      <div class="command position w-full">
        <div class="inline-flex items-center">
          <span>物品指令: </span>
          <div class="text-3xl text-yellow-400 ml-5">{{ rawItem.command }}</div>
        </div>
        <textarea v-model="rawItem.command"/>
      </div>

      <div class="description position">
        <span>物品描述: </span>
        <div id="test" v-show="true" v-html="rawItem.description" class="content-wrap"/>

        <!--<textarea v-model=""></textarea>-->
      </div>



      <div class="info">
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
import {computed, onUpdated, reactive, readonly, ref} from "vue";
import sendRoutePath from "../../../hooks/sendRoutePath.js";
import axios from "axios";
const route = useRoute()
let routeValue = {
  name: null,
  type: null
}

const rawItem = reactive({
  name: null,
  price: null,
  saleCondition: null,
  salePercent: null,
  command: null,
  image: {
    regular: null,
    hover: null
  },
  description: null
})
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

  console.log(result)
  routeValue.name = result.name
  routeValue.type = result.type
}

const price = computed(() => {
  return rawItem.price / 100
})

const originPrice = computed(() => {
  return (rawItem.price / 100) * (rawItem.salePercent / 100)
})



getSpecificItem(route.params.id)

onUpdated(() => {
  sendRoutePath(routeValue)
})
</script>

<style>
.detail > div {
  @apply col-span-3 mb-6
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
  @apply bg-gray-800 text-2xl mt-5 w-full border border-light h-36
}
</style>