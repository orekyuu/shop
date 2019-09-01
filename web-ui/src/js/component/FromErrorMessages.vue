<template>
  <div>
    <p
      v-for="e in error"
      :key="e"
      class="error"
    >
      {{ e }}
    </p>
  </div>
</template>

<script>
export default {
  name: 'FromErrorMessages',
  props: {
    error: { type: Array, required: true }
  }
}
</script>

<style scoped>

</style>
