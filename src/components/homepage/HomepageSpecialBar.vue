<!-- 主页的奖励进度 -->
<template>
  <div class="module-general specials-bar mb-2.5 fontcolor-white">
    <information-bar/>
    <progress-bar/>
  </div>
</template>


<script>
import progressBar from "@/components/homepage/specialBar/ProgressBar";
import informationBar from "@/components/homepage/specialBar/InformationBar";

export default {
  name: "HomepageSpecialBar",
  components: {
    progressBar,
    informationBar
  }
}
</script>


<style scoped>
.specials-bar {
  background-color: rgb(175, 97, 196);
  font-weight: 700;
  border: 3px solid rgba(255,255,255,.1);
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  text-align: center;
  position: relative;
}
</style>