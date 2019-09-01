import VueRouter from 'vue-router'
import Home from './page/Home'
import SendMail from './page/accounts/registration/SendMail'
import AccountRegistration from './page/accounts/registration/AccountRegistration'
import InvalidTokenError from './page/accounts/registration/InvalidTokenError'
import Login from './page/Login'
import CircleRegistration from './page/circle/CircleRegistration'
import CircleRegistrationComplete from './page/circle/CircleRegistrationComplete'

const routes = [
  { path: '/home', component: Home },
  { path: '/login', component: Login },
  { path: '/accounts/registration', component: AccountRegistration },
  { path: '/accounts/registration/mail', component: SendMail },
  { path: '/accounts/registration/invalid_token', component: InvalidTokenError },
  { path: '/circle/registration', component: CircleRegistration },
  { path: '/circle/registration/complete', component: CircleRegistrationComplete }
]

export default new VueRouter({
  mode: 'history',
  routes
})
