<template>

  <div>

    <wcrates></wcrates>
    <wranks></wranks>

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
  margin: 0;
}

</style>