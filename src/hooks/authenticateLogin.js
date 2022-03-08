import {useCookies} from "vue3-cookies";


const {cookies} = useCookies()
let isAuthenticated = false

export default async function (to, from) {
    let authorization = cookies.get('authorization');
    isAuthenticated = !(authorization === null || authorization === '');
    if (!isAuthenticated && to.name !== 'login') {
        return {name: 'login'}
    }
}