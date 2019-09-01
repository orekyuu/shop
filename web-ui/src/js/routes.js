import VueRouter from 'vue-router'
import Home from './page/Home'
import SendMail from './page/accounts/registration/SendMail'
import AccountRegistration from './page/accounts/registration/AccountRegistration'
import InvalidTokenError from './page/accounts/registration/InvalidTokenError'

const routes = [
  { path: '/home', component: Home },
  { path: '/accounts/registration', component: AccountRegistration },
  { path: '/accounts/registration/mail', component: SendMail },
  { path: '/accounts/registration/invalid_token', component: InvalidTokenError }
]

export default new VueRouter({
  mode: 'history',
  routes
})
