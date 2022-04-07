<template>
  <div :class="backgroundCondition" class="loading fixed inset-0 z-50 transition-opacity ease-in-out duration-300 flex flex-col items-center justify-center bg-black/80">
    <img src="https://ba1oretto.com/webstore/images/logo.gif" alt="Loading" class="animate-pulse">
    <div class="load-text font-bold uppercase text-4xl mt-3 animate-track">Loading...</div>
  </div>
</template>

<script>
export default {
  name: "PageLoading"
}
</script>

<script setup>
import {ref} from "vue";
import pubsub from "pubsub-js";

const backgroundCondition = ref('opacity-0 pointer-events-none')

const changeCondition = (_, enable) => {
  backgroundCondition.value = enable ? 'opacity-100 pointer-events-auto' : 'opacity-0 pointer-events-none'
}
pubsub.subscribe('changeLoadingBgCondition', changeCondition)
</script>