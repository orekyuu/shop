<template>
  <form
    :action="action"
    :method="method"
    class="register-account-send-mail-form"
  >
    <input
      type="hidden"
      :value="csrf"
      name="_csrf"
    >
    <slot />
  </form>
</template>

<script>
export default {
  name: 'Form',
  props: {
    action: { type: String, required: true },
    method: { type: String, required: true }
  },
  computed: {
    csrf () {
      return document.getElementById('_csrf').attributes.value.value
    }
  }
}
</script>

<style scoped>

</style>
