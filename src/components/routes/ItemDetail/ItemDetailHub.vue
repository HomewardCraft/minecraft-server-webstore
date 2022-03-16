<template>
  <!-- 别问我为什么用for遍历, 不用就undefined -->
  <div class="grid lg:grid-cols-3 gap-12" v-for="i in item" :key="i.index">
    <item-detail-info :item="i"/>
    <div class="info">
      <item-picture :imageAddress="i.imageAddress" :name="i.name"/>
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
import {onUpdated, ref} from "vue";
import sendRoutePath from "../../../hooks/sendRoutePath.js";
import axios from "axios";

const route = useRoute()

let obj = {}
let item = ref('')

async function getItemDetail(id) {
  const {
    data: result
  // } = await http.get(`baioretto/webstore/api/production/${id}`)
  } = await axios.get(`local/production/${id}`)

  obj['res'] = result.data

  item.value = obj

  console.log(item.value)
}

getItemDetail(route.params.id)

onUpdated(() => {
  sendRoutePath(obj.res)
})
</script>