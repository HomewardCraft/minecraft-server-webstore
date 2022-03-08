<template>
  <div class="toasts fixed left-0 bottom-0 z-50 leading-loose grid gap-5 m-6 select-none">
    <transition name="slide">
      <toast-condition-enum v-if="slot.currentSlotName !== ''" :name="slot.currentSlotName">
        <template #[slot.currentSlotName]>
          <div :class="slot.color" class="toast inline-flex text-white font-bold border border-lighten rounded-lg py-3 px-6 shadow-xl text-shadow">
            {{slot.msg}}
          </div>
        </template>
      </toast-condition-enum>
    </transition>
  </div>
</template>

<script>
import ToastConditionEnum from "./toast/ToastConditionEnum.vue";
export default {
  name: "ContainerToasts",
  components: {ToastConditionEnum}
}
</script>

<script setup>
import {reactive, ref} from "vue";
import pubsub from "pubsub-js";

let slot = reactive({
  currentSlotName: '',
  msg: '',
  color: ''
})

let timer
function setCurrentComponent(_, data) {
  clearTimeout(timer)
  timer = setTimeout(() => {
    slot.currentSlotName = data.currentSlotName
    slot.msg = data.msg
    if (slot.currentSlotName === 'success') {
      slot.color = 'bg-green-700'
    } else {
      slot.color = 'bg-red-500'
    }
    setTimeout(() => {
      slot.currentSlotName = ''
    }, 3000);
  }, 300)
}
pubsub.subscribe('setCurrentToastComponent', setCurrentComponent)
</script>