<template>
  <div id="app">
    <img alt="Arcane logo" src="./assets/logo_show.png" width="50%" height="50%">
    <HelloWorld msg="Arcane Homeward"/>
  </div>
</template>

<script>
//导入组件
import HelloWorld from './components/HelloWorld.vue'
import wlogo from "./components/wlogo";
import wheader from "./components/wheader";
import wsale from "./components/wsale";
import wcount from "./components/wcount";
import wcategories from "./components/wcategories";
import whelp from "./components/whelp";
import wfooter from "./components/wfooter";


export default {
  name: 'App',
  components: {
    HelloWorld,
    wlogo,
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
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
