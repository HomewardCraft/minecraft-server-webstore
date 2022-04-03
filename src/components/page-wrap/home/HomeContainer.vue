<template>
  <div class="body-wrap grid grid-rows-body h-full">
    <div class="page-wrap">
      <home-hero></home-hero>
      <home-video></home-video>
      <home-blog></home-blog>
      <home-staff></home-staff>
      <home-discord></home-discord>
      <div class="stone-bg dark pb-5"></div>
      <div class="videoPlayer bg-black fixed inset-0 z-50 p-10 pt-0 grid grid-rows-video" style="display: none;">
        <div
            class="top text-gray-500 flex items-center justify-start p-8 cursor-pointer transition duration-200 hover:text-yellow-400">
          <svg viewBox="0 0 640 512" fill="currentColor" class="w-8 mr-3">
            <path
                d="M576 64H205.26A63.97 63.97 0 0 0 160 82.75L9.37 233.37c-12.5 12.5-12.5 32.76 0 45.25L160 429.25c12 12 28.28 18.75 45.25 18.75H576c35.35 0 64-28.65 64-64V128c0-35.35-28.65-64-64-64zm-84.69 254.06c6.25 6.25 6.25 16.38 0 22.63l-22.62 22.62c-6.25 6.25-16.38 6.25-22.63 0L384 301.25l-62.06 62.06c-6.25 6.25-16.38 6.25-22.63 0l-22.62-22.62c-6.25-6.25-6.25-16.38 0-22.63L338.75 256l-62.06-62.06c-6.25-6.25-6.25-16.38 0-22.63l22.62-22.62c6.25-6.25 16.38-6.25 22.63 0L384 210.75l62.06-62.06c6.25-6.25 16.38-6.25 22.63 0l22.62 22.62c6.25 6.25 6.25 16.38 0 22.63L429.25 256l62.06 62.06z"></path>
          </svg>
          <div class="text-lg font-bold pr-6">Return to site</div>
        </div>
        <div class="video-wrap box-border p-5 bg-black lg:p-16 h-full">
          <iframe class="h-64 md:h-half lg:h-full" frameborder="0" allowfullscreen="1"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                  title="YouTube video player" width="100%" height="360"
                  src="https://www.youtube.com/embed/tbTGhffdi94?enablejsapi=1&amp;origin=https%3A%2F%2Foriginrealms.com&amp;widgetid=7"
                  id="widget8"></iframe>
        </div>
      </div>
    </div>
    <div
        class="loading fixed inset-0 z-50 transition-opacity ease-in-out duration-300 flex flex-col items-center justify-center bg-black-80 pointer-events-none opacity-0">
      <img src="https://assets.originrealms.com/static/img/animated-icon.gif" alt="Loading" class="animate-pulse">
      <div class="load-text font-bold uppercase text-4xl mt-3 animate-track">Loading...</div>
    </div>
  </div>
</template>

<script>
import HomeHero from "./HomeHero.vue";
import HomeVideo from "./HomeVideo.vue";
import HomeBlog from "./HomeBlog.vue";
import HomeStaff from "./HomeStaff.vue";
import HomeDiscord from "./HomeDiscord.vue";
export default {
  name: "HomeContainer",
  components: {HomeDiscord, HomeStaff, HomeBlog, HomeVideo, HomeHero}
}
</script>

<style>
.page-bg {
  min-height: 600px;
  height: 70vh;
  z-index: -1;
  background: url(https://ba1oretto.com/webstore/images/home-page-bg.png) bottom no-repeat;
  background-size: cover;
}

.hero {
  position: relative;
  width: 100%;
  display: flex;
  flex-direction: column;
}

.page-bg[data-page=home]:after {
  background: linear-gradient(180deg, rgba(129, 80, 133, .7), transparent 18%, rgba(0, 0, 0, .2) 60%, #000);
}

.hero .logo .img {
  background: url(https://ba1oretto.com/webstore/images/logo.png) 50% no-repeat;
  background-size: contain;
  padding-bottom: 50.25%;
}

.hero .logo {
  display: inline-block;
  max-width: 380px;
  width: 92%;
  position: relative;
}

</style>