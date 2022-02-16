<template>

  <div class="grid">
    <div class="span-row-3"><wlogo></wlogo></div>
    <div><wrouter></wrouter></div>
    <div class="span-row-2"><wheaderinfo></wheaderinfo></div>
  </div>


</template>

<script>

import wrouter from "./wrouter";
import wheaderinfo from "./wheaderinfo";
import wlogo from "./wlogo";


export default {
  name: "wheader",
  components: {wrouter, wheaderinfo, wlogo}
}
</script>

<style scoped>

.grid {
  margin-top: 10px;
  margin-bottom: 80px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}
.span-row-3{grid-row: span 3 / auto;}

.span-row-2{grid-row: span 2 / auto;}

div{
  /*margin: 0;*/
  /*width: 1100px;*/
  /*height: 100px;*/
  /*display: block;*/
}
</style>