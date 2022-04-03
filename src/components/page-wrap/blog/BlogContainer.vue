<template>
  <div class="container mx-auto">
    <div class="md:grid md:grid-cols-2 md:gap-10">
      <a v-for="post in data" key="index" :href="'/blog/' + post.name" class="post mb-4 lg:mb-0 group">
        <div class="cover-wrap mb-6">
          <div class="blackout"/>
          <div class="cover shadow-border bg-cover bg-center transition ease-in-out duration-150 group-hover:opacity-90 group-hover:shadow-purple-inner cover-lg" :style="'background-image: url('+ post.imageAddress + ')'"/>
        </div>
        <div class="post-body transition-opacity ease-in-out duration-150 group-hover:opacity-90">
          <h3 class="font-bold text-white mb-1 text-xl text-2xl mb-3">{{ post.version }} - {{ post.title }}</h3>
          <p class="excerpt h-full mb-4 text-gray-500">{{ substring(post.preview) }}</p>
          <div class="flex lg:items-center flex-col-reverse lg:flex-row text-gray-500">
            <!-- todo 颜色切换 -->
            <div class="font-semibold tracking-wide uppercase tag tag-update" style="color: rgb(245, 183, 43);">{{ post.type }}</div>
            <div class="mx-2 hidden lg:block">–</div>
            <div class="date">{{ post.date }}</div>
          </div>
        </div>
      </a>
    </div>

    <div class="flex items-center justify-between bg-black/50 p-4 mt-10 mb-20">
      <div :class="buttonCondition.previous" class="inline-block border border-lighten py-2 px-4 transition-all duration-150 ease-in-out">
        <svg fill="currentColor" viewBox="0 0 20 20" class="w-8 h-8">
          <path fill-rule="evenodd" d="M7.707 14.707a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 1.414L5.414 9H17a1 1 0 110 2H5.414l2.293 2.293a1 1 0 010 1.414z" clip-rule="evenodd"/>
        </svg>
      </div>
      <!-- todo 动态的 -->
      <div class="pages text-sm font-bold text-gray-500">Page <b class="text-pink-400">{{ 1 }}</b> of {{ 6 }}</div>
      <div :class="buttonCondition.next" class="inline-block border border-lighten py-2 px-4 transition-all duration-150 ease-in-out">
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

const data = [{
  name: 'gigs-and-jigs',
  imageAddress: 'https://ba1oretto.com/2022/4/Badger_Blog.jpg',
  version: '0.18.0',
  title: 'Gigs & Jigs Update',
  preview: 'Greetings adventurers! As many of you have recently seen, Origin Isles is undergoing some major construction to the right side of the island and there\'s plenty more to see! Bucklewasdwasdwasssssssssssss',
  type: 'update',
  date: 'Mar 19th, 2022'
},{
  name: 'bandits-and-badlands',
  imageAddress: 'https://ba1oretto.com/2022/3/Badlands_Blog.jpg',
  version: '0.17.0',
  title: 'Bandits & Badlands',
  preview: 'Hello there! The arid region is being elevated to all new heights, as we see a whole new cast of foes arriving on Origin Realms, with so much to explore! Today we\'re excited to rewdaaasdlkwajdklawnjodlawhoudja;kldjaispojdwqpiajdksajipw',
  type: 'update',
  date: 'Mar 5th, 2022'
}]

const substring = (text) => {
  return text.toString().substring(0, 180) + '...'
}








const buttonCondition = reactive({
  previous: 'text-gray-500 bg-gray-900',
  next: 'text-btn-text bg-btn shadow-btn hover:opacity-75 cursor-pointer'
})
</script>