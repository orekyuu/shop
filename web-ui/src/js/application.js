import Vue from 'vue'
import VueRouter from 'vue-router'
import { fetchMessages } from './api'
import App from './App'

Vue.use(VueRouter)

fetchMessages().then(messages => {
  const initialDataElement = document.getElementById("initialData");
  const initialData = initialDataElement.dataset.initialData
  if (initialData == null) {
    throw new Error("invalid initialData")
  }
  window.initialData = JSON.parse(initialData);
  window.messages = messages

  const app = new Vue({
    components: { App },
    template: '<App/>'
  })
  app.$mount('#app')
}).catch((e) => console.error(e))
