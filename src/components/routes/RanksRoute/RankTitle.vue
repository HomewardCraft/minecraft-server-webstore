<template>
  <div class="text-center">
    <div class="text-5xl text-white font-bold pb-6">Ranks</div>
    <div class="info-wrap">
      <button class="text-gray-500 inline-flex items-center mx-auto rounded-md py-3 px-5 font-bold border border-lighten transition-colors duration-150 ease-in-out hover:border-yellow-400 hover:text-white focus:outline-none" @click="openInfo">
        <svg class="w-6 h-6 opacity-50 mr-3" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-8-3a1 1 0 00-.867.5 1 1 0 11-1.731-1A3 3 0 0113 8a3.001 3.001 0 01-2 2.83V11a1 1 0 11-2 0v-1a1 1 0 011-1 1 1 0 100-2zm0 8a1 1 0 100-2 1 1 0 000 2z" clip-rule="evenodd"/>
        </svg>
        <span>How does the rank system work?</span>
      </button>
      <div class="info-text lg:w-2/3 mx-auto text-gray-500 transition-all duration-200 ease-in-out" :class="condition.classes" :style="condition.height">
        <div class="px-10 pt-8 pb-4">
          <div class="text-xl font-bold text-white mb-4">This is where things get interesting!</div>
          <p class="mb-3">Here on Origin Realms, we believe your rank should simply be a thank you for your support. As you'll see below, each rank has a price range that you'll need to meet before automatically being given the benefits.</p>
          <p class="mb-3">This means you will be given the rank as a free bonus, depending on how much you have spent in total on the store. Let's say you spend $3 to gain the VIP rank, you could then spend more the next week and climb your way to PRO or above!</p>
          <p>To see how much money you have spent in total, simply run the /donate command in-game!</p>
          <div class="text-red-500 font-bold mt-6 cursor-pointer" @click="openInfo">Close</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RankTitle"
}
</script>

<script setup>
import {reactive} from "vue";

let isOpen = false
let condition = reactive({
  classes: 'opacity-0 pointer-events-none',
  height: 'height: 0'
})

function openInfo() {
  if (!isOpen) {
    condition.classes = ''
    condition.height = 'height: 356px'
    isOpen = true
    console.log('height: ', condition.height)
    console.log('isOpen: ', isOpen)
  } else {
    condition.classes = 'opacity-0 pointer-events-none'
    condition.height = 'height: 0'
    isOpen = false
  }
}
</script>