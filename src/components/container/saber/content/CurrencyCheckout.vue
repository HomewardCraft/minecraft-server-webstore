<template>
  <!-- todo 价格(读后端数据)与币种(v-for遍历) -->
  <button class="flex font-bold transition-colors duration-150 ease-in-out items-center rounded bg-gray-800 text-gray-500 py-2 px-4 hover:bg-yellow-400 focus:bg-yellow-400 focus:outline-none hover:text-yellow-900 focus:text-yellow-900" @click="switchVisible">
    <span class="mr-3 opacity-75">$</span>
    <span>USD</span>
  </button>
  <div class="currencies transition-all ease-in-out duration-200 absolute top-0 left-0 right-0 mt-12 bg-gray-800 shadow-lg rounded grid grid-cols-2 gap-2 p-4 z-50" :class="clazz.array">
    <button class="currency font-bold rounded-md flex items-center justify-center bg-light p-3 text-gray-500 transition-opacity duration-150 ease-in-out hover:opacity-50">
      <span class="symbol opacity-75 flex items-center justify-center mr-3 leading-0">€</span>
      <span class="code">EUR</span>
    </button>
  </div>
</template>

<script>
export default {
  name: "CurrencyCheckout"
}
</script>

<script setup>
import {reactive} from "vue";

let isActive = false
let clazz = reactive({
  array: ['opacity-0', 'pointer-events-none']
})

function switchVisible() {
  if (isActive === false) {
    clazz.array = []
    isActive = true
  } else {
    clazz.array = ['opacity-0', 'pointer-events-none']
    isActive = false
  }
}

</script>