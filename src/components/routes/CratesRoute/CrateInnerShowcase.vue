<template>
  <div class="text p-10 lg:col-span-3">
    <div class="title text-center lg:text-left font-bold text-3xl mb-6">Cosmetic Crates</div>
    <div class="relative">
      <crate-details @click="toDetailPage"/>
    </div>
  </div>
</template>

<script>
import PurchaseButton from "./PurchaseButton.vue";
import CrateDetails from "./CrateDetails.vue";

export default {
  name: "CrateInnerShowcase",
  components: {CrateDetails, PurchaseButton}
}
</script>

<script setup>
import {useRouter} from "vue-router";

let router = useRouter()

function toDetailPage(id) {
  router.push({
    name: 'detail',
    params: {
      id: id
    }
  })
}
</script>