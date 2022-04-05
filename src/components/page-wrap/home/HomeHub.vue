<template>
  <home-hero/>
  <home-video/>
  <home-blog/>
  <home-staff/>
  <home-social/>
  <div class="stone-bg dark pb-5"/>
  <home-video-player/>
</template>

<script>
import HomeHero from "./HomeHero.vue";
import HomeVideo from "./HomeVideo.vue";
import HomeBlog from "./HomeBlog.vue";
import HomeSocial from "./HomeSocial.vue";
import HomeVideoPlayer from "./HomeVideoPlayer.vue";
import HomeStaff from "./HomeStaff.vue";
export default {
  name: "HomeHub",
  components: {HomeStaff, HomeVideoPlayer, HomeSocial, HomeBlog, HomeVideo, HomeHero},
}
</script>