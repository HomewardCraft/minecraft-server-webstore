<template>
  <div
      class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out opacity-100 pointer-events-auto"
      data-v-00ffbf09="">
    <div class="transition-transform duration-200 ease-in-out transform" data-v-00ffbf09="">
      <div class="title flex items-center justify-between mb-6" data-v-00ffbf09="">
        <div class="font-bold text-2xl" data-v-00ffbf09="">Terms &amp; Conditions</div>
        <svg
            @click = "closewindow"
            viewBox="0 0 36 36" fill="currentColor"
             class="w-4 h-4 box-content text-gray-500-400 cursor-pointer p-4 rounded-full bg-gray-800 shadow-lg transition-colors duration-150 ease-in-out hover:text-red-400"
             data-v-00ffbf09="">
          <path
              d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z"
              data-v-00ffbf09=""></path>
        </svg>
      </div>
      <div class="body bg-gray-900 p-6 content-wrap" data-v-00ffbf09="">
        <p>Payments to &nbsp;"Origin Realms" is a payment for the virtual items contained in the purchase. This
          transaction is final and there are no refunds.</p>
        <p><br></p>
        <p>If you are banned for breaking the rules of the server, you will not be refunded. Bans are subject to the
          full discretion of the server admins and rules can be changed at any time. There is no guarantee on being able
          to enter the server, and if the server and/or feature is no longer operated the virtual items are forfeit.</p>
        <p><br></p>
        <p>Refund requests due to issues concerning lag, game glitches, or any other issues are subject to the
          discretion of the administration team. Any item that can be placed in a players inventory is subject to expiry
          upon player death. All items are virtual and have no value. </p>
        <p><br></p>
        <p><span><strong>All items purchased, that are not ranks are for one map only meaning that they will be lost upon reset of the server. &nbsp;Chargebacks will ensure you are banned from entering the server. We do not offer refunds.</strong></span>
        </p>
      </div>
    </div>
  </div>
</template>

<script setup>
import {getCurrentInstance} from "vue";

let BUS = getCurrentInstance().appContext.config.globalProperties.$bus
function closewindow() {
  BUS.emit('termManipulation', 'close'
  )}
</script>

<script>
export default {
  name: "checkoutterms"
}
</script>

<style scoped>
.modal[data-v-00ffbf09] {
  padding: 40px 0 0;
  overflow: auto;
}

.modal {
  z-index: 99999;
}

.modal .body[data-v-00ffbf09] {
  max-width: 700px;
  margin-bottom: 40px;
}
</style>