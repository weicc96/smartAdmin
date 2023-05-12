/*
 * 权限
 *
 * @Author:    weicc
 * @Date:      2022-09-06 20:00:40
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */

import { useUserStore } from '/@/store/modules/system/user';
import lodash from 'lodash';

export function privilegeDirective(el, binding) {
  // 超级管理员
  if (useUserStore().administratorFlag) {
    return true;
  }
  // 获取功能点权限
  let userPointsList = useUserStore().getPointList;
  if (!userPointsList) {
    return false;
  }
  // 如果有权限，删除节点
  if (!lodash.some(userPointsList,['webPerms',binding.value])) {
    el.parentNode.removeChild(el);
  }
  return true;
}
