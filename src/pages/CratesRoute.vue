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
}
</script>

<script setup>
import {getCurrentInstance, ref} from "vue";

let http = getCurrentInstance().appContext.config.globalProperties.$http;

let crates = ref('')

function getItemList() {
  http.get(`fantang/api/category/crates`).then(
      res => {
        let result = res.data
        let imageAddress = ''
        let crates = {}
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
            crates[name] = crateArray
            crateArray = []
            imageAddress = item.itemBasicInfo.imageAddress
            crateArray.push(item)
          }

          if (i === result.data.length - 1) {
            let name = imageAddress.substring(45, imageAddress.length - 10);
            crates[name] = crateArray
          }
        }

        console.log('final crateArray: ', crateArray)
        console.log('final crates: ', crates)

        console.log(result.data)
        crates.value = crates
      }
  )

  // let imageAddress = ''
  // let crates = {}
  // let crateArray = []
  //
  // for (let i = 0; i < result.data.length; i++) {
  //   let item = result.data[i];
  //
  //
  //   if (imageAddress === '') {
  //     imageAddress = item.itemBasicInfo.imageAddress
  //   }
  //
  //
  //   if (imageAddress === item.itemBasicInfo.imageAddress) {
  //     crateArray.push(item)
  //   }
  //
  //   if (imageAddress !== item.itemBasicInfo.imageAddress) {
  //     let name = imageAddress.substring(45, imageAddress.length - 10);
  //     crates[name] = crateArray
  //     crateArray = []
  //     imageAddress = item.itemBasicInfo.imageAddress
  //     crateArray.push(item)
  //   }
  //
  //   if (i === result.data.length - 1) {
  //     let name = imageAddress.substring(45, imageAddress.length - 10);
  //     crates[name] = crateArray
  //   }
  // }
  //
  // console.log('final crateArray: ', crateArray)
  // console.log('final crates: ', crates)
  //
  // console.log(result.data)
  // crates.value = crates
}

getItemList()

console.log(crates)
</script>