<template>
  <div @click.self="closebt()"
       class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out opacity-100 pointer-events-auto">
    <div class="transition-transform duration-200 ease-in-out transform">
      <div class="title flex items-center justify-between mb-6">
        <div class="font-bold text-2xl text-white">Please enter your username to continue</div>
        <svg viewBox="0 0 36 36" fill="white" @click="closebt()"
             class="w-4 h-4 box-content text-gray-500-400 cursor-pointer p-4 rounded-full bg-gray-800 shadow-lg transition-colors duration-150 ease-in-out text-red-400"
        >
          <path
              d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z"
          >

          </path>
        </svg>
      </div>
      <!--不要删除此行data-v 删了就失去样式-->
      <div class="body bg-gray-900 grid lg:grid-cols-3 items-center">
        <div class="render bg-yellow-400 p-6 pb-0">
          <img src="https://assets.originrealms.com/static/store/user.png" class="max-w-full mx-auto">
        </div>
        <div class="form p-10 lg:col-span-2"><!---->
          <form>
            <input
                class="bg-gray-800 text-white block py-2 px-4 w-fix mb-5 border border-light text-center transition-colors duration-150 ease-in-out border-yellow-400 outline-none"
                autocomplete="off" pattern="^[A-Za-z0-9_]{1,16}$" spellcheck="false" maxlength="16">
            <button
                class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out opacity-75 text-center w-full focus:outline-none"
                type="submit" name="submit">Continue to Store
            </button>
          </form>
        </div>
        <div class="lg:col-span-3 p-8 bg-gray-800">
          <div class="font-bold text-xl mb-4 text-white">What is my Minecraft username?</div>
          <p class="text-gray-500 text-sm mb-3">
            Your username is the name you appear as on a
            Minecraft
            server. If you don’t know what your username is, then please refer to the Minecraft launcher. Towards the
            top
            corner it will say your Minecraft name. For example, the bottom of our Minecraft launcher shows “Herobrine”.
            Remember, usernames cannot contain spaces.
          </p>
          <img src="https://i.grphcrtv.com/WW-s8hLU6d5sL.png">
        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: "LoginUtil",
  data() {
    return {}
  },
  methods: {
    closebt() {
      console.log("销毁")
      this.$bus.$emit('closeloginpannel', false)
    }

  }
}
</script>

<style scoped>

@import "./../../assets/css/loginutil.css";


</style>