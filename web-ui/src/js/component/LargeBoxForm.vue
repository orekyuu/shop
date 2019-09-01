<template>
  <div class="login-form-box-body-inline">
    <Form
      :action="action"
      :method="method"
      class="register-account-send-mail-form"
    >
      <slot />
    </Form>
  </div>
</template>

<script>
import Form from './Form'
export default {
  name: 'LargeBoxForm',
  components: { Form },
  props: {
    action: { type: String, required: true },
    method: { type: String, required: true }
  }
}
</script>

<style scoped>

</style>
