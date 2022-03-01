<template>
  <!-- 这里定义交给路由管理的组件 -->
  <!-- 样式由父组件components/container/ContainerBody控制 -->
  <categories-section/>
  <help-section/>
</template>

<script>
import CategoriesSection from "../components/routes/HomepageRoute/CategoriesSection.vue";
import HelpSection from "../components/routes/HomepageRoute/HelpSection.vue";
export default {
  name: "HomepageRoute",
  components: {HelpSection, CategoriesSection}
}
</script>