<template>
  <div class="category-heading pt-4 text-center">
    <div class="text-5xl text-white font-bold">Crates</div>
  </div>
  <crate-showcase v-for="crate in crates" :key="crate.id" :crates="crate"/>
</template>

<script>
import CrateShowcase from "../components/routes/CratesRoute/CrateShowcase.vue";

export default {
  name: "CratesRoute",
  components: {CrateShowcase},
}
</script>

<script setup>
import {getCurrentInstance, ref} from "vue";

let http = getCurrentInstance().appContext.config.globalProperties.$http;
let crates = ref('')

async function getCratesList() {
  const {
    data: result
  } = await http.get(`fantang/api/category/crates`)

  let imageAddress = ''
  let cratesObject = {}
  let crateArray = []

  for (let i = 0; i < result.data.length; i++) {
    let item = result.data[i];

    if (imageAddress === '') {
      imageAddress = item.itemBasicInfo.imageAddress
    }

    if (imageAddress === item.itemBasicInfo.imageAddress) {
      crateArray.push(item)
    }

    if (imageAddress !== item.itemBasicInfo.imageAddress) {
      let name = imageAddress.substring(45, imageAddress.length - 10);
      cratesObject[name] = crateArray
      crateArray = []
      imageAddress = item.itemBasicInfo.imageAddress
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
</script>