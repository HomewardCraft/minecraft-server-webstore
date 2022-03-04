<template>
  <suspense>
    <extra-route/>
    <template #fallback>
      <page-loading/>
    </template>
  </suspense>
</template>

<script>
import {defineAsyncComponent} from "vue";
import PageLoading from "../components/PageLoading.vue";

const extraRoute = defineAsyncComponent({
  loader: () => import('../components/routes/ExtrasRoute/ExtraRoute.vue')
})

export default {
  name: "ExtrasRoute",
  components: {PageLoading, extraRoute},
}
</script>