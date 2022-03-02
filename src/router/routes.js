import homepageRoute from "../pages/HomepageRoute.vue";
import ranksRoute from "../pages/RanksRoute.vue";
import cratesRoute from "../pages/CratesRoute.vue";
import extrasRoute from "../pages/ExtrasRoute.vue";
import itemDetailPage from "../pages/ItemDetailPage.vue";

export default [
    {
        path: '/',
        component: homepageRoute
    },
    {
        path: '/extras',
        component: extrasRoute
    },
    {
        path: '/ranks',
        component: ranksRoute
    },
    {
        path: '/crates',
        component: cratesRoute
    }
    ,
    {
        name: 'detail',
        path: '/detail/:id',
        component: itemDetailPage
    }
]