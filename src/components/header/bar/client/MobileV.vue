<template>
<div class="bar"></div>
<div class="bar"></div>
<div class="bar"></div>
</template>

<script>
export default {
  name: "MobileV"
}
</script>

<style scoped>
/*.navigate .mobile .bar {*/
.bar {
  background: #fff;
  height: 4px;
  width: 30px;
  border-radius: 100px;
  transition: .24s all ease-in-out;
  position: relative;
  top: 0;
}
/*.navigate .mobile .bar:nth-of-type(2) {*/
.bar:nth-of-type(2) {
  margin: 6px 0;
}
</style>