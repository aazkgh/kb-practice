<template>
<section class="main-container">
    <h2>상품 목록 페이지입니다.</h2>
    <div id="product-list-box">
        <div v-for="product in productsList" class="product-box" :key="product.id">
            <img class="product-img" :src=product.image />
            <span>{{ product.name }}</span>
            <span style="color: lightsteelblue;">{{ product.price }}</span>
            <router-link :to="{ name: 'productDetail', params: { id: product.id } }">상세 보기</router-link>
        </div>
    </div>
</section>
</template>
<script setup>
import { productsList } from '../data/products';
</script>
<style scoped>
#product-list-box {
    display: flex;
    flex-wrap: wrap;
    gap: 1rem;
}

.product-box {
    max-width: 12dvw;
    max-height: 16dvw;

    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 0.4rem;

    border: 1px solid lightgray;
    border-radius: 10px;
    padding: 0.6rem;
}

.product-img {
    width: 100%;
    object-fit: cover;
    overflow: hidden;
    border-radius: 8px;
}
</style>