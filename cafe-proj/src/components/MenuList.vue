<template>
  <section>
    <h2>메뉴 선택</h2>
    <button v-for="menu in menus" type="button" 
      class="menuTag"  @click="$emit('select-drink', menu.name)">
      {{ menu.name }} ({{ menu.price }}원)
    </button>
  </section>
</template>
<script setup lang="ts">
export interface MenuProps {
  name: string,
  price: number
}

defineProps<{
  menus: Array<MenuProps>
}>()
</script>
<style scoped>
.menuTag {
  margin: 5px;
  padding: 10px;
  cursor: pointer;
}
</style>
