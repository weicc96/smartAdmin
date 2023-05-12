/*
 * 角色菜单
 *
 * @Author:    weicc
 * @Date:      2022-09-03 22:00:49
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { getRequest, postRequest } from '/@/lib/axios';
export const roleMenuApi = {
  /**
   * @description: 获取角色关联菜单权限
   * @param {*}
   * @return {*}
   */
  getRoleSelectedMenu: (roleId) => {
    return getRequest(`role/menu/getRoleSelectedMenu/${roleId}`);
  },
  /**
   * @description: 更新角色权限
   * @param {*}
   * @return {*}
   */
  updateRoleMenu: (data) => {
    return postRequest('role/menu/updateRoleMenu', data);
  },
};
