<template>
  <div class="discount font-bold">
    <div class="inline-flex items-center w-full flex-row">
      <span>打折:</span>
      <div class="line-through italic text-yellow-400 text-3xl ml-5 flex-grow">${{ props.discount }} USD</div>
      <div @click="changeDiscountCondition" :class="discountClass.button" class="rounded-lg p-2">
        <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"/>
        </svg>
      </div>
    </div>
    <input :class="discountClass.input" v-model="item.salePercent" type="number" class="appearance-none">
  </div>
</template>

<script>
export default {
  name: "ItemDiscount"
}
</script>

<script setup>
const props = defineProps(['item', 'discountClass', 'discount'])

const item = props.item
const discountClass = props.discountClass

function changeDiscountCondition() {
  discountClass.isDiscount = item.saleCondition = !discountClass.isDiscount
}
</script>