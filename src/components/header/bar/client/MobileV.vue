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
.navigate .mobile.active .bar:nth-of-type(1) {
  transform: rotate(45deg);
  top: 10px;
}

.navigate .mobile.active .bar:nth-of-type(2) {
  transform: rotate(180deg);
  opacity: 0;
}

.navigate .mobile.active .bar:nth-of-type(3) {
  transform: rotate(-45deg);
  top: -10px;
}


.navigate .mobile .bar {
  background: #fff;
  height: 4px;
  width: 30px;
  border-radius: 100px;
  transition: .24s all ease-in-out;
  position: relative;
  top: 0;
}
.navigate .mobile .bar:nth-of-type(2) {
  margin: 6px 0;
}
</style>