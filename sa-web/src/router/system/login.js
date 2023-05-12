/*
 * 登录页面
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:51:50
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */

export const loginRouters = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('/@/views/system/login/login.vue'),
    meta: {
      title: '登录',
      hideInMenu: true,
    },
  },
];
