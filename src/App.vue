<script setup>
import PageWrap from "./components/PageWrap.vue";
import PageLoading from "./components/PageLoading.vue";
</script>

<template>
  <div id="_frame">
    <div class="body-wrap grid grid-rows-body h-full">
      <router-view name="header"/>
      <page-wrap/>
      <router-view name="footer"/>
      <page-loading/>
    </div>
  </div>
</template>