<template>
    <section id="orderStatics">
        <h3>📊 주문 통계</h3>
        총 주문 횟수: {{ orders.length }}회 <br />
        총 매출: {{ sales }}원<br />
        가장 인기 있는 음료: 
        <span v-for="([name, _], idx) in popularDrink" :key="name">
            {{ name }}<span v-if="idx < popularDrink.length - 1">, </span>
        </span>  ({{ popularDrink[0][1] }}회)<br />
        가장 많이 선택된 사이즈: 
        <span v-for="(size, idx) in popularSize" :key="size">
            {{ size }}<span v-if="idx < popularSize.length - 1">, </span>
        </span><br />        
        추가 샷 비율: {{ shotRatio }}%<br />
    </section>
</template>
<script setup lang="ts">
import { computed } from 'vue';

export interface OrderType {
    time: string;
    drinkName: string;
    size: string;
    extraShot: boolean;
    ice: string;
    price: number;
}

const { orders } = defineProps<{
    orders : OrderType[]
}>();

const sales = computed(() => {
    return orders.reduce((sum: number, curr: OrderType) => { 
        return sum += curr.price }, 0).toLocaleString();
});

const popularDrink = computed(() => {
    const drinkCount = new Map();
    orders.forEach((val) => {
        const name = val.drinkName;
        drinkCount.set(name, drinkCount.get(name) + 1 || 1)
    });

    const sorted = [...drinkCount.entries()].sort((a, b) => b[1] - a[1]);
    const maxCount = sorted[0]?.[1];
    const mostFrequent = sorted.filter(([_, count]) => count === maxCount);
    return mostFrequent;
});

const popularSize = computed(() => {
    const sizeCount = new Map();
    orders.forEach((val) => {
        const name = val.size;
        sizeCount.set(name, sizeCount.get(name) + 1 || 1)
    });

    const sorted = [...sizeCount.entries()].sort((a, b) => b[1] - a[1]);
    const maxCount = sorted[0]?.[1];
    const mostFrequent = sorted.filter(([_, count]) => count === maxCount)
    .map((val) => { return val[0]} );

    return mostFrequent;
});

const shotRatio = computed(() => {
    const shots = orders.reduce((sum: number, curr: OrderType) => { 
        return curr.extraShot ? sum + 1 : sum }, 0);
    return (shots / orders.length).toFixed(2);
});
</script>
<style>
    #orderStatics {
        padding: 0.4rem 1.2rem 1.2rem;
        margin: 2rem 0;

        background-color: #e6ffe6;
        border: 1px solid #8fbc8f;
        border-radius: 10px;
    }    
</style>