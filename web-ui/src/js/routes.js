import VueRouter from 'vue-router'
import Home from "./page/Home";

const routes = [
    { path: "/home", component: Home },
];

export default new VueRouter({
    mode: 'history',
    routes
});