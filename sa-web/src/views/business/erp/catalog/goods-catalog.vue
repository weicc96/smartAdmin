<!--
  * 目录  商品
  * 
  * @Author:    weicc 
  * @Date:      2022-08-21 19:52:43 
  * @Wechat:    wcchen96 
  * @Email:     15793730318@163.com 
-->
<template>
  <div>
    <CategoryTreeTable :category-type="CATEGORY_TYPE_ENUM.GOODS.value" />
  </div>
</template>
<script setup>
  import CategoryTreeTable from './components/category-tree-table.vue';
  import { CATEGORY_TYPE_ENUM } from '/@/constants/business/erp/category-const';
</script>
