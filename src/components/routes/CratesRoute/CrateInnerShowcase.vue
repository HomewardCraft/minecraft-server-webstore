<template>
  <div class="text p-10 lg:col-span-3">
    <div class="title text-center lg:text-left font-bold text-3xl mb-6">{{ name }}</div>
    <div class="relative">
      <div class="amounts grid lg:grid-cols-4">
        <crate-details v-for="crate in props.crates" :key="crate.index" :crate="crate" @click="toDetailPage(crate.id)"/>
      </div>
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

const router = useRouter()
const props = defineProps(['crates'])

const amountAndName = props.crates[0].name;
let name = amountAndName.split(' ', 3)[1] + ' ' + 'Crate'

function toDetailPage(id) {
  router.push({
    name: 'detail',
    params: {
      id: id
    }
  })
}
</script>