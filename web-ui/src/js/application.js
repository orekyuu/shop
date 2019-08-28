import Vue from "vue"
import ProductList from "./component/ProductList";

Vue.component("ProductList", ProductList);

function mountComponents(selector, tag) {
    const items = document.querySelectorAll(selector);
    items.forEach((el, _) => {
        const vm = new Vue({
            el: el,
            template: `<${tag}/>`
        });
    });
}

mountComponents(".product-list", "ProductList");
