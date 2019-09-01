<template>
  <div class="floor-content-wrapper">
    <div class="left">
      <slot name="left" />
    </div>
    <div class="center">
      <slot name="center" />
    </div>
    <div class="right">
      <slot name="right" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'ThreeColumn'
}
</script>

<style scoped>

</style>
