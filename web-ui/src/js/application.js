import Vue from "vue"
import VueRouter from 'vue-router'
import { fetchMessages } from "./api"
import App from "./App";

Vue.use(VueRouter);

fetchMessages().then(messages => {
    console.log(messages);
    const app = new Vue({
        el: "#app",
        components: { App },
        template: "<App/>"
    });
});
