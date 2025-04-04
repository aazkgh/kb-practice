import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
import Products from "../pages/Products.vue";
import Cart from "../pages/Cart.vue";
import ProductDetail from "../pages/ProductDetail.vue";

const router = createRouter({
    history: createWebHistory(),
    routes:  [
        { path: '/', name: 'home', component:Home },
        { path: '/products', name: 'products', component: Products },
        { path: '/products/:id', name: 'productDetail', component: ProductDetail },
        { path: '/cart', name: 'cart', component: Cart },
    ]
})

export default router