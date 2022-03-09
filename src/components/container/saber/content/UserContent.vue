<template>
  <div class="flex items-center font-bold text-lg bg-custom-1200 pt-5 px-6">
    <img src="https://assets.originrealms.com/static/store/user.png" alt="default" class="max-h-16"/>
    <div class="ml-5">
      <div class="label text-xs uppercase tracking-widest leading-none text-gray-500">Managing As</div>
      <div class="username">{{ username }}</div>
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
import pubsub from "pubsub-js";
import {useCookies} from "vue3-cookies";

const {cookies} = useCookies();

let username = ref('')
let name = cookies.get('username');

function setUsername(_, name) {
  username.value = name
}
setUsername('', name)

pubsub.subscribe('setUsername', setUsername)
</script>
