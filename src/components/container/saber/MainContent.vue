<template>
  <div class="content-user">
    <user-content/>
    <button-content/>
  </div>
  <div class="content-cart py-10">
    <cart-content/>
  </div>
</template>

<script setup>


</script>

<script>
import UserContent from "./content/UserContent.vue";
import ButtonContent from "./content/ButtonContent.vue";
import CartContent from "./content/CartContent.vue";
export default {
  name: "MainContent",
  components: {CartContent, ButtonContent, UserContent}
}
</script>