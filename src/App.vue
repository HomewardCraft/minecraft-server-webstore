<script setup>
import PageWrap from "./components/PageWrap.vue";
</script>

<template>
  <div id="_frame">
    <div class="body-wrap grid grid-rows-body h-full">
      <router-view name="header"/>
      <page-wrap/>
      <router-view name="footer"/>
    </div>
  </div>
</template>