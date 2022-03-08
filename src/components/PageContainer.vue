<template>
  <div class="page-container">
    <!--<background-image/>-->
    <container-body/>
    <container-toasts/>
    <container-side-bar/>
    <editor-pannel/>
  </div>
</template>

<script>
import BackgroundImage from "./container/BackgroundImage.vue";
import ContainerBody from "./container/ContainerBody.vue";
import ContainerToasts from "./container/ContainerToasts.vue";
import ContainerSideBar from "./container/ContainerSideBar.vue";
import EditorPannel from "../pages/EditorPannel.vue";

export default {
  name: "PageContainer",
  components: {EditorPannel, ContainerToasts, ContainerBody, BackgroundImage, ContainerSideBar}
}
</script>