import axios from "axios";

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
axios.defaults.transformRequest = [(value) => {
    let formattedData = ''
    for (let data in value) {
        formattedData += encodeURIComponent(data) + '=' + encodeURIComponent(value[data]) + '&'
    }
    return formattedData
}]

export default axios