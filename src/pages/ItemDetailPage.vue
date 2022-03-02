<template>
  <div class="grid lg:grid-cols-3 gap-12">
    <item-detail-info></item-detail-info>
    <div class="info">
      <item-picture></item-picture>
      <ItemAddCart></ItemAddCart>
    </div>
  </div>
</template>

<script>
import ItemDetailInfo from "../components/routes/ItemDetail/ItemDetailInfo.vue";
import ItemPicture from "../components/routes/ItemDetail/ItemPicture.vue";
import ItemAddCart from "../components/routes/ItemDetail/ItemAddCart.vue";

export default {
  name: "ItemDetailPage",
  components: {ItemAddCart, ItemPicture, ItemDetailInfo}
}
</script>

<script setup>
import sendRoutePath from "../hooks/sendRoutePath.js";

sendRoutePath()
</script>