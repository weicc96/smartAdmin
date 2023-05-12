/*
 * 操作日志
 *
 * @Author:    weicc
 * @Date:      2022-09-03 21:56:45
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const operateLogApi = {
  // 分页查询 @author 卓大
  queryList: (param) => {
    return postRequest('/support/operateLog/page/query', param);
  },
  // 详情 @author 卓大
  detail: (id) => {
    return getRequest(`/support/operateLog/detail/${id}`);
  },
};
