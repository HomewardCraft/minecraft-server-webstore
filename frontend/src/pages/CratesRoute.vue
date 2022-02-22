<!-- crates的商品的页面 -->
<template>
  <div>
    <div class="title">Crates</div>
    <div class="container">
      <div class="background">
        <div class="crate" :class="state" @mouseover="open()" @mouseout="origin()"/>
        <transition name="fade">
          <div class="crate"></div>
        </transition>
      </div>
    </div>

<!--    <button v-on:click="show = !show">-->
<!--      Toggle-->
<!--    </button>-->
<!--    <transition name="fade">-->
<!--      <p v-if="show">hello</p>-->
<!--    </transition>-->
  </div>
</template>

<script>
export default {
  name: "CratesRoute",
  data() {
    return {
      state: '',
      show: true
    }
  },
  methods: {
    open() {
      this.show = !this.show
    },
    origin() {
      this.show = true
    }
  }
}
</script>

<style scoped>
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}


.ease-in-out {
  transition-timing-function: cubic-bezier(.4,0,.2,1);
}


body {
  background: #000;
  color: #fff;
  font-family: proxima-nova, sans-serif;
}

.background {
  margin-top: 4rem;
  margin-bottom: 3rem;
  background-color: rgba(13, 14, 15, 1);
  border-width: 1px;
  border-style: solid;
  border-color: #ffffff1a;
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
}

.crate {
  max-width: 100%;
  margin-left: 1.5rem;
}

.crate {
  min-height: 282px;
  max-width: 320px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

.crate {
  background: url(../../src/assets/crates/cosmetic_crate.png);
  background-position-x: center;
  background-position-y: center;
  background-size: cover;
}

.crate-open {
  background: url(../../src/assets/crates/cosmetic_crate_open.png);
  background-position-x: center;
  background-position-y: center;
  background-size: cover;
}

.title {
  color: rgba(255, 255, 255, 1);
  font-weight: 700;
  text-align: center;
  padding-top: 4rem;
  font-size: 3rem;
  line-height: 1;
}
</style>