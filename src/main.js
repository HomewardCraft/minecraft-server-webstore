import { createApp } from 'vue'
import App from './App.vue'

import router from "./router/index.js";
import vuex from './store/index.js'
import mitt from "mitt";

import './index.css'

const app = createApp(App)

app.use(router)
app.use(vuex)

app.config.globalProperties.$bus = new mitt()
app.mount('#app')


