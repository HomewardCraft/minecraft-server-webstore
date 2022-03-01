<template>
<div class="page-container">
  <background-image/>
  <body-frame/>
  <body-toasts/>
  <body-side-bar/>
</div>
</template>

<script>
import BackgroundImage from "./container/BackgroundImage.vue";
import BodyFrame from "./container/BodyFrame.vue";
import BodyToasts from "./container/BodyToasts.vue";
import BodySideBar from "./container/body/BodySideBar.vue";
export default {
  name: "PageContainer",
  components: {BodySideBar, BodyToasts, BodyFrame, BackgroundImage}
}
</script>