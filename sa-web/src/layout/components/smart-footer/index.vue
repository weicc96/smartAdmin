<!--
  * 底部：版权、公司等信息
  * 
  * @Author:    weicc 
  * @Date:      2022-09-06 20:29:12 
  * @Wechat:    wcchen96 
  * @Email:     15793730318@163.com 
-->
<template>
  <div class="version" >
    <a target="_blank" href="https://www.1024lab.net">
      SmartAdmin V2.x @copyright 河南·洛阳【1024创新实验室】 Since 2012-{{ currentYear }}
    </a>
  </div>
</template>
<script setup>
  import dayjs from 'dayjs';

  const currentYear = dayjs().year();
</script>

<style lang="less" scoped>
  .version {
    font-size: 14px;
    color: rgba(0, 0, 0, 0.45);
    a {
      color: rgba(0, 0, 0, 0.45);
    }
    a:hover {
      color: @primary-color;
    }
  }
</style>
