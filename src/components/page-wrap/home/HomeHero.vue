<template>
  <div class="hero mb-56">
    <div data-page="home" class="page-bg"></div>
    <nav class="nav mb-2 z-40 mt-5">
      <div class="container mx-auto">
        <div class="mobile-toggle ml-auto block md:hidden p-8">
          <div class="bar"></div>
          <div class="bar"></div>
          <div class="bar"></div>
        </div>
        <div class="menu-collapse flex md:items-center flex-col md:flex-row md:justify-center">
          <ul class="md:flex md:justify-center md:items-center md:mb-3 md:-mx-3 uppercase font-bold tracking-widest text-lg text-shadow ">
            <li class="mx-3 mb-3 md:mb-0"><a href="/"
                                             class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-home hover:border-lighten bg-nav-home border-lighten"><span
                class="block">Home</span></a></li>
            <li class="mx-3 mb-3 md:mb-0"><a href="/blog"
                                             class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-blog hover:border-lighten"><span
                class="block">Blog</span></a></li>
            <li class="mx-3 mb-3 md:mb-0"><a href="/rules"
                                             class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-help hover:border-lighten"><span
                class="block">Rules</span></a></li>
            <li class="mx-3 mb-3 md:mb-0"><a href="https://store.originrealms.com"
                                             class="flex items-center px-5 py-3 md:py-1 transition duration-200 bg-red-600/80 text-white hover:bg-red-500 border border-lighten">Store</a>
            </li>
          </ul>
        </div>
      </div>
    </nav> <!---->
    <div class="logo mx-auto mt-32">
      <div class="img"></div>
    </div>
    <div class="cursor-pointer group inline-block mx-auto">
      <div
          class="server mx-auto mt-8 font-bold text-sm uppercase flex flex-col justify-center items-center lg:items-stretch lg:flex-row transition-opacity duration-150 ease-in-out group-hover:opacity-75">
        <div class="server bg-ip-900 tracking-widest py-2 px-3 border border-lighten shadow-ip">
          play.originrealms.com
        </div>
        <div
            class="flex items-center ml-auto px-3 tracking-wide bg-ip-800 text-ip-400 -ml-px border shadow-ip-count border-lighten text-sm">
          412
        </div>
      </div>
      <div
          class="tooltips font-extrabold text-sm text-center tracking-widest uppercase mt-4 text-white relative text-shadow-md">
        <p class="top-0 left-0 right-0 opacity-1 transition-all duration-200 ease-in-out transform relative">Click
          to Copy</p>
        <p class="top-0 left-0 right-0 opacity-1 transition-all duration-200 ease-in-out transform absolute opacity-0 -translate-y-2">
          Copied to Clipboard</p></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeHero"
}
</script>

<style scoped>

</style>