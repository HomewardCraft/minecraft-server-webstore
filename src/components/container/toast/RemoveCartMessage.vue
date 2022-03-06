<template>
  <transition name="slide">
    <div class="toast-wrap">
      <div class="toast inline-flex text-white font-bold border border-lighten rounded-lg py-3 px-6 shadow-xl text-shadow bg-red-700">
        Removed item from your cart.
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "RemoveCartMessage"
}
</script>

<script setup>

</script>