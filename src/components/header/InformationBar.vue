<template>
  <div class="flex flex-col items-end">
    <navigator-bar/>
    <website-bar/>
  </div>
</template>

<script>
import NavigatorBar from "./bar/NavigatorBar.vue";
import WebsiteBar from "./bar/WebsiteBar.vue";
export default {
  name: "InformationBar",
  components: {WebsiteBar, NavigatorBar}
}
</script>

<style scoped>
.items-end {
  align-items: flex-end;
}
</style>