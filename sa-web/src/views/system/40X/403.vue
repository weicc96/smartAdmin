<!--
  * 403 无权限 页面
  * 
  * @Author:    weicc 
  * @Date:      2022-08-08 20:46:18
  * @Wechat:    wcchen96 
  * @Email:     15793730318@163.com 
-->
<template>
  <a-result status="404" title="对不起，您没有权限访问此内容">
    <template #extra>
      <a-button type="primary" @click="goHome">返回首页</a-button>
    </template>
  </a-result>
</template>
<script setup>
  import { useRouter } from 'vue-router';
  import { HOME_PAGE_NAME } from '/@/constants/system/home-const';

  function goHome() {
    useRouter().push({ name: HOME_PAGE_NAME });
  }
</script>
