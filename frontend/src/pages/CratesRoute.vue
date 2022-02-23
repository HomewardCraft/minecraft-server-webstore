<!-- 与CrateShowcase关联, 以下为摆烂代码, 马上清掉 -->
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
            <div class="right-info-inner">
              <div class="right-info-amount">20x</div>
              <div class="right-info-price">49.99</div>
              <div class="right-info-price2">44.99</div>
              <div class="cnm">
                <svg class="leftfff" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z" clip-rule="evenodd"></path>
                </svg>
                <div class="ddf">
                  <span>buy now</span>
                </div>
              </div>
            </div>
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

.leftfff {
  width: 1.25rem;
  height: 1.25rem;
  margin-right: 0.75rem;
  display: block;
  vertical-align: middle;
}

body {
  background: #000;
  color: #fff;
  font-family: proxima-nova, sans-serif;
}

.ddf {
  width: 1.25rem;
  height: 1.25rem;
  margin-right: 0.75rem;
}

.cnm {
  padding-top: 0.75rem;
  justify-content: center;
  align-items: center;
  display: flex;
}

.right-info-price2 {
  opacity: .5;
}

.right-info-price {
  opacity: .25;
  text-decoration: line-through;
  font-size: .875rem;
  line-height: 1.25rem;
}

.right-info-amount {
  font-size: 1.5rem;
  line-height: 2rem;
  padding-bottom: 0.25rem;
}

.right-info-inner {
  padding-top: 1.25rem;
  padding-bottom: 1.25rem;
  font-weight: 700;
  text-align: center;
  --tw-bg-opacity: 1;
  background-color: rgba(24,26,27,var(--tw-bg-opacity));
  border-color: #ffffff1a;
  border-right-width: 0;
  border-width: 1px;
  cursor: pointer;
  --tw-translate-x: 0;
  --tw-translate-y: 0;
  --tw-rotate: 0;
  --tw-skew-x: 0;
  --tw-skew-y: 0;
  --tw-scale-x: 1;
  --tw-scale-y: 1;
  transform: translate(var(--tw-translate-x)) translateY(var(--tw-translate-y)) rotate(var(--tw-rotate)) skew(var(--tw-skew-x)) skewY(var(--tw-skew-y)) scaleX(var(--tw-scale-x)) scaleY(var(--tw-scale-y));
  display: block;
}

.right-info {
  position: relative;
  display: grid;
  grid-template-columns: repeat(4,minmax(0,1fr));
  border-style: solid;
  box-sizing: border-box;
  border-width: 0;
  border-color: rgba(229, 231, 235, 1);
  color: #fff;
  background-color: rgba(24, 26, 27, 1);
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