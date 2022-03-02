<template>
  <div class="bread-crumbs mb-12 flex items-center">
    <router-link to="/" class="bg-gray-900 border border-light rounded-md py-3 px-5 font-bold text-gray-500 flex items-center transition-colors duration-200 ease-in-out hover:bg-custom-300 hover:text-yellow-800">
      <svg class="w-5 h-5 mr-3 opacity-50" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd" d="M7.707 3.293a1 1 0 010 1.414L5.414 7H11a7 7 0 017 7v2a1 1 0 11-2 0v-2a5 5 0 00-5-5H5.414l2.293 2.293a1 1 0 11-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd"/>
      </svg>
      <span>Home</span>
    </router-link>
    <div class="separator">/</div>
  </div>
</template>

<script>
export default {
  name: "BreadCrumb"
}
</script>

<script setup>

</script>

<style scoped>
.bread-crumbs .separator {
  color: #4b5563;
  padding: 0 10px;
}
</style>