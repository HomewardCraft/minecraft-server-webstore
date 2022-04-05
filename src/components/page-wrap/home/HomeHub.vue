<template>
  <home-hero/>
  <home-video/>
  <home-blog/>
</template>

<script>
import HomeHero from "./HomeHero.vue";
import HomeVideo from "./HomeVideo.vue";
import HomeBlog from "./HomeBlog.vue";
export default {
  name: "HomeHub",
  components: {HomeBlog, HomeVideo, HomeHero},
}
</script>