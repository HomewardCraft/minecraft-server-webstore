<template>

  <div>

    <div class="firstline">
      <span id="grid">
        <wshowplayer></wshowplayer>
        <span class = "mmm"></span>
      </span>
    </div>

    <div class = "divsec">
      <span class = "secondline">
      Arcane Homeward, A Untitle network product.
      <br>
      We are in no way affiliated with or endorsed by Mojang, AB.
    </span>

    </div>


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

.divsec {
  background-color: #f6bc21;
}

/*footer的杂项菜单，不重要*/
.mmm{
  display: block;
  height: 50px;
  text-align: center;
}

#grid {
  margin:auto;
  padding-left: 100px;
  width: 1000px;
  display: grid;
  grid-template-columns: repeat(2, 500px);
  grid-gap: 10px;
}

div {
}

.secondline{

  color: #4a390a;


  margin:auto;
  padding: 20px 0;

  width: 1000px;
  height: 40px;
  display: block;
  background-color: #f6bc21;
}

.firstline {
  height:20%;
  position: relative;
  display: block;
  background-color: #e8a11a;

}


</style>