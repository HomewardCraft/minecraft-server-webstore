<template>
  <div class="hero mb-56">
    <div data-page="home" class="page-bg"/>
    <nav class="nav mb-2 z-40 mt-5">
      <div class="container mx-auto">
        <div class="mobile-toggle ml-auto block md:hidden p-8">
          <div class="bar"/>
          <div class="bar"/>
          <div class="bar"/>
        </div>
        <div class="menu-collapse flex md:items-center flex-col md:flex-row md:justify-center">
          <ul class="md:flex md:justify-center md:items-center md:mb-3 md:-mx-3 uppercase font-bold tracking-widest text-lg text-shadow">
            <li class="mx-3 mb-3 md:mb-0">
              <a href="/" class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-home hover:border-lighten bg-nav-home border-lighten">
                <span class="block">Home</span>
              </a>
            </li>
            <li class="mx-3 mb-3 md:mb-0">
              <a href="/blog" class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-blog hover:border-lighten">
                <span class="block">Blog</span>
              </a>
            </li>
            <li class="mx-3 mb-3 md:mb-0">
              <a href="/rules" class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-help hover:border-lighten">
                <span class="block">Rules</span>
              </a>
            </li>
            <li class="mx-3 mb-3 md:mb-0">
              <a href="https://baioretto.com" class="flex items-center px-5 py-3 md:py-1 transition duration-200 bg-red-600/80 text-white hover:bg-red-500 border border-lighten">Store</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="logo mx-auto mt-32">
      <div class="img"/>
    </div>
    <div @click="copyIp" data-clipboard-text="play.fantang.cc" class="cursor-pointer group inline-block mx-auto">
      <div class="server mx-auto mt-8 font-bold text-sm uppercase flex flex-col justify-center items-center lg:items-stretch lg:flex-row transition-opacity duration-150 ease-in-out group-hover:opacity-75">
        <div class="server bg-ip-900 tracking-widest py-2 px-3 border border-lighten shadow-ip">play.fantang.cc</div>
        <div class="flex items-center ml-auto px-3 tracking-wide bg-ip-800 text-ip-400 -ml-px border shadow-ip-count border-lighten text-sm">169</div>
      </div>
      <div class="tooltips font-extrabold text-sm text-center tracking-widest uppercase mt-4 text-white relative text-shadow-md">
        <transition name="tooltip" mode="out-in">
          <p v-if="ipStyle">Click to Copy</p>
          <p v-else-if="!ipStyle">Copied to Clipboard</p>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeHero"
}
</script>

<script setup>
import {ref} from "vue";
import {debounce} from "lodash";
import {copy} from "../../../hook/clipboard.js";

const ipStyle = ref(true)

const copyIp = () => {
  changeIpStyle()
}

const privateBounce = debounce(() => {
  ipStyle.value = true
}, 5000)

const changeIpStyle = () => {
  ipStyle.value = false
  copy('.cursor-pointer.group.inline-block.mx-auto')
  privateBounce()
}
</script>