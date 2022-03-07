import {createRouter, createWebHashHistory} from "vue-router";

import routes from "./routes.js";

import authenticateLogin from "../hooks/authenticateLogin.js";

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})


// router.beforeEach(authenticateLogin)

export default router