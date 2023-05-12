<!--
  * 目录  demo
  *
  * @Author:    weicc
  * @Date:      2022-08-21 19:52:43
  * @Wechat:    wcchen96
  * @Email:     15793730318@163.com
  * @Copyright  1024创新实验室 （ https://1024lab.net ），Since 2012
-->
<template>
  <div>
    <CategoryTreeTable :category-type="CATEGORY_TYPE_ENUM.DEMO.value" :privilegePrefix="'custom'"/>
  </div>
</template>
<script setup>
  import CategoryTreeTable from './components/category-tree-table.vue';
  import { CATEGORY_TYPE_ENUM } from '/@/constants/business/erp/category-const';
</script>
