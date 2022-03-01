<template>
  <div class="container-body homepage">
    <div class="container mx-auto">
      <bread-crumb/>
      <body-header/>
      <router-view/>
    </div>
  </div>
</template>

<script>
import BreadCrumb from "./body/BreadCrumb.vue";
import BodyHeader from "./body/BodyHeader.vue";

export default {
  name: "ContainerBody",
  components: {BodyHeader, BreadCrumb}
}
</script>