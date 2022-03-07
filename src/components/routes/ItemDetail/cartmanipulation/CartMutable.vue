<template>
  <transition name="slide">
    <div class="quantity flex mb-4">
      <button @click="props.decreaseItem" class="flex p-4 bg-btn border border-lighten uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90">
        <svg class="w-6 h-6" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
          <path d="M400 288h-352c-17.69 0-32-14.32-32-32.01s14.31-31.99 32-31.99h352c17.69 0 32 14.3 32 31.99S417.7 288 400 288z"/>
        </svg>
      </button>
      <div class="quantity w-full text-center font-bold text-lg bg-gray-900 flex text-gray-500 items-center justify-center">
        {{ props.itemAmount }}x Bundle
      </div>
      <button @click="props.increaseItem" class="flex p-4 bg-btn border border-lighten uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90">
        <svg class="w-6 h-6" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
          <path d="M432 256c0 17.69-14.33 32.01-32 32.01H256v144c0 17.69-14.33 31.99-32 31.99s-32-14.3-32-31.99v-144H48c-17.67 0-32-14.32-32-32.01s14.33-31.99 32-31.99H192v-144c0-17.69 14.33-32.01 32-32.01s32 14.32 32 32.01v144h144C417.7 224 432 238.3 432 256z"/>
        </svg>
      </button>
    </div>
  </transition>

  <transition name="slide">
    <div id="addCart" class="flex justify-center items-center w-full bg-gray-900 border border-light py-4 uppercase font-extrabold tracking-wide text-gray-500 transition-all transform duration-150 ease-in-out focus:outline-none cursor-not-allowed">
      Added to cart
    </div>
  </transition>

  <transition name="slide">
    <button @click="removeItem" class="remove text-red-400 transition-colours ease-in-out duration-150 hover:text-red-200 p-5 font-bold text-sm text-center block w-full">
      Remove from cart
    </button>
  </transition>
</template>

<script>
export default {
  name: "CartMutable"
}
</script>

<script setup>
let props = defineProps(['increaseItem', 'decreaseItem', 'removeItem', 'itemAmount']);
</script>