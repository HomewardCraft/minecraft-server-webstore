<template>
  <bread-crumb/>
  <body-header/>
  <body-container/>
</template>

<script>
import BreadCrumb from "./body/BreadCrumb.vue";
import BodyHeader from "./body/BodyHeader.vue";
import BodyContainer from "./body/BodyContainer.vue";

export default {
  name: "BodyFrame",
  components: {BodyContainer, BodyHeader, BreadCrumb}
}
</script>