<template>
  <LargeBox header="新規登録">
    <div
      v-if="isComplete"
      style="text-align: center"
    >
      メールを送信しました。メールのリンクから登録を行ってください。
    </div>
    <LargeBoxForm
      v-else
      action="/accounts/registration/mail"
      method="post"
    >
      <div class="register-form-header">
        メールアドレスで登録
      </div>
      <input
        name="mail"
        class="register-form-mail"
        type="email"
        placeholder="メールアドレス"
        :value="mailFormModel.mail"
      >
      <FromErrorMessages :error="mailForm.fieldError.mail" />
      <button
        class="register-form-submit"
        type="submit"
      >
        メール送信
      </button>
    </LargeBoxForm>
  </LargeBox>
</template>

<script>
import LargeBox from '../../../component/LargeBox'
import LargeBoxForm from '../../../component/LargeBoxForm'
import FromErrorMessages from '../../../component/FromErrorMessages'
export default {
  name: 'SendMail',
  components: { FromErrorMessages, LargeBoxForm, LargeBox },
  data () {
    return {
      mailFormModel: window.initialData.mailForm.form
    }
  },
  computed: {
    mailForm () {
      return window.initialData.mailForm
    },
    isComplete () {
      return this.$route.query.complete !== undefined
    }
  }
}
</script>

<style scoped>

</style>
