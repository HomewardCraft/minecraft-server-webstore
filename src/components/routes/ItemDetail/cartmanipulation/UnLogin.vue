<template>
  <div class="bg-gray-900 border border-lighten py-4 px-5 text-center mt-4 text-gray-500 font-bold">
    <svg class="w-12 h-12 opacity-50 mx-auto mb-2" viewBox="0 0 640 512" fill="currentColor">
      <path d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"/>
    </svg>
    <div class="lg text-lg leading-tight pb-3">Enter username to purchase</div>
    <div class="sm opacity-75">You need to enter your Minecraft username before you can purchase this item!</div>
  </div>
  <div @click="showLoginPanel" class="flex justify-center w-full text-gray-500 items-center bg-btn text-btn-text border border-lighten py-4 uppercase font-extrabold tracking-wide transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90">
    <svg class="w-6 h-6 opacity-75 mr-2" viewBox="0 0 640 512" fill="currentColor">
      <path d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"/>
    </svg>
    <span>Enter Username</span>
  </div>
</template>

<script>
export default {
  name: "UnLogin"
}
</script>

<script setup>
import pubsub from "pubsub-js";

function showLoginPanel() {
  pubsub.publish('changeLoginCondition')
}
</script>