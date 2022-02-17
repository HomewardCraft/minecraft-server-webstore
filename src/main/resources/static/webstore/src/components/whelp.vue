<template>
  <div>

      <span class="uni">


        <span class="nh">
          Need help?
        </span>

        <br>
        <span>
          Not sure where to start, or need some friendly
        </span>
        <br>
        <span>
          assistance? Our team is here for you from start to finish!

        </span>

<br>
        <span class="help">
          Click for more info  →
        </span>

      </span>


  </div>
</template>

<script>
export default {
  name: "whelp"
}
</script>

<style scoped>
div {
  background-image: url(../assets/ghost.png);
  background-position-x: 40px;
  background-position-y: -50px;
  display: block;
  background-repeat: no-repeat;
  background-size: 20%;
  width: 20%;
  height: 80%;
  /*缺少一个颜色渐变*/
}

.nh {
  font-size: 24px;
  font-weight: bold;
}

.uni {
  margin-top: 40px;
}

.help {
  margin-top: 20px;
  padding: 10px;
  font-size: 14px;
  color: white;
  border-style: solid;
  border-color: rgb(140, 190, 193);
  border-width: 1px;
  border-radius: 6px;
  font-weight: bold;
}

.help:hover {
  filter: brightness(0.9);
}

span {
  margin-left: 150px;
  text-align: left;
  float: left;
  font-size: 15px;
  color: #FFFFFF;
}

div {
  margin: auto;
  width: 1100px;
  height: 200px;
  display: block;
  text-align: center;
  border: 3px solid #5685a7;
  background-color: #1e5c88;

}
</style>