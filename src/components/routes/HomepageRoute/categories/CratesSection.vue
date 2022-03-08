<template>
  <router-link to="/crates" class="category category-crates">
    <crate-animation/>
    <div class="label capitalize">crates</div>
  </router-link>
</template>

<script>
import CrateAnimation from "./showcase/CrateAnimation.vue";
export default {
  name: "CratesSection",
  components: {CrateAnimation}
}
</script>

<style scoped>
@screen lg {
  .categories .category.category-crates {
    grid-column: 1;
    grid-row: 1;
  }
}

.categories .category.category-crates {
  background: linear-gradient(50deg, #dc1628, #ea632e);
}

.homepage .categories .category.category-crates:before {
  display: block;
}

.categories .category:before {
  content: "NEW";
  position: absolute;
  top: 22px;
  left: -50px;
  font-size: 26px;
  letter-spacing: 2px;
  transform: rotate(-45deg);
  background: rgba(255, 255, 255, .3);
  padding: 5px 60px;
  text-shadow: rgb(0 0 0 / 20%) 0 3px 6px;
  border: 2px solid rgba(255, 255, 255, .3);
  display: none;
}
</style>