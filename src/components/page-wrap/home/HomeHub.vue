<template>
  <home-hero/>
  <home-video/>
  <home-blog/>
  <home-social/>
  <div class="stone-bg dark pb-5"></div>
</template>

<script>
import HomeHero from "./HomeHero.vue";
import HomeVideo from "./HomeVideo.vue";
import HomeBlog from "./HomeBlog.vue";
import HomeSocial from "./HomeSocial.vue";
export default {
  name: "HomeHub",
  components: {HomeSocial, HomeBlog, HomeVideo, HomeHero},
}
</script>