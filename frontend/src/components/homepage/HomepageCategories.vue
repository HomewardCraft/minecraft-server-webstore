<!-- 主页中部的商品汇总 -->
<template>
  <div>
    <div>
      <span class="cat"> Categories </span>
      <div class="grid">
        <div class="span-row-2">
          <homepageCrates @click.native="toCratesPage"/>
        </div>
        <homepageRanks/>
        <homepageExtras @click.native="toExtrasPage"/>
      </div>
    </div>
  </div>
</template>


<script>
import homepageCrates from "@/components/homepage/HomepageCrates";
import homepageRanks from "@/components/homepage/HomepageRanks";
import homepageExtras from "@/components/homepage/HomepageExtras";

export default {
  name: "HomepageCategories",
  components: {
    homepageCrates,
    homepageRanks,
    homepageExtras
  },
  methods: {
    toCratesPage() {
      this.$router.push('crates')
    },
    toExtrasPage() {
      this.$router.push('extras')

    }
  }
}
</script>


<style scoped>
.cat {
  padding: 20px 0;
  margin: auto;
  font-weight: bold;
  font-size: 28px;
  color: #FFFFFF;
  width: 1100px;
  height: 30px;
  display: block;
  text-align: left;
}

.grid {
  margin: auto;
  width: 1100px;
  height: 500px;
  display: grid;
  grid-template-columns: repeat(2, 0fr);
}

.span-row-2 {
  align-self: center;
  grid-row: span 2 / auto;
}
</style>