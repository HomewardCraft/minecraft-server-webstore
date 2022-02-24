<!-- 包含CrateImage与CrateInternalShowcase -->
<template>
<div>
  <div class="container simple grid-4 border-tiny">
    <crate-image :uri="this.crate.itemBasicInfo.imageAddress"/>
    <crate-internal-showcase/>
  </div>
</div>
</template>

<script>
import crateInternalShowcase from "@/components/crate/CrateInternalShowcase";
import crateImage from "@/components/crate/CrateImage";

export default {
  name: "CrateShowcase",
  components: {
    crateInternalShowcase,
    crateImage
  },
  props: ['crate']
}
</script>

<style scoped>
/* 不知道该怎么分类 */
.simple {
  margin-top: 3rem;
  background-color: rgba(13, 14, 15, 1);
}

/* 网格坐标 */
.grid-4 {
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
}

/* 边框 */
.border-tiny {
  border-width: 1px;
  border-style: solid;
  border-color: #ffffff1a;
}
</style>