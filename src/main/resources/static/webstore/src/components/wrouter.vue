<template>

  <div>

    <ul class="rt">
      <li>
        <bhome></bhome>
      </li>
      <li>
        <bblog></bblog>
      </li>
      <li>
        <brules></brules>
      </li>
      <li>
        <bstore></bstore>
      </li>
    </ul>

  </div>

</template>

<script>

import bhome from "./buttom/bhome";
import bblog from "./buttom/bblog";
import brules from "./buttom/brules";
import bstore from "./buttom/bstore";

export default {
  name: "wrouter",
  components: {bhome, bblog, brules, bstore}
}
</script>

<style scoped>

.rt {

  list-style-type: none;
  margin: 0;
  padding: 0;

}

</style>