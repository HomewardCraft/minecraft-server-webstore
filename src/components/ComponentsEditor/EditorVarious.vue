<template>
  <div class="main">
    <section id="accounts" class="mb-10">
      <div class="text flex-1 ml-8 mt-4">
        <div class="top relative flex items-center justify-between mb-2">
          <div class="title text-white font-bold">
          </div>
          <div class="currency-checkout">
            <button
                class="flex font-bold transition-colors duration-150 ease-in-out items-center rounded bg-gray-800 text-gray-500 py-2 px-10 hover:bg-yellow-400 focus:bg-yellow-400 focus:outline-none hover:text-yellow-900 focus:text-yellow-900"
                @click="switchVisible">
              <span class="mr-3 opacity-75">类型</span>
              <span>宝箱</span>
            </button>
            <div
                class="currencies transition-all ease-in-out duration-200 absolute top-0 left-0 right-0 mt-12 bg-gray-800 shadow-lg rounded grid grid-cols-2 gap-2 p-4 z-50"
                :class="clazz.array">
              <button
                  class="currency font-bold rounded-md flex items-center justify-center bg-light p-3 text-gray-500 transition-opacity duration-150 ease-in-out hover:opacity-50">
                <span class="symbol opacity-75 flex items-center justify-center mr-3 leading-0">类型</span>
                <span class="code">额外物品</span>
              </button>
            </div>
          </div>
        </div>
        <div class="flex items-center justify-between pb-0 mb-2">
          <h3 class="font-bold text-white">参与折扣</h3>
          <div :class="dynamicStyle.tick" @click="changeCondition" class="tick rounded-lg p-2 ml-16">
            <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"/>
            </svg>
          </div>
          <h3 class="text-white font-bold">额度 (%)</h3>
          <input maxlength="16" placeholder="75%" class="bg-gray-800 text-white block py-2 px-4 w-16 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
        </div>
        <h3 class="font-bold text-white mb-2">物品价格
          <input maxlength="256" placeholder="请使用分" class="bg-gray-800 ml-4 mr-4 text-white py-2 px-4 w-32 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>出售：128 元
        </h3>
        <h3 class="font-bold text-white">附带指令
          <input maxlength="256" placeholder="例如 /minecraft give @p items" class="bg-gray-800 ml-4 text-white py-2 px-4 w-64 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
        </h3>
      </div>
    </section>

  </div>
</template>

<script setup>

import {reactive} from "vue";

let isAgree = false

let dynamicStyle = reactive({
  checkbox: '',
  tick: 'bg-gray-800',
  button: 'bg-green-600',
  text: '',
  absolute: 'opacity-0'
})

function changeCondition() {
  if (!isAgree) {
    dynamicStyle.checkbox = 'opacity-50'
    dynamicStyle.tick = 'bg-green-600'
    dynamicStyle.button = 'bg-gray-800'
    dynamicStyle.text = 'opacity-0'
    dynamicStyle.absolute = ''
    isAgree = true
  } else {
    dynamicStyle.checkbox = ''
    dynamicStyle.tick = 'bg-gray-800'
    dynamicStyle.button = 'bg-green-600'
    dynamicStyle.text = ''
    dynamicStyle.absolute = 'opacity-0'
    isAgree = false
  }
}

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

<script>
export default {
  name: "EditorVarious"
}
</script>

<style scoped>
.checkout .avatar .button {
  background: linear-gradient(to top, #181a1b, rgba(24, 26, 27, 0));
}

.invalid {
  --tw-bg-opacity: 1;
  border-color: rgb(239 68 68 / var(--tw-bg-opacity));
}
</style>