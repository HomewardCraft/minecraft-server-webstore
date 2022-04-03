<template>
  <footer class="page-footer bg-yellow-400">
    <div class="top bg-yellow-500">
      <div class="container mx-auto">
        <div class="md:ml-27.5 py-3 px-6 md:flex md:items-center md:justify-between">
          <div @click="copyIp" data-clipboard-text="play.fantang.cc" class="server-wrap server-minecraft flex relative font-bold text-sm uppercase justify-center lg:items-stretch transition-opacity duration-150 ease-in-out hover:opacity-80 text-ip-1000 cursor-pointer">
            <div class="server bg-yellow-600 tracking-widest py-2 px-3">play.fantang.cc</div>
            <div class="flex items-center px-3 tracking-wide bg-yellow-600 opacity-80">271</div>
            <transition name="tooltip">
              <div v-show="ipStyle" class="tooltip absolute left-0.5 -bottom-0.5 text-xs font-bold uppercase transition-opacity ease-in-out duration-200 text-ip-700">IP Copied!</div>
            </transition>
          </div>
          <div class="socials flex flex-wrap justify-center mt-4 md:mt-0 text-ip-900">
            <a href="https://baioretto.com" class="block p-3 transition transition-opacity duration-150 ease-in-out hover:opacity-75">
              <svg fill="currentColor" viewBox="0 0 245 240" class="w-5 h-5">
                <path d="M214.5,54.1c-30.1-22.6-58.8-22-58.8-22l-2.9,3.3c35.5,10.9,52.1,26.6,52.1,26.6c-21.7-11.9-43.1-17.8-62.9-20.1c-15.1-1.7-29.5-1.3-42.2,0.4c-1.3,0-2.3,0.2-3.6,0.4c-7.3,0.6-25.1,3.3-47.5,13.2c-7.7,3.6-12.3,6.1-12.3,6.1s17.4-16.5,55-27.4l-2.1-2.5c0,0-28.6-0.6-58.8,22c0,0-30.1,54.6-30.1,121.9c0,0,17.6,30.3,63.8,31.8c0,0,7.7-9.4,14-17.4c-26.6-7.9-36.6-24.7-36.6-24.7s2.1,1.5,5.9,3.6c0.2,0.2,0.4,0.4,0.8,0.6c0.6,0.4,1.3,0.6,1.9,1c5.2,2.9,10.5,5.2,15.3,7.1c8.6,3.3,18.8,6.7,30.7,9c15.7,2.9,34.1,4,54.2,0.2c9.8-1.7,19.9-4.6,30.3-9c7.3-2.7,15.5-6.7,24-12.3c0,0-10.5,17.1-37.8,24.9c6.3,7.9,13.8,16.9,13.8,16.9c46.2-1.5,64-31.8,64-31.8C244.6,108.7,214.5,54.1,214.5,54.1z M83.3,157c-11.7,0-21.4-10.5-21.4-23.3c0-12.8,9.4-23.3,21.4-23.3c12,0,21.6,10.5,21.4,23.3C104.7,146.5,95.2,157,83.3,157z M159.8,157c-11.7,0-21.4-10.5-21.4-23.3c0-12.8,9.4-23.3,21.4-23.3c12,0,21.4,10.5,21.4,23.3C181.2,146.5,171.8,157,159.8,157z"/>
              </svg>
            </a>
            <a href="https://twitter.com/ZeroTwo08100166" class="block p-3 transition transition-opacity duration-150 ease-in-out hover:opacity-75">
              <svg viewBox="0 0 512 512" fill="currentColor" class="w-5 h-5">
                <path d="M459.37 151.716c.325 4.548.325 9.097.325 13.645 0 138.72-105.583 298.558-298.558 298.558-59.452 0-114.68-17.219-161.137-47.106 8.447.974 16.568 1.299 25.34 1.299 49.055 0 94.213-16.568 130.274-44.832-46.132-.975-84.792-31.188-98.112-72.772 6.498.974 12.995 1.624 19.818 1.624 9.421 0 18.843-1.3 27.614-3.573-48.081-9.747-84.143-51.98-84.143-102.985v-1.299c13.969 7.797 30.214 12.67 47.431 13.319-28.264-18.843-46.781-51.005-46.781-87.391 0-19.492 5.197-37.36 14.294-52.954 51.655 63.675 129.3 105.258 216.365 109.807-1.624-7.797-2.599-15.918-2.599-24.04 0-57.828 46.782-104.934 104.934-104.934 30.213 0 57.502 12.67 76.67 33.137 23.715-4.548 46.456-13.32 66.599-25.34-7.798 24.366-24.366 44.833-46.132 57.827 21.117-2.273 41.584-8.122 60.426-16.243-14.292 20.791-32.161 39.308-52.628 54.253z"/>
              </svg>
            </a>
            <a href="https://www.instagram.com/baioretto_w/" class="block p-3 transition transition-opacity duration-150 ease-in-out hover:opacity-75">
              <svg aria-hidden="true" viewBox="0 0 448 512" fill="currentColor" class="w-5 h-5">
                <path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z"/>
              </svg>
            </a>
            <a href="https://www.youtube.com/channel/UC_Gaj5YRUTnJ6aqrX5KEAIA" class="block p-3 transition transition-opacity duration-150 ease-in-out hover:opacity-75">
              <svg aria-hidden="true" viewBox="0 0 576 512" fill="currentColor" class="w-5 h-5">
                <path d="M549.655 124.083c-6.281-23.65-24.787-42.276-48.284-48.597C458.781 64 288 64 288 64S117.22 64 74.629 75.486c-23.497 6.322-42.003 24.947-48.284 48.597-11.412 42.867-11.412 132.305-11.412 132.305s0 89.438 11.412 132.305c6.281 23.65 24.787 41.5 48.284 47.821C117.22 448 288 448 288 448s170.78 0 213.371-11.486c23.497-6.321 42.003-24.171 48.284-47.821 11.412-42.867 11.412-132.305 11.412-132.305s0-89.438-11.412-132.305zm-317.51 213.508V175.185l142.739 81.205-142.739 81.201z"/>
              </svg>
            </a>
            <a href="https://www.reddit.com/user/Ba1oretto" class="block p-3 transition transition-opacity duration-150 ease-in-out hover:opacity-75">
            <svg aria-hidden="true" fill="currentColor" viewBox="0 0 512 512" class="w-5 h-5">
              <path d="M440.3 203.5c-15 0-28.2 6.2-37.9 15.9-35.7-24.7-83.8-40.6-137.1-42.3L293 52.3l88.2 19.8c0 21.6 17.6 39.2 39.2 39.2 22 0 39.7-18.1 39.7-39.7s-17.6-39.7-39.7-39.7c-15.4 0-28.7 9.3-35.3 22l-97.4-21.6c-4.9-1.3-9.7 2.2-11 7.1L246.3 177c-52.9 2.2-100.5 18.1-136.3 42.8-9.7-10.1-23.4-16.3-38.4-16.3-55.6 0-73.8 74.6-22.9 100.1-1.8 7.9-2.6 16.3-2.6 24.7 0 83.8 94.4 151.7 210.3 151.7 116.4 0 210.8-67.9 210.8-151.7 0-8.4-.9-17.2-3.1-25.1 49.9-25.6 31.5-99.7-23.8-99.7zM129.4 308.9c0-22 17.6-39.7 39.7-39.7 21.6 0 39.2 17.6 39.2 39.7 0 21.6-17.6 39.2-39.2 39.2-22 .1-39.7-17.6-39.7-39.2zm214.3 93.5c-36.4 36.4-139.1 36.4-175.5 0-4-3.5-4-9.7 0-13.7 3.5-3.5 9.7-3.5 13.2 0 27.8 28.5 120 29 149 0 3.5-3.5 9.7-3.5 13.2 0 4.1 4 4.1 10.2.1 13.7zm-.8-54.2c-21.6 0-39.2-17.6-39.2-39.2 0-22 17.6-39.7 39.2-39.7 22 0 39.7 17.6 39.7 39.7-.1 21.5-17.7 39.2-39.7 39.2z"/>
            </svg>
            </a>
          </div>
        </div>
      </div>
    </div>
    <div class="container mx-auto flex flex-col md:flex-row md:items-center p-6">
      <a href="https://ba1oretto.com" class="hidden md:block piston mr-6">
        <div class="head">
          <div class="top"/>
          <div class="neck"/>
        </div>
        <div class="base"/>
      </a>
      <div class="text">
        <div class="text-black opacity-80 leading-tight">Origin Realms, A Piston Solutions product.</div>
        <div class="text-yellow-900 leading-tight">We are in no way affiliated with or endorsed by Mojang, AB.</div>
      </div>
    </div>
  </footer>
</template>

<script setup>
import {ref} from "vue";
import {debounce} from "lodash";
import {copy} from "../hook/clipboard.js";

const ipStyle = ref(false)

const copyIp = () => {
  changeIpStyle()
}

const privateBounce = debounce(() => {
  ipStyle.value = false
}, 2500)

const changeIpStyle = () => {
  ipStyle.value = true
  copy('.server-wrap')
  privateBounce()
}
</script>

<script>
export default {
  name: "PageFooter"
}
</script>