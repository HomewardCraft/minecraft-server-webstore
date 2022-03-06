<template>
  <transition name="slide">
    <div class="toast-wrap">
      <div class="toast inline-flex text-white font-bold border border-lighten rounded-lg py-3 px-6 shadow-xl bg-green-700">
        Added {{ props.item.name }} to your card
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "AddCartMessage"
}
</script>

<script setup>
let props = defineProps(['item']);
</script>