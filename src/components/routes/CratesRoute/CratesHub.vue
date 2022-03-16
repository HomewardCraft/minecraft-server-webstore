<template>
  <div class="category-heading pt-4 text-center">
    <div class="text-5xl text-white font-bold">Crates</div>
  </div>
  <crate-showcase v-for="crate in crates" :key="crate.id" :crates="crate"/>
</template>

<script>
import CrateShowcase from "./CrateShowcase.vue";

export default {
  name: "CratesHub",
  components: {CrateShowcase},
}
</script>

<script setup>
import {ref} from "vue";
import sendRoutePath from "../../../hooks/sendRoutePath.js";
import axios from "axios";

let crates = ref('')

async function getCratesList() {
  const {
    data: result
  // } = await axios.get(`baioretto/webstore/api/category/crates`)
  } = await axios.get(`local/category/crates`)

  let imageAddress = ''
  let cratesObject = {}
  let crateArray = []

  for (let i = 0; i < result.data.length; i++) {
    let item = result.data[i];

    if (imageAddress === '') {
      imageAddress = item.imageAddress
    }

    if (imageAddress === item.imageAddress) {
      crateArray.push(item)
    }

    if (imageAddress !== item.imageAddress) {
      let name = imageAddress.substring(45, imageAddress.length - 10);
      cratesObject[name] = crateArray
      crateArray = []
      imageAddress = item.imageAddress
      crateArray.push(item)
    }

    if (i === result.data.length - 1) {
      let name = imageAddress.substring(45, imageAddress.length - 10);
      cratesObject[name] = crateArray
    }
  }

  crates.value = cratesObject
}

getCratesList()

sendRoutePath()
</script>