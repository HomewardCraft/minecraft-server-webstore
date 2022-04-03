<template>
  <router-view name="header"/>
  <div class="page-wrap">
    <router-view/>
  </div>
  <router-view name="footer"/>
</template>

<script>
import PageHeader from "./PageHeader.vue";

export default {
  name: "PageWrap",
  components: {PageHeader}
}
</script>

<script setup>
import PageFooter from "./PageFooter.vue";
</script>