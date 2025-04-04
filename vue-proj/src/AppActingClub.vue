<template>
    <main id="mainContainer">
        <LineReadyButton @ready="handleReady" />
        <p id="slot"><i>{{ cheerUp }}</i></p>
    </main>
</template>
<script setup lang="ts">
import { ref } from 'vue';
import LineReadyButton from './acting-club-components/LineReadyButton.vue';

const cheerUp = ref('여기에 동아리 회장의 코멘트가 들어갑니다.')
const slotData = [
    '기죽지마라. 나빼고 다 X밥이다.',
    '아쉬우면 나만 손해 ~',
    '노력은 배신하지 않는다',
    '오늘만큼은 내가 주인공',
    '와 찢었다.. - 1시간 뒤의 나',
    '이거 끝나면 침대에 누울 수 있어!',
    '어차피 틀려도 관객들은 모른다.',
    '자신감! 자신감! 자신감! 자신감여자'
];

const handleReady = () => {
    const random = Math.round(Math.random() * (slotData.length - 1))
    cheerUp.value = slotData[random]
}

</script>
<style>
    body {
        padding: 0;
        margin: 0;

        height: 100dvh;
        width: 100dvw;
    }
    button {
        background-color: inherit;
        border: none;
        outline: none;
        cursor: pointer;
    }

    #mainContainer {
        padding: 2rem;

        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 3.2rem;
    }
    #slot {
        padding: 1.4rem;
        max-width: 40rem;

        background-color: #f1f2f6;
        border: 1px solid #dfe4ea;
        border-radius: 8px;
    }
</style>
