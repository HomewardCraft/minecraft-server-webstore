import homepageRoute from "../pages/HomepageRoute.vue";
import ranksRoute from "../pages/RanksRoute.vue";
import cratesRoute from "../pages/CratesRoute.vue";
import extrasRoute from "../pages/ExtrasRoute.vue";
import itemDetailPage from "../pages/ItemDetailPage.vue";
import checkoutPage from "../pages/CheckoutPage.vue";

export default [
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
        name: 'ranks',
        path: '/ranks',
        component: ranksRoute
    },
    {
        name: 'crates',
        path: '/crates',
        component: cratesRoute
    }
    ,
    {
        name: 'detail',
        path: '/detail/:id',
        component: itemDetailPage
    },
    {
        name: 'checkout',
        path: '/checkout',
        component: checkoutPage
    }

]

