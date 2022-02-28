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
<!--    基于当前pathTree进行面包内部分配-->
    <template v-for="(obj,i) in pathTree.length">
      <div class="separator">/</div>
<!--      如果不是最后一个path的话就有跳转链接-->
      <a v-if="i<pathTree.length-1" :href=pathTree[i].path class="breadcrumb">{{ pathTree[i].name }}</a>
<!--      反之，最后一个path无法进行跳转-->
      <div v-else class="breadcrumb">{{ pathTree[i].name }}</div>
    </template>
    <!--<div class="breadcrumb">20x Cosmetic Crate Key</div>-->
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "Breadcrumb",
  data() {
    return {
      pathTree: []
    }
  },
  methods: {
    getPath() {
      // console.log("(!) getPath()")
      const path = this.$route.path.split('/')

      for (let j = 0; j < path.length; j++) {
        switch (path[j]) {
          case '':
            break;
          case 'extras':
            this.pathTree.push({name: "Extras", path: '#/extras'})
            break;
          case 'crates':
            this.pathTree.push({name: "Crates", path: '#/crates'})
            break;
          case 'checkout':
            this.pathTree.push({name: "Checkout", path: '/'})
            break;
          default:
            this.pathTree.push({name: "Unknown", path: '/'})
        }
      }

      // console.log(this.pathTree)

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
    // console.log(this.$route)
  },
  watch: {
    $route(val) {
      this.pathTree = []
      this.getPath();
    },

  }
}

//TODO 实现基于路由或者后端查询分配指定子链接

</script>

<style scoped>

@import "./../../assets/css/breadcrumb.css";

</style>