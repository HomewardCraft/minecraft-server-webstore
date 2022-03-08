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

let username = ref('')

function setUsername(_, name) {
  username.value = name
}
pubsub.subscribe('setUsername', setUsername)
</script>
