import {getCurrentInstance} from "vue";
import {useRoute} from 'vue-router'

export default function () {
    let bus = getCurrentInstance().appContext.config.globalProperties.$bus

    let fullPath = useRoute().fullPath

    bus.emit('sendRoutePath', fullPath)
}