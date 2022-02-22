<!-- 主页的crate的商品界面 -->
<template>
  <div class="bg" :class="bgvue" @mouseover="dark()" @mouseout="origin()">
    <span>
      Crates
    </span>
    <div class="img" :class="hover">
    </div>
  </div>
</template>


<script>
export default {
  name: "HomepageCrates",
  data() {
    return {
      hover: '',
      bgvue: ''
    }

  },
  methods: {
    dark() {
      this.hover = 'hover'
      this.bgvue = 'turndark'
    },
    origin() {
      this.hover = ''
      this.bgvue = ''
    }
  }
}
</script>


<style scoped>
div{
  margin-left: -20px;
}

.turndark{
  filter:brightness(0.8);
}

span {
  margin: 0;
  text-align: left;
  padding: 30px;
  float: right;
  font-size: 28px;
  font-weight: bold;
  color: #FFFFFF;
}

.img {
  background-image: url(../../assets/crates.png);
  background-position: bottom;
  background-repeat: no-repeat;
  width: 430px;
  height: 440px;
  display: block;
}

.bg {
  background: linear-gradient(45deg, #da1728, #e8602e);
  background-size: 100%;
  width: 500px;
  height: 500px;
  display: block;
  text-align: center;
  margin-right: 10px;
  margin-left: 15px;
  border: 1px solid transparent;
}

/*过期
/*.img:hover {*/
/*  background-image: url(../assets/crates_hover.png);*/
/*}*/

.hover {
  background-image: url(../../assets/crates_hover.png);

}
</style>