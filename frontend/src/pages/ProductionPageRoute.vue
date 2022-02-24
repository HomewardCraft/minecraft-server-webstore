<template>
  <div>
    这是一个呼呼 {{$route.params.id}} {{$route.params.originPrice}} {{$route.params.currentPrice}} {{$route.params.name}}
  </div>
</template>

<script>
export default {
  name: "ProductionPageRoute"
}
</script>

<style scoped>

div{
  color:white;
}

</style>