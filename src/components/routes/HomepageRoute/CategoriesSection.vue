<template>
  <h2 class="text-3xl font-bold mb-4">Categories</h2>
  <div class="categories">
    <crates-section/>
    <extras-section/>
    <ranks-section/>
  </div>
</template>

<script>
import CratesSection from "./categories/CratesSection.vue";
import ExtrasSection from "./categories/ExtrasSection.vue";
import RanksSection from "./categories/RanksSection.vue";

export default {
  name: "CategoriesSection",
  components: {RanksSection, ExtrasSection, CratesSection}
}
</script>

<style scoped>
@screen lg {
  .categories {
    grid-template-columns: minmax(auto, 45%) minmax(auto, 55%);
    grid-template-rows: 1fr 1fr;
  }
}

@screen sm {
  .categories {
    grid-template-columns: minmax(auto, 50%) minmax(auto, 50%);
  }
}

.categories {
  display: grid;
  grid-gap: 20px;
}
</style>