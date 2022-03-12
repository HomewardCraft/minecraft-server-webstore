<template>
  <button @click="changeCategoryShowCaseCondition" class="item-category">
    <span>{{information.category}}</span>
  </button>

  <transition name="item">
    <div v-show="categoryShowCase.isOpen" class="item-categories transition-all ease-in-out duration-200 bg-gray-800 shadow-lg rounded grid grid-flow-col z-50">
      <button v-show="categories.crate" @click="changeCategoryShowCase('Crate')" class="category h-full font-bold">
        <span>Crate</span>
      </button>
      <button v-show="categories.extra" @click="changeCategoryShowCase('Extra')" class="category h-full font-bold">
        <span>Extra</span>
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
const props = defineProps(['information', 'categoryShowCase', 'categories', 'discountShowCase']);

let categoryShowCase = props.categoryShowCase
let categories = props.categories
let information = props.information
let discountShowCase = props.discountShowCase

function changeCategoryShowCase(type) {
  categoryShowCase.isOpen = false
  information.category = type
  setTimeout(() => {
    if (type === 'Crate') {
      information.multiDiscount.x1 = null
      information.multiDiscount.x5 = null
      information.multiDiscount.x10 = null
      information.multiDiscount.x20 = null
      categories.crate = false
      categories.extra = true
    } else {
      information.discount = null
      categories.extra = false
      categories.crate = true
    }
  }, 300)
}
function changeCategoryShowCaseCondition() {
  categoryShowCase.isOpen = !categoryShowCase.isOpen
  discountShowCase.isOpen = false
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
</style>