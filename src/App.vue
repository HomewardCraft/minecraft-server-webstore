<script setup>
import PageFooter from "./components/PageFooter.vue";
import PageHeader from "./components/PageHeader.vue";
</script>

<template>
  <div id="_frame">
    <div class="body-wrap grid grid-rows-body h-full">
      <page-header/>
      <router-view/>
      <page-footer/>
    </div>
  </div>
</template>