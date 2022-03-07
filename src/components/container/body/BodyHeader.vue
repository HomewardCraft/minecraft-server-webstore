<template>
  <div v-show="isShow"
       class="promotion flex lg:items-center justify-between mb-10 py-12 lg:py-20 px-10 lg:px-16">
    <item-promotion/>
  </div>
  <div class="special-bar mb-10 -mt-5" style="background-color: rgb(175, 97,  196)">
    <special-bar/>
  </div>
</template>

<script setup>

import {onMounted, ref} from "vue";
import {getCurrentInstance} from "vue";

let BUS = getCurrentInstance().appContext.config.globalProperties.$bus
let isShow = ref(true)

onMounted(() => {

  BUS.on('changePromotionState', (manipulation) => {
    console.log("start")
    if (manipulation === 'show') {
      console.log("should show")

      isShow.value = true
    }
    if (manipulation === 'hide') {
      console.log("should hide")
      isShow.value = false
    }
  })
})

</script>

<script>
import ItemPromotion from "./header/ItemPromotion.vue";
import SpecialBar from "./header/SpecialBar.vue";

export default {
  name: "BodyHeader",
  components: {SpecialBar, ItemPromotion}
}


</script>

<style scoped>
.promotion {
  background: linear-gradient(180deg, #87419a 30%, rgba(217, 141, 31, 0)), url(./src/assets/images/homepage/valentines.png) 100%/cover;
  justify-content: center;
}

@screen lg {
  .promotion {
    justify-content: space-between;
    background: linear-gradient(90deg, #87419a, rgba(217, 141, 31, 0) 70%), url(./src/assets/images/homepage/valentines.png) 100%/cover;
  }

  .special-bar {
    padding: 10px 20px;
  }
}

.promotion {
  text-shadow: rgb(0 0 0 / 25%) 3px 3px 2px;
  box-shadow: inset #fff3 0 0 0 3px;
  position: relative;
}

.special-bar {
  background: #452ea3;
  font-weight: 700;
  border: 2px solid rgba(255, 255, 255, .1);
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  text-align: center;
  position: relative;
}
</style>