<!-- 页面顶部的导航 -->
<template>
  <div class="router">
    <ul class="rt">
      <li class="il">
        <a>
          <homewardHome/>
        </a>
      </li>
      <li>
        <a>
          <homewardBlog/>
        </a>
      </li>
      <li>
        <a>
          <homewardRules/>
        </a>
      </li>
      <li>
        <a>
          <router-link to="/">
            <homewardStore/>
          </router-link>

        </a>
      </li>
    </ul>
  </div>
</template>


<script>
import homewardHome from "@/components/buttom/HomewardHome";
import homewardBlog from "@/components/buttom/HomewardBlog";
import homewardRules from "@/components/buttom/HomewardRules";
import homewardStore from "@/components/buttom/HomewardStore";

export default {
  name: "HomewardRouter",
  components: {
    homewardHome,
    homewardBlog,
    homewardRules,
    homewardStore
  },
  methods: {
    /* Deprecated
     returnStorePage() {
     this.$router.push('homepageRouter')
     }
     */
  }
}
</script>


<style scoped>
.rt {
  list-style-type: none;
  margin: auto 0;
  padding: 0;
  overflow: hidden;
}

li {
  float: left;
}

a {
  text-decoration: none;
  font-size: 18px;
  font-weight: bold;
  color: #FFFFFF;
  text-transform: uppercase;
  line-height: 40px;
}

.router {
  position: relative;
}
</style>