<template>
    <nav id="nav">
        <router-link to="/" class="link">홈</router-link>
        <router-link to="/products" class="link">상품 목록</router-link>
        <router-link to="/cart" class="link">장바구니</router-link>
    </nav>
</template>
<script setup>
</script>
<style scoped>
    #nav {
        width: 100%;
        padding: 1.2rem;

        display: flex;
        justify-content: space-around;

        background-color: lightsteelblue;
        color:whitesmoke;
        font-size: 1.2rem;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    .link {
        width: 8rem;

        text-align: center;
        &:hover {
            text-decoration-line: underline;
        }
    }
    .router-link-active {
        font-weight: 600;
        color: white;
    }
</style>