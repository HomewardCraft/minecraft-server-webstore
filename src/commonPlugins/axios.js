import axios from "axios";
import {useCookies} from "vue3-cookies";

const {cookies} = useCookies();

const authorization = cookies.get('authorization');

const axiosInstance = axios.create({
    timeout: 5000
})

axiosInstance.interceptors.request.use(
    config => {
        config.headers['Authorization'] = authorization
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

export default axiosInstance