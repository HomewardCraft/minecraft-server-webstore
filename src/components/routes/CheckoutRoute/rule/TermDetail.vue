<template>
  <div @click="changeCondition" class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out" :class="clazz">
    <div class="transition-transform duration-200 ease-in-out transform">
      <div class="title flex items-center justify-between mb-6">
        <div class="font-bold text-2xl">Terms & Conditions</div>
        <svg viewBox="0 0 36 36" fill="currentColor" class="w-4 h-4 box-content cursor-pointer p-4 rounded-full bg-gray-800 shadow-lg transition-colors duration-150 ease-in-out hover:text-red-400">
          <path d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z"/>
        </svg>
      </div>
      <div id="term" class="content-wrap body bg-gray-900 p-6" v-html="information"></div>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import pubsub from "pubsub-js";
import {getCurrentInstance} from "vue";

let http = getCurrentInstance().appContext.config.globalProperties.$http

let clazz = ref('opacity-0 pointer-events-none')
let isClosed = true
function changeCondition(event) {
  let currentClick = document.getElementById('term')
  if (isClosed) {
    clazz.value = 'opacity-100 pointer-events-auto'
    isClosed = false
  } else if (currentClick) {
    if (!currentClick.contains(event.target)) {
      clazz.value = 'opacity-0 pointer-events-none'
      isClosed = true
    }
  }
}
pubsub.subscribe('termManipulation', changeCondition)

let information = ref('')
async function getTermInfo() {
  const {
    data: res
  } = await http.get('backend/webstore/api/rule/term')
  information.value = res
}
getTermInfo()
</script>

<script>
export default {
  name: "TermDetail"
}
</script>

<style scoped>
.modal {
  padding: 40px 0 0;
  overflow: auto;
}

.modal .body {
  max-width: 700px;
  margin-bottom: 40px;
}

.content-wrap {
  color: rgb(179,183,188);
}
</style>