<template>
  <div class="category-heading pt-4 text-center">
    <div class="text-5xl text-white font-bold">Crates</div>
  </div>
  <crate-showcase/>
</template>

<script>
import CrateShowcase from "../components/routes/CratesRoute/CrateShowcase.vue";
export default {
  name: "CratesRoute",
  components: {CrateShowcase},
  beforeCreate() {
    // let http = this.$.appContext.config.globalProperties.$http;

    // getItemList()
    //
    // async function getItemList() {
    //   const {
    //     data: result
    //   } = await http.get(`fantang/crate`)
    //
    //   console.log(result);
    // }
  }
}
</script>

<script setup>
import {getCurrentInstance} from "vue";
let http = getCurrentInstance().appContext.config.globalProperties.$http;

getItemList()

async function getItemList() {
  const {
    data: result
  } = await http.get(`fantang/api/category/crates`)

  console.log(result);
}

</script>