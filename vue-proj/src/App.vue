<template>
    <Header />
    <main>
        <router-view />
    </main>
</template>
<script setup>
import { provide, reactive } from 'vue';
import Header from './mini-mall/components/Header.vue';

const cart = reactive([]);
const addCart = (product) => {
    cart.push(product);
};

provide('cart', cart);
provide('addCart', addCart)

</script>
<style>
    * {
        margin: 0;
        padding: 0;

        text-decoration: none;
        outline: none;
        color: inherit;
    }

    body {   
        width: 100%;
        height: 100%;
    }

    #app {
        width: calc(100% - 20rem);
        padding: 0 10rem;

        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .main-container {
        margin-top: 1.2rem;

        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 1rem;
    }
</style>