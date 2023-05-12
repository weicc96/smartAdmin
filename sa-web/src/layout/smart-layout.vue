<!--
  *  layout 多种模式
  * 
  * @Author:    weicc 
  * @Date:      2022-09-06 20:40:16 
  * @Wechat:    wcchen96 
  * @Email:     15793730318@163.com 
-->
<template>
  <!--左侧菜单 模式-->
  <SmartSideLayout v-if="layout === LAYOUT_ENUM.SIDE.value" />
  <!--左侧展开菜单 模式-->
  <SmartSideExpandLayout v-if="layout === LAYOUT_ENUM.SIDE_EXPAND.value" />
</template>
<script setup>
  import { computed } from 'vue';
  import SmartSideExpandLayout from './smart-side-expand-layout.vue';
  import { LAYOUT_ENUM } from '/@/constants/layout-const';
  import SmartSideLayout from '/@/layout/smart-side-layout.vue';
  import { useAppConfigStore } from '/@/store/modules/system/app-config';

  const layout = computed(() => useAppConfigStore().$state.layout);
</script>
