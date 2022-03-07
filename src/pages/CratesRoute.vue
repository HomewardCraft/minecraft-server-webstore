<template>
  <suspense>
    <crates-hub/>
    <template #fallback>
      <page-loading/>
    </template>
  </suspense>
</template>

<script>
import {defineAsyncComponent} from "vue";
import PageLoading from "../components/PageLoading.vue";

const CratesHub = defineAsyncComponent({
  loader: () => import('../components/routes/CratesRoute/CratesHub.vue')
})

export default {
  name: "CratesRoute",
  components: {PageLoading, CratesHub},
}
</script>