<template>
  <main>
    <MenuList :menus=menuList @select-drink="handleSelectDrink" />
    <div v-if="selectedDrink" class="selected">
      <h4>선택한 음료: {{ selectedDrink }}</h4>
    </div>
    <DrinkOptions v-if="selectedDrink" :selectedDrink @options-changed="handleOptionChange"/>
    <div v-if="selectedOptions.size && selectedOptions.ice" class="selected">
      <h4>선택한 옵션:</h4>
        <br /> 사이즈: {{ selectedOptions.size }}
        <br /> 추가샷: {{ selectedOptions.extraShot ? '있음' : '없음' }}
        <br /> 얼음 양: {{ selectedOptions.ice }}
    </div>

  </main>
</template>
<script lang="ts">
import DrinkOptions, { type DrinkOptionType } from './components/DrinkOptions.vue';
import MenuList from './components/MenuList.vue';

export default {
  name: 'App',
  data() {
    return {
      menuList : [
        { name: "아메리카노", price: 4000 },
        { name: "카페라떼", price: 4500 },
        { name: "바닐라라떼", price: 4800 },
        { name: "콜드브루", price: 5000 }
      ],
      selectedDrink: '',
      selectedOptions: <DrinkOptionType>({})
    }
  },
  components: {
    MenuList,
    DrinkOptions
  },
  methods: {
    handleSelectDrink(drinkName : string) {
      this.selectedDrink = drinkName;
    },
    handleOptionChange(options: DrinkOptionType){
      this.selectedOptions = options;
    }
  },
}
</script>
<style scoped>
  body {
    margin: 0;
    background-color: white;
    color: black;
  }
  .selected {
    margin-top: 2rem;
    padding: 1rem;
    border: 1px solid #ddd;
    background-color: #f7f7f7;
  }
</style>
