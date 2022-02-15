<template>
  <div id="app">
    <wheader></wheader>
    <wsale></wsale>
  </div>
</template>

<script>
//导入组件
import HelloWorld from './components/HelloWorld.vue'
import wheader from "./components/wheader";
import wsale from "./components/wsale";
import wcount from "./components/wcount";
import wcategories from "./components/wcategories";
import whelp from "./components/whelp";
import wfooter from "./components/wfooter";
import Wrouter from "./components/wrouter";


export default {
  name: 'App',
  components: {
    Wrouter,
    HelloWorld,
    wheader,
    wsale,
    wcount,
    wcategories,
    whelp,
    wfooter
  }
}
</script>

<style>

#app {
  background-color: black;

}
</style>
