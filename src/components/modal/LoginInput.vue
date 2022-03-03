<template>
  <div class="form p-10 lg:col-span-2">
    <div>
      <input
          class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"
          autocomplete="off" pattern="^[A-Za-z0-9_]{1,16}$" spellcheck="false" maxlength="16" v-model = "username"/>
      <button
          class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center w-full focus:outline-none"
           type = "submit" @click = "login">Continue to Store
      </button>
    </div>

  </div>
</template>

<script>

export default {
  name: "LoginInput",
  mounted() {

  }
}
</script>

<script setup>


import { useCookies } from "vue3-cookies";
import {getCurrentInstance, ref} from "vue";

let username = ref('')
const { cookies } = useCookies();

let ctx = getCurrentInstance()
let web = getCurrentInstance().appContext.config.globalProperties.$http

function closepannel(){
  ctx.appContext.config.globalProperties.$bus.emit('loginpannelmanipulate', 'close')
}

async function login() {




  if (username.length == 0) {
    return false;
  }

  const {
    data: result
  } = await web.get(`mojang/users/profiles/minecraft/${username.value}`)

  if (result.error) {
    alert(result.errorMessage)
  } else {
    ctx.appContext.config.globalProperties.$store.commit('login',result)
    console.log(cookies.get("user_session"))
    console.log(ctx.appContext.config.globalProperties.$store.state.user)
    closepannel()
  }



}
</script>
<style scoped>
</style>