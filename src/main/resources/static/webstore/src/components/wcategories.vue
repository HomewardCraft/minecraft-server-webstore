<template>

  <div class="grid">
    <div class="span-row-2">
      <wcrates></wcrates>
    </div>
    <wranks></wranks>
    <wextras></wextras>
  </div>

</template>

<script>

import wcrates from "./wcrates";
import wranks from "./wranks";
import wextras from "./wextras";

export default {
  name: "wcategories",
  components: {wcrates, wranks, wextras}
}
</script>

<style scoped>

div {


}

.grid {
  margin: auto;
  width: 1130px;
  height:500px;


  display: grid;
  grid-template-columns: repeat(2, 0fr);
}

.span-row-2 {
  align-self: center;
  grid-row: span 2 / auto;
}

</style>