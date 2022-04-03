<script setup>
import PageFooter from "./components/PageFooter.vue";
import PageHeader from "./components/PageHeader.vue";
import PageWrap from "./components/PageWrap.vue";
</script>

<template>
  <div id="_frame">
    <div class="body-wrap grid grid-rows-body h-full">
      <page-header/>
      <page-wrap/>
      <page-footer/>
    </div>
  </div>
</template>