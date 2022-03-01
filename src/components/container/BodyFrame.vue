<template>
  <div class="body-frame homepage">
    <div class="container mx-auto">
      <bread-crumb/>
      <body-header/>
      <!-- xxx -->
    </div>
  </div>
</template>

<script>
import BreadCrumb from "./body/BreadCrumb.vue";
import BodyHeader from "./body/BodyHeader.vue";

export default {
  name: "BodyFrame",
  components: {BodyHeader, BreadCrumb}
}
</script>