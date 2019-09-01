<template>
  <LargeBox header="ログイン">
    <LargeBoxForm
      action="/login"
      method="post"
    >
      <div class="register-form-header">
        メールアドレスで登録
      </div>
      <input
        name="username"
        class="register-form-mail"
        type="text"
        placeholder="ユーザー名"
      >
      <input
        name="password"
        class="register-form-mail"
        type="password"
        placeholder="パスワード"
      >
      <button
        class="register-form-submit"
        type="submit"
      >
        ログイン
      </button>
    </LargeBoxForm>
  </LargeBox>
</template>

<script>
import LargeBox from '../component/LargeBox'
import LargeBoxForm from '../component/LargeBoxForm'
export default {
  name: 'Login',
  components: { LargeBoxForm, LargeBox }
}
</script>

<style scoped>

</style>
