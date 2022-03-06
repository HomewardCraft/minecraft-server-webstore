<template>
  <div class="main">
    <section id="accounts" class="mb-10"><h4 class="font-bold text-white text-xl mb-6">Confirm Minecraft Account</h4>
      <div class="account lg:w-4/5 flex items-center">
        <div @click="logOut"
            class="avatar h-32 w-32 relative bg-gray-800 border border-lighten bg-bottom bg-no-repeat"
             :style="{backgroundSize: '80%', backgroundImage: 'url(' + url + uuid + ')'}"
        >
          <div
              @click="logOut"
              class="button flex items-center justify-center absolute inset-0 top-auto text-center cursor-pointer pb-2 pt-8 text-orange-300 font-bold opacity-100 transition-colors duration-150 ease-in-out hover:text-white">
            <span class="text-white">Change</span>
            <svg class="w-5 h-5 ml-2" fill="white" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="text flex-1 ml-8">
          <h3 class="font-bold text-white text-xl mb-2">{{ username }}</h3>
          <p class="text-gray-500 text-sm"> The items you purchase today are non transferable, non-refundable, and
            will be added to the account <b class="text-white">{{ username }}</b>. Please ensure you have space in your
            inventory before purchasing.</p></div>
      </div>
    </section>
    <section id="details" class="lg:w-2/3 mb-10">
      <div>
        <div
            class="font-bold text-white text-xl mb-6 relative flex items-center justify-between cursor-pointer group">
          <span>Email Address</span>
          <svg class="w-4 h-4 opacity-75" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd"
                  d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-8-3a1 1 0 00-.867.5 1 1 0 11-1.731-1A3 3 0 0113 8a3.001 3.001 0 01-2 2.83V11a1 1 0 11-2 0v-1a1 1 0 011-1 1 1 0 100-2zm0 8a1 1 0 100-2 1 1 0 000 2z"
                  clip-rule="evenodd"></path>
          </svg>
          <div
              class="popup absolute top-0 right-0 mt-8 text-gray-500 bg-black-80 rounded-lg text-sm font-normal max-w-md py-1 px-2 text-right pointer-events-none opacity-0 transition-opacity duration-150 ease-in-out group-hover:opacity-100">
            Your email will only be used to send payment confirmations and other important information. You will never
            be spammed or sent junk mail by Origin Realms.
          </div>
        </div>
        <div class="form-row"><label for="email" class="sr-only">Email Address</label>
          <input name="email" id="email" v-model="Email" ref="email"
                 type="email"
                 class="appearance-none bg-gray-800 border border-lighten font-bold text-lg block w-full py-3 px-5 transition-colors duration-150 ease-in-out focus:outline-none focus:border-piston"
                 placeholder="example@arcanetravel.com">
        </div>
      </div>
    </section>
    <section id="method" class="lg:w-4/5"><h4 class="font-bold text-white text-xl mb-6">Payment Method</h4>
      <div class="gateways"><label
          class="gateway flex items-center relative border border-lighten py-4 px-6 mb-4 transition-opacity duration-150 ease-in-out cursor-pointer opacity-75 opacity-100"
          data-gateway="PayPal"><input type="radio" id="gateway-600346" name="gateway" class="absolute opacity-0"
                                       value="600346"><span
          class="dot block rounded-full border-2 border-lighten mr-4 opacity-25 transition-opacity duration-150 ease-in-out"><span
          class="inner block m-1 h-2 w-2 bg-white rounded-full"></span></span><span class="logo block"><img
          src="https://cdn.tebex.io/store/845008/templates/75753/assets/db15f53773b3bcf37891eb0d011b239df91790bc.png"
          alt="PayPal"></span><span class="cards block"></span></label></div>
    </section>
  </div>
</template>

<script setup>
import {customRef, reactive, ref} from "vue";
import {getCurrentInstance} from "vue";
import {watch} from "vue";
import {useRouter} from "vue-router";

let GLOBAL_DATA = reactive(getCurrentInstance().appContext.config.globalProperties.$store)
let router = useRouter()
let username = ref(GLOBAL_DATA.state.user.ign)
let uuid = ref(GLOBAL_DATA.state.user.uuid)
let url = ref('https://visage.surgeplay.com/bust/128/')

function delayRef(value, delay) {
  let timer
  return customRef((track, trigger) => {
    return {
      get() {
        track()
        return value
      },
      set(newValue) {
        clearTimeout(timer)
        timer = setTimeout(() => {
          value = newValue
          trigger()
        }, delay)
      },
    }
  })
}

let Email = delayRef(GLOBAL_DATA.state.fields.email_add, 1000)

function logOut() {
  router.push('/')
  GLOBAL_DATA.commit('logOut', 'logout')
  }

function check(value) {
  var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式

  if (value === "") { //输入不能为空
    console.log("(!) 错误格式")
    return false;
  } else if (!reg.test(value)) { //正则验证不通过，格式不对
    console.log("(!) 错误格式")
    return false;
  } else {
    console.log("(+) 通过")
    GLOBAL_DATA.state.fields.email = true
    return true;
  }
}

watch(() => GLOBAL_DATA.state.fields, (newValue, oldValue) => {
  console.log("fields更新了")

}, {deep: true})

watch(Email, (newValue, oldValue) => {
  console.log('Email', newValue, oldValue)
  check(Email.value)
}, {immediate: true})

</script>

<script>
export default {
  name: "checkoutmain"
}
</script>

<style scoped>
.checkout .avatar .button {
  background: linear-gradient(to top, #181a1b, rgba(24, 26, 27, 0));
}
</style>