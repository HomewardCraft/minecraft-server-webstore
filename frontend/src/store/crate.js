import Vue from "vue";

export default {
    namespaced: true,
    actions: {
        async getCrates(context, category) {
            const {
                data: result
            } = await Vue.prototype.$http.get(`/category/${category}`)
            this.commit('crate/setCrates', result.data)
        }
    },
    mutations: {
        setCrates(state, crates) {
            if (state.itemList.length === 0) {
                crates.forEach((crate) => {
                    state.itemList.push(crate)
                })
            }
        }
    },
    state: {
        itemList: []
    },
    getters: {}
}