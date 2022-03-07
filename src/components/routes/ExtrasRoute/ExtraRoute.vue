<template>
  <SearchUtil></SearchUtil>

  <div class="packages grid gap-6 md:grid-cols-2 pt-16">
    <a v-for="items in list" :key="items.itemBasicInfo.id"
       @click="goToDetail(items.itemBasicInfo.id)"
       ref ="item"
       :id="items.itemBasicInfo.id"
       class="package grid bg-gray-900 border border-lighten transform transition-all hover:opacity-75 hover:-translate-y-2"
    >
      <div class="image">
        <div class="bg-block bg-gray-800 mx-12 h-24"></div>
        <img alt="Slot Rune"

             src="//dunb17ur4ymx4.cloudfront.net/packages/images/31894a0afe0c182aa24e9dc47654a9107dc76fdc.png">
      </div>

      <div class="text px-6 text-center font-bold">
        <div class="name text-white text-lg">{{ items.itemBasicInfo.name}}</div>
        <div class="price pt-2 text-yellow-400">
          <div class="discounted text-gray-500 text-sm font-italic line-through">${{ items.itemBasicInfo.price / 100 }}
            USD
          </div>
          <div class="final">${{ items.itemBasicInfo.price / 100 * (items.itemSaleInfo.onsalePercent / 100) }} USD</div>
        </div>
        <div class="button pt-10 pb-5 flex text-gray-500 items-center justify-center"><span
            data-v-45761ad8="">View Item Details</span>
          <svg class="w-6 h-6 opacity-50 ml-3" fill="currentColor" viewBox="0 0 20 20"
               xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd"
                  d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z"
                  fill-rule="evenodd"></path>
          </svg>
        </div>
        <div class="quality-bar"></div>
      </div>
    </a>
    <!---->
  </div>

</template>

<script>
import SearchUtil from "../../util/SearchUtil.vue";
import {getCurrentInstance, onBeforeMount, onMounted, ref} from "vue";
import {useRouter} from "vue-router";
import sendRoutePath from "../../../hooks/sendRoutePath.js";

export default {
  name: "ExtrasRoute",
  setup() {
    let list = ref('')
    let http = getCurrentInstance().appContext.config.globalProperties.$http;
    const router = useRouter()

    function goToDetail(id) {
      router.push({
        // 目标路由
        name: 'detail',
        params: {
          //示例数据
          id: id
        }
      })
    }

    async function getCratesList() {
      const {
        data: result
      } = await http.get(`fantang/webstore/api/category/extras`)

      list.value = result.data
    }

    onMounted(() => {
      getCratesList()

    })

    onBeforeMount(() => {
      sendRoutePath()
    })

    return {
      goToDetail,
      useRouter,
      getCratesList,
      list
    }
  },
  components: {SearchUtil}
}
</script>

<style scoped>
/*你敢动一个我样式就敢烂，不要纠结为什么这么写，生效了就是好代码*/
.package {
  display: grid;
  grid-template-rows: auto 1fr;
  padding-bottom: 6px;
  position: relative;
}


.image {
  padding: 40px 0 0;
  height: 260px;
  box-sizing: content-box;
}

.packages img {
  margin: auto;
  position: relative;
  width: 300px;
}

.bg-block {
  z-index: 0;
  position: absolute;
  top: 100px;
  left: 0;
  right: 0;
}

.quality-bar {
  height: 6px;
  background: #EB4BE5;
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
}

</style>