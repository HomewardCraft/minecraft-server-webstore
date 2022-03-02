<template>
  <extra-route/>
</template>

<script>
import extraRoute from "../components/routes/ExtrasRoute/ExtraRoute.vue";

export default {
  name: "ExtrasRoute",
  components: {extraRoute}
}
</script>

<script setup>
import sendRoutePath from "../hooks/sendRoutePath.js";

sendRoutePath()
</script>