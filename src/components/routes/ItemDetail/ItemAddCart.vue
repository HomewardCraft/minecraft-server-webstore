<template>
  <div v-show="!logged_in">
    <div class="bg-gray-900 border border-lighten py-4 px-5 text-center mt-4 text-gray-500 font-bold">
      <svg class="w-12 h-12 opacity-50 mx-auto mb-2" viewBox="0 0 640 512" fill="currentColor">
        <path
            d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"></path>
      </svg>
      <div class="lg text-lg leading-tight pb-3">Enter username to purchase</div>
      <div class="sm opacity-75">You need to enter your Minecraft username before you can purchase this item!</div>
    </div>
    <button @click="showLoginPannel"
            class="flex loginbn justify-center w-full text-gray-500 items-center bg-btn text-btn-text border border-lighten py-4 uppercase font-extrabold tracking-wide transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90': cooldown }">
      <svg class="w-6 h-6 opacity-75 mr-2" viewBox="0 0 640 512" fill="#96428e">
        <path
            d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"></path>
      </svg>
      <span class="username">Enter Username</span></button>
  </div>
<!--  没有登录就显示上面的样式-->
  <button
      v-show="logged_in"
      class="flex justify-center items-center w-full px-6 bg-btn border border-lighten py-4 shadow-btn uppercase font-extrabold tracking-wide text-btn-text transition-all transform duration-150 ease-in-out hover:opacity-75 focus:outline-none focus:scale-90"
      data-exception="">
    <svg class="w-8 h-8 mr-2 opacity-75" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
      <path
          d="M3 1a1 1 0 000 2h1.22l.305 1.222a.997.997 0 00.01.042l1.358 5.43-.893.892C3.74 11.846 4.632 14 6.414 14H15a1 1 0 000-2H6.414l1-1H14a1 1 0 00.894-.553l3-6A1 1 0 0017 3H6.28l-.31-1.243A1 1 0 005 1H3zM16 16.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM6.5 18a1.5 1.5 0 100-3 1.5 1.5 0 000 3z"></path>
    </svg>
    <span>添加到购物车!</span>
  </button>
</template>

<script>
import {getCurrentInstance, ref, toRef} from "vue";

export default {
  name: "ItemAddCart",
  setup() {


    let ctx = getCurrentInstance()

    function showLoginPannel() {

      ctx.appContext.config.globalProperties.$bus.emit('loginpannelmanipulate', 'open')

    }


    let logged_in = toRef(ctx.appContext.config.globalProperties.$store.state.user, 'logged_in')

    return {
      showLoginPannel,
      logged_in
    }
  }
}
</script>


<style scoped>

/*图标背景颜色*/
.loginbn {
  background-color: #fdafe0;
}

/*字体颜色（按钮）*/

.username {
  color: #96428e;
}
</style>