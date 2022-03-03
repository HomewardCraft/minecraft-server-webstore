<template>
  <!-- 别问我为什么用for遍历, 不用就undefined -->
  <div class="grid lg:grid-cols-3 gap-12" v-for="i in item" :key="i.index">
    <item-detail-info :item="i"/>
    <div class="info">
      <item-picture :imageAddress="i.imageAddress" :name="i.name"/>
      <ItemAddCart/>
    </div>
  </div>
</template>

<script>
import ItemDetailInfo from "../components/routes/ItemDetail/ItemDetailInfo.vue";
import ItemPicture from "../components/routes/ItemDetail/ItemPicture.vue";
import ItemAddCart from "../components/routes/ItemDetail/ItemAddCart.vue";

export default {
  name: "ItemDetailPage",
  components: {ItemAddCart, ItemPicture, ItemDetailInfo}
}
</script>

<script setup>
import {useRoute} from "vue-router";
import {getCurrentInstance, onUpdated, ref} from "vue";
import sendRoutePath from "../hooks/sendRoutePath.js";

let http = getCurrentInstance().appContext.config.globalProperties.$http;
let route = useRoute()

let obj = {}
let item = ref('')

async function getItemDetail(id) {
  const {
    data: result
  } = await http.get(`fantang/webstore/api/production/${id}`)

  obj['res'] = result.data

  item.value = obj
}

getItemDetail(route.params.id)

onUpdated(() => {
  sendRoutePath(obj.res)
})
</script>