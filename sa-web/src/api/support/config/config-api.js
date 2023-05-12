/*
 * 配置
 *
 * @Author:    卓大
 * @Date:      2022-09-03 21:51:54
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const configApi = {
  // 分页查询 @author 卓大
  queryList: (param) => {
    return postRequest('/support/config/query', param);
  },
  // 添加配置参数 @author 卓大
  addConfig: (param) => {
    return postRequest('/support/config/add', param);
  },
  // 修改配置参数 @author 卓大
  updateConfig: (param) => {
    return postRequest('/support/config/update', param);
  },
  // 查询配置详情 @author 卓大
  queryByKey: (param) => {
    return getRequest(`/support/config/queryByKey?configKey=${param}`);
  },
};
