import { createStore } from "vuex";
import {getCurrentInstance} from "vue";
import { useCookies } from "vue3-cookies";

const { cookies } = useCookies();
let ctx = getCurrentInstance()

const actions = {
    //响应组件中加的动作
    login(context,value){
        context.commit('login',value)
    },
}

const mutations = {
    //执行加
    login(state,value){
        state.user.logged_in = true
        state.user.ign = value.name
        state.user.uuid = value.id
        cookies.set("user_session", state.user,"7D")
    }
}

const state = {
    //登录初始数据
    "user": {
        "logged_in": false,
        "ign": " ",
        "uuid": " "
    }
}

export default createStore({
    actions,
    state,
    mutations
})