/*
 * 登录日志
 *
 * @Author:    weicc
 * @Date:      2022-09-03 21:56:31
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const loginLogApi = {
  // 分页查询 @author 卓大
  queryList: (param) => {
    return postRequest('/support/loginLog/page/query', param);
  },
};
