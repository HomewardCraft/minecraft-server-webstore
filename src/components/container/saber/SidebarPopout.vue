<template>
  <div @click="props.changeCondition" class="item cursor-pointer bg-custom-300 border border-lighten lg:w-16 h-16 box-content flex items-center justify-center relative group lg:mb-3 transition-all ease-in-out duration-500">
    <div class="tooltip right-0 mr-20 opacity-0 absolute transition-opacity duration-150 ease-in-out group-hover:opacity-100">hello</div>
    <img src="https://ba1oretto.com/webstore/images/login/guest.png" alt="default" class="w-8 h-8 block">
  </div>
</template>

<script setup>
const props = defineProps({
  changeCondition: Function
});
</script>

<script>
export default {
  name: "SidebarPopout"
}
</script>

<style scoped>
.side-bar.active .popout .item {
  opacity: 0;
  transform: translate(25px);
}
</style>