<template>
  <header class="page-header mb-16">
    <div class="container mx-auto sm:px-10 lg:px-20 flex items-center justify-between">
      <a href="/">
        <img src="https://ba1oretto.com/webstore/images/logo.png" class="max-h-24 sm:h-24 my-6" alt="logo">
      </a>
      <div class="right flex items-end flex-col">
        <nav class="nav mb-2 z-40">
          <div>
            <div class="mobile-toggle ml-auto block md:hidden p-8">
              <div class="bar"></div>
              <div class="bar"></div>
              <div class="bar"></div>
            </div>
            <div class="menu-collapse flex md:items-center flex-col md:flex-row">
              <ul class="md:flex md:justify-center md:items-center md:mb-3 md:-mx-3 uppercase font-bold tracking-widest text-lg text-shadow ">
                <li class="mx-3 mb-3 md:mb-0"><a href="/"
                                                 class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-home hover:border-lighten"><span
                    class="block">Home</span></a></li>
                <li class="mx-3 mb-3 md:mb-0"><a href="/blog"
                                                 class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-blog hover:border-lighten bg-nav-blog border-lighten"><span
                    class="block">Blog</span></a></li>
                <li class="mx-3 mb-3 md:mb-0"><a href="/rules"
                                                 class="flex items-center px-5 py-3 md:py-1 transition duration-200 border border-transparent hover:bg-nav-help hover:border-lighten"><span
                    class="block">Rules</span></a></li>
                <li class="mx-3 mb-3 md:mb-0"><a href="https://store.originrealms.com"
                                                 class="flex items-center px-5 py-3 md:py-1 transition duration-200 bg-red-600-80 text-white hover:bg-red-500 border border-lighten">Store</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="serverbar text-right z-20 uppercase font-bold cursor-pointer hidden md:flex items-center">
          <div
              class="server-wrap server-minecraft flex flex-col relative font-bold text-sm uppercase flex flex-col justify-center items-center lg:items-stretch lg:flex-row transition-opacity duration-150 ease-in-out hover:opacity-80">
            <div class="server bg-ip-900 tracking-widest py-2 px-3 border border-lighten">play.originrealms.com</div>
            <div class="flex items-center px-3 tracking-wide bg-ip-800 text-ip-400 border border-lighten -ml-px">461
            </div>
            <div
                class="tooltip absolute mt-2 right-0 text-xs font-bold uppercase transition-opacity ease-in-out duration-200 text-ip-700 opacity-0"
                style="bottom: -20px;">
              IP Copied!
            </div>
          </div>
          <a href="https://originrealms.com/discord"
             class="server-wrap server-discord ml-4 flex flex-col font-bold text-sm uppercase flex flex-col justify-center items-center lg:items-stretch lg:flex-row transition-opacity duration-150 ease-in-out hover:opacity-80">
            <div class="server bg-discord-900 tracking-widest py-2 px-3 border border-lighten">Join Discord</div>
            <div
                class="flex items-center px-3 tracking-wide bg-discord-800 text-indigo-100-400 border border-lighten -ml-px">
              11,823+
            </div>
          </a></div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "PageHeader"
}
</script>

<script setup>

</script>