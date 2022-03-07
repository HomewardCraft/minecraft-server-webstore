<template>
  <div class="help-box px-6 lg:px-10 flex items-center flex-row lg:flex-row">
    <div class="ghost"></div>
    <div class="text py-6 text-center lg:text-left lg:w-1/2 lg:ml-8">
      <div class="text-xl font-bold pb-2">Need help?</div>
      <div class="text-lg pb-4">Not sure where to start, or need some friendly assistance? Our team is here for you from start to finish!</div>
      <div class="button inline-flex items-center font-bold cursor-pointer transition-opacity duration-150 ease-in-out hover:opacity-75 py-2 px-4 rounded-lg border border-lighten">
        <span>Click for more info</span>
        <svg class="w-5 h-5 opacity-50 ml-3" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
          <path fill-rule="evenodd" d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z" clip-rule="evenodd"/>
        </svg>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HelpSection"
}
</script>

<style scoped>
.help-box {
  background: linear-gradient(180deg, rgba(255, 81, 245, .85) 0%, rgba(255, 81, 221, .8) 100%);
  box-shadow: #fff3 0 0 0 2px inset;
}

.help-box .ghost {
  height: 210px;
  background: center/cover no-repeat url(./src/assets/images/homepage/ghost.png);
  background-size: 185px auto;
  min-width: 210px;
}
</style>