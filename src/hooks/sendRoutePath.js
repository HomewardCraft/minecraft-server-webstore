import {getCurrentInstance} from "vue";
import {useRoute} from 'vue-router'

export default function (item) {
    let bus = getCurrentInstance().appContext.config.globalProperties.$bus

    let fullPath = useRoute().fullPath

    let routeObject = {
        fullPath,
        item
    }

    bus.emit('sendRoutePath', routeObject)
}