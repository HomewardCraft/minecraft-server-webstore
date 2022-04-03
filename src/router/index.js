import {createRouter, createWebHistory} from "vue-router";

const blogHub = () => import('../components/page-wrap/blog/BlogHub.vue')

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/blog',
            name: 'blog',
            component: blogHub
        }
    ]
})

export {router}