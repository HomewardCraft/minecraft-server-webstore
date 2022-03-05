<template>
  <div class="grid lg:grid-cols-checkout gap-6 checkout">
    <Checkoutmain></Checkoutmain>
    <Checkoutdetails></Checkoutdetails>
    <Checkoutconfirm></Checkoutconfirm>
    <Checkoutbuttons></Checkoutbuttons>
  </div>
  <Checkoutprivacy/>
  <Checkoutterms/>
</template>

<script setup>
import {getCurrentInstance, onBeforeUnmount, onMounted, ref} from "vue";
import Checkoutprivacy from "../components/routes/CheckoutRoute/checkoutprivacy.vue";
import Checkoutterms from "../components/routes/CheckoutRoute/checkoutterms.vue";
let BUS = getCurrentInstance().appContext.config.globalProperties.$bus
let isPrivacyOpen = ref(false)

onMounted(() => {
  BUS.emit('changePromotionState','hide')
})

onBeforeUnmount(() => {
  BUS.emit('changePromotionState','show')
})
</script>

<script>
import Checkoutmain from "../components/routes/CheckoutRoute/checkoutmain.vue";
import Checkoutdetails from "../components/routes/CheckoutRoute/checkoutdetails.vue";
import Checkoutconfirm from "../components/routes/CheckoutRoute/checkoutconfirm.vue";
import Checkoutbuttons from "../components/routes/CheckoutRoute/checkoutbuttons.vue";

export default {
  name: "CheckoutPage",
  components: { Checkoutbuttons, Checkoutconfirm, Checkoutdetails, Checkoutmain}
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