import homepageRoute from "../pages/HomepageRoute.vue";
import cratesRoute from "../pages/CratesRoute.vue";
import extrasRoute from "../pages/ExtrasRoute.vue";
import loginRoute from "../pages/LoginRoute.vue";

export default [
    {
        name: 'login',
        path: '/login',
        component: loginRoute
    },
    {
        name: 'home',
        path: '/',
        component: homepageRoute
    },
    {
        name: 'extras',
        path: '/extras',
        component: extrasRoute
    },
    {
        name: 'crates',
        path: '/crates',
        component: cratesRoute
    }
]

