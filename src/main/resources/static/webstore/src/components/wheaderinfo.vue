<template>
  <div class = "rinfo">

    <tr>
      <th class = "a">
        <div class="info">kkk.fantang.cc</div>
      </th>
      <th class = "a">
        <div class="number">217</div>
      </th>

      <th class = "b" >
        <div class="infodc">JOIN DISCORD</div>
      </th>
      <th  class = "b">
        <div class="numberdc">7887+</div>
      </th>
    </tr>


  </div>

</template>

<script>
export default {
  name: "wheaderinfo"
}
</script>

<style scoped>


.rinfo{
  position:relative;
  margin-left: 30px;
}

th:hover {

  opacity: 0.8;

}

.number {
  color: #FFFFFF;
  background-color: #bd6836;
  border-style: solid;
  border-color: #d09572;
  border-width: 1px;
  border-left-width: 0px;
  padding-left: 8px;
  padding-right: 8px;
}

.numberdc {
  color: #FFFFFF;
  background-color: #5662c5;
  border-style: solid;
  border-color: #8991d6;
  border-width: 1px;
  border-left-width: 0px;
  padding-left: 8px;
  padding-right: 8px;
}
.infodc {
  padding-left: 15px;
  padding-right: 15px;
  width: auto;
  /*控制两个展示框之间的距离*/
  margin-left: 20px;


  font-weight: bold;
  color: #fdfdfd;
  text-transform: uppercase;

  background-color: #3641a8;
  border-style: solid;
  border-color: #727ac1;
  border-width: 1px;
}

div {
  line-height: 30px;
  font-size: 16px;
  text-align: center;
  height: 30px;
  display: block;
  border: 1px solid transparent;
}

.info {
  padding-left: 15px;
  padding-right: 15px;
  width: auto;
  /*控制两个展示框之间的距离*/
  margin-left: 20px;


  font-weight: bold;
  color: #FFFFFF;
  text-transform: uppercase;

  background-color: #aa5728;
  border-style: solid;
  border-color: #c28968;
  border-width: 1px;
}

</style>