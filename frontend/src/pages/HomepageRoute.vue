<!-- 主页的路由, 路径"/" -->
<template>
<div>
  <HomepageCategories/>
  <div class="help">
    <homepageHelp/>
  </div>
</div>
</template>

<script>
import HomepageCategories from "@/components/homepage/HomepageCategories";
import homepageHelp from "@/components/homepage/HomepageHelp";

export default {
  name: "HomepageRoute",
  components: {
    HomepageCategories,
    homepageHelp
  }
}
</script>

<style scoped>
.help {
  margin-top: 100px;
  margin-left: 11px;
}
</style>