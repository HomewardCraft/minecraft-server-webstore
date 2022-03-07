<template>
  <div class="amount">
    <div class="progress-bar">
      <!-- 不能写死 -->
      <div class="percent mb-2">Your Cart: 25%</div>
      <div class="progress">
        <div class="total" style="width: 25%"/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProgressBar"
}
</script>

<style scoped>
@screen lg {
  .progress-bar .progress {
    width: 140px;
  }
}

.progress-bar .progress {
  background: rgba(255,255,255,.2);
}

.progress-bar .total {
  background: #fff;
  height: 6px;
}
</style>