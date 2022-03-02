import { createStore } from "vuex";

const state = {
    //登录初始数据
    "user": {
        "logged_in": true,
        "ign": " ",
        "uuid": " "
    }
}

export default createStore({
    state
})