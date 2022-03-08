import {useCookies} from "vue3-cookies";


const {cookies} = useCookies()
let isAuthenticated = false

let authorization = cookies.get('Authorization');

export default async function (to, from) {
    if (!isAuthenticated && to.name !== 'login') {
        return {name: 'login'}
    }
}