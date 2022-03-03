<script>

import PageHeader from "./components/PageHeader.vue";
import PageContainer from "./components/PageContainer.vue";
import PageFooter from "./components/PageFooter.vue";
import BottomModal from "./components/BottomModal.vue";

export default {
  components: {BottomModal, PageFooter, PageContainer, PageHeader}
}

</script>

<template>
  <div class="h-full">
    <div class="grid grid-rows-body h-full">
      <page-header/>
      <page-container/>
      <page-footer/>
    </div>
    <BottomModal/>
  </div>
</template>