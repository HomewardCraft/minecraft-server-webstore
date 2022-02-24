<template>
  <div class = "main mt-8">
    <div class="grid lg:grid-cols-3 gap-12">
      <!--    这是一个呼呼 {{ $route.params.id }} {{ $route.params.originPrice }} {{ $route.params.currentPrice }}-->
      <!--    {{ $route.params.name }}-->
      <div class="info lg:col-span-2">
        <h3 class="package-title font-bold text-5xl text-white mb-4">
          Slot Rune
        </h3>
        <div class="price font-extrabold mb-6">
          <div class="discount line-through italic text-gray-700">$3.99 USD</div>
          <div class="final text-2xl text-yellow-400">$3.59 USD</div>
        </div>
        <div class="description content-wrap"><p>Unlock the ultimate enchanting potential for your tool, using slot runes!
          These powerful runes will add an additional slot for enchantments to your tools.</p>
          <p>Once a purchase has been made, you will receive the slot rune in-game shortly after. Use an anvil to combine
            it with any of your tools!</p></div>
      </div>
      <div class="info">
        <div class="bg-gray-800 border border-light px-4 py-10 mb-6"><img
            src="//dunb17ur4ymx4.cloudfront.net/packages/images/31894a0afe0c182aa24e9dc47654a9107dc76fdc.png"
            draggable="false" alt="Slot Rune" class="max-w-full mx-auto"></div><!----><!---->
        <div>
          <div class="bg-gray-900 border border-lighten py-4 px-5 text-center mt-4 text-gray-500 font-bold">
            <svg class="w-12 h-12 opacity-50 mx-auto mb-2" viewBox="0 0 640 512" fill="currentColor">
              <path
                  d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"></path>
            </svg>
            <div class="lg text-lg leading-tight pb-3">Enter username to purchase</div>
            <div class="sm opacity-75">You need to enter your Minecraft username before you can purchase this item!</div>
          </div>
          <button
              class="flex justify-center w-full text-gray-500 items-center bg-btn text-btn-text border border-lighten py-4 uppercase font-extrabold tracking-wide transition-all transform duration-150 ease-in-out opacity-75 focus:outline-none focus:scale-90': cooldown }">
            <svg class="w-6 h-6 opacity-75 mr-2" viewBox="0 0 640 512" fill="#b05da3">
              <path
                  d="M224 256c70.7 0 128-57.31 128-128S294.7 0 224 0C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3C0 496.5 15.52 512 34.66 512h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304zM616 200h-48v-48C568 138.8 557.3 128 544 128s-24 10.75-24 24v48h-48C458.8 200 448 210.8 448 224s10.75 24 24 24h48v48C520 309.3 530.8 320 544 320s24-10.75 24-24v-48h48C629.3 248 640 237.3 640 224S629.3 200 616 200z"></path>
            </svg>
            <span class = "enteruser">Enter Username</span>
          </button>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: "ProductionPageRoute",
  methods: {

  },
  mounted()  {
    console.log(this.$route.params.id) //打印当前物品id

    //TODO 使用这个ID查询数据库的物品，返回价格，打折以及图片和介绍

  }
}
</script>

<style scoped>

@import "./../assets/css/productroute.css";



.package-title {
  margin-top: 0px;
}

.enteruser{
  font-weight: 800;
  color: #96428e;
}


</style>