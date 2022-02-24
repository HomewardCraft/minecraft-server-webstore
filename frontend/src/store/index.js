//该文件用于创建Vuex中最为核心的store
import Vue from 'vue'
//引入Vuex
import Vuex from 'vuex'
//应用Vuex插件
Vue.use(Vuex)

import crate from "@/store/crate";

//创建并暴露store
export default new Vuex.Store({
    modules: {
        crate:crate
    }
})