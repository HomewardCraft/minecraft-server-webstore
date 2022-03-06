<template>
  <transition name="slide">
    <div class="toast-wrap">
      <div class="toast inline-flex text-white font-bold border border-lighten rounded-lg py-3 px-6 shadow-xl text-shadow bg-green-700">
        Decreased the quantity in your cart
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "DecreaseItemMessage"
}
</script>

<script setup>

</script>