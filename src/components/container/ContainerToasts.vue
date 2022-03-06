<template>
  <div class="toasts fixed left-0 bottom-0 z-50 leading-loose grid gap-5 m-6">
    <transition name="slide">
      <keep-alive>
        <component :is="currentComponent.componentName" :item="currentComponent.item"/>
      </keep-alive>
    </transition>
  </div>
</template>

<script>
import ToastIdle from "./toast/ToastIdle.vue";
import AddCartMessage from "./toast/AddCartMessage.vue";
import RemoveCartMessage from "./toast/RemoveCartMessage.vue";
import IncreaseItemMessage from "./toast/IncreaseItemMessage.vue";
import DecreaseItemMessage from "./toast/DecreaseItemMessage.vue";
export default {
  name: "ContainerToasts",
  components: {ToastIdle, AddCartMessage, RemoveCartMessage, IncreaseItemMessage, DecreaseItemMessage}
}
</script>

<script setup>
import {reactive} from "vue";
import pubsub from "pubsub-js";

let currentComponent = reactive({
  componentName: 'ToastIdle',
  item: {
    name: ''
  }
})

let timer

function setCurrentComponent(_, data) {
  clearTimeout(timer)
  timer = setTimeout(() => {
    currentComponent.item.name = data.itemMeta.name
    currentComponent.componentName = data.componentName
    setTimeout(() => {
      currentComponent.componentName = 'ToastIdle'
    }, 2000);
  }, 300)
}
pubsub.subscribe('setCurrentToastComponent', setCurrentComponent)
</script>