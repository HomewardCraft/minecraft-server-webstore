<template>
  <div class="info lg:col-span-2"><h3 class="package-title font-bold text-5xl text-white mb-4">{{items.name}}</h3>
    <div class="price font-extrabold mb-6">
      <!--没办法，只能这样写了，let里面的东西没法正确的读出来-->
      <div class="discount line-through italic text-gray-700">${{items.price / 100}} USD</div>
      <div class="final text-2xl text-yellow-400">${{(items.price / 100) * (items.salePercent / 100)}} USD</div>
    </div>
    <div class="description content-wrap"><p>Unlock the ultimate enchanting potential for your tool, using slot runes!
      These powerful runes will add an additional slot for enchantments to your tools.</p>
      <p>Once a purchase has been made, you will receive the slot rune in-game shortly after. Use an anvil to combine
        it with any of your tools!</p></div>
  </div>
</template>

<script>
export default {
  name: "ItemDetailInfo"
}
</script>

<script setup>
import {onMounted, reactive, ref} from "vue";
import {getCurrentInstance} from "vue";
import {useRoute} from "vue-router";



let http = getCurrentInstance().appContext.config.globalProperties.$http;
//接收的商品id
let itemId = ref('')
//这里存放着查询的商品信息
let items = ref(' ')

let saleCondition = items.value.saleCondition;

let originPrice = items.value.price / 100

let price = (items.value.price / 100) * (items.value.salePercent / 100)



async function getItemDetail() {
  const {
    data: result
  } = await http.get(`fantang/webstore/api/production/${itemId.value}`)

  items.value = result.data
  console.log("(!) 当前物品是:")
  console.log(items)

}

onMounted(() => {
  console.log('(!) 搜索此物品id中')

  itemId.value = useRoute().params.id
  getItemDetail()

})

</script>

<style scoped>

</style>