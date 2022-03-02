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
import {getCurrentInstance} from "vue";
import {useRoute} from 'vue-router'

let bus = getCurrentInstance().appContext.config.globalProperties.$bus
let fullPath = useRoute().fullPath

bus.emit('test', fullPath)
</script>