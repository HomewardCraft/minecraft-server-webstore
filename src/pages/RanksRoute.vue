<template>
  <rank-title/>
  <div class="rank-grid grid md:grid-cols-2 lg:grid-cols-4 gap-4 mt-12">
    <rank-level/>
  </div>
</template>

<script>
import RankTitle from "../components/routes/RanksRoute/RankTitle.vue";
import RankLevel from "../components/routes/RanksRoute/RankLevel.vue";

export default {
  name: "RanksRoute",
  components: {RankLevel, RankTitle}
}
</script>

<script setup>
import sendRoutePath from "../hooks/sendRoutePath.js";

sendRoutePath()
</script>