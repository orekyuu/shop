<template>
  <LargeBox header="新規登録">
    <div v-if="invalidTokenError">
      無効なリンクです。はじめから新規登録を行ってください。
    </div>
    <LargeBoxForm
      v-else
      action="/accounts/registration"
      method="post"
    >
      <div class="register-form-header">
        ユーザー情報
      </div>

      <input
        name="token"
        type="hidden"
        :value="registrationFormModel.token"
      >
      <input
        v-model="registrationFormModel.username"
        name="username"
        class="register-form-mail"
        type="text"
        placeholder="ユーザー名"
      >
      <FromErrorMessages :error="registrationForm.fieldError.username" />
      <input
        v-model="registrationFormModel.password"
        name="password"
        class="register-form-mail"
        type="password"
        placeholder="パスワード"
      >
      <FromErrorMessages :error="registrationForm.fieldError.password" />
      <input
        v-model="registrationFormModel.passwordConfirm"
        name="passwordConfirm"
        class="register-form-mail"
        type="password"
        placeholder="パスワード(確認)"
      >
      <FromErrorMessages :error="registrationForm.fieldError.passwordConfirm" />
      <p v-if="!passwordConfirmValidation">
        パスワードが一致しない
      </p>

      <button
        class="register-form-submit"
        type="submit"
      >
        登録
      </button>
    </LargeBoxForm>
  </LargeBox>
</template>

<script>
import LargeBox from '../../../component/LargeBox'
import LargeBoxForm from '../../../component/LargeBoxForm'
import FromErrorMessages from '../../../component/FromErrorMessages'

export default {
  name: 'AccountRegistration',
  components: { FromErrorMessages, LargeBoxForm, LargeBox },
  data () {
    return {
      registrationFormModel: window.initialData.registrationForm.form
    }
  },
  computed: {
    registrationForm () {
      return window.initialData.registrationForm
    },
    passwordConfirmValidation () {
      return this.registrationFormModel.password === this.registrationFormModel.passwordConfirm
    },
    invalidTokenError () {
      return window.initialData.invalidTokenError
    }
  }
}
</script>

<style scoped>

</style>
