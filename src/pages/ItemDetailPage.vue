<template>
  <suspense>
    <item-detail-hub/>
    <template #fallback>
      <page-loading/>
    </template>
  </suspense>
</template>

<script>
import {defineAsyncComponent} from "vue";
import PageLoading from "../components/PageLoading.vue";

const ItemDetailHub = defineAsyncComponent({
  loader: () => import('../components/routes/ItemDetail/ItemDetailHub.vue')
})

export default {
  name: "CratesRoute",
  components: {PageLoading, ItemDetailHub},
}
</script>