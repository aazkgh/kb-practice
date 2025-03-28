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
    <OrderSummary v-if="selectedDrink && selectedOptions.size && selectedOptions.ice"
      :selectedMenu :selectedOptions @place-order="handlePlaceOrder"/>
    <OrderHistory :orders />
    <button type="button" id="staticBtn" v-show="orders.length > 0" @click="staticsOpen = !staticsOpen">
      {{ staticsOpen ? '통계 숨기기' : '통계 보기' }}
    </button>
    <Statics :orders="orders" v-if="staticsOpen" />  
  </main>
</template>
<script lang="ts">
import DrinkOptions, { type DrinkOptionType } from './cafe-components/DrinkOptions.vue';
import MenuList from './cafe-components/MenuList.vue';
import type { OrderType } from './cafe-components/OrderHistory.vue';
import OrderHistory from './cafe-components/OrderHistory.vue';
import OrderSummary from './cafe-components/OrderSummary.vue';
import Statics from './cafe-components/Statics.vue';

export default {
  name: 'AppCafe',
  data() {
    return {
      menuList : [
        { name: "아메리카노", price: 4000 },
        { name: "카페라떼", price: 4500 },
        { name: "바닐라라떼", price: 4800 },
        { name: "콜드브루", price: 5000 }
      ],
      selectedDrink: '',
      selectedOptions: <DrinkOptionType>{},
      orders: <OrderType[]>[],
      staticsOpen: false
    }
  },
  components: {
    MenuList,
    DrinkOptions,
    OrderSummary,
    OrderHistory,
    Statics
  },
  computed: {
  selectedMenu() {
      return this.menuList.find(menu => menu.name === this.selectedDrink) || {name: '', price: 0};
    }
  },
  methods: {
    handleSelectDrink(drinkName : string) {
      this.selectedDrink = drinkName;
    },
    handleOptionChange(options : DrinkOptionType){
      this.selectedOptions = options;
    },
    handlePlaceOrder(confirmed : boolean, time: string){
      if(confirmed){
        alert(`${this.selectedDrink} 주문이 완료되었습니다.`)
        const data = <OrderType>{
          time,
          drinkName: this.selectedMenu.name,
          size: this.selectedOptions.size,
          extraShot: this.selectedOptions.extraShot,
          ice: this.selectedOptions.ice,
          price: this.selectedMenu.price,
        }

        this.orders.push(data);

        this.selectedDrink = '';
        this.selectedOptions = { 
          size: '',
          extraShot: false,
          ice: 'normal'}
      }
    }
  },
}
</script>
<style>
  * {
    list-style: none;
  }
  body {
    margin: 0;
    padding: 2rem;
    background-color: white;
    color: black;
  }
  .selected {
    margin-top: 2rem;
    padding: 1rem;
    border: 1px solid #ddd;
    background-color: #f7f7f7;
  }
  #staticBtn {
    padding: 1rem 2rem;

    background-color: #8fbc8f;
    color: white;
    border-radius: 6px;
    border: none;
    outline: none;


    &:hover {
      background-color: #78a678;
    }
  }
</style>
