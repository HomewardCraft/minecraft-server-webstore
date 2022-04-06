<template>
  <div data-page="rules" class="page-bg" style="background-image: url(https://ba1oretto.com/blog/2022/04/Badger_Blog.jpg)"/>
  <rules-container/>
</template>

<script>
import RulesContainer from "./RulesContainer.vue";
import PageHeader from "../../PageHeader.vue";

export default {
  name: "RulesHub",
  components: {PageHeader, RulesContainer}
}
</script>

<style scoped>

</style>