<template>
  <div class="details">
    <section id="basket" class="mb-10"><h4 class="font-bold text-white text-2xl mb-4">Your Basket <b
        class="text-gray-500 text-base">(1)</b></h4>
      <form>
        <div v-for="item in itemsInCart" :key="item.id"
             class="packages">
          <div class="package bg-gray-800 border border-lighten flex justify-between mb-5 relative group">
            <div class="info text-sm font-bold px-5 py-3">
              <div class="title text-gray-500 text-lg mb-1">{{ item.name }}</div>
              <div class="price">${{ item.price }} USD</div>
            </div>
            <div class="details flex items-center">
              <label for="quantity[4248027]"
                     class="sr-only">Quantity</label>
              <input
                name="quantity[4248027]" id="quantity[4248027]" type="number" min="1" max="99"
                :value = item.quantity
                class="text-white w-8 mr-5 block text-center bg-gray-800 border border-lighten text-gray-500 font-bold text-sm py-1 transition-colors duration-150 ease-in-out focus:outline-none focus:border-piston appearance-none">
              <button
                  class="flex items-center absolute top-0 right-0 p-2 bg-red-500 transition-all ease-in-out duration-150 transform -translate-y-0 translate-x-1/2 pointer-events-none opacity-0 group-hover:opacity-100 rounded-full group-hover:pointer-events-auto cursor-pointer group-hover:-translate-y-1/2 hover:bg-red-400 focus:outline-none">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 352 512" class="h-4 w-4" fill="currentColor">
                  <path
                      d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path>
                </svg>
              </button>
            </div>
          </div>
        </div>


        <div class="updated text-right transition-opacity duration-150 ease-in-out">
          <button type="submit"
                  class="inline-flex items-center py-2 px-3 text-sm bg-btn border border-lighten shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 focus:outline-none">
            Update Cart
          </button>
        </div>
      </form>
    </section>
    <section id="coupons" class="mb-10 relative"><h4 class="font-bold text-white text-xl mb-6">Got a giftcard?</h4>
      <form class="form-row flex"><label for="giftcode" class="sr-only">Giftcard / Coupon Number</label><input
          name="coupon" id="giftcode" autocomplete="off" type="text"
          class="appearance-none bg-gray-800 border border-lighten font-bold block w-full py-2 px-5 transition-colors duration-150 ease-in-out focus:outline-none focus:border-piston"
          placeholder="XXXX • XXXX • XXXX">
        <button
            class="px-3 bg-blue-600 border border-lighten transition-colors duration-150 ease-in-out hover:bg-blue-400 focus:outline-none"
            type="submit">
          <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd"
                  d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                  clip-rule="evenodd"></path>
          </svg>
        </button>
      </form>
      <div class="coupons flex flex-wrap mt-5"></div>
      <div
          class="loader absolute inset-0 bg-black-80 grid items-center justify-center leading-none transition-opacity duration-200 ease-in-out pointer-events-none opacity-0">
        <img src="https://assets.originrealms.com/static/img/animated-icon.gif" class="animate-pulse w-10 mx-auto"
             alt="Loading">
        <div class="load-text font-bold uppercase text-xl animate-track">Loading...</div>
      </div>
    </section>
    <section id="total">
      <div class="flex items-end justify-between font-bold leading-none">
        <div class="text-lg opacity-75">Total</div>
        <div class="text-2xl text-white">$7.18 USD</div>
      </div>
    </section>
  </div>
</template>

<script setup>
import {reactive} from "vue";
import {getCurrentInstance} from "vue";

let GLOBAL_DATA = reactive(getCurrentInstance().appContext.config.globalProperties.$store)
let itemsInCart = reactive(GLOBAL_DATA.state.cart.items)


</script>


<script>
export default {
  name: "checkoutdetails"
}
</script>

<style scoped>

</style>