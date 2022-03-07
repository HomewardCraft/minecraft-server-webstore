<template>
  <!-- 这里定义交给路由管理的组件 -->
  <!-- 样式由父组件components/container/ContainerBody控制 -->
  <section class="section-categories mb-6">
    <categories-section/>
  </section>
  <section class="section-help mt-16">
    <help-section/>
  </section>
</template>

<script>
import CategoriesSection from "../components/routes/HomepageRoute/CategoriesSection.vue";
import HelpSection from "../components/routes/HomepageRoute/HelpSection.vue";

export default {
  name: "HomepageRoute",
  components: {HelpSection, CategoriesSection}
}
</script>

<script setup>
import sendRoutePath from "../hooks/sendRoutePath.js";

sendRoutePath()
</script>