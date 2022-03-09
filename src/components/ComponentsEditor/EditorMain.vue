<template>
  <div class="flex justify-around items-center">
    <div class="item-image">
      <div class="h-52 w-52 relative bg-gray-800 bg-bottom bg-no-repeat border border-light border-b-0">
      <!-- image here -->
      </div>
      <div class="bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 border border-light border-t-0 text-gray-300 flex items-center justify-center text-center cursor-pointer py-2 font-bold opacity-100 transition-colors duration-150 ease-in-out">
        <span>更换图片</span>
        <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
        </svg>
      </div>
    </div>

    <div class="item-info grid gap-3">
      <button @click="changeCategoryShowCaseCondition" class="item-category">
        <span>{{categoryShowCase.category}}</span>
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

      <div class="item-name my-auto">
        <h3>物品名称</h3>
        <input v-model="information.name" maxlength="24" placeholder="物品的名称"/>
      </div>

      <button @click="changeDiscountShowCaseCondition" class="item-count">
        <span>折扣</span>
      </button>

      <transition name="item">
        <div v-show="discountShowCase.isOpen" class="item-discount my-auto transition-all ease-in-out duration-200 bg-gray-900 shadow-lg rounded z-50">
          <h3 class="text-white font-bold">额度 (%)</h3>
          <input v-model="information.discount" maxlength="2" type="number" placeholder="78%" class="appearance-none"/>
        </div>
      </transition>

      <div class="item-price my-auto">
        <h3 class="font-bold mb-2">物品价格</h3>
        <input v-model="information.price" maxlength="7" type="number" placeholder="1元等于100" class="appearance-none"/>
      </div>

      <div class="item-command my-auto">
        <h3 class="font-bold ">附带指令</h3>
        <input v-model="information.command" maxlength="128" placeholder="例如 /minecraft give @p items"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive} from "vue";
import pubsub from "pubsub-js";


let categoryShowCase = reactive({
  category: '类型',
  isOpen: false
})

let categories = reactive({
  crate: true,
  extra: true
})

let discountShowCase = reactive({
  isOpen: true
})

function changeCategoryShowCaseCondition() {
  categoryShowCase.isOpen = !categoryShowCase.isOpen
  discountShowCase.isOpen = false
}
function changeCategoryShowCase(type) {
  categoryShowCase.isOpen = false
  categoryShowCase.category = type
  setTimeout(() => {
    if (type === 'Crate') {
      categories.crate = false
      categories.extra = true
    } else {
      categories.extra = false
      categories.crate = true
    }
  }, 300)
}

function changeDiscountShowCaseCondition() {
  discountShowCase.isOpen = !discountShowCase.isOpen
  categoryShowCase.isOpen = false
}

let information = reactive({
  category: categoryShowCase.category,
  name: null,
  price: null,
  discount: null,
  command: null
})

function commit() {
  let cancelCommit = information.category === '类型' || information.name === null || information.price === null || information.discount === null || information.command === null || !Number.isInteger(information.price) || !Number.isInteger(information.discount) || !information.price.length <= 7 || !information.discount.length <= 2 || !information.price >= 100 || !information.discount > 0;
  if (cancelCommit) {
    return false
  }
  pubsub.publish('commit', information)
}
</script>

<script>
export default {
  name: "EditorMain"
}
</script>

<style>
.item-leave-active {
  animation: imba ease-in-out 0.3s reverse;
}

.item-enter-active {
  animation: imba ease-in-out 0.3s;
}

@keyframes imba {
  from {
    transform: translateY(-30px);
    opacity: 0;
  }
  to {
    transform: translateY(0px);
    opacity: 1;
  }
}

.item-info button {
  @apply my-auto items-center justify-center font-bold transition-colors duration-150 ease-in-out rounded bg-gray-800 text-gray-500 py-2.5 hover:bg-yellow-400 hover:text-yellow-900
}

#editorPanel.body .item-discount {
  grid-column: 1;
  grid-row: 2;
}

#editorPanel.body .item-info {
  justify-content: flex-end;
  flex-grow: 0.8;
  grid-template-columns: 320px 320px;
  grid-template-rows: 50px 90px 90px;
}

#editorPanel.body .item-info input {
  width: 100%;
  @apply bg-gray-800 text-white py-2.5 px-4 border border-light transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none
}

#editorPanel.body h3 {
  font-size: 1.25rem;
  line-height: 2rem;
  @apply text-gray-500 mb-1 font-bold
}

#editorPanel.body .item-category {
  font-size: 1.25rem;
  grid-column: 1;
  grid-row: 1;
}

#editorPanel.body .item-categories {
  grid-column: 2;
  grid-row: 2;
  font-size: 1.25rem;
  height: 143%;
}

#editorPanel.body .item-name {
  grid-column: 1;
  grid-row: 2;
}

#editorPanel.body .item-count {
  font-size: 1.25rem;
  grid-column: 2;
  grid-row: 1;
}

#editorPanel.body .item-price {
  grid-column: 2;
  grid-row: 2;
}

#editorPanel.body .item-command {
  grid-column-start: 1;
  grid-column-end: 3;
  grid-row: 3;
}
</style>