<!-- 包含CrateDetail -->
<template>
  <div class="padding-2.5 position-1">
    <div class="title">Cosmetic Crates</div>
    <div class="simple grid border-tiny">
      <crate-detail v-for="crate in crates" :key="crate.name"/>
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
  data() {
    return {
      crates: {
        a: {
          name: "20x Cosmetic Crate Key"
        },
        b: {
          name: "15x Cosmetic Crate Key"
        },
        c: {
          name: "10x Cosmetic Crate Key"
        },
        d: {
          name: "5x Cosmetic Crate Key"
        }
      }
    }
  }
}
</script>

<style scoped>
/* 普通的样式 */
.simple {
  box-sizing: border-box;
  color: #fff;
  background-color: rgba(24, 26, 27, 1);
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
  border-color: rgba(229, 231, 235, 1);
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