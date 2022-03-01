<template>
  <div class="side-bar bg-gray-900 font-bold transition-all duration-500 ease-in-out z-40 outline-none" :class="active">
    <div class="side-bar-close absolute left-0 right-0 lg:right-auto lg:-ml-12 bg-red-600 border border-lighten lg:w-12 h-12 box-content flex items-center justify-center cursor-pointer transition-opacity duration-300 ease-in-out" :class="opacity" @click="closeBar">
      <svg viewBox="0 0 36 36" class="w-5 h-5" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <path d="M36.0002 5.00012L30.7462 -0.253906L17.8731 12.6191L5.00012 -0.253866L-0.253906 5.00016L12.6191 17.8732L-0.253784 30.7461L5.00024 36.0001L17.8731 23.1272L30.7461 36.0001L36.0001 30.7461L23.1272 17.8732L36.0002 5.00012Z"/>
      </svg>
      <span class="ml-3 lg:hidden">Close Sidebar</span>
    </div>
    <div class="popout">
      <sidebar-popout/>
    </div>
    <main-content/>
  </div>
</template>

<script>
import SidebarPopout from "./saber/SidebarPopout.vue";
import MainContent from "./saber/MainContent.vue";
export default {
  name: "ContainerSideBar",
  components: {MainContent, SidebarPopout}
}
</script>

<script setup>
import {ref} from "vue";

let opacity = ref('opacity-0')
let active = ref('')
// let isActive = false

function closeBar() {
  opacity.value = 'opacity-0'
  active.value = ''
}
</script>

<style scoped>
.side-bar {
  position: fixed;
  z-index: 9999999;
  top: 0;
  width: 100%;
  right: -100%;
  bottom: 0;
}

@screen sm {
  .side-bar {
    right: -380px;
    width: 380px;
  }
}

.side-bar.active {
  right: 0;
}

.side-bar .popout {
  position: fixed;
  transition: .3s ease-in-out all;
  opacity: 1;
  left: 0;
  right: 0;
  bottom: 0;
  display: grid;
  grid-template-columns: minmax(auto,33.3334%) minmax(auto,33.3334%) minmax(auto,33.3334%);
}

@screen lg {
  .side-bar .popout {
    display: flex;
    align-items: center;
    top: 100px;
    left: auto;
    right: 40px;
    bottom: auto;
    flex-direction: column;
  }
}
</style>