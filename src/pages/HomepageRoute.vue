<template>
  <container-categories/>
  <container-help/>
</template>

<script>
import ContainerCategories from "../components/routes/HomepageRoute/ContainerCategories.vue";
import ContainerHelp from "../components/routes/HomepageRoute/ContainerHelp.vue";
export default {
  name: "HomepageRoute",
  components: {ContainerHelp, ContainerCategories}
}
</script>