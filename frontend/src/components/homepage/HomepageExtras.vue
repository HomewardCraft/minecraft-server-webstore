<!-- 主页的extra的商品界面 -->
<template>
  <div class="bg" :class="bgvue" @mouseover="dark()" @mouseout="origin()">
    <span>
      Extras
    </span>
    <div class="img" :class="hover">
    </div>
  </div>
</template>


<script>
export default {
  name: "HomepageExtras",
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
  margin:10px;
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
  margin-left: 20px;
  margin-top:50px;
  background-image: url(../../assets/extras.png);
  background-repeat: no-repeat;
  background-size: 35%;
  width: 100%;
  height: 94%;
  display: block;
}

.bg {
  border: 2px solid rgba(255, 255, 255, 0.5);
  background: linear-gradient(45deg, #bd5124, #db9f37);
  background-size: 100%;
  width: 580px;
  height: 240px;
  display: block;
  text-align: center;
  margin-right: 15px;
  margin-left: 15px;
}

/*过期
/*.img:hover {*/
/*  background-image: url(../assets/crates_hover.png);*/
/*}*/

.hover {
  background-image: url(../../assets/extras_hover.png);

}
</style>