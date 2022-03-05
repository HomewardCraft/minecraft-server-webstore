<template>
  <section id="confirm"><h4 class="font-bold text-white text-xl mb-6">Privacy &amp; Terms</h4>
    <div class="grid lg:grid-cols-2 gap-6">
      <!--没有同意的按钮Privacy-->
      <div v-show="!isPlayerAgreePrivacy"
           class="checkbox border border-light bg-gray-900 transition-opacity duration-200 ease-in-out">
        <div class="flex items-center justify-between p-5 pb-0 font-bold text-lg">
          <div class="cursor-pointer flex items-center"><span>Privacy Policy</span>
            <svg @click="openPrivacyWindow"
                 class="w-5 h-5 ml-2 opacity-50" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path
                  d="M11 3a1 1 0 100 2h2.586l-6.293 6.293a1 1 0 101.414 1.414L15 6.414V9a1 1 0 102 0V4a1 1 0 00-1-1h-5z"></path>
              <path d="M5 5a2 2 0 00-2 2v8a2 2 0 002 2h8a2 2 0 002-2v-3a1 1 0 10-2 0v3H5V7h3a1 1 0 000-2H5z"></path>
            </svg>
          </div>
          <div @click="agree('privacy')" class="tick rounded-lg p-2 bg-gray-800">
            <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="body p-5 pt-3 text-gray-500 opacity-75"><p class="text-sm">By ticking this box, you confirm you
          are over 16 years of age or have the permission of your guardian, and consent to our privacy policy</p>
        </div>
        <div
            class="button relative border border-lighten -m-px h-12 transition-opacity duration-200 ease-in-out hover:opacity-75 cursor-pointer bg-green-600">
            <span
                class="text-shadow block absolute inset-0 flex justify-center items-center font-bold uppercase transition-opacity duration-150 ease-in-out">I have read and I agree</span>
          <div
              @click="agree('privacy')"
              class="absolute inset-0 flex justify-center items-center transition-opacity duration-150 ease-in-out opacity-0">
            <svg class="w-5 h-5 text-gray-500" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
      <!--同意了的按钮Privacy-->
      <div v-show="isPlayerAgreePrivacy"
           class="checkbox border border-light bg-gray-900 transition-opacity duration-200 ease-in-out opacity-50">
        <div class="flex items-center justify-between p-5 pb-0 font-bold text-lg">
          <div class="cursor-pointer flex items-center"><span>Privacy Policy</span>
            <svg class="w-5 h-5 ml-2 opacity-50" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path
                  d="M11 3a1 1 0 100 2h2.586l-6.293 6.293a1 1 0 101.414 1.414L15 6.414V9a1 1 0 102 0V4a1 1 0 00-1-1h-5z"></path>
              <path d="M5 5a2 2 0 00-2 2v8a2 2 0 002 2h8a2 2 0 002-2v-3a1 1 0 10-2 0v3H5V7h3a1 1 0 000-2H5z"></path>
            </svg>
          </div>
          <div @click="agree('privacy')" class="tick rounded-lg p-2 bg-green-600">
            <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="body p-5 pt-3 text-gray-500 opacity-75"><p class="text-sm">By ticking this box, you confirm you are
          over 16 years of age or have the permission of your guardian, and consent to our privacy policy</p></div>
        <div
            class="button relative border border-lighten -m-px h-12 transition-opacity duration-200 ease-in-out hover:opacity-75 cursor-pointer bg-gray-800">
          <span
              class="text-shadow block absolute inset-0 flex justify-center items-center font-bold uppercase transition-opacity duration-150 ease-in-out opacity-0">I have read and I agree</span>
          <div @click="agree('privacy')"
               class="absolute inset-0 flex justify-center items-center transition-opacity duration-150 ease-in-out">
            <svg class="w-5 h-5 text-gray-500" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
      <!--没有同意的按钮Terms-->
      <div v-show="!isPlayerAgreeTerms"
           class="checkbox border border-light bg-gray-900 transition-opacity duration-200 ease-in-out">
        <div class="flex items-center justify-between p-5 pb-0 font-bold text-lg">
          <div class="cursor-pointer flex items-center"><span>Terms &amp; Conditions</span>
            <svg @click="openTermWindow"
                 class="w-5 h-5 ml-2 opacity-50" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path
                  d="M11 3a1 1 0 100 2h2.586l-6.293 6.293a1 1 0 101.414 1.414L15 6.414V9a1 1 0 102 0V4a1 1 0 00-1-1h-5z"></path>
              <path d="M5 5a2 2 0 00-2 2v8a2 2 0 002 2h8a2 2 0 002-2v-3a1 1 0 10-2 0v3H5V7h3a1 1 0 000-2H5z"></path>
            </svg>
          </div>
          <div @click="agree('terms')" class="tick rounded-lg p-2 bg-gray-800">
            <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="body p-5 pt-3 text-gray-500 opacity-75"><p class="text-sm">By ticking this box, you confirm you
          are over 16 years of age or have the permission of your guardian, and consent to our terms &amp;
          conditions</p></div>
        <div
            class="button relative border border-lighten -m-px h-12 transition-opacity duration-200 ease-in-out hover:opacity-75 cursor-pointer bg-green-600">
            <span
                class="text-shadow block absolute inset-0 flex justify-center items-center font-bold uppercase transition-opacity duration-150 ease-in-out">I have read and I agree</span>
          <div
              @click="agree('terms')"
              class="absolute inset-0 flex justify-center items-center transition-opacity duration-150 ease-in-out opacity-0">
            <svg class="w-5 h-5 text-gray-500" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
      <!--同意了的按钮Terms-->
      <div v-show="isPlayerAgreeTerms"
           class="checkbox border border-light bg-gray-900 transition-opacity duration-200 ease-in-out opacity-50">
        <div class="flex items-center justify-between p-5 pb-0 font-bold text-lg">
          <div class="cursor-pointer flex items-center"><span>Terms &amp; Conditions</span>
            <svg class="w-5 h-5 ml-2 opacity-50" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path
                  d="M11 3a1 1 0 100 2h2.586l-6.293 6.293a1 1 0 101.414 1.414L15 6.414V9a1 1 0 102 0V4a1 1 0 00-1-1h-5z"></path>
              <path d="M5 5a2 2 0 00-2 2v8a2 2 0 002 2h8a2 2 0 002-2v-3a1 1 0 10-2 0v3H5V7h3a1 1 0 000-2H5z"></path>
            </svg>
          </div>
          <div @click="agree('terms')" class="tick rounded-lg p-2 bg-green-600">
            <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
        <div class="body p-5 pt-3 text-gray-500 opacity-75"><p class="text-sm">By ticking this box, you confirm you are
          over 16 years of age or have the permission of your guardian, and consent to our terms &amp; conditions</p>
        </div>
        <div
            class="button relative border border-lighten -m-px h-12 transition-opacity duration-200 ease-in-out hover:opacity-75 cursor-pointer bg-gray-800">
          <span
              class="text-shadow block absolute inset-0 flex justify-center items-center font-bold uppercase transition-opacity duration-150 ease-in-out opacity-0">I have read and I agree</span>
          <div @click="agree('terms')"
               class="absolute inset-0 flex justify-center items-center transition-opacity duration-150 ease-in-out">
            <svg class="w-5 h-5 text-gray-500" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd"
                    d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                    clip-rule="evenodd"></path>
            </svg>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import {getCurrentInstance, onBeforeUpdate, onMounted, reactive} from "vue";
import {ref} from "vue";

let BUS = getCurrentInstance().appContext.config.globalProperties.$bus

const props = defineProps(['isPlayerAgreePrivacy', 'isPlayerAgreeTerms'])

let isPlayerAgreePrivacy = ref(false)
let isPlayerAgreeTerms = ref(false)

function openTermWindow() {
  BUS.emit('termManipulation')
}

function openPrivacyWindow() {
  BUS.emit('privacyManipulation')
}

function giveDataToPage() {
  BUS.emit('giveConfirmDataToPage', reactive({isPlayerAgreePrivacy, isPlayerAgreeTerms}))
}

function agree(type) {
  if (type === "privacy") {
    isPlayerAgreePrivacy.value = !isPlayerAgreePrivacy.value
  }
  if (type === "terms") {
    isPlayerAgreeTerms.value = !isPlayerAgreeTerms.value
  }
}

onMounted(() => {

})

onBeforeUpdate(() => {
  giveDataToPage()
})

</script>

<script>
export default {
  name: "checkoutconfirm"
}
</script>

<style scoped>

</style>