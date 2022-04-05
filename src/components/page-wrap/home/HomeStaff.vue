<template>
  <div id="staff">
    <div class="bg-gray-900" @mouseenter="cancelInterval" @mouseleave="startInterval">
      <div class="container mx-auto relative z-10">
        <div class="staff">
          <div class="pt-10 lg:hidden">
            <h3 class="text-white text-3xl font-bold">Meet The Team</h3>
            <h5 class="text-gray-500">Learn about the people who make Origin Realms amazing!</h5>
          </div>
          <div class="staff-members">
            <div class="member flex flex-col-reverse lg:grid lg:grid-cols-staff gap-4">
              <div class="info-wrap">
                <div class="pt-10 hidden lg:block">
                  <h3 class="text-white text-3xl font-bold">Meet The Team</h3>
                  <h5 class="text-gray-500">Learn about the people who make Origin Realms amazing!</h5>
                </div>
                <!-- todo -->
                <div class="bio-wrap relative">
                  <div v-show="contributor.test1.enable" data-name="test1" class="info py-5">
                    <div class="name flex items-center text-pink-600 font-bold uppercase text-lg mb-1">test1 - Model Artist</div>
                    <div class="bio text-gray-500">It is I, Samuel! Origin Realms offers loads of custom content, but making brand new items feel as if they belong in the game is no easy task! All of the models and characters you see in game were created by me, as well as their animations. I take pride in ensuring everything I do is the best quality down to the very last detail so that you, the player, have the most fun!</div>
                  </div>
                  <div v-show="contributor.test2.enable" data-name="test2" class="info py-5">
                    <div class="name flex items-center text-pink-600 font-bold uppercase text-lg mb-1">test2 - Branding Artist</div>
                    <div class="bio text-gray-500">The name is Wytze, and I’m the man behind all of the renders and imagery you see on our social media and this website! Creating a consistent style for these art pieces is incredibly important, I want everyone to feel as if they are looking at something that was made by Mojang, which is why I spent hours perfecting every single piece before it goes live! </div>
                  </div>
                  <div v-show="contributor.test3.enable" data-name="test3" class="info py-5">
                    <div class="name flex items-center text-pink-600 font-bold uppercase text-lg mb-1">test3 - Community Manager</div>
                    <div class="bio text-gray-500">Hello, I’m Ashley! My purpose here on Origin Realms is to make sure the community is having as much fun possible at all times. You’ll actively see me in game, on the discord and I’ll always be around to help if you need! I’m also in charge of our amazing volunteer staff team - it is important that Origin Realms is always a safe and happy place to play every day! </div>
                  </div>
                </div>
              </div>
              <!-- todo -->
              <div class="render-wrap relative">
                <div v-show="contributor.test1.enable" data-name="test1" class="render">
                  <img src="/src/assets/image/test/17d979d.png" class="block mt-5 lg:mt-16 lg:ml-6 lg:mx-auto max-h-full max-w-full mx-auto" alt="">
                </div>
                <div v-show="contributor.test2.enable" data-name="test2" class="render">
                  <img src="/src/assets/image/test/961e499.png" class="block mt-5 lg:mt-16 lg:ml-6 lg:mx-auto max-h-full max-w-full mx-auto" alt="test2">
                </div>
                <div v-show="contributor.test3.enable" data-name="test3" class="render">
                  <img src="/src/assets/image/test/cd89691.png" class="block mt-5 lg:mt-16 lg:ml-6 lg:mx-auto max-h-full max-w-full mx-auto" alt="test2">
                </div>
              </div>
            </div>
          </div>
          <div class="pt-4 pb-6 flex lg:inline-flex mr-auto items-center justify-between flex-wrap text-gray-500">
            <div @click="scrollStaff('previous')" class="arrow arrow-left cursor-pointer order-2 transition-colors duration-150 ease-in-out hover:text-pink-400 lg:order-1 rounded-full">
              <svg fill="currentColor" viewBox="0 0 20 20" class="w-8 h-8">
                <path fill-rule="evenodd" d="M7.707 14.707a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 1.414L5.414 9H17a1 1 0 110 2H5.414l2.293 2.293a1 1 0 010 1.414z" clip-rule="evenodd"/>
              </svg>
            </div>
            <div class="staffSelector w-full lg:w-auto pb-4 px-1 lg:pb-0 flex flex-wrap items-center justify-center order-1 lg:order-2 px-5">
              <div @click="switchStaff(1)" :class="contributor.test1.style" class="pr-1 relative transform transition duration-150 cursor-pointer">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAkFBMVEUAAAD////66//2yaH5vYvtuYr9unHrqmHgtmDUqDHRnzHSiTjDfS7AjRerfhatdAuhagqfZwCgZQCUXQCOWwBjRhBiRhBROAhPNgBGMQlDLAZAJQA6JwQ2JQQ3IwIyIwIzHwAvHQIvHQMqHAInGQIjFQAgFAEaEAEKAAYPABIdACEoAStAADBPAFqGALLFAP9hTxG6AAAAAXRSTlMAQObYZgAAAN1JREFUeNrt1NVBNDEUgNEz+gvWAg7917JvOBWs6yShANyCfhWcyL1+ezw1gB3mAEANlgAla5SeWflyErBBB2o60FBT0EdeUg0KBgQiiUBFQeJ/dhIiKChZEilBR00kPwmJwH9a0CexBQpCfhIdkSkLKkoqhtSsIS+powUNgZptLplzTI81VhlJh6wAsGRKwQwUJNrsD1cz5x9z0NAD6FGBv7lIhyxpwJhtgBMSwCGzvLcUcWtD7pOo6AigykEqDlmChgEbdGAJ8B90oMlFmnPNAQlgDhqACsCLSF+/Gx3hPtQTL0fVAAAAAElFTkSuQmCC" class="w-10" alt="test1">
              </div>
              <div @click="switchStaff(2)" :class="contributor.test2.style" class="pr-1 relative transform transition duration-150 cursor-pointer">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAflBMVEUAAAAaEAEgFAEjFQAnGQIqHAIvHQIvHQMzHwAyIwI2JQQ3IwI6JwRDLAZGMQlROAhiRhBjRhDUqDHovEXvqk7puF7wvmP2x1nt1mj333H+4XX/+5H/0Kj+1LL+xp/9sYLQyMHa09ff2dTh2t3v7Oj/7dj/6c3/6M3///+q3vLVnI8GAAAAAXRSTlMAQObYZgAAANBJREFUeNrt1DVixDAQQNEneZnh/kdMt0SWU02gCyr4K7P/oH9eQBIMGHnGDfTjtONA9kqyV9LznF04XOOg5UrHAnWVWtCx5cIQXBiE4bm6EhJCoyBOe2RyfaWwarhQSEyjmomWTH2lPi3TuHEFawp3qKvUhMCUljGJHA91YFBRKXvG8zIpFK401SduxIkWwRGMSOBUSykzIKomRZkKI4COW932bkKpMIy/dySuDLiBUkMpZWIZmrMPy/6z2sUA1lIas6chAVGvS5wWQQWl78g9YnA4ixbXY/EAAAAASUVORK5CYII=" class="w-10" alt="test2">
              </div>
              <div @click="switchStaff(3)" :class="contributor.test3.style" class="pr-1 relative transform transition duration-150 cursor-pointer">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAqFBMVEUAAAAKDhMaEAEgFAEjFQAnGQIqHAIvHQIvHQMzHwAyIwI2JQQ3IwI6JwRDLAZGMQlROAhiRhBjRhB3STNCIyNCJRg7IxgbICgvACI5ACk8ACxIADRKADNYAD9MDEFfD1JmDVRxCF97AGOJCHGGfV6kjWfanUTmqkjxuUv/x1n/qW7/tn//vIn/vY/3t43/zKb35dv47+zs8/i/0N7OfQ3Fcw68aw0oBAmlhzt7AAAAAXRSTlMAQObYZgAAAOBJREFUeNrt0zN2hUEYANA7sW2pzv4XE0vtM+ZX9ep4wlE359xP/K/nVwAwzgQAkIFRgJI2Q163Xv9hBADQZBRERkFOpGQOaUk5KDmmxiwdcjDMJBfJSQggUA7eCAKBIdKTELjkiDodhkGXQM4Q6UmjTHLHJAgAEUhLGiYCoA62wAPAWELSMABKdunxQAkCW5wwnHziJugyYMgpQU4A3RSkgGHGiExTDt5lAgGUlJwS0hYugoIn1mhRMAOaDIEiSZaGGQORWVqMgFGADhgBMRVpkiYjBIAJ0AcoACQgfcdVAZzvOxmReXGNAAAAAElFTkSuQmCC" class="w-10" alt="test3">
              </div>
            </div>
            <div @click="scrollStaff('next')" class="arrow arrow-right cursor-pointer order-3 transition-colors duration-150 ease-in-out hover:text-pink-400 rounded-full">
              <svg fill="currentColor" viewBox="0 0 20 20" class="w-8 h-8">
                <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"/>
              </svg>
            </div>
          </div>
        </div>
        <div class="island"/>
      </div>
      <div class="indicator">
        <div class="progress" :style="{ width: widthPercentage }"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {computed, onMounted, reactive, ref} from "vue";


const contributor = reactive({
  test1: {
    enable: true,
    style: 'pointer-events-none opacity-100 -translate-y-2'
  },
  test2: {
    enable: false,
    style: 'opacity-70 hover:opacity-80'
  },
  test3: {
    enable: false,
    style: 'opacity-70 hover:opacity-80'
  }
})
let interval
const width = ref(2)


const widthPercentage = computed(() => {
  return width.value + '%'
})


const switchStaff = (position) => {
  switch (position) {
    case 1 : {
      contributor.test1.enable = true
      contributor.test2.enable = contributor.test3.enable = false
      contributor.test1.style = 'pointer-events-none opacity-100 -translate-y-2'
      contributor.test2.style = contributor.test3.style = 'opacity-70 hover:opacity-80'
      break
    }
    case 2 : {
      contributor.test2.enable = true
      contributor.test1.enable = contributor.test3.enable = false
      contributor.test2.style = 'pointer-events-none opacity-100 -translate-y-2'
      contributor.test1.style = contributor.test3.style = 'opacity-70 hover:opacity-80'
      break
    }
    case 3 : {
      contributor.test3.enable = true
      contributor.test1.enable = contributor.test2.enable = false
      contributor.test3.style = 'pointer-events-none opacity-100 -translate-y-2'
      contributor.test1.style = contributor.test2.style = 'opacity-70 hover:opacity-80'
      break
    }
  }
  width.value = 0
}
const scrollStaff = (behaviour) => {
  if (behaviour === 'next') {
    switch (true) {
      case contributor.test1.enable: {
        contributor.test2.enable = true
        contributor.test1.enable = false
        contributor.test2.style = 'pointer-events-none opacity-100 -translate-y-2'
        contributor.test1.style = 'opacity-70 hover:opacity-80'
        break
      }
      case contributor.test2.enable: {
        contributor.test3.enable = true
        contributor.test2.enable = false
        contributor.test3.style = 'pointer-events-none opacity-100 -translate-y-2'
        contributor.test2.style = 'opacity-70 hover:opacity-80'
        break
      }
      case contributor.test3.enable: {
        contributor.test1.enable = true
        contributor.test3.enable = false
        contributor.test1.style = 'pointer-events-none opacity-100 -translate-y-2'
        contributor.test3.style = 'opacity-70 hover:opacity-80'
        break
      }
    }
  } else if (behaviour === 'previous') {
    switch (true) {
      case contributor.test1.enable: {
        contributor.test3.enable = true
        contributor.test1.enable = false
        contributor.test3.style = 'pointer-events-none opacity-100 -translate-y-2'
        contributor.test1.style = 'opacity-70 hover:opacity-80'
        break
      }
      case contributor.test2.enable: {
        contributor.test1.enable = true
        contributor.test2.enable = false
        contributor.test1.style = 'pointer-events-none opacity-100 -translate-y-2'
        contributor.test2.style = 'opacity-70 hover:opacity-80'
        break
      }
      case contributor.test3.enable: {
        contributor.test2.enable = true
        contributor.test3.enable = false
        contributor.test2.style = 'pointer-events-none opacity-100 -translate-y-2'
        contributor.test3.style = 'opacity-70 hover:opacity-80'
        break
      }
    }
  } else return false
}
const previousStaff = () => {

}

const cancelInterval = () => {
  clearInterval(interval)
}
const startInterval = () => {
  loopWidth()
}
const loopWidth = () => {
  interval = setInterval(() => {
    width.value += 0.5
    if (width.value === 100) {
      width.value = 0
    }
  }, 100)
}
onMounted(loopWidth)
</script>

<script>
export default {
  name: "HomeStaff"
}
</script>