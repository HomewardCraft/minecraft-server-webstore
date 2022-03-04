<template>
  <div class="info lg:col-span-2">
    <h3 class="package-title font-bold text-5xl text-white mb-4">{{ name }}</h3>
    <div class="price font-extrabold mb-6">
      <div class="discount line-through italic text-gray-700" v-if="saleCondition">${{ originPrice }} USD</div>
      <div class="final text-2xl text-yellow-400" v-if="!saleCondition">${{ price }} USD</div>
      <div class="flex items-center h-14" v-if="saleCondition">
        <div class="text-3xl text-yellow-400 pt-5">${{ price }} USD</div>
      </div>
    </div>
    <div class="description content-wrap">
      <p>Unlock the ultimate enchanting potential for your tool, using slot runes! These powerful runes will add an additional slot for enchantments to your tools.</p>
      <p>Once a purchase has been made, you will receive the slot rune in-game shortly after. Use an anvil to combine it with any of your tools!</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "ItemDetailInfo"
}
</script>

<script setup>
import {onMounted} from "vue";



const props = defineProps(['item']);
let item = props.item

let name = item.name;
let originPrice = item.price / 100;
let price = (item.price / 100) * (item.salePercent / 100);
let saleCondition = item.saleCondition

//二重校验
if(originPrice !== price || item.salePercent !== 0) {saleCondition = true}

</script>