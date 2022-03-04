import {createStore} from "vuex";
import {getCurrentInstance} from "vue";
import {useCookies} from "vue3-cookies";

const {cookies} = useCookies();
let ctx = getCurrentInstance()

const actions = {
    //响应组件中加的动作
    login(context, value) {
        context.commit('login', value)
    },
    addItemToCart(context, value) {
        context.commit('addItemToCart', value)
    },
    removeItemFromCart(context, value) {
        context.commit('removeItemFromCart', value)
    },
    increaseItemByOne(context, value) {
        context.commit('increaseItemByOne', value)
    },
    decreaseItemByOne(context, value) {
        context.commit('decreaseItemByOne', value)
    },
    removeThisItem(context, value) {
        context.commit('removeThisItem', value)
    }
}

const mutations = {
    //执行加
    login(state, value) {
        state.user.logged_in = true
        state.user.ign = value.name
        state.user.uuid = value.id
        cookies.set("user_session", state.user, "7D")
    },
    addItemToCart(state, value) {
        this.state.cart.items.push(value)
        console.log(state.cart)
    },
    removeItemFromCart(state, value) {
        var index = {}
        for (index in this.state.cart.items) {
            if (this.state.cart.items[index].id == value.id) {
                this.state.cart.items.splice(index, 1)
            }
        }
        console.log("(!) 现在购物车有以下物品")
        console.log(this.state.cart.items)
        console.log("=====================")
    },
    increaseItemByOne(state, value) {
        for (var index in this.state.cart.items) {
            if (this.state.cart.items[index].id == value.id) {
                this.state.cart.items[index].quantity++
                console.log("(+) 添加成功 当前有" + this.state.cart.items[index].quantity + "个")
            }
        }
    },
    decreaseItemByOne(state, value) {
        for (var index in this.state.cart.items) {


            if (this.state.cart.items[index].id == value.id) {

                this.state.cart.items[index].quantity--
                console.log("(-) 减少成功 当前有" + this.state.cart.items[index].quantity + "个")
            }
        }
    },
    removeThisItem(state, value) {
        for (var index in this.state.cart.items) {
            if (this.state.cart.items[index].id == value.id) {
                this.state.cart.items.splice(index, 1)
            }
        }
    }

}

const state = {
    //登录初始数据
    "user": {
        "logged_in": false,
        "ign": " ",
        "uuid": " "
    },
    "cart": {
        "items": [],
        "total": 0
    }
}

export default createStore({
    actions,
    state,
    mutations
})