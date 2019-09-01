<template>
  <div>
    <p
      v-for="e in error"
      :key="e"
      class="error-message"
    >
      {{ e }}
    </p>
  </div>
</template>

<script>
export default {
  name: 'FromErrorMessages',
  props: {
    error: { type: Array, required: false, default: () => [] }
  }
}
</script>

<style scoped>

</style>
