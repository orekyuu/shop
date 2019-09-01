<template>
  <div class="form-row-wrapper">
    <div class="form-label-wrapper">
      <label>{{ label }}</label>
    </div>
    <div class="form-body-wrapper">
      <slot />
    </div>
    <div class="form-body-help">
      <ul>
        <li
          v-for="text in helpTexts"
          :key="text"
        >
          {{ text }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ThreeColumnFormRow',
  props: {
    label: { type: String, required: true },
    helpTexts: { type: Array, required: false, default: () => [] }
  }
}
</script>

<style scoped>

</style>
