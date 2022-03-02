import homepageRoute from "../pages/HomepageRoute.vue";
import extrasRoute from "../components/routes/HomepageRoute/ExtrasRoute.vue";

export default [
    {
        path: '/',
        component: homepageRoute
    },
    {
        path: '/extras',
        component: extrasRoute
    }
]