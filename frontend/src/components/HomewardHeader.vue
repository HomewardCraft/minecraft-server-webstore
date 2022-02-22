<!-- 网站的标题, 不会变 -->
<template>
  <div class="grid">
    <div class="span-row-3">
      <homewardLogo/>
    </div>
    <div>
      <homewardRouter/>
    </div>
    <div class="span-row-2">
      <homewardInfo/>
    </div>
  </div>
</template>


<script>
import homewardRouter from "@/components/HomewardRouter";
import homewardInfo from "@/components/HomewardInfo";
import homewardLogo from "@/components/HomewardLogo";

export default {
  name: "HomewardHeader",
  components: {
    homewardRouter,
    homewardInfo,
    homewardLogo
  }
}
</script>


<style scoped>
.grid {
  margin-top: 10px;
  margin-bottom: 80px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}

.span-row-3{
  grid-row: span 3 / auto;
}

.span-row-2{
  grid-row: span 2 / auto;
}

div{
  /*margin: 0;*/
  /*width: 1100px;*/
  /*height: 100px;*/
  /*display: block;*/
}
</style>