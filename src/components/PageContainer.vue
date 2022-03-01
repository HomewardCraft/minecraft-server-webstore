<template>
<div class="page-container">
  <background-image/>
  <container-body/>
  <container-toasts/>
  <container-side-bar/>
</div>
</template>

<script>
import BackgroundImage from "./container/BackgroundImage.vue";
import ContainerBody from "./container/ContainerBody.vue";
import ContainerToasts from "./container/ContainerToasts.vue";
import ContainerSideBar from "./container/ContainerSideBar.vue";
export default {
  name: "PageContainer",
  components: {ContainerSideBar, ContainerToasts, ContainerBody, BackgroundImage}
}
</script>