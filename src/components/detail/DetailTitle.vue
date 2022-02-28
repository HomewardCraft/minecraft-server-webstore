<template>
  <div class="fontcolor-white">
    {{ amount }}x {{ itemName }}
  </div>
</template>

<script>
export default {
  name: "DetailTitle",
  props: ['name', 'amount'],
  data() {
    return {
      itemName: this.name,

    }
  }
}
</script>

<style scoped>

</style>