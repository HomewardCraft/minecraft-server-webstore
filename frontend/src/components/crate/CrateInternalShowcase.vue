<!-- 包含CrateDetail -->
<template>
<div class="padding-2.5 position-1">
<div class="title">Cosmetic Crates</div>
  <div class="simple grid border-tiny">
    <crate-detail/>
  </div>
</div>
</template>

<script>
import crateDetail from "@/components/crate/CrateDetail";

export default {
  name: "RightShowcase",
  components: {
    crateDetail
  }
}
</script>

<style scoped>
.simple {
  box-sizing: border-box;
  color: #fff;
  background-color: rgba(24, 26, 27, 1);
  height: 158px;
  display: block;
}

.grid {
  display: grid;
  grid-template-columns: repeat(4,minmax(0,1fr));
}

.border-tiny {
  border-style: solid;
  border-width: 0;
  border-color: rgba(229, 231, 235, 1);
}

.position-1 {
  grid-column: span 3;
}

.padding-2\.5 {
  padding: 2.5rem
}

.title {
  text-align: left;
  font-weight: 700;
  font-size: 1.875rem;
  line-height: 2.25rem;
  margin-bottom: 1.5rem;
  color: #fff;
}
</style>