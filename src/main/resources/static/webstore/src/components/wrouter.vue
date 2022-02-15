<template>

  <div>

    <ul class="rt">
      <li class="il">
        <a>
          <bhome></bhome>
        </a>
      </li>
      <li>
        <a>
          <bblog></bblog>
        </a>
      </li>
      <li>
        <a>
          <brules></brules>
        </a>
      </li>
      <li>
        <a>
          <bstore></bstore>
        </a>
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
  overflow: hidden;
}

li {
  float: left;

}

a {
  font-size: 18px;
  font-weight: bold;
  color: #FFFFFF;
  text-transform: uppercase;
}

</style>