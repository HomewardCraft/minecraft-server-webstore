<template>
<div class="page-container">
  <background-image/>
  <!--https://s4.ax1x.com/2022/03/01/b1YCLR.png-->
  <body-frame/>
</div>
</template>

<script>
import BackgroundImage from "./container/BackgroundImage.vue";
import BodyFrame from "./container/BodyFrame.vue";
export default {
  name: "PageContainer",
  components: {BodyFrame, BackgroundImage}
}
</script>