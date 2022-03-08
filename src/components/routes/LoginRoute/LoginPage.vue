<template>
  <div class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out opacity-100 pointer-events-auto select-none">
    <div class="transition-transform duration-200 ease-in-out transform">
      <div class="title flex items-center justify-between mb-6 -mb-0.5">
        <login-title/>
      </div>
      <div class="body bg-gray-900 grid lg:grid-cols-3 items-center">
        <LoginAvatar/>
        <div class="form p-10 lg:col-span-2">
          <div>
            <input maxlength="16" v-model="admin.username" placeholder="Administration Account" class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
            <input type="password" maxlength="32" v-model="admin.password" placeholder="Administration Password" class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
            <button @click="login" class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center w-full focus:outline-none">继续登录校验</button>
          </div>
        </div>
        <LoginHelp/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginPage"
}
</script>

<script setup>
import {reactive} from "vue";
import {getCurrentInstance} from "vue";
import {useCookies} from "vue3-cookies";
import setCurrentToastComponent from "../../../hooks/setToastComponent.js";
import {useRouter} from "vue-router";
import LoginTitle from "../../ComponentsLogin/LoginTitle.vue";
import LoginAvatar from "../../ComponentsLogin/LoginAvatar.vue";
import LoginHelp from "../../ComponentsLogin/LoginHelp.vue";

const {cookies} = useCookies()
const http = getCurrentInstance().appContext.config.globalProperties.$http
const router = useRouter()

let admin = reactive({
  username: '',
  password: ''
})

function login() {
  const resultSet = async () => {
    const result = await http.post('fantang/webstore/api/admin/login', {
      username: admin.username,
      password: admin.password
    })
    if (result.data.message === 'success') {
      await cookies.set('authorization', result.headers.authorization, '7d')
      setCurrentToastComponent('success', 'successfully landing system!')
      router.push('/')
    } else {
      setCurrentToastComponent('fail', 'an error occurred: ' + result.data.message)
    }
  }
  resultSet()
}
</script>

<style>
.login section {
  @apply text-4xl
}

.login input {
  @apply bg-gray-800 ml-5 h-full border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}

.login button {
  @apply opacity-90 bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-60 text-center w-full focus:outline-none
}

.modal {
  overflow: auto;
}

.modal .body {
  @apply w-900 font-extrabold text-2xl
}
</style>