<template>
  <h2 class="text-3xl font-bold mb-8 flex justify-center">编辑分类</h2>
  <div class="categories flex items-center justify-center flex-col">
    <crates-section/>
    <extras-section/>
    <ranks-section/>
    <posts-section/>
  </div>
</template>

<script>
import CratesSection from "./categories/CratesSection.vue";
import ExtrasSection from "./categories/ExtrasSection.vue";
import RanksSection from "./categories/RanksSection.vue";
import PostsSection from "./categories/PostsSection.vue";

export default {
  name: "CategoriesSection",
  components: {PostsSection, RanksSection, ExtrasSection, CratesSection}
}
</script>

<style>
/* categories下的基础样式 */
.categories .category {
  background: #181a1b;
  box-shadow: #fff3 0 0 0 2px inset;
  color: #fff;
  font-weight: 700;
  font-size: 32px;
  position: relative;
  min-height: 230px;
  min-width: 680px;
  line-height: normal;
  transition-property: all;
  transition-duration: .2s;
  transition-timing-function: cubic-bezier(.4,0,.2,1);
  overflow: hidden;
  margin-bottom: 10px;
}

/* 鼠标悬浮的样式 */
.categories .category:hover {
  opacity: .8;
}

/* 字体样式 */
.categories .category .label {
  position: absolute;
  top: 30px;
  right: 30px;
}

/* categories动画样式 */
.categories .category .render {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

/* 位置吧 我不知道 */
.categories .category .render div {
  background: bottom left/auto no-repeat;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  transition: .3s ease-in-out opacity;
}

/* 指针悬停时正常的宝箱 */
.categories .category:hover .render .layer-regular {
  opacity: 0;
}

/* 指针悬停时打开的宝箱 */
.categories .category:hover .render .layer-hover {
  opacity: 1;
}

/* 不悬停时打开的宝箱 */
.categories .category .render div.layer-hover {
  opacity: 0;
}

.categories {
  /*grid-gap: 2rem;*/
}
</style>