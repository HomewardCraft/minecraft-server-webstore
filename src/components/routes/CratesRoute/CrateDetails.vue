<template>
  <div class="amounts grid lg:grid-cols-2 lg:grid-cols-4">
    <div class="amount block text-center py-5 font-bold cursor-pointer bg-gray-800 border border-light border-r-0 last:border-r group transition-all duration-150 ease-in-out transform hover:text-yellow-800 hover:bg-yellow-400 hover:-translate-y-2">
      <div class="amount text-2xl pb-1">20x</div>
      <div class="price opacity-25 text-sm line-through">$49.99 USD</div>
      <div class="price opacity-50">$44.99 USD</div>
      <purchase-button/>
    </div>
  </div>
</template>

<script>
import PurchaseButton from "./PurchaseButton.vue";

export default {
  name: "CrateDetails",
  components: {PurchaseButton}
}
</script>

<script setup>

</script>