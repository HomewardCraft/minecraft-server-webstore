<!-- 管理所有组件的组件 -->
<template>
  <div id="app" class="h-full">
    <div class="grid grid-rows-body h-full">
      <page-header/>
      <page-body/>
      <page-footer/>
    </div>
  </div>
</template>


<script>
import pageHeader from "@/components/PageHeader";
import pageFooter from "@/components/PageFooter";
import pageBody from "@/components/PageBody";

export default {
  name: 'App',
  components: {
    pageBody,
    pageFooter,
    pageHeader
  }
}
</script>
