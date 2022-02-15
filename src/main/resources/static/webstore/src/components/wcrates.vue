<template>
  <div class="bg">
    <span>
      Crates
    </span>
    <div class="img">
    </div>
  </div>
</template>

<script>
export default {
  name: "wcrates"

}
</script>

<style scoped>

span {
  margin: 0;
  text-align: left;
  padding: 30px;
  float: right;
  font-size: 28px;
  font-weight: bold;
  color: #FFFFFF;
}

.img{
  background-image: url(../assets/crates.png);
  background-position: bottom;
  background-repeat: no-repeat;
  width: 430px;
  height: 440px;
  display: block;
}
.bg{
  background-color: #df312a;
  background-size: 100%;
  width: 430px;
  height: 480px;
  display: block;
  text-align: center;
  margin-right: 15px;
  margin-left: 15px;
  border: 1px solid transparent;
}
</style>