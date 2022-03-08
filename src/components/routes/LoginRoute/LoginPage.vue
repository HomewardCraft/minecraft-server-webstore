<template>
  <div class="flex items-center justify-center">
    <div class="login text-gray-500 bg-github-darkgray font-extrabold p-10 select-none">
      <section>
        <span>账号: </span>
        <input v-model="admin.username">
      </section>
      <section class="mt-10">
        <span>密码: </span>
        <input type="password" v-model="admin.password">
      </section>
      <button class="mt-10" @click="login">登录</button>
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

const {cookies} = useCookies()
const http = getCurrentInstance().appContext.config.globalProperties.$http
const router = useRouter()

let admin = reactive({
  username: '',
  password: ''
})

function login() {
  const resultSet = async () => {
    // const result = await http.post('local/admin/login', {
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
</style>