<template>
  <div>
    <detail-title :name="details.itemBasicInfo.name" :amount="amount"/>
    <detail-price/>
    <detail-lore/>
    <detail-image/>
    <login-box/>
  </div>
</template>

<script>
import detailTitle from "@/components/detail/DetailTitle";
import detailPrice from "@/components/detail/DetailPrice";
import detailLore from "@/components/detail/DetailLore";
import detailImage from "@/components/detail/DetailImage";
import loginBox from "@/components/detail/LoginBox";

export default {
  name: "DetailPage",
  props: ['details', 'amount'],
  components: {
    detailTitle,
    detailPrice,
    detailLore,
    detailImage,
    loginBox
  },
  data() {
    return {
      name: null
    }
  },
  beforeDestroy() {
    this.$store.state.item.itemDetails.splice(0, this.$store.state.item.itemDetails.length)
  }
}
</script>

<style scoped>

</style>