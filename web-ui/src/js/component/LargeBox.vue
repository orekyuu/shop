<template>
  <div class="large-box">
    <h1 class="large-box-header">
      {{ header }}
    </h1>
    <div class="large-box-body">
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  name: 'LargeBox',
  props: {
    header: { type: String, required: true }
  }
}
</script>

<style scoped>

</style>
