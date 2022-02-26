import Vue from "vue";

export default {
    namespaced: true,
    actions: {
        async getItem(_, category, id) {
            const {
                data: result
            } = await Vue.prototype.$http.get(`/category/${category}/${id}`)
            this.commit('item/setItem', result.data)
        }
    },
    mutations: {
        setItem(state, item) {
            state.itemDetails = item
        }
    },
    state: {
        itemDetails: {}
    },
    getters: {}
}