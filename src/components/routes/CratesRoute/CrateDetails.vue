<template>
    <div class="amount block text-center py-5 font-bold cursor-pointer bg-gray-800 border border-light border-r-0 last:border-r group transition-all duration-150 ease-in-out transform hover:text-yellow-800 hover:bg-yellow-400 hover:-translate-y-2">
      <div class="amount text-2xl pb-1">{{ amount }}</div>
      <div class="price opacity-25 text-sm line-through" v-if="saleCondition">${{ originPrice }} USD</div>
      <div class="price opacity-50" v-if="saleCondition">${{ price }} USD</div>
      <div class="h-11 flex justify-center items-center pt-3" v-if="!saleCondition">
        <div class="price opacity-50 text-xl"> ${{ originPrice }} USD </div>
      </div>
      <purchase-button/>
    </div>
</template>

<script>
import PurchaseButton from "./PurchaseButton.vue";

export default {
  name: "CrateDetails",
  components: {PurchaseButton}
}
</script>

<script setup>
let props = defineProps(['crate'])
let crate = props.crate

let amount = crate.itemBasicInfo.name.split(' ')[0]

let saleCondition = crate.itemSaleInfo.onsaleCondition;

let originPrice = crate.itemBasicInfo.price / 100

let price = (crate.itemBasicInfo.price / 100) * (crate.itemSaleInfo.onsalePercent / 100)

</script>