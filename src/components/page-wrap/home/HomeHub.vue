<template>
  <home-hero/>
  <home-video/>
</template>

<script>
import HomeHero from "./HomeHero.vue";
import HomeVideo from "./HomeVideo.vue";
export default {
  name: "HomeHub",
  components: {HomeVideo, HomeHero},
}
</script>