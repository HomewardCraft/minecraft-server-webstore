<template>
  <div class="category-heading pt-4 text-center">
    <div class="text-5xl text-white font-bold">Extras</div>
    <div class="input-wrap w-full lg:w-1/2 mx-auto relative mt-6">
      <input ref="inputtext" @focus="focus"
             @blur="unfocus"
             class="wi w-full bg-gray-900 rounded-md text-white border border-lighten text-lg py-3 px-6 transition-colors duration-200 ease-in-out focus:outline-none focus:border-yellow-400"
             id="searchTerm">
      <div
          class="placeholder pointer-events-none absolute top-0 left-0 text-lg text-gray-700 py-2 leading-loose px-6 transition-opacity duration-200 ease-in-out">
        {{ placeholder }}
      </div>
      <label for="searchTerm" class="icon absolute right-0 top-0 m-px p-4 rounded-md pointer-events-none">
        <svg class="w-5 h-5 text-gray-700" fill="#55575c" viewBox="0 0 20 20">
          <path fill-rule="evenodd"
                d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                clip-rule="evenodd"></path>
        </svg>
      </label>
    </div>
  </div>
</template>

<script>

import {getCurrentInstance, onBeforeUnmount, onMounted, ref} from "vue";

export default {
  name: "SearchUtil",
  setup() {

    //获取当前实例对象 vue2中的this
    const {proxy, ctx} = getCurrentInstance()

    let placeholder = ref('按 Enter 进行聚焦搜索')

    function saveKeys(event) {

      if (event.code === "Enter")
        ctx.$refs.inputtext.focus()
    }

    function focus() {
      placeholder.value = " "
    }

    function unfocus() {
      placeholder.value = "按 Enter 来聚焦搜索"
    }

    //实现鼠标“打点”相关的生命周期钩子
    onMounted(() => {
      window.addEventListener('keypress', saveKeys)
    })

    onBeforeUnmount(() => {
      window.removeEventListener('keypress', saveKeys)
    })

    return {
      placeholder,
      focus,
      unfocus
    }
  }
}
</script>

<style scoped>
.placeholder {
  color: #55575c;
}

.wi {
  background-color: #0d0e0f;
}

.wi2 {
  background-color: #55575c;
}

</style>