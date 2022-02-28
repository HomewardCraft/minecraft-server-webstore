<!-- 这个固定信息没必要编程组件 -->
<template>
  <div class="bt">
    BLOG
  </div>
</template>


<script>
export default {
  name: "HomewardBlog"
}
</script>


<style scoped>
div{
  width: 100px;
  height: 40px;
  display: block;
  text-align: center;
  margin-right: 15px;
  margin-left: 15px;
  border: 1px solid transparent;

}

.bt:hover{
  background-color: #1185d7;
  border-style:solid;
  border-color: #a5cde0;
  border-width:1px;
}
</style>