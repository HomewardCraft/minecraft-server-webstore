<template>

  <div>

    <wlogo></wlogo>


    <wrouter></wrouter>


    <wheaderinfo></wheaderinfo>


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

div{
  /*margin: 0;*/
  /*width: 1100px;*/
  /*height: 100px;*/
  /*display: block;*/
}
</style>