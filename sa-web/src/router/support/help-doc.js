/*
 * 帮助文档
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:53:19
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import SmartHelpDocLayout from '/@/layout/smart-help-doc-layout.vue';

export const helpDocRouters = [
  {
    path: '/help-doc',
    name: 'HelpDoc',
    component: SmartHelpDocLayout,
    meta: {
      title: '帮助文档',
      hideInMenu: true,
    },
    children: [
      {
        path: '/help-doc/detail',
        component: () => import('/@/views/support/help-doc/user-view/help-doc-user-view.vue'),
      },
    ],
  },
];
