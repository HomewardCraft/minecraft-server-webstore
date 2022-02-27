<template>
  <div class="module-general grid module-general">
    <detailPage :details="details" :amount="amount"/>
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
    console.log(this.itemInfo)
    this.$store.dispatch('item/getItem', this.itemInfo)
  },
  beforeMount() {
    this.details = this.$store.state.item.itemDetails
  },
  data() {
    return {
      details: '',
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