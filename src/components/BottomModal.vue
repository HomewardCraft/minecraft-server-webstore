<template>
  <div @click.self = "close"
      class="modal fixed bg-black-80 inset-0 grid items-center justify-center transition-opacity duration-300 ease-in-out"
      :class="styles.outer">
    <div class="transition-transform duration-200 ease-in-out transform" :class="styles.inner">
      <div class="title flex items-center justify-between mb-6">
        <login-title/>
      </div>
      <div class="body bg-gray-900 grid lg:grid-cols-3 items-center">
        <login-avatar/>
        <login-input/>
        <login-help/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {getCurrentInstance} from "vue";
import {reactive} from "vue";
import {onMounted} from "vue";

const {proxy, ctx} = getCurrentInstance()

let ispannelopen = false

let styles = reactive({
  outer: 'opacity-0 pointer-events-none',
  inner: 'scale-75'
})

function open() {
  styles.outer = 'opacity-100 pointer-events-auto'
  styles.inner = ''
}

function close() {
  styles.outer = 'opacity-0 pointer-events-none'
  styles.inner = 'scale-75'
}


onMounted(() => {
  getCurrentInstance().appContext.config.globalProperties.$bus.on
  //判断发送的指令，如果是open就开，close就关闭
  ('loginpannelmanipulate', (command) => {
    if (command === 'open') {
      open()
    } else {
      close();
    }

  })
})


</script>

<script>
import LoginAvatar from "./modal/LoginAvatar.vue";
import LoginTitle from "./modal/LoginTitle.vue";
import LoginInput from "./modal/LoginInput.vue";
import LoginHelp from "./modal/LoginHelp.vue";

export default {
  name: "BottomModal",
  components: {LoginHelp, LoginInput, LoginTitle, LoginAvatar}
}
</script>

<style scoped>
.modal {
  padding: 40px 0 0;
  overflow: auto;
}

.modal .body {
  max-width: 700px;
  margin-bottom: 40px;
}
</style>