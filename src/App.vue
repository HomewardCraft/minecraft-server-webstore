<script>
import PageHeader from "./components/PageHeader.vue";
import PageContainer from "./components/PageContainer.vue";
import PageFooter from "./components/PageFooter.vue";
export default {
  components: {PageFooter, PageContainer, PageHeader}
}
</script>

<template>
  <div class="grid grid-rows-body h-full">
    <page-header/>
    <page-container/>
    <page-footer/>
  </div>
  <div>

  </div>
  <div>
    登录弹窗
  </div>
</template>