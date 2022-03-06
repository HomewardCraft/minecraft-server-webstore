<template>
  <button @click="props.addItemToCart" class="flex justify-center items-center w-full px-6 bg-btn border border-lighten py-4 shadow-btn uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90">
    <svg class="w-8 h-8 mr-2 opacity-75" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
      <path d="M3 1a1 1 0 000 2h1.22l.305 1.222a.997.997 0 00.01.042l1.358 5.43-.893.892C3.74 11.846 4.632 14 6.414 14H15a1 1 0 000-2H6.414l1-1H14a1 1 0 00.894-.553l3-6A1 1 0 0017 3H6.28l-.31-1.243A1 1 0 005 1H3zM16 16.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM6.5 18a1.5 1.5 0 100-3 1.5 1.5 0 000 3z"/>
    </svg>
    <span>添加到购物车!</span>
  </button>
</template>

<script>
export default {
  name: "CartEmpty"
}
</script>

<script setup>
let props = defineProps(['addItemToCart']);
</script>