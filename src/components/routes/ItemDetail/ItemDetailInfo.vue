<template>
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
import {onBeforeUpdate, onMounted, onUpdated, reactive} from "vue";
import isBlank from "../../../hooks/isBlank.js";

const props = defineProps(['item']);
let item = props.item

let informationTemp = reactive({
  name: '',
  // originPrice: item.price / 100,
  // price: (item.price / 100) * (item.salePercent / 100),
  // saleCondition: item.saleCondition
})
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

onBeforeUpdate(() => {
  console.log(1)
//  1
  informationTemp.name = item.name
  console.log(informationTemp.name)
  // informationTemp.originPrice = item.price / 100
  // informationTemp.price = (item.price / 100) * (item.salePercent / 100)
  // informationTemp.saleCondition = item.saleCondition
})
</script>

<style>
</style>