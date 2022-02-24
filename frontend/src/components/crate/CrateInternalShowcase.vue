<!-- 包含CrateDetail -->
<template>
  <div class="padding-2.5 position-1">
    <div class="title">Cosmetic Crates</div>
    <div class="simple grid border-tiny">
      <crate-detail/>
      <!--    v-for="crate in crates"-->
      <!--    :key="crate.id"-->
      <!--/>-->
      <button @click="getCrates">112233</button>
    </div>
  </div>
</template>

<script>
import crateDetail from "@/components/crate/CrateDetail";

export default {
  name: "RightShowcase",
  components: {
    crateDetail
  },
  methods: {
    async getCrates() {
      const {
        data: result
      } = await this.$http.get(`http://127.0.0.1:50012/category/crates`).then(
          crates => {
            console.log(result);
            console.log(crates)
            console.log(this.$router);
            console.log(this.$route.path);
          }
      )
    }
  },
  data() {
    return {

    }
  }
}
</script>

<style scoped>
/* 普通的样式 */
.simple {
  box-sizing: border-box;
  color: #fff;
  height: 158px;
  display: block;
}

/* 网格坐标 */
.grid {
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
}

/* 边框 */
.border-tiny {
  border-style: solid;
  border-width: 0;
  border-color: #ffffff1a;
}

/* 坐标内位置 */
.position-1 {
  grid-column: span 3;
}

/* 边距 */
.padding-2\.5 {
  padding: 2.5rem
}

/* 商品名称样式 */
.title {
  text-align: left;
  font-weight: 700;
  font-size: 1.875rem;
  line-height: 2.25rem;
  margin-bottom: 1.5rem;
  color: #fff;
}
</style>