<template>
  <div class="item-price my-auto grid">
    <h3 class="font-bold mb-2">物品价格</h3>
    <input v-model="price" size="999" type="number" placeholder="单位: 元" class="appearance-none"/>
  </div>
</template>

<script>
export default {
  name: "ItemPrice"
}
</script>

<script setup>
import {ref, watch} from "vue";
import pubsub from "pubsub-js";

const props = defineProps(['cache']);
const cache = props.cache

const price = ref(cache.price)
watch(price, (value) => {
  cache.price = value * 100
})
const cleanCache = () => {
  price.value = null
}
pubsub.subscribe('cleanInsertCache', cleanCache)
</script>

<style>
.editor .item-price {
  grid-column: 2;
  grid-row: 2;
}
</style>