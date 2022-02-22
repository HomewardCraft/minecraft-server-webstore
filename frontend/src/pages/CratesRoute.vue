<!-- crates的商品的页面 -->
<template>
  <div>
    <div class="title">Crates</div>
    <div class="container">
      <div class="left-background">
        <div v-if="show" class="crate" @mouseover="show = false"/>
        <div v-else class="crate-open" @mouseout="show = true"></div>
        <div class="right-background">
          <div class="right-main-title">Cosmetic Crates</div>
          <div class="right-info">
            <div class=""></div>
          </div>
        </div>
      </div>
    </div>
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
      // this.state = 'crate-open'
      this.show = false
    },
    origin() {
      // this.state = 'crate'
      this.show = true
    }
  }
}
</script>

<style scoped>

body {
  background: #000;
  color: #fff;
  font-family: proxima-nova, sans-serif;
}

.right-info {
  position: relative;
  display: grid;
  grid-template-columns: repeat(4,minmax(0,1fr));
  border-style: solid;
  box-sizing: border-box;
  border-width: 0;
  border-color: rgba(229, 231, 235, 1);
}

.right-background {
  grid-column: span 3;
  padding: 2.5rem
}

.right-main-title {
  text-align: left;
  font-weight: 700;
  font-size: 1.875rem;
  line-height: 2.25rem;
  margin-bottom: 1.5rem;
  color: #fff;
}

.left-background {
  margin-top: 4rem;
  margin-bottom: 3rem;
  background-color: rgba(13, 14, 15, 1);
  border-width: 1px;
  border-style: solid;
  border-color: #ffffff1a;
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
}

.crate, .crate-open {
  max-width: 100%;
  margin-left: 1.5rem;
}

.crate, .crate-open {
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