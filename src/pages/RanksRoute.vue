<template>
  <suspense>
    <ranks-route/>
    <template #fallback>
      <page-loading/>
    </template>
  </suspense>
</template>

<script>
import {defineAsyncComponent} from "vue";
import PageLoading from "../components/PageLoading.vue";

const RanksRoute = defineAsyncComponent({
  loader: () => import('../components/routes/RanksRoute/RankHub.vue')
})

export default {
  name: "ExtrasRoute",
  components: {PageLoading, RanksRoute},
}
</script>