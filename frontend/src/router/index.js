import VueRouter from 'vue-router'

import homepageRouter from "@/pages/HomepageRoute";
import cratesPage from "@/pages/CratesRoute";
import extrasPage from "@/pages/ExtrasRoute";
import productionPage from "@/pages/ProductionPageRoute";

export default new VueRouter(
    {
        routes: [
            {
                name: 'homepageRouter',
                path: '/',
                component: homepageRouter
            },
            {
                name: 'crates',
                path: '/crates',
                component: cratesPage
            },
            {
                name: 'extras',
                path: '/extras',
                component: extrasPage
            },
            {
                name: 'product',
                path: '/p/:id',
                component: productionPage
            }
        ]
    }
)