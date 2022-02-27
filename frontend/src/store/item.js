import Vue from "vue";

export default {
    namespaced: true,
    actions: {
        async getItem(_, item) {
            const {
                data: result
            } = await Vue.prototype.$http.get(`/category/${item.category}/${item.id}`)
            this.commit('item/setItem', result.data)
        }
    },
    mutations: {
        setItem(state, item) {
            state.itemDetails = item
        }
    },
    state: {
        itemDetails: ''
    },
    getters: {}
}