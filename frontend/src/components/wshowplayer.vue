<template>

  <div class="grid">
    <div>

      <span class = "blockone">
      KKK.FANTANG.CC
      </span>

    </div>
    <div>

      <span class = "blocktwo">
      297
      </span>

    </div>
  </div>


</template>

<script>



export default {
  name: "wshowplayer",
}
</script>

<style scoped>



.grid {

  /*此行暂时摆烂，不应该从组件中调整位置*/
  padding-top: 10px;
  padding-bottom: 10px;
  display: grid;
  grid-template-columns: repeat(3, 0fr);

}

.grid:hover{
  filter: brightness(103%);
}

.blocktwo {
  line-height: 40px;
  font-size: 14px;
  text-align: center;
  height: 40px;
  display: block;

  width: 50px;

  font-weight: bold;
  color: #965712;
  text-transform: uppercase;

  background-color: #d88913;

}

.blockone {

  line-height: 40px;
  font-size: 14px;
  text-align: center;
  height: 40px;
  display: block;
  width: 150px;



  font-weight: bold;
  color: #814810;
  text-transform: uppercase;

  background-color: #d48412;

}
</style>