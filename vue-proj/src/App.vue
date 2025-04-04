<template>
    <Header />
    <main>
        <router-view />
    </main>
</template>
<script setup>
import Header from './mini-mall/components/Header.vue';
</script>
<style>
    * {
        margin: 0;
        padding: 0;

        text-decoration: none;
        color: inherit;
    }
    html {
        width: 100dvw;
        height: 100dvh;
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
</style>