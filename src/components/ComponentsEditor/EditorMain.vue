<template>
  <div class="flex justify-around items-center">
    <div class="item-image">
      <div class="h-52 w-52 relative bg-gray-800 bg-bottom bg-no-repeat border border-light border-b-0">
      <!-- image here -->
      </div>
      <div class="bg-green-700 hover:bg-yellow-400 hover:text-yellow-900 focus:text-yellow-900 border border-light border-t-0 text-gray-300 flex items-center justify-center text-center cursor-pointer pb-2 pt-2 text-white font-bold opacity-100 transition-colors duration-150 ease-in-out hover:text-orange-300">
        <span>更换图片</span>
        <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
        </svg>
      </div>
    </div>

    <div class="item-info grid gap-3">
      <button class="item-category">
        <span>类型</span>
      </button>

      <div class="item-name my-auto">
        <h3>物品名称</h3>
        <input maxlength="24" placeholder="物品的名称"/>
      </div>

      <button class="item-count">
        <span>折扣</span>
      </button>

      <div class="item-price my-auto">
        <h3 class="font-bold mb-2">物品价格</h3>
        <input maxlength="24" placeholder="1元等于100"/>
      </div>

      <div class="item-command my-auto">
        <h3 class="font-bold ">附带指令</h3>
        <input maxlength="128" placeholder="例如 /minecraft give @p items"/>
      </div>
    </div>
  </div>
</template>

<script setup>


</script>

<script>
export default {
  name: "EditorMain"
}
</script>

<style>
.item-info button {
  @apply my-auto items-center justify-center font-bold transition-colors duration-150 ease-in-out rounded bg-gray-800 text-gray-500 py-2.5 hover:bg-yellow-400 focus:bg-yellow-400 focus:outline-none hover:text-yellow-900 focus:text-yellow-900
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