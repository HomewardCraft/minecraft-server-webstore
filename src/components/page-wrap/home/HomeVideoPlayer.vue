<template>
  <transition name="video-player" mode="in-out">
    <div v-if="video" class="videoPlayer bg-black fixed inset-0 z-50 p-10 pt-0 grid grid-rows-video">
      <div @click="changePlayerCondition" class="top text-gray-500 flex items-center justify-start p-8 cursor-pointer transition duration-200 hover:text-yellow-400">
        <svg viewBox="0 0 640 512" fill="currentColor" class="w-8 mr-3">
          <path d="M576 64H205.26A63.97 63.97 0 0 0 160 82.75L9.37 233.37c-12.5 12.5-12.5 32.76 0 45.25L160 429.25c12 12 28.28 18.75 45.25 18.75H576c35.35 0 64-28.65 64-64V128c0-35.35-28.65-64-64-64zm-84.69 254.06c6.25 6.25 6.25 16.38 0 22.63l-22.62 22.62c-6.25 6.25-16.38 6.25-22.63 0L384 301.25l-62.06 62.06c-6.25 6.25-16.38 6.25-22.63 0l-22.62-22.62c-6.25-6.25-6.25-16.38 0-22.63L338.75 256l-62.06-62.06c-6.25-6.25-6.25-16.38 0-22.63l22.62-22.62c6.25-6.25 16.38-6.25 22.63 0L384 210.75l62.06-62.06c6.25-6.25 16.38-6.25 22.63 0l22.62 22.62c6.25 6.25 6.25 16.38 0 22.63L429.25 256l62.06 62.06z"/>
        </svg>
        <div class="text-lg font-bold pr-6">Return to site</div>
      </div>
      <div class="video-wrap box-border p-5 bg-black lg:p-16 h-full">
        <iframe class="h-64 md:h-half lg:h-full" width="100%" height="360" src="https://www.youtube.com/embed/1cGQotpn8r4?autoplay=1&enablejsapi=1&origin=https%3A%2F%2Fbaioretto.com" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen/>
      </div>
    </div>
  </transition>
</template>

<script setup>
import {ref} from "vue";
import pubsub from "pubsub-js";

const video = ref(false)
const changePlayerCondition = () => {
  video.value = !video.value
}

pubsub.subscribe('enablePlayer', changePlayerCondition)
</script>

<script>
export default {
  name: "HomeVideoPlayer"
}
</script>