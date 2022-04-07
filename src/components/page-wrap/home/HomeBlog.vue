<template>
  <section id="homeBlog">
    <div class="container mx-auto">
      <div class="section-title pt-48 pb-12 text-center">
        <h3 class="text-white text-3xl font-bold">Community Blogs</h3>
        <h5 class="text-gray-500 font-medium">Stay up to date with the latest blog posts!</h5>
      </div>
      <div class="posts grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-3">
        <a v-for="post in postList" :href="getPostURL(post.slug)" class="post mb-4 lg:mb-0 group">
          <div class="cover-wrap mb-6">
            <div class="blackout"/>
            <div :style="getImageAddress(post.featureImage)" class="cover shadow-border bg-cover bg-center transition ease-in-out duration-150 group-hover:opacity-90 group-hover:shadow-purple-inner"/>
          </div>
          <div class="post-body transition-opacity ease-in-out duration-150 group-hover:opacity-90 text-center">
            <h3 class="font-bold text-white mb-1 text-xl">{{ post.title }}</h3>
            <div class="flex lg:items-center flex-col-reverse lg:flex-row text-gray-500 justify-center">
              <div :style="getTagColor(post.tagColor)" class="font-semibold tracking-wide uppercase">{{ post.tag }}</div>
              <div class="mx-2 hidden lg:block">–</div>
              <div class="date">{{ getDate(post.createTime) }}</div>
            </div>
          </div>
        </a>
      </div>
      <div class="text-center pt-10 pb-32">
        <a href="/blog" class="inline-block bg-btn border border-lighten py-4 px-8 text-xl shadow-btn uppercase font-extrabold tracking-wide text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 hover:px-10 hover:tracking-widest">View all Posts</a>
      </div>
    </div>
  </section>
</template>

<script setup>
import {getDate, getTagColor, getPostURL, getImageAddress} from "../../../hook/attribute-generator.js";
import axios from "axios";
import {reactive} from "vue";

const postList = reactive([])

const selectPost = async () => {
  const {data: result } = await axios.get('local/post/home')
  postList.unshift(result.data[1], result.data[0], result.data[2])
}
selectPost()
</script>

<script>
export default {
  name: "HomeBlog"
}
</script>