<template>
  <div class="container-body homepage">
    <div class="container mx-auto">
      <bread-crumb/>
      <router-view/>

    </div>
  </div>
</template>

<script>
import BreadCrumb from "./body/BreadCrumb.vue";

export default {
  name: "ContainerBody",
  components: {BreadCrumb}
}
</script>

<script setup>

</script>