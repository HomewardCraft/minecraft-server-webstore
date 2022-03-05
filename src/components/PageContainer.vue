<template>
  <div class="page-container">
    <background-image @click="closeAll"/>
    <container-body @click="closeAll"/>
    <container-toasts @click="closeAll"/>
    <container-side-bar/>
  </div>
</template>

<script setup>
import {getCurrentInstance} from "vue";

let bus = getCurrentInstance().appContext.config.globalProperties.$bus

function closeAll() {
  bus.emit('updateSideBarState', 'manipulate')
}

</script>

<script>
import BackgroundImage from "./container/BackgroundImage.vue";
import ContainerBody from "./container/ContainerBody.vue";
import ContainerToasts from "./container/ContainerToasts.vue";
import ContainerSideBar from "./container/ContainerSideBar.vue";

export default {
  name: "PageContainer",
  components: {ContainerSideBar, ContainerToasts, ContainerBody, BackgroundImage}
}
</script>