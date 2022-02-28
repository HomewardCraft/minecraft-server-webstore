<!-- 与CrateShowcase关联 -->
<template>
  <div>
    <div class="title">Crates</div>
    <crate-showcase v-for="item in data" :key="item.id" :crate="item"/>
  </div>
</template>

<script>
import crateShowcase from "@/components/crate/CrateShowcase";

export default {
  name: "CratesRoute",
  components: {
    crateShowcase
  },
  created() {
    this.$store.dispatch('itemList/getItemList', this.category)
  },
  beforeMount() {
    this.data = this.$store.state.itemList.itemArray
  },
  data() {
    return {
      category: this.$route.path.slice(1),
      data: null,
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