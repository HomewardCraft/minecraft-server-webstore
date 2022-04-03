<template>
  <div data-page="blog" class="page-bg" style="background-image: url(https://ba1oretto.com/2022/4/Badger_Blog.jpg)"/>
  <blog-container/>
  <div class="stone-bg dark pt-10 pb-20 blog-offset"/>
</template>

<script>
import BlogContainer from "./BlogContainer.vue";

export default {
  name: "BlogHub",
  components: {BlogContainer}
}
</script>

<script setup>
</script>