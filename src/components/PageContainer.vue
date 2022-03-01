<template>
<div class="page-container">
  <background-image/>
  <!--https://s4.ax1x.com/2022/03/01/b1YCLR.png-->
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