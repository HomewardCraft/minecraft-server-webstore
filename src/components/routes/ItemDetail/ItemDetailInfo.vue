<template>
  <div class="info lg:col-span-2">
    <item-title :name="rawInfo.name"/>
    <item-price :rawInfo="rawInfo"/>
    <item-description :description="item.description" :markdown="markdown" :cache="cache"/>
  </div>
</template>

<script>
import ItemTitle from "./ItemTitle.vue";
import ItemPrice from "./ItemPrice.vue";
import ItemDescription from "./ItemDescription.vue";
export default {
  name: "ItemDetailInfo",
  components: {ItemTitle,ItemPrice,ItemDescription}
}
</script>

<script setup>
import {onMounted, reactive} from "vue";
import isBlank from "../../../hooks/isBlank.js";

const props = defineProps(['item']);
let item = props.item

const rawInfo = {
  name: item.name,
  originPrice: item.price / 100,
  price: (item.price / 100) * (item.salePercent / 100),
  saleCondition: item.saleCondition
}
let markdown = reactive({
  input: ''
})
let cache = reactive({
  name: item.name,
  markdown: ''
})

onMounted(() => {
  const rawCache = localStorage.getItem('detailCache');
  if (!isBlank(rawCache)) {
    let cache = JSON.parse(rawCache);
    if (cache.name === item.name) {
      markdown.input = cache.markdown
    //  todo cache here
    } else {
      localStorage.removeItem('detailCache')
    }
  }
})
</script>

<style>
#editor {
  margin: 0;
  height: 100%;
  font-family: "Helvetica Neue", Arial, sans-serif;
  color: #333;
}

textarea, #editor div {
  display: inline-block;
  width: 49%;
  height: 100%;
  vertical-align: top;
  box-sizing: border-box;
  padding: 0 20px;
}

textarea {
  border: none;
  border-right: 1px solid #ccc;
  resize: none;
  outline: none;
  background-color: #f6f6f6;
  font-size: 14px;
  font-family: "Monaco", courier, monospace;
  padding: 20px;
}

code {
  color: #f66;
}
</style>