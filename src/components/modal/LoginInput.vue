<template>
  <div class="form p-10 lg:col-span-2">
    <div>
      <input autocomplete="off" pattern="^[A-Za-z0-9_]{1,16}$" spellcheck="false" maxlength="16" v-model = "username" class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
      <button type="submit" @click="login" class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center w-full focus:outline-none">
        Continue to Store
      </button>
    </div>

  </div>
</template>

<script>

export default {
  name: "LoginInput",
}
</script>

<script setup>
import {getCurrentInstance, ref} from "vue";
import pubsub from "pubsub-js";
import {useRouter} from "vue-router";

let username = ref('')

let store = getCurrentInstance().appContext.config.globalProperties.$store
let http = getCurrentInstance().appContext.config.globalProperties.$http
let router = useRouter();

async function login() {
  if (username.value.length === 0) {
    return false;
  }
  const {
    data: result
  } = await http.get(`mojang/users/profiles/minecraft/${username.value}`)
  if (result === '' || result.isEmpty) {
    alert('cnm')
  } else {
    debugger
    if (result.name === store.state.user.ign) {
      pubsub.publish('changeLoginCondition')
      return false
    }
    store.commit('logOut', '')
    store.commit('login',result)
    router.push('/')
    pubsub.publish('changeLoginCondition')
  }
}
</script>