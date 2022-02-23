<!-- 管理所有组件的组件 -->
<template>
  <div id="app">
    <br>
    <homewardHeader/>
    <homewardSale class="sale"/>
    <br>
    <homepageCount/>
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
import homepageCount from "@/components/homepage/HomepageCount";
import homewardFooter from "@/components/HomewardFooter";

export default {
  name: 'App',
  components: {
    homewardHeader,
    homewardSale,
    homepageCount,
    homewardFooter
  }
}
</script>


<style>
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
</style>
