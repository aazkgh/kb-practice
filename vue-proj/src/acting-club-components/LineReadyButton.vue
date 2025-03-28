<template>
    <section class="btnContainer">
        <button type="button" id="readyBtn" @click="emitReady">
            📽 대사 준비 완료
        </button>
        <br />
        버튼을 누른 횟수: {{ count }}회 
    </section>
</template>
<script setup lang="ts">
import { ref } from 'vue';

const count = ref(0);

const readyEmits = defineEmits<{
    (e: 'ready') : void
}>();

const emitReady = () => {
    count.value++
    readyEmits('ready');
};
</script>
<style>
    .btnContainer {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    #readyBtn {
        height: 5rem;
        width: 12rem;

        background-color: #ff7675;
        color: white;
        border-radius: 12px;
        text-align: center;
        font-size: large;

        &:hover {
            background-color: #d63031;
        }
    }
</style>