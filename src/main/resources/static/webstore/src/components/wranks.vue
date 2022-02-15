<template>
  <div class="bg" :class="bgvue" @mouseover="dark()" @mouseout="origin()">
    <span>
      Ranks
    </span>
    <div class="img" :class="hover">
    </div>
  </div>
</template>


<script>
export default {
  name: "wranks",
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
  margin-top:15px;
  background-image: url(../assets/ranks.png);
  background-repeat: no-repeat;
  background-size: 35%;
  width: 100%;
  height: 94%;
  display: block;
}

.bg {
  border: 2px solid #9d66ac;
  background-color: #650f7e;
  background-size: 100%;
  width: 570px;
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
  background-image: url(../assets/ranks_hover.png);

}



</style>