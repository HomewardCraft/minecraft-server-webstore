<template>
  <div class="grid lg:grid-cols-checkout gap-6 checkout">
    <Checkoutmain></Checkoutmain>
    <Checkoutdetails></Checkoutdetails>
    <rule-information/>
    <Checkoutbuttons></Checkoutbuttons>
  </div>
</template>

<script setup>
import {getCurrentInstance, onBeforeUnmount, onMounted, ref} from "vue";

let BUS = getCurrentInstance().appContext.config.globalProperties.$bus

let isPlayerAgreePrivacy = ref(false)
let isPlayerAgreeTerms = ref(false)

onMounted(() => {
  BUS.emit('changePromotionState', 'hide')
  BUS.on('giveConfirmDataToPage',(data)=>{
    isPlayerAgreePrivacy.value = data.isPlayerAgreePrivacy
    isPlayerAgreeTerms.value = data.isPlayerAgreeTerms
  })

})

onBeforeUnmount(() => {
  BUS.emit('changePromotionState', 'show')
})
</script>

<script>
import Checkoutmain from "../components/routes/CheckoutRoute/checkoutmain.vue";
import Checkoutdetails from "../components/routes/CheckoutRoute/checkoutdetails.vue";
import RuleInformation from "../components/routes/CheckoutRoute/RuleInformation.vue";
import Checkoutbuttons from "../components/routes/CheckoutRoute/checkoutbuttons.vue";

export default {
  name: "CheckoutPage",
  components: {Checkoutbuttons, RuleInformation, Checkoutdetails, Checkoutmain}
}
</script>

<style scoped>
@media (min-width: 992px) {
  .lg\:grid-cols-checkout {
    grid-template-columns: 1fr minmax(260px, 380px);
  }
}

.checkout .avatar .button {
  background: linear-gradient(to top, #181a1b, rgba(24, 26, 27, 0));
}

</style>