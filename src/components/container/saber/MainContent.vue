<template>
  <div class="content-user">
    <user-content></user-content>
    <button-content/>
  </div>
</template>

<script>
import ButtonContent from "./content/ButtonContent.vue";
import UserContent from "./content/UserContent.vue";
export default {
  name: "MainContent",
  components: {UserContent, ButtonContent}
}
</script>