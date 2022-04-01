<template>
  <transition name="slide">
    <div class="toast-wrap">
        <slot :name="props.name"></slot>
    </div>
  </transition>
</template>

<script>
export default {
  name: "ToastConditionEnum"
}
</script>

<script setup>
let props = defineProps(['name']);
</script>