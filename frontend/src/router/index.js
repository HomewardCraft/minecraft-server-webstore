import VueRouter from 'vue-router'

import homepageRouter from "@/pages/HomepageRoute";
import cratesPage from "@/pages/CratesRoute";

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
            }
        ]
    }
)