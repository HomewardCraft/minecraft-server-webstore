<template>
  <div class="loading fixed inset-0 z-50 transition-opacity ease-in-out duration-300 flex flex-col items-center justify-center bg-black-80 pointer-events-none">
    <img src="https://ba1oretto.com/webstore/images/logo.gif" class="animate-pulse" alt="Loading">
    <div class="load-text font-bold uppercase text-4xl mt-3 animate-track">加载中...</div>
  </div>
</template>

<script>
export default {
  name: "PageLoading"
}
</script>

<style scoped>
.loading {
  z-index: 999999;
}
</style>