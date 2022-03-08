<template>
  <div class="main">
    <section id="accounts" class="mb-10">

      <div class="account lg:w-5/5 flex items-center">
        <div @click="logOut"
             class="avatar h-56 w-56 relative bg-gray-800 border border-lighten bg-bottom bg-no-repeat"
             :style="{backgroundSize: '80%', backgroundImage: 'url(' + url + uuid + ')'}">
          <div
              @click="logOut"
              class="button flex items-center justify-center absolute inset-0 top-auto text-center cursor-pointer pb-2 pt-8 text-orange-300 font-bold opacity-100 transition-colors duration-150 ease-in-out hover:text-white">
            <span class="text-white">更换图片</span>
            <svg class="w-5 h-5 ml-2" fill="white" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="text flex-1 ml-8">
          <h3 class="font-bold text-white mb-2">物品名称</h3>
          <input maxlength="16"  placeholder="物品的唯一名称" class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
          <h3 class="font-bold text-white mb-2">物品编号</h3>
          <input maxlength="16" placeholder="物品的数据库唯一编号" class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none"/>
<!--          <p class="text-gray-500 text-sm">物品编号</p>-->
        </div>
      </div>
    </section>

  </div>
</template>

<script setup>


</script>

<script>
export default {
  name: "editormain"
}
</script>

<style scoped>
.checkout .avatar .button {
  background: linear-gradient(to top, #181a1b, rgba(24, 26, 27, 0));
}

.invalid {
  --tw-bg-opacity: 1;
  border-color: rgb(239 68 68 / var(--tw-bg-opacity));
}
</style>