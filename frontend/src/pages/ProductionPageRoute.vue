<template>
  <div class="module-general grid module-general">
    <detailPage v-for="details in data" :key="details.index" :details="details" :amount="amount"/>
  </div>
</template>

<script>
import detailPage from "@/components/detail/DetailPage";

export default {
  name: "ProductionPageRoute",
  components: {
    detailPage
  },
  created() {
    this.$store.dispatch('item/getItem', this.itemInfo)
  },
  beforeMount() {
    this.data = this.$store.state.item.itemDetails
  },
  data() {
    return {
      data: null,
      amount: this.$route.params.amount,
      itemInfo: {
        category: this.$route.params.category,
        id: this.$route.params.id
      },
      isloginshow: false
    }
  },
  methods: {
    openloginpannel() {
      this.isloginshow = true
    }
  }
}
</script>

<style scoped>


</style>