<template>
    <section id="orderContainer">
        <h3>📋 주문 내역서</h3>
        주문 시간: {{ currTime }}
        <hr style="border:1px dotted #d2b48c">
        음료: {{ selectedMenu.name }} <br />
        사이즈: {{ selectedOptions.size }} <br />
        추가샷: {{ selectedOptions.extraShot ? '추가함' : '없음' }} <br />
        얼음 양: {{ selectedOptions.ice }} <br />
        <hr style="border:1px dotted #d2b48c">
        결제 금액: {{ selectedMenu.price.toLocaleString() }}
        <button type="button" @click="emitConfirm">주문 확정하기</button>
    </section>
</template>
<script setup lang="ts">
import { computed } from 'vue';
import type { DrinkOptionType } from './DrinkOptions.vue';
import type { MenuProps } from './MenuList.vue';

defineProps<{
    selectedMenu: MenuProps , 
    selectedOptions:DrinkOptionType
}>();

const currTime = computed(() => {
    const date = new Date();
    const hour = date.getHours() >= 12 ? '오후 ' + (date.getHours() - 12) : '오전 ' + date.getHours();

    return `${date.getFullYear()}. ${date.getMonth()}. ${date.getDate()}. ${hour}:${date.getMinutes()}:${date.getSeconds()}`
});

//emit 정의
const confirmEmits = defineEmits<{
    (e: 'place-order', confirmed: boolean) : void
}>();

//event 감지
const emitConfirm = () => {
    confirmEmits('place-order', true);
};
</script>
<style scoped>
    #orderContainer {
        padding: 0.4rem 1.2rem 1.2rem;
        margin: 2rem 0;

        background-color: #fffaf0;
        border: 1px solid #d2b48c;
        border-radius: 10px;
    }
</style>