<template>
  <div class="container mx-auto">
    <div class="grid lg:grid-cols-2 gap-5">
      <div @click="openPlayer" class="video-wrap">
        <div class="video border border-white transition duration-150 hover:shadow-pink">
          <div class="play transition-all ease-in-out duration-150">
            <svg viewBox="0 0 512 512" fill="currentColor" class="mx-auto mb-3 w-16 h-16 opacity-75">
              <path d="M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8zm115.7 272l-176 101c-15.8 8.8-35.7-2.5-35.7-21V152c0-18.4 19.8-29.8 35.7-21l176 107c16.4 9.2 16.4 32.9 0 42z"/>
            </svg>
            <p class="text-white font-bold uppercase text-sm text-shadow">Watch the Beta Teaser</p>
          </div>
        </div>
      </div>
      <div class="text text-center lg:text-left md:flex md:flex-col md:justify-center">
        <h2 class="text-white text-3xl font-bold mb-4">What is Origin Realms?</h2>
        <p class="mb-2 font-medium text-gray-500">Origin Realms is a <b>Minecraft: Java Edition</b> server that aims to enhance and expand upon vanilla gameplay. Our goal is to take what people love about Minecraft survival and give it new life with custom blocks, new biomes, detailed characters, dungeons and much more!</p>
        <p class="font-medium text-gray-500">Whether you are building up your base, exploring vast resource worlds or completing in-depth quests, we have something for everyone here on Origin Realms!</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import pubsub from "pubsub-js";

const openPlayer = () => {
  pubsub.publish('enablePlayer')
}
</script>

<script>
export default {
  name: "HomeVideo"
}
</script>