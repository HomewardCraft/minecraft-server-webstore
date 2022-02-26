import Vue from "vue";

export default {
    namespaced: true,
    actions: {
        async getItemList(_, category) {
            const {
                data: result
            } = await Vue.prototype.$http.get(`/category/${category}`)
            this.commit('itemList/setItemList', result.data)
        }
    },
    mutations: {
        setItemList(state, itemList) {
            if (state.itemArray.length !== 0) {
                state.itemArray.splice(0, state.itemArray.length)
            }
            itemList.forEach((crate) => {
                state.itemArray.push(crate)
            })
        }
    },
    state: {
        itemArray: []
    },
    getters: {}
}