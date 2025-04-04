<template>
<div v-if="product" class="product-detail">
    <h2>{{ product.name }}</h2>
    <img :src="product.image" alt="" class="product-image" />
    <p class="price">가격: {{ product.price.toLocaleString() }}원</p>
    <button type="button" @click="addBtnHandler">장바구니 담기</button>
</div>
<div v-else>
    <p>존재하지 않는 상품입니다.</p>
</div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { productsList } from "../data/products";
import { computed, inject } from "vue";

const route = useRoute();
const router = useRouter();
const id = Number(route.params.id);
const product = computed(() => productsList.find((p) => p.id === id));

const addCart = inject('addCart');
const addBtnHandler = () => {
    addCart(product.value);
    router.push({name: 'cart'});
}
</script>

<style scoped>
.product-detail {
text-align: center;
padding: 40px 20px;
}

.product-image {
max-width: 300px;
width: 100%;
height: auto;
margin: 20px 0;
border-radius: 8px;
box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
}

.price {
font-size: 20px;
color: #444;
margin-top: 10px;
}
</style>
