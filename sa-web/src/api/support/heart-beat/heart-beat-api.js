/*
 * 心跳
 *
 * @Author:    weicc
 * @Date:      2022-09-03 21:55:47
 * @Wechat:    wcchen96
 * @Email:     15793730318@163.com
 */
import { postRequest } from '/@/lib/axios';

export const heartBeatApi = {
  // 分页查询 @author 卓大
  queryList: (param) => {
    return postRequest('/support/heartBeat/query', param);
  },
};
