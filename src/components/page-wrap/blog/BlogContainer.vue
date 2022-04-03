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
          <p class="excerpt h-full mb-4 text-gray-500">{{ textSubstring(post.preview) }}</p>
          <div class="flex lg:items-center flex-col-reverse lg:flex-row text-gray-500">
            <!-- todo 颜色切换 -->
            <div class="font-semibold tracking-wide uppercase tag tag-update" :style="setColor(post.type)">{{ post.type }}</div>
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
  imageAddress: 'https://ba1oretto.com/blog/2022/4/Badger_Blog.jpg',
  version: '0.18.0',
  title: 'Gigs & Jigs Update',
  preview: 'Greetings adventurers! As many of you have recently seen, Origin Isles is undergoing some major construction to the right side of the island and there\'s plenty more to see! Bucklewasdwasdwasssssssssssss',
  type: 'Update',
  date: 'Mar 19th, 2022'
},{
  name: 'road-to-1-0-0',
  imageAddress: 'https://ba1oretto.com/blog/2021/7/Dev_Update_Blog.jpeg',
  version: '1.0.0',
  title: 'The Road To 1.0.0',
  preview: 'As promised in our last blog post, in today we\'ll be talking more about the path out of Beta as we approach update 1.0.0, and what that means for the future of Origin Realms. For more informationwadsioajdpwak[skd[awppo',
  type: 'Dev Blog',
  date: 'Jul 12th, 2021'
},{
  name: 'summer-time',
  imageAddress: 'https://ba1oretto.com/blog/2021/7/Summer_Blog.jpeg',
  version: '0.9.0',
  title: 'Summer Time',
  preview: 'Howdy there, travellers! In todays blog post, we\'re taking a look at the most tropical update to hit Origin Realms thus far - the summer update! Before you continue, I\'d like to nweasdalkjsd;kljwapiuspdkw;ap[sodkw[ak[',
  type: 'Event',
  date: 'Jul 12th, 2021'
},{
  name: 'blocks-and-rocks',
  imageAddress: 'https://ba1oretto.com/blog/2020/7/Custom_Blocks2.jpg',
  version: '0.01.0',
  title: 'More Blocks & Rocks!',
  preview: 'Greetings adventurer, and welcome back to another weekly blog! This week, we\'re giving all our love and attention to the building community as we uncover over100 brand new blocks deep dark fantasies deep dark fantasies deep dark fantasies',
  type: 'Misc',
  date: 'Jul 27th, 2020'
}]

const textSubstring = (text) => {
  return text.toString().substring(0, 180) + '...'
}

const setColor = (type) => {
  switch (type.toString().toLowerCase()) {
    case 'update': return 'color: rgb(245, 183, 43)'
    case 'dev blog': return 'color: rgb(51, 241, 127)'
    case 'event': return 'color: rgb(67, 204, 218)'
    case 'misc': return 'color: rgb(255, 134, 218)'
  }
}








const buttonCondition = reactive({
  previous: 'text-gray-500 bg-gray-900',
  next: 'text-btn-text bg-btn shadow-btn hover:opacity-75 cursor-pointer'
})
</script>