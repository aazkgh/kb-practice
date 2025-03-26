<template>
  <main>
    <MenuList :menus=menuList @select-drink="handleSelectDrink" />
    <div v-if="selectedDrink" class="selected">
      <h4>선택한 음료: {{ selectedDrink }}</h4>
    </div>
    <DrinkOptions :selectedDrink />
  </main>
</template>
<script lang="ts">
import DrinkOptions from './components/DrinkOptions.vue';
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
    }
  },
  components: {
    MenuList
  },
  methods: {
    handleSelectDrink(drinkName : string) {
      this.selectedDrink = drinkName;
    },
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
    margin-top: 20px;
    padding: 10px;
    border: 1px solid #ddd;
    background-color: #f7f7f7;
  }
</style>
