<template>
  <div data-page="blog" class="page-bg" :style="getImageAddress(latest.imageAddress)"/>
  <blog-container/>
  <div class="stone-bg dark pt-10 pb-20 blog-offset"/>
</template>

<script>
import BlogContainer from "./BlogContainer.vue";
import PageHeader from "../../PageHeader.vue";

export default {
  name: "BlogHub",
  components: {BlogContainer, PageHeader}
}
</script>

<script setup>
import {getImageAddress} from "../../../hook/attribute-generator.js";

const latest = {
  imageAddress: 'https://ba1oretto.com/blog/2022/04/Badger_Blog.jpg'
}
</script>