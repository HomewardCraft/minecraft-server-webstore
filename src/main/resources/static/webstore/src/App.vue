<template>
  <div id="app">
    <wheader></wheader>
    <wsale class="wsale"></wsale>
    <br>
    <wcount></wcount>
    <span class="cat">
      Categories
    </span>
    <wcrates></wcrates>
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
import Wcrates from "./components/wcrates";


export default {
  name: 'App',
  components: {
    Wcrates,
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
.cat {
  padding: 20px 0;
  margin:auto;
  font-weight: bold;
  font-size: 28px;
  color: #FFFFFF;
  width: 1100px;
  height: 30px;
  display: block;
  text-align: left;
}

.wsale {
  alignment: center;
}

#app {
  background-color: black;
  margin: auto;

}
</style>
