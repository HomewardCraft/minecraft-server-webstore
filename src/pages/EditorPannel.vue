<template>
  <div v-if="false"
      class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out opacity-100 pointer-events-auto">
    <div class="transition-transform duration-200 ease-in-out transform">
      <div class="title flex items-center justify-between mb-6">
        <login-title/>
      </div>
      <div class="body bg-gray-900 grid lg:grid-cols-3 items-center">
        <login-avatar/>
        <div class="form p-10 lg:col-span-2">
          <div>
            <input autocomplete="off" pattern="^[A-Za-z0-9_]{1,16}$" spellcheck="false" maxlength="16"
                   placeholder="Administration Account"
                   class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
            <input autocomplete="off" pattern="^[A-Za-z0-9_]{1,16}$" spellcheck="false" maxlength="16"
                   placeholder="Administration Password"
                   class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
            <button type="submit" @click="login"
                    class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center w-full focus:outline-none">
              继续登录校验
            </button>
          </div>

        </div>
        <login-help/>
      </div>
    </div>
  </div>
</template>

<script setup>
import LoginTitle from "../components/ComponentsLogin/LoginTitle.vue";
import LoginAvatar from "../components/ComponentsLogin/LoginAvatar.vue";
import LoginHelp from "../components/ComponentsLogin/LoginHelp.vue";
</script>

<script>
export default {
  name: "EditorPannel"
}
</script>

<style scoped>
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
  padding: 40px 0 0;
  overflow: auto;
}

.modal .body {
  max-width: 700px;
  margin-bottom: 40px;
}
</style>