<template>
  <div class="form p-10 lg:col-span-2">
    <form>
      <input class="bg-gray-800 text-white block py-2 px-4 w-full mb-5 border border-light text-center transition-colors duration-150 ease-in-out focus:border-yellow-400 focus:outline-none" autocomplete="off" pattern="^[A-Za-z0-9_]{1,16}$" spellcheck="false" maxlength="16"/>
      <button class="bg-btn border border-lighten py-2 px-4 shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 text-center w-full focus:outline-none" type="submit" name="submit">Continue to Store</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginInput"
}
</script>

<style scoped>
</style>