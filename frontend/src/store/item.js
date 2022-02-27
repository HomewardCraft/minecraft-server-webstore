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
            if (state.itemDetails.length !== 0) {
                state.itemDetails.splice(0, state.itemDetails.length)
            }
            state.itemDetails.push(item)
        }
    },
    state: {
        itemDetails: []
    },
    getters: {}
}