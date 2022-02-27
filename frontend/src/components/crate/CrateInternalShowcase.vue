<!-- 包含CrateDetail -->
<template>
  <div class="padding-2.5 position-1">
    <div class="title" v-text="crate.itemBasicInfo.name"/>
    <div class="simple grid border-tiny">
      <crate-detail
          v-for="amount in amountList"
          :key="amount"
          :amount="amount"
          :detail="crates"
          @click.native="toDetailPage(amount)"
      />
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
  data: function () {
    return {
      price: this.crate.itemBasicInfo.price,
      onSaleCondition: this.crate.itemSaleInfo.onsaleCondition,
      onSalePercent: this.crate.itemSaleInfo.onsalePercent,
      surplusTime: this.crate.itemSaleInfo.surplusTime,
      category: this.$route.path.slice(1)
    }
  },
  methods: {
    toDetailPage(amount) {
      this.$router.push({
        name: 'product',
        params: {
          category: this.category,
          amount: amount,
          id: this.crate.itemBasicInfo.id
        }
      })
    },
  },
  props: ['crate'],
  computed: {
    crates() {
      return {
        price: this.price,
        discount: {
          onSaleCondition: this.onSaleCondition,
          onSalePercent: this.onSalePercent,
          surplusTime: this.surplusTime,
        }
      }
    },
    amountList() {
      return {
        x20: 20,
        x10: 10,
        x5: 5,
        x1: 1,
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