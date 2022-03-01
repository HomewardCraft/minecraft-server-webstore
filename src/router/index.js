import homepageRoute from "../pages/HomepageRoute.vue";

const routes = [
    {
        path: '/',
        component: homepageRoute
    }
]

export default VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes
})