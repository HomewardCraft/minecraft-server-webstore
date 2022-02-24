<!-- 与CrateShowcase关联 -->
<template>
  <div>
    <div class="title">Crates</div>
    <crate-showcase v-for="item in data" :key="item.id"/>
  </div>
</template>

<script>
import crateShowcase from "@/components/crate/CrateShowcase";

export default {
  name: "CratesRoute",
  components: {
    crateShowcase
  },
  methods: {
    async getCrates() {
      const {
        data: result
      } = await this.$http.get(`/category/${this.category}`)
      result.data
    }
  },
  data() {
    return {
      category: this.$route.path.slice(1),
      itemList: [],
      data: [
        {
          id: 1
        },
        {
          id: 2
        },
        {
          id: 3
        }
      ]
    }
  }
}
</script>

<style scoped>
/* 标题 */
.title {
  color: rgba(255, 255, 255, 1);
  font-weight: 700;
  text-align: center;
  padding-top: 4rem;
  font-size: 3rem;
  line-height: 1;
}
</style>