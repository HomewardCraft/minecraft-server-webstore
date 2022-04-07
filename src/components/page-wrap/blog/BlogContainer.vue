<template>
  <div class="container mx-auto">
    <div class="md:grid md:grid-cols-2 md:gap-10">
      <a v-for="(post, index) in data.posts" :key="index" :href="getPostURL(post.slug)" class="post mb-4 lg:mb-0 group">
        <div class="cover-wrap mb-6">
          <div class="blackout"/>
          <div class="cover shadow-border bg-cover bg-center transition ease-in-out duration-150 group-hover:opacity-90 group-hover:shadow-purple-inner cover-lg" :style="getImageAddress(post.featureImage)"/>
        </div>
        <div class="post-body transition-opacity ease-in-out duration-150 group-hover:opacity-90">
          <h3 class="font-bold text-white mb-1 text-xl text-2xl mb-3">{{ post.title }}</h3>
          <p class="excerpt h-full mb-4 text-gray-500">{{ textSubstring(post.excerpt, 180) }}</p>
          <div class="flex lg:items-center flex-col-reverse lg:flex-row text-gray-500">
            <div class="font-semibold tracking-wide uppercase" :style="getTagColor(post.tagColor)">{{ post.tag }}</div>
            <div class="mx-2 hidden lg:block">–</div>
            <div class="date">{{ getDate(post.createTime) }}</div>
          </div>
        </div>
      </a>
    </div>
    <div class="flex items-center justify-between bg-black/50 p-4 mt-10 mb-20">
      <div :class="button.prev" @click="changePage(false)" class="inline-block border border-lighten py-2 px-4 transition-all duration-150 ease-in-out">
        <svg fill="currentColor" viewBox="0 0 20 20" class="w-8 h-8">
          <path fill-rule="evenodd" d="M7.707 14.707a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 1.414L5.414 9H17a1 1 0 110 2H5.414l2.293 2.293a1 1 0 010 1.414z" clip-rule="evenodd"/>
        </svg>
      </div>
      <div class="pages text-sm font-bold text-gray-500">Page <b class="text-pink-400">{{ data.pagination.pageNum }}</b> of {{ data.pagination.pageSum }}</div>
      <div :class="button.next" @click="changePage(true)" class="inline-block border border-lighten py-2 px-4 transition-all duration-150 ease-in-out">
        <svg fill="currentColor" viewBox="0 0 20 20" class="w-8 h-8">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"/>
        </svg>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BlogContainer"
}
</script>

<script setup>
import {reactive} from "vue";
import {getDate, getPostURL, getTagColor, getImageAddress} from "../../../hook/attribute-generator.js";
import axios from "axios";
import pubsub from "pubsub-js";

const params = {
  pageNum: 1,
  pageSize: 8
}
const data = reactive({
  pagination: {},
  posts: []
})

const button = reactive({
  next: 'text-btn-text bg-btn shadow-btn hover:opacity-75 cursor-pointer',
  prev: 'text-gray-500 bg-gray-900 pointer-events-none'
})
const buttonCondition = {
  disable: 'text-gray-500 bg-gray-900 pointer-events-none',
  enable: 'text-btn-text bg-btn shadow-btn hover:opacity-75 cursor-pointer'
}

const getPosts = async () => {
  const {data: res} = await axios.get('local/post/blog', {params})
  const result = res.data;
  data.pagination = {
    pageNum: result.pageNum,
    pageSize: result.pageSize,
    pageSum: result.pageSum,
    next: result.next,
    prev: result.prev,
    total: result.total
  }
  data.posts = result.posts
  button.next = data.pagination.next === null ? buttonCondition.disable : buttonCondition.enable
  button.prev = data.pagination.prev === null ? buttonCondition.disable : buttonCondition.enable
  pubsub.publish('changeLoadingBgCondition', false)
}
getPosts()

const textSubstring = (text, position) => {
  return text.toString().substring(0, position) + '...'
}

const changePage = (next) => {
  pubsub.publish('changeLoadingBgCondition', true)
  const superContainer = document.getElementById('app')
  superContainer.scrollIntoView({
    behavior: 'smooth'
  })
  params.pageNum += next ? 1 : -1
  getPosts()
}
</script>