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
export default {
  name: "ContainerToasts",
  components: {AddCartMessage}
}
</script>

<script setup>
import {reactive, ref} from "vue";
import pubsub from "pubsub-js";

let currentComponent = reactive({
  componentName: 'ToastIdle',
  item: {
    name: ''
  }
})

function setCurrentComponent(_, data) {
  currentComponent.item.name = data.itemMeta.name
  currentComponent.componentName = data.componentName
  setTimeout(() => {
    currentComponent.componentName = 'ToastIdle'
  }, 5000)
}
pubsub.subscribe('setCurrentToastComponent', setCurrentComponent)
</script>

<style scoped>
.toasts {
  max-width: 400px;
  width: 100%;
}
</style>