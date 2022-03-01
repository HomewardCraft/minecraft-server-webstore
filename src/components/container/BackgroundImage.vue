<template>
<div class="page-background background-image"/>
</template>

<script>
export default {
  name: "BackgroundImage"
}
</script>

<style scoped>
.background-image {
  background-image: url("https://s4.ax1x.com/2022/03/01/b1wjBQ.jpg");
}

.page-background {
  min-height: 600px;
  height: 40vh;
  position: absolute;
  z-index: -1;
  top: 0;
  left: 0;
  right: 0;
  background-size: cover;
}

.page-background:after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(to bottom,rgba(0,0,0,.8),rgba(0,0,0,.8) 60%,#000 100%);
}
</style>