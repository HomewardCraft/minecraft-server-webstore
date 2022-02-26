<template>
  <div class="width-auto flex justify-center items-center p-12 progressbar">
    <div class="progressbar">
      <div class="mb-0.5">
        Your Cart: 10%
      </div>
      <div class="progress">
        <div class="total"  style="width: 10%"/>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "ProgressComponent"
}
</script>

<style scoped>

.progressbar .progress {
  width: 140px;
}

.progressbar .progress {
  background: rgba(255,255,255,.2);
}

.progressbar .total {
  background: #fff;
  height: 6px;
}

.progressbar .progress {
  background: rgba(255,255,255,.2);
}
</style>