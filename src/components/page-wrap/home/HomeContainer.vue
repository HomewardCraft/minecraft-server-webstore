<template>
  <div class="body-wrap grid grid-rows-body h-full">
    <div class="page-wrap">
      <home-hero></home-hero>
      <home-video></home-video>
      <home-blog></home-blog>
      <home-staff></home-staff>
      <home-discord></home-discord>
      <div class="stone-bg dark pb-5"></div>
      <home-video-player></home-video-player>
    </div>
    <div
        class="loading fixed inset-0 z-50 transition-opacity ease-in-out duration-300 flex flex-col items-center justify-center bg-black/80 pointer-events-none opacity-0">
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
import HomeVideoPlayer from "./HomeVideoPlayer.vue";
export default {
  name: "HomeContainer",
  components: {HomeVideoPlayer, HomeDiscord, HomeStaff, HomeBlog, HomeVideo, HomeHero}
}
</script>

<style>
.page-bg {
  min-height: 600px;
  height: 70vh;
  z-index: -1;
  background: url(https://ba1oretto.com/home/background.png) bottom no-repeat;
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