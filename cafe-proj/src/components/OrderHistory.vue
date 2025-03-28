<template>
    <section id="historyContainer">
        <h4>🛒 주문 내역</h4>
        <div v-if="orders.length > 0">
            <ul>
                <li v-for="order in orders" :key="order.time">
                    ⏰ {{ order.time }} <br />
                    음료: {{ order.drinkName }} <br />
                    사이즈: {{ order.size }} <br />
                    추가샷: {{ order.extraShot ? '추가함' : '없음' }} <br />
                    얼음 양: {{ order.ice }} <br />
                    금액: {{ order.price.toLocaleString() }}
                    <hr style="border:1px dotted #d2b48c">
                </li>
            </ul>
        </div>
    <div v-else>
        주문 내역이 없습니다.
    </div>
    </section>
</template>
<script setup lang="ts">
export interface OrderType {
    time: string;
    drinkName: string;
    size: string;
    extraShot: boolean;
    ice: string;
    price: number;
}

defineProps<{ 
    orders: OrderType[] 
}>()

</script>
<style scoped>
    #historyContainer {
        padding: 0.4rem 1.2rem 1.2rem;
        margin: 2rem 0;

        background-color: #fffaf0;
        border: 1px solid #d2b48c;
        border-radius: 10px;
    }
</style>