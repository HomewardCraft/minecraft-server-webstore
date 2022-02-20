//引入Vue
import Vue from 'vue'
//引入app组件
import App from './App.vue'
//引入插件
import developerplugin from "./components/plugins/developer";
//引入vuex
import Vuex from 'vuex'
//引入store
import store from './store/index.js'

//使用插件
Vue.use(developerplugin)

//关闭vue生产提示
Vue.config.productionTip = false

//创建vm
new Vue({
  el: '#app',
  //模板渲染器
  render: h => h(App),
  store,
  beforeCreate() {
    Vue.prototype.$bus = this //全局事件总线
  }
})
    // .$mount('#app')
