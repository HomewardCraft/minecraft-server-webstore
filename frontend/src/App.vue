<!-- 管理所有组件的组件 -->
<template>
  <div id="app">
    <br>
    <homewardHeader/>
    <Breadcrumb v-show="this.$route.path !== '/'"></Breadcrumb>
    <homewardSale class="sale"/>
    <br>
    <homepage-special-bar/>
    <span class="cat"/>
    <!-- 引入路由 -->
    <router-view/>
    <homewardFooter/>
  </div>
</template>


<script>
//导入组件
import homewardHeader from "@/components/HomewardHeader";
import homewardSale from "@/components/HomewardSale";
import homepageSpecialBar from "@/components/homepage/HomepageSpecialBar";
import homewardFooter from "@/components/HomewardFooter";
import Breadcrumb from "@/components/util/Breadcrumb";

export default {
  name: 'App',
  components: {
    homewardHeader,
    homewardSale,
    homepageSpecialBar,
    homewardFooter,
    Breadcrumb
  }
}
</script>


<style>
.mb-0\.5 {
  margin-bottom: 0.5rem;
}

.mb-2\.5 {
  margin-bottom: 2.5rem;
}

.mt-1\.25 {
  margin-top: -1.25rem;
}

.p-12 {
  padding: 1.5rem 2rem;
}

.width-auto {
  width: auto;
}

.flex-row {
  flex-direction: row;
}

.flex {
  display: flex;
}

.justify-center {
  justify-content: center;
}

.items-center {
  align-items: center;
}

.fontcolor-white {
  color: #fff;
}

.module-general {
  margin-left: auto;
  margin-right: auto;
  max-width: 1100px;
}

.grid {
  display: grid;
}

@font-face {
  font-family: proxima-nova;
  src: url("/src/assets/fonts/proximanova.ttf");
}

body {
  font-family: proxima-nova, sans-serif;
}

div {
  display: block;
}

.container {
  box-sizing: border-box;
  max-width: 1100px;
  margin-left: auto;
  margin-right: auto;
}

.sale {
  alignment: center;
}

#app {
  width: 100%;
  background-color: black;
  margin: 0 auto;
  overflow: hidden;
  position: relative;
}

.height-full {
  height: 100%;
}

.grid-rows-auto {
  grid-template-rows: auto 1fr auto;
}
</style>
