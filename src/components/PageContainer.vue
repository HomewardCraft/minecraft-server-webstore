<template>
  <div class="page-container">
    <container-body/>
    <container-toasts/>
    <container-side-bar/>
    <editor-panel/>
  </div>
</template>

<script>
import BackgroundImage from "./container/BackgroundImage.vue";
import ContainerBody from "./container/ContainerBody.vue";
import ContainerToasts from "./container/ContainerToasts.vue";
import ContainerSideBar from "./container/ContainerSideBar.vue";
import EditorPanel from "../pages/EditorPanel.vue";

export default {
  name: "PageContainer",
  components: {EditorPanel, ContainerToasts, ContainerBody, BackgroundImage, ContainerSideBar}
}
</script>