import {createRouter, createWebHistory} from "vue-router";

const homeHub = () => import('../components/page-wrap/home/HomeHub.vue')
const rulesHub = () => import('../components/page-wrap/rules/RulesHub.vue')
const blogHub = () => import('../components/page-wrap/blog/BlogHub.vue')
const header = () => import('../components/PageHeader.vue')
const footer = () => import('../components/PageFooter.vue')

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/blog',
            name: 'blog',
            components: {
                default: blogHub,
                header,
                footer
            }
        },
        {
            path: '/rules',
            name: 'rules',
            components: {
                default: rulesHub,
                header,
                footer
            }
        },
        {
            name: 'home',
            path: '/',
            components: {
                default: homeHub,
                footer
            }
        }
    ]
})

export {router}