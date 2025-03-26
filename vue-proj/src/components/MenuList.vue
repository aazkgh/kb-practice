<template>
  <main>
    <h2>메뉴 선택</h2>
    <button v-for="menu in menus" type="button" 
      class="menuTag"  @click="$emit('select-drink', menu.name)">
      {{ menu.name }} ({{ menu.price }}원)
    </button>
  </main>
</template>
<script setup lang="ts">
defineProps<{
  menus: Array<{ name: string; price: number }>
}>()
</script>
<style scoped>
.menuTag {
  margin: 5px;
  padding: 10px;
  cursor: pointer;
}
</style>
