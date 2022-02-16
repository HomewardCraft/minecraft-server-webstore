<template>

  <div>

      <span class="firstline">
      <wshowplayer></wshowplayer>
      </span>

    <span class = "secondline">
      Arcane Homeward, A Untitle network product.
      <br>
      We are in no way affiliated with or endorsed by Mojang, AB.
    </span>

  </div>


</template>

<script>
import wshowplayer from "./wshowplayer"

export default {
  name: "wfooter",
  components: {wshowplayer}
}
</script>

<style scoped>


div {
  margin-top: 100px;
}

.secondline{

  padding-top: 30px;
  padding-left: 450px;

  color: #4a390a;

  position: relative;
  margin: auto;
  width: 100%;
  height: 80px;
  display: block;
  background-color: #f6bc21;
}

.firstline {
  position: relative;
  width: 100%;
  height: 70px;
  display: block;
  background-color: #e8a11a;

}


</style>