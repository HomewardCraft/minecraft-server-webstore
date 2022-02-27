<!--是这样的-->
<template>
  <div class="breadcrumbs mb-12 flex items-center mainfix">
    <a href="#/"
       class="return-btn bg-gray-900 border border-light rounded-md py-3 px-5 font-bold text-gray-500 flex items-center transition-colors duration-200 ease-in-out hover:bg-piston text-yellow-800">
      <svg class="w-5 h-5 mr-3 opacity-50" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd"
              d="M7.707 3.293a1 1 0 010 1.414L5.414 7H11a7 7 0 017 7v2a1 1 0 11-2 0v-2a5 5 0 00-5-5H5.414l2.293 2.293a1 1 0 11-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
              clip-rule="evenodd">

        </path>
      </svg>
      <span>Home</span></a>
    <div class="separator">/</div>
    <a href="#/crates" class="breadcrumb">Crates</a>
    <div class="separator">/</div>
    <div class="breadcrumb">20x Cosmetic Crate Key</div>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "Breadcrumb",
  data(){
    return {
      beforeUrl: '',
      category: '',
      id: ''
    }
  },
  methods: {
    getPath() {
      console.log("(!) getPath()")
      const path = this.$route.path.split('/')

      console.log(path)

      // this.$store.dispatch('items/getItem', this.category)
    }
  },
  mounted() {
    // this.$nextTick(() => {
    //   //获取上级路由
    //   console.log(this.beforeUrl)
    // })
    // router.afterEach((to,from)=>{
    //   console.log('AfterEach',to,from)
    // })
    this.getPath();
    console.log(this.$route)
  },
  watch: {
    $route(val) {
      this.getPath();
    },

  }
}

//TODO 实现基于路由或者后端查询分配指定子链接

</script>

<style scoped>

@import "./../../assets/css/breadcrumb.css";

</style>