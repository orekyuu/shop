<template>
  <LargeBox header="サークル登録">
    <Form
      action="/circle/registration"
      method="post"
    >
      <ThreeColumnFormRow
        label="サークル名"
        :help-texts="[]"
      >
        <input
          name="name"
          type="text"
          :value="formModel.name"
          :class="{error: fieldError.name}"
        >
        <FromErrorMessages :error="fieldError.name" />
      </ThreeColumnFormRow>

      <ThreeColumnFormRow
        label="ユーザーサポート用メールアドレス"
        :help-texts="['(半角英数字)', '携帯メールは使用できません', '購入者からの問い合わせの際に公開されます']"
      >
        <input
          name="supportMail"
          type="email"
          :value="formModel.supportMail"
          :class="{error: fieldError.supportMail}"
        >
        <FromErrorMessages :error="fieldError.supportMail" />
      </ThreeColumnFormRow>

      <ThreeColumnFormRow
        label="公式サイト"
        :help-texts="['(半角英数字)']"
      >
        <input
          name="homepage"
          type="url"
          :value="formModel.homepage"
          :class="{error: fieldError.homepage}"
        >
        <FromErrorMessages :error="fieldError.homepage" />
      </ThreeColumnFormRow>
      <button
        class="register-form-submit"
        type="submit"
      >
        サークル登録
      </button>
    </Form>
  </LargeBox>
</template>

<script>
import LargeBox from '../../component/LargeBox'
import ThreeColumnFormRow from '../../component/ThreeColumnFormRow'
import FromErrorMessages from '../../component/FromErrorMessages'
import Form from '../../component/Form'
export default {
  name: 'CircleRegistration',
  components: { Form, FromErrorMessages, ThreeColumnFormRow, LargeBox },
  data () {
    return {
      formModel: window.initialData.circleRegistrationForm.form
    }
  },
  computed: {
    form () {
      return window.initialData.circleRegistrationForm
    },
    fieldError () {
      return this.form.fieldError
    }
  }
}
</script>

<style scoped>

</style>
