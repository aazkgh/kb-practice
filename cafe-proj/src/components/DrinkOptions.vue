<template>
    <section id="chooseOption">
        <h2>{{ selectedDrink }} 옵션 선택</h2>
        <div>
            사이즈: 
            <input type="radio" name="size" value="Small" v-model="drinkOptions.size" @change="emitOptions">Small
            <input type="radio" name="size" value="Medium" v-model="drinkOptions.size" @change="emitOptions" checked>Medium
            <input type="radio" name="size" value="Large" v-model="drinkOptions.size" @change="emitOptions">Large
        </div>
        <div>
            <input type="checkbox" v-model="drinkOptions.extraShot" @change="emitOptions">샷 추가
        </div>
        <div>
            얼음 양: 
            <select v-model="drinkOptions.ice" @change="emitOptions">
                <option value="less">적게</option>
                <option value="normal">보통</option>
                <option value="more">많이</option>
            </select>
        </div>
    </section>
</template>
<script setup lang="ts">
import { reactive } from 'vue';

defineProps<{
    selectedDrink: string
}>()

export interface DrinkOptionType {
    size: string;
    extraShot: boolean;
    ice: string;
}

const drinkOptions = reactive<DrinkOptionType>({
    size: 'Medium',
    extraShot: false,
    ice: 'normal'
});

//emit 정의
const optionEmits = defineEmits<{
    (e: 'options-changed', options: DrinkOptionType) : void
}>();

//event 감지
const emitOptions = () => {
    optionEmits('options-changed', drinkOptions);
};

</script>
<style scoped>
    #chooseOption {
        padding: 0.4rem 1.2rem 1.2rem;
        margin: 2rem 0;

        display: flex;
        flex-direction: column;
        gap: 1.2rem;

        background-color: lavenderblush;
    }
</style>