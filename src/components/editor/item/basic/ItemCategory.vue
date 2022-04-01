<template>
  <button @click="changeCategoryShowCaseCondition" class="item-category">
    <span>{{cache.category}}</span>
  </button>

  <transition name="item">
    <div v-show="moduleCondition.categoryShowCase" class="item-categories transition-all ease-in-out duration-200 bg-gray-800 shadow-lg rounded grid grid-flow-col z-50">
      <button v-show="cache.categories.crate" @click="changeCategoryShowCase('crates')" class="category h-full font-bold">
        <span>Crates</span>
      </button>
      <button v-show="cache.categories.extra" @click="changeCategoryShowCase('extras')" class="category h-full font-bold">
        <span>Extras</span>
      </button>
    </div>
  </transition>
</template>

<script>
export default {
  name: "ItemCategory"
}
</script>

<script setup>
const props = defineProps(['cache', 'moduleCondition']);

const cache = props.cache
const moduleCondition = props.moduleCondition

function changeCategoryShowCase(type) {
  moduleCondition.categoryShowCase = false
  cache.category = type
  cache.clickable = ''
  setTimeout(() => {
    if (type === 'crates') {
      cache.discount = null
      cache.categories.crate = false
      cache.categories.extra = true
    } else {
      cache.multiDiscount.x1 = null
      cache.multiDiscount.x5 = null
      cache.multiDiscount.x10 = null
      cache.multiDiscount.x20 = null
      cache.categories.extra = false
      cache.categories.crate = true
    }
  }, 300)
}
function changeCategoryShowCaseCondition() {
  moduleCondition.categoryShowCase = !moduleCondition.categoryShowCase
  moduleCondition.discountShowCase = false
}
</script>

<style>
.editor .item-categories {
  grid-column: 1;
  grid-row: 2;
  font-size: 1.25rem;
  height: 92%;
}
.editor .item-category {
  font-size: 1.25rem;
  grid-column: 1;
  grid-row: 1;
}
.editor .item-category span, .editor .item-categories span {
 @apply capitalize
}
</style>