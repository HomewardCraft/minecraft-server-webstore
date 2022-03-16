<template>
  <div class="text p-10 lg:col-span-3">
    <div class="title text-center lg:text-left font-bold text-3xl mb-6">{{ name }}</div>
    <div class="relative">
      <div class="amounts grid lg:grid-cols-4">
        <crate-details v-for="crate in props.crates" :key="crate.index" :crate="crate"  @click="toEditorPage(crate.id)"/>
      </div>
    </div>
  </div>
</template>

<script>
import CrateDetails from "./CrateDetails.vue";

export default {
  name: "CrateInnerShowcase",
  components: {CrateDetails}
}
</script>

<script setup>
import {useRouter} from "vue-router";

const router = useRouter()
const props = defineProps(['crates'])

console.log(props.crates)

const amountAndName = props.crates[0].name;
const name = amountAndName.split(' ', 3)[1] + ' ' + 'Crate'

function toEditorPage(id) {
  router.push({
    name: 'detail',
    params: {
      id: id
    }
  })
}
</script>