<template>
  <div class="flex items-center font-bold text-lg bg-custom-1200 pt-5 px-6">
    <img src="https://assets.originrealms.com/static/store/user.png" alt="default" class="max-h-16"/>
    <div class="ml-5">
      <div class="username label text-2xl tracking-widest leading-none text-gray-50/90">{{ username }}</div>
      <div class="text-gray-500">管理员身份</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserContent"
}
</script>

<script setup>
import {ref} from "vue";
import {useCookies} from "vue3-cookies";

const {cookies} = useCookies()

let username = ref('')

function getUsername() {
  let name = cookies.get('username')
  username.value = name
}

getUsername()
</script>
