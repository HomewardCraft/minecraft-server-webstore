<template>
  <div>

      <span class="uni">
        <span>
          Happy
        </span>

        <br>
        <span>
          Arcane Year !
        </span>

        <br>
        <span class="discount">
          25% OFF STORE SALE
        </span>

      </span>


  </div>
</template>

<script>
export default {
  name: "wsale"
}
</script>

<style scoped>
.uni {

  padding: 60px;

}

.discount {
  padding-top: 10px;
  font-size: 24px;
  color: #fbdd81;
}

span {
  margin: 0;
  text-align: left;
  padding-left: 30px;
  float: left;
  font-size: 48px;
  font-weight: bold;
  color: #FFFFFF;
  text-shadow: 2px 2px 2px #000000;
}

div {
  margin: auto;
  width: 1100px;
  height: 300px;
  display: block;
  text-align: center;
  border: 3px solid #9d66ac;
  background-color: #833f96;

}
</style>