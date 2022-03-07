import VueCookies from "vue3-cookies";

let isAuthenticated = false

export default async function (to, from) {
    if (!isAuthenticated && to.name !== 'login') {
        return {name: 'login'}
    }
    console.log(to)
    console.log(from)
}